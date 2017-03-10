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
			<h1>Register for ESMZone</h1>
			<p>Complete the form below to create an account!</p>
			<g:if test="${user?.hasErrors() || message}">
				<div class="errors">
					<g:renderErrors bean="${user}"></g:renderErrors>
					<g:if test="${message}">
						<g:message code="${message}"></g:message>
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
		</div>
		
		<g:form action="register" name="registerForm">
			<g:hiddenField name="login" value="${user?.login}"/>
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
				<label for="gender">Gender:</label>
			</div>
			<div class="gender">
				<g:radio name="gender" value="Male" checked="${user?.gender == 'Male'}"/>Male&nbsp;&nbsp;
				<g:radio name="gender" value="Female" checked="${user?.gender == 'Female'}"/>Female
			</div>
            <div class="formField">
            	<label for="grade">Grade:</label>
                <g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${memberProfileInstance?.grade}" noSelection="['': '']" />
			</div>
            <div class="formField">
            	<label for="playedSports">Sports Played:</label>
                <g:select class="sports" name="playedSports" from="${com.esm.esmzone.Sport.list()}" multiple="yes" optionKey="id" size="5" value="${profile?.playedSports}" />
			</div>
			<div class="formField">
               	<label for="favoriteSports">Favorite Sports:</label>
                <g:select class="sports" name="favoriteSports" from="${com.esm.esmzone.Sport.list()}" multiple="yes" optionKey="id" size="5" value="${profile?.favoriteSports}" />
			</div>
            <div class="formField">
            	<label for="strongestSubjects">Strongest Subjects:</label>
                <g:select class="subjects" name="strongestSubjects" from="${com.esm.esmzone.Subject.list()}" multiple="yes" optionKey="id" size="5" value="${profile?.strongestSubjects}" />
			</div>
            <div class="formField">
            	<label for="leastFavoriteSubjects">Least Favorite Subjects:</label>
                <g:select class="subjects" name="leastFavoriteSubjects" from="${com.esm.esmzone.Subject.list()}" multiple="yes" optionKey="id" size="5" value="${profile?.leastFavoriteSubjects}" />
			</div>
			<div class="formField">
				<label for="birthdate">Birthdate:</label>
				<div id="valuePicker">
					<g:datePicker name="birthdate" value="${user?.birthdate}" precision="day" years="${2010..1930}"/>
				</div>
			</div>	
			<div class="formField">
				<label for="securityQuestion">SecurityQuestion:</label>
				<div id="valuePicker">
					<g:select id="securityQuestion" 
							  name="securityQuestion.id"
							  value="${user?.securityQuestion?.id}"
					          from="${securityQuestionList}" 
					          optionKey="id" 
					          optionValue="name" 
					          noSelection="['':'-Choose security question-']">
					</g:select>
				</div>
			</div>	
			<div class="formField">
				<label for="securityAnswer">Answer:</label>
				<g:textField name="securityAnswer" value="${user?.securityAnswer}"></g:textField>
			</div>	
			<div class="checkbox">
				Please check the following box if you wish to receive ESMZone updates.	
				<g:checkBox name="newsletter"></g:checkBox>
			</div>			
			<g:submitButton class="formButton" name="register" value="Register"></g:submitButton>					
		</g:form>
	</body>

</html>
