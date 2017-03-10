
<%@ page import="com.esm.esmzone.ESMTransaction" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'ESMTransaction.label', default: 'ESMTransaction')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'ESMTransaction.id.label', default: 'Id')}" />
                        
                            <th><g:message code="ESMTransaction.user.label" default="User" /></th>
                   	    
                            <th><g:message code="ESMTransaction.friend.label" default="Friend" /></th>
                   	    
                            <g:sortableColumn property="message" title="${message(code: 'ESMTransaction.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="type" title="${message(code: 'ESMTransaction.type.label', default: 'Type')}" />
                        
                            <g:sortableColumn property="cleared" title="${message(code: 'ESMTransaction.cleared.label', default: 'Cleared')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${ESMTransactionInstanceList}" status="i" var="ESMTransactionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${ESMTransactionInstance.id}">${fieldValue(bean: ESMTransactionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: ESMTransactionInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: ESMTransactionInstance, field: "friend")}</td>
                        
                            <td>${fieldValue(bean: ESMTransactionInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: ESMTransactionInstance, field: "type")}</td>
                        
                            <td><g:formatBoolean boolean="${ESMTransactionInstance.cleared}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${ESMTransactionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
