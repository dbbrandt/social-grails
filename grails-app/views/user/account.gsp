<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta name="layout" content="mainAdmin">
		<title>ESMZone Account Edit</title>
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
		</style>
	</head>
	<body id="body">
		<div class="bodycopy">
			<h1>Account</h1>
			<p>Update your account for <b>${user?.login}</b> and submit!</p>
			<g:if test="${user?.hasErrors() || message}">
				<div class="errors">
					<g:renderErrors bean="${user}"></g:renderErrors>
					<g:if test="${message}">
						<g:message code="${message}"></g:message>
					</g:if>
				</div>			
			</g:if>
		</div>		
		<g:form action="account" name="profileForm">
			<g:hiddenField name="login" value="${user?.login}"/>
			<g:hiddenField name="version" value="${user?.version}" />
			<div class="formField">
				<label for="login">Email:</label>
				<g:textField name="email" value="${user?.email}"></g:textField>
			</div>			
			<div class="formField">			
				<label for="password">Password:</label>
				<g:passwordField name="password" value="${params?.password}"></g:passwordField>			
			</div>
			<div class="formField">			
				<label for="confirm">Confirm Password:</label>
				<g:passwordField name="confirm" value="${params?.confirm}"></g:passwordField>			
			</div>
			<div class="formField">
				<label for="firstName">First Name:</label>
				<g:textField name="firstName" value="${user?.firstName}"></g:textField>
			</div>			
			<div class="formField">
				<label for="lastName">Last Name:</label>
				<g:textField name="lastName" value="${user?.lastName}"></g:textField>
			</div>	
			<div class="checkbox">
				Please check the box if you wish to receive ESMZone updates.	
				<g:checkBox name="newsletter"></g:checkBox>
			</div>			
			<g:submitButton class="formButton" name="profile" value="Submit"></g:submitButton>					
		</g:form>
	</body>
	
</html>