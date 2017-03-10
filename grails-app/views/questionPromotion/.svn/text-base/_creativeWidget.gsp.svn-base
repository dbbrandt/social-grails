<%@ page import="com.esm.promotion.QuestionPromotion" %>
<%@ page import="com.esm.promotion.PromotionStatus" %>
<%@ page import="com.esm.esmzone.SystemConfig" %>
<g:set var="config" value="${SystemConfig.get(1)}"/>
<g:set var="promotion" value="${QuestionPromotion.get(config.questionPromotion?.id)}"/>
<g:if test="${promotion?.displayToUser(request?.user) }">
	<div class="question-promotion">
			<a href="/esmzone/questionPromo?id=${config.questionPromotion?.id}" class="iframe">
			    <img width="188px" height="90px" src="${resource(dir:'images',file:promotion.loggedInCreative)}" >
			</a>
	</div>
</g:if>
<g:elseif test="${promotion?.displayToVisitor(request?.user)}">
	<div class="question-promotion">
			<a href="/esmzone/register?coupon=trivia-1">
			     <img  width="188px" height="90px" src="${resource(dir:'images',file:promotion.loggedOutCreative)}">
		    </a>
	</div>
</g:elseif>
