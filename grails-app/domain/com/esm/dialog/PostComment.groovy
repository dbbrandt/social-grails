package com.esm.dialog

import com.esm.esmzone.Points;
import com.esm.esmzone.User
import com.esm.esmzone.PointsType


class PostComment {
	
	static searchable = true
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = Post

	Post post
	User author
	String description
	Complaint complaint
	
	Points pointsDetail = null
	static transients = [ 'pointsDetail']

	static constraints = {
		post nullable:false
		author nullable:false
		description blank:false,nullable:false,size:1..250
		complaint nullable:true
	}
	
	def beforeInsert = {
		if (post.postType.name == PostTypeName.QUESTION) {
			this.pointsDetail = author.addPoints(PointsType.lookup("QuestionComment"))
		}
		else {
			this.pointsDetail = author.addPoints(PointsType.lookup("PostComment"))
		}
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
