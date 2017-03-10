package com.esm.esmzone

import grails.test.*
import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class ProspectTests extends GrailsUnitTestCase {
	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}

    void testRequiredFields() {
		mockDomain(Prospect)
		
		def prospect = new Prospect()
		
		assertFalse prospect.validate()
		assertEquals "nullable", prospect.errors.email
		assertEquals "nullable", prospect.errors.source
		
		
    }
}
