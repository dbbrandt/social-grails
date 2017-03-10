package com.esm.cms

import com.esm.esmzone.User;

class ContentPage {
	Date dateCreated
	Date lastUpdated
	
	User author
	String name
	String description
	String content
	ContentTemplate template
	String view
	ContentStatus status = ContentStatus.INACTIVE
	
	static hasMany = [sections:ContentSection]

	static constraints = {
		author nullable:false
		name blank:false, nullable:false, size:1..60
		description blank:false, nullable:false, size:1..400
		content blank:true,nullable:true
		view blank:false, nullable:false
		template nullable:true
	}

	static mapping = {
		content type: 'text'
		sections sort: 'sequence'
	}

	String fetchContent() {
		if (template) {
			return template.content
		}
		else {
			return content
		}
	}
	
	String toString() {
		return id + "." + name + "(" + status + ")"
	}
	
}
enum ContentStatus {
	INACTIVE, PENDING, ACTIVE
}
