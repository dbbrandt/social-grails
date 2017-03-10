package com.esm.esmzone;

class Address {
	
	Date dateCreated
	Date lastUpdated
	
	String street
	String city
	String state
	String postalCode
	String country = "USA"
	
	static constraints = {
		street blank:true, nullable:true
		city blank:false, nullable:false
		state blank:false, nullable:false
		postalCode blank:true, nullable:true
		country blank:true, nullable:true
		
	}
	
	String toString(){ 
		return "$street, $city, $state $postalCode" ;
	}		
	
}
