<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta name="layout" content="mainAdmin">
		<title>ESMZone Forgot Password</title>
		<style type="text/css" media="screen">
			.formField label {
				position:absolute;
				margin-top:10px;
			}
			.formField input {
				margin-left:150px;
				margin-top:10px;
			}
			#profileForm {
				margin-top:20px;
				width:400px;
				margin-left:20px;
			}
			.checkbox {
			    margin-top:10px;
				width:140px;
			}
			.checkbox input {
			    margin-top:-35px;
				margin-left:150px;
			}
			
			.formButton {
				margin-left:200px;
				margin-top:20px;
			}
			.bodycopy {
				margin-left:20px;	
			}
			.formField #valuePicker {
				margin-left:150px;
				margin-top:10px;
			}
		</style>
	</head>
	<body id="body">
		<div class="bodycopy">
			<h1>Forgot Password</h1>
			<g:if test="${user?.hasErrors() || flash.message}">
				<div class="errors">
					<g:renderErrors bean="${user}"></g:renderErrors>
					<g:if test="${flash.message}">
						<g:message code="${flash.message}"></g:message>
					</g:if>
				</div>			
			</g:if>
		</div>		
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
					<div class="formField">
						<label for="securityAnswer">Answer:</label>
						<g:textField name="securityAnswer"></g:textField>
					</div>			
					<div class="formField">
						<label for="birthdate">Birthdate:</label>
						<div id="valuePicker">
							<g:datePicker name="birthdate" precision="day" years="${2010..1930}"/>
						</div>
					</div>
					<div class="checkbox">
						Please send me a reset email instead.	
						<g:checkBox name="sendEmail"></g:checkBox>
					</div>			
			</g:elseif>
			<g:else>
				<p>Please select a new password</p>
				<div class="formField">			
					<label for="password">Password:</label>
					<g:passwordField name="password" value="${params?.password}"></g:passwordField>			
				</div>
				<div class="formField">			
					<label for="confirm">Confirm Password:</label>
					<g:passwordField name="confirm" value="${params?.confirm}"></g:passwordField>			
				</div>
			</g:else>
			<g:submitButton class="formButton" name="profile" value="Submit"></g:submitButton>					
		</g:form>
	</body>
	
</html>