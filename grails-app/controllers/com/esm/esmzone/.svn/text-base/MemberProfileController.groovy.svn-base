package com.esm.esmzone

import grails.converters.JSON
import org.compass.core.engine.SearchEngineQueryParseException
import org.springframework.util.ClassUtils
import com.esm.dialog.*
import org.jsecurity.crypto.hash.Sha1Hash

class MemberProfileController {
	def searchableService
		
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def index = {
		redirect(action: "list", params: params)
	}
	
	def list = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		[memberProfileInstanceList: MemberProfile.list(params), memberProfileInstanceTotal: MemberProfile.count()]
	}
	
	def create = {
		def memberProfileInstance = new MemberProfile()
		memberProfileInstance.properties = params
		return [memberProfileInstance: memberProfileInstance]
	}
	
	def save = {
		def memberProfileInstance = new MemberProfile(params)
		if (memberProfileInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), memberProfileInstance.id])}"
			redirect(action: "show", id: memberProfileInstance.id)
		}
		else {
			render(view: "create", model: [memberProfileInstance: memberProfileInstance])
		}
	}
	
	def show = {
		def memberProfileInstance = MemberProfile.get(params.id)
		if (!memberProfileInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
			redirect(action: "list")
		}
		else {
			[memberProfileInstance: memberProfileInstance]
		}
	}

	def view = {
		if (!request.user) {
			redirect(controller:"home", index:"index")
			return
		}
		request.menu = "people"
		if (!params.userId) {
			params.userId = request?.user?.id
		}
		def userInstance = User.get(params.userId)
		MemberProfile memberProfileInstance = userInstance.memberProfile
		def result = []
		Integer postInstanceTotal = (params.offset)?params.int("offset"):0
		if (!memberProfileInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile')])}"
			redirect(controller: "memberProfile", action: "profile")
		}
		else {
			params.max = Math.min(params.max ? params.int('max') : 5, 100)
			def postController = new PostController()
			result = postController.doSearch(params, searchableService)
		}
		return result + [memberProfileInstance: memberProfileInstance, userInstance:userInstance]
	}

	def editProfileInfo = {
		def userInstance = User.get(request?.user?.id)
		def orgPassword = userInstance?.password
		userInstance?.properties = params
		def memberProfileInstance = MemberProfile.get(userInstance?.memberProfile?.id)
		memberProfileInstance?.properties = params
		if(request?.method == 'POST') {
			def passwordChanged
			if (params?.password) {
				if(params.password != params.confirm) {
					userInstance.password = params.password
					userInstance.errors.rejectValue("password", "user.password.dontmatch")
					return [userInstance:userInstance, memberProfileInstance:memberProfileInstance]
				}
				else {
					userInstance.password = new Sha1Hash(params.password).toHex()
					userInstance.textPassword = params.password
					passwordChanged = 'true'
				}
			}
			else {
				userInstance.password = orgPassword
				println userInstance.password
			}
			println userInstance.login
			println userInstance.email
			//email is used for the login for non-Facebook users
			if (userInstance.email == userInstance.login) {
				userInstance.login = params.email.toLowerCase()
			}  
			userInstance.calcDivision() // update the division if needed based on grade
			userInstance.email = params.email.toLowerCase()
			if(userInstance.validate()) {
				userInstance.save()
	//			if(params.newsletter && !u.newsletter) {
	//				new Subscription(type:SubscriptionType.NEWSLETTER, user:u).save()
	//			}
				try {
					sendMail {
						to userInstance.email
						subject "Profile Update"
						body view:"/emails/confirmProfileUpdate",
								model:[user:userInstance, password:passwordChanged]
					}					
				}
				catch(Exception e) {
					log.error "Problem sending email $e.message", e
					flash.message = "Problem sending email $e.message " + e
					return [userInstance:userInstance, memberProfileInstance:memberProfileInstance]
				}
			}
			else {
				userInstance.password = params.password
				return [userInstance:userInstance, memberProfileInstance:memberProfileInstance]
			}					
			def school
			if (params.currentSchoolAuto_id) {
				school = School.get(params.currentSchoolAuto_id)
				memberProfileInstance.currentSchool = school
			}
			def formerSchool
			def formerSchools = memberProfileInstance.formerSchools
			(1..3).each { seq -> 
				def parmName = "formerSchoolAuto"+seq+"_id"
				def schoolId = params."$parmName"
				if (schoolId) {
					if (formerSchools.size() >= seq) {
						formerSchool = formerSchools.toArray()[seq-1]
						memberProfileInstance.removeFromFormerSchools(formerSchool)
					}
					school = School.get(schoolId)
					memberProfileInstance.addToFormerSchools(school)
				}
			}
			if(memberProfileInstance.validate()) {
				memberProfileInstance.save() // save the user connect and the profile record
			}
			else {
				return [memberProfileInstance:memberProfileInstance] // failed to validate return with errors
			}
			if (params?.wantToMentor) {
			    //chain(action:"mentorProfile", model:[memberProfileInstance:memberProfileInstance], params:params)
				chain(action:"mentorProfile", params: params)
			}
			else {
				if (params?.needMentor) {
					chain(action:"menteeProfile", params: params)
				}
			}
			flash.message = "Your profile information has been saved!"
			redirect(action:"editProfileInfo")
		}
		return [userInstance:userInstance, memberProfileInstance:memberProfileInstance]
	}

	def editProfileInterests = {
		def userInstance = User.get(request?.user?.id)
		def profile = MemberProfile.get(userInstance?.memberProfile?.id)

		if(request?.method == 'POST') {
			println params
			
			userInstance?.properties = params
			profile?.properties = params
			def sport, subject
			
			def playedSports = profile.playedSports
			def favoriteSports = profile.favoriteSports
			def favoriteSubjects = profile.favoriteSubjects
			def leastFavoriteSubjects = profile.leastFavoriteSubjects
			def strongestSubjects = profile.strongestSubjects
			
			(1..3).each { seq ->
				def curSport = profile.getPlayedSport(seq)
				if (curSport) {
					profile.removeFromPlayedSports(curSport)
				}
				def parmName = "playedSports"+seq
				def sportId = params."$parmName"
				if (sportId != 'null') {
					sport = Sport.get(sportId)
					profile.addToPlayedSports(sport)
				}
			}
			(1..2).each { seq -> 
				def curSport = profile.getFavoriteSport(seq)
				if (curSport) {
					profile.removeFromFavoriteSports(curSport)
				}
				def parmName = "favoriteSports"+seq
				def sportId = params."$parmName"
				if (sportId != 'null') {
					if (favoriteSports?.size() >= seq) {
						def favoriteSport = favoriteSports?.toArray()[seq-1]
						profile.removeFromFavoriteSports(favoriteSport)
					}
					sport = Sport.get(sportId)
					profile.addToFavoriteSports(sport)
				}
			}
			(1..2).each { seq -> 
				def curSubject = profile.getFavoriteSubject(seq)
				if (curSubject) {
					profile.removeFromFavoriteSubjects(curSubject)
				}
				def parmName = "favoriteSubjects"+seq
				def subjectId = params."$parmName"
				if (subjectId != 'null') {
					if (favoriteSubjects?.size() >= seq) {
						def favoriteSubject = favoriteSubjects?.toArray()[seq-1]
						profile.removeFromFavoriteSubjects(favoriteSubject)
					}
					subject = Subject.get(subjectId)
					profile.addToFavoriteSubjects(subject)
				}
			}
			(1..2).each { seq -> 
				def curSubject = profile.getLeastFavoriteSubject(seq)
				if (curSubject) {
					profile.removeFromLeastFavoriteSubjects(curSubject)
				}
				def parmName = "leastFavoriteSubjects"+seq
				def subjectId = params."$parmName"
				if (subjectId != 'null') {
					if (leastFavoriteSubjects?.size() >= seq) {
						def leastFavoriteSubject = leastFavoriteSubjects?.toArray()[seq-1]
						profile.removeFromLeastFavoriteSubjects(leastFavoriteSubject)
					}
					subject = Subject.get(subjectId)
					profile.addToLeastFavoriteSubjects(subject)
				}
			}
			(1..2).each { seq -> 
				def curSubject = profile.getStrongestSubject(seq)
				if (curSubject) {
					profile.removeFromStrongestSubjects(curSubject)
				}
				def parmName = "strongestSubjects"+seq
				def subjectId = params."$parmName"
				if (subjectId != 'null') {
					if (strongestSubjects?.size() >= seq) {
						def strongestSubject = strongestSubjects?.toArray()[seq-1]
						profile.removeFromStrongestSubjects(strongestSubject)
					}
					subject = Subject.get(subjectId)
					profile.addToStrongestSubjects(subject)
				}
			}
			
			if(profile.validate()) {
				profile.save() // save the user connect and the profile record
				redirect (action:editProfileInterests)
			}
		}
		//profile.playedSports.each { println it }
		return [userInstance:userInstance, memberProfileInstance:profile]
	}

	def editProfileFans = {
		def userInstance = User.get(request?.user?.id)
		return [userInstanceList:userInstance.connectionList()]
	}

	def edit = {
		def memberProfileInstance = MemberProfile.get(params.id)
		if (!memberProfileInstance) {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
			redirect(action: "list")
		}
		else {
			return [memberProfileInstance: memberProfileInstance]
		}
	}
	
	def update = {
		def memberProfileInstance = MemberProfile.get(params.id)
		if (memberProfileInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (memberProfileInstance.version > version) {
					
					memberProfileInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'memberProfile.label', default: 'MemberProfile')] as Object[], "Another user has updated this MemberProfile while you were editing")
					render(view: "edit", model: [memberProfileInstance: memberProfileInstance])
					return
				}
			}
			memberProfileInstance.properties = params
			School school
			if (params.currentSchool_id) {
				school = School.get(params.currentSchool_id)
				if (school) {
					memberProfileInstance.currentSchool = school
				}
				else {
					memberProfileInstance.currentSchool = null
				}
			}
			def currentSchool = memberProfileInstance.currentSchool
			if (!memberProfileInstance.hasErrors() && memberProfileInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), memberProfileInstance.id])}"
				redirect(action: "show", id: memberProfileInstance.id)
			}
			else {
				render(view: "edit", model: [memberProfileInstance: memberProfileInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
			redirect(action: "list")
		}
	}
	
	def delete = {
		def memberProfileInstance = MemberProfile.get(params.id)
		if (memberProfileInstance) {
			try {
				memberProfileInstance.delete(flush: true)
				flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
				redirect(action: "list")
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
				redirect(action: "show", id: params.id)
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'memberProfile.label', default: 'MemberProfile'), params.id])}"
			redirect(action: "list")
		}
	}

	def selectAvatar = {
		def user = User.get(request?.user?.id)
		def memberProfileInstance = user.memberProfile
		if (user && params.avatar.id) {
			def avatar = Avatar.get(params.long("avatar.id"))
			if (avatar) {
				memberProfileInstance.avatar = avatar
				if (memberProfileInstance.validate()) {
	                memberProfileInstance.save()				
				}
			}
		}
		redirect(action:"profile")
	}

	def editProfileAvatar = {
		def userInstance = User.get(request?.user?.id)
  	    def memberProfileInstance = MemberProfile.get(userInstance?.memberProfile?.id)
		def systemConfig = SystemConfig.get(1)
		println systemConfig
		println systemConfig.avatarUrl
		def avatar = memberProfileInstance?.avatar
		if (!avatar) {
			avatar = new Avatar(name:userInstance.toString() + userInstance.id, user:userInstance)
			println "Creating new avatar " + avatar
		}
		if(request?.method == 'POST') {
		    def f = request.getFile("avatarFile")
			def avatarFilePath = systemConfig.avatarFilePath
		    if(!f.empty) {
			   f.transferTo( new File(avatarFilePath + userInstance.id + ".png" ))
 			   avatar?.filename = userInstance.id + ".png"
			   avatar.nobleAvatar = params?.nobleAvatar
			   if (!avatar.save()) {
				   println avatar.errors
			   }
			   memberProfileInstance.avatar = avatar
			   if (!memberProfileInstance.save()) {
				  println memberProfileInstance.errors
				  flash.message = "Failed to update avatar"
			   }
			    println "Saved avatar: " + avatar + avatar.id
				flash.message = "Your profile information has been saved!"
				redirect(action:"editProfileAvatar")
		    }
		}
		return [userInstance:userInstance, memberProfileInstance:memberProfileInstance, avatarInstance:avatar, avatarUrl:systemConfig.avatarUrl]
	}

	def uploadAvatar = {
		println params
		if(request?.method == 'POST') {
			println "Starting uploadAvatar"
		    def f = request.getFile("avatarFile")
			println "file retrieved" + f
		    if(!f.empty) {
			   println "File not empty. Starting save"
			   def user = User.get(params?.id)
			   println "Found user : " + params?.id + " " + user
			   def avatarFilePath = SystemConfig.get(1).avatarFilePath
			   f.transferTo( new File(avatarFilePath + user.id + ".png" ))
 			   println "completed save"
 			   def memberProfileInstance = MemberProfile.get(user?.memberProfile?.id)
 			   def avatar = memberProfileInstance?.avatar
 			   if (!avatar) {
				   avatar = new Avatar(name:user.firstName + " " + user.lastName + "." + user.id)
			   }
 			   avatar.filename = user.id + ".png"
 			   println avatar.filename
			   avatar.nobleAvatar = params?.nobleAvatar
			   println avatar.nobleAvatar
			   avatar.user = user
			   if (!avatar.save(flush:true)) {
				   println avatar.errors
				   render "Failure"			
			   }
			   memberProfileInstance.avatar = avatar
			   if (!memberProfileInstance.save()) {
				  println memberProfileInstanc.errors
				  flash.message = "Failed to update avatar"
				  render "Failure"
			   }
		    }
			println "Success"
			render "Success"
		}
	}
	
    def selectSchool = {
		
	}
	
	def schoolAutocomplete = { 
		def list = School.findAllByNameLike("%${params.query}%")
		def jsonList = list.collect { [ id: it.id, name: it.name ] }
		def jsonResult = [
				result: jsonList
				]
		render jsonResult as JSON
	} 	

	def editProfile = {
		def user = User.get(request?.user?.id)
		def memberProfileInstance = MemberProfile.get(user?.memberProfile?.id)
		if (!memberProfileInstance){
			memberProfileInstance = new MemberProfile()
		}
		if(request?.method == 'POST') {
			memberProfileInstance.properties = params
			def school
			if (params.currentSchoolAuto_id) {
				school = School.get(params.currentSchoolAuto_id)
				memberProfileInstance.currentSchool = school
			}
			def formerSchool
			def formerSchools = memberProfileInstance.formerSchools
			(1..3).each { seq -> 
				def parmName = "formerSchoolAuto"+seq+"_id"
				def schoolId = params."$parmName"
				//println("Current school in seq:" + seq + " " + formerSchools.toArray()[seq-1])
				if (schoolId) {
					if (formerSchools.size() >= seq) {
						formerSchool = formerSchools.toArray()[seq-1]
						memberProfileInstance.removeFromFormerSchools(formerSchool)
					}
					school = School.get(schoolId)
					memberProfileInstance.addToFormerSchools(school)
				}
			}
			if(memberProfileInstance.validate()) {
				memberProfileInstance.save() // save the user connect and the profile record
			}
			else {
				return [memberProfileInstance:memberProfileInstance] // failed to validate return with errors
			}
			if (params?.wantToMentor) {
			    //chain(action:"mentorProfile", model:[memberProfileInstance:memberProfileInstance], params:params)
				chain(action:"mentorProfile", params: params)
			}
			else {
				if (params?.needMentor) {
					chain(action:"menteeProfile", params: params)
				}
				else {
					redirect(action:"view")
				}
			}
		}
		else {
			if (!memberProfileInstance) {
				memberProfileInstance = new MemberProfile()
			}
			return [memberProfileInstance:memberProfileInstance]
		}
		
	}
	
	def mentorProfile = { MentorProfileCommand cmd ->
		//def memberProfileInstance = chainModel.memberProfileInstance
		def memberProfileInstance = MemberProfile.get(params.id)
		if (cmd.hasErrors()) { // if this is mentor insure they have a complete profile
			render(view:"profile", model: [memberProfileInstance:memberProfileInstance, mentorProfileCommand:cmd])
			return
		}
		else {
			def user = User.get(request?.user?.id)
			if (user.readyForMentorApplication()) { // mentor is ready for another application
				redirect(controller: "mentorApplication", action:"apply")
				return
			}
			else {
				redirect(action:"view")
				return
			}
		}
	}
	
	def menteeProfile = { MentorProfileCommand cmd ->
		//def memberProfileInstance = chainModel.memberProfileInstance
		def memberProfileInstance = MemberProfile.get(params.id)
		if (cmd.hasErrors()) { // if this is mentor insure they have a complete profile
			render(view:"profile", model: [memberProfileInstance:memberProfileInstance, mentorProfileCommand:cmd])
			return
		}
		else {
			if (params?.mentor) {
				redirect(controller:"networkConnection", action:"requestMentor",id:mentor)
			}
			else {
				redirect(controller:"user", action:"selectMentor")
			}
		}
	}
}

class MentorProfileCommand {
	String favoriteProPlayer
	String favoriteProTeam
	String favoriteMovie
	String roleModel
	String careerInterests
	String favoriteActivities
	Integer grade
	String gainFromSite
	Boolean wantToMentor
	List favoriteSports
	List playedSports
	List favoriteSubjects
	List leastFavoriteSubjects
	List strongestSubjects
	List collegeInterest
	List formerShcools
	
	static constraints = {
		favoriteProPlayer blank:true,nullable:true
		favoriteProTeam blank:true,nullable:true
		favoriteMovie blank:true,nullable:true
		roleModel blank:true,nullable:true
		careerInterests blank:true,nullable:true
		favoriteActivities blank:true,nullable:true
		grade nullable:false
		gainFromSite blank:true,nullable:true
		wantToMentor nullable:true
		favoriteSubjects nullable:true
		favoriteSports validator: {val, obj -> if (!val?.size()) { return false	} }
		playedSports validator: {val, obj -> if (!val?.size()) { return false }	}
		leastFavoriteSubjects validator: {val, obj -> if (!val?.size()) { return false }	}
		strongestSubjects validator: {val, obj -> if (!val?.size()) { return false }	}
	}
}

