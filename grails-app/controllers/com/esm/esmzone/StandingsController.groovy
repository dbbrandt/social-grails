package com.esm.esmzone;

class StandingsController {
	
		def index = {
			params.max = Math.min(params.max ? params.int('max') : 10, 100)
			if (!params.offset) {
				params.offset = 0
			}
			if (!params.sort) {
				params.sort = "score"
				params.order = "desc"
			}
			// Need to handle nested class sorts ex. memberProfile.grade
			// for now default to score
			else if (params.sort.find(~/\./)) {
				params.sort = "score"
				params.order = "desc"
			}
			if (!params?.standingsTab) {
				params.standingsTab = "Division1"
			}
			def userDivision1List =  User.createCriteria().list(params) {
				ge('id',params.long("offset"))
				memberProfile {
					le('grade',8)
				}
				maxResults(params.max)
				order(params.sort, params.order)
				
			}
			def userDivision2List =  User.createCriteria().list(params) {
				ge('id',params.long("offset"))
				memberProfile {
					between('grade',9,10)
				}
				maxResults(params.max)
				order(params.sort, params.order)
							}
			def userDivision3List =  User.createCriteria().list(params) {
				ge('id',params.long("offset"))
				memberProfile {
					ge('grade',11)
				}
				maxResults(params.max)
				order(params.sort, params.order)
			}
			return [userDivision1List: userDivision1List, userDivision2List:userDivision2List, userDivision3List:userDivision3List]
		}
		
}
