
<%@ page import="com.esm.esmzone.Points" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'points.label', default: 'Points')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${pointsInstance}">
            <div class="errors">
                <g:renderErrors bean="${pointsInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="points"><g:message code="points.points.label" default="Points" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsInstance, field: 'points', 'errors')}">
                                    <g:textField name="points" value="${fieldValue(bean: pointsInstance, field: 'points')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type"><g:message code="points.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsInstance, field: 'type', 'errors')}">
                                    <g:select name="type.id" from="${com.esm.esmzone.PointsType.list()}" optionKey="id" value="${pointsInstance?.type?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="points.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${pointsInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
