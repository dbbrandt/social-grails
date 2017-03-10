
<%@ page import="com.esm.cms.ContentTemplate" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentTemplate.label', default: 'ContentTemplate')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <resource:richTextEditor type="full"/>
		<br>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${contentTemplateInstance}">
            <div class="errors">
                <g:renderErrors bean="${contentTemplateInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author"><g:message code="contentTemplate.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${contentTemplateInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="contentTemplate.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${contentTemplateInstance?.name}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="contentTemplate.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'description', 'errors')}">
                                    <g:textField style="width:670px" name="description" cols="40" rows="5" value="${contentTemplateInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="content"><g:message code="contentTemplate.content.label" default="Content" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'content', 'errors')}">
                                    <richui:richTextEditor name="content" value="${contentTemplateInstance?.content}" width="670" height="600px"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="contentTemplate.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${contentTemplateInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="contentTemplate.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentTemplateInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${contentTemplateInstance?.lastUpdated}"  />
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
