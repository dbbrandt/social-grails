
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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
	        <g:form action="admin" method="post"> 
	                    Email search:
						<g:textField name="email" value="${params?.email}" />
	                	<g:submitButton class="formButton" name="sports" value="Update"></g:submitButton>					
	        </g:form>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'user.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="login" title="${message(code: 'user.login.label', default: 'Login')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'user.password.label', default: 'Password')}" />
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'user.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="lastName" title="${message(code: 'user.lastName.label', default: 'Last Name')}" />
                        
                            <g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}" />
                        
                            <g:sortableColumn property="birthdate" title="${message(code: 'user.birthdate.label', default: 'Birthdate')}" />
                        
                            <g:sortableColumn property="email" title="${message(code: 'user.email.label', default: 'Email')}" />
                        
                            <th><g:message code="user.memberProfile.label" default="Member Profile" /></th>
                   	    
                            <th><g:message code="user.address.label" default="Address" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: userInstance, field: "login")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "password")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "lastName")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "gender")}</td>
                        
                            <td><g:formatDate date="${userInstance.birthdate}" /></td>
                        
                            <td>${fieldValue(bean: userInstance, field: "email")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "memberProfile")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "address")}</td>
                        
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
