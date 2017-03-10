
<%@ page import="com.esm.dialog.Complaint" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'complaint.label', default: 'Complaint')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'complaint.id.label', default: 'Id')}" />
                        
                            <th><g:message code="complaint.user.label" default="User" /></th>
                   	    
                            <g:sortableColumn property="content" title="${message(code: 'complaint.content.label', default: 'Content')}" />
                        
                            <g:sortableColumn property="message" title="${message(code: 'complaint.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'complaint.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="contentId" title="${message(code: 'complaint.contentId.label', default: 'Content Id')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${complaintInstanceList}" status="i" var="complaintInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${complaintInstance.id}">${fieldValue(bean: complaintInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: complaintInstance, field: "user")}</td>
                        
                            <td>${fieldValue(bean: complaintInstance, field: "content")}</td>
                        
                            <td>${fieldValue(bean: complaintInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: complaintInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: complaintInstance, field: "contentId")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${complaintInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
