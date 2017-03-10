
<%@ page import="com.esm.cms.ContentPage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentPage.label', default: 'ContentPage')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <resource:richTextEditor type="full"/>
        <br>
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
            <g:hasErrors bean="${contentPageInstance}">
            <div class="errors">
                <g:renderErrors bean="${contentPageInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${contentPageInstance?.id}" />
                <g:hiddenField name="version" value="${contentPageInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                           
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="contentPage.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" cols="60" value="${contentPageInstance?.name}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="view"><g:message code="contentPage.view.label" default="View" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'view', 'errors')}">
                                    <g:textField name="view" value="${contentPageInstance?.view}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="contentPage.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${com.esm.cms.ContentStatus?.values()}" value="${contentPageInstance?.status}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="description"><g:message code="contentPage.description.label" default="Description" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'description', 'errors')}">
                                    <g:textField style="width:670px" name="description" cols="40" rows="5" value="${contentPageInstance?.description}" />
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="template"><g:message code="contentPage.template.label" default="Template" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'template', 'errors')}">
                                    <g:select name="template.id" from="${com.esm.cms.ContentTemplate.list()}" optionKey="id" value="${contentPageInstance?.template?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="content"><g:message code="contentPage.content.label" default="Content" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'content', 'errors')}">
                                    <richui:richTextEditor name="content" value="${contentPageInstance?.content}" width="600" height="600"/>
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="sections"><g:message code="contentPage.sections.label" default="Sections" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'sections', 'errors')}">
                                    
								<ul>
								<g:each in="${contentPageInstance?.sections?}" var="s">
								    <li><g:link controller="contentSection" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
								</g:each>
								</ul>
								<g:link controller="contentSection" action="create" params="['contentPage.id': contentPageInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'contentSection.label', default: 'ContentSection')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="contentPage.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${contentPageInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="contentPage.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${contentPageInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="author"><g:message code="contentPage.author.label" default="Author" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: contentPageInstance, field: 'author', 'errors')}">
                                    <g:select name="author.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${contentPageInstance?.author?.id}"  />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <g:if test="${(contentPageInstance.status != com.esm.cms.ContentStatus.ACTIVE)}">
                    	<span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                	</g:if>
                </div>
            </g:form>
        </div>
    </body>
</html>
