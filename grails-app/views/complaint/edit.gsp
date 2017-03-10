
<%@ page import="com.esm.dialog.Complaint" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'complaint.label', default: 'Complaint')}" />
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
            <g:hasErrors bean="${complaintInstance}">
            <div class="errors">
                <g:renderErrors bean="${complaintInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${complaintInstance?.id}" />
                <g:hiddenField name="version" value="${complaintInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="complaint.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${complaintInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="content"><g:message code="complaint.content.label" default="Content" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'content', 'errors')}">
                                    <g:textField name="content" value="${complaintInstance?.content}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="message"><g:message code="complaint.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'message', 'errors')}">
                                    <g:textField name="message" value="${complaintInstance?.message}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="complaint.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.dialog.ComplaintStatus?.values()}" value="${complaintInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="contentId"><g:message code="complaint.contentId.label" default="Content Id" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'contentId', 'errors')}">
                                    <g:textField name="contentId" value="${fieldValue(bean: complaintInstance, field: 'contentId')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="type"><g:message code="complaint.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'type', 'errors')}">
                                    <g:select name="type" from="${com.esm.dialog.ContentType?.values()}" value="${complaintInstance?.type}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="reason"><g:message code="complaint.reason.label" default="Reason" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'reason', 'errors')}">
                                    <g:select name="reason" from="${com.esm.dialog.ComplaintType?.values()}" value="${complaintInstance?.reason}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="complaint.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${complaintInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="complaint.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: complaintInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${complaintInstance?.dateCreated}"  />
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
