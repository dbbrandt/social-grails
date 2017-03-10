<%@ page import="com.esm.esmzone.User" %>
<g:if test="${request.user}">
	<div class="standings section">
		<h3>Division ${userInstance?.division} Standing</h3>
		<ul>
			<g:each in="${userInstance.standings(5)}" status="i" var="user">
				<g:set var="highlighted" value="${(user.id==userInstance?.id)?'user':''}"/>
				<g:set var="ranking" value="${(user.id==userInstance?.id)?userInstance.rank():i+1}"/>
				<li class="${highlighted}">${ranking}. <a class="${highlighted}" href="${createLink(controller:'memberProfile', action:'view')}?userId=${user?.id}" alt="Go to ${user}'s profile">${user}</a><span>${user?.score}</span></li>
			</g:each>
		</ul>
		<a href="${createLink(controller:'user', action:'standings')}" alt="See complete standings">See complete standings</a>
	</div>
</g:if>
	