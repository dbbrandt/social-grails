package com.esm.esmzone;

import java.util.SortedSet;

class MemberProfile {
	
	Date dateCreated
	Date lastUpdated
	
	static belongsTo = [user:User]
	
	String favoriteProPlayer
	String favoriteProTeam
	String favoriteMovie
	String roleModel
	String careerInterests
	String favoriteActivities
	Integer grade
	School currentSchool
	BigDecimal gpa
	String gainFromSite
	Boolean wantToMentor
	Boolean needMentor = false
	Avatar avatar
	
	static hasMany = [   
	favoriteSports:Sport, 
	playedSports:Sport,
	favoriteSubjects:Subject,
	leastFavoriteSubjects:Subject,
	strongestSubjects:Subject,
	formerSchools:School,
	collegeInterest:School] 
	
	static constraints = {
		favoriteProPlayer blank:true,nullable:true
		favoriteProTeam blank:true,nullable:true
		favoriteMovie blank:true,nullable:true
		roleModel blank:true,nullable:true
		careerInterests blank:true,nullable:true
		favoriteActivities blank:true,nullable:true
		gpa nullable:true
		grade nullable:false
		currentSchool nullable:true
		gainFromSite blank:true,nullable:true
		wantToMentor nullable:true
		needMentor nullable:true
		avatar nullable:true
	}
	
	def afterUpdate = {
		def division = this.user.division
		if (division != this.user.calcDivision()) {
			this.user.save()
		}
	}
	
	School getFormerSchool(sequence) {
		if (sequence < 1) {
			return null
		}
		def schools = this.formerSchools.sort()
		if (schools && (schools.size() >= sequence)) {
			return schools.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	Sport getPlayedSport(sequence) {
		if ((sequence < 1) || (!this.playedSports)) {
			return null
		}
		def sports = this.playedSports.sort()
		if (sports && (sports.size() >= sequence)) {
			return sports.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	Sport getFavoriteSport(sequence) {
		if ((sequence < 1) || (!this.favoriteSports)) {
			return null
		}
		def sports = this.favoriteSports.sort()
		if (sports && (sports.size() >= sequence)) {
			return sports.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	Subject getStrongestSubject(sequence) {
		if ((sequence < 1) || (!this.strongestSubjects)) {
			return null
		}
		def subjects = this.strongestSubjects.sort()
		if (subjects && (subjects.size() >= sequence)) {
			return subjects.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	Subject getFavoriteSubject(sequence) {
		if ((sequence < 1) || (!this.favoriteSubjects)) {
			return null
		}
		def subjects = this.favoriteSubjects
		if (subjects && (subjects.size() >= sequence)) {
			return subjects.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	Subject getLeastFavoriteSubject(sequence) {
		if ((sequence < 1) || (!this.leastFavoriteSubjects)) {
			return null
		}
		def subjects = this.leastFavoriteSubjects
		if (subjects && (subjects.size() >= sequence)) {
			return subjects.toArray()[sequence-1]
		}
		else {
			return null
		}
	}
	
	String gradeLevel() {
		if (grade > 12) {
			return GradeLevel.COLLEGE
		}
		return grade.toString()
	}
	
	String toString(){ 
		return "$user" ;
	}
	
}
enum GradeLevel {
	SEVENTH(7), EIGHTH(8), NINTH(9), TENTH(10),ELEVENTH(11),
	TWELFTH(12), COLLEGE(13)
	GradeLevel(int value) { this.value = value
	}
	private final int value
	public int value() { return value
	}
	public int toInteger() { return value
	}
	private static List list = [7,8,9,10,11,12,13]
	
	static List getList() {
		return list 
	}
}
