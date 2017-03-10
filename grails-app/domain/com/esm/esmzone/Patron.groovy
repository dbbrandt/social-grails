package com.esm.esmzone;

class Patron {
	
	Date dateCreated
	Date lastUpdated
	
	String email
	String password
	String organizationName
	String firstName
	String lastName
	SecurityQuestion securityQuestion
	String securityAnswer
	Address address
	PatronStatus status = PatronStatus.PENDING
	Source source
	
	String textPassword
	static transients = ['textPassword']
	

	static constraints = {
		email blank:false, nullable:false,size:5..125,matches:/[\S]+/, unique:true
		password blank:false,nullable:false,matches:/[\S]+/
		organizationName blank:false,nullable:false
		firstName blank:false,nullable:false
		lastName blank:false,nullable:false
		address nullable:true
		source nullable:true
	}
	
	String toString(){ 
		return "$firstName $lastName" ;
	}
}
enum PatronStatus {
	PENDING, ACTIVE, SUSPENDED, REJECTED
}