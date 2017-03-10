package com.esm.esmzone

import com.esm.dialog.*
import com.esm.survey.*

class MentorQuizController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [mentorQuizInstanceList: MentorQuiz.list(params), mentorQuizInstanceTotal: MentorQuiz.count()]
    }

    def create = {
        def mentorQuizInstance = new MentorQuiz()
        mentorQuizInstance.properties = params
        return [mentorQuizInstance: mentorQuizInstance]
    }

    def save = {
        def mentorQuizInstance = new MentorQuiz(params)
        if (mentorQuizInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorQuizInstance.id])}"
            redirect(action: "show", id: mentorQuizInstance.id)
        }
        else {
            render(view: "create", model: [mentorQuizInstance: mentorQuizInstance])
        }
    }

    def show = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
        if (!mentorQuizInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
            redirect(action: "list")
        }
        else {
            [mentorQuizInstance: mentorQuizInstance]
        }
    }

    def view = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
        if (!mentorQuizInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
            redirect(action: "list")
        }
        else {
			def survey = mentorQuizInstance.survey 
            [mentorQuizInstance: mentorQuizInstance, surveyInstance:survey]
        }
    }

    def submitQuiz = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
		def questions = mentorQuizInstance.survey.questions
		def correctAnswers = 0
		def resp
		def previousResponses = [:]
		if (!params?.response || (params?.response.size() != questions.size())) {
			flash.message = "You must answer all the questions."
			questions.each { q ->
				previousResponses[q.id] = params?.response?."${q.id}"
			}
			render(view:"view", model:[mentorQuizInstance:mentorQuizInstance, surveyInstance:mentorQuizInstance.survey, previousResponses:previousResponses])
			return
		}
		questions.each { q ->
			resp = Response.get(params?.response?."${q.id}")
			mentorQuizInstance.addToResponses(resp)
		}
		if (mentorQuizInstance.save()) {
			def pass = mentorQuizInstance.checkQuiz()
			mentorQuizInstance.passed = pass
			if (pass && mentorQuizInstance.save()) {
				redirect(controller:"mentorApplication", action:"referenceInput", id: mentorQuizInstance.application.id)
			}
			else {
				redirect(controller:"mentorApplication", action:"failedQuiz", id: mentorQuizInstance.application.id)
			}
		}
		else {
			flash.message = "${message(code: 'mentorQuiz.save.error', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
			redirect(action:"view")
		}
		
		
	}
    
    def edit = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
        if (!mentorQuizInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [mentorQuizInstance: mentorQuizInstance]
        }
    }

    def update = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
        if (mentorQuizInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (mentorQuizInstance.version > version) {
                    
                    mentorQuizInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'mentorQuiz.label', default: 'MentorQuiz')] as Object[], "Another user has updated this MentorQuiz while you were editing")
                    render(view: "edit", model: [mentorQuizInstance: mentorQuizInstance])
                    return
                }
            }
            mentorQuizInstance.properties = params
            if (!mentorQuizInstance.hasErrors() && mentorQuizInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), mentorQuizInstance.id])}"
                redirect(action: "show", id: mentorQuizInstance.id)
            }
            else {
                render(view: "edit", model: [mentorQuizInstance: mentorQuizInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def mentorQuizInstance = MentorQuiz.get(params.id)
        if (mentorQuizInstance) {
            try {
                mentorQuizInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'mentorQuiz.label', default: 'MentorQuiz'), params.id])}"
            redirect(action: "list")
        }
    }
}
