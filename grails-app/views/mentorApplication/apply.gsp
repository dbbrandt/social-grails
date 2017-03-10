
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
            <h1>Mentor Application</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${mentorApplicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorApplicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
                <p>In order to become a mentor you must pass a simple quiz and then get two recommendations.</p>
                <p>If you pass the quiz you will be prompted to enter the email addresses of two references.</p>
                <p>The two reference must respond to your email within a week and confirm your qualification to be a mentor.</p>
                <p>Your references will be able to see your profile in order to confirm your identity and qualifications.</p>
            </div>
            <g:form action="apply" method="post" >
				<div class="checkbox">
					Please check the Agree box below to confirm your acceptance of these terms.	
					<g:checkBox name="mentorWaiver"></g:checkBox>
				</div>			
                <div class="buttons">
                    <span class="button"><g:submitButton name="apply" class="save" value="${message(code: 'default.button.apply.label', default: 'Apply')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
