<%@ page import="com.esm.promotion.QuestionPromotion" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="js/functions.js"></script>
</head>
<body>
<div id="popup">
	<div class="menu">
		<img alt="Answer the Question of the Day" src="${resource(dir:'images',file:'question_bnr_1.jpg')}" />
	</div><!-- end div.menu -->
	<div id="content">
        <g:form name="questionform" action="viewResult" method="post" >
            <g:hiddenField name="id" value="${questionPromotion.id}"/>
            <div class="quiz">
            	<div class="question">
                    <b>${question.questionText}</b><br><br>
            		<g:set var="responses" value="${question.responses}"/>
	                <g:each in="${responses}" var="r">
	                	<div id="responses">
		            	    <input id="responses" type="radio" name="response" value="${r.id}"/>
	            			${r.responseText}
            			</div>
		            </g:each>
                </div>
            </div>
			<a href="javascript:submitformNormal('questionform')" class="nofold button">Submit</a>
			<div class="promotion-rules">
				<br><br><br>
				<b>Rules:</b><br>
				One play per day.<br>
				Answer ${questionPromotion.answersToWin} questions correctly in
				${questionPromotion.daysToWin} days in order to win a ${questionPromotion.description}.   
			</div>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>

