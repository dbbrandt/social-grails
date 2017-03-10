package com.esm.cms

import java.util.Date;

import com.esm.esmzone.User;

class ContentSection {

	static belongsTo = ContentPage
	
	Date dateCreated
	Date lastUpdated
	
	ContentPage page
	User author
	String name
	String title
	String description
	String content
	ContentTemplate template
	Integer sequence
	ContentStatus status = ContentStatus.INACTIVE
	
	static constraints = {
		author nullable:false
		name blank:false, nullable:false, size:1..20
		title blank:false, nullable:false, size:1..120
		description blank:true, nullable:true
		content blank:true,nullable:true
		sequence nullable:false
		template nullable:true
	}

	static mapping = {
		content type: 'text'
	}

	String getContent() {
		if (template) {
			return template.content
		}
		else {
			return content
		}
	}

	String toString() {
		return id + ". " + sequence + ") " + name + " (" + status + ")"
	}

}
