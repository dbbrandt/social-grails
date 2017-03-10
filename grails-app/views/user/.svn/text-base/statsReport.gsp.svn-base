<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
</head>
<body>
<div id="popup" class="stats">
	<div class="menu">
		<h1>Stats</h1>
		<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${userInstance?.id}" class="back-link" target="_top">Visit Profile</a>
	</div><!-- end div.menu -->

	<div id="content">
		<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${userInstance?.id}" target="_top"><img src="${userInstance?.avatarFile()}" alt="${userInstance}" class="avatar"/></a>
		<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${userInstance?.id}" target="_top"><h1>${userInstance}</h1></a>
		<g:if test="${userInstance.isMentor}">
			<span>Mentor</span>
		</g:if>
		<table>
			<thead>
				<th colspan="2">Info</th>
				<th colspan="2">Stats</th>
			</thead>
			<tr>
				<td>Gender</td>
				<td>${userInstance.gender}</td><td>Medals</td>
				<td>
					<ul class="medals-list">
					<g:set var="medals" value="${userInstance?.medals()}"/>
					<g:each in="${medals}" var="medal">			
						<li>
							<img id="medal_${medal.value}" title="${medal.name}" alt="${medal.name}"  src="${resource(dir:'images',file:'medal'+medal.value+'.png')}">
						</li>
					</g:each>
					</ul>
				</td>
			</tr>
			<tr>
				<td>Grade</td>
				<td>${userInstance.memberProfile?.gradeLevel()}</td>
				<g:if test="${userInstance.isMentor}">
					<td>Mentor Rating</td>
					<td>${userInstance?.averageRating} <img alt="${userInstance?.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-black-'+userInstance?.starRating()+'.png')}" /></td>
				</g:if>
				<g:else>
					<td></td>
					<td></td>
				</g:else>
			</tr>
			<tr>
				<td>City/Town</td>
				<td>${userInstance?.address?.city}</td>
				<td>Questions Asked</td>
				<td>${userInstance.questionCount}</td>
			</tr>
			<tr>
				<td>School</td>
				<td>${userInstance.memberProfile?.currentSchool}</td>
				<td>Questions Answered</td>
				<td>${userInstance.answerCount}</td>
			</tr>
			<tr>
				<td>Sports Played</td>
				<td>${userInstance.memberProfile?.playedSports}</td>
				<td>Score</td>
				<td>${userInstance.score}</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>Division ${userInstance.division} Rank</td>
				<td>${userInstance.rank()}</td></tr>
		</table>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>
