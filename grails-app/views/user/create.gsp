
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="login"><g:message code="user.login.label" default="Login" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'login', 'errors')}">
                                    <g:textField name="login" maxlength="125" value="${userInstance?.login}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password"><g:message code="user.password.label" default="Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'password', 'errors')}">
                                    <g:textField name="password" value="${userInstance?.password}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstName"><g:message code="user.firstName.label" default="First Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'firstName', 'errors')}">
                                    <g:textField name="firstName" value="${userInstance?.firstName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName"><g:message code="user.lastName.label" default="Last Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'lastName', 'errors')}">
                                    <g:textField name="lastName" value="${userInstance?.lastName}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="gender"><g:message code="user.gender.label" default="Gender" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'gender', 'errors')}">
                                    <g:textField name="gender" value="${userInstance?.gender}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="birthdate"><g:message code="user.birthdate.label" default="Birthdate" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'birthdate', 'errors')}">
                                    <g:datePicker name="birthdate" precision="day" value="${userInstance?.birthdate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email"><g:message code="user.email.label" default="Email" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'email', 'errors')}">
                                    <g:textField name="email" value="${userInstance?.email}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="memberProfile"><g:message code="user.memberProfile.label" default="Member Profile" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'memberProfile', 'errors')}">
                                    <g:select name="memberProfile.id" from="${com.esm.esmzone.MemberProfile.list()}" optionKey="id" value="${userInstance?.memberProfile?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="address"><g:message code="user.address.label" default="Address" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'address', 'errors')}">
                                    <g:select name="address.id" from="${com.esm.esmzone.Address.list()}" optionKey="id" value="${userInstance?.address?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="source"><g:message code="user.source.label" default="Source" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'source', 'errors')}">
                                    <g:select name="source.id" from="${com.esm.esmzone.Source.list()}" optionKey="id" value="${userInstance?.source?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="averageRating"><g:message code="user.averageRating.label" default="Average Rating" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'averageRating', 'errors')}">
                                    <g:textField name="averageRating" value="${fieldValue(bean: userInstance, field: 'averageRating')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="score"><g:message code="user.score.label" default="Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'score', 'errors')}">
                                    <g:textField name="score" value="${fieldValue(bean: userInstance, field: 'score')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="securityQuestion"><g:message code="user.securityQuestion.label" default="Security Question" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'securityQuestion', 'errors')}">
                                    <g:select name="securityQuestion.id" from="${com.esm.esmzone.SecurityQuestion.list()}" optionKey="id" value="${userInstance?.securityQuestion?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="division"><g:message code="user.division.label" default="Division" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'division', 'errors')}">
                                    <g:select name="division" from="${com.esm.esmzone.Division?.values()}" value="${userInstance?.division}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="points"><g:message code="user.points.label" default="Points" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'points', 'errors')}">
                                    <g:textField name="points" value="${fieldValue(bean: userInstance, field: 'points')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="securityAnswer"><g:message code="user.securityAnswer.label" default="Security Answer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'securityAnswer', 'errors')}">
                                    <g:textField name="securityAnswer" value="${userInstance?.securityAnswer}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="user.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.esmzone.UserStatus?.values()}" value="${userInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ratingCount"><g:message code="user.ratingCount.label" default="Rating Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'ratingCount', 'errors')}">
                                    <g:textField name="ratingCount" value="${fieldValue(bean: userInstance, field: 'ratingCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="user.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${userInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="isMentor"><g:message code="user.isMentor.label" default="Is Mentor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'isMentor', 'errors')}">
                                    <g:checkBox name="isMentor" value="${userInstance?.isMentor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answerCount"><g:message code="user.answerCount.label" default="Answer Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'answerCount', 'errors')}">
                                    <g:textField name="answerCount" value="${fieldValue(bean: userInstance, field: 'answerCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="questionCount"><g:message code="user.questionCount.label" default="Question Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'questionCount', 'errors')}">
                                    <g:textField name="questionCount" value="${fieldValue(bean: userInstance, field: 'questionCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="user.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${userInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="isMember"><g:message code="user.isMember.label" default="Is Member" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'isMember', 'errors')}">
                                    <g:textField name="isMember" value="${fieldValue(bean: userInstance, field: 'isMember')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="mentorScore"><g:message code="user.mentorScore.label" default="Mentor Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'mentorScore', 'errors')}">
                                    <g:textField name="mentorScore" value="${fieldValue(bean: userInstance, field: 'mentorScore')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="textPassword"><g:message code="user.textPassword.label" default="Text Password" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'textPassword', 'errors')}">
                                    <g:textField name="textPassword" value="${userInstance?.textPassword}" />
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
