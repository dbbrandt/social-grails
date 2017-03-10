package com.esm.dialog

import java.math.BigDecimal;

import com.esm.esmzone.Points;
import com.esm.esmzone.User
import com.esm.esmzone.PointsType

class AnswerRating {
	
	static BigDecimal increment = 1.66
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = Answer
	
	Answer answer
	User user
	BigDecimal score = increment
	
	BigDecimal oldScore
	Points pointsDetail = null
	static transients = ['oldScore', 'pointsDetail']
                     
	static constraints = {
		score nullable:false 
	}

	def beforeInsert = {
		answer.addRating(this)
		this.pointsDetail = user.addPoints(PointsType.lookup("AnswerRating"))
	}
	
	def beforeUpdate = {
		answer.updateRating(this)
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
