package com.esm.esmzone;

class Points {
	
    Date dateCreated
    Date lastUpdated

	static belongsTo = User

	User user
	Integer points
	PointsType type
	Long contentId
	
	static constraints = {
		points nullable:false
		type nullable:false
		contentId nullable:true
	}

	String toString(){ 
		return "${type} ($dateCreated)";
	}
}
