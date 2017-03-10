package com.esm.esmzone;

class Source {
	
	Date dateCreated
	Date lastUpdated
	
	String sourceName
	String message
	String description
	String owner
	String coupon
	Date startDate = new Date()
	Date endDate
	SourceStatus status = SourceStatus.PENDING
	
	static constraints = {
		sourceName blank:false, nullable:false, unique:true
		description blank:true, nullable:true
		message blank:true, nullable:true
		coupon blank:true, nullable:true
		owner blank:true, nullable:true
		startDate nullable:false
		endDate nullable:true
		status nullable:false
	}	
	
	String toString(){ 
		return "$sourceName" ;
	}
}
enum SourceStatus {
	PENDING, ACTIVE, INACTIVE, SUSPENDED
}
