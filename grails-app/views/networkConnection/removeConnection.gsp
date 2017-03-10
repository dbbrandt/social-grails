
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <title>Remove Connection</title>
    </head>
    <body>
        <div class="body">
            <h1>Remove Connection</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${networkConnectionInstance}">
            <div class="errors">
                <g:renderErrors bean="${networkConnectionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
            </div>
            <g:form action="removeConnection" method="post" >
                <g:hiddenField name="id" value="${networkConnectionInstance?.id}" />
				Are you sure you want to delete the connection between with ${networkConnectionInstance.getFan(request.user)}?<br>
				Click submit to continue.
                <div class="buttons">
                    <span class="button"><g:submitButton name="apply" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
