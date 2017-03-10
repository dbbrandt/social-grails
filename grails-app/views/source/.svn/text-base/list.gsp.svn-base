
<%@ page import="com.esm.esmzone.Source" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'source.label', default: 'Source')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'source.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="sourceName" title="${message(code: 'source.sourceName.label', default: 'Source Name')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'source.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="message" title="${message(code: 'source.message.label', default: 'Message')}" />
                        
                            <g:sortableColumn property="coupon" title="${message(code: 'source.coupon.label', default: 'Coupon')}" />
                        
                            <g:sortableColumn property="owner" title="${message(code: 'source.owner.label', default: 'Owner')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${sourceInstanceList}" status="i" var="sourceInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${sourceInstance.id}">${fieldValue(bean: sourceInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: sourceInstance, field: "sourceName")}</td>
                        
                            <td>${fieldValue(bean: sourceInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: sourceInstance, field: "message")}</td>
                        
                            <td>${fieldValue(bean: sourceInstance, field: "coupon")}</td>
                        
                            <td>${fieldValue(bean: sourceInstance, field: "owner")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${sourceInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
