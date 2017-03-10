package com.esm.promotion


import grails.test.*
import com.esm.esmzone.User

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class QuestionPromotionControllerTests extends grails.test.ControllerUnitTestCase {
	
	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}
	
	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}
	
	void testViewQuestion() {
		//def qpc = new QuestionPromotionController()
		
		mockRequest.method = 'GET'
		mockParams.id = 1
		def model = controller.viewQuestion()
		def questionPromotion = model.questionPromotion
		assertNotNull questionPromotion
		assertEquals 1, questionPromotion.id
		
		def question = model.question
		assertNotNull question
		assertEquals question.id, questionPromotion.currentQuestion.id
		
		
		// test completed campaign view returns correct redirect
		questionPromotion.status = PromotionStatus.COMPLETED
		questionPromotion.save()
		
		//qpc = new QuestionPromotionController()
		
		mockRequest.method = 'GET'
		mockParams.id = 1
		controller.viewQuestion()
		println controller.response.redirectedUrl
		assertEquals "/questionPromotion/viewResult", controller.response.redirectedUrl  
	}
	
	void testViewResult() {
		//def qpc = new QuestionPromotionController()
		
		def questionPromotion = QuestionPromotion.get(1)
		assertNotNull questionPromotion
		def currentQuestion = questionPromotion.nextQuestion()
		assertNotNull currentQuestion
		def responses = currentQuestion.responses
		assertNotNull responses
	    // test correct answer give proper output
		def correctResponse
		responses.each { r ->
			if (r.correct) {
				correctResponse = r
			}
		}
		assertNotNull correctResponse
		
		mockRequest.method = 'POST'
		mockParams.id = 1
		mockParams.response = correctResponse.id
		controller.request.user = User.get(1)
		
		def model = controller.viewResult()
		questionPromotion = model.questionPromotion
		assertNotNull questionPromotion
		assertEquals 1, questionPromotion.id
		
		def questionText = model.questionText
		assertNotNull questionText
		assertEquals questionText, questionPromotion.currentQuestion.questionText
		
		def responseText = model.responseText
		assertNotNull responseText
		assertEquals responseText, correctResponse.responseText
		
		def message = model.message
		println message
		assertNotNull message
		
		// test missing answer gives proper error
		mockRequest.method = 'POST'
		mockParams.id = 1
		mockParams.response = null
		controller.request.user = User.get(1)
		
		model = controller.viewResult()

		responseText = model.responseText
		message = model.message
		println message
		assertNotNull message
		assertEquals message, questionPromotion.incorrectMessage

	}
}
