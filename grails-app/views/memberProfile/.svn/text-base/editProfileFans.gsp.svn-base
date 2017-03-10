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
					<li><a href="${createLink(action:'editProfileInterests',id:request?.id)}">Interests</a></li>
					<li><a href="${createLink(action:'editProfileAvatar',id:request?.id)}">Edit Avatar</a></li>

					<li><a class="current" href="${createLink(action:'editProfileFans',id:request?.id)}">Fans and Mentors</a></li>
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
				<div id="page">
					<div class="section">

						<div class="section-titles">
							<h2>Edit Fans and Mentors</h2>
						</div>
						<div class="main-content">
							<table class="sortable">
								<col id="col-avatar"></col><col id="col-name"></col><col id="col-gender"></col><col id="col-grade"></col><col id="col-town-school"></col><col id="col-action"></col>
								<thead>
									<tr><th class="sorttable_nosort"></th>
									<th>Name</th>
									<th class="sorttable_nosort">Gender</th>
									<th>Grade</th>
									<th>Current School</th>
									<th class="sorttable_nosort">Action</th>

								</thead>
								<tbody>
									<g:each in="${userInstanceList}" var="user">
									<tr>
										<td><a href="${createLink(controller:'memberProfile', action:'view')}?userId=${user?.id}" target="_top" ><img src="${user?.avatarFile()}" class="avatar"/></a></td>
										<g:set var="starFile" value="stars-${request?.user?.starRating()}.png"/>
										<td><h2>${user}</h2><span>${request?.user?.getRelationship(user)}</span><img alt="${request?.user?.averageRating} stars" src="${resource(dir:'images/stars',file:starFile)}" /></td>
										<td>${user.gender}</td>
										<td>${user?.memberProfile?.gradeLevel()}</td>
										<td>${user?.memberProfile?.currentSchool}</td>
										<td><a href="${createLink(controller:'networkConnection', action:'removeAConnection', id:user?.id)}" class="iframe delete button">Delete</a></td>
									</tr>
									</g:each>
								</tbody>
							</table>
						</div>
						<div class="clearer"></div>
					</div><!-- end div.section -->
				</div><!-- end div#page -->
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>