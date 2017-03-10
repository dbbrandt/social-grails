package com.esm.dialog

import com.esm.esmzone.User
import com.esm.esmzone.UserStatus

class ComplaintController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [complaintInstanceList: Complaint.list(params), complaintInstanceTotal: Complaint.count()]
    }

    def report = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def complaintInstanceList
		if (!params.status) {
			params.status = "PENDING"
		}
        if (params.status != "ALL") {
			def status = Enum.valueOf(ComplaintStatus, params.status)
			complaintInstanceList =  Complaint.createCriteria().list(params) {
				eq('status',status)
			}
		}
		else {
			complaintInstanceList = Complaint.list(params)
		}
		[complaintInstanceList: complaintInstanceList, complaintInstanceTotal: Complaint.count()]
    }

    def create = {
        def complaintInstance = new Complaint()
        complaintInstance.properties = params
        return [complaintInstance: complaintInstance]
    }

    def add = {
		def complaintInstance = new Complaint()
		complaintInstance.properties = params
		complaintInstance.type = Enum.valueOf(ContentType, params.type)
		complaintInstance.user = request?.user
		if(request.method == 'POST') {
			println "Submitting Complaint" 
			println params
			//def className = "com.esm.dialog.Post"
			//def content = Thread.currentThread().contextClassLoader.loadClass(className).newInstance()
			def content = complaintInstance.getContent()
			if (!content) {
				flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
				return [complaintInstance: complaintInstance]
			}
			complaintInstance.author = content.author
			if (complaintInstance.save(flush:true)) {
			    content.complaint = complaintInstance
				content.save(flush:true)
				flash.message = "Complaint submitted."
				render(template:"close")
			}
			else {
				println complaintInstance.errors
				if (!params.message) {
					flash.message = "A description is required to flag inappropriate content. Please try again."
					println flash.message
				}
				else {
					flash.message = "Failed to submit complaint. Please contact the system adminstrator."
					println flash.message
				}
			}
		}
		return [complaintInstance: complaintInstance, className: Post.name]
	}

    
    def reject = {
        def complaintInstance = Complaint.get(params.id)
		if (complaintInstance) {
			complaintInstance.status = ComplaintStatus.REJECTED
			if (complaintInstance.save(flush:true)) {
				def content = complaintInstance.getContent()
				content.complaint = null
				content.save(flush:true)
				flash.message = "${message(code: 'default.complaint.reject.message', args: [message(code: 'complaint.label', default: 'Complaint'), complaintInstance.id])}"
				redirect(action:"report")
			}
		}
		render(view: "complaintReport", model: [complaintInstance: complaintInstance])
    }

    def accept = {
        def complaintInstance = Complaint.get(params.id)
		if (complaintInstance) {
			complaintInstance.status = ComplaintStatus.ACCEPTED
			if (complaintInstance.save(flush:true)) {
				def content = complaintInstance.getContent()
				content.complaint = complaintInstance
				content.save(flush:true)
				flash.message = "${message(code: 'default.complaint.accept.message', args: [message(code: 'complaint.label', default: 'Complaint'), complaintInstance.id])}"
				redirect(action:"report")
			}
		}
		render(view: "complaintReport", model: [complaintInstance: complaintInstance])
    }

    def suspend = {
        def complaintInstance = Complaint.get(params.id)
		if (complaintInstance) {
			def user = complaintInstance.author
			user.status = UserStatus.SUSPENDED
			if (user.save(flush:true)) {
				flash.message = "${message(code: 'default.user.suspended.message', args: [message(code: 'user.label', default: 'User'), user.id])}"
				redirect(action:"report")
			}
		}
		render(view: "complaintReport", model: [complaintInstance: complaintInstance])
    }

    def save = {
        def complaintInstance = new Complaint(params)
        if (complaintInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'complaint.label', default: 'Complaint'), complaintInstance.id])}"
            redirect(action: "show", id: complaintInstance.id)
        }
        else {
            render(view: "create", model: [complaintInstance: complaintInstance])
        }
    }

    def show = {
        def complaintInstance = Complaint.get(params.id)
        if (!complaintInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
            redirect(action: "list")
        }
        else {
            [complaintInstance: complaintInstance]
        }
    }

    def edit = {
        def complaintInstance = Complaint.get(params.id)
        if (!complaintInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [complaintInstance: complaintInstance]
        }
    }

    def update = {
        def complaintInstance = Complaint.get(params.id)
        if (complaintInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (complaintInstance.version > version) {
                    
                    complaintInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'complaint.label', default: 'Complaint')] as Object[], "Another user has updated this Complaint while you were editing")
                    render(view: "edit", model: [complaintInstance: complaintInstance])
                    return
                }
            }
            complaintInstance.properties = params
            if (!complaintInstance.hasErrors() && complaintInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'complaint.label', default: 'Complaint'), complaintInstance.id])}"
                redirect(action: "show", id: complaintInstance.id)
            }
            else {
                render(view: "edit", model: [complaintInstance: complaintInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def complaintInstance = Complaint.get(params.id)
        if (complaintInstance) {
            try {
                complaintInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'complaint.label', default: 'Complaint'), params.id])}"
            redirect(action: "list")
        }
    }
}
