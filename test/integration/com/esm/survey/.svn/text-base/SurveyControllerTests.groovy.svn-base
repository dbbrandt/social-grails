package com.esm.survey

import grails.test.*

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class SurveyControllerTests extends grails.test.ControllerUnitTestCase {
	
	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}
	
    void testBuild() {
		def sc = new SurveyController()
		
		mockParams.title = 'Test'
		sc.build()
		assertEquals "show", sc.redirectArgs.action  
		
		def survey = Survey.findByTitle(mockParams.title)
		assertNotNull survey
		assertEquals 10, survey.questions.size()
		def question = survey.questions.toArray()[0]
		assertEquals QuestionType.MENTOR, question.type
    }
}
