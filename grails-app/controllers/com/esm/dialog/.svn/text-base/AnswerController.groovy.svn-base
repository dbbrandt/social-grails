package com.esm.dialog

import com.esm.esmzone.User;
import com.esm.esmzone.PointsType

class AnswerController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST", add: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [answerInstanceList: Answer.list(params), answerInstanceTotal: Answer.count()]
    }

    def rate = {
    	def answerInstance = Answer.get(params.id)
		def user = User.get(request.user.id)
		def c = AnswerRating.createCriteria()
		def answerRatingList = c {
    		eq('user',user)
			eq('answer', answerInstance)
		}
		if (!answerRatingList && (answerInstance.author != user)) {
			answerInstance.addToRatings(user:request.user)
			answerInstance.save(flush:true)
		}
		else if (answerRatingList) {
			def answerRating = AnswerRating.get(answerRatingList.toArray()[0].id)
			answerRating.incrementRating() 
			answerRating.save(flush:true)
		}
		redirect(controller:"post", action:"view",id:answerInstance?.post?.id)	
      }


    def bestAnswer = {
    	def answerInstance = Answer.get(params.id)
		def user = User.get(request.user.id)
		def post = answerInstance.post
		if ((answerInstance.author != user) && (post.author == user)) {
			if (!post.bestAnswer) {
				answerInstance.author.addPoints(PointsType.lookup("BestAnswer"))
			}
			post.bestAnswer = answerInstance
			post.save()
		}
        redirect(controller:"post", action:"view",id:post.id)	
      }

    def create = {
        def answerInstance = new Answer()
        answerInstance.properties = params
        return [answerInstance: answerInstance]
    }

    def save = {
        def answerInstance = new Answer(params)
        if (answerInstance.save(flush: true)) {
			flash.message = "${message(code: 'default.created.message', args: [message(code: 'answer.label', default: 'Answer'), answerInstance.id])}"
            redirect(action: "show", id: answerInstance.id)
        }
        else {
            render(view: "create", model: [answerInstance: answerInstance])
        }
    }

    def show = {
        def answerInstance = Answer.get(params.id)
        if (!answerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
            redirect(action: "list")
        }
        else {
            [answerInstance: answerInstance]
        }
    }

    def edit = {
        def answerInstance = Answer.get(params.id)
        if (!answerInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [answerInstance: answerInstance]
        }
    }

    def update = {
        def answerInstance = Answer.get(params.id)
        if (answerInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (answerInstance.version > version) {
                    
                    answerInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'answer.label', default: 'Answer')] as Object[], "Another user has updated this Answer while you were editing")
                    render(view: "edit", model: [answerInstance: answerInstance])
                    return
                }
            }
            answerInstance.properties = params
            if (!answerInstance.hasErrors() && answerInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'answer.label', default: 'Answer'), answerInstance.id])}"
                redirect(action: "show", id: answerInstance.id)
            }
            else {
                render(view: "edit", model: [answerInstance: answerInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def answerInstance = Answer.get(params.id)
        if (answerInstance) {
            try {
                answerInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'answer.label', default: 'Answer'), params.id])}"
            redirect(action: "list")
        }
    }
}
