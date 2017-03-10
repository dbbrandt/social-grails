package com.esm.dialog

import com.esm.esmzone.PointsType
import com.esm.esmzone.User
import com.esm.esmzone.PointsType


class Tag {
	Date dateCreated
	Date lastUpdated
	
	static searchable = true

	static belongsTo = {user:User}

	User user
	String name
	Integer postCount = 0
	Boolean isLeafTag = false
	
	static constraints = {
		name blank:false, nullable:false,unique:true, size:1..20
	}
	
	def beforeInsert = {
		user.addPoints(PointsType.lookup("Tag"))
	}

	synchronized Integer incrementPostCount() {
		this.postCount++
		this.save()
	}
	
	String toString(){ 
		return name;
	}
	
}
