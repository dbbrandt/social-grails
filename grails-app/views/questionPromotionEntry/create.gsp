
<%@ page import="com.esm.promotion.QuestionPromotionEntry" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry')}" />
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
            <g:hasErrors bean="${questionPromotionEntryInstance}">
            <div class="errors">
                <g:renderErrors bean="${questionPromotionEntryInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="response"><g:message code="questionPromotionEntry.response.label" default="Response" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'response', 'errors')}">
                                    <g:select name="response.id" from="${com.esm.survey.Response.list()}" optionKey="id" value="${questionPromotionEntryInstance?.response?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="result"><g:message code="questionPromotionEntry.result.label" default="Result" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'result', 'errors')}">
                                    <g:select name="result" from="${com.esm.promotion.PromotionEntryResult?.values()}" value="${questionPromotionEntryInstance?.result}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateFulfilled"><g:message code="questionPromotionEntry.dateFulfilled.label" default="Date Fulfilled" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'dateFulfilled', 'errors')}">
                                    <g:datePicker name="dateFulfilled" precision="day" value="${questionPromotionEntryInstance?.dateFulfilled}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateNotified"><g:message code="questionPromotionEntry.dateNotified.label" default="Date Notified" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'dateNotified', 'errors')}">
                                    <g:datePicker name="dateNotified" precision="day" value="${questionPromotionEntryInstance?.dateNotified}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="active"><g:message code="questionPromotionEntry.active.label" default="Active" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'active', 'errors')}">
                                    <g:checkBox name="active" value="${questionPromotionEntryInstance?.active}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answersToWin"><g:message code="questionPromotionEntry.answersToWin.label" default="Answers To Win" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'answersToWin', 'errors')}">
                                    <g:textField name="answersToWin" value="${fieldValue(bean: questionPromotionEntryInstance, field: 'answersToWin')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="questionPromotionEntry.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${questionPromotionEntryInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="fulfilled"><g:message code="questionPromotionEntry.fulfilled.label" default="Fulfilled" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'fulfilled', 'errors')}">
                                    <g:checkBox name="fulfilled" value="${questionPromotionEntryInstance?.fulfilled}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="questionPromotionEntry.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${questionPromotionEntryInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="notified"><g:message code="questionPromotionEntry.notified.label" default="Notified" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'notified', 'errors')}">
                                    <g:checkBox name="notified" value="${questionPromotionEntryInstance?.notified}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="promotion"><g:message code="questionPromotionEntry.promotion.label" default="Promotion" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'promotion', 'errors')}">
                                    <g:select name="promotion.id" from="${com.esm.promotion.QuestionPromotion.list()}" optionKey="id" value="${questionPromotionEntryInstance?.promotion?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="questionPromotionEntry.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionEntryInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${questionPromotionEntryInstance?.user?.id}"  />
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
