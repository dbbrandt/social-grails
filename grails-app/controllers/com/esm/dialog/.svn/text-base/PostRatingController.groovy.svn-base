package com.esm.dialog

class PostRatingController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [postRatingInstanceList: PostRating.list(params), postRatingInstanceTotal: PostRating.count()]
    }

    def create = {
        def postRatingInstance = new PostRating()
        postRatingInstance.properties = params
        return [postRatingInstance: postRatingInstance]
    }

    def save = {
        def postRatingInstance = new PostRating(params)
        if (postRatingInstance.save(flush: true)) {
			postRatingInstance.post.addRating(postRatingInstance)
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'postRating.label', default: 'PostRating'), postRatingInstance.id])}"
            redirect(action: "show", id: postRatingInstance.id)
        }
        else {
            render(view: "create", model: [postRatingInstance: postRatingInstance])
        }
    }

    def show = {
        def postRatingInstance = PostRating.get(params.id)
        if (!postRatingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postRatingInstance: postRatingInstance]
        }
    }

    def edit = {
        def postRatingInstance = PostRating.get(params.id)
        if (!postRatingInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postRatingInstance: postRatingInstance]
        }
    }

    def update = {
        def postRatingInstance = PostRating.get(params.id)
        if (postRatingInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postRatingInstance.version > version) {
                    
                    postRatingInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'postRating.label', default: 'PostRating')] as Object[], "Another user has updated this PostRating while you were editing")
                    render(view: "edit", model: [postRatingInstance: postRatingInstance])
                    return
                }
            }
            postRatingInstance.properties = params
            if (!postRatingInstance.hasErrors() && postRatingInstance.save(flush: true)) {
				postRatingInstance.post.score(flush:true)
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'postRating.label', default: 'PostRating'), postRatingInstance.id])}"
                redirect(action: "show", id: postRatingInstance.id)
            }
            else {
                render(view: "edit", model: [postRatingInstance: postRatingInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def postRatingInstance = PostRating.get(params.id)
        if (postRatingInstance) {
            try {
                postRatingInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postRating.label', default: 'PostRating'), params.id])}"
            redirect(action: "list")
        }
    }
}
