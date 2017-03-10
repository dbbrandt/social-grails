package com.esm.promotion

import grails.test.*
import com.esm.survey.Survey
import com.esm.survey.Question
import com.esm.survey.QuestionType
import com.esm.esmzone.User

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class QuestionPromotionIntegrationTests extends GrailsUnitTestCase {

	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}

    void testGenerateSurvey() {
		
		def questionList = Question.findAllByType(QuestionType.PROMOTION)
		def listSize = questionList.size() 
		
		questionList = Question.findAllByType(QuestionType.PROMOTION)
		assertEquals listSize, questionList.size()
		
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
				
		def survey = questionPromotion.generateSurvey()

		assert questionPromotion.validate()
		assert questionPromotion.save()
		

		assertEquals questionPromotion.name, survey.title
		assertEquals listSize, survey.questions.size()
		def question = survey.questions.toArray()[0]
		assertEquals QuestionType.PROMOTION, question.type
		
    }

	void testNextQuestion() {
		
		def questionList = Question.findAllByType(QuestionType.PROMOTION)
		def listSize = questionList.size()
		def today = new Date()
		today.clearTime()
		
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.currentQuestionDate = today
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		questionPromotion.generateSurvey()
		assert questionPromotion.save()
		def surveySize = questionPromotion.survey.questions.size()
		assertEquals listSize, surveySize
		
		def question = questionPromotion.nextQuestion()
		assertNotNull question
		assertEquals question, questionPromotion.currentQuestion
		def lastQuestion = question
		
		//verify a question was removed from the survey
		surveySize = questionPromotion.survey.questions.size()
		listSize--
		assertEquals listSize, surveySize
		assertFalse questionPromotion.survey.questions.contains(question)

		assertEquals today, questionPromotion.currentQuestionDate
		
		//verify a new question is selected for a new day
		def yesterday = new Date() - 1
		yesterday.clearTime()
		questionPromotion.currentQuestionDate = yesterday
		question = questionPromotion.nextQuestion()
		assertNotNull question
		assertEquals question, questionPromotion.currentQuestion
		assert question != lastQuestion
		
		//verify no more questions returns completes campaign and returns null
		// remove all questions
		def survey = questionPromotion.survey 
		assert survey
		questionList = []
		survey.questions.each { q -> 
			questionList.add(q)
		}
		questionList.each { q ->
			survey.removeFromQuestions(q)
		}
		assert survey.save()
		assertEquals 0,survey.questions.size() 
		questionPromotion.currentQuestionDate = yesterday
		question = questionPromotion.nextQuestion()
		assertNull question
		assertEquals PromotionStatus.COMPLETED, questionPromotion.status
	}

	// Request to check if the promotion should be displayed to the user.
	// This method is used prior to showing a promotion to a user.
	void testDisplayToUser() {
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		questionPromotion.generateSurvey()
		assert questionPromotion.save()

		// new active promotion. the user has not made an entry. Should show.
		def user = User.get(1)
		def question = questionPromotion.nextQuestion()
		assertNotNull question

		
		// Test when the user has made an entry. Should not show.
		def correctResponse
		question.responses.each { r ->
			if (r.correct) {
				correctResponse = r
			}
		}
		assertNotNull correctResponse

		// create a correct entry 
		def entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.validate()
		assert entry.save()

		assertFalse questionPromotion.displayToUser(user)
		
		//Modify the entry to yesterday and verify promotion now shows.
		def yesterday = new Date() - 1
		yesterday.clearTime()

		entry.dateCreated = yesterday
		assert entry.save()
		assert questionPromotion.displayToUser(user)
		
		//Mark the promotion as completed and verify not shown to user
		questionPromotion.status = PromotionStatus.COMPLETED
		assert questionPromotion.save()
		assertFalse questionPromotion.displayToUser(user)
	}
		
	// Request to check if the promotion should be displayed to a visitor.
	// This method is used prior to showing a promotion to a visitor.
	void testDisplayToVisitor() {
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		questionPromotion.generateSurvey()
		assert questionPromotion.save()

		// new active promotion. the user has not made an entry. Should show.
		def user = User.get(1)
		def question = questionPromotion.nextQuestion()
		assertNotNull question
		assertFalse questionPromotion.displayToVisitor(user)
		
		user = null
		assert questionPromotion.displayToVisitor(user)

		//Mark the promotion as completed and verify not shown to user
		questionPromotion.status = PromotionStatus.COMPLETED
		assert questionPromotion.save()
		assertFalse questionPromotion.displayToVisitor(user)
	}

	void testUserStatus() {
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.answersToWin = 2
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		// create and save the QuestionPromotion with it's survey
		questionPromotion.generateSurvey()
		assert questionPromotion.validate()
		assert questionPromotion.save()

		def correctResponse
		def question = questionPromotion.nextQuestion()
		assertNotNull question
		
		question.responses.each { r ->
			if (r.correct) {
				correctResponse = r
			}
		}
		assertNotNull correctResponse

		def user = User.get(1)
		
		// Submit a correct entry and verify that it was a winner
		def entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.validate()
		assert entry.save()
		def result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.CORRECT, result
		
		def messages = questionPromotion.userStatus(user)
		assert messages
		assertNull messages.wins
		assert messages.status

		// Submit a second correct entry and verify that it is a winner
		entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.validate()
		assert entry.save()
		result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.WINNER, result
		
		messages = questionPromotion.userStatus(user)
		assert messages
		assert messages.wins
		assertNull messages.status
	}

	void testSubmitEntry() {
	
		def questionPromotion = new QuestionPromotion()
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.answersToWin = 2
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		// create and save the QuestionPromotion with it's survey
		questionPromotion.generateSurvey()
		assert questionPromotion.validate()
		assert questionPromotion.save()

		def incorrectResponse
		def correctResponse
		def question = questionPromotion.nextQuestion()
		assertNotNull question
		
		question.responses.each { r ->
			if (r.correct) {
				correctResponse = r
			}
			else {
				incorrectResponse = r
			}
		}
		assertNotNull incorrectResponse
		assertNotNull correctResponse

		def user = User.get(1)
		
		def listSize =  QuestionPromotionEntry.count()
		// Submit an incorrect entry and verify that it was not a winner
		def entry = new QuestionPromotionEntry(user,questionPromotion, incorrectResponse)
		assert entry.validate()
		assert entry.save()
		listSize++
		assertEquals listSize, QuestionPromotionEntry.count()
		def result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.INCORRECT, result
		assert questionPromotion.remainingQuota == 1
		
		// Submit a correct entry and verify that it was a winner
		entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.validate()
		assert entry.save()
		listSize++
		assertEquals listSize, QuestionPromotionEntry.count()
		result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.CORRECT, result
		assert questionPromotion.remainingQuota == 1

		// Submit a second correct entry and verify that it is a winner
		entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.validate()
		assert entry.save()
		listSize++
		assertEquals listSize, QuestionPromotionEntry.count()
		result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.WINNER, result
		assert questionPromotion.remainingQuota == 0


		// Test simplified case where there is only one answer needed to win
		questionPromotion = new QuestionPromotion()
		
		questionPromotion.quota = 1
		questionPromotion.startDate = new Date()
		questionPromotion.answersToWin = 1
		questionPromotion.name = "Test Promotion"
		questionPromotion.correctMessage = "Correct Answer!"
		questionPromotion.incorrectMessage = "Incorrect Answer..."
		questionPromotion.winningMessage = "You are a winner!"
		questionPromotion.status = PromotionStatus.ACTIVE
		
		// create and save the QuestionPromotion with it's survey
		questionPromotion.generateSurvey()
		assert questionPromotion.save()
		
		user = User.get(1)
		
		// Submit an single correct entry and verify that it is a winner
		entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.WINNER, result
		
		//verify that the promotion is completed since the quota is 1
		assertEquals 0,questionPromotion.remainingQuota
		assertEquals PromotionStatus.COMPLETED,questionPromotion.status

		//verify that another entry is rejected		
		entry = new QuestionPromotionEntry(user,questionPromotion, correctResponse)
		assert entry.save()
		result = questionPromotion.submitEntry(entry)
		assertEquals PromotionEntryResult.INVALID, result
	}

}
