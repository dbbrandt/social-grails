<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="static">
			<div id="left">
				<div class="box">
					<g:render template="/memberProfile/personalStatsWidget" model="['homepage':false]"/>
				</div><!-- end div.box -->
				
				<div id="edit_profile_ad">
					<script type="text/javascript"><!--
						google_ad_client = "ca-pub-4702516645654390";
						/* Edit own profile */
						google_ad_slot = "0149796406";
						google_ad_width = 250;
						google_ad_height = 250;
						//-->
					</script>
					<script type="text/javascript"
						src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
					</script>

				</div>
				
			</div><!-- end div#left -->
			<div id="content" class="wide">
			<div id="content-header">
				<h1>Edit profile</h1>
				<ul class="menu">
					<li><a class="current"  href="${createLink(action:'editProfileInfo',id:request?.id)}">Your Information</a></li>
					<li><a href="${createLink(action:'editProfileInterests',id:request?.id)}">Interests</a></li>
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
				<g:form name="informationform" method="post" action="editProfileInfo">
					<g:hiddenField name="version" value="${userInstance?.version}" />
						<table class="four columns">
							<col id="section-titles"></col><col id="input-titles"></col><col id="inputs"></col><col id="notes-instructions"></col>
							<tr class="section">
	
								<tr><td><h2>Account Information</h2></td><td>Email Address</td><td><g:textField name="email" value="${userInstance?.email}"/></td><td></td></tr>
								<tr><td></td><td>Enter new password</td><td><g:passwordField name="password" value="${params?.password}"/></td><td></td></tr>
								<tr><td></td><td>Re-enter new password</td><td><g:passwordField name="confirm" value="${params?.confirm}"/></td><td></td></tr>
							</tr>
	
							<g:set var="address" value="${userInstance?.address}"/>
							<tr class="section">
								<tr><td><h2>General information</h2></td><td>First Name</td><td><g:textField name="firstName" value="${userInstance?.firstName}"/></td><td></td></tr>
								<tr><td></td><td>Last Name</td><td><g:textField name="lastName" value="${userInstance?.lastName}"/></td><td></td></tr>
								<tr><td></td><td>Current School</td>
									<td>										
									<gui:autoComplete
								        id="currentSchoolAuto"
								        idField="id"
								        style="autoInput1"
								        controller="memberProfile"
								        action="schoolAutocomplete"
								        minQueryLength="3"
								        queryDelay="0.5"
								        value="${memberProfileInstance?.currentSchool}"
									/>
									</td>
									<td></td>
								</tr>
								<tr><td></td><td>Date of Birth</td><td><g:datePicker name="birthdate" value="${userInstance?.birthdate}" precision="day" years="${2010..1930}"/></td><td></td></tr>
								<tr><td></td><td>Street</td><td><g:textField name="address.street" value="${address?.street}"/></td><td></td></tr>
								<tr><td></td><td>City</td><td><g:textField name="address.city" value="${address?.city}"/></td><td></td></tr>
								<tr><td></td><td>State</td><td><g:select class="state" name="state" from="${com.esm.esmzone.StateProvince.list()}" optionKey="abbreviation" value="${address?.state}"  noSelection="[null:' ']"/></td><td></td></tr>
								<tr><td></td><td>Zip Code</td><td><g:textField name="address.postalCode" value="${address?.postalCode}"/></td><td></td></tr>
								<tr><td></td><td>Grade</td>
									<td><g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${memberProfileInstance?.grade}" noSelection="['': '']" />
									</td>
									<td></td>
								</tr>
							</tr>
						</table><!-- end table.four columns -->
					</div><!-- end div#page -->
					<div id="content-footer">
						<a href="javascript:submitform('informationform')" class="right button">Save</a>
					</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>