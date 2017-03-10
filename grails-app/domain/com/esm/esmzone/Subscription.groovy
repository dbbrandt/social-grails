package com.esm.esmzone;

class Subscription {
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [subscriber:User]
	
	User subscriber
	Boolean active = true
	Date startDate = new Date()
	Date endDate = new Date()
	String firstName
	String lastName
	String email
	Address address
    PaymentMethod paymentMethod	
	BigDecimal rate = 0.0
    SubscriptionType subscriptionType	
	
	static constraints = {
		active nullable:false
		startDate nullable:false
		endDate nullable:false
		firstName blank:false,nullable:false
		lastName blank:false,nullable:false
		email blank:false,nullable:false
		address nullable:true
		paymentMethod nullable:false
		rate nullable:false
		subscriptionType nullable:false
	}

	def beforeInsert = {
		subscriber.addPoints(PointsType.lookup("Subscribe"))
	}

	String toString() {
		return "$subscriptionType"
	}
}
