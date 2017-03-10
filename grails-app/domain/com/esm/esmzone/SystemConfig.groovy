package com.esm.esmzone;

import com.esm.promotion.QuestionPromotion

class SystemConfig {
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = User
	
	User modifiedBy
	Boolean regEmailOn = false
	String avatarFilePath = "/ebs1/opt/TcatServer6/webapps/esmzone/images/avatar/"
	String avatarUrl = "http://localhost:8080/esmzone/"
	QuestionPromotion questionPromotion
	Source defaultSource
	Boolean showPendingContent = false
	
	static constraints = {
		modifiedBy blank:false, nullable:false
		regEmailOn nullable:false
		avatarFilePath nullable:false
		avatarUrl nullable:false
		questionPromotion nullable:true
		defaultSource nullable:true
		showPendingContent nullable:true
	}
	
	String toString(){ 
		return "SystemConfig regEmailOn: $regEmailOn   Last Modified By:$modifiedBy Modified On: $lastUpdated" ;
	}		
	
}
