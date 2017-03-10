
<%@ page import="com.esm.esmzone.NetworkConnection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'networkConnection.label', default: 'NetworkConnection')}" />
        <title>Scout Report</title>
    </head>
    <body>
        <div class="body">
            <h1>Scout Report: Pending Requests</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <th><g:message code="networkConnection.user.label" default="Member" /></th>
                   	    
                            <g:sortableColumn property="message" title="${message(code: 'networkConnection.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="type" title="${message(code: 'networkConnection.type.label', default: 'Type')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'networkConnection.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'networkConnection.dateCreated.label', default: 'Requested')}" />
                            
                            <th>Action</th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${networkConnectionInstanceList}" status="i" var="networkConnectionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link controller='memberProfile' action="view" id="${networkConnectionInstance?.user?.id}">${fieldValue(bean: networkConnectionInstance, field: "user")}</g:link></td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "type")}</td>
                        
                            <td>${fieldValue(bean: networkConnectionInstance, field: "status")}</td>
                        
                            <td><g:formatDate date="${networkConnectionInstance?.dateCreated}" /></td>
                            
                            <td>
                            	<g:link action='acceptConnection' id="${networkConnectionInstance?.id}">Accept</g:link>&nbsp;|
                            	<g:link action='declineConnection' id="${networkConnectionInstance?.id}">Decline</g:link>
                            </td>
                        
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
