
<%@ page import="com.esm.dialog.Answer" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'answer.label', default: 'Answer')}" />
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
            <g:hasErrors bean="${answerInstance}">
            <div class="errors">
                <g:renderErrors bean="${answerInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${answerInstance?.id}" />
                <g:hiddenField name="version" value="${answerInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="answer.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${answerInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="complaint"><g:message code="answer.complaint.label" default="Complaint" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'complaint', 'errors')}">
                                    <g:select name="complaint.id" from="${com.esm.dialog.Complaint.list()}" optionKey="id" value="${answerInstance?.complaint?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="averageRating"><g:message code="answer.averageRating.label" default="Average Rating" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'averageRating', 'errors')}">
                                    <g:textField name="averageRating" value="${fieldValue(bean: answerInstance, field: 'averageRating')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="post"><g:message code="answer.post.label" default="Post" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'post', 'errors')}">
                                    <g:select name="post.id" from="${com.esm.dialog.Post.list()}" optionKey="id" value="${answerInstance?.post?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ratingCount"><g:message code="answer.ratingCount.label" default="Rating Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'ratingCount', 'errors')}">
                                    <g:textField name="ratingCount" value="${fieldValue(bean: answerInstance, field: 'ratingCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="score"><g:message code="answer.score.label" default="Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'score', 'errors')}">
                                    <g:textField name="score" value="${fieldValue(bean: answerInstance, field: 'score')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="answer.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${answerInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="author"><g:message code="answer.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${answerInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="answer.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${answerInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ratings"><g:message code="answer.ratings.label" default="Ratings" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'ratings', 'errors')}">
                                    
<ul>
<g:each in="${answerInstance?.ratings?}" var="r">
    <li><g:link controller="answerRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="answerRating" action="create" params="['answer.id': answerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answerRating.label', default: 'AnswerRating')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="comments"><g:message code="answer.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'comments', 'errors')}">
                                    
<ul>
<g:each in="${answerInstance?.comments?}" var="c">
    <li><g:link controller="answerComment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="answerComment" action="create" params="['answer.id': answerInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answerComment.label', default: 'AnswerComment')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="myRating"><g:message code="answer.myRating.label" default="My Rating" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'myRating', 'errors')}">
                                    <g:textField name="myRating" value="${fieldValue(bean: answerInstance, field: 'myRating')}" />
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
