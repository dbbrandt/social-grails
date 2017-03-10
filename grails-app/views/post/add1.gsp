
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Question</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${postInstance}">
            <div class="errors">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="add" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="post.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" size="80" maxlength="120" value="${postInstance?.title}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="member"><g:message code="post.member.label" default="Member" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'member', 'errors')}">
                                    <g:select name="member.id" from="${request.user.fanList()}" optionKey="id" value="${postInstance?.member?.id}" noSelection="['null': 'Public']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="post.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: postInstance, field: 'description', 'errors')}">
                                    <fckeditor:editor name="description" width="500" height="300" toolbar="Basic"><%=postInstance?.description%></fckeditor:editor>							
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="Submit" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
