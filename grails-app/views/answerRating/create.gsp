
<%@ page import="com.esm.dialog.AnswerRating" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'answerRating.label', default: 'AnswerRating')}" />
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
            <g:hasErrors bean="${answerRatingInstance}">
            <div class="errors">
                <g:renderErrors bean="${answerRatingInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="score"><g:message code="answerRating.score.label" default="Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerRatingInstance, field: 'score', 'errors')}">
                                    <g:textField name="score" value="${fieldValue(bean: answerRatingInstance, field: 'score')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answer"><g:message code="answerRating.answer.label" default="Answer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerRatingInstance, field: 'answer', 'errors')}">
                                    <g:select name="answer.id" from="${com.esm.dialog.Answer.list()}" optionKey="id" value="${answerRatingInstance?.answer?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="user"><g:message code="answerRating.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerRatingInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${answerRatingInstance?.user?.id}"  />
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
