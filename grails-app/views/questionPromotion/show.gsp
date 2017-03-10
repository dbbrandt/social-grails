
<%@ page import="com.esm.promotion.QuestionPromotion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotion.label', default: 'QuestionPromotion')}" />
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
                            <td valign="top" class="name"><g:message code="questionPromotion.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.description.label" default="Description" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "description")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.quota.label" default="Quota" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "quota")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.remainingQuota.label" default="Remaining Quota" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "remainingQuota")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.startDate.label" default="Start Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionInstance?.startDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.endDate.label" default="End Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionInstance?.endDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.survey.label" default="Survey" /></td>
                            
                            <td valign="top" class="value"><g:link controller="survey" action="show" id="${questionPromotionInstance?.survey?.id}">${questionPromotionInstance?.survey?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.currentQuestion.label" default="Current Question" /></td>
                            
                            <td valign="top" class="value"><g:link controller="question" action="show" id="${questionPromotionInstance?.currentQuestion?.id}">${questionPromotionInstance?.currentQuestion?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.currentQuestionDate.label" default="Current Question Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionInstance?.currentQuestionDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.correctMessage.label" default="Correct Message" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "correctMessage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.incorrectMessage.label" default="Incorrect Message" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "incorrectMessage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.winningMessage.label" default="Winning Message" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "winningMessage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.loggedInCreative.label" default="Logged In Creative" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "loggedInCreative")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.loggedOutCreative.label" default="Logged Out Creative" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "loggedOutCreative")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.answersToWin.label" default="Answers To Win" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "answersToWin")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.daysToWin.label" default="Days To Win" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "daysToWin")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.entries.label" default="Entries" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${questionPromotionInstance.entries}" var="e">
                                    <li><g:link controller="questionPromotionEntry" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${questionPromotionInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.notAvailableMessage.label" default="Not Available Message" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: questionPromotionInstance, field: "notAvailableMessage")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="questionPromotion.status.label" default="Status" /></td>
                            
                            <td valign="top" class="value">${questionPromotionInstance?.status?.encodeAsHTML()}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${questionPromotionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
