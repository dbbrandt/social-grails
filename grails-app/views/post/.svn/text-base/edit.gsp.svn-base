
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
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
            <g:hasErrors bean="${postInstance}">
            <div class="errors">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${postInstance?.id}" />
                <g:hiddenField name="version" value="${postInstance?.version}" />
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
                                  <label for="answers"><g:message code="post.answers.label" default="Answers" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'answers', 'errors')}">
                                    
<ul>
<g:each in="${postInstance?.answers?}" var="a">
    <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="answer" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'answer.label', default: 'Answer')])}</g:link>

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
                                  <label for="tags"><g:message code="post.tags.label" default="Tags" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'tags', 'errors')}">
                                    
<ul>
<g:each in="${postInstance?.tags?}" var="t">
    <li><g:link controller="postTag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="postTag" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'postTag.label', default: 'PostTag')])}</g:link>

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
                                  <label for="comments"><g:message code="post.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'comments', 'errors')}">
                                    
<ul>
<g:each in="${postInstance?.comments?}" var="c">
    <li><g:link controller="postComment" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="postComment" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'postComment.label', default: 'PostComment')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ratings"><g:message code="post.ratings.label" default="Ratings" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'ratings', 'errors')}">
                                    
<ul>
<g:each in="${postInstance?.ratings?}" var="r">
    <li><g:link controller="postRating" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="postRating" action="create" params="['post.id': postInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'postRating.label', default: 'PostRating')])}</g:link>

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
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
