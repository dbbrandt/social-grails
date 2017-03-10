package com.esm.esmzone;

class Subject {
	
	Date dateCreated
	Date lastUpdated
	
	String name
	String description
	
	static constraints = {
		name blank:false, nullable:false,unique:true
		description blank:true,nullable:true
	}

	static mapping = {
		sort 'name'
	}

	String toString(){ 
		return name;
	}
	
}
