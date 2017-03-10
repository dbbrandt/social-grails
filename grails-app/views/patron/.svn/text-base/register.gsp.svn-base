<html>
	<head>
		<meta http-equiv="Content-type" content="text/html; charset=utf-8">
		<meta name="layout" content="mainAdmin">
		<title>ESMZone Registration</title>
		<style type="text/css" media="screen">
			.formField label {
				position:absolute;
				margin-top:10px;
			}
			.formField input {
				margin-left:150px;
				margin-top:10px;
			}
			.formField .grade {
				margin-left:150px;
				margin-top:10px;
			}
			.formField .sports {
				margin-left:150px;
				margin-top:10px;
			}
			.formField .subjects {
				margin-left:150px;
				margin-top:10px;
			}
			.formField #valuePicker {
				margin-right:55px;
				margin-top:10px;
				text-align: right;
			}
			.gender {
				margin-left:150px;
				margin-top:10px;
			}
			.checkbox {
			    margin-top:10px;
				width:200px;
			}
			.checkbox input {
			    margin-top:-35px;
				margin-left:260px;
			}
			#registerForm {
				margin-top:20px;
				margin-left:20px;
				width:400px;
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
			<h1>Register for a Patron account on ESMZone</h1>
			<p>Complete the form below to create an account!</p>
			<g:if test="${patron?.hasErrors() || message}">
				<div class="errors">
					<g:renderErrors bean="${patron}"></g:renderErrors>
					<g:if test="${message}">
						<g:message code="${message}"></g:message>
					</g:if>
				</div>			
			</g:if>
			<g:if test="${address?.hasErrors()}">
				<div class="errors">
					<g:renderErrors bean="${address}"></g:renderErrors>
				</div>			
			</g:if>
		</div>
		
		<g:form action="register" name="registerForm">
			<div class="formField">
				<label for="email">Email:</label>
				<g:textField name="email" value="${patron?.email}"></g:textField>
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
				<label for="organizationName">Organization:</label>
				<g:textField name="organizationName" value="${patron?.organizationName}"></g:textField>
			</div>			
			<div class="formField">
				<label for="firstName">First Name:</label>
				<g:textField name="firstName" value="${patron?.firstName}"></g:textField>
			</div>			
			<div class="formField">
				<label for="lastName">Last Name:</label>
				<g:textField name="lastName" value="${patron?.lastName}"></g:textField>
			</div>	
			<div class="formField">
				<label for="street">Street:</label>
				<g:textField name="street" value="${address?.street}"></g:textField>
			</div>	
			<div class="formField">
				<label for="city">City:</label>
				<g:textField name="city" value="${address?.city}"></g:textField>
			</div>	
			<div class="formField">
				<label for="state">State:</label>
				<g:textField name="state" value="${address?.state}"></g:textField>
			</div>	
			<div class="formField">
				<label for="postalCode">Zip:</label>
				<g:textField name="postalCode" value="${address?.postalCode}"></g:textField>
			</div>	
			<div class="formField">
				<label for="securityQuestion">SecurityQuestion:</label>
				<div id="valuePicker">
					<g:select id="securityQuestion" 
							  name="securityQuestion.id"
							  value="${patron?.securityQuestion?.id}"
					          from="${securityQuestionList}" 
					          optionKey="id" 
					          optionValue="name" 
					          noSelection="['':'-Choose security question-']">
					</g:select>
				</div>
			</div>	
			<div class="formField">
				<label for="securityAnswer">Answer:</label>
				<g:textField name="securityAnswer" value="${patron?.securityAnswer}"></g:textField>
			</div>	
			<g:submitButton class="formButton" name="register" value="Register"></g:submitButton>					
		</g:form>
	</body>
</html>