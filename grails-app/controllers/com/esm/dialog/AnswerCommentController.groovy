package com.esm.dialog

import com.esm.esmzone.User
import com.esm.esmzone.PointsType

class AnswerCommentController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [answerCommentInstanceList: AnswerComment.list(params), answerCommentInstanceTotal: AnswerComment.count()]
    }

    def create = {
        def answerCommentInstance = new AnswerComment()
        answerCommentInstance.properties = params
        return [answerCommentInstance: answerCommentInstance]
    }

    def save = {
        def answerCommentInstance = new AnswerComment(params)
        if (answerCommentInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), answerCommentInstance.id])}"
            redirect(action: "show", id: answerCommentInstance.id)
        }
        else {
            render(view: "create", model: [answerCommentInstance: answerCommentInstance])
        }
    }

    def show = {
        def answerCommentInstance = AnswerComment.get(params.id)
        if (!answerCommentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
            redirect(action: "list")
        }
        else {
            [answerCommentInstance: answerCommentInstance]
        }
    }

    def edit = {
        def answerCommentInstance = AnswerComment.get(params.id)
        if (!answerCommentInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [answerCommentInstance: answerCommentInstance]
        }
    }

    def update = {
        def answerCommentInstance = AnswerComment.get(params.id)
        if (answerCommentInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (answerCommentInstance.version > version) {
                    
                    answerCommentInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'answerComment.label', default: 'AnswerComment')] as Object[], "Another user has updated this AnswerComment while you were editing")
                    render(view: "edit", model: [answerCommentInstance: answerCommentInstance])
                    return
                }
            }
            answerCommentInstance.properties = params
            if (!answerCommentInstance.hasErrors() && answerCommentInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), answerCommentInstance.id])}"
                redirect(action: "show", id: answerCommentInstance.id)
            }
            else {
                render(view: "edit", model: [answerCommentInstance: answerCommentInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def answerCommentInstance = AnswerComment.get(params.id)
        if (answerCommentInstance) {
            try {
                answerCommentInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answerComment.label', default: 'AnswerComment'), params.id])}"
            redirect(action: "list")
        }
    }
}
