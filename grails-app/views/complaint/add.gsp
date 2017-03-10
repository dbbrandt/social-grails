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
		<h1>Flag</h1>
	</div><!-- end div.menu -->
	<div id="content">
		<g:if test="${flash.message}">
			<p id="error" class="output">
				<g:message code="${flash.message}"></g:message>
			</p>
		</g:if>
	 	<p>${complaintInstance?.content}</p>
		<g:form name="messageform" method="post" controller="complaint" action="add">
            <g:hiddenField name="contentId" value="${complaintInstance?.contentId}" />
            <g:hiddenField name="type" value="${complaintInstance?.type}" />
            <g:hiddenField name="content" value="${complaintInstance?.content}" />
			<label for="message">Please select a type and describe the reason for the complaint (Required)</label>
			<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500"> characters</span>
            <g:select name="reason" from="${com.esm.dialog.ComplaintType?.values()}" value="${complaintInstance?.reason}"  />
			<textarea id="message" name="message" type="text" style="height:120px;border:1px solid #000000;" maxlength="500" onKeyDown="textCounter(document.messageform.message,document.messageform.textcounter,500)" onKeyUp="(document.messageform.message,document.messageform.textcounter,500)"></textarea>
			<a href="javascript:submitformNormal('messageform')" class="nofold button">Save</a>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>