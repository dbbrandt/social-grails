<%=contentPage?.fetchContent()%>
<g:if test="${!request?.user}">
   	<div id="register-button">
		<p><a href="${createLink(controller:'user', action:'joinToday')}" class="iframe">Join ESMZone Today</a> &gt;&gt;</p>
	</div>
</g:if>
	
	