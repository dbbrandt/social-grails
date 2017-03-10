<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <g:set var="containerClass" value="${(request?.user)?'standings':'landing standings'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
				<g:if test="${request?.user}">
					<div class="box">
						<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
						<g:form name="filter-searchform" id="search-selection" method="post" action="standings">
						<input type="hidden" name="homeTab" value="${params.homeTab}"/>
						<input type="hidden" name="q" value="${q}"/>
						<input type="hidden" name="school_id" value="${school_id}"/>
						<div class="filters" style="margin-top:10px">
							<h3>Refine Results</h3>
							<table>
								<tr><td><label for="postCount">Members with </label></td><td>
								<g:select class="postCount" name="postCount" from="${[['id':0,'value':'0'],['id':1,'value':'1'], ['id':2,'value':'less than 5'], ['id':3,'value':'at least 10']]}" optionKey="id"  optionValue="value" value="${postCount}" noSelection="['': '']" /> posts</td></tr>
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
						&nbsp;<a href="${createLink(controller:'user', action:'standings')}">Clear all</a>
						<input type="submit" value="Submit" class="hidden">
						<a href="javascript:submitform('filter-searchform')" class="submit right button">Find Results</a>
						</g:form>	
					</div><!-- end div.box -->
					<div class="facebook">
						<div class="share">
							<a href="http://www.facebook.com/sharer.php?u=www.esmzone.com/esmzone&t=ESMZONE - Where Student Athletes Train to Lead" class="share-link button nofold" target="_blank"></a>
							
						</div>
					</div><!-- end div.facebook -->
					
					<div class="addtoany">
						<a class="a2a_dd" href="http://www.addtoany.com/share_save"><img src="${resource(dir:'images', file:'addtoany_button.png')}" width="161" height="16" border="0" alt="Share"/></a>
						<script type="text/javascript">
							var a2a_config = a2a_config || {};
							a2a_config.linkname = "ESMZone";
						</script>
<script type="text/javascript" src="http://static.addtoany.com/menu/page.js"></script>
					</div><!-- end div.addtoany -->
					
				</g:if>
				<g:else>
				    <div class="box">
						<%=contentPage?.fetchContent()%>
						<div id="register-button">
							<p><a href="${createLink(controller:'user', action:'joinToday')}" class="iframe">Join ESMZone Today</a> &gt;&gt;</p>
						</div>
					</div>
					<div class="facebook">
						<div class="share">
							<a href="http://www.facebook.com/sharer.php?u=www.esmzone.com/esmzone&t=ESMZONE - Where Student Athletes Train to Lead" class="share-link button nofold" target="_blank"></a>
						</div>
					</div><!-- end div.facebook -->
					
					<div class="addtoany">
						<a class="a2a_dd" href="http://www.addtoany.com/share_save"><img src="${resource(dir:'images', file:'addtoany_button.png')}" width="161" height="16" border="0" alt="Share"/></a>
						<script type="text/javascript">
							var a2a_config = a2a_config || {};
							a2a_config.linkname = "ESMZone";
						</script>
<script type="text/javascript" src="http://static.addtoany.com/menu/page.js"></script>
					</div><!-- end div.addtoany -->
					
				</g:else>
				
			</div><!-- end div#left -->
			<div id="content" class="wide">
			<div id="content-header">
				<ul class="menu">
					<li><a class="${(params.homeTab == 'I')?'current':''}" href="${createLink(controller:'user', action:'standings')}?homeTab=I">Division I Standings</a></li>
					<li><a class="${(params.homeTab == 'II')?'current':''}" href="${createLink(controller:'user', action:'standings')}?homeTab=II">Division II Standings</a></li>
					<li><a class="${(params.homeTab == 'III')?'current':''}" href="${createLink(controller:'user', action:'standings')}?homeTab=III">Division III Standings</a></li>
				</ul>
			</div><!-- end div#content-header -->
				<div id="page">
					<table class="sortable">
						<col id="col-number"></col>
						<col id="col-name"></col>
						
						<col id="col-grade"></col>
						<col id="col-gender"><col id="col-town"></col>
						<col id="col-sports"></col>
						<col id="col-subjects"></col>
						<col id="col-score"></col>
						<thead>
							<tr>
								<th class="sorttable_nosort number"></th>
								<th class="name" width="175px">Name</th>
								<th class="mentor" width="45px"></th>
								<th class="grade" width="45px">Grade</th>
								<th class="school" width="165px">School</th>
								<th class="sorttable_nosort medals" width="100px">Medals</th>
								<th class="score" width="65px">Score</th>
						</thead>
						<tbody>
						<g:if test="${userInstanceList?.size() > 0}">
							<g:each in="${userInstanceList}" var="userInstance">
								<tr>
									<td>${userInstance.rank()}</td>
									<g:if test="${request?.user}"> 
										<td><g:link class="iframe" controller='user' action="statsReport" id="${userInstance?.id}"><h2>${userInstance}</h2></g:link></td>
									</g:if>
									<g:else>
										<td><h2>${userInstance?.firstName}</h2></td>
									</g:else>
									<td>
										<g:if test="${userInstance.isMentor}">
											<span>Mentor</span>
										</g:if>
									</td>
									<td>${userInstance.memberProfile?.gradeLevel()}</td>
									<td>${userInstance.memberProfile?.currentSchool}</td>
									<td>				
										<g:set var="medals" value="${userInstance?.medals()}"/>
										<g:each in="${medals}" var="medal">			
											<img  id="medal_${medal.value}" title="${medal.name}" alt="${medal.name}"  src="${resource(dir:'images',file:'medal'+medal.value+'.png')}">
										</g:each>
									</td>
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
			
			<g:if test="${request.user}">
			</g:if>
			<g:else>
				<div id="standings_ad">
					<script type="text/javascript"><!--
						google_ad_client = "ca-pub-4702516645654390";
						/* Logged out Standings banner */
						google_ad_slot = "4951777866";
						google_ad_width = 468;
						google_ad_height = 60;
						//-->
					</script>
					<script type="text/javascript"
						src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

				</div><!-- end of div#standings_ad -->
			</g:else>
			
		</div><!-- end div#container -->			
    </body>
</html>