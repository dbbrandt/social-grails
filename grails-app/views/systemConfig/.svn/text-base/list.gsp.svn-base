
<%@ page import="com.esm.esmzone.SystemConfig" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'systemConfig.label', default: 'SystemConfig')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'systemConfig.id.label', default: 'Id')}" />
                        
                            <th><g:message code="systemConfig.showPendingContent.label" default="Show Pending Content" /></th>

                            <th><g:message code="systemConfig.modifiedBy.label" default="Modified By" /></th>
                   	    
                            <g:sortableColumn property="regEmailOn" title="${message(code: 'systemConfig.regEmailOn.label', default: 'Reg Email On')}" />
                        
                            <g:sortableColumn property="avatarFilePath" title="${message(code: 'systemConfig.avatarFilePath.label', default: 'Avatar File Path')}" />
                        
                            <g:sortableColumn property="avatarUrl" title="${message(code: 'systemConfig.avatarUrl.label', default: 'Avatar Url')}" />
                        
                            <th><g:message code="systemConfig.questionPromotion.label" default="Question Promotion" /></th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${systemConfigInstanceList}" status="i" var="systemConfigInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${systemConfigInstance.id}">${fieldValue(bean: systemConfigInstance, field: "id")}</g:link></td>
                        
                            <td><g:formatBoolean boolean="${systemConfigInstance.showPendingContent}" /></td>

                            <td>${fieldValue(bean: systemConfigInstance, field: "modifiedBy")}</td>
                        
                            <td><g:formatBoolean boolean="${systemConfigInstance.regEmailOn}" /></td>
                        
                            <td>${fieldValue(bean: systemConfigInstance, field: "avatarFilePath")}</td>
                        
                            <td>${fieldValue(bean: systemConfigInstance, field: "avatarUrl")}</td>
                        
                            <td>${fieldValue(bean: systemConfigInstance, field: "questionPromotion")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${systemConfigInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
