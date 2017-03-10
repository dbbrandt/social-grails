
<%@ page import="com.esm.esmzone.Patron" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'patron.label', default: 'Patron')}" />
        <title>Patron Requests</title>
    </head>
    <body>
        <div class="body">
            <h1>Patrons: Pending Requests</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'patron.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'patron.email.label', default: 'Email')}" />
                        
                            <g:sortableColumn property="organizationName" title="${message(code: 'patron.organizationName.label', default: 'Organization Name')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'patron.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'patron.lastName.label', default: 'Last Name')}" />
                        
                            <th><g:message code="patron.address.label" default="Address" /></th>

                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${patronInstanceList}" status="i" var="patronInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${patronInstance.id}">${fieldValue(bean: patronInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "organizationName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: patronInstance, field: "address")}</td>

                            <td>
                            	<g:link action='acceptPatron' id="${patronInstance?.id}">Accept</g:link>&nbsp;|
                            	<g:link action='declinePatron' id="${patronInstance?.id}">Decline</g:link>
                            </td>
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
