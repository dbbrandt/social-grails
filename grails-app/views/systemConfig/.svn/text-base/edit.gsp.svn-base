
<%@ page import="com.esm.esmzone.SystemConfig" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'systemConfig.label', default: 'SystemConfig')}" />
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
            <g:hasErrors bean="${systemConfigInstance}">
            <div class="errors">
                <g:renderErrors bean="${systemConfigInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${systemConfigInstance?.id}" />
                <g:hiddenField name="version" value="${systemConfigInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="showPendingContent"><g:message code="systemConfig.showPendingContent.label" default="Show Pending Content" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'showPendingContent', 'errors')}">
                                    <g:checkBox name="showPendingContent" value="${systemConfigInstance?.showPendingContent}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="modifiedBy"><g:message code="systemConfig.modifiedBy.label" default="Modified By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'modifiedBy', 'errors')}">
                                    <g:select name="modifiedBy.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${systemConfigInstance?.modifiedBy?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="regEmailOn"><g:message code="systemConfig.regEmailOn.label" default="Reg Email On" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'regEmailOn', 'errors')}">
                                    <g:checkBox name="regEmailOn" value="${systemConfigInstance?.regEmailOn}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="avatarFilePath"><g:message code="systemConfig.avatarFilePath.label" default="Avatar File Path" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'avatarFilePath', 'errors')}">
                                    <g:textField name="avatarFilePath" value="${systemConfigInstance?.avatarFilePath}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="avatarUrl"><g:message code="systemConfig.avatarUrl.label" default="Avatar Url" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'avatarUrl', 'errors')}">
                                    <g:textField name="avatarUrl" value="${systemConfigInstance?.avatarUrl}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="questionPromotion"><g:message code="systemConfig.questionPromotion.label" default="Question Promotion" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'questionPromotion', 'errors')}">
                                    <g:select name="questionPromotion.id" from="${com.esm.promotion.QuestionPromotion.list()}" optionKey="id" value="${systemConfigInstance?.questionPromotion?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="defaultSource"><g:message code="systemConfig.defaultSource.label" default="Default Source" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'defaultSource', 'errors')}">
                                    <g:select name="defaultSource.id" from="${com.esm.esmzone.Source.list()}" optionKey="id" value="${systemConfigInstance?.defaultSource?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="systemConfig.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${systemConfigInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="systemConfig.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: systemConfigInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${systemConfigInstance?.lastUpdated}"  />
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
