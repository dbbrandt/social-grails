package com.esm.esmzone;

class PointsType {
	
	private static Map pointsLookup
	
	Date dateCreated
	Date lastUpdated
	
	String name
	String description
	Integer points
	Integer bonusCount = 10
	Integer bonusPoints = 0
	
	static constraints = {
		name blank:false, nullable:false, unique:true
		description blank:true, nullable:true
		points nullable:false
	}

	static lookup(typeName) {
		if (!pointsLookup) {
			pointsLookup = ["default":0]
			def pointsType = PointsType.list()
			pointsType.each {
				pointsLookup.put(it.name, it) 
			}
		}
		return pointsLookup.get(typeName)
	}

    Integer calcBonus(count) {
        if (count % bonusCount == 0) {
          return bonusPoints
        }
        return 0
    }

	String toString(){ 
		return "${name}: ${points}";
	}
}
