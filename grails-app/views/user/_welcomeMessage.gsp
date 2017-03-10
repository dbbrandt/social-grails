<div id="welcomeBox">
	<g:if test="${request?.user?.isMember()}">
		<div id="avatar">
            <img width="64px" height="64px" src="${request.avatar}"/>
		</div>
		<div id="welcomeText">
        ${request?.user?.firstName} ${request?.user?.lastName}<br>
		Score ${request?.user?.score} Rating: ${request?.user?.averageRating}<br>
		</div>
	</g:if>
	<g:else>
		<span id="userWelcome">${request?.user?.firstName}!</span><br><br>
		Get all the great features of ESMZone enabled and start participating.&nbsp;&nbsp;<g:link controller="user" action="subscribe"><span style="color:#CC3333;">Subscribe Now!</span></g:link>
	</g:else>
</div>
