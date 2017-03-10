
<%@ page import="com.esm.esmzone.MentorApplication" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorApplication.label', default: 'MentorApplication')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Submit Mentor Reference</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${referenceInstance}">
            <div class="errors">
                <g:renderErrors bean="${referenceInstance}" as="list" />
            </div>
            </g:hasErrors>
            <div>
            	<p>${referenceInstance.firstName} ${referenceInstance.lastName},</p>
				<p>Please enter your reference below.</p>
                <p>Indicate if you recommend this individual or not and a brief comment on your reasons.</p>
                <p> Mentor Information:</p>
            </div>
            <br>
            <g:render template="/memberProfile/profile" model="['memberProfileInstance':memberProfileInstance]"/>
            <br>
            <g:form action="referenceResponse" method="post" >
                <g:hiddenField name="id" value="${mentorApplicationInstance?.id}" />
                <g:hiddenField name="seq" value="${referenceInstance?.sequence}" />
	            <div class="formField">
	               	<div class="radio">
		               	<label for="approved">Recommend:</label>
	                    Yes<g:radio name="approved" value="true" />&nbsp;&nbsp;
	                    No<g:radio name="approved" value="false" />
	                </div>
  				</div>
  				<br>
	            <div class="formField">
	               	<label for="comment">Reason:</label>
					<g:textArea name="description" value="${referenceInstance?.description}"></g:textArea>
  				</div>
	            <div class="formbutton">
	                <g:submitButton name="submit" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
	            </div>
            </g:form>
        </div>
    </body>
</html>
