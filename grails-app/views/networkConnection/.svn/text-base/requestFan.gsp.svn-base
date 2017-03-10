
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'requestFan.label', default: 'Become a Fan')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Become a Fan</h1>
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
            <g:form action="requestFan" method="post" >
                <g:hiddenField name="user.id" value="${networkConnectionInstance?.user.id}" />
                <g:hiddenField name="friend.id" value="${networkConnectionInstance?.friend.id}" />
                <g:hiddenField name="type" value="${networkConnectionInstance?.type}" />
                <div class="formField">
	               	<label for="message">Enter a brief comment to the Member</label>
				</div>
				<br>
				<g:textArea name="message" value="${networkConnectionInstance?.message}"></g:textArea>
                <div class="buttons">
                    <span class="button"><g:submitButton name="apply" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
