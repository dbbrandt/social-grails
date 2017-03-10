package com.esm.cms

class ContentTemplateController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contentTemplateInstanceList: ContentTemplate.list(params), contentTemplateInstanceTotal: ContentTemplate.count()]
    }

    def create = {
        def contentTemplateInstance = new ContentTemplate()
        contentTemplateInstance.properties = params
        return [contentTemplateInstance: contentTemplateInstance]
    }

    def save = {
        def contentTemplateInstance = new ContentTemplate(params)
        if (contentTemplateInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), contentTemplateInstance.id])}"
            redirect(action: "show", id: contentTemplateInstance.id)
        }
        else {
            render(view: "create", model: [contentTemplateInstance: contentTemplateInstance])
        }
    }

    def show = {
        def contentTemplateInstance = ContentTemplate.get(params.id)
        if (!contentTemplateInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
            redirect(action: "list")
        }
        else {
            [contentTemplateInstance: contentTemplateInstance]
        }
    }

    def edit = {
        def contentTemplateInstance = ContentTemplate.get(params.id)
        if (!contentTemplateInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [contentTemplateInstance: contentTemplateInstance]
        }
    }

    def update = {
        def contentTemplateInstance = ContentTemplate.get(params.id)
        if (contentTemplateInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (contentTemplateInstance.version > version) {
                    
                    contentTemplateInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contentTemplate.label', default: 'ContentTemplate')] as Object[], "Another user has updated this ContentTemplate while you were editing")
                    render(view: "edit", model: [contentTemplateInstance: contentTemplateInstance])
                    return
                }
            }
            contentTemplateInstance.properties = params
            if (!contentTemplateInstance.hasErrors() && contentTemplateInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), contentTemplateInstance.id])}"
                redirect(action: "show", id: contentTemplateInstance.id)
            }
            else {
                render(view: "edit", model: [contentTemplateInstance: contentTemplateInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def contentTemplateInstance = ContentTemplate.get(params.id)
        if (contentTemplateInstance) {
            try {
                contentTemplateInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentTemplate.label', default: 'ContentTemplate'), params.id])}"
            redirect(action: "list")
        }
    }
}
