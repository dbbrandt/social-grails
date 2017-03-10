
<%@ page import="com.esm.esmzone.Reference" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'reference.label', default: 'Reference')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${referenceInstance}">
            <div class="errors">
                <g:renderErrors bean="${referenceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${referenceInstance?.id}" />
                <g:hiddenField name="version" value="${referenceInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="reference.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${referenceInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="sequence"><g:message code="reference.sequence.label" default="Sequence" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'sequence', 'errors')}">
                                    <g:textField name="sequence" value="${fieldValue(bean: referenceInstance, field: 'sequence')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="reference.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.esmzone.ReferenceStatus?.values()}" value="${referenceInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="firstName"><g:message code="reference.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${referenceInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastName"><g:message code="reference.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${referenceInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="relationship"><g:message code="reference.relationship.label" default="Relationship" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'relationship', 'errors')}">
                                    <g:textField name="relationship" value="${referenceInstance?.relationship}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="reference.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${referenceInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="application"><g:message code="reference.application.label" default="Application" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'application', 'errors')}">
                                    <g:select name="application.id" from="${com.esm.esmzone.MentorApplication.list()}" optionKey="id" value="${referenceInstance?.application?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="reference.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${referenceInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="approved"><g:message code="reference.approved.label" default="Approved" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'approved', 'errors')}">
                                    <g:checkBox name="approved" value="${referenceInstance?.approved}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="reference.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: referenceInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${referenceInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
