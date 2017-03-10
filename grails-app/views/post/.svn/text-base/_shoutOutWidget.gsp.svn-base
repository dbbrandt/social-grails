<%@ page import="com.esm.dialog.Post %>
<g:if test="${request?.user}">
	<div class="community-shout-out section">
		<h3>Community Shout-Out</h3>
		<g:formRemote 
			name="shoutoutform" 
			url="[controller:'post',action:'addShoutOut']" 
			update="shoutOutWidget">
			<input type="text"  name="title" onfocus="this.select();" size="140" value="Tell the community in 140 characters" title="Tell the community in 140 characters" class="entry-field auto-clear">
			<input type="submit" class="submitShoutout" value="" alt="Submit Shout-Out" />    
		</g:formRemote>
	</div><!-- end div.community-shout-out.section -->
	<div class="community-news section">
		<h3>Community News</h3>
		<ul>
			<g:set var="postInstance" value="${new com.esm.dialog.Post() }"/>
			<g:each in="${postInstance.shoutOuts(5)}" var="post">
				<li><a href="${createLink(controller:'memberProfile', action:'view')}?userId=${post.author.id}">${post.author}</a>:&nbsp;${post.title}</li>
			</g:each>
		</ul>
		<a href="${createLink(controller:'post', action:'postDirectory')}" class="iframe">See more Community News</a>
	</div><!-- end div.community-news.section -->
</g:if>
