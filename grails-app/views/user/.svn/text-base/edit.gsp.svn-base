
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
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
            <g:hasErrors bean="${userInstance}">
            <div class="errors">
                <g:renderErrors bean="${userInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${userInstance?.id}" />
                <g:hiddenField name="version" value="${userInstance?.version}" />
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
                                  <label for="roles"><g:message code="user.roles.label" default="Roles" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'roles', 'errors')}">
                                    <g:select name="roles" from="${com.esm.esmzone.Role.list()}" multiple="yes" optionKey="id" size="5" value="${userInstance?.roles}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="permissions"><g:message code="user.permissions.label" default="Permissions" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'permissions', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.permissions?}" var="p">
    <li><g:link controller="permission" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="permission" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'permission.label', default: 'Permission')])}</g:link>

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
                                  <label for="complaints"><g:message code="user.complaints.label" default="Complaints" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'complaints', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.complaints?}" var="c">
    <li><g:link controller="complaint" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="complaint" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'complaint.label', default: 'Complaint')])}</g:link>

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
                                  <label for="fanConnections"><g:message code="user.fanConnections.label" default="Fan Connections" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'fanConnections', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.fanConnections?}" var="f">
    <li><g:link controller="networkConnection" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="networkConnection" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'networkConnection.label', default: 'NetworkConnection')])}</g:link>

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
                                  <label for="myConnections"><g:message code="user.myConnections.label" default="My Connections" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'myConnections', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.myConnections?}" var="m">
    <li><g:link controller="networkConnection" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="networkConnection" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'networkConnection.label', default: 'NetworkConnection')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="subscriptions"><g:message code="user.subscriptions.label" default="Subscriptions" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'subscriptions', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.subscriptions?}" var="s">
    <li><g:link controller="subscription" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="subscription" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'subscription.label', default: 'Subscription')])}</g:link>

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
                                  <label for="pointDetails"><g:message code="user.pointDetails.label" default="Point Details" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'pointDetails', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.pointDetails?}" var="p">
    <li><g:link controller="points" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="points" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'points.label', default: 'Points')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="mentorApplications"><g:message code="user.mentorApplications.label" default="Mentor Applications" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: userInstance, field: 'mentorApplications', 'errors')}">
                                    
<ul>
<g:each in="${userInstance?.mentorApplications?}" var="m">
    <li><g:link controller="mentorApplication" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="mentorApplication" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mentorApplication.label', default: 'MentorApplication')])}</g:link>

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
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
