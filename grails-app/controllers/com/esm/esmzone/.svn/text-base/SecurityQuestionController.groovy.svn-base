package com.esm.esmzone

class SecurityQuestionController {
	
	def scaffold = true
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [securityQuestionInstanceList: SecurityQuestion.list(params), securityQuestionInstanceTotal: SecurityQuestion.count()]
    }

    def create = {
        def securityQuestionInstance = new SecurityQuestion()
        securityQuestionInstance.properties = params
        return [securityQuestionInstance: securityQuestionInstance]
    }

    def save = {
        def securityQuestionInstance = new SecurityQuestion(params)
        if (securityQuestionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), securityQuestionInstance.id])}"
            redirect(action: "show", id: securityQuestionInstance.id)
        }
        else {
            render(view: "create", model: [securityQuestionInstance: securityQuestionInstance])
        }
    }

    def show = {
        def securityQuestionInstance = SecurityQuestion.get(params.id)
        if (!securityQuestionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
            redirect(action: "list")
        }
        else {
            [securityQuestionInstance: securityQuestionInstance]
        }
    }

    def edit = {
        def securityQuestionInstance = SecurityQuestion.get(params.id)
        if (!securityQuestionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [securityQuestionInstance: securityQuestionInstance]
        }
    }

    def update = {
        def securityQuestionInstance = SecurityQuestion.get(params.id)
        if (securityQuestionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (securityQuestionInstance.version > version) {
                    
                    securityQuestionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'securityQuestion.label', default: 'SecurityQuestion')] as Object[], "Another user has updated this SecurityQuestion while you were editing")
                    render(view: "edit", model: [securityQuestionInstance: securityQuestionInstance])
                    return
                }
            }
            securityQuestionInstance.properties = params
            if (!securityQuestionInstance.hasErrors() && securityQuestionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), securityQuestionInstance.id])}"
                redirect(action: "show", id: securityQuestionInstance.id)
            }
            else {
                render(view: "edit", model: [securityQuestionInstance: securityQuestionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def securityQuestionInstance = SecurityQuestion.get(params.id)
        if (securityQuestionInstance) {
            try {
                securityQuestionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'securityQuestion.label', default: 'SecurityQuestion'), params.id])}"
            redirect(action: "list")
        }
    }
}
