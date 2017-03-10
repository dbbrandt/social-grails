package com.esm.promotion

import com.esm.survey.*
import com.esm.esmzone.SystemConfig

class QuestionPromotionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [questionPromotionInstanceList: QuestionPromotion.list(params), questionPromotionInstanceTotal: QuestionPromotion.count()]
    }

    def create = {
        def questionPromotionInstance = new QuestionPromotion()
        questionPromotionInstance.properties = params
        return [questionPromotionInstance: questionPromotionInstance]
    }

    def save = {
        def questionPromotionInstance = new QuestionPromotion(params)
        if (questionPromotionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), questionPromotionInstance.id])}"
            redirect(action: "show", id: questionPromotionInstance.id)
        }
        else {
            render(view: "create", model: [questionPromotionInstance: questionPromotionInstance])
        }
    }

    def show = {
        def questionPromotionInstance = QuestionPromotion.get(params.id)
        if (!questionPromotionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
            redirect(action: "list")
        }
        else {
            [questionPromotionInstance: questionPromotionInstance]
        }
    }

    def edit = {
        def questionPromotionInstance = QuestionPromotion.get(params.id)
        if (!questionPromotionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [questionPromotionInstance: questionPromotionInstance]
        }
    }

    def update = {
        def questionPromotionInstance = QuestionPromotion.get(params.id)
        if (questionPromotionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (questionPromotionInstance.version > version) {
                    
                    questionPromotionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'questionPromotion.label', default: 'QuestionPromotion')] as Object[], "Another user has updated this QuestionPromotion while you were editing")
                    render(view: "edit", model: [questionPromotionInstance: questionPromotionInstance])
                    return
                }
            }
            questionPromotionInstance.properties = params
            if (!questionPromotionInstance.hasErrors() && questionPromotionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), questionPromotionInstance.id])}"
                redirect(action: "show", id: questionPromotionInstance.id)
            }
            else {
                render(view: "edit", model: [questionPromotionInstance: questionPromotionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def questionPromotionInstance = QuestionPromotion.get(params.id)
        if (questionPromotionInstance) {
            try {
                questionPromotionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotion.label', default: 'QuestionPromotion'), params.id])}"
            redirect(action: "list")
        }
    }
	
	def viewQuestion = {
		def questionPromotionInstance = QuestionPromotion.get(params.id)
		def question = questionPromotionInstance.nextQuestion()
		if (question) {
			return [questionPromotion: questionPromotionInstance, question: question]
		}
		else {
			if (questionPromotionInstance.status != PromotionStatus.COMPLETED) {
				questionPromotionInstance.status = PromotionStatus.COMPLETED
				questionPromotionInstance.save()
			}
			println "Redirected due to completed campaign"
			redirect(action:"viewResult", id: params.id)
		}
	}
	
	def viewResult = {
		def questionPromotionInstance = QuestionPromotion.get(params.id)
		def questionText
		def responseText
		def message
		if (questionPromotionInstance.status != PromotionStatus.ACTIVE) {
			message = questionPromotionInstance.notAvailableMessage
			println "Promotion is not active"
		}
		else {
			def user = request?.user
			def response = Response.get(params.response)
			questionText = questionPromotionInstance?.currentQuestion.questionText
			responseText = response?.responseText
			def entry = new QuestionPromotionEntry(user, questionPromotionInstance, response)
			if (entry.validate()) {
				entry.save()
				def result = PromotionEntryResult.INCORRECT
				if (response) {
					result = questionPromotionInstance.submitEntry(entry)
				}
				if (result == PromotionEntryResult.WINNER) {
						message = questionPromotionInstance.winningMessage
				}
				else {
					if (result == PromotionEntryResult.CORRECT) {
						message = questionPromotionInstance.correctMessage + " You only need " + 
							entry.answersToWin + " more correct answers to win!"
					}
					else {
						message = questionPromotionInstance.incorrectMessage
					}
				}
			}
			else {
				println entry.errors
				message = "Error processing your request."
			}
		}
		return [questionPromotion: questionPromotionInstance, questionText:questionText, responseText:responseText, message:message]
	}
	
	def backdateEntries = {
		def config = SystemConfig.get(1)
		def questionPromotionInstance = QuestionPromotion.get(config.questionPromotion?.id)
		def startDate = new Date()
		def yesterday = startDate - 1
		startDate.clearTime()
		def entryList =  QuestionPromotionEntry.createCriteria().list() {
			ge("dateCreated", startDate)
			eq("promotion", questionPromotionInstance)
		}
		entryList.each { entry ->
			entry.dateCreated = yesterday
			entry.save()
		}
        flash.message = entryList.size().toString() + " entries were backdated to yesterday."
		redirect(controller:"home", action:"admin")
	}

	def reActivate = {
		def config = SystemConfig.get(1)
		def questionPromotionInstance = QuestionPromotion.get(config.questionPromotion?.id)
		questionPromotionInstance.remainingQuota = questionPromotionInstance.quota
		questionPromotionInstance.currentQuestionDate = null
		questionPromotionInstance.status = PromotionStatus.ACTIVE
		questionPromotionInstance.save()
		flash.message = "QuestionPromotion was reactivated with a quota of: " + questionPromotionInstance.remainingQuota.toString()
		redirect(controller:"home", action:"admin")
	}

	def backdateCurrentQuestion = {
		def config = SystemConfig.get(1)
		def questionPromotionInstance = QuestionPromotion.get(config.questionPromotion?.id)
		def startDate = new Date()
		startDate.clearTime()
		def yesterday = startDate - 1
		questionPromotionInstance.currentQuestionDate = yesterday
		questionPromotionInstance.save()
		flash.message = "QuestionPromotion currentQuestionDate backdated to yesterday"
		redirect(controller:"home", action:"admin")
	}
	
}
