package com.esm.promotion

import com.esm.esmzone.User
import com.esm.survey.Response

class QuestionPromotionEntry {

    Date dateCreated
    Date lastUpdated

	User user
	Response response
	PromotionEntryResult result
	Integer answersToWin
	
	Boolean active = true // it will be deactivated once used for a win or expired
	
	Boolean notified = false
	Date dateNotified
	
	Boolean fulfilled = false
	Date dateFulfilled
	
	static belongsTo = [promotion:QuestionPromotion]

	static constraints = {   
		   response nullable:true
		   result nullable:true
		   dateFulfilled nullable:true
		   dateNotified nullable:true
    }
	

	
	public QuestionPromotionEntry(User user, QuestionPromotion promotion, Response response) { 
		this.user = user
		this.promotion = promotion
		this.response = response
		this.answersToWin = promotion.answersToWin
	}
	
	public QuestionPromotionEntry(Map m=null) {
		m?.each { k,v ->
		  this."$k" = v
		}
		if (this.promotion) {
			this.answersToWin = this.promotion.answersToWin
		}
	}
	
	String toString() {
		return "$user : $response.question - $response" ;
	}
}
enum PromotionEntryResult {
	INCORRECT, CORRECT, WINNER, INVALID
}
