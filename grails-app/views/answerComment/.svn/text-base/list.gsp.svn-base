
<%@ page import="com.esm.dialog.AnswerComment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'answerComment.label', default: 'AnswerComment')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'answerComment.id.label', default: 'Id')}" />
                        
                            <th><g:message code="answerComment.answer.label" default="Answer" /></th>
                   	    
                            <th><g:message code="answerComment.author.label" default="Author" /></th>
                   	    
                            <th><g:message code="answerComment.complaint.label" default="Complaint" /></th>
                   	    
                            <g:sortableColumn property="description" title="${message(code: 'answerComment.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'answerComment.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${answerCommentInstanceList}" status="i" var="answerCommentInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${answerCommentInstance.id}">${fieldValue(bean: answerCommentInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: answerCommentInstance, field: "answer")}</td>
                        
                            <td>${fieldValue(bean: answerCommentInstance, field: "author")}</td>
                        
                            <td>${fieldValue(bean: answerCommentInstance, field: "complaint")}</td>
                        
                            <td>${fieldValue(bean: answerCommentInstance, field: "description")}</td>
                        
                            <td><g:formatDate date="${answerCommentInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${answerCommentInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
