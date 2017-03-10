
<%@ page import="com.esm.cms.ContentTemplate" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentTemplate.label', default: 'ContentTemplate')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    	<br>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'contentTemplate.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'contentTemplate.name.label', default: 'Name')}" />

                            <g:sortableColumn property="description" title="${message(code: 'contentTemplate.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="content" title="${message(code: 'contentTemplate.content.label', default: 'Content')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'contentTemplate.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'contentTemplate.lastUpdated.label', default: 'Last Updated')}" />

                            <th><g:message code="contentTemplate.author.label" default="Author" /></th>
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${contentTemplateInstanceList}" status="i" var="contentTemplateInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${contentTemplateInstance.id}">${fieldValue(bean: contentTemplateInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: contentTemplateInstance, field: "name")}</td>

                            <td>${fieldValue(bean: contentTemplateInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: contentTemplateInstance, field: "content")}</td>
                        
                            <td><g:formatDate date="${contentTemplateInstance.dateCreated}" /></td>
                        
                            <td><g:formatDate date="${contentTemplateInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: contentTemplateInstance, field: "author")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${contentTemplateInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
