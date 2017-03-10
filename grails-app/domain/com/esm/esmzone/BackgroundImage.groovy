package com.esm.esmzone;

class BackgroundImage {
	Date dateCreated
	Date lastUpdated
	
	String name
	String filename
	
	static constraints = {
		name blank:false, nullable:false, unique:true
		filename blank:true, nullable:true
	}
	
	String toString(){ 
		return name 
	}
	
}
