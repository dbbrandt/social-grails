<%@ page import="com.esm.dialog.Post" %>
<div class="community-news section">
	<h3>Community News from ${userInstance?.firstName}</h3>
	<ul>
		<g:set var="postInstance" value="${new Post()}"/>
		<g:each in="${postInstance.shoutOuts(5, userInstance.id)}" var="post">
			<li>${post.title}</li>
		</g:each>
	</ul>
	<a href="${createLink(controller:'post', action:'postDirectory', id:userInstance.id)}" class="iframe">See more Community News from ${userInstance?.firstName}</a>
</div><!-- end div.community-news.section -->