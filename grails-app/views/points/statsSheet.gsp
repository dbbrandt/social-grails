
<%@ page import="com.esm.esmzone.Points" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'points.label', default: 'Points')}" />
        <title>Stats Sheet</title>
    </head>
    <body>
        <div class="body">
            <h1>${request.user.firstName}'s Stats Sheet</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list" style="width:50%">
                <table>
                    <thead>
                        <tr>
                            <th>Type</th>

                            <th>Value</th>

                            <th>Count</th>

                            <th>Points</th>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${pointsInstanceList}" status="i" var="pointsInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${pointsInstance?.type}</td>

                            <td>${pointsInstance?.value}</td>

                            <td>${pointsInstance?.count}</td>

                            <td>${pointsInstance?.points}</td>
                        
                        </tr>
                    </g:each>
                        <tr>
                            <th>Totals</th>

                            <th>-</th>

                            <th>${pointsInstanceCount}</th>

                            <th>${pointsInstanceTotal}</th>
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <br><br>
            <div class="list" style="width:24%">
                <table>
                    <thead>
                        <tr>
                            <th>Summary</th>
                            <th>Value</th>
                        </tr>
                    </thead>
                    <tr>
                    	<td>Total Ratings</td>
                    	<td>${request.user.ratingCount}</td>
                    </tr>
                    <tr>
                    	<td>Average Rating</td>
                    	<td>${request.user.averageRating}</td>
                    </tr>
                    <tr>
                    	<td>Total Points</td>
                    	<td>${request.user.points}</td>
                    </tr>
                    <tr>
                    	<th>Total Score</th>
                    	<th>${request.user.score}</th>
                    </tr>
                </table>
            </div>
        </div>
    </body>
</html>
