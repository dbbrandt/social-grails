<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="profile">
			<div id="left">
				<div class="box">
					<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
					<div class="profile-header section">
						<h1>${userInstance}</h1>
						<g:if test="${userInstance.isMentor}">
							<span>Mentor</span>
						</g:if>
						<img id="questionAvatar_${userInstance?.id}" title="${userInstance}" alt="${userInstance}" src="${userInstance?.avatarFile()}" class="avatar">
						<a href="${createLink(controller:'post', action:'addMessage', id:userInstance?.id)}" class="iframe">Send Message</a>
						<g:if test="${userInstance != request.user}">
							<g:if test="${userInstance.amFan(request?.user)}">
								<a class="disable">Am Fan</a>
							</g:if>
							<g:elseif test="${userInstance.isFan(request?.user)}">
								<a class="disable">My Fan</a>
							</g:elseif>
							<g:elseif test="${userInstance.pendingFan(request?.user)}">
							 	<a class="disable">Fan Requested</a>
							</g:elseif>
							<g:else>
								<a href="${createLink(controller:'networkConnection', action:'requestAFan', id:userInstance?.id)}" class="iframe">Be a Fan</a>
							</g:else>
							<g:if test="${userInstance.isMentor}"> 
								<g:if test="${request?.user.myMentor(userInstance)}">
									<a class="disable">My Mentor</a>
								</g:if>
								<g:if test="${request?.user.myMentee(userInstance)}">
									<a class="disable">My Mentee</a>
								</g:if>
								<g:elseif test="${request?.user.pendingMentor(userInstance)}">
								 	<a class="disable">Mentor Requested</a>
								</g:elseif>
								<g:else>
									<a href="${createLink(controller:'networkConnection', action:'requestAMentor', id:userInstance?.id)}" class="iframe">Request Mentor</a>
								</g:else>
							</g:if>
						</g:if>
					</div><!-- end div.profile-header -->
					<div class="medals section"><!-- begin medals section -->
						<h3>Medals</h3>
						<ul>
							<g:set var="medals" value="${userInstance?.medals()}"/>
							<g:each in="${medals}" var="medal">			
								<li>
									<img  id="medal_${medal.value}" title="${medal.name}" alt="${medal.name}"  src="${resource(dir:'images',file:'medal'+medal.value+'.png')}">
								</li>
							</g:each>
						</ul>
					</div><!-- end medals section -->
					<div class="stats section"><!-- begin stats section -->
						<h3>Stats</h3>
						<table>
							<colgroup class="left"></colgroup>
							<colgroup></colgroup>
							<g:if test="${userInstance.isMentor}">
								<tr><td>Total Ratings</td><td>${request?.user?.ratingCount}&nbsp; <img alt="${request?.user?.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-black-'+request?.user?.starRating()+'.png')}" /></td></tr>
							</g:if>
							<tr><td>Questions Asked</td><td>${userInstance?.questionCount}</td></tr>
							<tr><td>Questions Answered</td><td>${userInstance?.answerCount}</td></tr>
							<tr><td>Total Points Earned</td><td>${userInstance?.points}</td></tr>
							<tr><td>Score</td><td>${userInstance?.score}</td></tr>
							<tr><td>Division ${userInstance?.division} Rank</td><td>${userInstance?.rank()}</td></tr>
						</table>
					</div><!-- end stats section -->
										<div class="fans-mentors section"><!-- begin fans/mentors section -->
						<h3>Fans &#149; Mentors</h3>
						<g:set var="fanlist" value="${userInstance?.connectionList()}"/>
						<span class="counter">${fanlist.size()}</span><!-- fans/mentor number goes here -->
						<div id="avatar-gallery">
							<g:each in="${fanlist}" var="fan">
								<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${fan?.id}">
									<img id="avatar_${fan?.id}"  title="${fan}" src="${fan?.avatarFile()}" class="avatar" />
								</a>
							</g:each>
						</div><!-- end div#avatar-gallery -->
						<g:if test="${fanlist.size() > 0}">
							<a href="${createLink(controller:'user', action:'fanReport', id:userInstance?.id)}" class="see-more-link iframe">See all fans and mentors</a>
						</g:if>
					</div><!-- end fans/mentors section -->
					<div class="profile-info section"><!-- begin stats section -->
						<table>
							<colgroup class="left"></colgroup>
							<colgroup></colgroup>
							<tr><td>Gender</td><td>${userInstance?.gender}</td></tr>
							<tr><td>Grade</td><td>${userInstance?.memberProfile?.gradeLevel()}</td></tr>
							<tr><td>City/Town</td><td>${userInstance?.address?.city}</td></tr>
							<tr><td>School</td><td>${userInstance?.memberProfile?.currentSchool}</tr>
							<tr><td>Sports Played</td><td>${userInstance?.memberProfile?.playedSports}</td></tr>
						</table>
					</div><!-- end stats section -->
				</div><!-- end div.box -->
			</div><!-- end div#left -->
			<div id="content" class="narrow">
				<div id="content-header">
					<g:form name="searchform" id="searchform" method="get" action="view">
						<input type="hidden" name="homeTab" value="${params.homeTab}"/>
						<input type="hidden" name="userId" value="${userInstance?.id}"/>
				        <input type="text" name="q" class="entry-field auto-clear" onfocus="this.select();" value="${params.q?params.q:'Find Questions and Answers'}" size="62"/> 
						<input type="submit" value="Submit" class="hidden">
						<a href="javascript:submitform('searchform')" class="button">Search</a>
					</g:form>
					<ul class="menu">
						<li><a class="${(params.homeTab == 'Everyone')?'current':''}" href="?homeTab=Everyone&id=${userInstance?.id}">Everyone</a></li>
						<li><a class="${(params.homeTab == 'Private')?'current':''}" href="?homeTab=Private&id=${userInstance?.id}">Private</a></li>
					</ul>
				</div><!-- end div.content-header -->
				<g:if test="${postInstanceList?.size() > 0}">
				<g:each in="${postInstanceList}" var="postInstance">
					<div id="conversationQuestion${postInstance.id}" class="conversation" >
						<g:render template="/post/conversationWidget" model="['postInstance':postInstance, 'answerInstance':postInstance.topAnswer()]"/>
					</div><!-- end div.conversation -->
				</g:each>
				</g:if>
				<g:else>
					<div class="conversation" >
						<p>&nbsp;&nbsp;No results found.</p>
					</div><!-- end div.conversation -->
				</g:else>
				<div id="content-footer">
	                <esm:paginate total="${postInstanceTotal}" />
				</div><!-- end div#content-footer -->
			</div><!-- end div#content -->
			<div id="right">
				<div class="box">
					<g:render template="/user/standingsWidget" model="['userInstance',userInstance]"/>
				</div><!-- end div.box -->
				
				<div id="view_profile_ad">
					<script type="text/javascript"><!--
						google_ad_client = "ca-pub-4702516645654390";
						/* view others profile */
						google_ad_slot = "1880267471";
						google_ad_width = 200;
						google_ad_height = 200;
						//-->
					</script>
					<script type="text/javascript"
						src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

	
				</div>
				
			</div><!-- end div#right -->
		</div><!-- end div#container -->			
    </body>
</html>