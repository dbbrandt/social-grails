package com.esm.dialog

import com.esm.esmzone.*

class Post  implements Comparable {
	
	static searchable = true

	static BigInteger questionPoints = 100
	static BigDecimal defaultRating = 1.0
	static BigDecimal starRatingFactor = 3.48
	
	
	Date dateCreated
	Date lastUpdated
	
	User author
	User member
	String title
	String description
	PostType postType
	SortedSet answers
	Answer bestAnswer
	Complaint complaint
	
	
	BigDecimal score = questionPoints * defaultRating
	BigDecimal averageRating = defaultRating 
	BigInteger ratingCount = 0
	BigDecimal answerScore = 0
	BigInteger answerCount = 0
	BigDecimal overallRating = defaultRating
	
	BigDecimal myRating
	Points pointsDetail = null
	
	static transients = [ 'myRating', 'pointsDetail']

	static hasMany = [tags:PostTag, 
	                  answers:Answer, 
	                  comments:PostComment, 
	                  ratings:PostRating]

	static constraints = {
		title blank:false, nullable:false, size:1..400
		member nullable:true
		complaint nullable:true
		description blank:true,nullable:true
		bestAnswer nullable:true
	}

    static mapping = {
		comments sort: 'id'
		complaint lazy:false
    }

	def beforeInsert = {
		def type = "Post"
		if (postType.name == PostTypeName.QUESTION) {
			type = "Question"
		}
		this.pointsDetail = author.addPoints(PointsType.lookup(type))
	}

	def afterInsert = {
		if (this.pointsDetail) {
			this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}

	String toString(){ 
		def max = (title.size() < 100)?title.size()-1:99
		return title[0..max];
	}

	public static List shoutOuts(rows) {
		def postInstanceList =  Post.createCriteria().list() {
			maxResults(rows)
			postType {
				eq('name', PostTypeName.SOCIAL)
				eq('audience', PostTypeAudience.PUBLIC)
			}
			order('dateCreated', 'desc')
		}
	}
	
	public static List shoutOuts(rows, userId) {
		def user = User.get(userId)
		def postInstanceList =  Post.createCriteria().list() {
			maxResults(rows)
			postType {
				eq('name', PostTypeName.SOCIAL)
				eq('audience', PostTypeAudience.PUBLIC)
			}
			eq('author',user)
			order('dateCreated', 'desc')
		}
	}
	
	Integer starRating() {
		return Math.round((averageRating * 4) - starRatingFactor) 
	}

	Boolean isEditable(user) {
		if (author == user ) {
			return true
		}
		return false
		
	}
	
	User getFan(requestor) {
		if (author == requestor) {
			return member
		}
		else {
			return author
		}
	}
	
	Answer topAnswer() {
		def topAnswer
		if (answers?.size() > 0) {
			answers.each { answerInstance ->
		        if (!answerInstance.complaint && !topAnswer) { 
						topAnswer = answerInstance
				}
			}
		}
		return topAnswer
	}
	
	Integer countAnswers() {
		def validAnswers = 0
 		if (answers?.size() > 0) {
			answers.each { answerInstance ->
				if (!answerInstance.complaint) { 
					validAnswers++
				}
			}
			if (this.answerCount != validAnswers) {
				this.answerCount = validAnswers
				this.save()
			}
		}
		return validAnswers
	}
	
	Integer myRating(user) {
		if (this.myRating) {
			return this.myRating
		}
		def c = PostRating.createCriteria()
		def postRatingList = c {
			eq('user',user)
			eq('post', this)
		}
		if (postRatingList) {
			def postRating = PostRating.get(postRatingList.toArray()[0].id)
			myRating = postRating.score
		}
		return this.myRating
	}
	
	String ratingImage(user) {
		if (!this.myRating) {
			this.myRating(user)
		}
		def rating = myRating?myRating:0
		def imageFile
		if (user == author) {
			return null
		}
		else {
			imageFile = "like-"
		}
		if ((rating > 1) && (rating <= 1.66)) {
			return imageFile+"1"
		}
		else if ((rating > 1.66) && (rating <= 3.32)) {
			return imageFile+"2"
		}
		else if (rating > 3.32) {
			return imageFile+"3"
		}
		return imageFile+"0"
	}
	
	String ratingText(user) {
		if (!this.myRating) {
			this.myRating(user)
		}
		def rating = myRating?myRating:0
		if (user == author) {
			return null
		}
		if ((rating > 1) && (rating <= 1.66)) {
			return "This is alright"
		}
		else if ((rating > 1.66) && (rating <= 3.32)) {
			return "I like it"
		}
		else if (rating > 3.32) {
			return "This is awsome"
		}
		return "Like this question?"
	}
	
	BigDecimal ratingValue() {
		BigDecimal rating = this.averageRating
		if (rating == 1) {
			rating = 0.0
		}
		else {
			// 5 point rating to 3 thumbs up rating
			rating = rating * 3 / 5
			rating = Math.round(100*rating)/100
		}
		return rating 
	}
	
	
	synchronized BigDecimal addRating(rating) {
		if (rating) {
			def ratingSum = averageRating * ratingCount
			ratingCount++
			ratingSum += rating.score
			this.averageRating = ratingSum / ratingCount
			this.score()
			author.addRating(rating)
		}
		return averageRating
	}
	
	synchronized BigDecimal updateRating(rating) {
		if (rating) {
			def ratingSum = averageRating * ratingCount
			ratingSum -= rating.oldScore
			ratingSum += rating.score
			this.averageRating = ratingSum / ratingCount
			this.score()
			author.updateRating(rating)
		}
		return averageRating
	}
		
	private BigDecimal answerScore() {
		if (answers) {
			this.answerCount = this.countAnswers()
			this.answerScore = answers.sum {it.score}
			//calculate the overall rate (the average of all question and answer ratings 
		}
		return answerScore
	}
	
	 void score() {
		this.score = (averageRating * questionPoints) + answerScore()

		def answerRatingSum = 0
		def answerRatingCount = 0
		if (answers) {
			answerRatingSum = answers.sum {it.averageRating * it.ratingCount }
			answerRatingCount = answers.sum {it.ratingCount }
		}
		def questionRatingSum = this.averageRating * this.ratingCount
		if (answerRatingCount + this.ratingCount > 0) {
			this.overallRating = (questionRatingSum + answerRatingSum ) / (answerRatingCount + this.ratingCount)
		}
		this.save()
	}
	
	
	
	List displayTags(maxLength=30,sort="name") {
		List tagList = []
		Integer maxTagListLength =  (maxLength>0)?maxLength:100
		Integer tagListLength = 0
		this.tags.each { postTag ->
			tagListLength += postTag.tag.name.length() + 1
			if (tagListLength < maxTagListLength) {
				tagList.add(postTag.tag)
			}
		}
		tagList.sort{it."$sort"}
		return tagList
	}
	
	Integer starRating(rating) {
		return Math.round((rating * 4) - User.starRatingFactor) 
	}
	
	int compareTo(obj) {
		def comp = score.compareTo(obj.score)
		if (!comp) {
			return dateCreated?.compareTo(obj.dateCreated)
		}
		return comp
	}
	
	
	
}
