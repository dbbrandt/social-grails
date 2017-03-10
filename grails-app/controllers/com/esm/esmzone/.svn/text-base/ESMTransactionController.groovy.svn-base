package com.esm.esmzone

class ESMTransactionController {

	// methods to identify the controller and action to display the transaction
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]


	static String controller(type) {
		switch (type) {
			case ESMTransactionType.QUESTION:
			case ESMTransactionType.MESSAGE:
			case ESMTransactionType.ANSWER:
				return 'post'
				break
			case ESMTransactionType.FAN:
				return 'user'
				break
		}
	}

	static String action(type) {
		switch (type) {
			case ESMTransactionType.QUESTION:
			case ESMTransactionType.ANSWER:
				return 'view'
				break
			case ESMTransactionType.MESSAGE:
				return 'addMessage'
				break
			case ESMTransactionType.FAN:
				return 'fanReport'
				break
		}
	}
	
	// return appropriate passed in string if UI is a pop-up (used for class and target tags in anchor)
	static String isIframe(type, trueString, falseString=null) {
		switch (type) { 
			case ESMTransactionType.MESSAGE:
			case ESMTransactionType.FAN:
				return trueString
				break
		}
		return falseString
	}
	
	static String shortMessage(trans, max=75) {
		def messageText = trans.message
		if (trans.message.size() > max) {
			messageText = trans.message[0..max] + "..."
		}
		return messageText
	}
	
	static String alertFormat(trans, newOnly=true) {
		def formatString = ""
		if ((trans.viewed == ViewedStatus.NEW) || (!newOnly && (trans.viewed == ViewedStatus.CLEARED))) {
			formatString = "color:#DE3804;font-weight:bold;"
		}
		return formatString
	}
	
	def viewDetail = {
		def trans =	ESMTransaction.get(params.id)	
		trans.viewed = ViewedStatus.VIEWED
		trans.save()
		def detailCtlr = this.controller(trans?.type)
		def detailAction = this.action(trans?.type)
		def user = request?.user
		if (user?.alertCount > 0) {
			user.alertCount--
			user.save()
		}
		redirect(controller:detailCtlr, action: detailAction, id: trans?.contentId)
	} 

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [ESMTransactionInstanceList: ESMTransaction.list(params), ESMTransactionInstanceTotal: ESMTransaction.count()]
    }

    def create = {
        def ESMTransactionInstance = new ESMTransaction()
        ESMTransactionInstance.properties = params
        return [ESMTransactionInstance: ESMTransactionInstance]
    }

    def save = {
        def ESMTransactionInstance = new ESMTransaction(params)
        if (ESMTransactionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), ESMTransactionInstance.id])}"
            redirect(action: "show", id: ESMTransactionInstance.id)
        }
        else {
            render(view: "create", model: [ESMTransactionInstance: ESMTransactionInstance])
        }
    }

    def show = {
        def ESMTransactionInstance = ESMTransaction.get(params.id)
        if (!ESMTransactionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
            redirect(action: "list")
        }
        else {
            [ESMTransactionInstance: ESMTransactionInstance]
        }
    }

    def edit = {
        def ESMTransactionInstance = ESMTransaction.get(params.id)
        if (!ESMTransactionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [ESMTransactionInstance: ESMTransactionInstance]
        }
    }

    def update = {
        def ESMTransactionInstance = ESMTransaction.get(params.id)
        if (ESMTransactionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (ESMTransactionInstance.version > version) {
                    
                    ESMTransactionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'ESMTransaction.label', default: 'ESMTransaction')] as Object[], "Another user has updated this ESMTransaction while you were editing")
                    render(view: "edit", model: [ESMTransactionInstance: ESMTransactionInstance])
                    return
                }
            }
            ESMTransactionInstance.properties = params
            if (!ESMTransactionInstance.hasErrors() && ESMTransactionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), ESMTransactionInstance.id])}"
                redirect(action: "show", id: ESMTransactionInstance.id)
            }
            else {
                render(view: "edit", model: [ESMTransactionInstance: ESMTransactionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def ESMTransactionInstance = ESMTransaction.get(params.id)
        if (ESMTransactionInstance) {
            try {
                ESMTransactionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'ESMTransaction.label', default: 'ESMTransaction'), params.id])}"
            redirect(action: "list")
        }
    }
	
	def transactionReport = {
		def user = User.get(request?.user?.id)
		user.alertCount = 0
		user.save()
		def transactionList =  user.transactionList(0)
		// mark all not yet viewed transactions as viewed
		transactionList.each { trans->
			if (trans.viewed == ViewedStatus.NEW) {
				trans.viewed = ViewedStatus.CLEARED
				trans.save()
			}
		}
		[transactionList: transactionList, transactionListTotal: transactionList.count()]
	}

	def clearTransaction = {
		def trans = ESMTransaction.get(params.id)
		trans.cleared = true
		trans.save()
		redirect(action:transactionReport)
	}
}
