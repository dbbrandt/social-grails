
<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
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
            <g:hasErrors bean="${mentorApplicationInstance}">
            <div class="errors">
                <g:renderErrors bean="${mentorApplicationInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${mentorApplicationInstance?.id}" />
                <g:hiddenField name="version" value="${mentorApplicationInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="mentorApplication.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.esmzone.ApplicationStatus?.values()}" value="${mentorApplicationInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="quiz"><g:message code="mentorApplication.quiz.label" default="Quiz" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'quiz', 'errors')}">
                                    <g:select name="quiz.id" from="${com.esm.esmzone.MentorQuiz.list()}" optionKey="id" value="${mentorApplicationInstance?.quiz?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="references"><g:message code="mentorApplication.references.label" default="References" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'references', 'errors')}">
                                    
<ul>
<g:each in="${mentorApplicationInstance?.references?}" var="r">
    <li><g:link controller="reference" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="reference" action="create" params="['mentorApplication.id': mentorApplicationInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'reference.label', default: 'Reference')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="mentor"><g:message code="mentorApplication.mentor.label" default="Mentor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'mentor', 'errors')}">
                                    <g:select name="mentor.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${mentorApplicationInstance?.mentor?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="mentorApplication.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${mentorApplicationInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="mentorApplication.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: mentorApplicationInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${mentorApplicationInstance?.dateCreated}"  />
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
