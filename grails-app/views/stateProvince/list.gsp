
<%@ page import="com.esm.esmzone.StateProvince" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'stateProvince.label', default: 'StateProvince')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'stateProvince.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'stateProvince.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'stateProvince.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'stateProvince.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${stateProvinceInstanceList}" status="i" var="stateProvinceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${stateProvinceInstance.id}">${fieldValue(bean: stateProvinceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: stateProvinceInstance, field: "name")}</td>
                        
                            <td><g:formatDate date="${stateProvinceInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${stateProvinceInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${stateProvinceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
