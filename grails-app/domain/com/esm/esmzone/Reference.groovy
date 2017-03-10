package com.esm.esmzone;

import com.esm.survey.*;

class Reference {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [application: MentorApplication]
	
	MentorApplication application
	Integer sequence
	ReferenceStatus status = ReferenceStatus.CREATED
	String email
	String firstName
	String lastName
	String relationship
	String description
	Boolean approved = false
	
	static constraints = {
		email email:true, blank:false, nullable:false, validator: {val, obj ->
			if (User.findByEmail(obj.email)) {
				return false
			}
		}
		sequence blank:false, nullable:false
		status blank:false, nullable:false
		firstName blank:false,nullable:false
		lastName blank:false,nullable:false
		relationship blank:false,nullable:false
		description blank:true,nullable:true
	}
	String toString(){ 
		return "$application - $email" ;
	}
}
enum ReferenceStatus {
	CREATED, SENT, APPROVED, REJECTED
}
