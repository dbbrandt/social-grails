
<%@ page import="com.esm.promotion.QuestionPromotion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotion.label', default: 'QuestionPromotion')}" />
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
            <g:hasErrors bean="${questionPromotionInstance}">
            <div class="errors">
                <g:renderErrors bean="${questionPromotionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="questionPromotion.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${questionPromotionInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="questionPromotion.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'description', 'errors')}">
                                    <g:textField name="description" value="${questionPromotionInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="quota"><g:message code="questionPromotion.quota.label" default="Quota" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'quota', 'errors')}">
                                    <g:textField name="quota" value="${fieldValue(bean: questionPromotionInstance, field: 'quota')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="remainingQuota"><g:message code="questionPromotion.remainingQuota.label" default="Remaining Quota" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'remainingQuota', 'errors')}">
                                    <g:textField name="remainingQuota" value="${fieldValue(bean: questionPromotionInstance, field: 'remainingQuota')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="startDate"><g:message code="questionPromotion.startDate.label" default="Start Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'startDate', 'errors')}">
                                    <g:datePicker name="startDate" precision="day" value="${questionPromotionInstance?.startDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="endDate"><g:message code="questionPromotion.endDate.label" default="End Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'endDate', 'errors')}">
                                    <g:datePicker name="endDate" precision="day" value="${questionPromotionInstance?.endDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="survey"><g:message code="questionPromotion.survey.label" default="Survey" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'survey', 'errors')}">
                                    <g:select name="survey.id" from="${com.esm.survey.Survey.list()}" optionKey="id" value="${questionPromotionInstance?.survey?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="currentQuestion"><g:message code="questionPromotion.currentQuestion.label" default="Current Question" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'currentQuestion', 'errors')}">
                                    <g:select name="currentQuestion.id" from="${com.esm.survey.Question.list()}" optionKey="id" value="${questionPromotionInstance?.currentQuestion?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="currentQuestionDate"><g:message code="questionPromotion.currentQuestionDate.label" default="Current Question Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'currentQuestionDate', 'errors')}">
                                    <g:datePicker name="currentQuestionDate" precision="day" value="${questionPromotionInstance?.currentQuestionDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="correctMessage"><g:message code="questionPromotion.correctMessage.label" default="Correct Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'correctMessage', 'errors')}">
                                    <g:textField name="correctMessage" value="${questionPromotionInstance?.correctMessage}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="incorrectMessage"><g:message code="questionPromotion.incorrectMessage.label" default="Incorrect Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'incorrectMessage', 'errors')}">
                                    <g:textField name="incorrectMessage" value="${questionPromotionInstance?.incorrectMessage}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="winningMessage"><g:message code="questionPromotion.winningMessage.label" default="Winning Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'winningMessage', 'errors')}">
                                    <g:textField name="winningMessage" value="${questionPromotionInstance?.winningMessage}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="loggedInCreative"><g:message code="questionPromotion.loggedInCreative.label" default="Logged In Creative" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'loggedInCreative', 'errors')}">
                                    <g:textField name="loggedInCreative" value="${questionPromotionInstance?.loggedInCreative}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="loggedOutCreative"><g:message code="questionPromotion.loggedOutCreative.label" default="Logged Out Creative" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'loggedOutCreative', 'errors')}">
                                    <g:textField name="loggedOutCreative" value="${questionPromotionInstance?.loggedOutCreative}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answersToWin"><g:message code="questionPromotion.answersToWin.label" default="Answers To Win" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'answersToWin', 'errors')}">
                                    <g:textField name="answersToWin" value="${fieldValue(bean: questionPromotionInstance, field: 'answersToWin')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="questionPromotion.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${questionPromotionInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="daysToWin"><g:message code="questionPromotion.daysToWin.label" default="Days To Win" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'daysToWin', 'errors')}">
                                    <g:textField name="daysToWin" value="${fieldValue(bean: questionPromotionInstance, field: 'daysToWin')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="questionPromotion.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${questionPromotionInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="notAvailableMessage"><g:message code="questionPromotion.notAvailableMessage.label" default="Not Available Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'notAvailableMessage', 'errors')}">
                                    <g:textField name="notAvailableMessage" value="${questionPromotionInstance?.notAvailableMessage}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="questionPromotion.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: questionPromotionInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.promotion.PromotionStatus?.values()}" value="${questionPromotionInstance?.status}"  />
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
