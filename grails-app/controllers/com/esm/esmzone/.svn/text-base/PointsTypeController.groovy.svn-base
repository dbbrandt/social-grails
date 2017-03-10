package com.esm.esmzone

class PointsTypeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [pointsTypeInstanceList: PointsType.list(params), pointsTypeInstanceTotal: PointsType.count()]
    }

    def create = {
        def pointsTypeInstance = new PointsType()
        pointsTypeInstance.properties = params
        return [pointsTypeInstance: pointsTypeInstance]
    }

    def save = {
        def pointsTypeInstance = new PointsType(params)
        if (pointsTypeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'pointsType.label', default: 'PointsType'), pointsTypeInstance.id])}"
            redirect(action: "show", id: pointsTypeInstance.id)
        }
        else {
            render(view: "create", model: [pointsTypeInstance: pointsTypeInstance])
        }
    }

    def show = {
        def pointsTypeInstance = PointsType.get(params.id)
        if (!pointsTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
            redirect(action: "list")
        }
        else {
            [pointsTypeInstance: pointsTypeInstance]
        }
    }

    def edit = {
        def pointsTypeInstance = PointsType.get(params.id)
        if (!pointsTypeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [pointsTypeInstance: pointsTypeInstance]
        }
    }

    def update = {
        def pointsTypeInstance = PointsType.get(params.id)
        if (pointsTypeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (pointsTypeInstance.version > version) {
                    
                    pointsTypeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'pointsType.label', default: 'PointsType')] as Object[], "Another user has updated this PointsType while you were editing")
                    render(view: "edit", model: [pointsTypeInstance: pointsTypeInstance])
                    return
                }
            }
            pointsTypeInstance.properties = params
            if (!pointsTypeInstance.hasErrors() && pointsTypeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'pointsType.label', default: 'PointsType'), pointsTypeInstance.id])}"
                redirect(action: "show", id: pointsTypeInstance.id)
            }
            else {
                render(view: "edit", model: [pointsTypeInstance: pointsTypeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def pointsTypeInstance = PointsType.get(params.id)
        if (pointsTypeInstance) {
            try {
                pointsTypeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'pointsType.label', default: 'PointsType'), params.id])}"
            redirect(action: "list")
        }
    }
}
