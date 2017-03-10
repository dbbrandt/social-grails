
<%@ page import="com.esm.util.SchoolLoad" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'schoolLoad.label', default: 'SchoolLoad')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'schoolLoad.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'schoolLoad.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="type" title="${message(code: 'schoolLoad.type.label', default: 'Type')}" />
                        
                            <g:sortableColumn property="postalCode" title="${message(code: 'schoolLoad.postalCode.label', default: 'Postal Code')}" />
                        
                            <g:sortableColumn property="street" title="${message(code: 'schoolLoad.street.label', default: 'Street')}" />
                        
                            <g:sortableColumn property="state" title="${message(code: 'schoolLoad.state.label', default: 'State')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${schoolLoadInstanceList}" status="i" var="schoolLoadInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${schoolLoadInstance.id}">${fieldValue(bean: schoolLoadInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: schoolLoadInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: schoolLoadInstance, field: "type")}</td>
                        
                            <td>${fieldValue(bean: schoolLoadInstance, field: "postalCode")}</td>
                        
                            <td>${fieldValue(bean: schoolLoadInstance, field: "street")}</td>
                        
                            <td>${fieldValue(bean: schoolLoadInstance, field: "state")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${schoolLoadInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
