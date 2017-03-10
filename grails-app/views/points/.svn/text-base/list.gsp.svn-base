
<%@ page import="com.esm.esmzone.Points" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'points.label', default: 'Points')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'points.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="points" title="${message(code: 'points.points.label', default: 'Points')}" />
                        
                            <th><g:message code="points.type.label" default="Type" /></th>
                   	    
                            <th><g:message code="points.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${pointsInstanceList}" status="i" var="pointsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${pointsInstance.id}">${fieldValue(bean: pointsInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: pointsInstance, field: "points")}</td>
                        
                            <td>${fieldValue(bean: pointsInstance, field: "type")}</td>
                        
                            <td>${fieldValue(bean: pointsInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${pointsInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
