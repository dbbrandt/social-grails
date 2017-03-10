package com.esm.dialog

class PostTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [postTypeInstanceList: PostType.list(params), postTypeInstanceTotal: PostType.count()]
    }

    def create = {
        def postTypeInstance = new PostType()
        postTypeInstance.properties = params
        return [postTypeInstance: postTypeInstance]
    }

    def save = {
        def postTypeInstance = new PostType(params)
        if (postTypeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'postType.label', default: 'PostType'), postTypeInstance.id])}"
            redirect(action: "show", id: postTypeInstance.id)
        }
        else {
            render(view: "create", model: [postTypeInstance: postTypeInstance])
        }
    }

    def show = {
        def postTypeInstance = PostType.get(params.id)
        if (!postTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postTypeInstance: postTypeInstance]
        }
    }

    def edit = {
        def postTypeInstance = PostType.get(params.id)
        if (!postTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postTypeInstance: postTypeInstance]
        }
    }

    def update = {
        def postTypeInstance = PostType.get(params.id)
        if (postTypeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postTypeInstance.version > version) {
                    
                    postTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'postType.label', default: 'PostType')] as Object[], "Another user has updated this PostType while you were editing")
                    render(view: "edit", model: [postTypeInstance: postTypeInstance])
                    return
                }
            }
            postTypeInstance.properties = params
            if (!postTypeInstance.hasErrors() && postTypeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'postType.label', default: 'PostType'), postTypeInstance.id])}"
                redirect(action: "show", id: postTypeInstance.id)
            }
            else {
                render(view: "edit", model: [postTypeInstance: postTypeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def postTypeInstance = PostType.get(params.id)
        if (postTypeInstance) {
            try {
                postTypeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postType.label', default: 'PostType'), params.id])}"
            redirect(action: "list")
        }
    }
}
