
<%@ page import="com.esm.esmzone.MemberProfile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <g:form method="post" >
                <g:hiddenField name="id" value="${memberProfileInstance?.id}" />
                <g:hiddenField name="version" value="${memberProfileInstance?.version}" />
                <br><br><br><br><br>
                This is the very complex thing that I need to say
                <gui:autoComplete
				        id="remoteData"
				        idField="id"
				        controller="memberProfile"
				        action="schoolAutocomplete"
				/>
            </g:form>
        </div>
    </body>
</html>
