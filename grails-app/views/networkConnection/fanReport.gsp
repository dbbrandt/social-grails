
<%@ page import="com.esm.esmzone.NetworkConnection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'networkConnection.label', default: 'NetworkConnection')}" />
        <title>Fan Report</title>
    </head>
    <body>
        <div class="body">
            <h1>Fan Report</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <p><b><u>Mentors</u></b></p><br>
            <g:if test="${mentorListTotal}">
	            <div class="list">
	                <table>
	                    <thead>
	                        <tr>
	                            <th><g:message code="networkConnection.user.label" default="name" /></th>

	                            <th><g:message code="networkConnection.averageRating.label" default="averageRating" /></th>
	                            
	                            <th>Action</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    <g:each in="${mentorList}" status="i" var="networkConnectionInstance">
	                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

	                            <td><g:link controller='memberProfile' action="view" id="${networkConnectionInstance?.friend?.id}">${fieldValue(bean: networkConnectionInstance, field: "friend")}</g:link></td>

	                            <td>${networkConnectionInstance?.friend?.averageRating}</td>
	                            
	                            <td><g:link controller='post' action="privateDirectory" id="${networkConnectionInstance?.friend?.id}">Questions (${networkConnectionInstance?.questionCount()})</g:link> | 
	                                <g:link controller='post' action="add" id="${networkConnectionInstance?.getFan(request.user)?.id}">Ask Question</g:link> |
	   								<g:link controller='networkConnection' action="removeConnection" id="${networkConnectionInstance?.id}">Remove</g:link> 
	                            </td>

	                        </tr>
	                    </g:each>
	                    </tbody>
	                </table>
	            </div>
	            <div class="paginateButtons">
	                <g:paginate total="${mentorListTotal}" />
	            </div>
		        </g:if>
		        <g:else>
		        	<b>None found.</b>
		        </g:else>
		        <g:link controller="user" action="selectMentor">Select a mentor.</g:link>
		        <br><br>
	            <p><b><u>Mentees</u></b></p><br>
	            <g:if test="${menteeListTotal}">
		            <div class="list">
		                <table>
		                    <thead>
		                        <tr>
		                            <th><g:message code="networkConnection.user.label" default="name" /></th>
	
		                            <th><g:message code="networkConnection.score.label" default="score" /></th>

	                            <th>Action</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    <g:each in="${menteeList}" status="i" var="networkConnectionInstance">
		                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	
		                            <td><g:link controller='memberProfile' action="view" id="${networkConnectionInstance?.user?.id}">${fieldValue(bean: networkConnectionInstance, field: "user")}</g:link></td>
	
		                            <td>${networkConnectionInstance?.user?.score}</td>
	
		                            <td><g:link controller='post' action="privateDirectory" id="${networkConnectionInstance?.user?.id}">Questions (${networkConnectionInstance?.questionCount()})</g:link> | 
		                                <g:link controller='post' action="add" id="${networkConnectionInstance?.getFan(request.user)?.id}">Ask Question</g:link> |
		   								<g:link controller='networkConnection' action="removeConnection" id="${networkConnectionInstance?.id}">Remove</g:link> 
		                            </td>
		                        </tr>
		                    </g:each>
		                    </tbody>
		                </table>
		            </div>
		            <div class="paginateButtons">
		                <g:paginate total="${menteeListTotal}" />
		            </div>
		        </g:if>
		        <g:else>
		        	<b>None found.</b>
		        </g:else>
		        <br><br>
	            <p><b><u>Fans</u></b></p><br>
	            <g:if test="${fanListTotal}">
		            <div class="list">
		                <table>
		                    <thead>
		                        <tr>
		                            <th><g:message code="networkConnection.user.label" default="Fan" /></th>

		                            <th><g:message code="networkConnection.user.label" default="All-Star" /></th>
	
		                            <th><g:message code="networkConnection.score.label" default="score" /></th>
		                            
		                            <th>Action</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    <g:each in="${fanList}" status="i" var="networkConnectionInstance">
		                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
	
		                            <td><g:link controller='memberProfile' action="view" id="${networkConnectionInstance?.user?.id}">${fieldValue(bean: networkConnectionInstance, field: "user")}</g:link></td>

		                            <td><g:link controller='memberProfile' action="view" id="${networkConnectionInstance?.friend?.id}">${fieldValue(bean: networkConnectionInstance, field: "friend")}</g:link></td>
	
		                            <td>${networkConnectionInstance?.friend?.score}</td>
	
	                            <td><g:link controller='post' action="privateDirectory" id="${networkConnectionInstance?.friend?.id}">Questions (${networkConnectionInstance?.questionCount()})</g:link> | 
	                                <g:link controller='post' action="add" id="${networkConnectionInstance?.getFan(request.user)?.id}">Ask Question</g:link> |
	   								<g:link controller='networkConnection' action="removeConnection" id="${networkConnectionInstance?.id}">Remove</g:link> 
	                            </td>

		                        </tr>
		                    </g:each>
		                    </tbody>
		                </table>
		            </div>
		            <div class="paginateButtons">
		                <g:paginate total="${fanListTotal}" />
		            </div>
		        </div>
	        </g:if>
	        <g:else>
	        	<b>None found.</b>
	        </g:else>
	      </div>
    </body>
</html>
