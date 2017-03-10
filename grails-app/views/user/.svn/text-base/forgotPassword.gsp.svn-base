<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="js/functions.js"></script>
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>Forgot Password</h1>
	</div><!-- end div#menu -->
	<div id="content">
		<g:if test="${user?.hasErrors() || flash.message}">
			<div class="errors">
				<g:renderErrors bean="${user}"></g:renderErrors>
				<g:if test="${flash.message}">
					<g:message code="${flash.message}"></g:message>
				</g:if>
			</div>			
		</g:if>
		<g:form action="forgotPassword" name="forgotPassword">
	       <g:hiddenField name="validated" value="${validated}" />
	       <g:hiddenField name="id" value="${user?.id}" />
		    <g:if test="${!user}">
				<p>Enter the information and submit!</p>
				<div class="formField">
					<label for="login">Email:</label>
					<g:textField name="email" value="${user?.email}"></g:textField>
				</div>
			</g:if>
			<g:elseif test="${securityQuestion}">
				<p>${securityQuestion.question}</p>
				<label for="securityAnswer">Answer:</label>
				<g:textField name="securityAnswer"></g:textField>
				<label for="birthdate">Birthdate:</label>
				<g:datePicker name="birthdate" precision="day" years="${2010..1930}"/>
				<div class="checkbox">
				<label for="sendEmail">Please send me a reset email instead.</label>
				<g:checkBox style="margin-top:-30px" name="sendEmail"></g:checkBox>
			</g:elseif>
			<g:else>
				<label>Please select a new password:</label>
				<label for="password">Password:</label>
				<g:passwordField name="password" value="${params?.password}"></g:passwordField>			
				<label for="confirm">Confirm Password:</label>
				<g:passwordField name="confirm" value="${params?.confirm}"></g:passwordField>			
			</g:else>
			<a href="javascript:submitformNormal('forgotPassword')" class="nofold button">Next</a>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup --></html>
