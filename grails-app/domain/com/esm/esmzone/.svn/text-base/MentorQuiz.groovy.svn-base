package com.esm.esmzone;

import com.esm.survey.*;

class MentorQuiz {
	
	static surveySize = 10
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [application: MentorApplication]
	
	Survey survey
	Boolean passed = false
	
	static hasMany = [responses: Response]
	
	static constraints = {
		survey nullable:false
		passed nullable:false
	}
	
	Boolean checkQuiz() {
		def correctResponses = 0
		responses.each { 
			if (it.correct) {
				correctResponses++ 
			}
		}
		BigDecimal score = (correctResponses / survey?.questions?.size()) * 100
		if (score >= 80.0) {
			passed = true
		}
		return passed
	}
	String toString(){ 
		return "$survey" ;
	}
		
}
