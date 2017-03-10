
<%@ page import="com.esm.dialog.Complaint" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'complaint.label', default: 'Complaint')}" />
        <title>Complaint Report</title>
    </head>
    <body>
        <div class="body">
            <h1>Pending Complaint Report</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div>
            	<g:link action="report" params="['status':'PENDING']">Pending</g:link> |
            	<g:link action="report" params="['status':'REJECTED']">Rejected</g:link> |
            	<g:link action="report" params="['status':'ACCEPTED']">Accepted</g:link> |
            	<g:link action="report" params="['status':'ALL']">All</g:link>
            </div>
            <br>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <g:sortableColumn property="author" title="${message(code: 'complaint.author.label', default: 'Author')}" />

                            <g:sortableColumn property="type" title="${message(code: 'complaint.type.label', default: 'Content Type')}" />

                            <g:sortableColumn property="content" title="${message(code: 'complaint.content.label', default: 'Content')}" />
                        
                            <g:sortableColumn property="user" title="${message(code: 'complaint.user.label', default: 'User')}" />
                   	    
                            <g:sortableColumn property="message" title="${message(code: 'complaint.message.label', default: 'Message')}" />

                            <g:sortableColumn property="status" title="${message(code: 'complaint.status.label', default: 'Status')}" />

							<th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${complaintInstanceList}" status="i" var="complaintInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                            <td><g:link controller='memberProfile' action="view" id="${complaintInstance?.author?.id}">${fieldValue(bean: complaintInstance, field: "author")}</g:link></td>

   	                        <td>${fieldValue(bean: complaintInstance, field: "type")}</td>

   	                        <td><%=complaintInstance?.content%></td>

                            <td><g:link controller='memberProfile' action="view" id="${complaintInstance?.user?.id}">${fieldValue(bean: complaintInstance, field: "user")}</g:link></td>
                            
                            <td>${fieldValue(bean: complaintInstance, field: "message")}</td>
             
                            <td>${fieldValue(bean: complaintInstance, field: "status")}</td>

                            <td><g:link controller='complaint' action="reject" id="${complaintInstance?.id}">Reject</g:link> | 
                                <g:link controller='complaint' action="accept" id="${complaintInstance?.id}">Accept</g:link> |
                                <g:link controller='complaint' action="suspend" id="${complaintInstance?.id}">Suspend Author</g:link> 
                            </td>

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
