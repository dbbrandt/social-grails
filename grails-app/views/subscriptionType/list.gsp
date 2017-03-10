
<%@ page import="com.esm.esmzone.SubscriptionType" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'subscriptionType.label', default: 'SubscriptionType')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'subscriptionType.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'subscriptionType.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'subscriptionType.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="months" title="${message(code: 'subscriptionType.months.label', default: 'Months')}" />
                        
                            <g:sortableColumn property="cost" title="${message(code: 'subscriptionType.cost.label', default: 'Cost')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'subscriptionType.lastUpdated.label', default: 'Last Updated')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${subscriptionTypeInstanceList}" status="i" var="subscriptionTypeInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${subscriptionTypeInstance.id}">${fieldValue(bean: subscriptionTypeInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: subscriptionTypeInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: subscriptionTypeInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: subscriptionTypeInstance, field: "months")}</td>
                        
                            <td>${fieldValue(bean: subscriptionTypeInstance, field: "cost")}</td>
                        
                            <td><g:formatDate date="${subscriptionTypeInstance.lastUpdated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${subscriptionTypeInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
