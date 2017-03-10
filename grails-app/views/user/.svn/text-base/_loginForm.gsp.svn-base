<g:if test="${params.loginError}">
	<div id="message" class="errorMessage">
		${params.loginError}
	</div>
</g:if>
<g:form name=:loginForm" controller="user" action="login">
	<div class="loginText">
		<div>Username:</div>
		<g:textField name="login" class="loginText"></g:textField>
		<div>Password:</div>
		<g:passwordField name="password" class="loginText"></g:passwordField>
	</div>			
	<div id="signUp"><g:link controller="user" action="register" class="loginText">Join Now!</g:link>&nbsp;&nbsp;<g:link controller="user" action="forgotPassword" class="forgotPassword">Forgot Password</g:link></div>
	<input type="image" src="${createLinkTo(dir:'images', file:'login-button.gif')}" name="loginButton" id="loginButton" border="0"></input>	
</g:form>
