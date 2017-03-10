package com.esm.dialog

import groovy.xml.MarkupBuilder
import grails.converters.JSON

class TagController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [tagInstanceList: Tag.list(params), tagInstanceTotal: Tag.count()]
    }

    def treeView = {
		def writer = new StringWriter()
		def xml = new MarkupBuilder(writer)
		def rootList = Tag.getTopLevelTags()
		xml.tags(name:"tags") {
			rootList.each { cat ->
				category(name:cat.name, id: cat.id) {
					def topicList = cat.getSubTags()
					topicList.each { top ->
						topic(name: top.name, id: top.id) {	
							def subtopicList = top.getSubTags()
							if (subtopicList) {
								subtopicList.each { sub ->
									subtopic(name:sub.name, id: sub.id)  {
										def userTagList = sub.getSubTags()
										if (userTagList) {
											userTagList.each { leaf ->
												usertag(name:leaf.name, id: leaf.id)
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		def data = writer.toString()
		return [data:data]
		
    }

    def getTags = {
		def category
		def categoryTags = Tag.getTopLevelTags()
		def topic
		def topicTags
		def subtopic
		def subtopicTags
		def userTag
		def userTags
		if (params.category) {
			category = Tag.get(params?.category)
			topicTags = category?.getSubTags()
		}
		if (params.topic) {
			topic = Tag.get(params?.topic)
			category = topic.getParent()
			topicTags = category?.getSubTags()
			subtopicTags = topic?.getSubTags()
		}
		if (params.subtopic) {
			subtopic = Tag.get(params?.subtopic)
			topic = subtopic.getParent()
			category = topic.getParent()
			topicTags = category?.getSubTags()
			subtopicTags = topic?.getSubTags()
			userTags = subtopic?.getSubTags()
		}
    	render(template:"/post/tagQuestion", model:[categoryTags:categoryTags, category:category, topicTags:topicTags, topic:topic, subtopicTags:subtopicTags, subtopic:subtopic, userTags:userTags])
    }

	def tagAutocomplete = { 
		def list = Tag.findAllByNameLike("%${params.query}%")
		def jsonList = list.collect { [ id: it.id, name: it.name ] }
		def jsonResult = [
				result: jsonList
				]
		render jsonResult as JSON
	} 	

    
    def create = {
        def tagInstance = new Tag()
        tagInstance.properties = params
        return [tagInstance: tagInstance]
    }

    def save = {
        def tagInstance = new Tag(params)
        if (tagInstance.save(flush: true)) {
			if (params.parent.id) {
				def parent = Tag.get(params.parent.id)
				if (parent) {
					parent.addSubTag(tagInstance)
				}
			}
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'tag.label', default: 'Tag'), tagInstance.id])}"
            redirect(action: "show", id: tagInstance.id)
        }
        else {
            render(view: "create", model: [tagInstance: tagInstance])
        }
    }

    def show = {
        def tagInstance = Tag.get(params.id)
        if (!tagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
            redirect(action: "list")
        }
        else {
            [tagInstance: tagInstance, parent: tagInstance.getParent()]
        }
    }

    def edit = {
        def tagInstance = Tag.get(params.id)
        if (!tagInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [tagInstance: tagInstance, parent: tagInstance.getParent()]
        }
    }

    def update = {
        def tagInstance = Tag.get(params.id)
        if (tagInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (tagInstance.version > version) {
                    
                    tagInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'tag.label', default: 'Tag')] as Object[], "Another user has updated this Tag while you were editing")
                    render(view: "edit", model: [tagInstance: tagInstance])
                    return
                }
            }
            tagInstance.properties = params
            if (!tagInstance.hasErrors() && tagInstance.save(flush: true)) {
				if (params.parent.id) {
					def parent = Tag.get(params.parent.id)
					if (parent) {
						parent.addSubTag(tagInstance)
					}
				}
				flash.message = "${message(code: 'default.updated.message', args: [message(code: 'tag.label', default: 'Tag'), tagInstance.id])}"
                redirect(action: "show", id: tagInstance.id)
            }
            else {
                render(view: "edit", model: [tagInstance: tagInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def tagInstance = Tag.get(params.id)
        if (tagInstance) {
            try {
                tagInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'tag.label', default: 'Tag'), params.id])}"
            redirect(action: "list")
        }
    }
}
