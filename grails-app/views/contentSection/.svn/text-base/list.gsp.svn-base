
<%@ page import="com.esm.cms.ContentSection" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'contentSection.label', default: 'ContentSection')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'contentSection.id.label', default: 'Id')}" />
                        
                            <th><g:message code="contentSection.page.label" default="Page" /></th>

                            <g:sortableColumn property="name" title="${message(code: 'contentSection.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="sequence" title="${message(code: 'contentSection.sequence.label', default: 'Sequence')}" />

                            <g:sortableColumn property="status" title="${message(code: 'contentSection.status.label', default: 'Status')}" />

                            <g:sortableColumn property="title" title="${message(code: 'contentSection.title.label', default: 'Title')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'contentSection.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="content" title="${message(code: 'contentSection.content.label', default: 'Content')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'contentSection.dateCreated.label', default: 'Date Created')}" />
                            
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'contentSection.lastUpdated.label', default: 'Last Updated')}" />

                            <th><g:message code="contentSection.author.label" default="Author" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${contentSectionInstanceList}" status="i" var="contentSectionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${contentSectionInstance.id}">${fieldValue(bean: contentSectionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: contentSectionInstance, field: "page")}</td>

                            <td>${fieldValue(bean: contentSectionInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: contentSectionInstance, field: "sequence")}</td>

                            <td>${fieldValue(bean: contentSectionInstance, field: "status")}</td>

                            <td>${fieldValue(bean: contentSectionInstance, field: "title")}</td>
                        
                            <td>${fieldValue(bean: contentSectionInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: contentSectionInstance, field: "content")}</td>
                        
                            <td><g:formatDate date="${contentSectionInstance.dateCreated}" /></td>
                        
                            <td><g:formatDate date="${contentSectionInstance.lastUpdated}" /></td>
                        
                            <td>${fieldValue(bean: contentSectionInstance, field: "author")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${contentSectionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
