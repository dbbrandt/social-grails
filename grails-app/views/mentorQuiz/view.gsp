
<%@ page import="com.esm.esmzone.MentorQuiz" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'mentorQuiz.label', default: 'MentorQuiz')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Complete Mentor Quiz</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:form name="quiz" action="submitQuiz" method="post" >
            <g:hiddenField name="id" value="${mentorQuizInstance.id}"/>
            <div class="quiz">
            		<g:set var="questionNumber" value="${1}"/>
	                <g:each in="${surveyInstance.questions}" var="q">
		            	<div class="question">
	            	 		<g:if test="${!previousResponses || previousResponses[q.id]}">
			                    <b>${questionNumber}.&nbsp;${q.questionText}</b><br>
			                </g:if>
			                <g:else>
			                    	<div style="color:red"><b>${questionNumber}.&nbsp;${q.questionText}</b></div><br>
			                </g:else>
		            		<g:set var="responses" value="${q.responses}"/>
			                <g:each in="${responses}" var="r">
				            	<div class="response">
				            	        
				            	 		<g:if test="${previousResponses && previousResponses[q.id]}">
						            		<g:radio name="response.${q.id }" value="${r.id}" checked="${(previousResponses[q.id].toLong()==r.id)?true:false}"/>
				            	 		</g:if>
				            	 		<g:else>
						            		<g:radio name="response.${q.id }" value="${r.id}"/>
				            	 		</g:else>
			            			 <div class="responseText">${r.responseText}</div>
				            	</div>
				            </g:each>
		                </div>
	            		<g:set var="questionNumber" value="${questionNumber+1}"/>
	                </g:each>
            </div>     
            
            <div class="formbutton">
                <g:submitButton name="submit" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
            </div>
            </g:form>
        </div>
    </body>
</html>
