
<%@ page import="com.esm.esmzone.Patron" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'patron.label', default: 'Patron')}" />
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
            <g:hasErrors bean="${patronInstance}">
            <div class="errors">
                <g:renderErrors bean="${patronInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="patron.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" maxlength="125" value="${patronInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="patron.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" value="${patronInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="organizationName"><g:message code="patron.organizationName.label" default="Organization Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'organizationName', 'errors')}">
                                    <g:textField name="organizationName" value="${patronInstance?.organizationName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstName"><g:message code="patron.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${patronInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName"><g:message code="patron.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${patronInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address"><g:message code="patron.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'address', 'errors')}">
                                    <g:select name="address.id" from="${com.esm.esmzone.Address.list()}" optionKey="id" value="${patronInstance?.address?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="source"><g:message code="patron.source.label" default="Source" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'source', 'errors')}">
                                    <g:select name="source.id" from="${com.esm.esmzone.Source.list()}" optionKey="id" value="${patronInstance?.source?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="patron.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.esmzone.PatronStatus?.values()}" value="${patronInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="patron.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${patronInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="securityQuestion"><g:message code="patron.securityQuestion.label" default="Security Question" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'securityQuestion', 'errors')}">
                                    <g:select name="securityQuestion.id" from="${com.esm.esmzone.SecurityQuestion.list()}" optionKey="id" value="${patronInstance?.securityQuestion?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="patron.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${patronInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="securityAnswer"><g:message code="patron.securityAnswer.label" default="Security Answer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'securityAnswer', 'errors')}">
                                    <g:textField name="securityAnswer" value="${patronInstance?.securityAnswer}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="textPassword"><g:message code="patron.textPassword.label" default="Text Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: patronInstance, field: 'textPassword', 'errors')}">
                                    <g:textField name="textPassword" value="${patronInstance?.textPassword}" />
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
