class UrlMappings {
    static mappings = {
		// user access
		"/logout"(controller:"user", action:"logout")
		"/login"(controller:"user", action:"login")
		"/facebookLogin"(controller:"user", action:"fbLogin")
		"/register"(controller:"user", action:"register")
		"/joinToday"(controller:"user", action:"joinToday")
		"/registrationConfirm"(controller:"user", action:"registrationConfirm")
		"/facebookConfirm"(controller:"user", action:"facebookConfirm")
		"/forgotPassword"(controller:"user", action:"forgotPassword")
		"/confirmRegistration"(controller:"user", action:"confirmRegistration")
		"/account"(controller:"user", action:"account")
		"/fanReport"(controller:"user", action:"fanReport")
		"/selectMentor"(controller:"user", action:"selectMentor")
		"/mentorDirectory"(controller:"user", action:"mentorDirectory")
		"/people/student_athlete"(controller:"user", action:"people")
		"/scoreboard/standings"(controller:"user", action:"standings")
		"/stats"(controller:"user", action:"statsReport")
		"/testFacebookAPI"(controller:"user", action:"facebookAPI")
		
		"/editProfile"(controller:"memberProfile", action:"editProfile")
		"/editProfileInfo"(controller:"memberProfile", action:"editProfileInfo")
		"/editProfileInterestes"(controller:"memberProfile", action:"editProfileInterests")
		"/editProfileAvatar"(controller:"memberProfile", action:"editProfileAvatar")
		"/editProfileFans"(controller:"memberProfile", action:"editProfileFans")
		"/menteeProfile"(controller:"memberProfile", action:"menteeProfile")
		"/mentorProfile"(controller:"memberProfile", action:"mentorProfile")
		"/viewProfile"(controller:"memberProfile", action:"view")
		"/upload"(controller:"memberProfile", action:"upload")
		"/uploadAvatar"(controller:"memberProfile", action:"uploadAvatar")
		"/selectAvatar"(controller:"memberProfile", action:"selectAvatar")
		"/selectSchool"(controller:"memberProfile", action:"selectSchool")
		"/schoolAutocomplete"(controller:"memberProfile", action:"schoolAutocomplete")

		"/askQuestion/online_game"(controller:"post", action:"add")
		"/viewQuestion"(controller:"post", action:"view")
		"/publicQuestions"(controller:"post", action:"directory")
		"/shoutOuts"(controller:"post", action:"postDirectory")
		"/addShoutOut"(controller:"post", action: "addShoutOut")
		"/addMessage"(controller:"post", action: "addMessage")
		"/tagedQuestions"(controller:"post", action:"tagDirectory")
		"/privateQuestions"(controller:"post", action:"privateDirectory")
		"/editQuestion"(controller:"post", action:"modify")
		"/ratePost"(controller:"post", action:"rate")
		"/search/sports_games"(controller:"post", action:"search")
		"/feedback"(controller:"post", action:"feedback")
		"/addTag"(controller:"post", action:"addTag")

		"/getTopics"(controller:"tag", action:"getTopicTags")
		"/getTags"(controller:"tag", action:"getTags")
		"/tagAutocomplete"(controller:"tag", action:"tagAutocomplete")

		"/addQuestionComment"(controller:"postComment", action:"add")

		"/addAnswer"(controller:"answer", action:"add")

		"/addAnswerComment"(controller:"answerComment", action:"add")

		"/apply"(controller:"mentorApplication", action:"apply")
		"/mentorStatus"(controller:"mentorApplication", action:"status")
		"/quizResults"(controller:"mentorApplication", action:"failedQuiz")
		"/references"(controller:"mentorApplication", action:"referenceInput")
		"/referenceResponse"(controller:"mentorApplication", action:"referenceResponse")
		"/responseConfirm"(controller:"mentorApplication", action:"responseConfirm")
		"/applicationCompleted"(controller:"mentorApplication", action:"complete")
		"/viewQuiz"(controller:"mentorQuiz", action:"view")
		"/submitQuiz"(controller:"mentorQuiz", action:"submitQuiz")

		"/dialogWidget"(controller:"home", action:"dialogWidget")
		"/scoreWidget"(controller:"home", action:"scoreWidget")
		"/about"(controller:"home", action:"about")
		"/contact"(controller:"home", action:"contact")
		"/privacy"(controller:"home", action:"privacy")
		"/terms"(controller:"home", action:"terms")
		"/faqs"(controller:"home", action:"faqs")
		"/spectators"(controller:"home", action:"spectators")
		
		"/statsSheet"(controller:"points", action:"statsSheet")

		"/rateAnswer"(controller:"answer", action:"rate")
		"/bestAnswer"(controller:"answer", action: "bestAnswer")

		"/questionPromo"(controller:"questionPromotion", action:"viewQuestion")
		"/answerPromo"(controller:"questionPromotion", action:"viewResult")
		
		"/requestAMentor"(controller:"networkConnection", action:"requestAMentor")
		"/requestAFan"(controller:"networkConnection", action:"requestAFan")
		"/requestFan"(controller:"networkConnection", action:"requestFan")
		"/requestMentor"(controller:"networkConnection", action:"requestMentor")
		"/scoutReport"(controller:"networkConnection", action:"scoutReport")
		"/requestReport"(controller:"networkConnection", action:"requestReport")
		"/acceptConnection"(controller:"networkConnection", action:"acceptConnection")
		"/declineConnection"(controller:"networkConnection", action:"declineConnection")
		"/removeConnection"(controller:"networkConnection", action:"removeConnection")
		"/removeAConnection"(controller:"networkConnection", action:"removeAConnection")

		"/addComplaint"(controller:"complaint", action:"add")

		"/patronRegistration"(controller:"patron", action:"register")

		"/transactionReport"(controller:"ESMTransaction", action:"transactionReport")
		"/clearTransaction"(controller:"ESMTransaction", action:"clearTransaction")
		"/viewTransactionDetail"(controller:"ESMTransaction", action:"viewDetail")
		
		"/searchsports_games"(controller:"home", action: "search")
		"/adminHome"(controller:"home", action: "admin")
		"/facebookHome"(controller:"home", action: "indexFacebook")
		"/facebookTest"(controller:"home", action: "facebookTest")
		
		//Anonymous browsing
		"/community_game"(controller:"home", action: "index")
		"/"(controller:"home", action: "home")
		"/joinToday"(controller: "user", action: "joinToday")
		

		// Administrator access
    	"/admin/$controller/$action?"()
    	"500"(view:'/error')
	}
}
