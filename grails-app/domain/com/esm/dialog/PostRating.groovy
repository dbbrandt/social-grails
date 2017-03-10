package com.esm.dialog

import com.esm.esmzone.Points;
import com.esm.esmzone.User
import com.esm.esmzone.PointsType

class PostRating {
	
	static BigDecimal increment = 1.66
	Date dateCreated
	Date lastUpdated
		
	static belongsTo = Post
	
	Post post
	User user
	BigDecimal score = increment
	
	BigDecimal oldScore
	Points pointsDetail = null

	static transients = ['oldScore', 'pointsDetail']
	
	static constraints = {
		score nullable:false
	}

	def beforeInsert = {
		post.addRating(this)
		if (post.postType.name == PostTypeName.QUESTION) {
			this.pointsDetail = user.addPoints(PointsType.lookup("QuestionRating"))
		}
		else {
			this.pointsDetail = user.addPoints(PointsType.lookup("PostRating"))
		}
	}

	def beforeUpdate = {
		post.updateRating(this)
	}
	
	def afterInsert = {
		if (this.pointsDetail) {
	 		this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}
	
	def incrementRating() {
		this.oldScore = this.score
		this.score += increment
		if (this.score > 5) {
		  this.score = increment	
		}
	}
	
	String toString(){ 
		return score;
	}
}
