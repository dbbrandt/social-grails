<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
	<div id="container" class="qa">
		<div id="left">
			<div class="box">
				<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
				<div class="section" style="border-top:0px;">
					<h3>Search</h3>
					<g:form name="searchform" id="searchform" method="get" action="search">
				        <input type="text" name="q" class="entry-field auto-clear" value="Find Questions and Answers" onfocus="placeholder(this);" size="62"/> 
						<a href="javascript:submitform('searchform')" title="Find Questions and Answers"></a>
					</g:form>
				</div><!-- end div.section -->
				<div class="section">
					<h3>Explore By Topic</h3>
					<ul>
						<g:each in="${postInstance.displayTags(100)}" var="tag">
							<li><a href="${createLink(controller:'post', action:'tagDirectory', id:tag?.id)}" alt="See more questions tagged ${tag}">${tag}</a></li>						
						</g:each> 
					</ul>
				</div><!-- end div.section -->
				<div class="section">
					<h3>Add another tag</h3>
					<g:form name="tagform" method="post" action="addTag">
                        <g:hiddenField name="id" value="${postInstance?.id}" />
						<gui:autoComplete
					        id="addTagAutoInput"
					        style="autoInput1"
					        controller="tag"
					        action="tagAutocomplete"
					        minQueryLength="1"
					        queryDelay="0.1"
					        value="${tag}"
					    />
						<a href="javascript:submitform('tagform')" title="Tag a Question"></a>
					</g:form>
				</div><!-- end div.section -->
				<g:if test="${postInstanceList?.size() > 0}">
					<div class="section">
						<h3>Related Questions</h3>
						<ul>
							<g:each in="${postInstanceList}" var="postInstance">
								<li><a href="${createLink(controller:'post', action:'view', id:postInstance?.id)}">${postInstance}</a></li>
							</g:each>
						</ul>
					</div>
				</g:if>
			</div> <!-- end div.box -->
			<div class="facebook">
				<a href="http://www.facebook.com/sharer.php?u=www.esmzone.com/esmzone&t=ESMZONE - Where Student Athletes Train to Lead" class="share-link button nofold" target="_blank"></a>
			</div>
			
			<div class="addtoany">
						<a class="a2a_dd" href="http://www.addtoany.com/share_save"><img src="${resource(dir:'images', file:'addtoany_button.png')}" width="161" height="16" border="0" alt="Share"/></a>
						<script type="text/javascript">
							var a2a_config = a2a_config || {};
							a2a_config.linkname = "ESMZone";
						</script>
<script type="text/javascript" src="http://static.addtoany.com/menu/page.js"></script>
					</div><!-- end div.addtoany -->
			
			<div id="answer_ad">
				<script type="text/javascript"><!--
					google_ad_client = "ca-pub-4702516645654390";
					/* Logged in Answer Question left column */
					google_ad_slot = "4457954539";
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
			<div id="content-header">
				<span style="display:block;height:14px;padding:10px 0 10px 0;">
					<span class="rating">Overall rating <img alt="${postInstance?.overallRating} stars" class="stars" src="${resource(dir:'images/stars',file:'stars-black-'+postInstance.starRating(postInstance.overallRating)+'.png')}" /> (from ${postInstance?.ratingCount} users)</span>
					<span class="right">Asked on <g:formatDate format="M/d/yyyy" date="${postInstance.dateCreated}" />&nbsp;&nbsp;|&nbsp;&nbsp;${postInstance?.answers?.size()} Responses&nbsp;&nbsp;|&nbsp;&nbsp;${postInstance?.comments?.size() } Comments</a></span>
				</span>
			</div><!-- end div#content-header -->
			<div class="conversation">
				<div class="question section">
					<g:if test="${flash.message}">
						<p id="error" class="output">
							<g:message code="${flash.message}"></g:message>
						</p>
					</g:if>
					<div id="postRatingSelector${postInstance?.id}">
			        	<g:render template="/post/ratingWidget" model="['ratingInstance':postInstance]"></g:render>
					</div><!-- end div.like -->
					<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author.id}" />
						<img id="questionAvatar_${postInstance?.id}" title="${postInstance?.author}" alt="${postInstance?.author}" src="${postInstance?.author?.avatarFile()}" class="avatar">
					</a>

					<h2>${postInstance?.title}</h2>
					<p>${postInstance?.description}</p>
					<span class="author">${postInstance?.author}</span>
					<div class="section-footer">
                    	<g:render template="/complaint/flag" model="['contentInstance':postInstance, 'type':'Post']"/>
						<span class="rating">Question rating <img alt="${postInstance?.averageRating} stars" class="stars" src="${resource(dir:'images/stars',file:'stars-black-'+postInstance?.starRating(postInstance?.averageRating)+'.png')}" /> (${postInstance?.ratingCount})</span>
						<a class="comments-link expand">
							<g:if test="${!postInstance?.comments?.size()}">
								Add a Comment
							</g:if>
							<g:else>
								View ${postInstance?.comments?.size()} Comments
							</g:else>
						</a>
						<div class="comments collapse">
							<g:if test="${postInstance?.comments?.size()> 0}">
								<h3>Comments (${postInstance?.comments?.size()})</h3>
		                        <g:each in="${postInstance.comments}" var="c">
		                        	<g:if test= "${!c?.complaint}">
										<div class="comment section">
											<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author.id}" />
												<img id="commentAvatar_${c?.id}" title="${c?.author}" alt="${c?.author}" src="${c?.author?.avatarFile()}" class="avatar">
											</a>
			    	                        <p>${c}</p>
											<span class="author">${c?.author} on <g:formatDate format="M/d/yyyy" date="${c.dateCreated}" /></span>
			  			                    <g:render template="/complaint/flag" model="['contentInstance':c, 'type':'PostComment']"></g:render>
										</div><!-- end div.comment -->
		                            </g:if>
		                        </g:each>
							</g:if>
							<div class="comment section comment-form-wrapper">
								<g:form name="postCommentForm" controller="post" action="view" method="post">
	                                <g:hiddenField name="id" value="${postInstance?.id}" />
				 	                <g:hiddenField name="target" value="postComment" />
									<textarea id="postCommentText" name="postComment.description" onfocus="this.select()" maxlength="500" onKeyDown="textCounter(document.postCommentForm.postCommentText,document.postCommentForm.textcounter,500)" onKeyUp="(document.postCommentForm.postCommentText,document.postCommentForm.textcounter,500)">Type Comment</textarea>
									<div class="footer">
										<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500"></readonly> characters</span>
										<a href="javascript:submitform('postCommentForm')" class="right button">Submit</a>
									</div>
								</g:form>
							</div>
						</div><!-- end div.comments -->
					</div>
				</div><!-- end div.question -->
                <g:each in="${postInstance.answers}" var="answerInstance">
    	           	<g:if test= "${!answerInstance?.complaint}">
					<div class="answer section">
		        		<g:render template="/answer/bestAnswerWidget" model="['answerInstance':answerInstance]"/>
				        <div id="answerRatingSelector${answerInstance.id}" class="like">
				        	<g:render template="/answer/ratingWidget" model="['ratingInstance':answerInstance]"/>
						</div><!-- end div.like -->
						<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${answerInstance?.author.id}" />
							<img id="answerAvatar_${answerInstance?.id}" title="${answerInstance?.author}" alt="${answerInstance?.author}" src="${answerInstance?.author?.avatarFile()}" class="avatar">
						</a>
	
						<p>${answerInstance.description}</p>
						<span class="author">${answerInstance?.author} on <g:formatDate format="M/d/yyyy" date="${answerInstance.dateCreated}"/></span>
						<div class="section-footer">
		                    <g:render template="/complaint/flag" model="['contentInstance':answerInstance, 'type':'Answer']"></g:render>
							<span class="rating">Answer rating <img alt="${answerInstance?.averageRating} stars" class="stars" src="${resource(dir:'images/stars',file:'stars-black-'+answerInstance?.starRating(answerInstance?.averageRating)+'.png')}" /> (${answerInstance?.ratingCount})</span>
							<a class="comments-link expand">
							<g:if test="${!answerInstance?.comments?.size()}">
								Add a Comment
							</g:if>
							<g:else>
								View ${answerInstance?.comments?.size()} Comments
							</g:else>
							</a>
						<div class="comments collapse">
							<g:if test="${answerInstance?.comments?.size()> 0}">
								<h3>Comments (${answerInstance?.comments?.size()})</h3>
		                        <g:each in="${answerInstance.comments}" var="c">
		                        	<g:if test= "${!c?.complaint}">
										<div class="comment section">
			  			                    <g:render template="/complaint/flag" model="['contentInstance':c, 'type':'AnswerComment']"></g:render>
											<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author.id}" />
												<img id="commentAvatar_${c?.id}" title="${c?.author}" alt="${c?.author}" src="${c?.author?.avatarFile()}" class="avatar">
											</a>
			    	                        <p>${c}</p>
											<span class="author">${c?.author} on <g:formatDate format="M/d/yyyy" date="${c.dateCreated}" /></span>
										</div><!-- end div.comment -->
		                            </g:if>
		                        </g:each>
							</g:if>
							<div class="comment section comment-form-wrapper">
								<g:form name="answerCommentForm${answerInstance?.id}" controller="post" action="view" method="post">
	       							<g:hiddenField name="id" value="${postInstance?.id}" />
	                                <g:hiddenField name="answer.id" value="${answerInstance?.id}" />
				 	                <g:hiddenField name="target" value="answerComment" />
									<textarea id="answerCommentText" name="answerComment.description" onfocus="this.select()" maxlength="500" onKeyDown="textCounter(document.answerCommentForm${answerInstance?.id}.answerCommentText,document.answerCommentForm${a?.id}.textcounter,500)" onKeyUp="(document.answerCommentForm${answerInstance?.id}.answerCommentText,document.answerCommentForm${answerInstance?.id}.textcounter,500)">Type Comment</textarea>
									<div class="footer">
										<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500"></readonly> characters</span>
										<a href="javascript:submitform('answerCommentForm${answerInstance?.id}')" class="right button">Submit</a>
									</div>
								</g:form>
							</div>
						</div><!-- end div.comments -->
						</div><!-- end div.section-footer -->
					</div><!-- end div.answer -->
					</g:if>
				</g:each>
				<g:form name="answerform" controller="post" action="view" method="post">
					<div class="form section">
				            <g:hiddenField name="id" value="${postInstance?.id}" />
		    	            <g:hiddenField name="target" value="answer" />
							<label for="answer">Type Your Answer - earn 10 points: 10 Answers earns 10 bonus points </label>
							<textarea name="answer.description" id="answer" maxlength="2000" onKeyDown="textCounter(document.answerform.answer,document.answerform.textcounter,2000)" onKeyUp="(document.answerform.answer,document.answerform.textcounter,2000)"></textarea>
					</div><!-- end .footer -->
					<div id="content-footer">
						<span class="rating">Overall rating <img alt="${postInstance?.overallRating} stars" class="stars" src="${resource(dir:'images/stars',file:'stars-'+postInstance?.starRating(postInstance?.overallRating)+'.png')}" /></span>
						<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="2000"></readonly> characters</span>
						<a href="javascript:submitform('answerform')" class="right button">Submit</a>
					</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div.conversation -->
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