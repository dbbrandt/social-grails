
<%@ page import="com.esm.esmzone.User" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
        <title>Select a Mentor</title>
    </head>
    <body>
        <div class="body">
            <h1>Select a Mentor</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
	        <g:form action="selectMentor" method="post">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <td>&nbsp;</td>
                        
                            <g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="gender" title="${message(code: 'user.gender.label', default: 'Gender')}" />
                    
                            <g:sortableColumn property="city" title="${message(code: 'user.town.label', default: 'Town')}" />

                            <g:sortableColumn property="playedSports" title="${message(code: 'user.playedSports.label', default: 'Sports Played')}" />

                            <g:sortableColumn property="grade" title="${message(code: 'user.grade.label', default: 'Grade')}" />

                            <g:sortableColumn property="score" title="${message(code: 'user.rating.label', default: 'Rating')}" />

                            <g:sortableColumn property="score" title="${message(code: 'user.score.label', default: 'Score')}" />

                            <g:sortableColumn property="mentorScore" title="${message(code: 'user.mentorScore.label', default: 'Mentor Match')}" />
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><div style="radio"><g:radio name="mentor" value="${userInstance.id}"/></div></td>
                                                    
                            <td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${userInstance.firstName} ${userInstance.lastName}</g:link></td>
                        
                            <td>${fieldValue(bean: userInstance, field: "gender")}</td>

                            <td>${userInstance?.address?.city}</td>

                            <td>${userInstance?.memberProfile?.playedSports}</td>

                            <td>${userInstance?.memberProfile?.gradeLevel()}</td>

                            <td>${fieldValue(bean: userInstance, field: "averageRating")}</td>

                            <td>${fieldValue(bean: userInstance, field: "score")}</td>

                            <td>${fieldValue(bean: userInstance, field: "mentorScore")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userInstanceTotal}" />
            </div>
            <div class="formbutton">
              	<g:submitButton name="submit" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
          	</div>
        </g:form>
        </div>
    </body>
</html>
