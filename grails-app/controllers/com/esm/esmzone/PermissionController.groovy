package com.esm.esmzone

class PermissionController {
	
	def scaffold = true;
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [permissionInstanceList: Permission.list(params), permissionInstanceTotal: Permission.count()]
    }

    def create = {
        def permissionInstance = new Permission()
        permissionInstance.properties = params
        return [permissionInstance: permissionInstance]
    }

    def save = {
        def permissionInstance = new Permission(params)
        if (permissionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'permission.label', default: 'Permission'), permissionInstance.id])}"
            redirect(action: "show", id: permissionInstance.id)
        }
        else {
            render(view: "create", model: [permissionInstance: permissionInstance])
        }
    }

    def show = {
        def permissionInstance = Permission.get(params.id)
        if (!permissionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
            redirect(action: "list")
        }
        else {
            [permissionInstance: permissionInstance]
        }
    }

    def edit = {
        def permissionInstance = Permission.get(params.id)
        if (!permissionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [permissionInstance: permissionInstance]
        }
    }

    def update = {
        def permissionInstance = Permission.get(params.id)
        if (permissionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (permissionInstance.version > version) {
                    
                    permissionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'permission.label', default: 'Permission')] as Object[], "Another user has updated this Permission while you were editing")
                    render(view: "edit", model: [permissionInstance: permissionInstance])
                    return
                }
            }
            permissionInstance.properties = params
            if (!permissionInstance.hasErrors() && permissionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'permission.label', default: 'Permission'), permissionInstance.id])}"
                redirect(action: "show", id: permissionInstance.id)
            }
            else {
                render(view: "edit", model: [permissionInstance: permissionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def permissionInstance = Permission.get(params.id)
        if (permissionInstance) {
            try {
                permissionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'permission.label', default: 'Permission'), params.id])}"
            redirect(action: "list")
        }
    }
}
