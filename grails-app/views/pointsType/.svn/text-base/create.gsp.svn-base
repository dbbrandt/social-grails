
<%@ page import="com.esm.esmzone.PointsType" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'pointsType.label', default: 'PointsType')}" />
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
            <g:hasErrors bean="${pointsTypeInstance}">
            <div class="errors">
                <g:renderErrors bean="${pointsTypeInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="pointsType.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${pointsTypeInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="pointsType.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${pointsTypeInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="points"><g:message code="pointsType.points.label" default="Points" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'points', 'errors')}">
                                    <g:textField name="points" value="${fieldValue(bean: pointsTypeInstance, field: 'points')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bonusCount"><g:message code="pointsType.bonusCount.label" default="Bonus Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'bonusCount', 'errors')}">
                                    <g:textField name="bonusCount" value="${fieldValue(bean: pointsTypeInstance, field: 'bonusCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="pointsType.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${pointsTypeInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="pointsType.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${pointsTypeInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bonusPoints"><g:message code="pointsType.bonusPoints.label" default="Bonus Points" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: pointsTypeInstance, field: 'bonusPoints', 'errors')}">
                                    <g:textField name="bonusPoints" value="${fieldValue(bean: pointsTypeInstance, field: 'bonusPoints')}" />
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
