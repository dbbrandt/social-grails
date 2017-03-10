package com.esm.promotion

class QuestionPromotionEntryController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [questionPromotionEntryInstanceList: QuestionPromotionEntry.list(params), questionPromotionEntryInstanceTotal: QuestionPromotionEntry.count()]
    }

    def create = {
        def questionPromotionEntryInstance = new QuestionPromotionEntry()
        questionPromotionEntryInstance.properties = params
        return [questionPromotionEntryInstance: questionPromotionEntryInstance]
    }

    def save = {
        def questionPromotionEntryInstance = new QuestionPromotionEntry(params)
        if (questionPromotionEntryInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), questionPromotionEntryInstance.id])}"
            redirect(action: "show", id: questionPromotionEntryInstance.id)
        }
        else {
            render(view: "create", model: [questionPromotionEntryInstance: questionPromotionEntryInstance])
        }
    }

    def show = {
        def questionPromotionEntryInstance = QuestionPromotionEntry.get(params.id)
        if (!questionPromotionEntryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
            redirect(action: "list")
        }
        else {
            [questionPromotionEntryInstance: questionPromotionEntryInstance]
        }
    }

    def edit = {
        def questionPromotionEntryInstance = QuestionPromotionEntry.get(params.id)
        if (!questionPromotionEntryInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [questionPromotionEntryInstance: questionPromotionEntryInstance]
        }
    }

    def update = {
        def questionPromotionEntryInstance = QuestionPromotionEntry.get(params.id)
        if (questionPromotionEntryInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (questionPromotionEntryInstance.version > version) {
                    
                    questionPromotionEntryInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry')] as Object[], "Another user has updated this QuestionPromotionEntry while you were editing")
                    render(view: "edit", model: [questionPromotionEntryInstance: questionPromotionEntryInstance])
                    return
                }
            }
            questionPromotionEntryInstance.properties = params
            if (!questionPromotionEntryInstance.hasErrors() && questionPromotionEntryInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), questionPromotionEntryInstance.id])}"
                redirect(action: "show", id: questionPromotionEntryInstance.id)
            }
            else {
                render(view: "edit", model: [questionPromotionEntryInstance: questionPromotionEntryInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def questionPromotionEntryInstance = QuestionPromotionEntry.get(params.id)
        if (questionPromotionEntryInstance) {
            try {
                questionPromotionEntryInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry'), params.id])}"
            redirect(action: "list")
        }
    }
}
