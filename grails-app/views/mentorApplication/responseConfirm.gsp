<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
        <title>Mentor Reference Confirmation</title>
    </head>
    <body>
        <div class="body">
            <h1>Mentor Reference Confirmation</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
        </div>
    </body>
</html>
