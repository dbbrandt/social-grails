
<%@ page import="com.esm.dialog.Tag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'tag.label', default: 'Tag')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="treeView">Tree View</g:link></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'tag.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'tag.name.label', default: 'Name')}" />

                            <th>Parent</th>
                        
                            <g:sortableColumn property="lastUpdated" title="${message(code: 'tag.lastUpdated.label', default: 'Last Updated')}" />
                        
                            <g:sortableColumn property="isLeafTag" title="${message(code: 'tag.isLeafTag.label', default: 'Is Leaf Tag')}" />
                        
                            <g:sortableColumn property="dateCreated" title="${message(code: 'tag.dateCreated.label', default: 'Date Created')}" />
                        
                            <th><g:message code="tag.user.label" default="User" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${tagInstanceList}" status="i" var="tagInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${tagInstance.id}">${fieldValue(bean: tagInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: tagInstance, field: "name")}</td>

                            <td>${tagInstance.getParent()}</td>
                        
                            <td><g:formatDate date="${tagInstance.lastUpdated}" /></td>
                        
                            <td><g:formatBoolean boolean="${tagInstance.isLeafTag}" /></td>
                        
                            <td><g:formatDate date="${tagInstance.dateCreated}" /></td>
                        
                            <td>${fieldValue(bean: tagInstance, field: "user")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${tagInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
