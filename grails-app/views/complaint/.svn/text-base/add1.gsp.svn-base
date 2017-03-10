
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'complaint.label', default: 'Submit a Complaint')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Submit Complaint</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${complaintInstance}">
            <div class="errors">
                <g:renderErrors bean="${complaintInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
                <b>Content:</b><br>
            	<i><%=complaintInstance?.content %></i>
            </div>
            <g:form action="add" method="post" >
	            <g:hiddenField name="contentId" value="${complaintInstance?.contentId}" />
	            <g:hiddenField name="type" value="${complaintInstance?.type}" />
	            <g:hiddenField name="content" value="${complaintInstance?.content}" />
	            <br>
                <div class="formField">
	               	<label for="reason">Type:</label>
                    <g:select name="reason" from="${com.esm.dialog.ComplaintType?.values()}" value="${complaintInstance?.reason}"  />
				</div>
				<br>
                <div class="formField">
	               	<label for="message">Please describe the reason for the complaint</label>
				</div>
				<br>
				<g:textArea name="message" value="${complaintInstance?.message}"></g:textArea>
                <div class="buttons">
                    <span class="button"><g:submitButton name="apply" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
