
<%@ page import="com.esm.survey.Response" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'response.label', default: 'Response')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'response.id.label', default: 'Id')}" />
                        
                            <th><g:message code="response.question.label" default="Question" /></th>
                   	    
                            <g:sortableColumn property="responseText" title="${message(code: 'response.responseText.label', default: 'Response Text')}" />
                        
                            <g:sortableColumn property="correct" title="${message(code: 'response.correct.label', default: 'Correct')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'response.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'response.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${responseInstanceList}" status="i" var="responseInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${responseInstance.id}">${fieldValue(bean: responseInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: responseInstance, field: "question")}</td>
                        
                            <td>${fieldValue(bean: responseInstance, field: "responseText")}</td>
                        
                            <td><g:formatBoolean boolean="${responseInstance.correct}" /></td>
                        
                            <td><g:formatDate date="${responseInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${responseInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${responseInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
