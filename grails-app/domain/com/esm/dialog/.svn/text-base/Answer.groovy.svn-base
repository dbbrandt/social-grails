package com.esm.dialog;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.esm.esmzone.Points;
import com.esm.esmzone.User;
import com.esm.esmzone.PointsType;

class Answer implements Comparable{
	
	static searchable = true
	
	static BigInteger answerPoints = 10
	static BigDecimal defaultRating = 1.0
	static BigDecimal starRatingFactor = 3.48
		
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = Post

	Post post
	User author
	String description
	Complaint complaint
			
	BigDecimal score = answerPoints * defaultRating
	BigDecimal averageRating = defaultRating
	BigInteger ratingCount = 0
	
	BigDecimal myRating = 0
	Points pointsDetail = null
	
	static transients = [ 'myRating', 'pointsDetail']
	
	static hasMany = [ comments:AnswerComment, 
	                   ratings:AnswerRating]
	
	static constraints = {
		description blank:false,nullable:false,size:1..2000
		complaint nullable:true
	}

    static mapping = {
		comments sort: 'id'
    }

	def beforeInsert = {
		this.pointsDetail = author.addPoints(PointsType.lookup("Answer"))
	}

	def afterInsert = {
		if (this.pointsDetail) {
			this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}

	String toString(){
		def max = (description.size() < 251)?description.size()-1:250
		def ellipses = (description.size() > 250)?"...":""
		return description[0..max] + ellipses
	}

	Integer starRating() {
		return Math.round((averageRating * 4) - starRatingFactor) 
	}

	Integer myRating(user) {
		if (this.myRating) {
			return this.myRating
		}
		def c = AnswerRating.createCriteria()
		def answerRatingList = c {
			eq('user',user)
			eq('answer', this)
		}
		if (answerRatingList) {
			def answerRating = AnswerRating.get(answerRatingList.toArray()[0].id)
			this.myRating = answerRating.score
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
		return "Like this answer?"
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
			post.score()
		}
		author.addRating(rating)
		return averageRating
	}
	
	synchronized BigDecimal updateRating(rating) {
		if (rating) {
			def ratingSum = averageRating * ratingCount
			ratingSum -= rating.oldScore
			ratingSum += rating.score
			averageRating = ratingSum / ratingCount
			this.score()
			post.score()
		}
		author.updateRating(rating)
		return averageRating
	}
	
	private void score() {
		score = averageRating * answerPoints
		this.save()
	}
	
	Integer starRating(rating) {
		return Math.round((rating * 4) - User.starRatingFactor) 
	}
	
	// Order by average score descending with dateCreated as tiebreaker
	int compareTo(obj) {
		def comp = score.compareTo(obj.score)
		if ((comp == 0) && obj.dateCreated && this.dateCreated) {
			comp = dateCreated?.compareTo(obj.dateCreated)
		}
		return -comp
	}
}
