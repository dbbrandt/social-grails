<g:if test="${ratingInstance?.author != request?.user}">
	<g:form name="aRatingForm${ratingInstance?.id}" controller="answer" action="rate"> 
		<input type="hidden" name="id" value="${ratingInstance?.id}"/>
		<a href="javascript:submitform('aRatingForm${ratingInstance?.id}')" class="${ratingInstance?.ratingImage(request?.user)}">${ratingInstance?.ratingText(request?.user)}</a>
	</g:form>
</g:if>
