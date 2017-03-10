package com.esm.cms

import com.esm.esmzone.SystemConfig;
 
class ContentPageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	// Mark sections as inactive
	Boolean deactivatePages(contentPage, status) {
		def workingPages = ContentPage.findAllWhere(view: contentPage.view, status:status)
		if (workingPages) {
			workingPages.each { page ->
				println "Updating page status to inactive for " + page
				page.status = ContentStatus.INACTIVE
				page.save()
			}
			return true
		}
		return false
	}

	def duplicateSections(originalPage, copyedPage) {
		originalPage.sections.each { section->
			def active = section
			def pending = new ContentSection()
			pending.author = active.author
			pending.page = copyedPage
			pending.name = active.name
			pending.title = active.title
			pending.description = active.description
			pending.content = active.content
			pending.template = active.template
			pending.sequence = active.sequence
			// Don't set inactive section as pending as they will show up in show pending and 
			// may result in duplicate sections being made pending.
			if (active.status == ContentStatus.ACTIVE) {			
				pending.status = ContentStatus.PENDING
			}
			if (pending.validate()) {
				pending.save()
			}
			else {
				println "failed to create pending section for page $contentPage: " + pending.errors
			}
		}
	}

	// Used to activate all sections for a page
	def activateSections(contentPage) {
		contentPage.sections.each { section->
			// only activate sections that are pending. Inactive are left alone.
			if (section.status == ContentStatus.PENDING) {
				section.status = ContentStatus.ACTIVE
				if (section.validate()) {
					section.save()
				}
				else {
					println "failed to activate pending section for page $contentPage: " + section.errors
				}
			}
		}
	}

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
		def  systemConfig = SystemConfig.get(1)
		def pendingMode = systemConfig.showPendingContent
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [contentPageInstanceList: ContentPage.list(params), contentPageInstanceTotal: ContentPage.count(), pendingMode: pendingMode]
    }
	
	def togglePendingMode = {
		def  systemConfig = SystemConfig.get(1)
		def pendingMode = !systemConfig.showPendingContent
		systemConfig.showPendingContent = pendingMode
		if (systemConfig.validate()) {
			systemConfig.save()
		}
        redirect(action: "list")
	}

    def create = {
        def contentPageInstance = new ContentPage()
        contentPageInstance.properties = params
        return [contentPageInstance: contentPageInstance]
    }

    def save = {
        def contentPageInstance = new ContentPage(params)
        if (contentPageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), contentPageInstance.id])}"
            redirect(action: "show", id: contentPageInstance.id)
        }
        else {
            render(view: "create", model: [contentPageInstance: contentPageInstance])
        }
    }

    def show = {
        def contentPageInstance = ContentPage.get(params.id)
        if (!contentPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [contentPageInstance: contentPageInstance]
        }
    }

    def edit = {
        def contentPageInstance = ContentPage.get(params.id)
        if (!contentPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
            redirect(action: "list")
        }
        else {
			if (contentPageInstance.status == ContentStatus.ACTIVE) {
				def active = contentPageInstance
				def pending = new ContentPage()
				pending.author = active.author
				pending.name = active.name
				pending.description = active.description
				pending.content = active.content
				pending.template = active.template
				pending.view = active.view
				pending.status = ContentStatus.PENDING
				if (pending.validate()) {
					pending.save(flush:true)
					contentPageInstance = pending
					this.duplicateSections(active, pending)
				}
				else {
					println "failed to create pending page: " + pending.errors
				}
			}
            return [contentPageInstance: contentPageInstance]
        }
    }

    def update = {
        def contentPageInstance = ContentPage.get(params.id)
        if (contentPageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (contentPageInstance.version > version) {
                    
                    contentPageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contentPage.label', default: 'ContentPage')] as Object[], "Another user has updated this ContentPage while you were editing")
                    render(view: "edit", model: [contentPageInstance: contentPageInstance])
                    return
                }
            }
			// save original status and then check if changed to Active
			def originalStatus = contentPageInstance.status
			println "Original Status of page " + originalStatus
            contentPageInstance.properties = params
			println "New status of page " + contentPageInstance.status
			Boolean activated = ((contentPageInstance.status == ContentStatus.ACTIVE) && (originalStatus != ContentStatus.ACTIVE))
			Boolean pended = ((contentPageInstance.status == ContentStatus.PENDING) && (originalStatus != ContentStatus.PENDING))
			if (activated) {
				this.deactivatePages contentPageInstance, ContentStatus.ACTIVE
				this.activateSections contentPageInstance
			}
			if (pended) {
				this.deactivatePages contentPageInstance, ContentStatus.PENDING
			}
            if (!contentPageInstance.hasErrors() && contentPageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), contentPageInstance.id])}"
                redirect(action: "show", id: contentPageInstance.id)
            }
            else {
                render(view: "edit", model: [contentPageInstance: contentPageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
            redirect(action: "list")
        }
    }

	def deleteContent = {
		println "In delete content"
		def contentPageInstance = ContentPage.get(params.id)
		if (contentPageInstance) {
			if (params.version) {
				def version = params.version.toLong()
				if (contentPageInstance.version > version) {
					
					contentPageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'contentPage.label', default: 'ContentPage')] as Object[], "Another user has updated this ContentPage while you were editing")
					render(view: "edit", model: [contentPageInstance: contentPageInstance])
					return
				}
			}
			contentPageInstance.content = null
			println "Deleteing Content" + contentPageInstance.content
			if (!contentPageInstance.hasErrors() && contentPageInstance.save(flush: true)) {
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), contentPageInstance.id])}"
				redirect(action: "show", id: contentPageInstance.id)
			}
			else {
				render(view: "edit", model: [contentPageInstance: contentPageInstance])
			}
		}
		else {
			flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
			redirect(action: "list")
		}
	}

    def delete = {
        def contentPageInstance = ContentPage.get(params.id)
        if (contentPageInstance) {
            try {
                contentPageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'contentPage.label', default: 'ContentPage'), params.id])}"
            redirect(action: "list")
        }
    }
}
