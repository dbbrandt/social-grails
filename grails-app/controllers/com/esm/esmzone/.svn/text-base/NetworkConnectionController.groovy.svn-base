package com.esm.esmzone

import org.hibernate.FetchMode as FM

class NetworkConnectionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [networkConnectionInstanceList: NetworkConnection.list(params), networkConnectionInstanceTotal: NetworkConnection.count()]
    }

    def scoutReport = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (!params.offset) {
			params.offset = 0
		}
        def user = User.get(request?.user.id)
		def networkConnectionInstanceList =  NetworkConnection.createCriteria().list(params) {
			eq('friend',user)
			eq('status',NetworkConnectionStatus.PENDING)
        }
        [networkConnectionInstanceList: networkConnectionInstanceList, networkConnectionInstanceTotal: networkConnectionInstanceList.count()]
    }

    def requestReport = {
        def user = User.get(request?.user.id)
		def networkConnectionInstanceList =  NetworkConnection.createCriteria().list() {
			eq('friend',user)
			eq('status',NetworkConnectionStatus.PENDING)
			order("dateCreated","desc")
        }
        [networkConnectionInstanceList: networkConnectionInstanceList, networkConnectionInstanceTotal: networkConnectionInstanceList.count()]
    }

    
    def fanReport = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		if (!params.offset) {
			params.offset = 0
		}
        def user = User.get(request?.user?.id)
		def mentorList =  NetworkConnection.createCriteria().list(params) {
			eq('user',user)
			eq('status',NetworkConnectionStatus.ACTIVE)
			eq('type', NetworkConnectionType.MENTOR)
        }
		def menteeList =  NetworkConnection.createCriteria().list(params) {
			eq('friend',user)
			eq('status',NetworkConnectionStatus.ACTIVE)
			eq('type', NetworkConnectionType.MENTOR)
		}
		def fanList =  NetworkConnection.createCriteria().list(params) {
			or {
				eq('user',user)
				eq('friend',user)
			}
			eq('status',NetworkConnectionStatus.ACTIVE)
			eq('type', NetworkConnectionType.FAN)
		}
		[mentorList: mentorList, mentorListTotal: mentorList.size(),menteeList: menteeList, menteeListTotal: menteeList.size(),fanList: fanList, fanListTotal: fanList.size()]
    }

	def requestMentor = {
		if (request.method == 'POST') {
			def networkConnectionInstance = new NetworkConnection(params)
			if (networkConnectionInstance.save(flush:true)) {
				redirect(controller:"user", action:"directory")
			}
			else {
				return [networkConnectionInstance:networkConnectionInstance] 
			}
		}			
		def user = User.get(request?.user?.id)
		def mentor = User.get(params?.id)
		def networkConnectionInstance = new NetworkConnection(user:user, friend:mentor,type:NetworkConnectionType.MENTOR)
		return [networkConnectionInstance:networkConnectionInstance]
	}

	def requestAMentor = {
		def userInstance = User.get(params.id)
		if (request.method == 'POST') {
			def networkConnectionInstance = new NetworkConnection(params)
			networkConnectionInstance.type = NetworkConnectionType.MENTOR
			if (!networkConnectionInstance.save(flush:true)) {
				flash.message = "Request failed."
			}
			render("Request Submitted.")
		}
		return [userInstance:userInstance]
	}

	def requestAFan = {
		def userInstance = User.get(params.id)
		if (request.method == 'POST') {
			def networkConnectionInstance = new NetworkConnection(params)
			networkConnectionInstance.type = NetworkConnectionType.FAN
			if (!networkConnectionInstance.save(flush:true)) {
				flash.message = "Request failed."
			}
			render("Request Submitted." + networkConnectionInstance.errors)
		}
		return [userInstance:userInstance]
	}

    
    def requestFan = {
		if (request.method == 'POST') {
			def networkConnectionInstance = new NetworkConnection(params)
			if (networkConnectionInstance.save(flush:true)) {
				redirect(controller:"user", action:"directory")
			}
			else {
				return [networkConnectionInstance:networkConnectionInstance] 
			}
		}			
		def user = User.get(request?.user?.id)
		def mentor = User.get(params?.id)
		def networkConnectionInstance = new NetworkConnection(user:user, friend:mentor,type:NetworkConnectionType.FAN)
		return [networkConnectionInstance:networkConnectionInstance]
	}

	def acceptConnection = {
		def networkConnectionInstance = NetworkConnection.get(params.id)
		if (networkConnectionInstance) {
			networkConnectionInstance.status = NetworkConnectionStatus.ACTIVE
			if (networkConnectionInstance.save(flush:true)) {
				// add alert to member accepted as fan
				def member = networkConnectionInstance.user
				def fanMessage = "accepted you as a fan."
				if (networkConnectionInstance.type == NetworkConnectionType.FAN) {
					flash.message = "${networkConnectionInstance.user} is now your fan!"
				}
				else if (networkConnectionInstance.type == NetworkConnectionType.MENTOR) {
					flash.message = "${networkConnectionInstance.user} is now your mentee!"
					fanType = "accepted you as a mentee."
				}
				member.transactionAlert(ESMTransactionType.FAN,fanMessage, request.user,member.id)
			}
			else {
				flash.message = "Failed to complete request. Please contact the system administrator."
			}
		}
		redirect(action:"requestReport")
	}

	def declineConnection = {
		def networkConnectionInstance = NetworkConnection.get(params.id)
		if (networkConnectionInstance) {
			NetworkConnectionType type = networkConnectionInstance.type
			try {
				networkConnectionInstance.delete(flush: true)
				if (type == NetworkConnectionType.FAN) {
					flash.message = "${networkConnectionInstance.user}'s fan request has been declined."
				}
				else if (type == NetworkConnectionType.MENTOR) {
					flash.message = "${networkConnectionInstance.user}'s mentor request has been declined."
				}
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
			}
		}
		redirect(action:"requestReport")
	}

	def removeConnection = {
		def networkConnectionInstance = NetworkConnection.get(params.id)
		if (networkConnectionInstance) {
			try {
				NetworkConnectionType type = networkConnectionInstance.type
				networkConnectionInstance.delete(flush: true)
				if (type == NetworkConnectionType.FAN) {
					flash.message = "${networkConnectionInstance.user}'s fan has been removed."
				}
				else if (type == NetworkConnectionType.MENTOR) {
					flash.message = "${networkConnectionInstance.user}'s mentor relationship has been removed."
				}
			}
			catch (org.springframework.dao.DataIntegrityViolationException e) {
				flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
			}
		}
		redirect(action:"fanReport")
	}

	def removeAConnection = {
		def networkConnectionInstance
		def userInstance
		if (request.method == 'POST') {
			println "Connection id: " + params.id
			networkConnectionInstance = NetworkConnection.get(params.id)
			if (networkConnectionInstance) {
				networkConnectionInstance.delete(flush:true)
			}
			else {
				println "No connection found"
				flash.message = "Failed to delete fan connection"
			}
		}
		else {
			def user = User.get(params.id)
			println "User: " + user
			def networkConnectionId = request?.user.getNetworkConnectionId(user)
			networkConnectionInstance = NetworkConnection.get(networkConnectionId)
			if (networkConnectionInstance.user == user) {
				userInstance = networkConnectionInstance.user
			}
			else {
				userInstance = networkConnectionInstance.friend
			}
			println "Network Connection: " + networkConnectionInstance + " User: " + userInstance
		}
		return [networkConnectionInstance:networkConnectionInstance, userInstance:userInstance]
	}

    def create = {
        def networkConnectionInstance = new NetworkConnection()
        networkConnectionInstance.properties = params
        return [networkConnectionInstance: networkConnectionInstance]
    }

    def save = {
        def networkConnectionInstance = new NetworkConnection(params)
        if (networkConnectionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), networkConnectionInstance.id])}"
            redirect(action: "show", id: networkConnectionInstance.id)
        }
        else {
            render(view: "create", model: [networkConnectionInstance: networkConnectionInstance])
        }
    }

    def show = {
        def networkConnectionInstance = NetworkConnection.get(params.id)
        if (!networkConnectionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
            redirect(action: "list")
        }
        else {
            [networkConnectionInstance: networkConnectionInstance]
        }
    }

    def edit = {
        def networkConnectionInstance = NetworkConnection.get(params.id)
        if (!networkConnectionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [networkConnectionInstance: networkConnectionInstance]
        }
    }

    def update = {
        def networkConnectionInstance = NetworkConnection.get(params.id)
        if (networkConnectionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (networkConnectionInstance.version > version) {
                    
                    networkConnectionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'networkConnection.label', default: 'NetworkConnection')] as Object[], "Another user has updated this NetworkConnection while you were editing")
                    render(view: "edit", model: [networkConnectionInstance: networkConnectionInstance])
                    return
                }
            }
            networkConnectionInstance.properties = params
            if (!networkConnectionInstance.hasErrors() && networkConnectionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), networkConnectionInstance.id])}"
                redirect(action: "show", id: networkConnectionInstance.id)
            }
            else {
                render(view: "edit", model: [networkConnectionInstance: networkConnectionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def networkConnectionInstance = NetworkConnection.get(params.id)
        if (networkConnectionInstance) {
            try {
                networkConnectionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'networkConnection.label', default: 'NetworkConnection'), params.id])}"
            redirect(action: "list")
        }
    }
}
