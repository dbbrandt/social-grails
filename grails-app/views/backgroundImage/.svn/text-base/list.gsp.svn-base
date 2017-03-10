
<%@ page import="com.esm.esmzone.BackgroundImage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'backgroundImage.label', default: 'BackgroundImage')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'backgroundImage.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'backgroundImage.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="filename" title="${message(code: 'backgroundImage.filename.label', default: 'Filename')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'backgroundImage.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'backgroundImage.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${backgroundImageInstanceList}" status="i" var="backgroundImageInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${backgroundImageInstance.id}">${fieldValue(bean: backgroundImageInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: backgroundImageInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: backgroundImageInstance, field: "filename")}</td>
                        
                            <td><g:formatDate date="${backgroundImageInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${backgroundImageInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${backgroundImageInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
