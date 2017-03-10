package com.esm.dialog

import com.esm.esmzone.Points;
import com.esm.esmzone.User
import com.esm.esmzone.PointsType

class AnswerComment {
	
	static searchable = true
	
	Date dateCreated
	Date lastUpdated
	
	Points pointsDetail = null
	static transients = [ 'pointsDetail']
	
	static belongsTo = Answer

	Answer answer
	User author
	String description
	Complaint complaint
	
	static constraints = {
		answer nullable:false
		author nullable:false
		complaint nullable:true
		description blank:false,nullable:false,size:10..250
	}
	
	def beforeInsert = {
		this.pointsDetail = author.addPoints(PointsType.lookup("AnswerComment"))
	}

	def afterInsert = {
		if (this.pointsDetail) {
			this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}


	String toString(){ 
		return description;
	}
}
