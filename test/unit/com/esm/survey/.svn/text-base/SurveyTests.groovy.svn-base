package com.esm.survey

import grails.test.*

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class SurveyTests extends GrailsUnitTestCase {

	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
		
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}


    void testValidate() {
		mockDomain(Survey)
		
		def survey = new Survey()
		assertFalse 'validation should have failed', survey.validate()
		println survey.errors
		
		assertEquals 1, survey.errors.errorCount
		assertEquals "nullable", survey.errors.title
    }
	
	void testGenerateSurvey() {
		mockDomain(Survey)
		mockDomain(Question)
		
		def survey = new Survey()
		
		assertFalse survey.generateSurvey(0)
		
		// no questions to generate from so false
		assertFalse survey.generateSurvey(1)
	}
}
