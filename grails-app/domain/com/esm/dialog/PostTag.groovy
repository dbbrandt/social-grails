package com.esm.dialog;

import com.esm.esmzone.Points;
import com.esm.esmzone.User;
import com.esm.esmzone.PointsType;

class PostTag {
	
	Date dateCreated
	Date lastUpdated
	
	static searchable = true
	
	static belongsTo = Post 
	
	Post post
	User user
	Tag tag
	
	Points pointsDetail = null
	static transients = [ 'pointsDetail']
	
	static constraints = {
		post nullable:false
		user nullable:false
		tag nullable:false,unique:'post'  	
	}
	
	def beforeInsert = {
		this.pointsDetail = user.addPoints(PointsType.lookup("QuestionTag"))
		
	}

	def afterInsert = {
		if (this.pointsDetail) {
			this.pointsDetail.contentId = this.id
			this.pointsDetail.save()
		}
	}

	String toString(){ 
		return tag
	}
	
}
