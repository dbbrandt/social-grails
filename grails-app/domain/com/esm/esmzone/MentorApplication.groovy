package com.esm.esmzone;

import com.esm.survey.*

class MentorApplication {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = User
	
	User mentor
	ApplicationStatus status = ApplicationStatus.STARTED
	MentorQuiz quiz
	Boolean mentorWaiver = false
	
	Points pointsDetail = null
	static transients = ['pointsDetail']

	
	static hasMany = [references:Reference]
	
	static constraints = {
		status nullable:false
		mentorWaiver nullable:false
		quiz nullable:true
	}

	String toString(){ 
		return "$mentor" ;
	}

	def beforeUpdate = {
		if (this.status == ApplicationStatus.ACCEPTED) {
			def type = "MentorCertified"
			this.pointsDetail = mentor.addPoints(PointsType.lookup(type))
		}
	}
	
	def afterUpdate = {
		if (this.status == ApplicationStatus.ACCEPTED) {
			this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}
	
}
enum ApplicationStatus {
	STARTED,QUIZ,REFERENCES,RESPONSES,REJECTED,ACCEPTED,SUSPENDED,FULL
}
