package com.esm.esmzone


class Role implements Serializable {
	RoleName name
	
	static constraints = {
		name(unique:true)
	}
	
	String toString(){ 
		return name;
	}
}
enum RoleName {
	USER, MEMBER, MENTOR, ADMINISTRATOR, COACH, RECRUITER, SPONSOR, PARENT
}
