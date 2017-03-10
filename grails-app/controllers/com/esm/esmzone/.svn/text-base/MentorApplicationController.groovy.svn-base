package com.esm.esmzone

import com.esm.survey.*;

class MentorApplicationController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [mentorApplicationInstanceList: MentorApplication.list(params), mentorApplicationInstanceTotal: MentorApplication.count()]
    }

    def status = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def mentorApplicationInstanceList =  MentorApplication.createCriteria().list(params) {
			eq('mentor', request?.user)
		}
		return [mentorApplicationInstanceList: mentorApplicationInstanceList, mentorApplicationInstanceTotal: mentorApplicationInstanceList.size()]
    }


    def create = {
        def mentorApplicationInstance = new MentorApplication()
        mentorApplicationInstance.properties = params
        return [mentorApplicationInstance: mentorApplicationInstance]
    }

	/* The application has a quiz and the quiz has a survey.
	 * Need to create the mentorApplication and save it.
	 * Then create a mentorQuiz and populate add a survey.
	 * Finally store the application in the user and goto the quiz
	 */
    def apply = {
		def user = User.get(request?.user?.id)
		if (user.isMentor) {
			redirect(action:"status")
		}
		def mentorApplicationInstance
		if (params?.id) {
			mentorApplicationInstance = MentorApplication.get(params?.id)
		}	
		else if (user?.mentorApplications.size() > 0) {
			user.mentorApplications.each { 
				if (it.status in [ApplicationStatus.STARTED,ApplicationStatus.QUIZ,ApplicationStatus.REFERENCES,ApplicationStatus.RESPONSES]) {
					mentorApplicationInstance = it
				}
			}
		}
		if (mentorApplicationInstance) {
			    if (mentorApplicationInstance.status == ApplicationStatus.QUIZ) {
					//create a new quiz
					def survey = new Survey(title: "$user:$mentorApplicationInstance.id")
					def result = survey.generateSurvey(MentorQuiz.surveySize) 
					if (!(result && survey.save())) { // save survey
						flash.message = "${message(code: 'survey.create.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorApplicationInstance.id])}"
						return [mentorApplicationInstance: mentorApplicationInstance]
					}
					def quiz = mentorApplicationInstance.quiz
					quiz.survey = survey
					if (!quiz.save()) {
						flash.message = "${message(code: 'quiz.create.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorApplicationInstance.id])}"
						return [mentorApplicationInstance: mentorApplicationInstance]
					}
				    if(!mentorApplicationInstance.save()) { // save mentorQuiz
						flash.message = "${message(code: 'mentorQuiz.create.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorApplicationInstance.id])}"
						return [mentorApplicationInstance: mentorApplicationInstance]
					}
					redirect(controller: "mentorQuiz", action:"view", id: mentorApplicationInstance.quiz.id)
					return
				}
				else if (mentorApplicationInstance.status == ApplicationStatus.REFERENCES) {
					redirect(action:"referenceInput", id: mentorApplicationInstance.id)
				}
				else if (mentorApplicationInstance.status == ApplicationStatus.RESPONSES) {
					redirect(action:"status")
				}
		}
		else {
			mentorApplicationInstance = new MentorApplication() 
			mentorApplicationInstance.properties = params
		}
		if(request.method == 'POST') {
			if (!params.mentorWaiver) {
				mentorApplicationInstance.errors.reject('mentorApplication.mentorWaiver.error','mentorWaiver must be checked')
				return [mentorApplicationInstance: mentorApplicationInstance]
			}
			mentorApplicationInstance.mentor = user 
			if (!mentorApplicationInstance.save()) { // save mentorApplication
				flash.message = "${message(code: 'mentorApplication.create.error', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), user.id])}"
			}
			else {
				def mentorQuiz = new MentorQuiz()
				def survey = new Survey(title: "$user:$mentorApplicationInstance.id")
				def result = survey.generateSurvey(MentorQuiz.surveySize) 
				if (!(result && survey.save())) { // save survey
					flash.message = "${message(code: 'survey.create.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorApplicationInstance.id])}"
				}
				else {
					mentorQuiz.application = mentorApplicationInstance
					mentorQuiz.survey = survey
					if (!mentorQuiz.save()) { // save mentorQuiz
						flash.message = "${message(code: 'mentorQuiz.create.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorApplicationInstance.id])}"
					}
					else {
						mentorApplicationInstance.quiz = mentorQuiz
						mentorApplicationInstance.status = ApplicationStatus.QUIZ
						mentorApplicationInstance.save() // save the mentor Quiz addition
						user.addToMentorApplications(mentorApplicationInstance) //update the user with the new application
						user.save()
						redirect(controller: "mentorQuiz", action:"view", id: mentorQuiz.id)
					}
				}
			}
		}
		return [mentorApplicationInstance: mentorApplicationInstance]
    }

    def failedQuiz = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		mentorApplicationInstance.status = ApplicationStatus.REJECTED
		mentorApplicationInstance.save() 
		return [mentorApplicationInstance: mentorApplicationInstance]
    }

	def referenceInput = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		if (mentorApplicationInstance) {
			mentorApplicationInstance.status = ApplicationStatus.REFERENCES
			def result = mentorApplicationInstance.save()
		}
		else {
			redirect(controller:"home", action:"index")
			return
		}
		def reference = []
		if (mentorApplicationInstance.references.size() == 0) {
			reference[1] = new Reference(sequence:1)
			reference[2] = new Reference(sequence:2)
		} 
		else {
			mentorApplicationInstance.references.each {
				reference[it.sequence] = it
			}
		}					
		def references = [reference[1], reference[2]]
		if(request.method == 'POST') {
			Boolean pass = true
			[1,2].each {
				def ref = reference[it]
				ref.application = mentorApplicationInstance
				ref.email = params.email."${it}"
				ref.firstName = params.firstName."${it}"
				ref.lastName = params.lastName."${it}"
				ref.relationship = params.relationship."${it}"
				if (!ref.validate()) {
					pass = false
				}
			}
			if (pass) {
				[1,2].each {
					def ref = reference[it]
					ref.save()
					mentorApplicationInstance.addToReferences(ref)
				}
			}
						
			// can't use the same reference twice
			
			if ((params.email."1".toLowerCase() == params.email."2".toLowerCase()) || 
			   ((params.firstName."1".toLowerCase() == params.firstName."2".toLowerCase()) && (params.lastName."1".toLowerCase() == params.lastName."2".toLowerCase()))) {
				pass = false			
				flash.message = "You may not use same reference twice."
			}
			if (pass && mentorApplicationInstance.save()) {
				flash.message = "${message(code: 'default.created.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), mentorApplicationInstance.id])}"
				// send out reference emails
				try {
					mentorApplicationInstance.references.each {
						def seqparm = "[seq:'" + it.sequence +"']"
						def ref = it
						sendMail {
							to ref.email
							subject "ESMZONE: Mentor Reference Check"
							body view:"/emails/mentorReference",
							model:[referenceInstance:ref, seqparm:seqparm]
						}
						ref.status=ReferenceStatus.SENT
						if  (!ref.save()) {
							throw new Exception("Status sent update failed.")
						}
					}
				}				
				catch(Exception e) {
						log.error "Problem sending email $e.message", e
						flash.message = "mentorApplication.reference.email.error,it.email"
						mentorApplicationInstance.status = ApplicationStatus.REFERENCES
						mentorApplicationInstance.save(flush:true)
						return [mentorApplicationInstance: mentorApplicationInstance, referenceList:references]
				}
				redirect(action:"complete", id:params.id)
			}
		}
		return [mentorApplicationInstance: mentorApplicationInstance, referenceList:references]
    }

	def complete = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		mentorApplicationInstance.status = ApplicationStatus.RESPONSES
		mentorApplicationInstance.save() 
		return [mentorApplicationInstance: mentorApplicationInstance]
    }

	def suspend = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		if (mentorApplicationInstance.status == ApplicationStatus.ACCEPTED) {
			mentorApplicationInstance.status = ApplicationStatus.SUSPENDED
			if (mentorApplicationInstance.save(flush:true)) { 
				def mentor = mentorApplicationInstance.mentor
				mentor.isMentor = false
				if (mentor.save(flush:true)) {
					flash.message = "Mentor role has been suspeneded."
				}
				else {
					flash.message = "Mentor status update failed."
				}
			}
			else {
				flash.message = "Application status update failed."
			}
		}
		redirect(action:"status")
    }

	def resume = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		if ((mentorApplicationInstance.status == ApplicationStatus.SUSPENDED) ||
		   (mentorApplicationInstance.status == ApplicationStatus.SUSPENDED)) {
			mentorApplicationInstance.status = ApplicationStatus.ACCEPTED
			if (mentorApplicationInstance.save(flush:true)) { 
				def mentor = mentorApplicationInstance.mentor
				mentor.isMentor = true
				if (mentor.save(flush:true)) {
					flash.message = "Mentor role has been resumed. Accepting all requests."
				}
				else {
					flash.message = "Mentor status update failed."
				}
			}
			else {
				flash.message = "Application status update failed."
			}
		}
		redirect(action:"status")
    }

	def notAcceptingRequests = {
		def mentorApplicationInstance = MentorApplication.get(params.id)
		if (mentorApplicationInstance.status == ApplicationStatus.ACCEPTED) {
			mentorApplicationInstance.status = ApplicationStatus.FULL
			if (mentorApplicationInstance.save(flush:true)) { 
				flash.message = "Mentor role has been marked as not accepting new requests."
			}
			else {
				flash.message = "Application status update failed."
			}
		}
		redirect(action:"status")
    }

    
	def referenceResponse = {
		// logout if this is a reference response
		if (org.jsecurity.SecurityUtils.getSubject()) {
			org.jsecurity.SecurityUtils.getSubject().logout()
		}
		def mentorApplicationInstance = MentorApplication.get(params?.id)
		def referenceInstance
		mentorApplicationInstance?.references?.each {
			if (it.sequence == params.int("seq")) {
				referenceInstance = it
			}
		}
		if (!referenceInstance) {
			log.error "Invalid refernce response request. Application: ${params.id} Reference Sequence: ${params.seq}"
			flash.message = "Sorry. We were not able to find the request for this reference."
		}
		else if (referenceInstance.status != ReferenceStatus.SENT) {
			log.error "Invalid refernce response request. Application: ${params.id} Reference Sequence: ${params.seq}. Duplicate request"
			flash.message = "Sorry. This refrerence has already been completed."
		}
		if (request.method == "POST")  {
			if (mentorApplicationInstance.status == ApplicationStatus.ACCEPTED) {
				return [mentorApplicationInstance: mentorApplicationInstance, memberProfileInstance:mentorApplicationInstance?.mentor?.memberProfile, referenceInstance:referenceInstance]
			}
			referenceInstance.approved = (params.approved == "true")?true:false
			referenceInstance.description = params.description
			def approvals = 0
			if (referenceInstance.approved == true) {
				referenceInstance.status = ReferenceStatus.APPROVED
				mentorApplicationInstance.references.each { 
					if (it.status == ReferenceStatus.APPROVED)
					approvals++
				}
				if (approvals == 2) {
					mentorApplicationInstance.status = ApplicationStatus.ACCEPTED
					def mentor = mentorApplicationInstance.mentor
					mentor.isMentor = true
					if (mentor.save(flush:true) && (mentorApplicationInstance.save(flush:true))) {
						flash.message = "${mentorApplicationInstance.mentor.firstName} has been approved as a mentor!"
						try {
							sendMail {
								to mentor.email
								subject "ESMZONE: Mentor Application Accepted"
								body view:"/emails/mentorAcceptance",
										model:[user:mentor]
							}
						}				
						catch(Exception e) {
							log.error "Problem sending email $e.message", e
						}
					}
					else {
						flash.message = "Problem updating the mentor status. Please contact a system administrator!"
					}
				}
				else {
					flash.message = "Thank you for your feedback and approval of ${mentorApplicationInstance.mentor.firstName}'s mentor application."
				}
				redirect(controller:"home", action:"index")
			}
			else {
				referenceInstance.status = ReferenceStatus.REJECTED
				mentorApplicationInstance.status = ApplicationStatus.REJECTED
				def mentor = mentorApplicationInstance.mentor
				flash.message = "Thank you for your feedback on ${mentorApplicationInstance.mentor.firstName}'s mentor application."
				try {
					sendMail {
						to mentor.email
						subject "ESMZONE: Mentor Application Update"
						body view:"/emails/mentorRejection",
								model:[user:mentor]
					}
				}				
				catch(Exception e) {
					log.error "Problem sending email $e.message", e
				}
				redirect(controller:"home", action:"index")
			}
		}
		return [mentorApplicationInstance: mentorApplicationInstance, memberProfileInstance:mentorApplicationInstance?.mentor?.memberProfile, referenceInstance:referenceInstance]
    }

    def save = {
        def mentorApplicationInstance = new MentorApplication(params)
        if (mentorApplicationInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), mentorApplicationInstance.id])}"
            redirect(action: "show", id: mentorApplicationInstance.id)
        }
        else {
            render(view: "create", model: [mentorApplicationInstance: mentorApplicationInstance])
        }
    }

    def show = {
        def mentorApplicationInstance = MentorApplication.get(params.id)
        if (!mentorApplicationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
            redirect(action: "list")
        }
        else {
            [mentorApplicationInstance: mentorApplicationInstance]
        }
    }

    def edit = {
        def mentorApplicationInstance = MentorApplication.get(params.id)
        if (!mentorApplicationInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [mentorApplicationInstance: mentorApplicationInstance]
        }
    }

    def update = {
        def mentorApplicationInstance = MentorApplication.get(params.id)
        if (mentorApplicationInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (mentorApplicationInstance.version > version) {
                    
                    mentorApplicationInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'mentorApplication.label', default: 'MentorApplication')] as Object[], "Another user has updated this MentorApplication while you were editing")
                    render(view: "edit", model: [mentorApplicationInstance: mentorApplicationInstance])
                    return
                }
            }
            mentorApplicationInstance.properties = params
            if (!mentorApplicationInstance.hasErrors() && mentorApplicationInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), mentorApplicationInstance.id])}"
                redirect(action: "show", id: mentorApplicationInstance.id)
            }
            else {
                render(view: "edit", model: [mentorApplicationInstance: mentorApplicationInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def mentorApplicationInstance = MentorApplication.get(params.id)
        if (mentorApplicationInstance) {
            try {
                mentorApplicationInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorApplication.label', default: 'MentorApplication'), params.id])}"
            redirect(action: "list")
        }
    }
}
