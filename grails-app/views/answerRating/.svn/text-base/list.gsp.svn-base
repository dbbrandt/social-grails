
<%@ page import="com.esm.dialog.AnswerRating" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'answerRating.label', default: 'AnswerRating')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'answerRating.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="score" title="${message(code: 'answerRating.score.label', default: 'Score')}" />
                        
                            <th><g:message code="answerRating.answer.label" default="Answer" /></th>
                   	    
                            <th><g:message code="answerRating.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${answerRatingInstanceList}" status="i" var="answerRatingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${answerRatingInstance.id}">${fieldValue(bean: answerRatingInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: answerRatingInstance, field: "score")}</td>
                        
                            <td>${fieldValue(bean: answerRatingInstance, field: "answer")}</td>
                        
                            <td>${fieldValue(bean: answerRatingInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${answerRatingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
