<html>
    <head>
        <title>ESMZONE - Where Student Athletes Train to Lead</title>
		<meta name="layout" content="main" />
    </head>ad
    <body>
        <g:set var="containerClass" value="${(request?.user)?'homepage':'landing'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
				<g:if test="${request?.user}">
					<div class="box">
						<g:render template="/memberProfile/personalStatsWidget" model="['homepage':true]"/>
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
					<%=contentPage?.fetchContent()%>
					<div id="register-button">
						<p><a href="${createLink(controller:'user', action:'joinToday')}" class="iframe">Join ESMZone Today</a> &gt;&gt;</p>
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
			<div id="content" class="narrow">
				<g:if test="${request?.user}">
					<div id="content-header">
						<g:form name="searchform" id="searchform" method="get" action="index">
							<input type="hidden" name="homeTab" value="${params.homeTab}"/>
					        <input type="text" name="q" class="entry-field auto-clear" onfocus="this.select();" value="${params.q?params.q:'Find Questions and Answers'}" size="62"/> 
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
				<g:else>
					<div id="banner">
						<div id="banner-splash">
							<div id="slideshow">
								<img src="${resource(dir:'images', file:'index_animated.gif')}" alt="Where Student Athletes Train to Lead" title="Where Student Athletes Train to Lead" width="550" height="275" />
							</div>
						</div>
						<span class="questions-header">Questions and Answers by the Community</span>
					</div><!-- end of div#banner -->
			    </g:else>
				
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
				<g:if test="${flash.message}">
					<p class="output">MESSAGE:<br><g:message code="${flash.message}"></g:message></p>
				</g:if>
				
				<g:if test="${request.user}">
					<g:render template="/questionPromotion/creativeWidget"/>
				</g:if>
				<g:else>
					<div id="homepage_ad">
						<script type="text/javascript"><!--
						google_ad_client = "ca-pub-4702516645654390";
						/* Logged Out Home */
							google_ad_slot = "1006157256";
							google_ad_width = 200;
							google_ad_height = 200;
						//-->
						</script>
						<script type="text/javascript"
							src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
						</script>
					</div> <!-- end div#homepage_ad -->
					<g:render template="/questionPromotion/creativeWidget"/>
				</g:else>

				<g:render template="/home/twitterWidget"/>
				<!-- g:render template="/user/standingsWidget" model="['userInstance':request?.user, 'userInstanceList1':userInstance1,'userInstanceList2':userInstance2,'userInstanceList3':userInstance3]"/> 					<g:render template="/user/standingsWidget" model="['userInstance':request?.user, 'userInstanceList1':userInstance1,'userInstanceList2':userInstance2,'userInstanceList3':userInstance3]"/> -->
				<div class="standings">
					<a href="${createLink(controller:'user', action:'standings')}" alt="See complete standings">	
						<img src="${resource(dir:'images', file:'standings_graphics.gif')}" alt="Standings" width="190" height="50" />
					</a>
				</div><!-- end of div.standings -->				

				<!--  <script type="text/javascript" src="http://pshared.5min.com/Scripts/ThumbSeed2.js?sid=220&amp;textLocation=0&amp;thumbnailSize=1&amp;width=230&amp;height=330&amp;title=Related%20Video&amp;headerTextColor=%23000000&amp;textFGColor=%23FFFFFF&amp;textFGColor_MO=%23FFFFFF&amp;textBGColor=%2379B0CB&amp;textBGColor_MO=%23000000&amp;categories=131%2C198%2C129%2C206%2C200%2C199%2C201"></script> --> 				
			</div><!-- end div#right -->
		</div><!-- end div#container -->			
    </body>
</html>