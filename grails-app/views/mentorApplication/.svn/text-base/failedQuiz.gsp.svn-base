
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
            <h1>Mentor Application Status</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${mentorApplicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorApplicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
                <p>Unfortunately you did not pass the quiz. Please come back and try again in a week.</p>
            </div>
        </div>
    </body>
</html>
