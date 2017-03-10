package com.esm.esmzone;

class Sport {
	
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
		return name
	}
	// Order by average score descending with dateCreated as tiebreaker
	int compareTo(obj) {
		return name.compareTo(obj.name)
	}
	
	
}
