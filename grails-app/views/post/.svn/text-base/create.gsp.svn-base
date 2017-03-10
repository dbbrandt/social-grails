
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
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
            <g:hasErrors bean="${postInstance}">
            <div class="errors">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="post.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'title', 'errors')}">
                                    <g:textArea name="title" cols="40" rows="5" value="${postInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="member"><g:message code="post.member.label" default="Member" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'member', 'errors')}">
                                    <g:select name="member.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${postInstance?.member?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="complaint"><g:message code="post.complaint.label" default="Complaint" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'complaint', 'errors')}">
                                    <g:select name="complaint.id" from="${com.esm.dialog.Complaint.list()}" optionKey="id" value="${postInstance?.complaint?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="post.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'description', 'errors')}">
                                    <g:textArea name="description" cols="40" rows="5" value="${postInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="bestAnswer"><g:message code="post.bestAnswer.label" default="Best Answer" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'bestAnswer', 'errors')}">
                                    <g:select name="bestAnswer.id" from="${com.esm.dialog.Answer.list()}" optionKey="id" value="${postInstance?.bestAnswer?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="averageRating"><g:message code="post.averageRating.label" default="Average Rating" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'averageRating', 'errors')}">
                                    <g:textField name="averageRating" value="${fieldValue(bean: postInstance, field: 'averageRating')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="score"><g:message code="post.score.label" default="Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'score', 'errors')}">
                                    <g:textField name="score" value="${fieldValue(bean: postInstance, field: 'score')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author"><g:message code="post.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${postInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="postType"><g:message code="post.postType.label" default="Post Type" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'postType', 'errors')}">
                                    <g:select name="postType.id" from="${com.esm.dialog.PostType.list()}" optionKey="id" value="${postInstance?.postType?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ratingCount"><g:message code="post.ratingCount.label" default="Rating Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'ratingCount', 'errors')}">
                                    <g:textField name="ratingCount" value="${fieldValue(bean: postInstance, field: 'ratingCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="post.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${postInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answerCount"><g:message code="post.answerCount.label" default="Answer Count" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'answerCount', 'errors')}">
                                    <g:textField name="answerCount" value="${fieldValue(bean: postInstance, field: 'answerCount')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="post.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${postInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answerScore"><g:message code="post.answerScore.label" default="Answer Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'answerScore', 'errors')}">
                                    <g:textField name="answerScore" value="${fieldValue(bean: postInstance, field: 'answerScore')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="myRating"><g:message code="post.myRating.label" default="My Rating" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'myRating', 'errors')}">
                                    <g:textField name="myRating" value="${fieldValue(bean: postInstance, field: 'myRating')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pointsDetail"><g:message code="post.pointsDetail.label" default="Points Detail" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'pointsDetail', 'errors')}">
                                    
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
