package com.esm.esmzone

class PointsController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pointsInstanceList: Points.list(params), pointsInstanceTotal: Points.count()]
    }

    def statsSheet = {
		params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def user = User.get(request?.user?.id)
		def c = Points.createCriteria()
		def pointsList =  c {
			eq('user',user) 
			projections {
				count('id')
				sum('points')
				groupProperty('type')
			}
		}
		def pointsInstanceList = []  
		pointsList.each {
			pointsInstanceList.add('id':it[2].id,'type':it[2].name,'value':it[2].points,'count':it[0],'points':it[1])
		}
		pointsInstanceList.sort{it.id}
		def pointsInstanceCount = pointsInstanceList.sum{it.count}
		def pointsInstanceTotal = pointsInstanceList.sum{it.points}
		[pointsInstanceList: pointsInstanceList, pointsInstanceCount: pointsInstanceCount, pointsInstanceTotal: pointsInstanceTotal ]
	}
	
    def create = {
        def pointsInstance = new Points()
        pointsInstance.properties = params
        return [pointsInstance: pointsInstance]
    }

    def save = {
        def pointsInstance = new Points(params)
        if (pointsInstance.save(flush: true)) {
			def user = User.get(request?.user?.id)
			user.addPoints(pointsInstance.type)
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'points.label', default: 'Points'), pointsInstance.id])}"
            redirect(action: "show", id: pointsInstance.id)
        }
        else {
            render(view: "create", model: [pointsInstance: pointsInstance])
        }
    }

    def show = {
        def pointsInstance = Points.get(params.id)
        if (!pointsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
            redirect(action: "list")
        }
        else {
            [pointsInstance: pointsInstance]
        }
    }

    def edit = {
        def pointsInstance = Points.get(params.id)
        if (!pointsInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [pointsInstance: pointsInstance]
        }
    }

    def update = {
        def pointsInstance = Points.get(params.id)
        if (pointsInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (pointsInstance.version > version) {
                    
                    pointsInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'points.label', default: 'Points')] as Object[], "Another user has updated this Points while you were editing")
                    render(view: "edit", model: [pointsInstance: pointsInstance])
                    return
                }
            }
            pointsInstance.properties = params
            if (!pointsInstance.hasErrors() && pointsInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'points.label', default: 'Points'), pointsInstance.id])}"
                redirect(action: "show", id: pointsInstance.id)
            }
            else {
                render(view: "edit", model: [pointsInstance: pointsInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def pointsInstance = Points.get(params.id)
        if (pointsInstance) {
            try {
				def userInstance = User.get(params.id)
				userInstance.removePoints(pointsInstance)
				pointsInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'points.label', default: 'Points'), params.id])}"
            redirect(action: "list")
        }
    }
}
