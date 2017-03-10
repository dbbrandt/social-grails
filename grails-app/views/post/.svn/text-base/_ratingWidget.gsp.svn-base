<g:if test="${ratingInstance?.author != request?.user}">
	<g:form name="ratingForm${ratingInstance?.id}" controller="post" action="rate"> 
		<div class="like">
			<input type="hidden" name="id" value="${ratingInstance?.id}"/>
			<a href="javascript:submitform('ratingForm${ratingInstance?.id}')" class="${ratingInstance?.ratingImage(request?.user)}">${ratingInstance?.ratingText(request?.user)}</a>
		</div>	
	</g:form>
</g:if>
