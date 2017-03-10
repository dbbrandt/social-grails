
<%@ page import="com.esm.dialog.PostTag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'postTag.label', default: 'PostTag')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'postTag.id.label', default: 'Id')}" />
                        
                            <th><g:message code="postTag.post.label" default="Post" /></th>
                   	    
                            <th><g:message code="postTag.user.label" default="User" /></th>
                   	    
                            <th><g:message code="postTag.tag.label" default="Tag" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'postTag.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'postTag.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postTagInstanceList}" status="i" var="postTagInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${postTagInstance.id}">${fieldValue(bean: postTagInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: postTagInstance, field: "post")}</td>
                        
                            <td>${fieldValue(bean: postTagInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: postTagInstance, field: "tag")}</td>
                        
                            <td><g:formatDate date="${postTagInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${postTagInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postTagInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
