
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
            <h1>Edit Question</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${postInstance}">
            <div class="errors">
                <g:renderErrors bean="${postInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="modify" method="post" >
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
                                    <g:if test="${postInstance.answers}">
                                    	${postInstance?.title}
                                    </g:if>
                                    <g:else>
                                    	<g:textField name="title" size="80" maxlength="120" value="${postInstance?.title}" />
                                    </g:else>
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
                                    <g:if test="${postInstance.answers}">
                                    	${postInstance?.description}
                                    </g:if>
                                    <g:else>
	                                    <fckeditor:editor name="description" width="500" height="300" toolbar="Basic"><%=postInstance.description%></fckeditor:editor>							
                                    </g:else>
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
