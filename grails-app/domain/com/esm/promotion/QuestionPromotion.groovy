package com.esm.promotion

import com.esm.survey.QuestionType;
import com.esm.survey.Survey
import com.esm.survey.Question
import com.esm.survey.Response

class QuestionPromotion {

    Date dateCreated
    Date lastUpdated

    String name
    String description
    Integer Quota
    Integer remainingQuota
    Date startDate
    Date endDate
    PromotionStatus status = PromotionStatus.PENDING
    String notAvailableMessage = "This promotion is no longer available."

    Survey survey
	Question currentQuestion
	Date currentQuestionDate
    Integer answersToWin = 1
    Integer daysToWin = 365 // number of days in which answerToWin must be achieved before reset. default is on year

    String correctMessage
    String incorrectMessage
    String winningMessage

    String loggedInCreative
    String loggedOutCreative

    static hasMany = [
            entries:QuestionPromotionEntry
    ]
  
    static constraints = {
	  name blank:false, nullable:false
	  description blank:true, nullable:true
      quota nullable:false
      remainingQuota nullable:true
      startDate nullable:false
	  endDate nullable:true
      survey nullable:false
	  currentQuestion nullable:true
	  currentQuestionDate nullable:true
      correctMessage blank:false, nullable:false
      incorrectMessage blank:false, nullable:false
      winningMessage blank:false, nullable:false
      loggedInCreative nullable:true
      loggedOutCreative nullable:true
    }
	
	String toString(){ 
		return this.name
	}		

	Survey generateSurvey(Integer questionCount = 0) {
		if (!this.survey) {
			this.remainingQuota = quota
			def surveySize = questionCount
		 	def survey = new Survey(title:this.name)
			if (surveySize == 0) {
				def questionList = Question.findAllByType(QuestionType.PROMOTION)
				surveySize = questionList.size()
			}
			survey.generateSurvey(surveySize, QuestionType.PROMOTION)
			if (survey.validate()) {
				survey.save()
				this.survey = survey
				return survey
			}
		}
		return null
	}
	
	Question nextQuestion() {
		if (this.status != PromotionStatus.ACTIVE) {
			println "Promotion not active"
			return null
		}
		def today = new Date()
		today.clearTime()
		if ((this.currentQuestionDate != today) || (!this.currentQuestion)) {
			def questions = this.survey.questions
			if (questions.size() > 0) {
				println "Found questions"
				this.currentQuestionDate = today
				this.currentQuestion = questions.toArray()[0]
				this.survey.removeFromQuestions(this.currentQuestion)
				this.save()
			}
			else {
				println "No more questions"
				this.currentQuestion = null
				this.status = PromotionStatus.COMPLETED
				this.save()
			}
		}
		return this.currentQuestion
	}
	
	Boolean displayToUser(user) {
		def today = new Date()
		today.clearTime()
		def entryList =  QuestionPromotionEntry.createCriteria().list() {
			eq("user",user )
			ge("dateCreated", today)
		}
		
		if (entryList || !user || (this.status != PromotionStatus.ACTIVE))
		 {
			return false
		}
		return true
	}

	Boolean displayToVisitor(user) {
		if (user || (this.status != PromotionStatus.ACTIVE))
		 {
			return false
		}
		return true
	}
	
	Map userStatus(user) {
		def winMessage
		def statusMessage 
		def winner = false
		def entryList =  QuestionPromotionEntry.createCriteria().list() {
			eq("user",user )
			eq("result", PromotionEntryResult.WINNER)
		}
		if (entryList.size() == 1) {
			winMessage = 'You won a ' + this.description + '.'
			winner = true
		} 
	    else {
			if (entryList.size() > 1) {
		          winMessage = 'You won ' + entryList.size().toString() + ' ' + this.description + 's.'
		          winner = true
			}
	    }
		def startDate = new Date() - daysToWin
		entryList =  QuestionPromotionEntry.createCriteria().list() {
			eq("user",user )
			eq("active", true)
			ge("dateCreated", startDate)
			response {
				eq("correct",true)
			}
		}
		def entries = entryList.size()
		if (entries > 0) {
		   def remaining = this.answersToWin - entries
		   def answerText = 'answer' 
		   if (entries > 1) {
			   answerText = 'answers'
		   }
		   statusMessage = this.description +
		   				   ". You have $entries correct " + answerText +
		                   ". You need $remaining more to win."
		}
		def messages = [wins:winMessage, status:statusMessage]
		return messages
	}

	PromotionEntryResult submitEntry(promotionEntry) {
		promotionEntry.result = PromotionEntryResult.INCORRECT
		if (this.status == PromotionStatus.COMPLETED) {
			promotionEntry.active = false
			promotionEntry.result = PromotionEntryResult.INVALID
			promotionEntry.save()
		}
		else {
			if (promotionEntry.response.correct) {
				promotionEntry.result = PromotionEntryResult.CORRECT
				def user = promotionEntry.user
				if (answersToWin == 1) {
					promotionEntry.active = false
					promotionEntry.result = PromotionEntryResult.WINNER
					promotionEntry.save()
					this.useQuota()
				}
				else {
					// only entries on or after startDate are valid for a win
					def startDate = new Date() - daysToWin
					def entryList =  QuestionPromotionEntry.createCriteria().list() {
						eq("user",user )
						eq("active", true)
						ge("dateCreated", startDate)
						response {
							eq("correct",true)
						}
					}
					if (entryList.size() == answersToWin) {
						promotionEntry.result = PromotionEntryResult.WINNER
						// mark entries as not active (already used)
						entryList.each { entry ->
							entry.active = false
							entry.save()
						}
						this.useQuota()
					} // if winner
					else {
						promotionEntry.answersToWin = this.answersToWin - entryList.size()
						promotionEntry.result = PromotionEntryResult.CORRECT
					} // correct answer but not winner
				} // answersToWin > 1
			} // correct answer
		} // promotion completed
		promotionEntry.save()
		return promotionEntry.result
	}
	
	synchronized Integer useQuota() {
		if (this.remainingQuota == null) {
			this.remainingQuota = this.quota
		}
		this.remainingQuota--
		if (this.remainingQuota < 1) {
			this.status = PromotionStatus.COMPLETED
		}
		this.save()
		return this.remainingQuota
	}
}
enum PromotionStatus {
	PENDING, ACTIVE, SUSPENDED, COMPLETED
}

