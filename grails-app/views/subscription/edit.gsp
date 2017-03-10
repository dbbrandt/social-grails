
<%@ page import="com.esm.esmzone.Subscription" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'subscription.label', default: 'Subscription')}" />
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
            <g:hasErrors bean="${subscriptionInstance}">
            <div class="errors">
                <g:renderErrors bean="${subscriptionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${subscriptionInstance?.id}" />
                <g:hiddenField name="version" value="${subscriptionInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="active"><g:message code="subscription.active.label" default="Active" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'active', 'errors')}">
                                    <g:checkBox name="active" value="${subscriptionInstance?.active}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="startDate"><g:message code="subscription.startDate.label" default="Start Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'startDate', 'errors')}">
                                    <g:datePicker name="startDate" precision="day" value="${subscriptionInstance?.startDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="endDate"><g:message code="subscription.endDate.label" default="End Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'endDate', 'errors')}">
                                    <g:datePicker name="endDate" precision="day" value="${subscriptionInstance?.endDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="firstName"><g:message code="subscription.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${subscriptionInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastName"><g:message code="subscription.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${subscriptionInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="email"><g:message code="subscription.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${subscriptionInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="address"><g:message code="subscription.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'address', 'errors')}">
                                    <g:select name="address.id" from="${com.esm.esmzone.Address.list()}" optionKey="id" value="${subscriptionInstance?.address?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="paymentMethod"><g:message code="subscription.paymentMethod.label" default="Payment Method" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'paymentMethod', 'errors')}">
                                    <g:select name="paymentMethod.id" from="${com.esm.esmzone.PaymentMethod.list()}" optionKey="id" value="${subscriptionInstance?.paymentMethod?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="rate"><g:message code="subscription.rate.label" default="Rate" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'rate', 'errors')}">
                                    <g:textField name="rate" value="${fieldValue(bean: subscriptionInstance, field: 'rate')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="subscriptionType"><g:message code="subscription.subscriptionType.label" default="Subscription Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'subscriptionType', 'errors')}">
                                    <g:select name="subscriptionType.id" from="${com.esm.esmzone.SubscriptionType.list()}" optionKey="id" value="${subscriptionInstance?.subscriptionType?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="subscription.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${subscriptionInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="subscription.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${subscriptionInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="subscriber"><g:message code="subscription.subscriber.label" default="Subscriber" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: subscriptionInstance, field: 'subscriber', 'errors')}">
                                    <g:select name="subscriber.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${subscriptionInstance?.subscriber?.id}"  />
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
