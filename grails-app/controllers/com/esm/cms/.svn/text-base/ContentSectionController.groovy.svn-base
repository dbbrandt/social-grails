package com.esm.cms

import com.esm.esmzone.User;

class ContentSectionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Mark sections with status as inactive
	Boolean deactivateSections(contentSection, status) {
	    def activeSections = ContentSection.findAllWhere(page:contentSection.page, name: contentSection.name, sequence:contentSection.sequence, status:status)
		if (activeSections) {
			activeSections.each { section ->
				section.status = ContentStatus.INACTIVE
				section.save()
			}
			return true
		}
		return false
	}

	def duplicateSection(contentSection) {
		def active = contentSection
		def pending = new ContentSection()
		pending.author = active.author
		pending.page = active.page
		pending.name = active.name
		pending.title = active.title
		pending.description = active.description
		pending.content = active.content
		pending.template = active.template
		pending.sequence = active.sequence
		pending.status = ContentStatus.PENDING
		if (pending.validate()) {
			pending.save()
			return pending
		}
		else {
			println "failed to create pending section: " + pending.errors
		}
		return null
	}
	
    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contentSectionInstanceList: ContentSection.list(params), contentSectionInstanceTotal: ContentSection.count()]
    }

    def create = {
        def contentSectionInstance = new ContentSection()
        contentSectionInstance.properties = params
        return [contentSectionInstance: contentSectionInstance]
    }

    def save = {
        def contentSectionInstance = new ContentSection(params)
        if (contentSectionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), contentSectionInstance.id])}"
            redirect(action: "show", id: contentSectionInstance.id)
        }
        else {
            render(view: "create", model: [contentSectionInstance: contentSectionInstance])
        }
    }

    def show = {
        def contentSectionInstance = ContentSection.get(params.id)
        if (!contentSectionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
            redirect(action: "list")
        }
        else {
            [contentSectionInstance: contentSectionInstance]
        }
    }

    def edit = {
        def contentSectionInstance = ContentSection.get(params.id)
        if (!contentSectionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
            redirect(action: "list")
        }
        else {
			if (contentSectionInstance.status == ContentStatus.ACTIVE) {
				contentSectionInstance = duplicateSection(contentSectionInstance)
			}
            return [contentSectionInstance: contentSectionInstance]
        }
    }

    def update = {
        def contentSectionInstance = ContentSection.get(params.id)
        if (contentSectionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (contentSectionInstance.version > version) {
                    
                    contentSectionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contentSection.label', default: 'ContentSection')] as Object[], "Another user has updated this ContentSection while you were editing")
                    render(view: "edit", model: [contentSectionInstance: contentSectionInstance])
                    return
                }
            }
			// save original status and then check if changed to Active
			Boolean originalStatus = contentSectionInstance.status
            contentSectionInstance.properties = params
			Boolean activated = ((contentSectionInstance.status == ContentStatus.ACTIVE) && (originalStatus != ContentStatus.ACTIVE))
			Boolean pended = ((contentSectionInstance.status == ContentStatus.PENDING) && (originalStatus == ContentStatus.ACTIVE))
			// Deactivate any active sections so only one section is active
			if (activated) {
				this.deactivateSections contentSectionInstance, ContentStatus.ACTIVE
			}
			// Deactivate any pending items so only one section is pending
			if (pended) {
				this.deactivateSections contentSectionInstance, ContentStatus.PENDING
			}
            if (!contentSectionInstance.hasErrors() && contentSectionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), contentSectionInstance.id])}"
                redirect(action: "show", id: contentSectionInstance.id)
            }
            else {
                render(view: "edit", model: [contentSectionInstance: contentSectionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def contentSectionInstance = ContentSection.get(params.id)
        if (contentSectionInstance) {
            try {
                contentSectionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentSection.label', default: 'ContentSection'), params.id])}"
            redirect(action: "list")
        }
    }
}
