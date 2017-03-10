
<%@ page import="com.esm.cms.ContentPage" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentPage.label', default: 'ContentPage')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    	<br>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="list" action="togglePendingMode">
            <g:if test="${pendingMode}">
            	Hide Pending Content (Pending is On) 
            </g:if>
            <g:else>
            	Show Pending Content
            </g:else>
            </g:link></span>
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

                            <g:sortableColumn property="id" title="${message(code: 'contentPage.id.label', default: 'Id')}" />

                            <g:sortableColumn property="name" title="${message(code: 'contentPage.name.label', default: 'Name')}" />
                   	    
                            <g:sortableColumn property="view" title="${message(code: 'contentPage.view.label', default: 'View')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'contentPage.status.label', default: 'Status')}" />

                            <th><g:message code="contentPage.sectionCount.label" default="Sections" /></th>

                            <g:sortableColumn property="description" title="${message(code: 'contentPage.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="content" title="${message(code: 'contentPage.content.label', default: 'Content')}" />
                        
                            <th><g:message code="contentPage.template.label" default="Template" /></th>

                            <g:sortableColumn property="dateCreated" title="${message(code: 'contentPage.dateCreated.label', default: 'Date Created')}" />
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'contentPage.lastUpdated.label', default: 'Last Updated')}" />

                            <th><g:message code="contentPage.author.label" default="Author" /></th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${contentPageInstanceList}" status="i" var="contentPageInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${contentPageInstance.id}">${fieldValue(bean: contentPageInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: contentPageInstance, field: "name")}</td>

                            <td>${fieldValue(bean: contentPageInstance, field: "view")}</td>
                        
                            <td>${fieldValue(bean: contentPageInstance, field: "status")}</td>

                            <td>${contentPageInstance?.sections.size()}</td>

                            <td>${fieldValue(bean: contentPageInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: contentPageInstance, field: "content")}</td>
                        
                            <td>${fieldValue(bean: contentPageInstance, field: "template")}</td>
                        
                            <td><g:formatDate date="${contentPageInstance.dateCreated}" /></td>
                        
                            <td><g:formatDate date="${contentPageInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: contentPageInstance, field: "author")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${contentPageInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
