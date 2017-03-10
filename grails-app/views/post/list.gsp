
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'post.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="title" title="${message(code: 'post.title.label', default: 'Title')}" />
                        
                            <th><g:message code="post.member.label" default="Member" /></th>
                   	    
                            <th><g:message code="post.complaint.label" default="Complaint" /></th>
                   	    
                            <g:sortableColumn property="description" title="${message(code: 'post.description.label', default: 'Description')}" />
                        
                            <th><g:message code="post.bestAnswer.label" default="Best Answer" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postInstanceList}" status="i" var="postInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${postInstance.id}">${fieldValue(bean: postInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: postInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "member")}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "complaint")}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "bestAnswer")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
