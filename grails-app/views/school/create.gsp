
<%@ page import="com.esm.esmzone.School" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'school.label', default: 'School')}" />
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
            <g:hasErrors bean="${schoolInstance}">
            <div class="errors">
                <g:renderErrors bean="${schoolInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address"><g:message code="school.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolInstance, field: 'address', 'errors')}">
                                    <g:select name="address.id" from="${com.esm.esmzone.Address.list()}" optionKey="id" value="${schoolInstance?.address?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="school.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${schoolInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="school.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${schoolInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="school.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${schoolInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="type"><g:message code="school.type.label" default="Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: schoolInstance, field: 'type', 'errors')}">
                                    <g:select name="type" from="${com.esm.esmzone.SchoolType?.values()}" value="${schoolInstance?.type}"  />
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
