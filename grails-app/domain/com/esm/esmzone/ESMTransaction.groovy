package com.esm.esmzone

class ESMTransaction {

	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [user:User]
	
	User member
	String message
	Integer contentId
	
	Boolean cleared = false
	ViewedStatus viewed = ViewedStatus.NEW
	ESMTransactionType type
	
	static constraints = {
		user nullable:false
		member nullable:true
		message nullable:true
		type nullable:false
		contentId nullable:true
	}
}
enum ESMTransactionType {
	QUESTION, ANSWER, MESSAGE, FAN
} 
enum ViewedStatus {
	NEW, CLEARED, VIEWED
}