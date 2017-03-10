<g:set  var="user" value="${request?.user}"/>
<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="ask-question">
			<div id="left">
				<!-- 
				<div class="box">
					<script type="text/javascript" src="http://pshared.5min.com/Scripts/ThumbSeed2.js?sid=220&amp;textLocation=0&amp;thumbnailSize=1&amp;width=230&amp;height=330&amp;title=Related%20Video&amp;headerTextColor=%23000000&amp;textFGColor=%23FFFFFF&amp;textFGColor_MO=%23FFFFFF&amp;textBGColor=%2379B0CB&amp;textBGColor_MO=%23000000&amp;fallback=15&amp;categories=15&amp;fallbackType=category"></script>
				</div>
				 -->
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
				
				<div id="ask_ad">
					<script type="text/javascript"><!--
						google_ad_client = "ca-pub-4702516645654390";
						/* Logged in - Ask Question - left column */
						google_ad_slot = "2992367461";
						google_ad_width = 250;
						google_ad_height = 250;
						//-->
					</script>
					<script type="text/javascript"
						src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

				</div>
				
			</div><!-- end div#left -->
		<div id="content" class="wide">
			<g:form id="questionform" name="questionform" method="post" action="add">
				<div id="content-header">
						<label for="question">Ask your question - earn 10 points: 10 Questions earns 10 bonus points</label>
						<span class="text-counter"><input name="textcounter1" id="textcounter1" class="textcounter" readonly="readonly" value="500"></readonly> characters</span>
						<textarea id="question" name="title" type="text" maxlength="500" onKeyDown="textCounter(document.questionform.question,document.questionform.textcounter1,500)" onKeyUp="(document.questionform.question,document.questionform.textcounter1,500)">${postInstance?.title}</textarea>
				</div><!-- end div#content-header -->
				<div id="page">
					<g:if test="${flash.message}">
						<p class="output error">
							<g:message code="${flash.message}"></g:message>
						</p>
					</g:if>
					<g:if test="${postInstance?.hasErrors()}">
						<div class="output" id="error">
							<g:renderErrors bean="${postInstance}"/>
						</div>
					</g:if>
                    <g:if test="${user?.hasErrors()}">
                        <div class="output" id="error">
                            <g:renderErrors bean="${user}"/>
                        </div>
                    </g:if>
                    <div class="section-footer">
						<h2 style="color:#9AB1C9;margin-top:10px;">Anything Else?</h2>
						<a class="expand" href="#" >
							<p style="font-size:9px;">Click here to enter more info, context, background?</p>
						</a>
						<div class="collapse">
							<span class="text-counter"><input name="textcounter2" id="textcounter2" class="textcounter" readonly="readonly" value="500"></readonly> characters</span>
							<textarea id="moreinfo" name="description" type="text" maxlength="500" onKeyDown="textCounter(document.questionform.moreinfo,document.questionform.textcounter2,500)" onKeyUp="(document.questionform.moreinfo,document.questionform.textcounter2,500)">${postInstance?.description}</textarea>
						</div>
						<br>
					</div><!-- end div.section -->
					<div id="tagQuestion" class="section">
						<h2 style="color:#9AB1C9;margin-top:10px;">Tag Your Question</h2>
						Search for an existing tag or create a new one
									<gui:autoComplete
								        id="tagAutoInput"
								        style="autoInput1"
								        controller="tag"
								        action="tagAutocomplete"
								        minQueryLength="1"
								        queryDelay="0.1"
								        value="${tag}"
								    />
					</div><!-- end div.section -->
					<div class="section">
						<h2>Who is the question for?</h2>
		                <g:select name="member.id" from="${request.user.connectionList()}" optionKey="id" value="${postInstance?.member?.id}" noSelection="['null': 'Community']" />
					</div><!-- end div.section -->
                    <g:render template="/user/postRegistrationWidget" model="['params':params]"/>
				</div><!-- end div#page -->
				<div id="content-footer">
					<a href="javascript:submitform('questionform')" class="right button">Ask Question</a>
				</div><!-- end div#content-footer -->
			</g:form>
		</div><!-- end div#content -->
		</div><!-- end div#container -->
		<script type="text/javascript">
			jQuery(function() {
				jQuery("a.expand").toggler({method: "slideFadeToggle"});
				jQuery("#content").expandAll({trigger: "a.expand", ref: "div.conversation", showMethod: "slideDown", hideMethod: "slideUp", speed: 300, oneSwitch: false});
			});
		</script>
					
    </body>
</html>