
<%@ page import="com.esm.dialog.PostType" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'postType.label', default: 'PostType')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'postType.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'postType.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="audience" title="${message(code: 'postType.audience.label', default: 'Audience')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postTypeInstanceList}" status="i" var="postTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${postTypeInstance.id}">${fieldValue(bean: postTypeInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: postTypeInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: postTypeInstance, field: "audience")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
