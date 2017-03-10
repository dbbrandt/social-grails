package com.esm.esmzone

class SubscriptionType {
	
	Date dateCreated
	Date lastUpdated
	
	String name
	String description
	Integer months
	BigDecimal cost = 0.0
	
	static constraints = {
		name blank:false,nullable:false
		description blank:true,nullable:true
		months nullable:true
		cost nullable:false
	}
	String toString() {
		return "$name"
	}
}
