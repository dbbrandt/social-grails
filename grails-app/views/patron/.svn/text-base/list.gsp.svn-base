
<%@ page import="com.esm.esmzone.Patron" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'patron.label', default: 'Patron')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'patron.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'patron.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'patron.password.label', default: 'Password')}" />
                        
                            <g:sortableColumn property="organizationName" title="${message(code: 'patron.organizationName.label', default: 'Organization Name')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'patron.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'patron.lastName.label', default: 'Last Name')}" />
                        
                            <th><g:message code="patron.address.label" default="Address" /></th>
                   	    
                            <th><g:message code="patron.source.label" default="Source" /></th>
                   	    
                            <g:sortableColumn property="status" title="${message(code: 'patron.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'patron.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${patronInstanceList}" status="i" var="patronInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${patronInstance.id}">${fieldValue(bean: patronInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "password")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "organizationName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "address")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "source")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "status")}</td>
                        
                            <td><g:formatDate date="${patronInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${patronInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
