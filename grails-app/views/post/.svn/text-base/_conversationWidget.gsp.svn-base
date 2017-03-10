<div class="question section">
	<div class="like">
	    <g:if test="${postInstance?.ratings?.size() > 0}">
			<img src="${resource(dir:'images',file:'like.gif')}" alt="Like this question?" />
			<span>${postInstance?.ratings?.size()} people like this question</span>
		</g:if>
		<g:else>
			<span>Like this question?</span>
		</g:else>
	</div>
	
	<g:if test="${request.user}">
		<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author.id}" />
			<img id="questionAvatar_${postInstance?.id}" title="${postInstance?.author}" alt="${postInstance?.author}" src="${postInstance?.author?.avatarFile()}" class="avatar">
		</a>
		<h2><a href="${createLink(controller:'post', action:'view', id:postInstance?.id)}">${postInstance}</a></h2>
		<span class="author">${postInstance?.author} 
		<g:if test="${postInstance?.member}">
			to ${postInstance?.member}
		</g:if>
		    on <g:formatDate format="M/d/yyyy" date="${postInstance.dateCreated}"/>
		</span>
	</g:if>
	<g:else>
		<img id="questionAvatar_${postInstance?.id}" src="${postInstance?.author?.avatarFile()}" class="avatar">
		<h2><a href="${createLink(controller:'user', action:'joinToday')}" title="Register to see more" class="iframe">${postInstance}</a></h2>
	</g:else>
</div><!-- end div.question -->
<g:if test="${answerInstance}">
	<g:if test="${request.user}">
		<div class="answer section">
			<div class="like">
			    <g:if test="${answerInstance?.ratings?.size() > 0}">
					<img src="${resource(dir:'images',file:'like.gif')}" alt="Like this question?" />
					<span>${answerInstance?.ratings?.size()} people like this answer</span>
				</g:if>
				<g:else>
					<span>Like this answer?</span>
				</g:else>
			</div>
			<div>
				<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${answerInstance?.author.id}"/>
					<img id="answerAvatar_${answerInstance?.id}" title="${answerInstance?.author}" alt="${answerInstance?.author}" src="${answerInstance?.author?.avatarFile()}" class="avatar">
				</a>
			</div>
			<p>${answerInstance}</p>
			<span class="author">${answerInstance?.author} on <g:formatDate format="M/d/yyyy" date="${answerInstance.dateCreated}"/></span>
		</div><!-- end div.answer -->
	</g:if>
</g:if>
<div class="footer">
		<g:if test="${request.user}">
			<span class="tags">Tags<img alt="arrow" class="arrow" src="${resource(dir:'images', file:'arrow-white.png')}" />
				<g:each in="${postInstance.displayTags()}" var="tag">
					<a href="${createLink(controller:'post', action:'tagDirectory', id:tag?.id)}" alt="See more questions tagged ${tag}">${tag}</a>
				</g:each> 
			</span>
			<img alt="${postInstance.averageRating} stars" class="stars" src="${resource(dir:'images/stars/', file:'stars-'+postInstance.starRating()+'.png')}" />
			<g:link controller="post" action="view" id="${postInstance.id}" alt="See all responses"><span class="responses">Responses<img alt="arrow" class="arrow" src="${resource(dir:'images', file:'arrow-white.png')}" />${postInstance?.countAnswers()}</g:link></span>
			<g:link controller="post" action="view" id="${postInstance.id}" alt="Answer this question" class="right button">Answer</g:link>
		</g:if>
		<g:else>
			<span class="tags">Tags<img alt="arrow" class="arrow" src="${resource(dir:'images', file:'arrow-white.png')}" />
				<g:each in="${postInstance.displayTags()}" var="tag">
					<a href="${createLink(controller:'user', action:'joinToday')}" title="Register to see more" class="iframe">${tag}</a>
				</g:each> 
			</span>
			<img alt="${postInstance.averageRating} stars" class="stars" src="${resource(dir:'images/stars/', file:'stars-'+postInstance.starRating()+'.png')}" />
			<g:link controller="user" action="joinToday" title="Register to see more" class="iframe"><span class="responses">Responses<img alt="arrow" class="arrow" src="${resource(dir:'images', file:'arrow-white.png')}" />${postInstance?.countAnswers()}</g:link></span>
			<g:link controller="user" action="joinToday" title="Register to see more" class="right button iframe">Answer</g:link>
		</g:else>
</div><!-- end .footer -->
