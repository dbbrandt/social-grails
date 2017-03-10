package com.esm.esmzone;

import com.esm.dialog.*


class NetworkConnection {
	
	Date dateCreated
	Date lastUpdated
	
	User user
	User friend
	String message
	NetworkConnectionType type
	NetworkConnectionStatus status = NetworkConnectionStatus.PENDING
	
	static constraints = {
		user nullable:false
		friend nullable:false, validator: {val, obj ->
			if (val == obj.user) {
				return false
			}
		}
		message nullable:true
		type nullable:false
		status nullable:false
	}
	
	def beforeInsert = {
		if (type == NetworkConnectionType.FAN){
			if (status == NetworkConnectionStatus.PENDING) {
				friend.addPoints(PointsType.lookup("FanRequest"))
			}
			else {
				user.addPoints(PointsType.lookup("AcceptedFan"))
				friend.addPoints(PointsType.lookup("AcceptFan"))
			}
		}
		else {
			if (type == NetworkConnectionType.MENTOR) {
					friend.addPoints(PointsType.lookup("MentorSelected"))
			}
		}
	}

	def beforeUpdate = {
		if (type == NetworkConnectionType.FAN){
			if (status == NetworkConnectionStatus.ACTIVE) {
				user.addPoints(PointsType.lookup("AcceptedFan"))
				friend.addPoints(PointsType.lookup("AcceptFan"))
			}
		}
	}

	User getFan(requestor) {
		if (user == requestor) {
		   return friend
		}
		else {
			return user
		}
	}
	
	Integer questionCount() {
		def postInstanceList =  Post.createCriteria().list() {
			or {
				and {
					eq('author',user)
					eq('member',friend)
				}
				and {
					eq('author',friend)
					eq('member',user)
				}
			}
			postType {
				eq('name', PostTypeName.QUESTION)
				eq('audience', PostTypeAudience.MEMBER)
			}
		}
		return postInstanceList?.size()
	}

	String toString(){ 
		return "$user - $friend" ;
	}
}
enum NetworkConnectionType {
	FAN, MENTOR, TEAMMATE
}
enum NetworkConnectionStatus {
	PENDING, ACTIVE
}