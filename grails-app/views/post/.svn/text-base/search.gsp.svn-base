<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <g:set var="containerClass" value="${(request?.user)?'search':'landing search'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
					<div class="box">
						<g:if test="${request?.user}">
							<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
						</g:if>
						<g:form name="filter-searchform" id="search-selection"	method="post" controller="post" action="search">
						<input type="hidden" name="q" value="${ q }"/>
						<input type="hidden" name="school_id" value="${school_id}"/>
						<input type="hidden" name="homeTab" value="${homeTab}"/>
						<input type="hidden" name="postInstanceTotal" value="${postInstanceTotal}"/>
						<br>
						<div class="filters" >
							<h3>Refine Search</h3>
							<table>
	
							<!-- <tr><td><label for="tags">Search by tags</label></td><td><input name="tags" type="checkbox" ${(tags=='on')?'checked':''}/></td></tr>  -->	
								<tr><td><label for="answers">Questions with</label></td>
									<td><g:select class="answers" name="answers" from="${[['id':0,'value':'0 answers'],['id':1,'value':'1 answer'],['id':2,'value':'less than 5 answers'], ['id':3,'value':'at least 10 answers']]}" optionKey="id"  optionValue="value" value="${answers}" noSelection="['': '# of answers']" /></td></tr>
								</tr>
								<tr><td><label for="rating">Questions with</label></td>
									<td><g:select class="rating" name="rating" from="${[['id':1,'value':'1 star'],['id':2,'value':'2 stars'],['id':3,'value':'3 stars'],['id':4,'value':'4 stars'],['id':5,'value':'5 stars']]}" optionKey="id" optionValue="value" value="${rating}" noSelection="['': '# of stars']" /></td>
								</tr>
								<tr><td><label for="gender">Gender</label></td><td><input type="checkbox" value="Male" name="gender" ${(gender=='Male')?'checked':''}/> Male<input type="checkbox" value="Female" name="gender" ${(gender=='Female')?'checked':''}/> Female</td></tr>
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
								<tr><td><label for="location">City/Town</label></td><td><input id="cityInput" name="city" size="17" value="${city}"/></td></tr>
							</table>
						</div><!-- end div.filters -->
						<br>
						&nbsp;<a href="${createLink(controller:'post', action:'search')}">Clear all</a>
						<input type="submit" value="Submit" class="hidden">
							<g:if test="${request?.user}">
								<a href="javascript:submitform('filter-searchform')" title="Filter results" class="submit right button">Find Results</a>
							</g:if>
							<g:else>
								<a href="${createLink(controller:'user', action:'joinToday')}" title="Join ESMZone Today" class="submit right button iframe">Join ESMZone Today</a>
							</g:else>
						</g:form>	
					</div><!-- end div.box -->
					
					<g:if test="${request.user}">
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
						
						<div id="search_ad">
							<script type="text/javascript"><!--
								google_ad_client = "ca-pub-4702516645654390";
								/* Logged in Search - Left Column */
								google_ad_slot = "0111867188";
								google_ad_width = 200;
								google_ad_height = 200;
							//-->
							</script>
							<script type="text/javascript"
								src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
							</script>
						</div>
					</g:if>
					
					<g:else>
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
						
						<div id="search_ad">
							<script type="text/javascript"><!--
								google_ad_client = "ca-pub-4702516645654390";
								/* Logged out Search */
								google_ad_slot = "6594225271";
								google_ad_width = 200;
								google_ad_height = 200;
							//-->
							</script>
							<script type="text/javascript"
								src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
							</script>
						</div><!-- end div#search_ad -->
					</g:else>
					
			</div><!-- end div#left -->
			<div id="content" class="narrow">
				<g:if test="${request?.user}">
					<div id="content-header">
						<g:form name="searchform" id="searchform" method="get" action="search">
							<input type="hidden" name="homeTab" value="${params.homeTab}"/>
					        <input type="text" name="q" class="entry-field auto-clear" onfocus="placeholder(this);" value="${params.q?params.q:'Find Questions and Answers'}" size="62"/> 
							<input type="submit" value="Submit" class="hidden">
							<a href="javascript:submitform('searchform')" class="button">Search</a>
						</g:form>
						<ul class="menu">
							<li><a class="${(params.homeTab == 'Everyone')?'current':''}" href="?homeTab=Everyone" title="Questions from everyone">Everyone</a></li>
							<li><a class="${(params.homeTab == 'Mine')?'current':''}" href="?homeTab=Mine" title="Questions I asked everyone">Mine</a></li>
							<li><a class="${(params.homeTab == 'Fans')?'current':''}" href="?homeTab=Fans" title="Questions my fans asked everyone">My Fans</a></li>
							<li><a class="${(params.homeTab == 'Mentors')?'current':''}" ahref="?homeTab=Mentors" title="Comming Soon!">My Mentors</a></li>
							<li><a class="${(params.homeTab == 'Private')?'current':''}" href="?homeTab=Private" title="Private questions with my fans">Private</a></li>
						</ul>
					</div><!-- end div.content-header -->
				</g:if>
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
			<g:if test="${request.user}">
				<div id="right">
					<div class="box">
						<div class="popular-tags section">
							<g:render template="/post/popularTagsWidget" model="['popularTagList':popularTagList]"/>
						</div><!-- end div.section -->
						<!--  <script type="text/javascript" src="http://pshared.5min.com/Scripts/ThumbSeed2.js?sid=220&amp;textLocation=0&amp;thumbnailSize=1&amp;width=230&amp;height=330&amp;title=Related%20Video&amp;headerTextColor=%23000000&amp;textFGColor=%23FFFFFF&amp;textFGColor_MO=%23FFFFFF&amp;textBGColor=%2379B0CB&amp;textBGColor_MO=%23000000&amp;fallback=15&amp;categories=15&amp;fallbackType=category"></script>  -->
						
					</div><!-- end div.box -->
					<div id="search_ad_right">
						<script type="text/javascript"><!--
							google_ad_client = "ca-pub-4702516645654390";
							/* Logged in - Search Right Column square */
							google_ad_slot = "1533918844";
							google_ad_width = 200;
							google_ad_height = 200;
							//-->
						</script>
						<script type="text/javascript"
							src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
						</script>
						
					</div>
				</div><!-- end div#right -->
			</g:if>
			<g:else>
				<div id="right" class="search-sidebar">
					<%=contentPage?.fetchContent()%>
					<div id="register-button">
						<p><a href="${createLink(controller:'user', action:'joinToday')}" class="iframe">Join ESMZone Today</a> &gt;&gt;</p>
					</div>
				</div> <!-- End div#right -->
			</g:else>
		</div><!-- end div#container -->			
    </body>
</html>