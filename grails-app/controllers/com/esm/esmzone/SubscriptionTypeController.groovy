package com.esm.esmzone

class SubscriptionTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [subscriptionTypeInstanceList: SubscriptionType.list(params), subscriptionTypeInstanceTotal: SubscriptionType.count()]
    }

    def create = {
        def subscriptionTypeInstance = new SubscriptionType()
        subscriptionTypeInstance.properties = params
        return [subscriptionTypeInstance: subscriptionTypeInstance]
    }

    def save = {
        def subscriptionTypeInstance = new SubscriptionType(params)
        if (subscriptionTypeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), subscriptionTypeInstance.id])}"
            redirect(action: "show", id: subscriptionTypeInstance.id)
        }
        else {
            render(view: "create", model: [subscriptionTypeInstance: subscriptionTypeInstance])
        }
    }

    def show = {
        def subscriptionTypeInstance = SubscriptionType.get(params.id)
        if (!subscriptionTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
            redirect(action: "list")
        }
        else {
            [subscriptionTypeInstance: subscriptionTypeInstance]
        }
    }

    def edit = {
        def subscriptionTypeInstance = SubscriptionType.get(params.id)
        if (!subscriptionTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [subscriptionTypeInstance: subscriptionTypeInstance]
        }
    }

    def update = {
        def subscriptionTypeInstance = SubscriptionType.get(params.id)
        if (subscriptionTypeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (subscriptionTypeInstance.version > version) {
                    
                    subscriptionTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'subscriptionType.label', default: 'SubscriptionType')] as Object[], "Another user has updated this SubscriptionType while you were editing")
                    render(view: "edit", model: [subscriptionTypeInstance: subscriptionTypeInstance])
                    return
                }
            }
            subscriptionTypeInstance.properties = params
            if (!subscriptionTypeInstance.hasErrors() && subscriptionTypeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), subscriptionTypeInstance.id])}"
                redirect(action: "show", id: subscriptionTypeInstance.id)
            }
            else {
                render(view: "edit", model: [subscriptionTypeInstance: subscriptionTypeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def subscriptionTypeInstance = SubscriptionType.get(params.id)
        if (subscriptionTypeInstance) {
            try {
                subscriptionTypeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'subscriptionType.label', default: 'SubscriptionType'), params.id])}"
            redirect(action: "list")
        }
    }
}
