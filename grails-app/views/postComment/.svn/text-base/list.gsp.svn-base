
<%@ page import="com.esm.dialog.PostComment" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'postComment.label', default: 'PostComment')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'postComment.id.label', default: 'Id')}" />
                        
                            <th><g:message code="postComment.post.label" default="Post" /></th>
                   	    
                            <th><g:message code="postComment.author.label" default="Author" /></th>
                   	    
                            <g:sortableColumn property="description" title="${message(code: 'postComment.description.label', default: 'Description')}" />
                        
                            <th><g:message code="postComment.complaint.label" default="Complaint" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'postComment.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postCommentInstanceList}" status="i" var="postCommentInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${postCommentInstance.id}">${fieldValue(bean: postCommentInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: postCommentInstance, field: "post")}</td>
                        
                            <td>${fieldValue(bean: postCommentInstance, field: "author")}</td>
                        
                            <td>${fieldValue(bean: postCommentInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: postCommentInstance, field: "complaint")}</td>
                        
                            <td><g:formatDate date="${postCommentInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postCommentInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
