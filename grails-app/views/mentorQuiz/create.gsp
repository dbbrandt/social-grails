
<%@ page import="com.esm.esmzone.MentorQuiz" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorQuiz.label', default: 'MentorQuiz')}" />
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
            <g:hasErrors bean="${mentorQuizInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorQuizInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="survey"><g:message code="mentorQuiz.survey.label" default="Survey" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorQuizInstance, field: 'survey', 'errors')}">
                                    <g:select name="survey.id" from="${com.esm.survey.Survey.list()}" optionKey="id" value="${mentorQuizInstance?.survey?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="passed"><g:message code="mentorQuiz.passed.label" default="Passed" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorQuizInstance, field: 'passed', 'errors')}">
                                    <g:checkBox name="passed" value="${mentorQuizInstance?.passed}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="application"><g:message code="mentorQuiz.application.label" default="Application" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorQuizInstance, field: 'application', 'errors')}">
                                    <g:select name="application.id" from="${com.esm.esmzone.MentorApplication.list()}" optionKey="id" value="${mentorQuizInstance?.application?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="mentorQuiz.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorQuizInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${mentorQuizInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="mentorQuiz.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorQuizInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${mentorQuizInstance?.dateCreated}"  />
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
