package com.esm.esmzone;

class Avatar {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = User
	
	User user
	String name
	String filename
	String nobleAvatar
	
	static constraints = {
		name blank:false, nullable:false, unique:true
		filename blank:true, nullable:true
		nobleAvatar blank:true, nullable:true
	}

	String toString(){ 
		return name 
	}
	
}
