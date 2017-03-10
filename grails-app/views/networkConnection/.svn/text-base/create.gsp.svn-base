
<%@ page import="com.esm.esmzone.NetworkConnection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'networkConnection.label', default: 'NetworkConnection')}" />
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
            <g:hasErrors bean="${networkConnectionInstance}">
            <div class="errors">
                <g:renderErrors bean="${networkConnectionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="networkConnection.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${networkConnectionInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="friend"><g:message code="networkConnection.friend.label" default="Friend" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'friend', 'errors')}">
                                    <g:select name="friend.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${networkConnectionInstance?.friend?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="message"><g:message code="networkConnection.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'message', 'errors')}">
                                    <g:textField name="message" value="${networkConnectionInstance?.message}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type"><g:message code="networkConnection.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'type', 'errors')}">
                                    <g:select name="type" from="${com.esm.esmzone.NetworkConnectionType?.values()}" value="${networkConnectionInstance?.type}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="networkConnection.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.esmzone.NetworkConnectionStatus?.values()}" value="${networkConnectionInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="networkConnection.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${networkConnectionInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="networkConnection.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: networkConnectionInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${networkConnectionInstance?.dateCreated}"  />
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
