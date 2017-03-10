<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
</head>
<body>
<div id="popup">
	<div class="menu">
		<g:if test="${userInstance}">
			<h1>Community News from ${userInstance?.firstName}</h1>
		</g:if>
		<g:else>
			<h1>Community News</h1>
			<g:if test="${request?.user}">
				<g:form name="shoutoutform" controller="post" action="addShoutOut">
				    <input type="hidden" name="popup" value="true"/>
				    <input style="margin-right:110px;" type="text"  name="title" onfocus="this.select();" size="140" value="Tell the community in 140 characters" title="Tell the community in 140 characters" class="entry-field auto-clear">
					<input style="margin-right:110px;" type="submit" class="submitShoutout" value="" alt="Submit Shout-Out" />    
				</g:form>
			</g:if>
		</g:else>
	</div><!-- end div#menu -->
	<div id="content">
		<table>
            <g:each in="${postInstanceList}" status="i" var="postInstance">
				<tr><td><g:formatDate format="hh:mm M/d/yyyy" date="${postInstance.dateCreated}" /></td><td><a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author?.id}" alt="${postInstance?.author}" target="_top">${postInstance?.author}</a>&nbsp; ${postInstance?.title}</td></tr>
			</g:each>
		</table>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>
