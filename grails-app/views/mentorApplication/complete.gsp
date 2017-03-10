
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
            <h1>Mentor Application Completed</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${mentorApplicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorApplicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
                <p><b>Congratulations!</b> You have completed your application. As soon as your references respond you will be notified of the result.</p>
				<br>
				<p><b>Thank you for your participation!</b></p>
            </div>
        </div>
    </body>
</html>
