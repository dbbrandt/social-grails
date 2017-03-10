package com.esm.esmzone

class PaymentMethodController {
	
	def scaffold = true
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [paymentMethodInstanceList: PaymentMethod.list(params), paymentMethodInstanceTotal: PaymentMethod.count()]
    }

    def create = {
        def paymentMethodInstance = new PaymentMethod()
        paymentMethodInstance.properties = params
        return [paymentMethodInstance: paymentMethodInstance]
    }

    def save = {
        def paymentMethodInstance = new PaymentMethod(params)
        if (paymentMethodInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), paymentMethodInstance.id])}"
            redirect(action: "show", id: paymentMethodInstance.id)
        }
        else {
            render(view: "create", model: [paymentMethodInstance: paymentMethodInstance])
        }
    }

    def show = {
        def paymentMethodInstance = PaymentMethod.get(params.id)
        if (!paymentMethodInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
            redirect(action: "list")
        }
        else {
            [paymentMethodInstance: paymentMethodInstance]
        }
    }

    def edit = {
        def paymentMethodInstance = PaymentMethod.get(params.id)
        if (!paymentMethodInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [paymentMethodInstance: paymentMethodInstance]
        }
    }

    def update = {
        def paymentMethodInstance = PaymentMethod.get(params.id)
        if (paymentMethodInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (paymentMethodInstance.version > version) {
                    
                    paymentMethodInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'paymentMethod.label', default: 'PaymentMethod')] as Object[], "Another user has updated this PaymentMethod while you were editing")
                    render(view: "edit", model: [paymentMethodInstance: paymentMethodInstance])
                    return
                }
            }
            paymentMethodInstance.properties = params
            if (!paymentMethodInstance.hasErrors() && paymentMethodInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), paymentMethodInstance.id])}"
                redirect(action: "show", id: paymentMethodInstance.id)
            }
            else {
                render(view: "edit", model: [paymentMethodInstance: paymentMethodInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def paymentMethodInstance = PaymentMethod.get(params.id)
        if (paymentMethodInstance) {
            try {
                paymentMethodInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'paymentMethod.label', default: 'PaymentMethod'), params.id])}"
            redirect(action: "list")
        }
    }
}
