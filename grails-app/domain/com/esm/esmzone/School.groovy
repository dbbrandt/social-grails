package com.esm.esmzone;

class School {
	Date dateCreated
	Date lastUpdated
	
	String name
	Address address
	SchoolType type = SchoolType.OTHER
	
	static constraints = {
		name blank:false, nullable:false, unique:true
		address nullable:true
		type nullable:false
	}

	static mapping = {
		sort 'name'
	}

	String toString(){ 
		return name 
	}
}
enum SchoolType {
	PRESCHOOL,ELEMENTARY,MIDDLE,JUNIOR_HIGH, HIGH,VOCATIONAL,COLLEGE,GRADUATE,OTHER
}
