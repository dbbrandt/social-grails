package com.esm.dialog

class PostType {
	
	PostTypeName name
	PostTypeAudience audience

	static constraints = {
		name blank:false, nullable:false
		audience blank:false, nullable:false
	}
	
	String toString(){ 
		return "${name} : ${audience}";
	}
}
enum PostTypeName {
	QUESTION, SOCIAL, FEEDBACK
}
enum PostTypeAudience {
	PUBLIC, PRIVATE, MENTOR, MEMBER, INAPPROPRIATE
}
