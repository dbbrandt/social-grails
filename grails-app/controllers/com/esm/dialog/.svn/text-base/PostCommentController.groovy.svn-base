package com.esm.dialog

import com.esm.esmzone.User;
import com.esm.esmzone.PointsType

class PostCommentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", add: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [postCommentInstanceList: PostComment.list(params), postCommentInstanceTotal: PostComment.count()]
    }

    def create = {
        def postCommentInstance = new PostComment()
        postCommentInstance.properties = params
        return [postCommentInstance: postCommentInstance]
    }

     def save = {
        def postCommentInstance = new PostComment(params)
        if (postCommentInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'postComment.label', default: 'PostComment'), postCommentInstance.id])}"
            redirect(action: "show", id: postCommentInstance.id)
        }
        else {
            render(view: "create", model: [postCommentInstance: postCommentInstance])
        }
    }

    def show = {
        def postCommentInstance = PostComment.get(params.id)
        if (!postCommentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
            redirect(action: "list")
        }
        else {
            [postCommentInstance: postCommentInstance]
        }
    }

    def edit = {
        def postCommentInstance = PostComment.get(params.id)
        if (!postCommentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [postCommentInstance: postCommentInstance]
        }
    }

    def update = {
        def postCommentInstance = PostComment.get(params.id)
        if (postCommentInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (postCommentInstance.version > version) {
                    
                    postCommentInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'postComment.label', default: 'PostComment')] as Object[], "Another user has updated this PostComment while you were editing")
                    render(view: "edit", model: [postCommentInstance: postCommentInstance])
                    return
                }
            }
            postCommentInstance.properties = params
            if (!postCommentInstance.hasErrors() && postCommentInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'postComment.label', default: 'PostComment'), postCommentInstance.id])}"
                redirect(action: "show", id: postCommentInstance.id)
            }
            else {
                render(view: "edit", model: [postCommentInstance: postCommentInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def postCommentInstance = PostComment.get(params.id)
        if (postCommentInstance) {
            try {
                postCommentInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'postComment.label', default: 'PostComment'), params.id])}"
            redirect(action: "list")
        }
    }
}
