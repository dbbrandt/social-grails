package com.esm.dialog

class AnswerRatingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [answerRatingInstanceList: AnswerRating.list(params), answerRatingInstanceTotal: AnswerRating.count()]
    }

    def create = {
        def answerRatingInstance = new AnswerRating()
        answerRatingInstance.properties = params
        return [answerRatingInstance: answerRatingInstance]
    }

    def save = {
        def answerRatingInstance = new AnswerRating(params)
        if (answerRatingInstance.save(flush: true)) {
			answerRatingInstance.answer.addRating(answerRatingInstance)
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), answerRatingInstance.id])}"
            redirect(action: "show", id: answerRatingInstance.id)
        }
        else {
            render(view: "create", model: [answerRatingInstance: answerRatingInstance])
        }
    }

    def show = {
        def answerRatingInstance = AnswerRating.get(params.id)
        if (!answerRatingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
            redirect(action: "list")
        }
        else {
            [answerRatingInstance: answerRatingInstance]
        }
    }

    def edit = {
        def answerRatingInstance = AnswerRating.get(params.id)
        if (!answerRatingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [answerRatingInstance: answerRatingInstance]
        }
    }

    def update = {
        def answerRatingInstance = AnswerRating.get(params.id)
        if (answerRatingInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (answerRatingInstance.version > version) {
                    
                    answerRatingInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'answerRating.label', default: 'AnswerRating')] as Object[], "Another user has updated this AnswerRating while you were editing")
                    render(view: "edit", model: [answerRatingInstance: answerRatingInstance])
                    return
                }
            }
            answerRatingInstance.properties = params
            if (!answerRatingInstance.hasErrors() && answerRatingInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), answerRatingInstance.id])}"
                redirect(action: "show", id: answerRatingInstance.id)
            }
            else {
                render(view: "edit", model: [answerRatingInstance: answerRatingInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def answerRatingInstance = AnswerRating.get(params.id)
        if (answerRatingInstance) {
            try {
                answerRatingInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerRating.label', default: 'AnswerRating'), params.id])}"
            redirect(action: "list")
        }
    }
}
