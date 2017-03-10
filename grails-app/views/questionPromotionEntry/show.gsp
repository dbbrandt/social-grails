
<%@ page import="com.esm.promotion.QuestionPromotionEntry" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry')}" />
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
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionEntryInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.response.label" default="Response" /></td>
                            
                            <td valign="top" class="value"><g:link controller="response" action="show" id="${questionPromotionEntryInstance?.response?.id}">${questionPromotionEntryInstance?.response?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.result.label" default="Result" /></td>
                            
                            <td valign="top" class="value">${questionPromotionEntryInstance?.result?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.dateFulfilled.label" default="Date Fulfilled" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionEntryInstance?.dateFulfilled}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.dateNotified.label" default="Date Notified" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionEntryInstance?.dateNotified}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.active.label" default="Active" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${questionPromotionEntryInstance?.active}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.answersToWin.label" default="Answers To Win" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionEntryInstance, field: "answersToWin")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionEntryInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.fulfilled.label" default="Fulfilled" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${questionPromotionEntryInstance?.fulfilled}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionEntryInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.notified.label" default="Notified" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${questionPromotionEntryInstance?.notified}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.promotion.label" default="Promotion" /></td>
                            
                            <td valign="top" class="value"><g:link controller="questionPromotion" action="show" id="${questionPromotionEntryInstance?.promotion?.id}">${questionPromotionEntryInstance?.promotion?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotionEntry.user.label" default="User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${questionPromotionEntryInstance?.user?.id}">${questionPromotionEntryInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${questionPromotionEntryInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
