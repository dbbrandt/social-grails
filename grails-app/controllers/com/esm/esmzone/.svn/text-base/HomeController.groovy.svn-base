package com.esm.esmzone;

import com.esm.dialog.*;
import com.esm.cms.*;
import org.compass.core.engine.SearchEngineQueryParseException
import org.springframework.util.ClassUtils
import org.jsecurity.SecurityUtils

class HomeController {
	def searchableService
	
	def facebookGraphService
	
	String fbContent() {
		def fbContent = ""
		def facebookData = facebookGraphService.getFacebookData()
		if (facebookData) {
			def userId = request?.user?.id
			if  (userId) {
				fbContent = "<fb:req-choice url=\\'http://" + request.getServerName() + "/esmzone/register?friendId=" + userId + "\\' label=\\'Register Now\\'  />"
			}
		}
		return fbContent
	}
	
	//TODO the cms content methods are duplicated in several controllers and need to be refactored.
	//Determin if Pending content should be show. Pending shown if admin user and systemConfig set
	def showPendingContent() {
		def  systemConfig = SystemConfig.get(1)
		def subject = SecurityUtils.getSubject()
		if (subject.authenticated) {
			def user = User.findByLogin(subject?.getPrincipal())
			def admin = user.hasRole(RoleName.ADMINISTRATOR)
			if (admin && systemConfig.showPendingContent) {
				println "Show pending content is true"
				return true
			}
		}
		return false
	}

	// return only active content for the page
	def activeContent(controller, action) {
		def page
		if (this.showPendingContent()) {
			page = ContentPage.findByViewAndStatus(controller+":"+action, ContentStatus.PENDING)
		}
		// if we are not in pending mode or there is not pending content get active content
		if (!page) {
	    	page = ContentPage.findByViewAndStatus(controller+":"+action, ContentStatus.ACTIVE)
		}
		return page
	}
	
	//return only active section for the page
	def activeSections(page) { 
		if (page) {
			def contentStatus
			def sections = []
			page.sections.each { section ->
				// show pending content if the page is pending or 
				// the page is active but we are in pending content mode
				if ((section.status == page.status) ||
				    (this.showPendingContent() && (section.status == ContentStatus.PENDING))
				   ) {
					sections.add section
				}
			}
			sections.sort { it.sequence }
			return sections
		}
		return null
	}
	
	def admin = {
		initWidgetParams(params)
		def loginError = params.loginError
		return fetchPosts(params) + fetchUsers(params) + [loginError:loginError]
	}
	
	def home = {
		redirect(action:"index")
	}
	
	def index = {
		params.max = Math.min(params.max ? params.int('max') : 5, 100)
		def postController = new PostController()
		def result = postController.doSearch(params, searchableService)
		def fbContent = this.fbContent();
		def serverName = request.getServerName()
		def contentPage = this.activeContent(controllerName, actionName)
		return result + [fbContent:fbContent,fbAction: "http://"+ serverName + "/esmzone",contentPage:contentPage]
	}

	def indexFacebook = {
		    def userId=request?.user.id
			return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/indexFacebook"]
	}

	def facebookTest = {
		return
	}

	def about = {
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/about",contentPage:contentPage, sections:sections]
	}
	
	def faqs = {
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/about",contentPage:contentPage, sections:sections]
	}

	def spectators = {
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/about",contentPage:contentPage, sections:sections]
	}

	def contact = {
		def user = User.get(1)
		if(request?.method == 'POST') {
			if (params.message) {
				try {
					sendMail {
						to user.email
						subject "ESMZone Contact Us"
						body view:"/emails/contactUs",
								model:[name:params?.name, email:params?.email, message:params?.message]
					}					
				}
				catch(Exception e) {
					log.error "Problem sending contact us email $e.message", e
					flash.message = "Failed to send contact us email"
					redirect(action:"contact")
				}
				flash.message = "Message sent. Thank you."
				redirect(action:"contact")
			}
		}
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		[contentPage:contentPage, sections:sections]
	}
	
	def privacy = {
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/about",contentPage:contentPage, sections:sections]
	}
	
	def terms = {
		def contentPage = this.activeContent(controllerName, actionName)
		def sections = this.activeSections(contentPage)
		return [fbContent:this.fbContent(),fbAction: "http://${request.getServerName()}/esmzone/about",contentPage:contentPage, sections:sections]
	}
	
	def dialogWidget = {
		initWidgetParams(params)
		def model = fetchPosts(params)
		render(template:"dialogWidget",model:model)
	}
	
	def scoreWidget = {
		initWidgetParams(params)
		def model = fetchUsers(params)
		render(template:"scoreWidget",model:model)
			}
	
	def login = {
		initWidgetParams(params)
		render(view:"index", model: fetchPosts(params))
	}
	
	Boolean initWidgetParams(params) {
		params.max = 10
		if (!params?.dialogTab) {
			params.dialogTab = "top10"
		}
		if (!params?.scoreTab) {
			params.scoreTab = "top10"
		}
		if (request.user) {
			def user = User.get(request?.user?.id)
			if (!params.grade) {
				params.grade = user?.memberProfile?.grade
			}
			if (!params.sport) {
				params.sport = user?.memberProfile?.playedSports?.toArray()[0].name
			}
		}
		return true
	}
	
	Object fetchPosts(params) {
		// because the home page has multiple widgets, currently the use the same params
		// Sortable columns must be the same or require special logic. 
		// ToDo: a more flexible sort approach
		def originalSort = params.sort
		if ((params.sort == "firstName") || (params.sort == "questionCount")) {
			params.sort = "title"
		}
		def postInstanceList =  Post.createCriteria().list(params) {
			postType {
				eq('name', PostTypeName.QUESTION)
				eq('audience', PostTypeAudience.PUBLIC)
			}
		}
		def postGradeList =  Post.createCriteria().list(params) {
			postType {
				eq('name', PostTypeName.QUESTION)
				eq('audience', PostTypeAudience.PUBLIC)
			}
			author {
				memberProfile {
					eq('grade',params.int('grade'))
				}
			}
		}
		def postSportsList =  Post.createCriteria().list(params) {
			postType {
				eq('name', PostTypeName.QUESTION)
				eq('audience', PostTypeAudience.PUBLIC)
			}
			author {
				memberProfile {
					playedSports {
						eq('name',params.sport)
					}
				}
			}
		}
		params.sort = originalSort
		if (!params.sort) {
			postInstanceList?.sort {a,b-> (b.score > a.score)? 1:0}
			postGradeList?.sort {a,b-> (b.score > a.score)? 1:0}
			postSportsList?.sort {a,b-> (b.score > a.score)? 1:0}
		}
		return [postInstanceList: postInstanceList,postGradeList: postGradeList, postSportsList:postSportsList]
	}

	Object fetchUsers(params) {
		// becauuse the home page hase multiple widgets, currently the use the same params
		// Sortable colums must be the same or require special logic. 
		// ToDo: a more flexible sort approach
		params.max = 10
		if (!params.sort) {
			params.sort = 'score'
			params.order = 'desc'
		}
		def originalSort = params.sort
		if (params.sort == "title") {
			params.sort = "firstName"
		}
		def userInstanceList = User.list(params)
		def userGradeList =  User.createCriteria().list(params) {
			memberProfile {
				eq('grade',params.int('grade'))
			}
		}
		def userSportsList
		if (params.sport) {
			userSportsList =  User.createCriteria().list(params) {
				memberProfile {
					playedSports {
						eq('name',params.sport)
					}
				}
				maxResults(10)
				order("score", "desc")
			}
		}
		params.sort = originalSort
		if (!params.sort) {
			userInstanceList?.sort {a,b-> (b.score > a.score)? 1:0}
			userGradeList?.sort {a,b-> (b.score > a.score)? 1:0}
			userSportsList?.sort {a,b-> (b.score > a.score)? 1:0}
		}
		return [userInstanceList: userInstanceList,userGradeList: userGradeList, userSportsList:userSportsList]
	}

}
