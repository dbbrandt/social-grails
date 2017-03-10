<g:if test="${((answerInstance?.post?.author == request?.user) && (answerInstance?.author != request.user))}">
    <g:form	name="bestAnswerForm${answerInstance?.id}" controller="answer" action="bestAnswer" menthod="post">
    	<div class="top-answer">
			<input type="hidden" name="id" value="${answerInstance.id}"/>
			<g:if test="${answerInstance?.post?.bestAnswer == answerInstance}">
				<a href="#" class="top-1">Top Answer</a>
			</g:if>
			<g:else>
				<a href="javascript:submitform('bestAnswerForm${answerInstance?.id}')" class="top-0">Set Top Answer</a>
			</g:else>
		</div>    	 
    </g:form>
</g:if>		
<g:elseif test="${answerInstance?.post?.bestAnswer == answerInstance}">
	<a class="top-1">Top Answer</a>
</g:elseif>
