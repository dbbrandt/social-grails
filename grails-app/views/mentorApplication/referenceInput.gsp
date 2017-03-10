
<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Mentor References</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${mentorApplicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorApplicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
				<p>Please enter two references below.</p>
                <p>The two reference must respond to your email within a week and confirm your qualification to be a mentor.</p>
                <p>Your references will be able to see your profile in order to confirm your identity and qualifications.</p>
            </div>
            <g:form action="referenceInput" method="post" >
                <g:hiddenField name="id" value="${mentorApplicationInstance?.id}" />
                <g:hiddenField name="version" value="${mentorApplicationInstance?.version}" />
                <g:each in="${referenceList}" var="r">
                	<p>Reference ${r.sequence}:</p> 
		            <g:hasErrors bean="${r}">
		            <div class="errors">
		                <g:renderErrors bean="${r}" as="list" />
		            </div>
		            </g:hasErrors>
		            <div class="formField">
		               	<label for="firstName.${r.sequence}">First Name:</label>
	                    <g:textField name="firstName.${r.sequence}" value="${r?.firstName}" />
	  				</div>
		            <div class="formField">
		               	<label for="lastName.${r.sequence}">Last Name:</label>
	                    <g:textField name="lastName.${r.sequence}" value="${r?.lastName}" />
	  				</div>
		            <div class="formField">
		               	<label for="relationship.${r.sequence}">Relationship to Applicant:</label>
	                    <g:textField name="relationship.${r.sequence}" value="${r?.relationship}" />
	  				</div>
		            <div class="formField">
		               	<label for="email.${r.sequence}">Email:</label>
	                    <g:textField name="email.${r.sequence}" value="${r?.email}" />
	  				</div>
	            </g:each>
	            <div class="formbutton">
	                <g:submitButton name="submit" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
	            </div>
            </g:form>
        </div>
    </body>
</html>
