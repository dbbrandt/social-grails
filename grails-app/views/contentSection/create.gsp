
<%@ page import="com.esm.cms.ContentSection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentSection.label', default: 'ContentSection')}" />
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
            <g:hasErrors bean="${contentSectionInstance}">
            <div class="errors">
                <g:renderErrors bean="${contentSectionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="contentSection.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" maxlength="20" value="${contentSectionInstance?.name}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="page"><g:message code="contentSection.page.label" default="Page" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'page', 'errors')}">
                                    <g:select name="page.id" from="${com.esm.cms.ContentPage.list()}" optionKey="id" value="${contentSectionInstance?.page?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title"><g:message code="contentSection.title.label" default="Title" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'title', 'errors')}">
                                    <g:textField name="title" maxlength="60" value="${contentSectionInstance?.title}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="sequence"><g:message code="contentSection.sequence.label" default="Sequence" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'sequence', 'errors')}">
                                    <g:textField name="sequence" value="${fieldValue(bean: contentSectionInstance, field: 'sequence')}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="contentSection.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.cms.ContentStatus?.values()}" value="${contentSectionInstance?.status}"  />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description"><g:message code="contentSection.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'description', 'errors')}">
                                    <g:textField style="width:670px" name="description" value="${contentSectionInstance?.description}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="template"><g:message code="contentSection.template.label" default="Template" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'template', 'errors')}">
                                    <g:select name="template.id" from="${com.esm.cms.ContentTemplate.list()}" optionKey="id" value="${contentSectionInstance?.template?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="content"><g:message code="contentSection.content.label" default="Content" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'content', 'errors')}">
                                    <richui:richTextEditor name="content" value="${contentSectionInstance?.content}" width="600" height="600"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="dateCreated"><g:message code="contentSection.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${contentSectionInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastUpdated"><g:message code="contentSection.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${contentSectionInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="author"><g:message code="contentSection.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentSectionInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${contentSectionInstance?.author?.id}"  />
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
