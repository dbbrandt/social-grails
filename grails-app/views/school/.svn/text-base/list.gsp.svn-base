
<%@ page import="com.esm.esmzone.School" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'school.label', default: 'School')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'school.id.label', default: 'Id')}" />
                        
                            <th><g:message code="school.address.label" default="Address" /></th>
                   	    
                            <g:sortableColumn property="name" title="${message(code: 'school.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'school.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'school.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="type" title="${message(code: 'school.type.label', default: 'Type')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${schoolInstanceList}" status="i" var="schoolInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${schoolInstance.id}">${fieldValue(bean: schoolInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: schoolInstance, field: "address")}</td>
                        
                            <td>${fieldValue(bean: schoolInstance, field: "name")}</td>
                        
                            <td><g:formatDate date="${schoolInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${schoolInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: schoolInstance, field: "type")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${schoolInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
