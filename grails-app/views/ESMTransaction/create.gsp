
<%@ page import="com.esm.esmzone.ESMTransaction" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'ESMTransaction.label', default: 'ESMTransaction')}" />
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
            <g:hasErrors bean="${ESMTransactionInstance}">
            <div class="errors">
                <g:renderErrors bean="${ESMTransactionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="ESMTransaction.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${ESMTransactionInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="friend"><g:message code="ESMTransaction.friend.label" default="Friend" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'friend', 'errors')}">
                                    <g:select name="friend.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${ESMTransactionInstance?.friend?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="message"><g:message code="ESMTransaction.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'message', 'errors')}">
                                    <g:textField name="message" value="${ESMTransactionInstance?.message}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type"><g:message code="ESMTransaction.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'type', 'errors')}">
                                    <g:select name="type" from="${com.esm.esmzone.ESMTransactionType?.values()}" value="${ESMTransactionInstance?.type}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="cleared"><g:message code="ESMTransaction.cleared.label" default="Cleared" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'cleared', 'errors')}">
                                    <g:checkBox name="cleared" value="${ESMTransactionInstance?.cleared}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="ESMTransaction.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${ESMTransactionInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="ESMTransaction.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: ESMTransactionInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${ESMTransactionInstance?.lastUpdated}"  />
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
