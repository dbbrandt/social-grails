
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Mentor Directory</title>
    </head>
    <body>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="firstName" title="${message(code: 'user.firstName.label', default: 'First Name')}" />
                        
                            <g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}" />

                            <g:sortableColumn property="address.state" title="${message(code: 'memberProfile.state.label', default: 'State')}" />

                            <g:sortableColumn property="memberProfile.grade" title="${message(code: 'memberProfile.playedSports.label', default: 'Grade')}" />

                            <g:sortableColumn property="memberProfile.playedSports" title="${message(code: 'memberProfile.playedSports.label', default: 'Sports Played')}" />

                            <g:sortableColumn property="score" title="${message(code: 'user.score.label', default: 'Score')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "gender")}</td>

                            <td>${userInstance?.address?.state}</td>

                            <td>${userInstance?.memberProfile?.gradeLevel()}</td>

                            <td>${userInstance?.memberProfile?.playedSports}</td>

                            <td>${fieldValue(bean: userInstance, field: "score")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
