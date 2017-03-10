
<%@ page import="com.esm.dialog.PostRating" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'postRating.label', default: 'PostRating')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'postRating.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="score" title="${message(code: 'postRating.score.label', default: 'Score')}" />
                        
                            <th><g:message code="postRating.post.label" default="Post" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'postRating.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'postRating.dateCreated.label', default: 'Date Created')}" />
                        
                            <th><g:message code="postRating.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postRatingInstanceList}" status="i" var="postRatingInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${postRatingInstance.id}">${fieldValue(bean: postRatingInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: postRatingInstance, field: "score")}</td>
                        
                            <td>${fieldValue(bean: postRatingInstance, field: "post")}</td>
                        
                            <td><g:formatDate date="${postRatingInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${postRatingInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: postRatingInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postRatingInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
