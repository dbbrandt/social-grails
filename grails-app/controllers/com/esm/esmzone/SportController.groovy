package com.esm.esmzone

class SportController {
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        println params
        [sportInstanceList: Sport.list(params), sportInstanceTotal: Sport.count()]
    }

    def create = {
        def sportInstance = new Sport()
        sportInstance.properties = params
        return [sportInstance: sportInstance]
    }

    def save = {
        def sportInstance = new Sport(params)
        if (sportInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'sport.label', default: 'Sport'), sportInstance.id])}"
            redirect(action: "show", id: sportInstance.id)
        }
        else {
            render(view: "create", model: [sportInstance: sportInstance])
        }
    }

    def show = {
        def sportInstance = Sport.get(params.id)
        if (!sportInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
            redirect(action: "list")
        }
        else {
            [sportInstance: sportInstance]
        }
    }

    def edit = {
        def sportInstance = Sport.get(params.id)
        if (!sportInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [sportInstance: sportInstance]
        }
    }

    def update = {
        def sportInstance = Sport.get(params.id)
        if (sportInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (sportInstance.version > version) {
                    
                    sportInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'sport.label', default: 'Sport')] as Object[], "Another user has updated this Sport while you were editing")
                    render(view: "edit", model: [sportInstance: sportInstance])
                    return
                }
            }
            sportInstance.properties = params
            if (!sportInstance.hasErrors() && sportInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'sport.label', default: 'Sport'), sportInstance.id])}"
                redirect(action: "show", id: sportInstance.id)
            }
            else {
                render(view: "edit", model: [sportInstance: sportInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def sportInstance = Sport.get(params.id)
        if (sportInstance) {
            try {
                sportInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'sport.label', default: 'Sport'), params.id])}"
            redirect(action: "list")
        }
    }
}
