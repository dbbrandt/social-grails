<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="static">
			<div id="left">
				<div class="box">
					<g:if test="${request?.user}">
						<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
					</g:if>
					<g:else>
						<g:render template="/home/introWidget"/>
					</g:else>
				</div><!-- end div.box -->
			</div><!-- end div#left -->
			<div id="content" class="wide">
			<div id="content-header">
				<h1>Edit profile</h1>
				<ul class="menu">
					<li><a href="${createLink(action:'editProfileInfo',id:request?.id)}">Your Information</a></li>
					<li><a class="current"  href="${createLink(action:'editProfileInterests',id:request?.id)}">Interests</a></li>
					<li><a href="${createLink(action:'editProfileAvatar',id:request?.id)}">Edit Avatar</a></li>

					<li><a href="${createLink(action:'editProfileFans',id:request?.id)}">Fans and Mentors</a></li>
					<li><a href="#">Billing Information</a></li>
				</ul>
			</div><!-- end div#content-header -->
			<div id="page">
				<p class="output">
					<g:if test="${flash.message}">
						<g:message code="${flash.message}"></g:message>
					</g:if>
				</p>
				<div class="output" id="error">
					<g:if test="${userInstance?.hasErrors()}">
						<g:renderErrors bean="${user}"/>
					</g:if>
				</div>
				<div class="output" id="error">
					<g:if test="${memberProfileInstance?.hasErrors()}">
						<g:renderErrors bean="${profile}"/>
					</g:if>
				</div>
				<div class="output" id="error">
					<g:if test="${address?.hasErrors()}">
						<g:renderErrors bean="${address}"/>
					</g:if>
				</div>										
            	<g:form action="editProfileInterests" name="informationform" method="post" >
	                <g:hiddenField name="id" value="${memberProfileInstance?.id}" />
	                <g:hiddenField name="version" value="${memberProfileInstance?.version}" />
					<table>
						<col id="section-titles"></col><col id="input-titles"></col><col id="inputs"></col><col id="notes-instructions"></col>
						<tr class="section">

							<tr>
								<td><h2>Personal Interests</h2></td>
								<td>Favorite Activities</td>
								<td><g:textField name="favoriteActivities" value="${memberProfileInstance?.favoriteActivities}"/></td>
								<td>Your favorite things to do in your free time.</td>
							</tr>
							<tr>
								<td></td>
								<td>Favorite Movies</td>
								<td><g:textField name="favoriteMovie" value="${memberProfileInstance?.favoriteMovie}"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Role Model</td>
								<td><g:textField name="roleModel" value="${memberProfileInstance?.roleModel}"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Career Interests</td>
								<td><g:textField name="careerInterests" value="${memberProfileInstance?.careerInterests}"/></td>
								<td></td>
							</tr>
						</tr>
						<tr class="section">
							<tr>
								<td><h2>Athletic Interests</h2></td>
								<td>Favorite Pro Player</td>
								<td><g:textField name="favoriteProPlayer" value="${memberProfileInstance?.favoriteProPlayer}"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Favorite Pro Team</td>
								<td><g:textField name="favoriteProTeam" value="${memberProfileInstance?.favoriteProTeam}"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Favorite Sports</td>
								<td><g:select name="favoriteSports1" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${memberProfileInstance?.getFavoriteSport(1)?.id}" noSelection="[null:' ']"/></td>
								<td>You can select up to 2 sports</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="favoriteSports2" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${memberProfileInstance?.getFavoriteSport(2)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Sports Played</td>
								<td><g:select name="playedSports1" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${memberProfileInstance?.getPlayedSport(1)?.id}"/></td>
								<td>You can select up to 3 sports</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="playedSports2" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${memberProfileInstance?.getPlayedSport(2)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="playedSports3" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${memberProfileInstance?.getPlayedSport(3)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
						</tr>
						<tr class="section">
							<tr>
								<td><h2>Academic Interests</h2></td>
								<td>Favorite Subjects</td>
								<td><g:select name="favoriteSubjects1" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getFavoriteSubject(1)?.id}" /></td>
								<td>You can select up to 2 subjects</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="favoriteSubjects2" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getFavoriteSubject(2)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Least Favorite Subjects</td>
								<td><g:select name="leastFavoriteSubjects1" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getLeastFavoriteSubject(1)?.id}"/></td>
								<td>You can select up to 2 subjects</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="leastFavoriteSubjects2" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getLeastFavoriteSubject(2)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td>Strongest Subjects</td>
								<td><g:select name="strongestSubjects1" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getStrongestSubject(1)?.id}" /></td>
								<td>You can select up to 2 subjects</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td><g:select name="strongestSubjects2" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${memberProfileInstance?.getStrongestSubject(2)?.id}" noSelection="[null:' ']"/></td>
								<td></td>
							</tr>
						</tr>
					</table>
				</div><!-- end div#page -->
				<div id="content-footer">
					<a href="javascript:submitform('informationform')" class="right button">Save</a>
				</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>