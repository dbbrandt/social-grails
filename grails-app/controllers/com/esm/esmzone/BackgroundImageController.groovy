package com.esm.esmzone

class BackgroundImageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [backgroundImageInstanceList: BackgroundImage.list(params), backgroundImageInstanceTotal: BackgroundImage.count()]
    }

    def create = {
        def backgroundImageInstance = new BackgroundImage()
        backgroundImageInstance.properties = params
        return [backgroundImageInstance: backgroundImageInstance]
    }

    def save = {
        def backgroundImageInstance = new BackgroundImage(params)
        if (backgroundImageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), backgroundImageInstance.id])}"
            redirect(action: "show", id: backgroundImageInstance.id)
        }
        else {
            render(view: "create", model: [backgroundImageInstance: backgroundImageInstance])
        }
    }

    def show = {
        def backgroundImageInstance = BackgroundImage.get(params.id)
        if (!backgroundImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [backgroundImageInstance: backgroundImageInstance]
        }
    }

    def edit = {
        def backgroundImageInstance = BackgroundImage.get(params.id)
        if (!backgroundImageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [backgroundImageInstance: backgroundImageInstance]
        }
    }

    def update = {
        def backgroundImageInstance = BackgroundImage.get(params.id)
        if (backgroundImageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (backgroundImageInstance.version > version) {
                    
                    backgroundImageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'backgroundImage.label', default: 'BackgroundImage')] as Object[], "Another user has updated this BackgroundImage while you were editing")
                    render(view: "edit", model: [backgroundImageInstance: backgroundImageInstance])
                    return
                }
            }
            backgroundImageInstance.properties = params
            if (!backgroundImageInstance.hasErrors() && backgroundImageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), backgroundImageInstance.id])}"
                redirect(action: "show", id: backgroundImageInstance.id)
            }
            else {
                render(view: "edit", model: [backgroundImageInstance: backgroundImageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def backgroundImageInstance = BackgroundImage.get(params.id)
        if (backgroundImageInstance) {
            try {
                backgroundImageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'backgroundImage.label', default: 'BackgroundImage'), params.id])}"
            redirect(action: "list")
        }
    }
}
