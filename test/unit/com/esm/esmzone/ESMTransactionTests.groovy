package com.esm.esmzone

import grails.test.*
import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class ESMTransactionTests extends GrailsUnitTestCase {
	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}

    void testRequiredFields() {
		mockDomain(ESMTransaction)
		
		def esmTransaction = new ESMTransaction()
		
		assertFalse esmTransaction.validate()
		assertEquals "nullable", esmTransaction.errors.user
		assertEquals "nullable", esmTransaction.errors.type
    }
}
