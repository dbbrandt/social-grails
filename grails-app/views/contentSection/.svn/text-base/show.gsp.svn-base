
<%@ page import="com.esm.cms.ContentSection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentSection.label', default: 'ContentSection')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
    	<br>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "name")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.page.label" default="Page" /></td>
                            
                            <td valign="top" class="value"><g:link controller="contentPage" action="show" id="${contentSectionInstance?.page?.id}">${contentSectionInstance?.page?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.title.label" default="Title" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "title")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.sequence.label" default="Sequence" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "sequence")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.status.label" default="Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "status")}</td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.description.label" default="Description" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: contentSectionInstance, field: "description")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.template.label" default="Template" /></td>
                            
                            <td valign="top" class="value"><g:link controller="contentTemplate" action="show" id="${contentSectionInstance?.template?.id}">${contentSectionInstance?.template?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.content.label" default="Content" /></td>
                            
                            <td valign="top" class="value"><%=contentSectionInstance.content%></td>
                            
                        </tr>

                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${contentSectionInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${contentSectionInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                   
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="contentSection.author.label" default="Author" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${contentSectionInstance?.author?.id}">${contentSectionInstance?.author?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${contentSectionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <g:if test="${(contentSectionInstance.status != com.esm.cms.ContentStatus.ACTIVE)}">
	                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                	</g:if>
                </g:form>
            </div>
        </div>
    </body>
</html>
