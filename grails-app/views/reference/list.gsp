
<%@ page import="com.esm.esmzone.Reference" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'reference.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'reference.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="sequence" title="${message(code: 'reference.sequence.label', default: 'Sequence')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'reference.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'reference.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'reference.lastName.label', default: 'Last Name')}" />
                        
                            <g:sortableColumn property="relationship" title="${message(code: 'reference.relationship.label', default: 'Relationship')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'reference.description.label', default: 'Description')}" />
                        
                            <th><g:message code="reference.application.label" default="Application" /></th>
                   	    
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'reference.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${referenceInstanceList}" status="i" var="referenceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${referenceInstance.id}">${fieldValue(bean: referenceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "sequence")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "relationship")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: referenceInstance, field: "application")}</td>
                        
                            <td><g:formatDate date="${referenceInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${referenceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
