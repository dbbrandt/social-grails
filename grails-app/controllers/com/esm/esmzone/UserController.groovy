package com.esm.esmzone

import java.util.List
import java.util.HashSet
import org.hibernate.FetchMode as FM

import org.jsecurity.authc.UsernamePasswordToken
import org.jsecurity.authc.AuthenticationException
import org.jsecurity.crypto.hash.Sha1Hash
import org.jsecurity.SecurityUtils
import org.compass.core.engine.SearchEngineQueryParseException
import org.springframework.util.ClassUtils
import javax.servlet.http.Cookie

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import org.w3c.dom.Document;

import com.esm.esmzone.User
import com.esm.esmzone.SecurityQuestion
import com.esm.esmzone.Role
import com.esm.esmzone.NetworkConnection
import com.esm.esmzone.SystemConfig
import com.esm.cms.*;


class UserController {
	//def facebookConnectService
	def facebookGraphService
	
	def scaffold = true
	
	def jsecSecurityManager

	//TODO the two pending and active content methods are duplicated in several controllers and need to be refactored.
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
	
	void setCookie(name, value) {
		def cookie = new Cookie(name, value.toString())
		cookie.path = '/'
		cookie.maxAge = 60*60*24*7 // 1 week in seconds
		response.addCookie(cookie)
	}	
	
	def foundCookie(name) {
		def cookies = request.getCookies()
		def cookie
		(1..cookies.size()).each { i->
			if (cookies[i-1].name == name) {
				cookie = cookies[i-1]
			}
		}
		return cookie
	}

	def facebookApi(path) {
		def result
		def facebookData = facebookGraphService.getFacebookData()
		
		println "Facebook API call with: " + path 

		if(facebookData) {
			try {
				result = facebookGraphService.api(path, facebookData)
			} catch (Exception e) {
				println "Facebook API error ${e}"
			}
		}
		
		return result

	}

	String checkFacebookSession() {
		def result
		def facebookData = facebookGraphService.getFacebookData()
		if (facebookData) {
			result = facebookData.get("uid")
		}
		return result
	}
	
	String testFacebookAPI() {
		println "Getting Facebook Profile"
		//def userData = facebookGraphService.getFacebookProfile()
		
		def userData = facebookApi("/me")

		return "Facebook profile: <br> " + userData
	}

	def facebookUserInfo() {
		return facebookApi("/me")
	}

	String facebookEmail(userData) {
		def email
		try {
			email = userData.get("email")
			println "Email: " + email
		} catch (Exception e) {
			println "Facebook fields not found ${e}"
		}
		return email
	}

	String facebookGender(userData) {
		def gender
		try {
			gender = userData.get("gender")
			if (userData.get("gender") == "male") {
				gender = "Male"
			}
			else {
				gender = "Female"
			}
			println "gender: " + gender
		} catch (Exception e) {
			println "Facebook fields not found ${e}"
		}
		return gender
	}

	String facebookCity(userData) {
		def city
		try {
			def location_result = userData.get("location")
			println "Location Result: " + location_result
			city = location_result.get("name")
			println "City: " + city
		} catch (Exception e) {
			println "Facebook fields not found ${e}"
		}
	}

	User createFacebookUser (userData, source) {
		if (!userData) {
			return
		}
		println "Creating User from Facebook data: " + userData
		def userId = userData.get("id")
		println "UserId: " + userId
		def first_name = userData.get("first_name")
		println "first name: " + first_name
		def last_name = userData.get("last_name")
		println "last name: " + last_name

		def email = facebookEmail(userData)
		def gender = facebookGender(userData) 

		def user_photo = facebookGraphService.getProfilePhotoSrc(userId)
		println "User photo:" + user_photo

		// Create the user from facebook data
		println "Creating new user"
		def user = new User()
		user.login = userId
		user.password = user.login
		user.firstName = first_name
		user.lastName = last_name
		user.gender = gender
		user.securityQuestion = SecurityQuestion.get(1)
		user.securityAnswer = userId.toString()

		if (email) {
			user.email = email
		}
		else {
			user.email = userId.toString() + '@esmzone.com'
		}
		Date date = new java.util.Date()
		user.dateCreated = date
		user.lastUpdated = date
		user.source = source
		user.ageTerms = true
		user.acceptTerms = true
		
		if (user.validate()) {
			user.save()
		}
		else {
			println user.errors
		}
		return user
	}

/*
	Boolean saveFacebookPicture(user) {
		FacebookJsonRestClient client = facebookConnectService.getFacebookClient()
		if (client) {
			println "Got FacebookJsonRestClient : " + client
		}
		String userId = facebookConnectService.getFacebookClient().users_getLoggedInUser()
		println "USER:  " + userId

		Set fields = new HashSet( [ProfileField.NAME,ProfileField.PIC_SQUARE])
		Collection<Long>users=new ArrayList()
		users.add(Long.parseLong(userId))
		def result = client.users_getInfo(users,fields)
		def userData = result.get(0)
		def name = userData.get("name")
		println "Username: " + name
		def pic = userData.get("pic_square")
		println "Image url: " + pic
		
		//TODO need to create an avatar file to add to the member profile
		//Copy the image from the URL to the avatar directory
		return true
	}
	
	String testFacebookAPI() {
		println "Getting Facebook Friends"
		def friends = facebookConnectService.getFacebookClient().friends_get()
		// setup the variables used to retrieve the data from the facebook API
		Set fields = new HashSet( [ProfileField.NAME, ProfileField.PIC_SQUARE])
		Collection<Long>userIds=new ArrayList()
		for (int index = 0; index < friends.length(); index++) {
			userIds.add((Long) friends.get(index))
		}
		//call the api
		def friendData = facebookConnectService.getFacebookClient().users_getInfo(userIds,fields)

		def friendString = ""
		for (int index = 0; index < friends.length(); index++) {
			def friend = friendData.get(index)
			// create the test line to show the friend
			friendString+=  userIds.get(index).toString() + "<br>" + friend.get("name") + 
							"<br><img height='50' width='50' src='" + friend.get("pic_square") + "'><br><br>"
		}

		return "Friends: <br> " + friendString 
	}	
	
	
	User createFacebookUser (userId, source) {
		println "Creating Facebook user: " + userId
		Collection<Long>userIds=new ArrayList()
		userIds.add(Long.parseLong(userId))
		Set fields = new HashSet( [ProfileField.FIRST_NAME, ProfileField.LAST_NAME])
		def result = facebookConnectService.getFacebookClient().users_getInfo(userIds, fields)
		def userData = result.get(0)

		// Create the user from facebook data 
		def user = new User()
		user.login = userId
		user.password = user.login
		user.firstName = userData.get("first_name")
		user.lastName = userData.get("last_name")
		user.securityQuestion = SecurityQuestion.get(1)
		user.securityAnswer = userId.toString()

		user.email = userId.toString() + '@esmzone.com'
		Date date = new java.util.Date()
		user.dateCreated = date
		user.lastUpdated = date
		user.source = source
		user.acceptTerms = true
		
		if (user.validate()) {
			user.save()
		}
		else {
			println user.errors
		}
		return user
	}
*/
	String loginUser(user) {
		def loginError
		def login = user.login
		def password = user.password
		def authToken = new UsernamePasswordToken(login, password)
		try{
			this.jsecSecurityManager.login(authToken)
			request.user = User.findByLoginAndStatus(login,UserStatus.ACTIVE)
			if (request.user && request.user.isMember()) {
				request.user.addPoints(PointsType.lookup("Login"))
				//select random background image for the session
				def random = new Random()
				def BackgroundImageCount = BackgroundImage.count()
				def BackgroundImageList = BackgroundImage.list()
				def next = random.nextInt(BackgroundImageCount)
				def backgroundImage = BackgroundImageList.get(next)
				session.backgroundImage = backgroundImage?.filename
			}
			else {
				org.jsecurity.SecurityUtils.getSubject().logout()
				loginError = "Login failed. Not activated."
			}
		}
		catch (AuthenticationException ex){
			loginError = "Login failed: " + ex
		}
		println 'loginError: ' + loginError
		return loginError
	}	
	
	Object doSearch(paramList, contentPage=null, onlyPlayers=false) {
		def user = request?.user
		paramList.max = Math.min(paramList.max ? paramList.int('max') : 10, 200)
		def pageMax = paramList.max
		// set the max page size higher. This needs to be larger than a page
		// since filters will also be in effect and can further reduce the results.
		paramList.max = 100
		def userInstanceTotal 
		def resultsList = []
		def userInstanceList = []
		if (!paramList.q?.trim()) {
			userInstanceTotal= User.count()
			resultsList =  User.list(paramList) 
		}
		else {
			try {
				def userResult
				def userInstance
				def searchResult = User.search(paramList?.q, paramList)
				searchResult?.results.each {
					def className = ClassUtils.getShortName(it.getClass())
					if (className == "User") {
						userInstance = User.get(it?.id)
						resultsList.add(userInstance)
					}
				} //each search result 
			} 
			catch (SearchEngineQueryParseException ex) {
				return [parseException: true]
			}
			userInstanceTotal = resultsList.count()
		}
		//reset the page size to the original prior to search
		paramList.max = pageMax
		//need to repopulate the autoCompleteId after the initial selection 
		//It only comes back after the school is initiall inputted.
		def school_id
		// Use the full result size as the total unless people are filtered out
		if (paramList.schoolAutoInput_id) {
			school_id = paramList.school_id
		}
		resultsList.each { userInstance ->
			if (doFilter(paramList,userInstance,onlyPlayers)) {
				if (userInstanceList.size() < pageMax) {
					userInstanceList.add(userInstance)
				}
			} //end filter
			else { // row doesn't pass filter
				// decrement the total if the row is skipped
				userInstanceTotal--
			}
		}
		return [contentPage:contentPage, userInstanceList: userInstanceList, userInstanceTotal: userInstanceTotal, q:paramList?.q, tags:params.tags, mentors:params.mentors, postCount:params.postCount, rating:params.rating, male:params.male, female:params.female, grade:params.grade, playedSport:params.playedSport, school:params.schoolAutoInput, school_id:school_id, city:params.city, division:params.division ]
	}
	
	Boolean doFilter(paramList, userInstance, onlyPlayers=false) {
		// If onlyPlayers, exclude non-player roles.
		if (onlyPlayers && !userInstance.isPlayer()) {
			return false
		}
		if (!paramList.male && paramList.female && (userInstance.gender == "Male")) {
			return false
		}
		if (!paramList.female && paramList.male && (userInstance.gender == "Female")) {
			return false
		}
		if ((paramList.grade) && (userInstance?.memberProfile?.grade != params.int("grade"))) {
			return false
		}
		if ((paramList.playedSport) && (!userInstance?.memberProfile?.playedSports.contains(Sport.get(params.playedSport)))) {
			return false
		}
		if ((paramList.schoolAutoInput_id) && (userInstance?.memberProfile?.currentSchool != School.get(params.schoolAutoInput_id))) {
			return false
		}
		if ((paramList.city) && (userInstance?.address?.city?.toLowerCase() != paramList.city?.toLowerCase())) {
			return false
		}
		if (paramList.postCount){
			def postCount = userInstance?.answerCount + userInstance?.questionCount
			switch (paramList.int("postCount")) {
				case 0: // 0 
					if (postCount > 0) return false
					break

				case 1: // 1
					if (postCount != 1) return false
					break

				case 2: // less than 5 
					if ((postCount < 2) || (postCount > 5)) return false
					break
				
				case 3: // at least 10
					if (postCount < 10) return false
					break
			 }
		}
		if ((paramList.homeTab) && (userInstance?.division.toString() != paramList.homeTab)) {
			return false
		}
		return true
	}
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
		flash.message = "Welcome to our site!"
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

	def people = {
		request.menu = "people"
		params.sort = "firstName"
		def onlyPlayers = false 
		def results = doSearch(params, onlyPlayers)
		def hc = new HomeController()
		println hc.fbContent()
		return results + [fbContent:hc.fbContent()]
	}

	def standings = {
		request.menu = "standings"
		params.sort = "score"
		params.order = "desc"
		if (!params.homeTab) {
			if (!request?.user) {
				params.homeTab = 'I'
			}
			else {
				params.homeTab = request?.user?.division.toString()
			}
		}
		def onlyPlayers = true
		def contentPage = this.activeContent(controllerName, actionName)
		return doSearch(params,contentPage, onlyPlayers) 
    }

    def admin = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def userInstanceList
        if (!params.email) {
        	userInstanceList = User.list(params)
		}
		else {
	        userInstanceList =  User.createCriteria().list(params) {
				like('email','%'+params.email+'%')
			}
		}
        [userInstanceList: userInstanceList, userInstanceTotal: userInstanceList.size()]
    }

	def statsReport = {
		def userInstance = User.get(params.id)
		return [userInstance:userInstance]
	}

	def makeZombie = {
		def userInstance = User.get(params.id)
		if(request.method == 'POST') {
			if (userInstance.makeZombie()) {
				flash.message = "${message(code: 'default.zombie.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
				redirect(action:"admin")
			}
			else {
				flash.message = "Zombie request for " + userInstance + " failed." + userInstance.errors
			}
					}
		render(view:"show", model: [userInstance:userInstance])
	}
	
	def selectMentor = {
		def maxMentors = 4
		def user = User.get(request?.user?.id)
		def userInstanceList = []
		def listSize
		if (user) {
			if (!params.offset) {
				params.offset = 0
			}
			if (params?.mentor) {
				redirect(controller:"networkConnection", action:"requestMentor", id:params.mentor)
			}
			def mentorList =  User.createCriteria().list() {
					eq("gender",user.gender )
					eq("isMentor", true)
					ne("id", request.user.id)
					memberProfile {
						gt("grade", user?.memberProfile.grade)
					}
				fetchMode 'memberProfile', FM.EAGER
			}
			if (mentorList.size() < User.mentorListSize) {
				mentorList =  User.createCriteria().list() {
					eq("isMentor", true)
					ne("id", request.user.id)
					fetchMode 'memberProfile', FM.EAGER
				}
			}
			listSize = mentorList.size()
			mentorList.each {
				it.getMentorScore(user, user.memberProfile, user.address)
			}
			mentorList.sort{a,b-> (b.mentorScore > a.mentorScore)? 1:0}
			def start = params.int('offset')
			def end = ((start + maxMentors) > mentorList.size()) ? mentorList.size(): start + maxMentors
			userInstanceList = mentorList.toArray()[start..end-1]
			params.max = maxMentors
		}
		
		[userInstanceList: userInstanceList, userInstanceTotal: listSize]
	}

	
    def directory = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
		def rows
		if (!params.offset) {
				params.offset = 0
		}
		if (!params.sort) {
			params.sort = "firstName"
			params.order = "asc"
		}
		// Need to handle nested class sorts ex. memberProfile.grade
		// for now default to score
		def userInstanceList = []
		def user = User.get(request?.user?.id)

		if (!user) {
			params.sort = "firstName"
			params.order = 'desc'
			userInstanceList =  User.createCriteria().list(params) {
				eq('isMentor',true)
			}
			rows = userInstanceList.totalCount
		}
		else {
			if (params.sort.find(~/user\./)) {
				def type
				if (params.sort.find(~/\.fan/)) {
					type = NetworkConnectionType.FAN
				}
				else {
					type = NetworkConnectionType.MENTOR
				}
				params.sort = "firstName"
				userInstanceList =  User.createCriteria().list(params) {
					ge('id',params.long("offset"))
					or {
						myConnections {
							eq('friend',user)
							eq('type',type)
						}
						fanConnections {
							eq('user',user)
							eq('type', type)
						}
					}
					maxResults(params.max)
					order('score', params.order)
				}
				rows = userInstanceList.totalCount
			}
			else if (params.sort == "memberProfile.grade") {
				def results =  User.findAll("from User u, MemberProfile m where u.id = m.id order by m.grade ${params.order}",
				                                [max:params.max,offset:params.offset])
				def i = 0
				results.each { userInstanceList[i++] = it.getAt(0) }
				rows = User.count()
			}
			else if (params.sort == "averageRating"){
				params.order = 'desc'
				userInstanceList =  User.createCriteria().list(params) {
					eq('isMentor',true)
					order('averageRating', 'desc')
				}
				rows = userInstanceList.totalCount
			}
			else {
				userInstanceList =  User.list(params) 
				rows = User.count()
			}
		}
        [userInstanceList: userInstanceList, userInstanceTotal: rows]
    }

    def mentorDirectory = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
		if (!params.offset) {
				params.offset = 0
		}
		if (!params.sort) {
			params.sort = "score"
			params.order = "desc"
		}
		// Need to handle nested class sorts ex. memberProfile.grade
		// for now default to score
		else if (params.sort.find(~/\./)) {
			params.sort = "score"
			params.order = "desc"
		}
		def userInstanceList
		userInstanceList =  User.createCriteria().list(params) {
			eq('isMentor',true)
		}
		
        [userInstanceList: userInstanceList, userInstanceTotal: userInstanceList.count()]
    }

    def fanReport = {
		def user = request?.user
		if (params.id) {
			user = User.get(params.id)
		}
		[userInstanceList: user?.connectionList()]
    }


    def create = {
        def userInstance = new User()
        userInstance.properties = params
        return [userInstance: userInstance]
    }

    def save = {
        def userInstance = new User(params)
		userInstance.password = new Sha1Hash(params.password).toHex()
		if (userInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
            redirect(action: "show", id: userInstance.id)
        } 
        else {
			userInstance.password = "";
            render(view: "create", model: [userInstance: userInstance])
        }
    }

    def show = {
        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            [userInstance: userInstance]
        }
    }

    def edit = {
        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [userInstance: userInstance]
        }
    }

    def update = {
        def userInstance = User.get(params.id)
        if (userInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (userInstance.version > version) {
                    
                    userInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'User')] as Object[], "Another user has updated this User while you were editing")
                    render(view: "edit", model: [userInstance: userInstance])
                    return
                }
            }
            userInstance.properties = params
			if (userInstance.password && (userInstance.password != params.password)) {
				if(params.password != params.confirm) {
					userInstance.password = params.password
					userInstance.errors.rejectValue("password", "user.password.dontmatch")
					return [user:userInstance]
				}
				else {
					userInstance.password = new Sha1Hash(params.password).toHex()
				}
			}
						
            if (!userInstance.hasErrors() && userInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
                redirect(action: "show", id: userInstance.id)
            }
            else {
                render(view: "edit", model: [userInstance: userInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def userInstance = User.get(params.id)
        if (userInstance) {
            try {
                userInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

	def facebookAPI = {
		def apiResult = this.testFacebookAPI();
		[apiResult:apiResult]
	}

	// automatically register and login a new user,
	//	 or link a facebook user with an existing ESM account with same email
	//   or login a facebook user with an ESM account setup already  
	def fbLogin = {
		def source 
		def loginError
		// Verify user is comming from our Facebook connect button
		if (params.source != 'esmzone') {
			println "Invalid source for facebook login"
			loginError = "Invalid source for facebook login"
		}
		else {
			source = Source.findByCoupon(params.source)
		} 
		// Verify user successfully logged into Facebook
		def userId = this.checkFacebookSession()
		if (!userId) {
			println "fbLogin: Check for facebook logged in failed"
			loginError = "Facebook login failed."
		}
		// if no errors start auto login/registration process
		if (!loginError) {
			def facebookUserData = this.facebookUserInfo()
			def user = 	User.findByLogin(userId)
			// if user already created and active on our side, log the user into ESMZone
			if (user && (user.status == UserStatus.ACTIVE)) {
				loginError = this.loginUser(user)
			}
			// if user already created and but not yet active, goto confirm the registration
			else if (user && (user.status == UserStatus.PENDING)) {
				println 'Pending user, redirecting to facebookConfirm'
				redirect(action:"facebookConfirm")
				return
			} 
			// user is new, create and login the new user
			else {
				def email = this.facebookEmail(facebookUserData)
				if (email) {
					// Check if user exists with same email, link the user to their facebook login
					user = User.findByEmail(email)
					if (user) {
						println "Linking existing user"
						user.login = userId
						if (user.validate()) {
							user.save(flush:true)
							loginError = this.loginUser(user)
						}
						else {
							loginError = user.errors
						}
					}
				}
				if (!user) {
					//  no user found. Create one from facebook data
					println 'New user, creating based on fb data'
					if (params.friendId) {
					    source = Source.findBySourceName("friend")
					}
					user = this.createFacebookUser(facebookUserData, source)
					if (!user) {
						println "fbLogin: Create user for facebook logged in failed"
						loginError = "Facebook login failed."
					}
					else {
						if (params.friendId) {
						    def friend = User.get(params.friendId)
							def prosp = new Prospect(email:user.email, source:source, user:friend)
							if (prosp.validate()) {
							  prosp.save()
							}
							else {
							  println "Failed to validate prospect " . prosp.errors
							}
							println "Found friend: " + friend
						}
						//this.saveFacebookPicture(user)
						request.user = user
						redirect(action:"facebookConfirm")
						return
					}
				}
			} // user not found
		}
		flash.message = loginError
		redirect(controller:"home", action:"index",params:["loginError":loginError])
	}
	
	def login = { LoginCommand cmd ->
		if(request.method == 'POST') {
			def loginError
			if(!cmd.hasErrors()) {
				println "Login processing..."
				def user = new User()
				user.login = cmd.login
				user.password = cmd.password
				loginError = this.loginUser(user)
				if (!loginError) {
					println "Login succeded!"
					redirect(controller:"home", action:"index")
					return
				}
				println "Login error: " + loginError
			}
			println "Login CMD errors: " + cmd.errors
			if (!loginError) {
				if (!request?.user?.isMember()) {
					loginError = "${message(code: 'user.invalid.subscription')}"
				}
				else {
					loginError = "${message(code: 'user.invalid.login')}"
				}
			}
			if (loginError) {
				flash.message = "Login error."
				//flash.message = loginError
			}
			redirect(controller:"home", action:"index",params:["loginError":loginError])
			return
		}
		else {
			redirect(controller:"home", action:"index")
		}
	}

	def forgotPassword = {
		println params
		def user
		def flag = params.sendEmail
		if(request.method == 'POST') {
			if (!params.validated) {
				params.validated = 'false';
			}
			if (params.email) {
				user = User.findByEmail(params.email)
			}
			else if (params.id) {
				user = User.get(params.id)
			}
			if (!user) {
				flash.message = "${message(code: 'default.invalid.email.message', args: [message(code: 'user.label', default: 'User'), params.email])}"
				return [validated: params.validated]
			}
			else if (params.sendEmail) {
				user.textPassword = null
				try {
					sendMail {
						to user.email
						subject "Profile Changed"
						body view:"/emails/confirmProfileUpdate",
								model:[user:user, reset:'true']
					}					
				}
				catch(Exception e) {
					log.error "Problem sending email $e.message", e
				}
				flash.message = "${message(code: 'default.password.email.message', args: [message(code: 'user.label', default: 'User'), params.email])}"
				render "<script> parent.jQuery.fancybox.close() </script>"
			}
			else if ((params.validated == 'false') && !params.securityAnswer) {
				flash.message = null
				return [user: user, securityQuestion: user.securityQuestion, validated: params.validated]
			}
			else if ((params.validated == 'false') && ((params.securityAnswer != user.securityAnswer) || (params.birthdate != user.birthdate))) {
				flash.message = "${message(code: 'default.invalid.securityResponses.message', args: [message(code: 'user.label', default: 'User'), params.email])}"
				return [user: user, securityQuestion: user.securityQuestion, validated: params.validated]
			}
			else if (params.validated == 'false') { 
				flash.message = null
				params.validated = 'true'
				return [user: user, validated: params.validated]
			}
			else if (!params.password || (params.password != params.confirm)) {
				flash.message = "${message(code: 'default.invalid.passwordMatch.message', args: [message(code: 'user.label', default: 'User'), params.email])}"
				return [user: user, validated: params.validated]
			}
			else {
				user.password = new Sha1Hash(params.password).toHex()
				user.textPassword = params.password
				user.save(flush:true)
				try {
					sendMail {
						to user.email
						subject "Profile Changed"
						body view:"/emails/confirmProfileUpdate",
								model:[user:user]
					}					
				}
				catch(Exception e) {
					log.error "Problem sending email $e.message", e
				}

				flash.message = "${message(code: 'default.password.changed.message', args: [message(code: 'user.label', default: 'User'), params.email])}"
				redirect(controller:"home", action:"index")
			}
		}
		if (params.k) {
			user = User.get(params?.id)
			if (user && (user.password == params.k)) {
				flash.message = null
				params.validated = 'true'
				return [user: user, validated: params.validated]
			}
			else {
				flash.message = "${message(code: 'default.invalidReqeust.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
				redirect(controller:'home', action:'index')
			}
		}
		return [validated: false]
	}

	def account = {
		if(request.method == 'POST') {
			def passwordChanged
			User u = request.user
			def org_u = User.findByLogin(params.login)
			if (params.password && (params.password != org_u.password)) {
				if(params.password != params.confirm) {
					u.password = params.password
					u.errors.rejectValue("password", "user.password.dontmatch")
					return [user:u]
				}
				else {
					u.password = new Sha1Hash(params.password).toHex()
					u.textPassword = params.password
					passwordChanged = 'true'
				}
			}
			u.login = params.email  //email is the default login
			u.firstName = params.firstName
			u.lastName = params.lastName
			u.email = params.email
			if(u.validate()) {
				u.save()
				
				//			if(params.newsletter && !u.newsletter) {
				//				new Subscription(type:SubscriptionType.NEWSLETTER, user:u).save()
				//			}
				
				try {
					sendMail {
						to u.email
						subject "Profile Update"
						body view:"/emails/confirmProfileUpdate",
						model:[user:u, password:passwordChanged]
					}					
				}
				catch(Exception e) {
					log.error "Problem sending email $e.message", e
				}
				//redirect(controller:"store", action:"shop")
				flash.message = "Profile updated."
				redirect(controller:"home", action:"index")
			}
			else {
				u.password = params.password
				return [user:u]
			}					
		}
		else {
			User u = request.user
			return [user:u]
		}
	}
	// This is used to pop-up the light-box to get the user to identify 
	// if they are a student or non-student
	def joinToday = {
		
	}
	
	def register = {
		org.jsecurity.SecurityUtils.getSubject().logout()
		def sqList = SecurityQuestion.list()
		def user = new User(params)
		def profile = new MemberProfile(params)
		def  systemConfig = SystemConfig.get(1)
		def source = systemConfig.defaultSource
		def friend
        println params
        if (params.friendEmail) {
              source = Source.findBySourceName("friend")
              user.email = params.friendEmail
			  println "Friend email: " + user.email
              params.friendEmail=""
        }
		else if (params.friendId) {
			 	friend = User.get(params.friendId)
				source = Source.findBySourceName("friend")
				println "Found friend: " + friend
			}
		else if (params.coupon) {
              params.coupon = params.coupon.toLowerCase()
              source = Source.findByCoupon(params.coupon)
			  if (source) {
				  	setCookie('source', source.id)
					  println "Saved source cookie for source: " + source
			  }
        }
		else if (foundCookie('source')){
			source = Source.get(foundCookie('source').value)
			println "Setting source from cookie: " + source 
		}
		if(request.method == 'POST') {
			if (!source) {
				source = Source.get(1)
			}
            user.login = params.email?.toLowerCase()  //email is the default login
            user.email = params.email?.toLowerCase()
            user.securityQuestion = SecurityQuestion.get(params.securityQuestion?.id);
            user.memberProfile = profile
            user.source = source
			def role = Role.findByName('USER')
			if (params?.role) {
				role = Role.get(params.role)
				//assume non players are post highschool.
				user.memberProfile.grade = 13
			}
            if (user.validate() && (user.password == params.confirm)) {
                user.textPassword = user.password
                user.password = new Sha1Hash(user.password).toHex()
                user.calcDivision()
                user.addToRoles(role)
                user.save(flush:true)
                //				if(params.newsletter) {
                //					new Subscription(type:SubscriptionType.NEWSLETTER, user:u).save()
                //				}
				
				// Create a prospect for crediting the friend if this was a refferal
				if (friend) {
					def prosp = new Prospect(email:user.email, source:source, user:friend)
					if (prosp.validate()) {
					  prosp.save()
					}
					else {
					  println "Failed to validate prospect " . prosp.errors
					}
				}
				 
                if (systemConfig.regEmailOn) {
                    try {
                        sendMail {
                            to user.email
                            subject "ESMZONE Registration"
                            body view:"/emails/confirmRegistration",
                                 model:[user:user]
                        }
                        //redirect(controller:"store", action:"shop")
                        flash.message = "Registration confirm email sent to " + user.email + ". Please click the link in the email to activate your account. Check your spam folder if you don't see them email"
                        // send invitation emails to the friends invited
                        println "Redirecting to registrationConfirm : " + user.email
                        redirect(action: "registrationConfirm", params:["regEmail":user.email])
                    }
                    catch(Exception e) {
                        log.error "Problem sending email $e.message", e
                        flash.message = "Failed to send registration email to $user.email " + e.message
                    }
                }
                else {
                  println "!!!Email not sent. regEmailOn is flase. Redirecting to registrationConfirm : " + user.email
                  redirect(action: "registrationConfirm", params:["regEmail":user.email])
                }
            }
            else { // user validation failed
                if (user.password && (user.password != params.confirm)) {
                  user.errors.rejectValue("password","Passwords don't match.")
                }
                return [securityQuestionList: sqList, user:user, profile:profile, source:source, coupon:params.coupon, friend:friend, role: params.role]
            }
        }
        // non-post logic
		return [securityQuestionList: sqList, user:user, coupon:params.coupon, source:source, friend:friend, role:params.role]
	}

	def registrationConfirm = {
        println "In registration Confirm"
        if(request.method == 'POST') {
	        def user = User.findByEmail(params.regEmail)
	        def source = Source.findBySourceName("friend")

            def prospect
            (1..6).each { seq ->
                def parmName = "prospect"+seq
                prospect = params."$parmName"
                // make sure user isn't already registered
                if (prospect && !(User.findByEmail(prospect))) {
                    try {
                        sendMail {
                            to prospect
                            subject "You have been recruited"
                            body view:"/emails/inviteFriend",
                                 model:[user:user, prospect:prospect]
                        }
                        def prosp = new Prospect(email:prospect, source:source, user:user)
                        if (prosp.validate()) {
                          prosp.save()
                        }
                        else {
                          println "Failed to validate prospect " . prosp.errors
                        }
                    }
                    catch(Exception e) {
                        log.error "Problem sending friend invitation email $e.message", e
                    }
                }
            }
            redirect(controller:"home", action:"index")
        } // end POST processing
	}

	def facebookConfirm = {
		println params
		// OnLoadFunction will be used if a Facebook friend invitation was clicked otherwise it will be left empty
		def onLoadFunction

		def userId = this.checkFacebookSession()
		println "In facebook registration Confirm. userId : " + userId.toString() 
		def user = User.findByLogin(userId)
		request.user = user

		//hc.fbContent() doesn't work until setting the user in the request
		def hc = new HomeController()
		def fbAction = "http://${request.getServerName()}/esmzone/facebookConfirm"
		def fbContent = hc.fbContent()

		//Initialize email to the user email if it's not passed in as a parmeter
		//   In the speical case where an email is defaulted to the Facebook login, do use the temporary email.
		//   This temporary email was just a placeholder to save the user record.
		if (!(params.email || user?.email?.contains(user?.login))) {
			params.email = user?.email
		}

		// Initialize the grade. It is not expected that the grade will be set in the user but
		// in case logic is added to impute the grade from a birthday in the future it might be set.
		if (!params.grade) {
			params.grade = user?.memberProfile?.grade
		}

		if((request.method == 'POST') && userId) {
			def error = false
			if (!params.email) {
				flash.message = "Email is required."
				error = true
			}
			else {
				user.email = params.email
			}
			if (!params.grade) {
				if (error) {
					flash.message += "<br>Grade is required."
				}
				else {
					flash.message = "Grade is required."
				}
				error = true
			}
			if (!error) {
				if (!user.memberProfile) {
					user.memberProfile = new MemberProfile(params)
				}
				user.memberProfile.grade = params.int("grade")
				if (!user.validate()) {
					println user.errors
					error = true
				}
				else {
					user.save()
				}
				//If the user clicked invite friends link, we may have to pop-up the facebook friend invitation.
				//This is because we don't want to loose any data they inputted and the invite friend pop-up
				//redirect the page to a new URL effectively discarding any input on this page. Instead
				//we do a submit of the page and then auto-popup the facebook invite using that to redirect to the next 
				//page.
				if (params.inviteFriends) { 
					onLoadFunction = "fb_inviteFriends();"
				}
				else {
					println "Redirecting to confirmRegistration"
					redirect(action:"confirmRegistration", id:user.id)
					return
				}
			} // end error for missing fields
		} // end POST processing
		return [user:user, fbContent:fbContent, fbAction: fbAction, onLoadFunction:onLoadFunction]
	}

	def confirmRegistration = {
		println "Entering Confirm Registration for " + params.id
		def user = User.get(params.id)
		if (user && (user.status == UserStatus.PENDING)) {
			User.withTransaction {
				user.status = UserStatus.ACTIVE
				// Free membership during alpha/beta
				def paymentMethod = PaymentMethod.findByName("Free Promo")
				def subscriptionType = SubscriptionType.findByName("Annual")
				def subscription = new  Subscription(subscriber:user, subscriptionType:subscriptionType, firstName:user.firstName,lastName:user.lastName, email:user.email, address:user.address, paymentMethod:paymentMethod)
				if (subscription.save()) {
					user.addToSubscriptions(subscription)
					if (user.save(flush:true)) {
						def loginError = this.loginUser(user)
						if (loginError) {
							println "Registration confirmed. Please login."
							flash.message = "Registration confirmed. Please login."
						} else {
							println "Login succeded."
						}
					}
				}
				else {
					def error = "Registration confirmation failed: ${subscription.errors}"
					flash.message = "Registration confirmation failed: ${subscription.errors}"
				}
			}
		}
		redirect(controller:"home", action:"index")
	}
	
	def logout = {
		org.jsecurity.SecurityUtils.getSubject().logout()
		redirect(controller: 'home',action:'index')
	}
	
}

class LoginCommand {
	String login
	String password
	
	def jsecSecurityManager
	
	boolean authenticate() {
		def result = false
		def user = User.findByEmail(login)
		if (user) {
			// set the login to the database value to handle users with Facebook ids
			this.login = user.login
			result = true
		}
		return result
	}
	static constraints = {
		login blank:false, validator:{ val, cmd ->
			if(!cmd.authenticate())
			return "user.invalid.login"
		}
		password blank:false
	}
}
