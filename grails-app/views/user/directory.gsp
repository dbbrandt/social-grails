
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Member Directory</title>
    </head>
    <body>
        <div class="body">
            <h1>Member List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>

                            <g:sortableColumn property="firstName" title="${message(code: 'user.firstName.label', default: 'First Name')}" />
                        
                           	<g:if test="${request?.user}">
                            	<g:sortableColumn property="lastName" title="${message(code: 'user.lastName.label', default: 'Last Name')}" />
								<th>Avatar</th>                        
	                            <th>City</th>
	                        </g:if>
	                        <g:else>
	                            <th>State</td>
	                        </g:else>
	                        
	                        <g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}" />
							
                            <g:sortableColumn property="memberProfile.grade" title="${message(code: 'memberProfile.playedSports.label', default: 'Grade')}" />

                            <th>Sports Played</th>

                           	<g:if test="${request?.user}">
	                            <g:sortableColumn property="user.mentor" title="${message(code: 'user.mentor.label', default: 'Mentor')}" />
	
	                            <g:sortableColumn property="averageRating" title="${message(code: 'user.rating.label', default: 'Mentor Rating')}" />
	
	                            <g:sortableColumn property="user.fan" title="${message(code: 'user.fan.label', default: 'Fan')}" />
	                        </g:if>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                           	<g:if test="${request?.user}">
	                            <td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "firstName")}</g:link></td>
                        
    	                        <td>${fieldValue(bean: userInstance, field: "lastName")}</td>

								<td><img width="32px" height="32px" src="${userInstance.avatarFile()}"/></td>
	
	                            <td>${userInstance?.address?.city}, ${userInstance?.address?.state}</td>
        					</g:if>
        					<g:else>
	                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
        					
        					    <td>${userInstance?.address?.state}</td>
        					</g:else>
                        
                            <td>${fieldValue(bean: userInstance, field: "gender")}</td>

                            <td>${userInstance?.memberProfile?.grade}</td>

                            <td>${userInstance?.memberProfile?.playedSports}</td>

                           	<g:if test="${request?.user}">
								<td>
								<g:if test="${request?.user.myMentor(userInstance)}">
									My Mentor
								</g:if>
								<g:elseif test="${request?.user.pendingMentor(userInstance)}">
									Requested
								</g:elseif>
								<g:elseif test="${request?.user.myMentee(userInstance)}">
									My Mentee
								</g:elseif>
								<g:elseif test="${userInstance == request.user}">
									-
								</g:elseif>
								<g:elseif test="${userInstance.isMentor}">
	                            	<g:link controller="networkConnection" action="requestMentor" id="${userInstance.id}">Select</g:link>
	                            </g:elseif>
	                            </td>
	    
	    						<g:if test="${userInstance.isMentor}">
		                            <td>${fieldValue(bean: userInstance, field: "averageRating")}</td>
	                        	</g:if>
	                        	<g:else>
	                        		<td>&nbsp;</td>
	                        	</g:else>
    
	                            <td>
								<g:if test="${userInstance.isFan(request.user)}">
								 	My Fan
								</g:if>
								<g:elseif test="${userInstance.pendingFan(request.user)}">
								 	Requested
								</g:elseif>
								<g:elseif test="${userInstance.amFan(request.user)}">
								 	Their Fan
								</g:elseif>
								<g:elseif test="${userInstance == request.user}">
									-
								</g:elseif>
								<g:else>
	                            	<g:link controller="networkConnection" action="requestFan" id="${userInstance.id}">Request</g:link>
								</g:else>
	                           	</td>

							</g:if>    
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userInstanceTotal}" />
            </div>
            
        </div>
    </body>
</html>
