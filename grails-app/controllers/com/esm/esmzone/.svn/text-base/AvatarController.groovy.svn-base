package com.esm.esmzone

class AvatarController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [avatarInstanceList: Avatar.list(params), avatarInstanceTotal: Avatar.count()]
    }

    def create = {
        def avatarInstance = new Avatar()
        avatarInstance.properties = params
        return [avatarInstance: avatarInstance]
    }

    def save = {
        def avatarInstance = new Avatar(params)
        if (avatarInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'avatar.label', default: 'Avatar'), avatarInstance.id])}"
            redirect(action: "show", id: avatarInstance.id)
        }
        else {
            render(view: "create", model: [avatarInstance: avatarInstance])
        }
    }

    def show = {
        def avatarInstance = Avatar.get(params.id)
        if (!avatarInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
            redirect(action: "list")
        }
        else {
            [avatarInstance: avatarInstance]
        }
    }

    def edit = {
        def avatarInstance = Avatar.get(params.id)
        if (!avatarInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [avatarInstance: avatarInstance]
        }
    }

    def update = {
        def avatarInstance = Avatar.get(params.id)
        if (avatarInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (avatarInstance.version > version) {
                    
                    avatarInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'avatar.label', default: 'Avatar')] as Object[], "Another user has updated this Avatar while you were editing")
                    render(view: "edit", model: [avatarInstance: avatarInstance])
                    return
                }
            }
            avatarInstance.properties = params
            if (!avatarInstance.hasErrors() && avatarInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'avatar.label', default: 'Avatar'), avatarInstance.id])}"
                redirect(action: "show", id: avatarInstance.id)
            }
            else {
                render(view: "edit", model: [avatarInstance: avatarInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def avatarInstance = Avatar.get(params.id)
        if (avatarInstance) {
            try {
                avatarInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'avatar.label', default: 'Avatar'), params.id])}"
            redirect(action: "list")
        }
    }
}
