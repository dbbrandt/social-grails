
<%@ page import="com.esm.esmzone.MentorQuiz" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorQuiz.label', default: 'MentorQuiz')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'mentorQuiz.id.label', default: 'Id')}" />
                        
                            <th><g:message code="mentorQuiz.survey.label" default="Survey" /></th>
                   	    
                            <g:sortableColumn property="passed" title="${message(code: 'mentorQuiz.passed.label', default: 'Passed')}" />
                        
                            <th><g:message code="mentorQuiz.application.label" default="Application" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'mentorQuiz.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'mentorQuiz.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${mentorQuizInstanceList}" status="i" var="mentorQuizInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${mentorQuizInstance.id}">${fieldValue(bean: mentorQuizInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: mentorQuizInstance, field: "survey")}</td>
                        
                            <td><g:formatBoolean boolean="${mentorQuizInstance.passed}" /></td>
                        
                            <td>${fieldValue(bean: mentorQuizInstance, field: "application")}</td>
                        
                            <td><g:formatDate date="${mentorQuizInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${mentorQuizInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${mentorQuizInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
