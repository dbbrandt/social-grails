<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <g:set var="containerClass" value="${(request?.user)?'people':'landing people'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
				<g:if test="${request?.user}">
					<div class="box">
						<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
						<g:form name="filter-searchform" id="search-selection" method="post" action="people">
						<input type="hidden" name="q" value="${ q }"/>
						<input type="hidden" name="school_id" value="${school_id}"/>
						<div class="filters" style="margin-top:10px">
							<h3>Refine Search</h3>
							<table>
	
								<tr><td><label for="postCount">Members with ></label></td><td><input name="postCount" size="6" value="${postCount}"/> posts</td></tr>
								<tr><td><label for="gender">Gender</label></td><td><input type="checkbox" value="1" name="male" ${(male=='1')?'checked':''}/> Male<input type="checkbox" value="1" name="female" ${(female=='1')?'checked':''}/> Female</td></tr>
								<tr><td><label for="grade">Grade</label></td>
									<td><g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${grade}" noSelection="['': '']" /></td>
								</tr>
								<tr><td><label for="sports">Sports Played</label></td>
									<td><g:select class="sports" name="playedSport" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${playedSport}" noSelection="['': '']"  /></td>
								</tr>
								<tr><td><label for="school">School</label></td>
									<td><gui:autoComplete
									        id="schoolAutoInput"
									        idField="id"
									        style="autoInput1"
									        controller="memberProfile"
									        action="schoolAutocomplete"
									        minQueryLength="3"
									        queryDelay="0.5"
									        value="${school}"
										/>
									</td>
								</tr>
								<tr><td><label for="location">City/Town</label></td><td><input name="city" size="17" value="${city}"/></td></tr>
							</table>
						</div><!-- end div.filters -->
						<br>
						&nbsp;<a href="${createLink(controller:'user', action:'people')}">Clear all</a>
						<input type="submit" value="Submit" class="hidden">
						<a href="javascript:submitform('filter-searchform')" class="submit right button">Find Results</a>
						</g:form>	
					</div><!-- end div.box -->
					<div class="facebook">
						<g:if test="${fbContent}">
							<div class="share">
								<a style="margin-left:${(containerClass=='homepage')?'0px':'78px'};" class="friend-link" onclick="fb_inviteFriends()"></a>
							</div>
						</g:if>
						<g:else>
							<div class="share">
								<a style="margin-left:${(containerClass=='homepage')?'0px':'78px'};" href="http://www.facebook.com/sharer.php?u=www.esmzone.com/esmzone&t=ESM ZONE - The Place For Student Athletes" target="_blank" class="share-link"></a>
							</div>
						</g:else>
					</div><!-- end div.ad.box -->
				</g:if>
				<g:else>
					<div class="box">
						<h1>ESMZone</h1>
						<p style="font-size:14px;padding-top:10px">Be in the zone. Register now ...</p>
						<a href="${createLink(controller:'user', action:'register')}">Join us today</a>
		
						<img id="sports-icons" src="${resource(dir:'images',file:'sports-icons.png')}" alt="Cycling Football Skating Basketball Bowling" />
						<p style="font-weight:bold;font-style:italic;padding-top:5px">Ask questions, earn points!</p>
						<p style="font-weight:bold;font-style:italic;padding-top:5px">Answer questions, earn more points!</p>
						<p style="font-weight:bold;font-style:italic;padding-top:5px">Win prizes and awards as the top point earner in your division!</p>
						<p style="font-size:14px;padding-top:10px">ESMZone unites the power of teamwork with a student athlete's love of competition. Members are rewarded for helping one another.</p>
	
						<a id="register-join-button" href="${createLink(controller:'user', action:'register')}" class="right button">Register and Join ESM Zone</a>
					</div><!-- end div.box -->
					<div class="facebook">
						<div class="share">
							<a style="margin-left:${(containerClass=='homepage')?'0px':'78px'};" href="http://www.facebook.com/sharer.php?u=www.esmzone.com/esmzone&t=ESM ZONE - The Place For Student Athletes" target="_blank" class="share-link"></a>
						</div>
					</div><!-- end div.ad.box -->
				</g:else>
			</div><!-- end div#left -->
			<div id="content" class="wide">
				<g:if test="${request?.user}">
					<div id="content-header">
						<g:form name="searchform" id="searchform" method="get" action="people">
							<input type="hidden" name="homeTab" value="${params.homeTab}"/>
					        <input type="text" name="q" class="entry-field auto-clear" onfocus="placeholder(this);" value="${params.q?params.q:'Find People'}" size="62"/> 
							<input type="submit" value="Submit" class="hidden">
							<a href="javascript:submitform('searchform')" class="button">Search</a>
						</g:form>
					</div><!-- end div.content-header -->
				</g:if>
				<div id="page">
					<table class="sortable">
						<col id="col-number"></col>
						<col id="col-name" width="170px"></col>
						<col id="col-gender" width="60px"></col>
						<col id="col-grade" width="60px"></col>
						<col id="col-town" width="140px"></col>
						<col id="col-sports" width="130px"></col>
						<col id="col-school" width="130px"></col>
						<col id="col-score" width="70px"></col>
						<thead>
							<tr>
								<th class="sorttable_nosort"></th>
								<th width="165px">Name</th>
								<th class="sorttable_nosort" width="45px">Gender</th>
								<th width="45px">Grade</th>
								<th>School</th>
								<th class="sorttable_nosort">Sport(s) Played</th>
								<th class="sorttable_nosort">Subject(s)</th>
								<th width="50px">Score</th>
						</thead>
						<tbody>
						<g:if test="${userInstanceList?.size() > 0}">
							<g:each in="${userInstanceList}" var="userInstance">
								<tr>
									<g:if test="${request?.user}">
										<td>
											<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${userInstance?.id}"><img id="avatar_${userInstance?.id}"  title="${userInstance}" src="${userInstance?.avatarFile()}" class="avatar" /></a>
										</td>
										<td>
											<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${userInstance?.id}"><h2>${userInstance}</h2></a>
											<g:if test="${userInstance.isMentor}">
												<span>Mentor</span>
												<img alt="${userInstance?.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-black-'+userInstance?.starRating()+'.png')}" />
											</g:if>
										</td>
									</g:if>
									<g:else>
										<td>
											<img id="avatar_${userInstance?.id}"  title="${userInstance?.firstName}" src="${userInstance?.avatarFile()}" class="avatar" />
										</td>
										<td>											
											<g:if test="${userInstance.isMentor}">
												<span>Mentor</span>
												<img alt="${userInstance?.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-black-'+userInstance?.starRating()+'.png')}" />
											</g:if>
										</td>
									</g:else>
									<td>${userInstance.gender}</td>
									<td>${userInstance.memberProfile?.gradeLevel()}</td>
									<td>${userInstance.memberProfile?.currentSchool}</td>
									<td>${userInstance.memberProfile?.playedSports}</td>
									<td>${userInstance.memberProfile?.strongestSubjects}</td>
									<td>${userInstance.score}</td>
								</tr>
							</g:each>
							</g:if>
							<g:else>
								<tr>
									<td colspan="8">No results found.</td>
								</tr>
							</g:else>
						</tbody>
					</table>
				</div><!-- end div#page -->
				<div id="content-footer">
	                <esm:paginate total="${userInstanceTotal}" />
				</div><!-- end div#content-footer -->
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>