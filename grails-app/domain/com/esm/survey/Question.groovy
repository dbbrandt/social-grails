package com.esm.survey;

class Question {
	Date dateCreated
	Date lastUpdated
	
	String title
	String questionText
	QuestionType type = QuestionType.MENTOR
	
	static hasMany = [ responses:Response ]
	
	static constraints = {
		title blank:false, nullable:false
		questionText blank:false, nullable:false
		responses validator: {val, obj ->
			if (!val?.size()) {
				return false
			}
		}
		
	}
	
	String toString(){ 
		return "$questionText" ;
	}
}
enum QuestionType {
	MENTOR, PROMOTION
}
