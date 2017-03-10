
<%@ page import="com.esm.promotion.QuestionPromotion" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotion.label', default: 'QuestionPromotion')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'questionPromotion.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'questionPromotion.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="description" title="${message(code: 'questionPromotion.description.label', default: 'Description')}" />
                        
                            <g:sortableColumn property="quota" title="${message(code: 'questionPromotion.quota.label', default: 'Quota')}" />
                        
                            <g:sortableColumn property="remainingQuota" title="${message(code: 'questionPromotion.remainingQuota.label', default: 'Remaining Quota')}" />
                        
                            <g:sortableColumn property="startDate" title="${message(code: 'questionPromotion.startDate.label', default: 'Start Date')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${questionPromotionInstanceList}" status="i" var="questionPromotionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${questionPromotionInstance.id}">${fieldValue(bean: questionPromotionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: questionPromotionInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: questionPromotionInstance, field: "description")}</td>
                        
                            <td>${fieldValue(bean: questionPromotionInstance, field: "quota")}</td>
                        
                            <td>${fieldValue(bean: questionPromotionInstance, field: "remainingQuota")}</td>
                        
                            <td><g:formatDate date="${questionPromotionInstance.startDate}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${questionPromotionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
