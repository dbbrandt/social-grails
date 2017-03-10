<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="js/functions.js"></script>
</head>
<body>
<div id="popup" class="reply">
	<div class="menu">
		<h1>Personal Messages to ${userInstance}</h1>
		<div class="counter"><div class="round-right"></div><div class="number">${postInstanceList.size()}</div><div class="round-left"></div></div>
	</div><!-- end div.menu -->
	<div id="content">
		<g:form name="messageform" method="post" controller="post" action="addMessage">
			<input type="hidden" name="id" value="${userInstance.id}"/>
			<label for="title">Reply</label>
			<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500"> characters</span>
			<textarea id="title" name="title" type="text" style="width:410px;height:50px;border:1px solid #000000;" maxlength="500" onKeyDown="textCounter(document.messageform.title,document.messageform.textcounter,500)" onKeyUp="(document.messageform.title,document.messageform.textcounter,500)"></textarea>
			<a href="javascript:submitformPopup('messageform')" class="nofold button">Send</a>
		</g:form>
		<div id="conversation-thread">
	           <g:each in="${postInstanceList}" status="i" var="postInstance">
				<div class="conversation">
					<span><g:formatDate format="hh:mm M/d/yyyy" date="${postInstance.dateCreated}" /> <a href="${createLink(controller:'memberProfile', action:'view')}?userId=${postInstance?.author?.id}" alt="${postInstance?.author}" target="_top">${postInstance?.author}</a></span>
					<p>${postInstance?.title}</p>
				</div>
			</g:each>
		</div><!-- end div#conversation-thread -->
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>