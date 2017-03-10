<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <g:set var="containerClass" value="${(request?.user)?'homepage':'static'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
			</div><!-- end div#left -->
			<div id="content" class="wide">
				<div id="content-header">
					<h1>Registration</h1>
				</div><!-- end div#content-header -->
				<g:form action="register" name="registerForm">
					<div id="page">
						<table>
							<col id="section-titles"></col>
							<col id="input-titles"></col>
	
							<col id="inputs"></col>
							<col id="notes-instructions"></col>
							<tbody>
								<g:if test="${user?.hasErrors() || flash.message || profile?.hasErrors() || address?.hasErrors()}">
								<tr>
									<td></td>
									<td style="color:red">Errors</td>
									<td style="color:red" colspan="2">
										<g:if test="${user?.hasErrors() || flash.message}">
										<div class="errors">
											<g:renderErrors bean="${user}"></g:renderErrors>
											<g:if test="${flash.message}">
												<g:message code="${flash.message}"></g:message>
											</g:if>
										</div>			
										</g:if>
										<g:if test="${profile?.hasErrors()}">
										<div class="errors">
											<g:renderErrors bean="${profile}"></g:renderErrors>
										</div>			
										</g:if>
										<g:if test="${address?.hasErrors()}">
											<div class="errors">
												<g:renderErrors bean="${address}"></g:renderErrors>
											</div>			
										</g:if>
									</td>
								</tr>
								</g:if>
								<tr>
									<td><h2>Account Information</h2></td>
									<td>Email Address</td>
									<td><g:textField name="email" value="${user?.email}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Choose password</td>
									<td><g:passwordField name="password" value="${params?.password}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Re-enter password</td>
									<td><g:passwordField name="confirm" value="${params?.confirm}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>Security Question</td>
									<td>
										<g:select id="securityQuestion" 
											  name="securityQuestion.id"
											  value="${user?.securityQuestion?.id}"
									          from="${securityQuestionList}" 
									          optionKey="id" 
									          optionValue="name" 
									          noSelection="['':'-Choose security question-']">
										</g:select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Security Answer</td>
									<td><g:textField name="securityAnswer" value="${user?.securityAnswer}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>Gender</td>
									<td>
										<select type="text" name="gender">
											<option>Male</option>
											<option>Female</option> 
										</select>
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Date of Birth</td>
									<td><g:datePicker name="birthdate" value="${user?.birthdate}" precision="day" years="${2010..1930}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td><h2>General information</h2></td>
									<td>First Name</td>
									<td><g:textField name="firstName" value="${user?.firstName}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Last Name</td>
									<td><g:textField name="lastName" value="${user?.lastName}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>Street</td><td><g:textField name="street" value="${address?.street}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>City</td>
									<td><g:textField name="city" value="${address?.city}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>State</td>
									<td><g:textField name="state" value="${address?.state}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Zip</td>
									<td><g:textField name="postalCode" value="${address?.postalCode}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>Current School</td>
									<td>
										<gui:autoComplete
									        id="currentSchoolAuto"
									        idField="id"
									        style="autoInput1"
									        controller="memberProfile"
									        action="schoolAutocomplete"
									        minQueryLength="3"
									        queryDelay="0.5"
									        value="${profile?.currentSchool}"
										/>
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Grade</td>
									<td>
										<g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${profile?.grade}" noSelection="['': '']" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td><h2>Interests</h2></td>
									<td>Sports Played</td>
									<td>
										<g:select class="sports" name="playedSports1" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${profile?.getPlayedSport(1)}" />
									</td>
									<td>Select up to 3 sports</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<g:select class="sports" name="playedSports2" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${profile?.getPlayedSport(2)}" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<g:select class="sports" name="playedSports3" from="${com.esm.esmzone.Sport.list()}" optionKey="id" value="${profile?.getPlayedSport(3)}" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Strongest Subjects</td>
									<td>
										<g:select class="subjects" name="strongestSubjects1" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${profile?.getStrongestSubject(1)}" />
									</td>
									<td>Select up to 2 subjects</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<g:select class="subjects" name="strongestSubjects2" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${profile?.getStrongestSubject(2)}" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Least Favorite Subjects</td>
									<td>
										<g:select class="subjects" name="leastFavoriteSubjects1" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${profile?.getLeastFavoriteSubject(1)}" />
									</td>
									<td>Select up to 2 subjects</td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td>
										<g:select class="subjects" name="leastFavoriteSubjects2" from="${com.esm.esmzone.Subject.list()}" optionKey="id" value="${profile?.getLeastFavoriteSubject(2)}" />
									</td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td colspan="2">Please check the following box if you wish to receive ESMZone updates. <g:checkBox id="checkbox" name="newsletter"/></td> 										
									<td></td>
								</tr>
	
							</tbody>
						</table>
					</div><!-- end div#page -->
					<div id="content-footer">
						<input type="image" value="Register" class="submit right button" />
					</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>