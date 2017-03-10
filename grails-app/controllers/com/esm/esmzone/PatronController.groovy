package com.esm.esmzone

import org.jsecurity.crypto.hash.Sha1Hash

class PatronController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [patronInstanceList: Patron.list(params), patronInstanceTotal: Patron.count()]
    }

    def create = {
        def patronInstance = new Patron()
        patronInstance.properties = params
        return [patronInstance: patronInstance]
    }

    def save = {
        def patronInstance = new Patron(params)
        if (patronInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'patron.label', default: 'Patron'), patronInstance.id])}"
            redirect(action: "show", id: patronInstance.id)
        }
        else {
            render(view: "create", model: [patronInstance: patronInstance])
        }
    }

    def show = {
        def patronInstance = Patron.get(params.id)
        if (!patronInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
            redirect(action: "list")
        }
        else {
            [patronInstance: patronInstance]
        }
    }

    def edit = {
        def patronInstance = Patron.get(params.id)
        if (!patronInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [patronInstance: patronInstance]
        }
    }

    def update = {
        def patronInstance = Patron.get(params.id)
        if (patronInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (patronInstance.version > version) {
                    
                    patronInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'patron.label', default: 'Patron')] as Object[], "Another user has updated this Patron while you were editing")
                    render(view: "edit", model: [patronInstance: patronInstance])
                    return
                }
            }
            patronInstance.properties = params
            if (!patronInstance.hasErrors() && patronInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'patron.label', default: 'Patron'), patronInstance.id])}"
                redirect(action: "show", id: patronInstance.id)
            }
            else {
                render(view: "edit", model: [patronInstance: patronInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def patronInstance = Patron.get(params.id)
        if (patronInstance) {
            try {
                patronInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'patron.label', default: 'Patron'), params.id])}"
            redirect(action: "list")
        }
    }
	
	def register = {
		def sqlist = SecurityQuestion.list()
		def patron = new Patron(params)
		def address = new Address(params)
		if(request.method == 'POST') {
			if(Patron.findByEmail(params.email)) {
				return [securityQuestionList: sqlist, patron:patron, message:"patron.already.exists"]
			}
			else if(patron.password != params.confirm) {
				patron.errors.rejectValue("password", "patron.password.dontmatch")
				return [securityQuestionList: sqlist, patron:patron, address:address]
			}			
			else {
				patron.textPassword = patron.password
				patron.password = new Sha1Hash(patron.password).toHex()
				patron.securityQuestion = SecurityQuestion.get(params.securityQuestion.id);
				if (address.validate()) {
					address.save(flush:true)
					patron.address = address
					if(patron.validate()) {
						patron.save(flush:true)
						try {
							sendMail {
								to patron.email
								subject "Patron Confirmation"
								body view:"/emails/confirmPatronRegistration",
								model:[patron:patron]
							}					
						}
						catch(Exception e) {
							log.error "Problem sending email $e.message", e
						}
						//redirect(controller:"store", action:"shop")
						flash.message = "You application to become a Patron has been submitted."
						redirect(controller: "home", action: "index")
						return
					}
					else {
						return [securityQuestionList: sqlist, patron:patron, address:address]
					}
				}
				else {
					def patronErrors = patron.errors
					return [securityQuestionList: sqlist, patron:patron,address:address]
				}					
			}
		}
		return [securityQuestionList: sqlist]
	}

    def patronRequests = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (!params.offset) {
			params.offset = 0
		}
		def patronInstanceList =  Patron.createCriteria().list(params) {
			eq('status',PatronStatus.PENDING)
		}
		[patronInstanceList: patronInstanceList, patronInstanceTotal: patronInstanceList.count()]
	}
	
	def acceptPatron = {
		def patronInstance = Patron.get(params.id)
		if (patronInstance) {
			patronInstance.status = PatronStatus.ACTIVE
			def source = new Source(name:patronInstance.organizationName)
			if (source.validate()) {
				source.save()
				patronInstance.source = source
				if (patronInstance.validate()) {
					patronInstance.save(flush:true)
					flash.message = "Patron accepted. New source created." + source
				}
				else {
					flash.message = "Failed to complete request. Please contact the system administrator."
				}
			}
		}
		redirect(action:"patronRequests")
	}
	
	def declinePatron = {
		def patronInstance = patron.get(params.id)
		if (patronInstance) {
			patronInstance.status = PatronStatus.REJECTED
			if (patronInstance.validate()) {
				patronInstance.save(flush:true)
			}
			else {
				flash.message = "Failed to complete request. Please contact the system administrator."
			}
		}
		redirect(action:"patronRequests")
	}
	
	
}
