package com.esm.survey;

class Response {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = Question

	Question question
	String responseText
	Boolean correct = false
	
	static constraints = {
		question nullable:false
		responseText blank:false, nullable:false
		correct nullable:false
	}

	String toString(){ 
		return "$responseText - $correct" ;
	}
}
