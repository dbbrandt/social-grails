<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>Connection Alerts</h1>
		<span class="counter">${networkConnectionInstanceList.size()}</span>
	</div><!-- end div#menu -->
	<div id="content">
		<table>
		    <g:each in="${networkConnectionInstanceList}" status="i" var="connection">
				<tr>
					<td><g:formatDate format="hh:mm M/d/yyyy" date="${connection.dateCreated}" /></td>
					<td><a href="${createLink(controller:'memberProfile', action:'view')}?userId=${connection?.user?.id}" alt="${connection?.user}" target="_top">${connection?.user}</a>&nbsp; (${connection.type} request) ${connection.message}
					   	<g:link controller="networkConnection" action='acceptConnection' id="${connection?.id}">Accept</g:link>&nbsp;|
                       	<g:link controller="networkConnection" action='declineConnection' id="${connection?.id}">Decline</g:link>
					</td>
				</tr>
			</g:each>
		</table>
	</div><!-- end div#content -->
</div><!-- end div#popup --></body>
</html>
