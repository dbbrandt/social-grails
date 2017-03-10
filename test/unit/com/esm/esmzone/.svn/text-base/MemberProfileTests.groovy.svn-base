package com.esm.esmzone

import grails.test.*

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class MemberProfileTests extends GrailsUnitTestCase {

	protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

	void testRequiredFields() {
	    mockDomain(MemberProfile)
	
		def memberProfile = new MemberProfile()
		
	    assertFalse memberProfile.validate()
	    assertEquals "nullable", memberProfile.errors.grade
	    assertEquals "nullable", memberProfile.errors.user
	}
}

