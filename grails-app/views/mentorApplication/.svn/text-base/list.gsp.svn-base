
<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'mentorApplication.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'mentorApplication.status.label', default: 'Status')}" />
                        
                            <th><g:message code="mentorApplication.quiz.label" default="Quiz" /></th>
                   	    
                            <th><g:message code="mentorApplication.mentor.label" default="Mentor" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'mentorApplication.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'mentorApplication.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${mentorApplicationInstanceList}" status="i" var="mentorApplicationInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${mentorApplicationInstance.id}">${fieldValue(bean: mentorApplicationInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: mentorApplicationInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: mentorApplicationInstance, field: "quiz")}</td>
                        
                            <td>${fieldValue(bean: mentorApplicationInstance, field: "mentor")}</td>
                        
                            <td><g:formatDate date="${mentorApplicationInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${mentorApplicationInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${mentorApplicationInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
