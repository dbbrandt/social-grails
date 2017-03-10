<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>My Fans</h1>
		<span class="counter">${userInstanceList.size()}</span>
	</div><!-- end div#menu -->
	<div id="content" style="height:298px;">
		<table class="sortable">
			<thead>
				<tr><th class="sorttable_nosort"></th>
				<th class="sorttable_nosort"></th>
				<th>Name</th>
				<th class="sorttable_nosort">Gender</th>
				<th>Grade</th>
				<th>City/School</th>
			</thead>
			<tbody>
				<g:each in="${userInstanceList}" var="user">
				<tr>
					<td><a href="${createLink(controller:'post', action:'addMessage', id:user?.id)}" class="iframe"><img src="${resource(dir:'images',file:'message-button.gif')}" alt="Send ${user} a message" /></a></td>
					<td><a href="${createLink(controller:'memberProfile', action:'view')}?userId=${user?.id}" target="_top" ><img src="${user?.avatarFile()}" class="avatar"/></a></td>
					<g:set var="starFile" value="stars-${request?.user?.starRating()}.png"/>
					<td><h2>${user}</h2><span>${request?.user?.getRelationship(user)}</span><img alt="${request?.user?.averageRating} stars" src="${resource(dir:'images/stars',file:starFile)}" /></td>
					<td>${user.gender}</td>
					<td>${user?.memberProfile?.gradeLevel()}</td>
					<g:set var="address" value="${user.address}"/>
					<td>${address?.city} ${address?.state}<br/>${user?.memberProfile?.currentSchool}</td>
				</tr>
				</g:each>
			</tbody>
		</table>
	</div><!-- end div#content -->
</div><!-- end div#popup --></html>
