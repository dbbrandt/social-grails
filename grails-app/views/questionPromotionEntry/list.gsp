
<%@ page import="com.esm.promotion.QuestionPromotionEntry" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'questionPromotionEntry.label', default: 'QuestionPromotionEntry')}" />
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'questionPromotionEntry.id.label', default: 'Id')}" />
                        
                            <th><g:message code="questionPromotionEntry.response.label" default="Response" /></th>
                   	    
                            <g:sortableColumn property="result" title="${message(code: 'questionPromotionEntry.result.label', default: 'Result')}" />
                        
                            <g:sortableColumn property="dateFulfilled" title="${message(code: 'questionPromotionEntry.dateFulfilled.label', default: 'Date Fulfilled')}" />
                        
                            <g:sortableColumn property="dateNotified" title="${message(code: 'questionPromotionEntry.dateNotified.label', default: 'Date Notified')}" />
                        
                            <g:sortableColumn property="active" title="${message(code: 'questionPromotionEntry.active.label', default: 'Active')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${questionPromotionEntryInstanceList}" status="i" var="questionPromotionEntryInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${questionPromotionEntryInstance.id}">${fieldValue(bean: questionPromotionEntryInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: questionPromotionEntryInstance, field: "response")}</td>
                        
                            <td>${fieldValue(bean: questionPromotionEntryInstance, field: "result")}</td>
                        
                            <td><g:formatDate date="${questionPromotionEntryInstance.dateFulfilled}" /></td>
                        
                            <td><g:formatDate date="${questionPromotionEntryInstance.dateNotified}" /></td>
                        
                            <td><g:formatBoolean boolean="${questionPromotionEntryInstance.active}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${questionPromotionEntryInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
