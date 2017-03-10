
<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
        <title>My Mentor Application Status</title>
    </head>
    <body>
        <div class="body">
            <h1>My Mentor Application Status</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:if test="${mentorApplicationInstanceTotal}">
	            <div class="list">
	                <table>
	                    <thead>
	                        <tr>
	                        
	                            <g:sortableColumn property="status" title="${message(code: 'mentorApplication.status.label', default: 'Status')}" />
	                   	    
	                            <g:sortableColumn property="dateCreated" title="${message(code: 'mentorApplication.dateCreated.label', default: 'Application Date')}" />
	
	                            <g:sortableColumn property="lastUpdated" title="${message(code: 'mentorApplication.lastUpdated.label', default: 'Last Updated')}" />
	                            
	                            <th>Action</th>
	                        
	                        
	                        </tr>
	                    </thead>
	                    <tbody>
	                    <g:each in="${mentorApplicationInstanceList}" status="i" var="mentorApplicationInstance">
	                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	                        
	                            <td><g:link action="apply" id="${mentorApplicationInstance.id}">${fieldValue(bean: mentorApplicationInstance, field: "status")}</g:link></td>
	                        
	                            <td><g:formatDate date="${mentorApplicationInstance.lastUpdated}" /></td>
	                        
	                            <td><g:formatDate date="${mentorApplicationInstance.dateCreated}" /></td>
	                        
	                            <td><g:link action="suspend" id="${mentorApplicationInstance?.id}">)>Suspend</g:link> | 
	                                <g:link action="full" id="${mentorApplicationInstance?.id}">No new requests (Mentoring ${request?.user?.menteeList().size()})</g:link> |
	   								<g:link action="notAcceptingRequests" id="${mentorApplicationInstance?.id}">Resume</g:link> 
	                            </td>
	                        
	                        </tr>
	                    </g:each>
	                    </tbody>
	                </table>
	            </div>
	          </g:if>
	          <g:else>
	          	 No applications found. Click here to <g:link action="apply">apply</g:link> 
	          </g:else>
            <div class="paginateButtons">
                <g:paginate total="${mentorApplicationInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
