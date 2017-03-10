package com.esm.dialog

class PostTagController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [postTagInstanceList: PostTag.list(params), postTagInstanceTotal: PostTag.count()]
    }

    def create = {
        def postTagInstance = new PostTag()
        postTagInstance.properties = params
        return [postTagInstance: postTagInstance]
    }

    def save = {
        def postTagInstance = new PostTag(params)
        if (postTagInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'postTag.label', default: 'PostTag'), postTagInstance.id])}"
            redirect(action: "show", id: postTagInstance.id)
        }
        else {
            render(view: "create", model: [postTagInstance: postTagInstance])
        }
    }

    def show = {
        def postTagInstance = PostTag.get(params.id)
        if (!postTagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postTagInstance: postTagInstance]
        }
    }

    def edit = {
        def postTagInstance = PostTag.get(params.id)
        if (!postTagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postTagInstance: postTagInstance]
        }
    }

    def update = {
        def postTagInstance = PostTag.get(params.id)
        if (postTagInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postTagInstance.version > version) {
                    
                    postTagInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'postTag.label', default: 'PostTag')] as Object[], "Another user has updated this PostTag while you were editing")
                    render(view: "edit", model: [postTagInstance: postTagInstance])
                    return
                }
            }
            postTagInstance.properties = params
            if (!postTagInstance.hasErrors() && postTagInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'postTag.label', default: 'PostTag'), postTagInstance.id])}"
                redirect(action: "show", id: postTagInstance.id)
            }
            else {
                render(view: "edit", model: [postTagInstance: postTagInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def postTagInstance = PostTag.get(params.id)
        if (postTagInstance) {
            try {
                postTagInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postTag.label', default: 'PostTag'), params.id])}"
            redirect(action: "list")
        }
    }
}
