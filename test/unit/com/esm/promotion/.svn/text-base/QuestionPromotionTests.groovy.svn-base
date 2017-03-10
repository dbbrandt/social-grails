package com.esm.promotion

import grails.test.*

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder


class QuestionPromotionTests extends GrailsUnitTestCase {

	protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
		
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

	void testRequiredFields() {
	    mockDomain(QuestionPromotion)
	
	    def promotion = new QuestionPromotion()
	    assertFalse 'validation should have failed', promotion.validate()
	
		println promotion.errors
		
		assertEquals 7, promotion.errors.errorCount
		
	    assertEquals "nullable", promotion.errors.quota
	    assertEquals "nullable", promotion.errors.startDate 
		assertEquals "nullable", promotion.errors.name
		
	    assertEquals "nullable", promotion.errors.survey
	    assertEquals "nullable", promotion.errors.correctMessage
	    assertEquals "nullable", promotion.errors.incorrectMessage
	    assertEquals "nullable", promotion.errors.winningMessage
  }
}
