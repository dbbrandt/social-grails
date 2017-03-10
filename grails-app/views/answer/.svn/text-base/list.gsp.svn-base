
<%@ page import="com.esm.dialog.Answer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'answer.label', default: 'Answer')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'answer.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'answer.description.label', default: 'Description')}" />
                        
                            <th><g:message code="answer.complaint.label" default="Complaint" /></th>
                   	    
                            <g:sortableColumn property="averageRating" title="${message(code: 'answer.averageRating.label', default: 'Average Rating')}" />
                        
                            <th><g:message code="answer.post.label" default="Post" /></th>
                   	    
                            <g:sortableColumn property="ratingCount" title="${message(code: 'answer.ratingCount.label', default: 'Rating Count')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${answerInstanceList}" status="i" var="answerInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${answerInstance.id}">${fieldValue(bean: answerInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: answerInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: answerInstance, field: "complaint")}</td>
                        
                            <td>${fieldValue(bean: answerInstance, field: "averageRating")}</td>
                        
                            <td>${fieldValue(bean: answerInstance, field: "post")}</td>
                        
                            <td>${fieldValue(bean: answerInstance, field: "ratingCount")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${answerInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
