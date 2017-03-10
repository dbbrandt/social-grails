
<%@ page import="com.esm.esmzone.NetworkConnection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'networkConnection.label', default: 'NetworkConnection')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'networkConnection.id.label', default: 'Id')}" />
                        
                            <th><g:message code="networkConnection.user.label" default="User" /></th>
                   	    
                            <th><g:message code="networkConnection.friend.label" default="Friend" /></th>
                   	    
                            <g:sortableColumn property="message" title="${message(code: 'networkConnection.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="type" title="${message(code: 'networkConnection.type.label', default: 'Type')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'networkConnection.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'networkConnection.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'networkConnection.dateCreated.label', default: 'Date Created')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${networkConnectionInstanceList}" status="i" var="networkConnectionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${networkConnectionInstance.id}">${fieldValue(bean: networkConnectionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "friend")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "type")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "status")}</td>
                        
                            <td><g:formatDate date="${networkConnectionInstance.lastUpdated}" /></td>
                        
                            <td><g:formatDate date="${networkConnectionInstance.dateCreated}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${networkConnectionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
