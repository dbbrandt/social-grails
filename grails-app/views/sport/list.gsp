
<%@ page import="com.esm.esmzone.Sport" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'sport.label', default: 'Sport')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'sport.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'sport.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'sport.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'sport.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'sport.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sportInstanceList}" status="i" var="sportInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${sportInstance.id}">${fieldValue(bean: sportInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: sportInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: sportInstance, field: "description")}</td>
                        
                            <td><g:formatDate date="${sportInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${sportInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${sportInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
