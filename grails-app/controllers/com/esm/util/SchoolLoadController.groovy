package com.esm.util

import com.esm.esmzone.*

class SchoolLoadController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [schoolLoadInstanceList: SchoolLoad.list(params), schoolLoadInstanceTotal: SchoolLoad.count()]
    }

    def create = {
        def schoolLoadInstance = new SchoolLoad()
        schoolLoadInstance.properties = params
        return [schoolLoadInstance: schoolLoadInstance]
    }

    def save = {
        def schoolLoadInstance = new SchoolLoad(params)
        if (schoolLoadInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), schoolLoadInstance.id])}"
            redirect(action: "show", id: schoolLoadInstance.id)
        }
        else {
            render(view: "create", model: [schoolLoadInstance: schoolLoadInstance])
        }
    }

    def show = {
        def schoolLoadInstance = SchoolLoad.get(params.id)
        if (!schoolLoadInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
            redirect(action: "list")
        }
        else {
            [schoolLoadInstance: schoolLoadInstance]
        }
    }

    def load = {
		params.max = Math.min(params.max ? params.int('max') : 100, 10000)
		def schoolLoadList = SchoolLoad.list(params)
		def address
		def schoolLoad
		def school
		schoolLoadList.each {
			schoolLoad = it
			if (!School.findByName(schoolLoad.name)) {
				address = new Address(street:schoolLoad.street, city:schoolLoad.city, state:schoolLoad.state, postalCode:schoolLoad.postalCode)
				if (address.validate()) {
					address.save(flush:true)
					school = new School(name:schoolLoad.name, address:address, type:schoolLoad.type)
					if (school.validate()) {
						school.save(flush:true)
						schoolLoad.delete(flush:true)
					}
					else {
						println("Bad school data. $school.id " + school)
					}
				}
				else {
					println("Bad address data. $school.id " + school)
				}
				
			}
			else {
				//duplicate
				schoolLoad.delete(flush:true)
			}
		}
		redirect(controller:"school",action:"list" )
    }
    
    def edit = {
		def schoolLoadInstance = SchoolLoad.get(params.id)
        if (!schoolLoadInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [schoolLoadInstance: schoolLoadInstance]
        }
    }

    def update = {
        def schoolLoadInstance = SchoolLoad.get(params.id)
        if (schoolLoadInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (schoolLoadInstance.version > version) {
                    
                    schoolLoadInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'schoolLoad.label', default: 'SchoolLoad')] as Object[], "Another user has updated this SchoolLoad while you were editing")
                    render(view: "edit", model: [schoolLoadInstance: schoolLoadInstance])
                    return
                }
            }
            schoolLoadInstance.properties = params
            if (!schoolLoadInstance.hasErrors() && schoolLoadInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), schoolLoadInstance.id])}"
                redirect(action: "show", id: schoolLoadInstance.id)
            }
            else {
                render(view: "edit", model: [schoolLoadInstance: schoolLoadInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def schoolLoadInstance = SchoolLoad.get(params.id)
        if (schoolLoadInstance) {
            try {
                schoolLoadInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'schoolLoad.label', default: 'SchoolLoad'), params.id])}"
            redirect(action: "list")
        }
    }
}
