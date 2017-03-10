package com.esm.esmzone

class SubscriptionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [subscriptionInstanceList: Subscription.list(params), subscriptionInstanceTotal: Subscription.count()]
    }

    def create = {
        def subscriptionInstance = new Subscription()
        subscriptionInstance.properties = params
        return [subscriptionInstance: subscriptionInstance]
    }

    def save = {
        def subscriptionInstance = new Subscription(params)
        if (subscriptionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'subscription.label', default: 'Subscription'), subscriptionInstance.id])}"
            redirect(action: "show", id: subscriptionInstance.id)
        }
        else {
            render(view: "create", model: [subscriptionInstance: subscriptionInstance])
        }
    }

    def show = {
        def subscriptionInstance = Subscription.get(params.id)
        if (!subscriptionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
            redirect(action: "list")
        }
        else {
            [subscriptionInstance: subscriptionInstance]
        }
    }

    def edit = {
        def subscriptionInstance = Subscription.get(params.id)
        if (!subscriptionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [subscriptionInstance: subscriptionInstance]
        }
    }

    def update = {
        def subscriptionInstance = Subscription.get(params.id)
        if (subscriptionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (subscriptionInstance.version > version) {
                    
                    subscriptionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'subscription.label', default: 'Subscription')] as Object[], "Another user has updated this Subscription while you were editing")
                    render(view: "edit", model: [subscriptionInstance: subscriptionInstance])
                    return
                }
            }
            subscriptionInstance.properties = params
            if (!subscriptionInstance.hasErrors() && subscriptionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'subscription.label', default: 'Subscription'), subscriptionInstance.id])}"
                redirect(action: "show", id: subscriptionInstance.id)
            }
            else {
                render(view: "edit", model: [subscriptionInstance: subscriptionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def subscriptionInstance = Subscription.get(params.id)
        if (subscriptionInstance) {
            try {
                subscriptionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscription.label', default: 'Subscription'), params.id])}"
            redirect(action: "list")
        }
    }
}
