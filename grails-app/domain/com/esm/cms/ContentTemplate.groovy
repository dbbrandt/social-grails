package com.esm.cms

import java.util.Date;

import com.esm.esmzone.User;

class ContentTemplate {
	Date dateCreated
	Date lastUpdated
	
	User author
	String name
	String description
	String content
	
	static constraints = {
		author nullable:false
		name blank:false, nullable:false, size:1..60 
		description blank:false, nullable:false, size:1..400
		content blank:false,nullable:false
	}

	static mapping = {
		content type: 'text'
	}

	String toString() {
		return id + "." + name
	}

}
