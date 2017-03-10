package com.esm.dialog

import grails.test.*
import com.esm.esmzone.User
import com.esm.esmzone.ESMTransaction

import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.plugins.PluginManagerHolder

class PostControllerTests extends grails.test.ControllerUnitTestCase {
	
	protected void setUp() {
		super.setUp()
		PluginManagerHolder.pluginManager = [hasGrailsPlugin: { String name -> true }] as GrailsPluginManager
	}
	
	protected void tearDown() {
		super.tearDown()
		PluginManagerHolder.pluginManager = null
	}
	
	void testAdd() {
		def pc = new PostController()
		
		// TODO: add tags to the test
		mockRequest.method = 'POST'
		mockParams.title = "Test Title"
		mockParams.description = "Test Description"
		mockParams.member = User.get(2)
		pc.request.user = User.get(1)
		pc.add()

		assertEquals "search", pc.redirectArgs.action 
		def post = Post.findByTitle(mockParams.title)
		assert post
		def postId = post.id
		assert postId
		def trans = ESMTransaction.findByContentId(postId)
		assert trans
		def member = User.get(1) // question author 
		def user = User.get(2)  //  alerted user
		assertEquals user, trans.user
		assertEquals member, trans.member 
	}
}
