package com.esm.esmzone

import grails.test.*
import com.esm.esmzone.User
import com.esm.esmzone.ESMTransaction

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder


class ESMTransactionIntegrationTests extends GrailsUnitTestCase {

	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}

	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}

	void testTransactionList() {
		GregorianCalendar bd = new GregorianCalendar(1997,Calendar.JULY, 15)
		def source = Source.get(1)
		def securityQuestion = SecurityQuestion.get(1)
		def user = new User(login:"dbbrandt@gmail.com",email:"dbbrandt@gmail.com",
							firstName: 'Daniel', lastName: 'Brandt', acceptTerms: true,
							source: source,  securityQuestion:securityQuestion, securityAnswer:'Answer',
			                password:"bla",gender:"Female",birthdate:bd.time)
		assert user.validate()
		assert user.save()
  
		def trans = new ESMTransaction(user:user, type:ESMTransactionType.QUESTION)
		assert trans.validate()
		assert trans.save()
		
		def transList = user.transactionList()
		assert transList
		assert 1, transList.size()
	  }
	
	void testTransactionAlert() {
		GregorianCalendar bd = new GregorianCalendar(1997,Calendar.JULY, 15)
		def source = Source.get(1)
		def securityQuestion = SecurityQuestion.get(1)
		def user = new User(login:"dbbrandt@gmail.com",email:"dbbrandt@gmail.com",
							firstName: 'Daniel', lastName: 'Brandt', acceptTerms: true,
							source: source,  securityQuestion:securityQuestion, securityAnswer:'Answer',
							password:"bla",gender:"Female",birthdate:bd.time)
		user.validate()
		println user.errors
		assert user.save()
		
		assert user.transactionAlert(ESMTransactionType.MESSAGE, "This is a test message")
		assert 1, user.transactionList().size()
	}
}
