package com.esm.esmzone;

class SecurityQuestion {
	
	Date dateCreated
	Date lastUpdated
	
	String name
	String question
	
	static constraints = {
		name blank:false, nullable:false,unique:true
	}

	String toString(){ 
		return question;
	}
	
}
