package com.esm.promotion

import grails.test.*

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class QuestionPromotionEntryTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
		
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

    void testRequiredFields() {
		
		mockDomain(QuestionPromotionEntry)
		
		def entry = new QuestionPromotionEntry()
		assertFalse 'validation should have failed', entry.validate()
		println entry.errors
		assertEquals 3, entry.errors.errorCount
		assertEquals "nullable", entry.errors.user
		assertEquals "nullable", entry.errors.answersToWin
		assertEquals "nullable", entry.errors.promotion
    }
}
