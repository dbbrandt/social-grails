
<%@ page import="com.esm.util.SchoolLoad" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'schoolLoad.label', default: 'SchoolLoad')}" />
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
            <g:hasErrors bean="${schoolLoadInstance}">
            <div class="errors">
                <g:renderErrors bean="${schoolLoadInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${schoolLoadInstance?.id}" />
                <g:hiddenField name="version" value="${schoolLoadInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="schoolLoad.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${schoolLoadInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="type"><g:message code="schoolLoad.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'type', 'errors')}">
                                    <g:select name="type" from="${com.esm.esmzone.SchoolType?.values()}" value="${schoolLoadInstance?.type}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="postalCode"><g:message code="schoolLoad.postalCode.label" default="Postal Code" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'postalCode', 'errors')}">
                                    <g:textField name="postalCode" value="${schoolLoadInstance?.postalCode}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="street"><g:message code="schoolLoad.street.label" default="Street" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'street', 'errors')}">
                                    <g:textField name="street" value="${schoolLoadInstance?.street}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="state"><g:message code="schoolLoad.state.label" default="State" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'state', 'errors')}">
                                    <g:textField name="state" value="${schoolLoadInstance?.state}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="city"><g:message code="schoolLoad.city.label" default="City" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolLoadInstance, field: 'city', 'errors')}">
                                    <g:textField name="city" value="${schoolLoadInstance?.city}" />
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
