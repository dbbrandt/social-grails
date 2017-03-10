package com.esm.survey;

class Survey {
	
	Date dateCreated
	Date lastUpdated
	
	String title
	
	static hasMany = [ questions:Question ]
	
	static constraints = {
		title blank:false, nullable:false
	}
	/*
	 * The method will a random questions to the survey
	 */
	Boolean generateSurvey(Integer questionCount, QuestionType type = QuestionType.MENTOR) {
		if (((questionCount < 1) || Question.count() < questionCount)) {
			return false
		}
		(1..questionCount).each {
			this.addRandomQuestion(type)
		}
		return true
		
	}
	/*
	 * The method will add a random question to the survey making sure
	 * that the question is unique (not already in the survey)
	 */
	Question addRandomQuestion(type) {
		def random = new Random()
		def questionCount = Question.count()
		def questionList = Question.list()
		def next = random.nextInt(questionCount)
		def question = questionList.get(next)
		while ((question in questions) || (question.type != type)) {
			next = random.nextInt(questionCount)
			question = questionList.get(next)
		}
		this.addToQuestions(question)
		return question
	}
	
	String toString(){ 
		return "$title" ;
	}
}
