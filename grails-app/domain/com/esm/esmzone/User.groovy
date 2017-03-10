package com.esm.esmzone

import java.io.Serializable
import java.util.Calendar;
import com.esm.dialog.*;

class User implements Serializable{
	
	static searchable = true

	static Integer mentorListSize = 4
	static BigDecimal defaultRating = 1.0
	//factor needed to convert average rating to star image number
	//assuming that there are 4 images per star (1, 1.25, 1.5, 1.75)
	//Calculation is round(averageRating * 4 - starFactor)
	static BigDecimal starRatingFactor = 3.48
	
	Date dateCreated
	Date lastUpdated
	
	String login
	String password
	String firstName
	String lastName
	String email
	String gender
	Date birthdate
	Division division = Division.III
	SecurityQuestion securityQuestion
	String securityAnswer
	Boolean isMentor = false
	MemberProfile memberProfile
	Address address
	UserStatus status = UserStatus.PENDING
	Source source
    Boolean acceptTerms = false
	Boolean ageTerms = false
	
	
	BigDecimal score = 0
	BigDecimal averageRating = defaultRating
	BigInteger ratingCount = 0
	BigInteger points = 0
	BigInteger questionCount = 0
	BigInteger answerCount = 0
    BigInteger loginCount = 0
    BigInteger bestAnswerCount = 0
    BigInteger mentorBestAnswerCount = 0
	BigInteger alertCount = 0

	String textPassword
	Integer mentorScore
	Integer isMember = 0
	static transients = ['textPassword','mentorScore','isMember']
	
	static hasMany = [   
	roles:Role, 
	permissions:Permission,
	mentorApplications:MentorApplication,
	myConnections:NetworkConnection,
	fanConnections:NetworkConnection,
	pointDetails: Points,
	subscriptions: Subscription,
	complaints: Complaint]

	static mappedBy = [myConnections:"user", fanConnections:"friend"]
	                   
	static constraints = {
      // [\S]+ means no white space allowed
		login (unique:true, validator: {val, obj ->
            if (!val) {
                return false
            }
        })
		password blank:false,nullable:false,matches:/[\S]+/
		firstName blank:false,nullable:false
		lastName blank:false,nullable:false
		gender(nullable:true,blank:false, validator: {val, obj ->
			def genders = ['Male','Female']
			if (val && !genders.contains(val)) {
				return false
			}
		})
		birthdate(nullable:true,validator: {val, obj ->
			Calendar cal = Calendar.getInstance()
			cal.add(Calendar.YEAR,-12)
			if (val && (val > cal.getTime())) {
				return false
			}
		
		})
        securityQuestion blank:true, nullable:true
		securityAnswer blank:true, nullable:true
		email email:true, blank:false, nullable:false,unique:true
		memberProfile nullable:true
		address nullable:true
		source nullable:false
        acceptTerms(nullable:true, validator: {val, obj ->
            if (!val) {
                return false
            }
        })
        ageTerms(nullable:true, validator: {val, obj ->
            if (!val) {
                return false
            }
        })
		roles fetch:"join"
		permissions fetch:"join"
	}

	String toString(){ 
		return "$firstName $lastName" ;
	}

    // give point to a user if this reg was a friend invitation 

 	def beforeInsert = {
        def type = "Recruit"
        def source = Source.findBySourceName("friend")
        def prospect = Prospect.findByEmailAndSource(this.email, source)
        if (prospect) {
            def author = prospect.user
            Points pointsDetail = author.addPoints(PointsType.lookup(type))
    		pointsDetail.save()
        }
	}

    def completeRegistration(gender, address, school, sportList) {
        def completed = false
        if (gender) {
          this.gender = gender
        }
        if (school) {
          this.memberProfile.currentSchool = school
        }
        def sport
        def playedSports = this.memberProfile.playedSports
        (1..3).each { seq ->
            def sportId = sportList[seq]
            if (sportId) {
                if (playedSports?.size() >= seq) {
                    def playedSport = playedSports?.toArray()[seq-1]
                    this.memberProfile.removeFromPlayedSports(playedSport)
                }
                sport = Sport.get(sportId)
                this.memberProfile.addToPlayedSports(sport)
            }
        }
        if (address.validate()) {
            if (this.memberProfile.validate() && this.validate()) {
              this.address = address
              address.save()
              this.save()
              completed = true
            }
        }
        return completed
    }

	Integer starRating() {
		def factor = Math.round((averageRating * 4) - starRatingFactor) 
		factor = (factor < 1)?1:factor
		return factor
	}
	
	synchronized BigDecimal addRating(rating) {
		if (rating) {
			def ratingSum = averageRating * ratingCount
			ratingCount++
			ratingSum += rating.score
			this.averageRating = ratingSum / ratingCount
			this.score()
		}
		return averageRating
	}
	
	synchronized BigDecimal updateRating(rating) {
		if (rating && (this.id != 1)) {
			def ratingSum = averageRating * ratingCount
			ratingSum -= rating.oldScore
			ratingSum += rating.score
			this.averageRating = ratingSum / ratingCount
			this.score()
		}
		return averageRating
	}
	
	synchronized Points addPoints(pointsType) {
		if (!this.isPlayer()) {
			this.points = 0
			this.score()
			return null
		}
		if (pointsType) {
            def bonus = 0
			def pointsDetail = new Points(user: this, type:pointsType, points: pointsType.points)
			if (pointsDetail.save()) {
				this.addToPointDetails(pointsDetail)
                // these points types qualify for bonus points each time they hit a multiple (ex. each 10) 
				switch (pointsType.name) {
					case 'Question':
                      questionCount++
                      bonus = pointsType.calcBonus(questionCount)
                      break
					case 'Answer':
                      answerCount++
                      bonus = pointsType.calcBonus(answerCount)
                      break
                    case 'Login':
                      loginCount++
                      bonus = pointsType.calcBonus(loginCount)
                      break
                    case 'BestAnswer':
                      bestAnswerCount++
                      bonus = pointsType.calcBonus(bestAnswerCount)
                      break
                    case 'MentorBestAnswer':
                      mentorBestAnswerCount++
                      bonus = pointsType.calcBonus(mentorBestAnswerCount)
                      break
				}
                if (bonus > 0) {
                  pointsDetail = new Points(user: this, type:pointsType, points: pointsType.bonusPoints)
                  if (pointsDetail.save()) {
                      this.addToPointDetails(pointsDetail)
                      this.points += bonus 
                  }
                }
				this.points += pointsType.points
				this.score()
				return pointsDetail
			}
			else {
				return null
			}
		}
		else {
			return null
		}
	}
	
	private void score() {
		this.score = averageRating * points
		this.save()
	}
	
	Integer getMentorScore(user, userProfile, userAddress) {
		mentorScore = 0
		mentorScore += (user.gender == gender) ? 200 : 0
		mentorScore += (userProfile.grade < memberProfile.grade) ? 200 : 0
		mentorScore += (userAddress?.state == address?.state) ? 5 : 0
		mentorScore += (userAddress?.postalCode != address?.postalCode) ? 5 : 0
		mentorScore += (userProfile?.currentSchool != memberProfile.currentSchool) ? 4 : 0
		memberProfile?.strongestSubjects.each {
			mentorScore += (it in userProfile?.leastFavoriteSubjects)? 50 : 0
		}
		memberProfile?.playedSports.each {
			mentorScore += (it in userProfile?.playedSports)? 25 : 0
		}										
		memberProfile?.favoriteSports.each {
			mentorScore += (it in userProfile?.favoriteSports)? 5 : 0
		}
		mentorScore += (memberProfile?.currentSchool in memberProfile?.formerSchools) ? 4 : 0
		
		return mentorScore
	}	
	
	List fanRequests(rows) {
		def alertList
		if (rows == 0) {
			alertList =  NetworkConnection.createCriteria().list() {
				eq('friend',this)
				eq('status',NetworkConnectionStatus.PENDING)
			}
		}
		else {
			alertList =  NetworkConnection.createCriteria().list() {
				maxResults(rows)
				eq('friend',this)
				eq('status',NetworkConnectionStatus.PENDING)
			}
		}
		return alertList
	}
	
	List medals() {
		def medals = []
		//category 1) score: bronze > 5K, silver > 15K, gold > 30K  
		//category 2) ratings: bronze 5, silver 15, gold 30
		//category 4) Following: bronze > 10, silver > 20, gold > 40
		//category 3) Activity: bronze > 30, silver > 60, gold > 120
		//Testing 
		//category 1) Score: bronze > .5K, silver > 1.5K, gold > 2K  
		//category 2) ratings: bronze > 2 x 3-4, silver 3 x 4-4.5, gold 4x >4.5
		//category 3) Q&A: bronze > 5, silver > 10, gold > 15
		//category 4) Fans: bronze > 3, silver > 5, gold > 7
		def medal1 = [name:"Scoring: ",value:"1_"]
		def medal2 = [name:"Times Rated: ",value:"2_"]
		def medal3 = [name:"Following: ",value:"4_"]
		def medal4 = [name:"Activity: ",value:"3_"]
				
		//Category 1
		if (this.score >= 2000) {
			medal1.name += "Gold"
			medal1.value += "3"
			medals.add(medal1)
		}
		else if (this.score >= 1500) {
			medal1.name += "Silver"
			medal1.value += "2"
			medals.add(medal1)
		}	
		else if (this.score >= 500) {
			medal1.name += "Bronze"
			medal1.value += "3"
			medals.add(medal1)
		}	
		
		//Category 2
		if (this.ratingCount >= 10) {
			medal2.name += "Gold"
			medal2.value += "3"
			medals.add(medal2)
		}
		else if (this.ratingCount >= 5) {
			medal2.name += "Silver"
			medal2.value += "2"
			medals.add(medal2)
		}
		else if (this.ratingCount >= 3) {
			medal2.name += "Bronze"
			medal2.value += "3"
			medals.add(medal2)
		}
		
		//Category 3
		def friendCount = this.myConnections.size() + this.fanConnections.size()
		if (friendCount >= 7) {
			medal3.name += "Gold"
			medal3.value += "3"
			medals.add(medal3)
		}
		else if (friendCount >= 5) {
			medal3.name += "Silver"
			medal3.value += "2"
			medals.add(medal3)
		}
		else if (friendCount >= 3) {
			medal3.name += "Bronze"
			medal3.value += "3"
			medals.add(medal3)
		}
		
		//Category 4
		def activityCount = this.questionCount + this.answerCount
		if (activityCount >= 15) {
			medal4.name += "Gold"
			medal4.value += "3"
			medals.add(medal4)
		}
		else if (activityCount >= 10) {
			medal4.name += "Silver"
			medal4.value += "2"
			medals.add(medal4)
		}
		else if (activityCount >= 5) {
			medal4.name += "Bronze"
			medal4.value += "3"
			medals.add(medal4)
		}
		
		return medals
		
	}
	
	NetworkConnection findConnection(user1, user2, type) {
		def networkConnection
		def c = NetworkConnection.createCriteria()
		def results = c {
			and {
				eq("type",type )
				or {
					and {
						eq("user", user1)
						eq("friend", user2)
					}
					and {
						eq("user", user2)
						eq("friend", user1)
					}
				}
			}
		}
		if (results) {
			networkConnection = results.toArray()[0]
		}
		return networkConnection
	}

	// This should check if the mentor candidate is already a mentor
	Boolean readyForMentorApplication() {
		if (isMentor) {
			return false
		}
		if (this.mentorApplications.size() == 0) {
			return true
		}
		this.mentorApplications.each {
			if (it.status in [ApplicationStatus.STARTED,ApplicationStatus.QUIZ,ApplicationStatus.REFERENCES])
				return true
		}
		return false
	}
	
	Boolean myMentor(User user) {
			return this.findConnection(this, user, NetworkConnectionType.MENTOR, NetworkConnectionStatus.ACTIVE)
	}
	
	Boolean pendingMentor(User user) {
		return this.findConnection(this, user, NetworkConnectionType.MENTOR, NetworkConnectionStatus.PENDING)
	}
	
	Boolean myMentee(User user) {
		return this.findConnection(user, this, NetworkConnectionType.MENTOR, NetworkConnectionStatus.ACTIVE)
	}
	
	Boolean amFan(User user) {
		return this.findConnection(user, this, NetworkConnectionType.FAN, NetworkConnectionStatus.ACTIVE)
	}
	
	Boolean pendingFan(User user) {
		return this.findConnection(user, this, NetworkConnectionType.FAN, NetworkConnectionStatus.PENDING)
	}
	
	Boolean isFan(User user) {
		return this.findConnection(this, user, NetworkConnectionType.FAN, NetworkConnectionStatus.ACTIVE)
	}
	
	Long getNetworkConnectionId(User user) {
		println "My Connections: " +  myConnections.size()
		Long connectionId
		myConnections.each { connection ->
			println connection
			if ((connection.friend == user) || (connection.user == user)) {
				connectionId = connection.id
			}
		}
		println "Fan Connections: " +  fanConnections.size()
		fanConnections.each { connection ->
			println connection
			if ((connection.user == user) || (connection.friend == user)) {
				connectionId = connection.id
			}
		}
		return connectionId
	}
	
	String getRelationship(User user) {
		if (myMentor(user)) {
			return 'Mentor'
		}
		else if (myMentee(user)) {
			return 'Mentee'
		}
		else {
			return 'Fan'
		}
	}
	
	List connectionList(max=0) {
		def fanList = []
		if (max == 0) {
			max = 1000
		}
		def added = 0
		this.myConnections.each {
			if (it.status == NetworkConnectionStatus.ACTIVE) {
				def fan = User.get(it.friend.id)
				if (fan && !fanList.contains(fan) && (added < max)) {
					fanList.add(fan)
					added++
				}
			}
		}
		this.fanConnections.each {
				if (it.status == NetworkConnectionStatus.ACTIVE) {
					def fan = User.get(it.user.id)
					if (fan && !fanList.contains(fan) && (added < max)) {
						fanList.add(fan)
						added++
				}
			}
		}
		fanList.sort {it.firstName}
		return fanList
	}
	
	List fanList(type,max=0) {
		def fanList = []
		if (max == 0) {
			max = 1000
		}
		def added = 0
		this.myConnections.each {
			if ((it.status == NetworkConnectionStatus.ACTIVE) && (it.type == type)) {
				def fan = User.get(it.friend.id)
				if (fan && !fanList.contains(fan) && (added < max)) {
					fanList.add(fan)
					added++
				}
			}
		}
		this.fanConnections.each {
			if ((it.status == NetworkConnectionStatus.ACTIVE) && (it.type == type)) {
				def fan = User.get(it.user.id)
				if (fan && !fanList.contains(fan) && (added < max)) {
					fanList.add(fan)
					added++
				}
			}
		}
		return fanList
	}
	
	List menteeList() {
		def mentees = []
		this.fanConnections.each {
			if (it.type == NetworkConnectionType.MENTOR) {
				mentees = [it.user]
			}
		}
		return mentees.sort {it.firstName}
	}

	List transactionList(max=0) {
		if (max == 0) {
			max = 1000
		}
		def esmTransactions = []
		def startDate = new Date() - 30
		startDate.clearTime()
		def transList = ESMTransaction.createCriteria().list() {
			eq('user',this)
			eq('cleared',false)
			ge('dateCreated',startDate)
			order('dateCreated', 'desc')
			maxResults(max)
		}
		transList.each { t ->
			esmTransactions.add(t)
		}
		return esmTransactions	
	}
	
	Boolean findConnection(user, friend, type, status) {
		def c = NetworkConnection.createCriteria()
		def results = c {
			and {
				eq("type",type )
				eq("status", status)
				eq('user',user)
				eq('friend',friend)
			}
		}
		if (results) {
			return true
		}
		return false
	}
	
	Boolean makeZombie() {
		try {
			def aMemberProfile = this.memberProfile
			def anAddress = this.address
			this.memberProfile = null
			this.address = null
			this.status = UserStatus.ZOMBIE
			this.save(flush:true)
			aMemberProfile?.delete(flush:true)
			this.login = "zombie" + id
			this.email = "zombie" + id + "@esmzone.com"
			GregorianCalendar bd = new GregorianCalendar(1900,Calendar.JANUARY,1)
			this.birthdate = bd.time
			this.securityAnswer = "zombie"
			this.isMentor = false
			mentorApplications.each {
				this.removeFromMentorApplication(it)
			}
			myConnections.each {
				it.delete()
			}
			fanConnections.each {
				it.delete()
			}
			if (!this.save(flush:true)) {
				return false
			}
		}
		catch (org.springframework.dao.DataIntegrityViolationException e) {
			return false
		}
		return true
	}	
	
	Boolean isMember() {
		if (isMember == 0) {
			def c = User.createCriteria()
			def results = c {
				eq('id',this.id)
				subscriptions {
					eq("active",true )
				}
			}
			if (results) {
				isMember = 1
			}
			else { 
			    isMember = -1
			}
		}
		if (isMember == 1) {
			return true
		}
		return false
	}
	
	Integer rank() {
		def rankedUsers
		def c = User.createCriteria()
		def results = c {
			and {
				gt("score",score )
				eq("division",division)
			}
		}
		if (results) {
			return results.size() + 1
		}
		else {
			return 1
		}
				
	}
	
	List standings(rows) {
		def rankedUsers
		def divisionList =  User.createCriteria().list() {
			maxResults(rows)
			eq("division",division)
			order("score","desc")
		}
		if (!divisionList.contains(this)) {
			divisionList.add(this)
		}
		return divisionList
	}
	
	static List divisionStandings(rows, division) {
		def rankedUsers
		def divisionList =  User.createCriteria().list() {
			maxResults(rows)
			eq("division",division)
			order("score","desc")
		}
		return divisionList
	}
	
	
	Division calcDivision() {
		def grade = memberProfile.grade
		switch (grade) {
			case 6:
			case 7:
			case 8:
				this.division = Division.III
				break
			case 9:
			case 10:
			this.division = Division.II
			    break;
			case 11:
			case 12:
			case 13:
				this.division = Division.I
			    break
		}
		return this.division
	}
	
	String avatarFile() {
		def avatarUrl = SystemConfig.get(1).avatarUrl 
		def avatarFile = (this?.memberProfile?.avatar?.filename)?this?.memberProfile?.avatar?.filename:'default.png' 
		return avatarUrl + "images/avatar/" + avatarFile 
	}
	
	String avatarVersion() {
		def avatarVersion = this?.memberProfile?.avatar?.version 
		return (avatarVersion)?avatarVersion:'0' 
	}
	
	Boolean transactionAlert(type, message, member, contentId) {
		def trans = new ESMTransaction(user:this, type:type, message:message, member:member, contentId:contentId)
		if (trans.validate()) {
			trans.save()
			this.alertCount++
			this.save()
			return true
		}
		return false
	}
	
	Boolean hasRole(userRole) {
      def hasRole = false
	  roles.each { role ->
		  if (role.name == userRole) {
			  hasRole = true
		  } 
	  }	
	  return hasRole
	}
	
	// A player cannot be a Coach or a Spectator. Only players accrue points and show up on standings
	Boolean isPlayer() {
		if (this.hasRole(RoleName.COACH) || this.hasRole(RoleName.RECRUITER) || this.hasRole(RoleName.SPONSOR) || this.hasRole(RoleName.PARENT)) {
			return false
		}
		return true
	}
}

enum UserStatus {
	PENDING, ACTIVE, SUSPENDED, ZOMBIE
}
enum Division {
	I(1), II(2), III(3)
	Division(value) { this.value = value }
	private final int value
	public int value() { return value }
	public int toInteger() { return value }
}