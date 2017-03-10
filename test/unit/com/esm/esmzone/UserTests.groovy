package com.esm.esmzone

import grails.test.*
import com.esm.esmzone.User
import com.esm.dialog.AnswerRating

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class UserTests extends GrailsUnitTestCase {

    protected void setUp() {
        super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
		
    }

    protected void tearDown() {
        super.tearDown()
		PluginManagerHolder.pluginManager = null
    }

    void testRequiredFields() {
      mockDomain(User)

      def user = new User()
      assertFalse 'validation should have failed', user.validate()
	  println user.errors
      assertEquals "nullable", user.errors.login
      assertEquals "nullable", user.errors.firstName
      assertEquals "nullable", user.errors.lastName
      //assertEquals "nullable", user.errors.gender
      assertEquals "nullable", user.errors.securityQuestion
      assertEquals "nullable", user.errors.securityAnswer
      assertEquals "nullable", user.errors.email
    }

  void testConstraints() {
      mockDomain(User)

      def user = new User(login:"My login",email:"My Email",password:"My Password",gender:"Gender",acceptTerms:false)
      assertFalse 'validation should have failed', user.validate()
      // user and password cannot have blanks
      assertEquals null, user.errors.login
      assertEquals "matches", user.errors.password
      // email must be valid format
      assertEquals "email", user.errors.email
      // gender must be Male or Female
      assertEquals "validator", user.errors.gender
      assertEquals "validator", user.errors.acceptTerms

      user = new User(login:"dbb",email:"dbbrandt@gmail.com",password:"bla",gender:"Male",acceptTerms:true)
      assertFalse 'validation should have failed', user.validate()
      assertEquals null, user.errors.password
      assertEquals null, user.errors.email
      assertEquals null, user.errors.acceptTerms
  }

  void testRatings() {
	  mockDomain(User)

      GregorianCalendar bd = new GregorianCalendar(1997,Calendar.JULY, 15)
      def user = new User(login:"dbbrandt@gmail.com",email:"dbbrandt@gmail.com",password:"bla",gender:"Female",birthdate:bd.time)

      // Star rating is a transformation of 1 - 3 thumbs up to a 5 star system. Therefore the default is 1 thumbs up (approx 1.33)
      assert 'Default rating should be about one thumbs up or around 1.66 stars therefore > 1', user.starRating() > 1
      assert 'Default rating should be about one thumbs up or around 1.66 stars therefore < 1.7', user.starRating() > 1.7

      user.averageRating = 1.66 * 2 // two thumbs up
      assert 'Two thumbs up rating is about 3.32 therefore > 3', user.starRating() > 3
      assert 'Two thumbs up rating is about 3.32 therefore < 3.5', user.starRating() < 3.5

      user.averageRating = 1.66 * 3 // three thumbs up
      assert 'Three thumbs up rating is about 4.98 therefore > 4.75', user.starRating() > 4.75
      assert 'Three thumbs up rating is about 4.98 therefore < 5', user.starRating() < 4

      // create a rating of three stars
      def rating = new AnswerRating()
      rating.score = 1.66 * 3

      // Test add a rating
      user = new User(login:"dbbrandt@gmail.com",email:"dbbrandt@gmail.com",password:"bla",gender:"Female",birthdate:bd.time)
      user.addRating(rating)
      assert "Added rating. Rating count should be 1", user.ratingCount == 1
      assert "Average Rating should be 3 thumbs up, > 3.3", user.averageRating > 3.3
      assert "Average Rating should be 3 thumbs up, < 3.4", user.averageRating < 3.4
    }
  
}
