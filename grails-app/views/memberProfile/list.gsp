
<%@ page import="com.esm.esmzone.MemberProfile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'memberProfile.label', default: 'MemberProfile')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'memberProfile.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="favoriteProPlayer" title="${message(code: 'memberProfile.favoriteProPlayer.label', default: 'Favorite Pro Player')}" />
                        
                            <g:sortableColumn property="favoriteProTeam" title="${message(code: 'memberProfile.favoriteProTeam.label', default: 'Favorite Pro Team')}" />
                        
                            <g:sortableColumn property="favoriteMovie" title="${message(code: 'memberProfile.favoriteMovie.label', default: 'Favorite Movie')}" />
                        
                            <g:sortableColumn property="roleModel" title="${message(code: 'memberProfile.roleModel.label', default: 'Role Model')}" />
                        
                            <g:sortableColumn property="careerInterests" title="${message(code: 'memberProfile.careerInterests.label', default: 'Career Interests')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${memberProfileInstanceList}" status="i" var="memberProfileInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${memberProfileInstance.id}">${fieldValue(bean: memberProfileInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: memberProfileInstance, field: "favoriteProPlayer")}</td>
                        
                            <td>${fieldValue(bean: memberProfileInstance, field: "favoriteProTeam")}</td>
                        
                            <td>${fieldValue(bean: memberProfileInstance, field: "favoriteMovie")}</td>
                        
                            <td>${fieldValue(bean: memberProfileInstance, field: "roleModel")}</td>
                        
                            <td>${fieldValue(bean: memberProfileInstance, field: "careerInterests")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${memberProfileInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
