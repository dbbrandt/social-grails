
<%@ page import="com.esm.esmzone.Subscription" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'subscription.label', default: 'Subscription')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'subscription.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="active" title="${message(code: 'subscription.active.label', default: 'Active')}" />
                        
                            <g:sortableColumn property="startDate" title="${message(code: 'subscription.startDate.label', default: 'Start Date')}" />
                        
                            <g:sortableColumn property="endDate" title="${message(code: 'subscription.endDate.label', default: 'End Date')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'subscription.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'subscription.lastName.label', default: 'Last Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${subscriptionInstanceList}" status="i" var="subscriptionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${subscriptionInstance.id}">${fieldValue(bean: subscriptionInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatBoolean boolean="${subscriptionInstance.active}" /></td>
                        
                            <td><g:formatDate date="${subscriptionInstance.startDate}" /></td>
                        
                            <td><g:formatDate date="${subscriptionInstance.endDate}" /></td>
                        
                            <td>${fieldValue(bean: subscriptionInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: subscriptionInstance, field: "lastName")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${subscriptionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
