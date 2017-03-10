<%@ page contentType="text/plain"%>
Dear ${user.firstName} ${user.lastName},

Your ESMZone profile has been updated.

Your login id is: ${user.email}
<g:if test="${reset}">
Click the following link to reset your password.
http://${request.getServerName()}/esmzone/forgotPassword?id=${user?.id}&k=${user?.password}
</g:if>
<g:elseif test="${password == 'true'}">
Your password was successfully changed.
</g:elseif>

Keep up the good work!
Good Luck in the Competition!

The ESMZone Team
