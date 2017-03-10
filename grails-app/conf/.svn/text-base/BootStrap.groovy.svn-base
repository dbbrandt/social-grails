import org.jsecurity.crypto.hash.Sha1Hash
import org.codehaus.groovy.grails.commons.ApplicationAttributes
import com.esm.esmzone.*
import com.esm.dialog.*
import com.esm.survey.*
import com.esm.promotion.*
import com.esm.cms.*

class BootStrap {
	
	//def jmsContainer
	def init = { servletContext ->
		
		// Fix for idle connection errors 
		def ctx=servletContext.getAttribute(ApplicationAttributes.APPLICATION_CONTEXT)
		def dataSource = ctx.dataSourceUnproxied
		
		dataSource.setMinEvictableIdleTimeMillis(1000 * 60 * 30)
		dataSource.setTimeBetweenEvictionRunsMillis(1000 * 60 * 30)
		dataSource.setNumTestsPerEvictionRun(3)
		
		dataSource.setTestOnBorrow(true)
		dataSource.setTestWhileIdle(false)
		dataSource.setTestOnReturn(false)
		dataSource.setValidationQuery("SELECT 1")
		
		dataSource.properties.each { println it
		}
		// end fix
		
		User adminUser = User.findByLogin("admin@esmzone.com")
		if(!adminUser) {
			
			BackgroundImage background = new BackgroundImage(name:"Football Stadium", filename:"football-stadium")
			if(background.validate()) {
				background.save()
			}
			else {
				throw new Exception("Problem adding background $background.errors")
				log.error "Problem adding background $background.errors"
			}
			new BackgroundImage(name:"Stadium", filename:"stadium").save()
			new BackgroundImage(name:"Surfing", filename:"surfing").save()
			new BackgroundImage(name:"Halfpipe", filename:"halfpipe").save()
			new BackgroundImage(name:"Snowboard", filename:"snowboard").save()
			new BackgroundImage(name:"Track", filename:"track").save()
			new BackgroundImage(name:"Tennis", filename:"tennis").save()
			
			School school = new School(name:"Not Listed", type: SchoolType.OTHER )
			if(school.validate()) {
				school.save()
			}
			else {
				throw new Exception("Problem adding school $school.errors")
				log.error "Problem adding school $school.errors"
			}

            // NOTE: you need to add logic to the User domain class for any pointType that has bonus points (i.e. bonusCount > 0).
			PointsType pointsType = new PointsType(name:"Subscribe", description: "Initial subscription",points:50,bonusCount:0)
			if(pointsType.validate()) {
				pointsType.save()
			}
			else {
				throw new Exception("Problem adding pointsType $pointsType.errors")
				log.error "Problem adding pointsType $pointsType.errors"
			}
			new PointsType(name:"Renewal", description: "Renewal of subscription",points:50,bonusCount:0).save()
			new PointsType(name:"Login", description: "Logging In",points:10,bonusCount:10,bonusPoints:10).save()
			new PointsType(name:"Question", description: "Asking a question",points:10,bonusCount:10,bonusPoints:10).save()
			new PointsType(name:"Post", description: "Write a post",points:0,bonusCount:0).save()
			new PointsType(name:"Answer", description: "Answering a question",points:10,bonusCount:10,bonusPoints:10).save()
			new PointsType(name:"QuestionRating", description: "Rating a question",points:5,bonusCount:0).save()
			new PointsType(name:"PostRating", description: "Rating a post",points:5,bonusCount:0).save()
			new PointsType(name:"AnswerRating", description: "Rating an answer",points:5,bonusCount:0).save()
			new PointsType(name:"BestAnswer", description: "Select as best answer",points:10,bonusCount:10, bonusPoints:10).save()															
			new PointsType(name:"MentorBestAnswer", description: "Mentor select as best answer",points:15,bonusCount:10, bonusPoints:15).save()															
			new PointsType(name:"QuestionComment", description: "Comment on a question",points:2,bonusCount:0).save()
			new PointsType(name:"AnswerComment", description: "Comment on an answer",points:3,bonusCount:0).save()
			new PointsType(name:"PostComment", description: "Comment on a post",points:1,bonusCount:0).save()
			new PointsType(name:"Tag", description: "Create a new Tag",points:0,bonusCount:0).save()
			new PointsType(name:"QuestionTag", description: "Tag a Question",points:5,bonusCount:0).save()
			new PointsType(name:"FanRequest", description: "Requested by a fan",points:5,bonusCount:0).save()
			new PointsType(name:"AcceptFan", description: "Accept a fan",points:2,bonusCount:0).save()
			new PointsType(name:"AcceptedFan", description: "Accepted as a fan",points:2,bonusCount:0).save()
			new PointsType(name:"Recruit", description: "Recruit signs up",points:50,bonusCount:0).save()
			new PointsType(name:"RecruitMentor", description: "Recruit becomes a mentor",points:25,bonusCount:0).save()
			new PointsType(name:"MentorCertified", description: "Certified as a mentor",points:25,bonusCount:0).save()
			new PointsType(name:"MentorSelected", description: "Selected as a mentor",points:15,bonusCount:0).save()
			
			def organicSource = new Source(sourceName:"organic", coupon:"esmzone")
			if(organicSource.validate()) {
				organicSource.save()
			}
			else {
				throw new Exception("Problem adding organicSource $organicSource.errors")
				log.error "Problem adding organicSource $organicSource.errors"
			}
            new Source(sourceName:"friend", coupon:"refer_a_friend",message:"Congratulations! Your friend has recruited you to become a member. You get a one year free subscription!").save()
			new Source(sourceName:"Question Of The Day", coupon:"trivia-1",message:'<img src="images/promo_pg_bnr_1.jpg"/>').save()
			def defaultSource = new Source(sourceName:"Default Source with Promo", coupon:"esmzone-beta",message:'<img src="images/promo_pg_bnr_1.jpg"/>').save()
			
			SecurityQuestion securityQuestion = SecurityQuestion.findByName('Mothers Middle Name')
			if(!securityQuestion) {
				securityQuestion = new SecurityQuestion(name:"Mothers Maiden Name", 
				question:"What is you mother's maiden name?")
				.save()
			}
			new SecurityQuestion(name:"Dream Vacation Country", question:"What is the country of your ultimate dream vacation?").save()
			new SecurityQuestion(name:"Favorite Teacher", question:"What is the name of your favorite teacher?").save()
			new SecurityQuestion(name:"First Stuffed Animal", question:"What was the name of your first stuffed animal?").save()
			new SecurityQuestion(name:"City Mother Father Met", question:"In what city or town did your mother and father meet?").save()
			new SecurityQuestion(name:"Time of Day Born", question:"What time of the day were you born?").save()
			new SecurityQuestion(name:"Grandmothers First Name", question:"What is your grandmother's first name?").save()
			
			GregorianCalendar bd = new GregorianCalendar(1963,Calendar.JULY, 27)
			Address address = new Address(city:"Westport",state:"CT", postalCode:"06880")
			if(address.validate()) {
				address.save()
			}
			else {
				throw new Exception("Problem creating address $address.errors")
				log.error "Problem creating admin user $address.errors"
			}
			PaymentMethod paymentMethod
			SubscriptionType subscriptionType
			Subscription subscription
			User.withTransaction {
				adminUser = new User(login:"admin@esmzone.com", 
				password:new Sha1Hash("Test13").toHex(),
				firstName:"Admin",
				lastName:"User",
				gender: "Male",
				address: address,
				birthdate: bd.time,
				status: UserStatus.ACTIVE,
				source: organicSource,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
                acceptTerms: true,
                ageTerms: true,
				email:"admin@esmzone.com")
				adminUser.addToRoles(name:RoleName.USER)
				adminUser.addToRoles(name:RoleName.MEMBER)
				adminUser.addToRoles(name:RoleName.MENTOR)
				adminUser.addToRoles(name:RoleName.ADMINISTRATOR)
				adminUser.addToRoles(name:RoleName.COACH)
				adminUser.addToRoles(name:RoleName.RECRUITER)
				adminUser.addToRoles(name:RoleName.SPONSOR)
				adminUser.addToRoles(name:RoleName.PARENT)
				if(adminUser.validate()) {
					adminUser.save()
				}
				else {
					throw new Exception("Problem creating admin user $adminUser.errors")
					log.error "Problem creating admin user $adminUser.errors"
				}
				paymentMethod = new PaymentMethod(name:"Free Promo")
				if(paymentMethod.validate()) {
					paymentMethod.save()
				}
				else {
					throw new Exception("Problem creating billing info $paymentMethod.errors")
					log.error "Problem creating billing info $paymentMethod.errors"
				}
				subscriptionType = new SubscriptionType(name:"Annual")
				if(subscriptionType.validate()) {
					subscriptionType.save()
				}
				else {
					throw new Exception("Problem creating billing info $subscriptionType.errors")
					log.error "Problem creating billing info $subscriptionType.errors"
				}
				subscription = new Subscription(subscriber:adminUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				if(subscription.validate()) {
					subscription.save()
				}
				else {
					throw new Exception("Problem creating subscription info $subscription.errors")
					log.error "Problem creating subscription info $subscription.errors"
				}
				adminUser.addToSubscriptions(subscription)
				if (!adminUser.save()) {
					throw new Exception("Problem updating admin user $adminUser.errors")
					log.error "Problem creating updating user $adminUser.errors"
				}					
			}
			
			def systemConfig = new SystemConfig(modifiedBy:adminUser, regEmailOn:true, defaultSource:defaultSource)
			if(systemConfig.validate()) {
				systemConfig.save()
			}
			else {
				throw new Exception("Problem adding systemConfig $systemConfig.errors")
				log.error "Problem adding systemConfig $systemConfig.errors"
			}
			
			def academicsTag = new Tag(name:"Academics", user:adminUser)
			if(academicsTag.validate()) {
				academicsTag.save()
			}
			else {
				throw new Exception("Problem adding Tag $academicsTag.errors")
				log.error "Problem adding Tag $academicsTag.errors"
			}
			def sportsTag = new Tag(name:"Sports", user:adminUser).save()
			def lifeTag = new Tag(name:"Life", user:adminUser).save()
			
			MemberProfile adminProfile = new MemberProfile(grade: GradeLevel.TENTH.toInteger())
			adminProfile.avatar = new Avatar(name:adminUser.toString(), filename:"1.png", nobleAvatar:"2537262170203").save()
			adminProfile.user = adminUser
			adminProfile.currentSchool = school
			adminProfile.addToPlayedSports(name: "Baseball")
			def tag = new Tag(name:"Baseball", user:adminUser).save()
			adminProfile.addToPlayedSports(name: "Basketball")
			tag = new Tag(name:"Basketball", user:adminUser).save()
			adminProfile.addToPlayedSports(name: "Bowling")
			tag = new Tag(name:"Bowling", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Badminton")
			tag = new Tag(name:"Badminton", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Boxing")
			tag = new Tag(name:"Boxing", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Cross Country")
			tag = new Tag(name:"Cross Country", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Cycling")
			tag = new Tag(name:"Cycling", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Diving")
			tag = new Tag(name:"Diving", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Equestrian")
			adminProfile.addToFavoriteSports(name: "Fencing")
			tag = new Tag(name:"Fencing", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Field Hockey")
			tag = new Tag(name:"Field Hockey", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Figure Skating")
			tag = new Tag(name:"Figure Skating", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Football")
			tag = new Tag(name:"Football", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Golf")
			tag = new Tag(name:"Golf", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Gymnastics")
			tag = new Tag(name:"Gymnastics", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Ice Hockey")
			tag = new Tag(name:"Ice Hockey", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Indoor Track")
			tag = new Tag(name:"Indoor Track", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Lacrosse")
			tag = new Tag(name:"Lacrosse", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Mixed Martial Arts")
			tag = new Tag(name:"Mixed Martial Arts", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Track & Field")
			tag = new Tag(name:"Track & Field", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Rowing")
			tag = new Tag(name:"Rowing", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Rugby")
			tag = new Tag(name:"Rugby", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Sailing")
			tag = new Tag(name:"Sailing", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Skateboarding")
			tag = new Tag(name:"Skateboarding", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Skiing")
			tag = new Tag(name:"Skiing", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Snowboarding")
			tag = new Tag(name:"Snowboarding", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Soccer")
			tag = new Tag(name:"Soccer", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Softball")
			tag = new Tag(name:"Softball", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Swimming")
			tag = new Tag(name:"Swimming", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Tennis")
			tag = new Tag(name:"Tennis", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Ultimate Frisbee")
			tag = new Tag(name:"Ultimate Frisbee", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Volleyball")
			tag = new Tag(name:"Volleyball", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Water Polo")
			tag = new Tag(name:"Water Polo", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Weightlifting")
			tag = new Tag(name:"Weightlifting", user:adminUser).save()
			adminProfile.addToFavoriteSports(name: "Wrestling")
			tag = new Tag(name:"Wrestling", user:adminUser).save()
			
			adminProfile.addToFavoriteSubjects(name: "Art")
			def artTag = new Tag(name:"Art", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Drawing")
			tag = new Tag(name:"Drawing", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Photography")
			tag = new Tag(name:"Photography", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Business")
			def businessTag = new Tag(name:"Business", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Accounting")
			tag = new Tag(name:"Accounting", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Law")
			tag = new Tag(name:"Law", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Buseinss Math")
			tag = new Tag(name:"Business Math", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Computers")
			tag = new Tag(name:"Computers", user:adminUser).save()
			def englishSubject = new Subject(name: "English").save()
			adminProfile.addToFavoriteSubjects(englishSubject)
			def englishTag = new Tag(name:"English", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Composition/Grammar")
			tag = new Tag(name:"Composition/Grammar", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Writing Skills")
			tag = new Tag(name:"Writing Skills", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Literature")
			tag = new Tag(name:"Literature", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Journalism")
			tag = new Tag(name:"Journalism", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "History")
			def historyTag = new Tag(name:"History", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "US History")
			tag = new Tag(name:"US HISTORY", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "World History")
			tag = new Tag(name:"World HISTORY", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Languages")
			def languageTag = new Tag(name:"Language", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "French")
			tag = new Tag(name:"French", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Latin")
			tag = new Tag(name:"Latin", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Spanish")
			tag = new Tag(name:"Spanish", user:adminUser).save()
			def mathSubject = new Subject(name: "Math").save()
			adminProfile.addToFavoriteSubjects(mathSubject)
			def mathTag = new Tag(name:"Math", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Pre-Albegra")
			tag = new Tag(name:"Pre-Albegra", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Algebra")
			tag = new Tag(name:"Albegra", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Geometry")
			tag = new Tag(name:"Geometry", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Science")
			def scienceTag = new Tag(name:"Science", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Sociology")
			tag = new Tag(name:"Sociology", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Biology")
			tag = new Tag(name:"Biology", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Chemistry")
			tag = new Tag(name:"Chemistry", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Phisics")
			tag = new Tag(name:"Phisics", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Health")
			tag = new Tag(name:"Health", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Earth Science")
			tag = new Tag(name:"Earth", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Electricity")
			tag = new Tag(name:"Electricity", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Psychology")
			tag = new Tag(name:"Psychology", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Social Studies")
			def socialStudiesTag = new Tag(name:"Social Studies", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Geography")
			tag = new Tag(name:"Geography", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Civics, Government")
			tag = new Tag(name:"Civics, Government", user:adminUser).save()
			adminProfile.addToFavoriteSubjects(name: "Spelling")
			tag = new Tag(name:"Spelling", user:adminUser).save()
			adminProfile.addToLeastFavoriteSubjects(name: "Technology")
			tag = new Tag(name:"Technology", user:adminUser).save()
			adminProfile.addToLeastFavoriteSubjects(name: "Typing")
			tag = new Tag(name:"Typing", user:adminUser).save()
			adminProfile.addToStrongestSubjects(mathSubject)
			adminProfile.addToStrongestSubjects(englishSubject)
			if(adminProfile.validate()) {
				adminProfile.save()
			}
			else {
				throw new Exception("Problem creating admin user  profile $adminProfile.errors")
				log.error "Problem creating admin user profile $adminProfile.errors"
			}
			adminUser.memberProfile = adminProfile
			adminUser.calcDivision() 
			if (!adminUser.save()) {
				throw new Exception("Problem saving completed admin user $adminUser.errors")
				log.error "Problem saving completed admin user $adminUser.errors"
			}
			
			PostType questionPostType = new PostType(name:PostTypeName.QUESTION, audience:PostTypeAudience.PUBLIC).save()
			new PostType(name:PostTypeName.QUESTION, audience:PostTypeAudience.MEMBER).save()
			new PostType(name:PostTypeName.SOCIAL, audience:PostTypeAudience.PUBLIC).save()
			new PostType(name:PostTypeName.SOCIAL, audience:PostTypeAudience.MEMBER).save()
			new PostType(name:PostTypeName.FEEDBACK, audience:PostTypeAudience.PUBLIC).save()
			new PostType(name:PostTypeName.FEEDBACK, audience:PostTypeAudience.MEMBER).save()
			
			//dbrandt test user
			Role role = Role.findByName('ADMINISTRATOR')
			User testUser
			MemberProfile memberProfile
			User.withTransaction {
				address = new Address(city:"Irvington", state:"NY", postalCode:"10533")
				if(address.validate()) {
					address.save()
				}
				else {
					throw new Exception("Problem creating address $address.errors")
					log.error "Problem creating address $address.errors"
				}
				def email = "dbrandt@precidix.com"
				testUser = new User(login:email, 
				password:new Sha1Hash("danish").toHex(),
				firstName:"Dan",
				lastName:"Brandt",
				gender: "Male",
				birthdate: bd.time,
				address: address,
				status: UserStatus.ACTIVE,
				source: organicSource,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
                acceptTerms: true,
                ageTerms: true,
				email:email)
				testUser.addToRoles(role)
				if(testUser.validate()) {
					testUser.save()
				}
				else {
					throw new Exception("Problem creating testUser $testUser.errors")
					log.error "Problem creating testUser $testUser.errors"
				}
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				
				memberProfile = new MemberProfile(grade: GradeLevel.ELEVENTH.toInteger())
				memberProfile.avatar = new Avatar(name:testUser.toString(), filename:"2.png", nobleAvatar:"2537256960423").save()
				memberProfile.currentSchool = school
				memberProfile.addToPlayedSports(Sport.findByName("Basketball"))
				memberProfile.addToPlayedSports(Sport.findByName("Baseball"))
				memberProfile.addToFavoriteSports(Sport.findByName("Basketball"))
				memberProfile.addToFavoriteSports(Sport.findByName("Baseball"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("English"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("Science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Computers"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Math"))
				
				memberProfile.user = testUser
				if(memberProfile.validate()) {
					memberProfile.save()
				}
				else {
					throw new Exception("Problem creating testUser profile $memberProfile.errors")
					log.error "Problem creating testUser profile $memberProfile.errors"
				}
				testUser.memberProfile = memberProfile
				testUser.calcDivision() 
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
				
				def connection = new NetworkConnection(user:testUser, friend:adminUser, type:NetworkConnectionType.FAN, status:NetworkConnectionStatus.ACTIVE)
				if (!connection.save()) { 
					throw new Exception("Problem saving testUser conection to adin $connection.errors")
					log.error "Problem saving testUser conection to adin $connection.errors"
				}
			}
			
			//test user 1
			User.withTransaction {
				address = new Address(city:"Irvington", state:"NY", postalCode:"10533")
				address.save()
				testUser = new User(login:"user1@esmzone.com", 
				password:new Sha1Hash("test").toHex(),
				firstName:"Test",
				lastName:"User1",
				gender: "Male",
				birthdate: bd.time,
				status: UserStatus.ACTIVE,
				source: organicSource,
				address: address,
				isMentor: true,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
                acceptTerms: true,
                ageTerms: true,
				email:"user1@esmzone.com")
				testUser.addToRoles(role)
				testUser.save()
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				memberProfile = new MemberProfile(grade: GradeLevel.EIGHTH.toInteger())
				memberProfile.avatar = new Avatar(name:testUser.toString(), filename:"3.png", nobleAvatar:"2537256960423").save()
				memberProfile.currentSchool = school
				memberProfile.addToFormerSchools(school)
				memberProfile.addToPlayedSports(Sport.findByName("Basketball"))
				memberProfile.addToPlayedSports(Sport.findByName("Baseball"))
				memberProfile.addToFavoriteSports(Sport.findByName("Basketball"))
				memberProfile.addToFavoriteSports(Sport.findByName("Baseball"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("English"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Computers"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Math"))
				memberProfile.user = testUser
				memberProfile.save()
				testUser.memberProfile = memberProfile
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
			}
			
			//test user 2
			User.withTransaction {
				address = new Address(city:"Briarcliff Manor", state:"NY", postalCode:"10510")
				address.save()
				testUser = new User(login:"user2@esmzone.com", 
				password:new Sha1Hash("test").toHex(),
				firstName:"Test",
				lastName:"User2",
				gender: "Male",
				birthdate: bd.time,
				status: UserStatus.ACTIVE,
				source: organicSource,
				address: address,
				isMentor: true,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
				acceptTerms: true,
                ageTerms: true,
                email:"user2@esmzone.com")
				testUser.addToRoles(role)
				testUser.save()
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				memberProfile = new MemberProfile(grade: GradeLevel.EIGHTH.toInteger())
				
				memberProfile.currentSchool = school
				memberProfile.avatar = new Avatar(name:testUser.toString(), filename:"4.png", nobleAvatar:"2537256960423").save()
				memberProfile.addToFormerSchools(school)
				memberProfile.addToPlayedSports(Sport.findByName("Football"))
				memberProfile.addToPlayedSports(Sport.findByName("Baseball"))
				memberProfile.addToFavoriteSports(Sport.findByName("Football"))
				memberProfile.addToFavoriteSports(Sport.findByName("Baseball"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("History"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("English"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Math"))
				memberProfile.user = testUser
				memberProfile.save()
				testUser.memberProfile = memberProfile
				testUser.calcDivision() 
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
			}
			
			//test user 3
			User.withTransaction {
				address = new Address(city:"Briarcliff Manor", state:"NY", postalCode:"10510")
				address.save()
				testUser = new User(login:"user3@esmzone.com", 
				password:new Sha1Hash("test").toHex(),
				firstName:"Test",
				lastName:"User3",
				gender: "Female",
				birthdate: bd.time,
				status: UserStatus.ACTIVE,
				source: organicSource,
				address: address,
				isMentor: true,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
                acceptTerms: true,
                ageTerms: true,
				email:"user3@esmzone.com")
				testUser.addToRoles(role)
				testUser.save()
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				memberProfile = new MemberProfile(grade: GradeLevel.TWELFTH.toInteger())
				memberProfile.avatar = new Avatar(name:testUser.toString(), filename:"5.png", nobleAvatar:"2537256960423").save()
				memberProfile.currentSchool = school
				memberProfile.addToFormerSchools(school)
				memberProfile.addToPlayedSports(Sport.findByName("Football"))
				memberProfile.addToPlayedSports(Sport.findByName("Swimming"))
				memberProfile.addToFavoriteSports(Sport.findByName("Football"))
				memberProfile.addToFavoriteSports(Sport.findByName("Ice Hockey"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("Math"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("Science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("English"))
				memberProfile.addToStrongestSubjects(Subject.findByName("History"))
				memberProfile.user = testUser
				memberProfile.save()
				testUser.memberProfile = memberProfile
				testUser.calcDivision() 
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
			}
			
			
			//test user 4
			User.withTransaction {
				address = new Address(city:"Wesport", state:"CT", postalCode:"10510")
				address.save()
				testUser = new User(login:"user4@esmzone.com", 
				password:new Sha1Hash("test").toHex(),
				firstName:"Test",
				lastName:"User4",
				gender: "Male",
				birthdate: bd.time,
				status: UserStatus.PENDING,
				source: organicSource,
				address: address,
				isMentor: true,
				securityQuestion: securityQuestion,
				securityAnswer: "Secret",
				acceptTerms: true,
                ageTerms: true,
                email:"user4@esmzone.com")
				testUser.addToRoles(role)
				testUser.save()
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				memberProfile = new MemberProfile(grade: GradeLevel.NINTH.toInteger())
				memberProfile.currentSchool = school
				memberProfile.addToFormerSchools(school)
				memberProfile.addToPlayedSports(Sport.findByName("Football"))
				memberProfile.addToPlayedSports(Sport.findByName("Soccer"))
				memberProfile.addToFavoriteSports(Sport.findByName("Football"))
				memberProfile.addToFavoriteSports(Sport.findByName("Soccer"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("English"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("Science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("History"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Languages"))
				memberProfile.user = testUser
				memberProfile.save()
				testUser.memberProfile = memberProfile
				testUser.calcDivision() 
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
			}
			
			//Bill Smith
			User.withTransaction {
				address = new Address(stree:"Bill Street 1", city:"Wesport", state:"CT", postalCode:"10510")
				address.save()
				testUser = new User(login:"bill@optonline.net", 
				password:new Sha1Hash("katlyn").toHex(),
				firstName:"Bill",
				lastName:"Smith",
				gender: "Male",
				birthdate: bd.time,
				status: UserStatus.ACTIVE,
				source: organicSource,
				address: address,
				isMentor: true,
				securityQuestion: securityQuestion,
				securityAnswer: "ginger",
                acceptTerms: true,
                ageTerms: true,
				email:"bill@optonline.net")
				testUser.addToRoles(role)
				testUser.save()
				subscription = new Subscription(subscriber:testUser,subscriptionType:subscriptionType, firstName:adminUser.firstName, lastName:adminUser.lastName, email:adminUser.email, address:address, paymentMethod:paymentMethod)
				subscription.save()
				testUser.addToSubscriptions(subscription)
				memberProfile = new MemberProfile(grade: GradeLevel.NINTH.toInteger())
				memberProfile.currentSchool = school
				memberProfile.addToFormerSchools(school)
				memberProfile.addToPlayedSports(Sport.findByName("Football"))
				memberProfile.addToPlayedSports(Sport.findByName("Soccer"))
				memberProfile.addToFavoriteSports(Sport.findByName("Football"))
				memberProfile.addToFavoriteSports(Sport.findByName("Soccer"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("English"))
				memberProfile.addToLeastFavoriteSubjects(Subject.findByName("science"))
				memberProfile.addToStrongestSubjects(Subject.findByName("History"))
				memberProfile.addToStrongestSubjects(Subject.findByName("Languages"))
				memberProfile.user = testUser
				memberProfile.save()
				testUser.memberProfile = memberProfile
				testUser.calcDivision() 
				if (!testUser.save()) { 
					throw new Exception("Problem saving completed testUser $testUser.errors")
					log.error "Problem saving completed testUser $testUser.errors"
				}
				subscription = new Subscription(subscriber:testUser, subscriptionType:subscriptionType,firstName:testUser.firstName, lastName:testUser.lastName, email:testUser.email, address:address, paymentMethod:paymentMethod) 
				if(subscription.validate()) {
					subscription.save()
				}
				else {
					throw new Exception("Problem creating billing info $subscription.errors")
					log.error "Problem creating billing info $subscription.errors"
				}
				testUser.addToSubscriptions(subscription)
				if (!testUser.save()) {
					throw new Exception("Problem updating test user $testUser.errors")
					log.error "Problem creating updating test $testUser.errors"
				}					
				
			}
			
			Post post
			String answerText
			PostTag postTag
			
			Post.withTransaction {
				post = new Post()
				post.author = adminUser
				post.title = "What is Pi?"
				post.description = "I need to learn all about Pi and how to use it in geometry. I finding it very confusing"
				post.postType = questionPostType
				if(post.validate()) {
					post.save()
				}
				else {
					throw new Exception("Problem creating post $post.errors")
					log.error "Problem creating post $post.errors"
				}
				postTag = new PostTag(tag:mathTag, user:adminUser, post:post, dateCreated:new Date(), lastUpdated:new Date())
				if (postTag.validate()) {
					postTag.save()
				}
				post.addToTags(postTag)
				post.addToRatings(score: PostRating.increment,user:adminUser)
				post.addToRatings(score: PostRating.increment*2,user:testUser)
				post.addToComments(description:"I need the math meaning.", author:testUser)
				if (!post.save(flush:true)) {
					throw new Exception("Problem updating post $post.errors")
					log.error "Problem updating post $post.errors"
				}
			}
			
			String answerText2
			Answer bestAnswer
			AnswerComment answerComment
			Post.withTransaction {
				answerText = new String("""Pi is usually a mathematical term but has other meanings as well.
				    1) The ratio of the circumference to the diameter of a circle; approximately equal to 3.14159265358979323846...
				    2) Private detective: someone who can be employed as a detective to collect information
				    3) Principal investigator: the scientist in charge of an experiment or research project
				    4) The 16th letter of the Greek alphabet
				    5) Protease inhibitor: an antiviral drug used against HIV; interrupts HIV replication by binding and blocking HIV protease; often used in combination with other drug
				    """)
				post.addToAnswers(description:answerText, author:adminUser)
				post.save()
				answerText2 = "p (sometimes written pi) is a mathematical constant whose value is the ratio of any circle's circumference to its diameter in Euclidean space; this is the same value as the ratio of a circle's area to the square of its radius. It is approximately equal to 3.141593 in the usual decimal notation (see the table for its representation in some other bases). The constant is also known as Archimedes Constant, although this name is rather uncommon in modern, western, English-speaking contexts. Many formulae from mathematics, science, and engineering involve p, which is one of the most important mathematical and physical constants."
				bestAnswer = new Answer()
				bestAnswer.description = answerText2
				bestAnswer.author = testUser
				bestAnswer.post = post
				answerComment = new AnswerComment(description:"This is just what I needed. Thanks!", author:testUser,answer:bestAnswer, dateCreated:new Date(), lastUpdated:new Date())
				bestAnswer.addToComments(answerComment)
				bestAnswer.addToRatings(score: PostRating.increment*2,user:adminUser)
				bestAnswer.addToRatings(score: PostRating.increment*3,user:testUser)
				if(bestAnswer.validate()) {
					bestAnswer.save()
				}
				else {
					throw new Exception("Problem creating best answer $bestAnswer.errors")
					log.error "Problem creating best answer $bestAnswer.errors"
				}
				post.addToAnswers(bestAnswer)
				if(post.validate()) {
					post.save()
				}
				else {
					throw new Exception("Problem updating post $post.errors")
					log.error "Problem updating post $post.errors"
				}
			}
			Post.withTransaction {
				post = new Post()
				post.author = adminUser
				post.title = "What is the bill of rights?"
				post.description = "I need to understand the bill of rights and why it's not part of the original constitution"
				post.postType = questionPostType
				post.save()
				postTag = new PostTag(tag:socialStudiesTag, user:adminUser, post:post, dateCreated:new Date(), lastUpdated:new Date()).save()
				post.addToTags(postTag)
				post.addToRatings(score: PostRating.increment*2,user:adminUser)
				post.addToRatings(score: PostRating.increment*3,user:testUser)
				post.addToComments(description:"What are the first 10 amendments?", author:testUser)
				
				answerText = new String("""The bill of rights is the first 10 amendments.
				    1) When the constitution was written it did not include basic human rights
				    2) To get it passed, the left human rights out
				    3) The controversy was between states rights and federal. For example slavery
				    """)
				post.addToAnswers(description:answerText, author:adminUser)
				post.save()
				answerText2 = "The first 10 amendments are the basic set of rights we have today. Additional amendments have been added such as womes sufferage. The first 10 are called the bill or rights."
				bestAnswer = new Answer()
				bestAnswer.description = answerText2
				bestAnswer.author = testUser
				bestAnswer.post = post
				bestAnswer.addToComments(description:"This is just what I needed. Thanks!", author:testUser)
				bestAnswer.addToRatings(score: PostRating.increment*2,user:adminUser)
				bestAnswer.addToRatings(score: PostRating.increment*3,user:testUser)
				bestAnswer.save()
				post.addToAnswers(bestAnswer)
				if (!post.save()) {
					throw new Exception("Problem updating post $post.errors")
					log.error "Problem updating post $post.errors"
				}						
			}
			Post.withTransaction {
				post = new Post()
				post.author = adminUser
				post.title = "What is a sentence fragment?"
				post.description = "I keep getting critisized for sentence fragments. How can I tell a sentence is a fragement?"
				post.postType = questionPostType
				post.save()
				postTag = new PostTag(tag:englishTag, user:adminUser, post:post, dateCreated:new Date(), lastUpdated:new Date()).save()
				post.addToTags(postTag)
				post.addToRatings(score: PostRating.increment*3,user:adminUser)
				post.addToRatings(score: PostRating.increment*3,user:testUser)
				
				answerText = new String("""A SENTENCE FRAGMENT fails to be a sentence in the sense that it cannot stand by itself. It does not contain even one independent clause. There are several reasons why a group of words may seem to act like a sentence but not have the wherewithal to make it as a complete thought.
							    It may locate something in time and place with a prepositional phrase or a series of such phrases, but it's still lacking a proper subject-verb relationship within an independent clause: ex. In Japan, during the last war and just before the armistice.
							    It describes something, but there is no subject-verb relationship:Working far into the night in an effort to salvage her little boat.
							    It may have most of the makings of a sentence but still be missing an important part of a verb string:Some of the students working in Professor Espinoza's laboratory last semester.
								It may even have a subject-verb relationship, but it has been subordinated to another idea by a dependent word and so cannot stand by itself:Even though he had the better arguments and was by far the more powerful speaker.
							    """)
				bestAnswer = new Answer()
				bestAnswer.description = answerText
				bestAnswer.author = testUser
				bestAnswer.post = post
				bestAnswer.addToComments(description:"Wow. Great answer. Thanks!", author:testUser)
				bestAnswer.addToRatings(score: PostRating.increment*3,user:adminUser)
				bestAnswer.addToRatings(score: PostRating.increment*3,user:testUser)
				bestAnswer.save()
				post.addToAnswers(bestAnswer)
				if (!post.save()) {
					throw new Exception("Problem saving post $post.errors")
					log.error "Problem saving post $post.errors"
				}
				assert adminUser.score == 0
			}
			
			Post.withTransaction {
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 1"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 2"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 3"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 4"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 5"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 6"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 7"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 8"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 9"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 10"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 11"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 12"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 13"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 14"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 15"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 16"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 17"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 18"
				post.postType = questionPostType
				post.save()
				post = new Post()
				post.author = adminUser
				post.title = "Test Question 19"
				post.postType = questionPostType
				post.save()
			}
			
			def question = new Question(title: "Blood filter", questionText: "Blood is filtered by which organ?")
			question.addToResponses(responseText: "Lungs", correct: false)
			question.addToResponses(responseText: "Kidney", correct: true)
			question.addToResponses(responseText: "Liver", correct: false)
			question.addToResponses(responseText: "Intestines", correct: false)
			if(question.validate()) {
				question.save()
			}
			else {
				throw new Exception("Problem adding question $question.errors")
				log.error "Problem adding question $question.errors"
			}
			question = new Question(title: "13 + 9", questionText: "What does 13 + 9 equal?")
			question.addToResponses(responseText: "16", correct: false)
			question.addToResponses(responseText: "19", correct: false)
			question.addToResponses(responseText: "21", correct: false)
			question.addToResponses(responseText: "22", correct: true)
			question.save()
			question = new Question(title: "Water on earth", questionText: "What percentage of the Earth is covered in water?")
			question.addToResponses(responseText: "71", correct: true)
			question.addToResponses(responseText: "73", correct: false)
			question.addToResponses(responseText: "76", correct: false)
			question.addToResponses(responseText: "81", correct: false)
			question.save()
			question = new Question(title: "Gravity", questionText: "Earth's gravity is:")
			question.addToResponses(responseText: "8.9 m/s", correct: false)
			question.addToResponses(responseText: "9.8 m/s", correct: true)
			question.addToResponses(responseText: "11.3 m/s", correct: false)
			question.addToResponses(responseText: "12.2 m/s", correct: false)
			question.save()
			question = new Question(title: "Right Angle", questionText: "A right angle is:")
			question.addToResponses(responseText: "0 degrees", correct: false)
			question.addToResponses(responseText: "30 degrees", correct: false)
			question.addToResponses(responseText: "45 degrees", correct: false)
			question.addToResponses(responseText: "90 degress", correct: true)
			question.save()
			question = new Question(title: "Nearest Star", questionText: "What is the nearest star?")
			question.addToResponses(responseText: "The Sun", correct: true)
			question.addToResponses(responseText: "Alpha Centarui", correct: false)
			question.addToResponses(responseText: "Rigil Kentaurus", correct: false)
			question.addToResponses(responseText: "Sirius", correct: false)
			question.save()
			question = new Question(title: "Quarters", questionText: "How many quarters are there in a Canadian football game?")
			question.addToResponses(responseText: "1", correct: false)
			question.addToResponses(responseText: "3", correct: false)
			question.addToResponses(responseText: "4", correct: true)
			question.addToResponses(responseText: "6", correct: false)
			question.save()
			question = new Question(title: "Water Drains", questionText: "What direction can water drain from a sink in the Northern Hemisphere?")
			question.addToResponses(responseText: "Clockwise", correct: false)
			question.addToResponses(responseText: "Counterclockwise", correct: false)
			question.addToResponses(responseText: "Both", correct: true)
			question.save()
			question = new Question(title: "Music Notation", questionText: "What are the treble and bass clef called?")
			question.addToResponses(responseText: "The Grand Staff", correct: true)
			question.addToResponses(responseText: "Full Palette", correct: false)
			question.addToResponses(responseText: "Full Measure", correct: false)
			question.addToResponses(responseText: "The Ledger Line", correct: false)
			question.save()
			question = new Question(title: "Water Molecule", questionText: "A water molecule's molecular formula is:")
			question.addToResponses(responseText: "C02", correct: false)
			question.addToResponses(responseText: "A20", correct: false)
			question.addToResponses(responseText: "02", correct: false)
			question.addToResponses(responseText: "H20", correct: true)
			question.save()
			question = new Question(title: "Average IQ", questionText: "By definition, the average IQ is:")
			question.addToResponses(responseText: "100", correct: true)
			question.addToResponses(responseText: "110", correct: false)
			question.addToResponses(responseText: "125", correct: false)
			question.addToResponses(responseText: "130", correct: false)
			question.save()
			question = new Question(title: "Italy Contenent", questionText: "What continent is Italy in?")
			question.addToResponses(responseText: "Asia", correct: false)
			question.addToResponses(responseText: "Europe", correct: true)
			question.addToResponses(responseText: "Middle East", correct: false)
			question.addToResponses(responseText: "Oceania", correct: false)
			question.save()
			question = new Question(title: "Citrus Vitamin", questionText: "Which vitamin is abundant in citrus fruits?")
			question.addToResponses(responseText: "Vitamin A", correct: false)
			question.addToResponses(responseText: "Vitamin B", correct: false)
			question.addToResponses(responseText: "Vitamin C", correct: true)
			question.addToResponses(responseText: "Vitamin D", correct: false)
			question.save()
			question = new Question(title: "Coin addition", questionText: "A quarter, dime, nickel and penny are worth how much?")
			question.addToResponses(responseText: "40 cents", correct: false)
			question.addToResponses(responseText: "41 cents", correct: true)
			question.addToResponses(responseText: "42 cents", correct: false)
			question.addToResponses(responseText: "43 cents", correct: false)
			question.save()
			question = new Question(title: "Hexagon Sides", questionText: "How many sides does a hexagon have?")
			question.addToResponses(responseText: "5", correct: false)
			question.addToResponses(responseText: "6", correct: true)
			question.addToResponses(responseText: "7", correct: false)
			question.addToResponses(responseText: "8", correct: false)
			question.save()
			question = new Question(title: "Sum of 1 to 10", questionText: "What is the sum of numbers from 1 to 10?")
			question.addToResponses(responseText: "29", correct: false)
			question.addToResponses(responseText: "37", correct: false)
			question.addToResponses(responseText: "49", correct: false)
			question.addToResponses(responseText: "55", correct: true)
			question.save()
			question = new Question(title: "Boiling Point", questionText: "Under normal conditions, what temperature (in Celsius) does water boil?")
			question.addToResponses(responseText: "32", correct: false)
			question.addToResponses(responseText: "100", correct: true)
			question.addToResponses(responseText: "212", correct: false)
			question.addToResponses(responseText: "373", correct: false)
			question.save()
			question = new Question(title: "Earth Satelite", questionText: "Earth's largest natural satellite is the moon.")
			question.addToResponses(responseText: "True", correct: true)
			question.addToResponses(responseText: "False", correct: false)
			question.save()
			question = new Question(title: "Largest Animal", questionText: "The largest animal to have ever lived is:")
			question.addToResponses(responseText: "Killer Whale", correct: false)
			question.addToResponses(responseText: "African Elephant", correct: false)
			question.addToResponses(responseText: "Blue Whale", correct: true)
			question.addToResponses(responseText: "Ultrasaurus", correct: false)
			question.save()
			question = new Question(title: "28 Days", questionText: "How many months have 28 days?")
			question.addToResponses(responseText: "1", correct: false)
			question.addToResponses(responseText: "2", correct: false)
			question.addToResponses(responseText: "4", correct: false)
			question.addToResponses(responseText: "12", correct: true)
			question.save()
			
			
			// setup test questions
			question = new Question(title: "Short Lived Baseball Teams", questionText: "Three of these Major League Baseball teams lasted only one season. The other lasted for over 20 years. Which team was it?", type: QuestionType.PROMOTION)
			question.addToResponses(responseText: "Boston Beaneaters", correct: true)
			question.addToResponses(responseText: "Seattle Pliots", correct: false)
			question.addToResponses(responseText: "St. Louis Perfectos", correct: false)
			question.addToResponses(responseText: "Broklyn Atlantics", correct: false)
			question.save()
	
			question = new Question(title: "2002 NYC Marathon Winners", questionText: "In the 2002 New York City Marathon, which country finished first, second, and third, in the men's division?", type: QuestionType.PROMOTION)
			question.addToResponses(responseText: "Japan", correct: false)
			question.addToResponses(responseText: "United States", correct: false)
			question.addToResponses(responseText: "Poland", correct: false)
			question.addToResponses(responseText: "Kenya", correct: true)
			question.save()

			question = new Question(title: "Mark Spitz Gold Medals", questionText: "The great Olympic swimmer Mark Spitz, won 11 medals in his two Olympics. How many medals were Gold?", type: QuestionType.PROMOTION)
			question.addToResponses(responseText: "2", correct: false)
			question.addToResponses(responseText: "15", correct: false)
			question.addToResponses(responseText: "9", correct: true)
			question.addToResponses(responseText: "3", correct: false)
			question.save()

			question = new Question(title: "2002 MLS Winner", questionText: " Which team won the 2002 Major League Soccer (MLS) Cup?", type: QuestionType.PROMOTION)
			question.addToResponses(responseText: "Galaxy", correct: true)
			question.addToResponses(responseText: "MetroStars", correct: false)
			question.addToResponses(responseText: "D.C. United", correct: false)
			question.addToResponses(responseText: "There was not a Cup held in 2002", correct: false)
			question.save()
			
			//setup a questonPromotion for testing
			def questionPromotion = new QuestionPromotion()
			questionPromotion.quota = 2
			questionPromotion.startDate = new Date()
			questionPromotion.name = "Test Question Promotion"
			questionPromotion.description = "\$10 iTunes gift certificate"
			questionPromotion.correctMessage = "That is the correct answer! Play again tomorrow."
			questionPromotion.incorrectMessage = "Sorry, that is not the correct answer. Try again tomorrow!"
			questionPromotion.winningMessage = "You are a winner!"
			questionPromotion.loggedInCreative = "graphic_trivia_challenge.png"
			questionPromotion.loggedOutCreative = "graphic_trivia_challenge.png"
			questionPromotion.status = PromotionStatus.ACTIVE

			questionPromotion.generateSurvey()
			questionPromotion.save()
			
			systemConfig.questionPromotion = questionPromotion
			systemConfig.save()
		
			/*	
			def homeContent = """<h1>ESMZone</h1>
				<p style="font-size:14px;padding-top:10px">A community for anyone participating in sports and the challenges of being a student.</p>
				<a href="/esmzone/user/register">Join us today</a>
				<img id="sports-icons" src="images/sports-icons.png" alt="Cycling Football Skating Basketball Bowling" />
				<p style="font-weight:bold;font-style:italic;padding-top:5px">Ask questions, earn points!</p>
				<p style="font-weight:bold;font-style:italic;padding-top:5px">Answer questions, earn more points!</p>
				<p style="font-weight:bold;font-style:italic;padding-top:5px">Win prizes and awards as the top point earner in your division!</p>
				<p style="font-size:14px;padding-top:10px">ESMZone unites the power of teamwork with a student athlete's love of competition. Members are rewarded for helping one another.</p>"""
			def homePage = new ContentPage(author:adminUser, description: "Home Page ESMZone intro",
				content:homeContent, view:"home:index")
			if (homePage.validate()) {
				homePage.save()
			}
			else {
				throw new Exception("Problem creating contentPage $homePage.errors")
				log.error "Problem creating contentPage $homePage.errors"
			}
			*/
			//log.info "Starting JMS Container"
			//jmsContainer.start()
		} // end if admin not defined
	}
	def destroy = {
	}
} 