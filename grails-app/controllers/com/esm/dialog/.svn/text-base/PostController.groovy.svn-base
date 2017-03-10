package com.esm.dialog

import com.esm.esmzone.*
import com.esm.cms.*;
import org.compass.core.engine.SearchEngineQueryParseException
import org.springframework.util.ClassUtils
import org.jsecurity.SecurityUtils

class PostController {
	def searchableService

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
	
	Object doSearch(paramList, searchableService, contentPage=null, filter=false, tagInstanceList=null) {
		def user = request?.user
		def resultsList = []
		def postInstanceList = []
		if (!paramList.homeTab) {
			paramList.homeTab = 'Everyone'
		}
		def pageMax = paramList.max
		def offset = (paramList.offset)?paramList.int("offset"):0
		//need to retrieve more records since they will be filtered outside of the query
		paramList.max = 1000
		paramList.offset = 0
		def userInstance
		if (paramList.userId) {
			userInstance = User.get(params.userId)
		}
		if (!paramList.q?.trim()) {
			paramList.sort = "score"
			paramList.order = "desc"
			resultsList =  Post.createCriteria().list(paramList) {
				postType {
						'in'('name', [PostTypeName.QUESTION,PostTypeName.FEEDBACK])
				}
			}
		}
		else {
			try {
				def postResult
				def postInstance
				def searchResult = searchableService.search(paramList?.q, paramList)
				searchResult?.results.each {
					def className = ClassUtils.getShortName(it.getClass())
					switch (className) {
						case 'Post':
							postResult = it
							break
						case 'Answer':
						case 'PostComment':
							postResult = it.post
							break
						case 'AnswerComment':
							postResult = it.answer.post
							break
						default:
							postResult = null
							break
					}
					postInstance = Post.get(postResult?.id)
					if (postInstance && !resultsList.contains(postInstance) && (postInstance.postType.name in [PostTypeName.QUESTION, PostTypeName.FEEDBACK])) {
						resultsList.add(postInstance)
					}
				} //each search result 
			} 
			catch (SearchEngineQueryParseException ex) {
				return [parseException: true]
			}
		}
		//need to repopulate the autoCompleteId after the initial selection 
		//It only comes back after the school is initiall inputted.
		def school_id
		if (params.schoolAutoInput_id) {
			school_id = params.school_id
		}
		def add
		Integer postInstanceTotal = 0
		def index = 0
		resultsList.sort {a,b-> (b.dateCreated > a.dateCreated)? 1:0}
		resultsList.each { postInstance ->
			index++
			add = false
			if ((!postInstance.complaint) && (!filter || doFilter(paramList,postInstance))) {
				switch (paramList.homeTab) {
					case "Everyone":
						if (postInstance.postType.audience == PostTypeAudience.PUBLIC) {
							if (paramList.userId) { 
								if (postInstance.author == userInstance) {
									add = true
								}
							}
							else {
								add = true
							}
						}
						break
					case "Mine":
						if ((postInstance.author == user) && (postInstance.postType.audience == PostTypeAudience.PUBLIC)) {
							add = true
						}
						break
					case "Fans":
					// any fan is author and it's public or private directed to member
						if ((user.amFan(postInstance.author) || user.isFan(postInstance.author)) &&  
						(postInstance.postType.audience == PostTypeAudience.PUBLIC)) { 
							add = true
						}
						break
					case "Mentors":
					// any converstaion between mentor and member
						if (user.myMentor(postInstance.author) && (postInstance.postType.audience == PostTypeAudience.PUBLIC)) { 
							add = true
						}
						break
					case "Private":
					// any private conversation with member
						if (postInstance.postType.audience != PostTypeAudience.PUBLIC) {
						  	if (userInstance) {
						  		if (
						  			((postInstance.author == userInstance) && (postInstance.member == request?.user)) ||
								    ((postInstance.member == userInstance) && (postInstance.author == request?.user))
								   ) {
								
								   add = true
								}
						  	}
						  	else if ((postInstance?.author == request?.user) || (postInstance?.member == request?.user)) {
								add = true
							}
						}
						break
				}
			} //end filter
			if (add) {
				postInstanceTotal++
				if ((postInstanceList.size() < pageMax) && (postInstanceTotal > offset)) {
					postInstanceList.add(postInstance)
					//println "==> Added " +  postInstance.toString() + " -> Complaint: " +  postInstance.complaint.toString()
				}
			}		
		}
		paramList.max = pageMax
		paramList.offset = offset
		return [contentPage:contentPage, postInstanceList: postInstanceList, postInstanceTotal: postInstanceTotal, tagInstanceList:tagInstanceList, q:paramList?.q, tags:params.tags, mentors:params.mentors, answers:params.answers, rating:params.rating, gender:params.gender, grade:params.grade, playedSport:params.playedSport, school:params.schoolAutoInput, school_id:school_id, city:params.city ]
	}
	
	Boolean doFilter(paramList, postInstance) {
		println params
		def author = postInstance?.author
		if ((paramList.gender) && (author.gender != params.gender)) {
			return false
		}
		if ((paramList.grade) && (author?.memberProfile?.grade != params.int("grade"))) {
			return false
		}
		if ((paramList.playedSport) && (!author?.memberProfile?.playedSports.contains(Sport.get(params.playedSport)))) {
			return false
		}
		if ((paramList.schoolAutoInput_id) && (author?.memberProfile?.currentSchool != School.get(params.schoolAutoInput_id))) {
			return false
		}
		if ((paramList.city) && (author?.address?.city.toLowerCase() != paramList.city.toLowerCase())) {
			return false
		}
		if (paramList.answers){
			def answerCount = postInstance?.answers?.size()
			switch (paramList.int("answers")) {
				case 0: // 0 
					if (answerCount > 0) return false
					break

				case 1: // 1
					if (answerCount != 1) return false
					break

				case 2: // less than 5 
					if ((answerCount < 2) || (answerCount > 5)) return false
					break
				
				case 3: // at least 10
					if (answerCount < 10) return false
					break
			 }
		}		
		if (paramList.rating){
			def averageRating = postInstance?.averageRating
			// Closure to determine if the avgerageRating falls in the desired range
			def compareRating = { avg, rating -> ((avg > rating - 0.66) && (avg <= rating + 0.33))?true:false }
			// do the comparison
			if (!compareRating(postInstance?.averageRating, paramList.int("rating"))) {
				return false
			}
		}		
		return true
	}
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
        [postInstanceList: Post.list(params), postInstanceTotal: Post.count()]
    }

	def search = {
		request.menu = "search"
		params.max = Math.min(params.max ? params.int('max') : 5, 100)
		def tagInstanceList =  Tag.createCriteria().list() {
			gt('postCount',0)
			maxResults(30)
			order('postCount', 'desc')
		}
		if (params.tag) {
			redirect(action:"tagDirectory", id:params.tag)
			return
		}		
		def contentPage = this.activeContent(controllerName, actionName)
		return doSearch(params, searchableService, contentPage, true, tagInstanceList)
	}
	
    def directory = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
		def directoryTitle
		if (!params.sort) {
			params.sort = 'score'
			params.order = 'asc'
		}
		if (params.title) {
			directoryTitle = params.title
		}
		else if (params.sort == 'dateCreated') {
			directoryTitle = "Recent Questions"
		}
		else {
			directoryTitle = "Top Questions"
		}
		
		def postInstanceList =  Post.createCriteria().list(params) {
			postType {
				eq('name', PostTypeName.QUESTION)
				eq('audience', PostTypeAudience.PUBLIC)
			}
        }
        [postInstanceList: postInstanceList, postInstanceTotal: postInstanceList.size(), directoryTitle:directoryTitle]
    }

    def postDirectory = {
        params.max = Math.min(params.max ? params.int('max') : 100, 100)
		if (!params.sort) {
			params.sort = 'dateCreated'
			params.order = 'desc'
		}
		def postInstanceList
		def user
		if (params.id) {
			user = User.get(params.id)
			postInstanceList =  Post.createCriteria().list(params) {
				postType {
					eq('name', PostTypeName.SOCIAL)
					eq('audience', PostTypeAudience.PUBLIC)
				}
				eq('author',user)
			}
		}
		else {
			postInstanceList =  Post.createCriteria().list(params) {
				postType {
					eq('name', PostTypeName.SOCIAL)
					eq('audience', PostTypeAudience.PUBLIC)
				}
			}
		}
        [postInstanceList: postInstanceList, postInstanceTotal: postInstanceList.size(), userInstance:user]
    }


	def searchPosts = {
		if (!params.q?.trim()) {
			params.title = 'Search Results'
			redirect(action:"directory", params:params)
		}
		else {
			try {
				def postInstanceList = []
				def postInstance
				def postResult
				def searchResult = searchableService.search(params.q, params)
				searchResult?.results.each {
					def className = ClassUtils.getShortName(it.getClass())
					switch (className) {
						case 'Post':
							postResult = it
							break
						case 'Answer':
						case 'PostComment':
							postResult = it.post
							break
						case 'AnswerComment':
							postResult = it.answer.post
							break
						default:
							postResult = null
						    break
					}
					postInstance = Post.get(postResult?.id)
					if (postInstance && !postInstanceList.contains(postInstance)) {
						postInstanceList.add(postInstance)
					}
				}
				render(view:'directory', model:[postInstanceList:postInstanceList, postInstanceTotal: postInstanceList.size(), directoryTitle:'Search Results'], q:params.q)
			} catch (SearchEngineQueryParseException ex) {
				return [parseException: true]
			}
		}
	}

	def tagDirectory = {
		request.menu = "search"
		def tag = Tag.get(params?.id)
		def tagInstanceList =  Tag.createCriteria().list() {
			gt('postCount',0)
			maxResults(30)
			order('postCount', 'desc')
		}
		if (!tag) {
			params.title = 'Search Results'
			redirect(action:"search", params:params)
		}
		else {
			def postInstanceList =  Post.createCriteria().list(params) {
				postType {
					eq('name', PostTypeName.QUESTION)
					eq('audience', PostTypeAudience.PUBLIC)
				}
				tags {
					eq('tag',tag)
				}
				isNull('complaint')
			}
			def directoryTitle = "Search Results for Tag: " + tag
			render(view:'search', model:[postInstanceList:postInstanceList, postInstanceTotal: postInstanceList.size(), tagInstance:tag, tagInstanceList:tagInstanceList])
		}
	}

	def privateDirectory = {
        params.max = Math.min(params.max ? params.int('max') : 20, 100)
		if (!params.sort) {
			params.sort = 'lastUpdated'
			params.order = 'desc'
		}
		def postInstanceList
		if (params?.user) {
			postInstanceList =  Post.createCriteria().list(params) {
				postType {
					eq('name', PostTypeName.QUESTION)
					eq('audience', PostTypeAudience.MEMBER)
				}
				or {
					and {
						eq('author',params.user)
						eq('member',request.user)
					}
					and {
						eq('author',request.user)
						eq('member',params.user)
					}
				}
			}
		}
		else {
			postInstanceList =  Post.createCriteria().list(params) {
				postType {
					eq('name', PostTypeName.QUESTION)
					eq('audience', PostTypeAudience.MEMBER)
				}
				or {
					eq('author',request.user)
					eq('member',request.user)
				}
			}
		}
        [postInstanceList: postInstanceList, postInstanceTotal: postInstanceList.size()]
    }

    def rate = {
    	def postInstance = Post.get(params.id)
		def user = User.get(request.user.id)
		def c = PostRating.createCriteria()
		def postRatingList = c {
			eq('user',user)
			eq('post', postInstance)
		}
		// if never rated and not the author - (author cannot rate)
		if (!postRatingList && (postInstance?.author != user)) {
			postInstance.addToRatings(user:request.user)
			postInstance.save(flush:true)
		}
		// if rated (author could not have rated so no need to check)
		else if (postRatingList && (postInstance.author != user)) {
			def postRating = PostRating.get(postRatingList.toArray()[0].id)
			postRating.incrementRating() 
			postRating.save(flush:true)
		}
		redirect(controller:"post", action:"view",id:postInstance.id)	
    }

    def create = {
        def postInstance = new Post()
        postInstance.properties = params
        return [postInstance: postInstance]
    }

    def add = {
		request.menu = "ask"
		def categoryTags
		def postInstance = new Post()
		postInstance.properties = params
		if(request.method == 'POST') {
            def regComplete = true
            if (!request?.user.gender) {
                regComplete = completeProfile(params)
                // user appears to be persisted with a gender even without explicit save()
                if (!regComplete) {
                  request?.user.gender = null
                }
            }
            def postType
            if (params.member.id != 'null') {
                postType = PostType.findByNameAndAudience(PostTypeName.QUESTION,PostTypeAudience.MEMBER)
            }
            else {
                postType = PostType.findByNameAndAudience(PostTypeName.QUESTION,PostTypeAudience.PUBLIC)
            }
            postInstance.postType = postType
            postInstance.author = request.user
          
			if (postInstance.validate() && regComplete) {
				postInstance.save()
				// add alert to user if postType is not public
				if (postType.audience == PostTypeAudience.MEMBER) {
					def member = postInstance.member
					member.transactionAlert(ESMTransactionType.QUESTION,postInstance.title, postInstance.author,postInstance.id)
				}
				def tag
				if (params.tagAutoInput_id) {
					tag = Tag.get(params.tagAutoInput_id)
				}
				else if (params.tagAutoInput && (params.tagAutoInput != 'null')) { 
					tag = new Tag(name:params.tagAutoInput, user:request.user)
					if (tag.validate()) {
						tag.save(flush:true)
					}
				}
				
				if (tag) {
					postInstance.addToTags(user:request.user, tag:tag)
					if(postInstance.validate()) {
						postInstance.save()
						tag.postCount++
						if (tag.validate()) {
							tag.save()
						}
					}
				}
				redirect(controller: "post", action: "search")
			}
			else {
				return [postInstance: postInstance, categoryTags: categoryTags, params:params]
			}
		}
		else {
			if (params.id) {
				def member = User.get(params.id)
				postInstance.member = member
			}
			return [postInstance: postInstance, categoryTags: categoryTags, params:params]
		}
    }

    def completeProfile(params) {
        def user = User.get(request.user.id)
        def address = user.address
        def profile = user.memberProfile
        if (params.gender) {
            user.gender = params.gender
        }
        if (!address) {
            address = new Address()
        }

        // parse any profile data if entered
        address.state = (params.state != 'null')?params.state:null
        address.city = params.city
        def school
        if (params.schoolAutoInput_id) {
            school = School.get(params.schoolAutoInput_id)
        }
        else if (params.schoolAutoInput) {
            school = School.findByName(params.schoolAutoInput)
        }
        profile.currentSchool = school
        params.currentSchool = school
        def sportList = []
        (1..3).each { seq ->
            def parmName = "playedSports"+seq
            def sportId = params."$parmName"
            if (sportId != 'null') {
                sportList[seq] = sportId
                println "Sport played id"
                println sportId
            }
        }
        def regComplete = false
        if (user.gender && address.city && address.state && profile.currentSchool && (sportList.size() > 0)) {
            regComplete = user.completeRegistration(params.gender, address, school, sportList )
        }
        else {
            if (!address.validate()) {
              user.errors.rejectValue("address", "user.address.citystate")
            }
            if (!user.gender) {
              user.errors.rejectValue("gender", "user.gender.null")
            }
            if (!profile.currentSchool) {
              user.errors.rejectValue("memberProfile", "memberProfile.currentSchool.null")
            }
            if (sportList.size() == 0) {
              user.errors.rejectValue("memberProfile", "memberProfile.playedSports.null")
            }
        }
        return regComplete
    }


    def addShoutOut = {
		def postInstance = new Post()
		def user = User.get(request.user.id)
		postInstance.title = params.title
		if(request.method == 'POST') {
			def postType 
			postType = PostType.findByNameAndAudience(PostTypeName.SOCIAL,PostTypeAudience.PUBLIC)
			postInstance.postType = postType
			postInstance.author = user
			if (postInstance.validate()) {
				postInstance.save()
			}
			else {
				println postInstance.errors
			}
		}
		if (params.popup) {
			redirect(action:"postDirectory")
		}
		else {
			render(template:'shoutOutWidget')
		}
    }

    def addMessage = {
		def postInstance = new Post()
		def user = User.get(request.user.id)
		println "Member: " + params.id
		def	member = User.get(params.id)
		postInstance.title = params.title
		if(request.method == 'POST') {
			def postType 
			postType = PostType.findByNameAndAudience(PostTypeName.SOCIAL,PostTypeAudience.MEMBER)
			postInstance.postType = postType
			postInstance.member = member
			postInstance.author = user
			if (postInstance.validate()) {
				postInstance.save()
				member.transactionAlert(ESMTransactionType.MESSAGE,postInstance.title, user,user.id)
			}
			else {
				println postInstance.errors
			}
		}
		def postInstanceList =  Post.createCriteria().list() {
			postType {
				eq('name', PostTypeName.SOCIAL)
				eq('audience', PostTypeAudience.MEMBER)
			}
			or {
				and {
					eq('author',member)
					eq('member',user)
				}
				and {
					eq('author',user)
					eq('member',member)
				}
			}
			order('dateCreated', 'desc')
		}
		return [postInstanceList:postInstanceList, userInstance:member]
    }

    def feedback = {
		def postInstance = new Post(params)
		def user
		if (request?.user) {
			user = User.get(request.user.id)
		}
		else {
			user = User.get(1)
		}
		def	member = User.get(1)
		if(request.method == 'POST') {
			def postType 
			postType = PostType.findByNameAndAudience(PostTypeName.FEEDBACK,PostTypeAudience.MEMBER)
			postInstance.postType = postType
			postInstance.member = member
			postInstance.author = user
			if (postInstance.validate()) {
				postInstance.save()
			}
			else {
				println postInstance.errors
			}
		}
    }

	def addTag = {
		def postInstance = Post.get(params.id)
		def user = User.get(request.user.id)
		def tag
		if (params.addTagAutoInput_id) {
			tag = Tag.get(params.addTagAutoInput_id)
		}
		else if ((params.addTagAutoInput) && (params.addTagAutoInput != 'null')) {
			tag = Tag.findByName(params.addTagAutoInput)
			if (!tag) {
				tag = new Tag(name:params.addTagAutoInput, user:user)
				if (tag.validate()) {
					tag.save()
				}
				else {
					println tag.errors
					tag = null
				}
			}
		}
		def duplicate = false
		if (tag) {
			postInstance.tags.each {
				if (it.tag == tag) {
					duplicate = true
				}
			}
			if (!duplicate) {
				postInstance.addToTags(user:user, tag:tag)
				postInstance.save()
				tag.postCount++
				tag.save()
			}
		}
		
		redirect(action:"view", id:params.id)
	}

	def modify = {
        def postInstance = Post.get(params.id)
		def user = User.get(request.user.id)
        if (!postInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
        else {
			if(request.method == 'POST') {
				if (params.version) {
					def version = params.version.toLong()
					if (postInstance.version > version) {
						postInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'post.label', default: 'Post')] as Object[], "Another user has updated this Post while you were editing")
						render(view: "modify", model: [postInstance: postInstance])
						return
					}
				}
				postInstance.properties = params
				def postType
				if (postInstance.member) {
					postType = PostType.findByNameAndAudience(PostTypeName.QUESTION,PostTypeAudience.MEMBER)
				}
				else {
					postType = PostType.findByNameAndAudience(PostTypeName.QUESTION,PostTypeAudience.PUBLIC)
				}
				postInstance.postType = postType
				if (!postInstance.hasErrors() && postInstance.save(flush: true)) {
					flash.message = "${message(code: 'default.updated.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])}"
					redirect(action: "view", id: postInstance.id)
				}
				else {
					return [postInstance: postInstance]	
				}
											
			}
			return [postInstance: postInstance]
        }
    }

    def view = {
		request.menu = "search"
		def postInstance = Post.get(params.id)
		if (postInstance.complaint) {
			redirect(action:"search")
			return
		}
		def resultList
		def postInstanceList = []
		def tagList = []
		def tag
		if (postInstance.tags) {
			postInstance.tags.each {
				tagList.add(it.tag)
			}
			resultList =  Post.createCriteria().list() {
				ne('id', postInstance.id)
				postType {
					eq('name', PostTypeName.QUESTION)
					eq('audience', PostTypeAudience.PUBLIC)
				}
				tags {
					'in'('tag',tagList)
				}
			}
			resultList.each { post ->
			   if (!postInstanceList.contains(post)) {
				   postInstanceList.add(post)
				}
			}
		}
        def postCommentInstance 
        def answerInstance 
        def answerCommentInstance
		if(request.method == 'POST') { 
			if (params.target == 'answer') {
				answerInstance = new Answer()
				answerInstance.description = params.answer.description
				answerInstance.author = request?.user
				answerInstance.dateCreated = new Date()
				answerInstance.lastUpdated = new Date()
				answerInstance.post = postInstance
				if (answerInstance.validate()) {
					postInstance.addToAnswers(answerInstance)
					if (postInstance.save(flush:true)) {
						// add alert to author of question
						def member = postInstance.author
						if (member != request.user) {
							member.transactionAlert(ESMTransactionType.ANSWER,answerInstance.description, request.user,postInstance.id)
						}
						flash.message = "${message(code: 'default.created.message', args: [message(code: 'answer.label', default: 'Answer'), ''])}"
						answerInstance = new Answer()
					}
				}
			}
			else if (params.target == 'postComment') {
				postCommentInstance = new PostComment()
				postCommentInstance.description = params.postComment.description
				postCommentInstance.author = request?.user 
				postCommentInstance.dateCreated = new Date()
				postCommentInstance.lastUpdated = new Date()
				postCommentInstance.post = postInstance				
				if (postCommentInstance.validate()) {
					postInstance.addToComments(postCommentInstance)
					if (postInstance.save(flush:true)) {
						flash.message = "${message(code: 'default.created.message', args: [message(code: 'postComment.label', default: 'postComment'), ''])}"
						postCommentInstance = new PostComment()
					}
				}
			}
			else if (params.target == 'answerComment') {
				answerInstance = Answer.get(params.answer.id)
				answerCommentInstance = new AnswerComment()
				answerCommentInstance.description = params.answerComment.description
				answerCommentInstance.author = request?.user
				answerCommentInstance.dateCreated = new Date()
				answerCommentInstance.lastUpdated = new Date()
				answerCommentInstance.answer = answerInstance				
				if (answerCommentInstance.validate()) {
					answerInstance?.addToComments(answerCommentInstance)
					if (answerInstance.save(flush:true)) {
						flash.message = "${message(code: 'default.created.message', args: [message(code: 'answerComment.label', default: 'answerComment'), ''])}"
						answerCommentInstance = new AnswerComment()
						answerInstance = new Answer()
					}
				}
			}
			[postInstance: postInstance, postInstanceList: postInstanceList, postCommentInstance: postCommentInstance, answerInstance: answerInstance, answerCommentInstance: answerCommentInstance, ratingInstance: postInstance]
		}
		else {
			if (!postInstance) {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
				redirect(action: "list")
			}
			else {
				[postInstance: postInstance, postInstanceList: postInstanceList]
			}
		}
    }

    
    def save = {
        def postInstance = new Post(params)
        if (postInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])}"
            redirect(action: "show", id: postInstance.id)
        }
        else {
            render(view: "create", model: [postInstance: postInstance])
        }
    }

    def show = {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postInstance: postInstance]
        }
    }

    def edit = {
        def postInstance = Post.get(params.id)
        if (!postInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postInstance: postInstance]
        }
    }

    def update = {
        def postInstance = Post.get(params.id)
        if (postInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postInstance.version > version) {
                    postInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'post.label', default: 'Post')] as Object[], "Another user has updated this Post while you were editing")
                    render(view: "edit", model: [postInstance: postInstance])
                    return
                }
            }
            postInstance.properties = params
            if (!postInstance.hasErrors() && postInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'post.label', default: 'Post'), postInstance.id])}"
                redirect(action: "show", id: postInstance.id)
            }
            else {
                render(view: "edit", model: [postInstance: postInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def postInstance = Post.get(params.id)
        if (postInstance) {
            try {
                postInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'post.label', default: 'Post'), params.id])}"
            redirect(action: "list")
        }
    }
}
