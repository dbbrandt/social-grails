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
						<li><a class="current"  href="${createLink(action:'editProfileAvatar',id:request?.id)}">Edit Avatar</a></li>
	
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
						<g:if test="${memberProfileInstance?.hasErrors()}">
							<g:renderErrors bean="${profile}"/>
						</g:if>
					</div>
					<div class="section">
						<div class="section-titles">
							<a name="avatar"><h2>Build your Avatar</h2></a>
						</div>
						<g:set var="nobleAvatar" value="${(userInstance.gender == 'Male')?'2537256960459':'2537256961561'}"/>
						<div class="main-content">
							<applet code="com.nobleavatar.client.AppClient" 
							        codebase="${request.contextPath}"
							        archive="jgoodies-forms-1.0.4.jar,avatar.jar"
							        width="560" height="420">
							  <param name="id" value="${userInstance?.id}">
							  <param name="avatar" value="${(avatarInstance?.nobleAvatar)?avatarInstance?.nobleAvatar:nobleAvatar}">
							  <param name="path" value="${avatarUrl}">
							</applet>
						</div>    
					</div>
					<div class="section">
						<div class="section-titles">
							<a name="avatar"><h2>Upload your Avatar</h2></a>
						</div>
						<div class="main-content">
							<g:form name="informationform" action="editProfileAvatar" method="post" enctype="multipart/form-data" >
								<g:hiddenField name="id" value="${userInstance?.id}" />
								<g:hiddenField name="nobleAvatar" value="${nobleAvatar}" />
								<input type="file" name="avatarFile"/>
							</g:form>
						</div>
					</div>
				</div><!-- end div#page -->
				<div id="content-footer">
					<a href="javascript:submitform('informationform')" class="right button">Save</a>
				</div><!-- end div#content-footer -->
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>