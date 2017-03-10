
<%@ page import="com.esm.esmzone.SystemConfig" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'systemConfig.label', default: 'SystemConfig')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: systemConfigInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.showPendingContent.label" default="Show Pending Content" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${systemConfigInstance?.showPendingContent}" /></td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.modifiedBy.label" default="Modified By" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${systemConfigInstance?.modifiedBy?.id}">${systemConfigInstance?.modifiedBy?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.regEmailOn.label" default="Reg Email On" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${systemConfigInstance?.regEmailOn}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.avatarFilePath.label" default="Avatar File Path" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: systemConfigInstance, field: "avatarFilePath")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.avatarUrl.label" default="Avatar Url" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: systemConfigInstance, field: "avatarUrl")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.questionPromotion.label" default="Question Promotion" /></td>
                            
                            <td valign="top" class="value"><g:link controller="questionPromotion" action="show" id="${systemConfigInstance?.questionPromotion?.id}">${systemConfigInstance?.questionPromotion?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.defaultSource.label" default="Default Source" /></td>
                            
                            <td valign="top" class="value"><g:link controller="source" action="show" id="${systemConfigInstance?.defaultSource?.id}">${systemConfigInstance?.defaultSource?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${systemConfigInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="systemConfig.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${systemConfigInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${systemConfigInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
