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
		<h1>Result of Question of the Day</h1>
	</div><!-- end div.menu -->
	<div id="content">
           <div class="quiz">
           	<div class="question">
                   <b>${questionText}</b><br><br>
            	<div class="response">
           			 Your answer was: ${responseText}<br><br>
            	</div>
            	<b>${message}</b>
               </div>
           </div>     
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>
