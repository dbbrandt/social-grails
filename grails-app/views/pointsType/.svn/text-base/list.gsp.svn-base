
<%@ page import="com.esm.esmzone.PointsType" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'pointsType.label', default: 'PointsType')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'pointsType.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'pointsType.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'pointsType.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="points" title="${message(code: 'pointsType.points.label', default: 'Points')}" />
                        
                            <g:sortableColumn property="bonusCount" title="${message(code: 'pointsType.bonusCount.label', default: 'Bonus Count')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'pointsType.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'pointsType.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="bonusPoints" title="${message(code: 'pointsType.bonusPoints.label', default: 'Bonus Points')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${pointsTypeInstanceList}" status="i" var="pointsTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${pointsTypeInstance.id}">${fieldValue(bean: pointsTypeInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: pointsTypeInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: pointsTypeInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: pointsTypeInstance, field: "points")}</td>
                        
                            <td>${fieldValue(bean: pointsTypeInstance, field: "bonusCount")}</td>
                        
                            <td><g:formatDate date="${pointsTypeInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${pointsTypeInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: pointsTypeInstance, field: "bonusPoints")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${pointsTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
