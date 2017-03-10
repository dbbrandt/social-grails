package com.esm.util;

import com.esm.esmzone.SchoolType;

class SchoolLoad {
	
	String name
	String street
	String city
	String state
	String postalCode
	SchoolType type = SchoolType.OTHER
		
	static constraints = {
		name blank:false, nullable:false, unique:true
		type nullable:false
	}
	String toString(){ 
		return name 
	}
}
