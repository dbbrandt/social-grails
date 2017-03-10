
<%@ page import="com.esm.esmzone.Avatar" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'avatar.label', default: 'Avatar')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'avatar.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'avatar.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="filename" title="${message(code: 'avatar.filename.label', default: 'Filename')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'avatar.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'avatar.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${avatarInstanceList}" status="i" var="avatarInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${avatarInstance.id}">${fieldValue(bean: avatarInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: avatarInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: avatarInstance, field: "filename")}</td>
                        
                            <td><g:formatDate date="${avatarInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${avatarInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${avatarInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
