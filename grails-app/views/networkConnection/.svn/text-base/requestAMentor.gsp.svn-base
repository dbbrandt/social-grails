<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="js/functions.js"></script>
	<script type="text/javascript">
	function textCounter(field,cntfield,maxlimit) {
	if (field.value.length > maxlimit) // if too long...trim it!
	field.value = field.value.substring(0, maxlimit);
	// otherwise, update 'characters left' counter
	else
	cntfield.value = maxlimit - field.value.length;
	}
	</script>
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>Request ${userInstance} as a Mentor</h1>
	</div><!-- end div.menu -->
	<div id="content">
		<g:form name="messageform" method="post" controller="networkConnection" action="requestAMentor">
                <g:hiddenField name="user.id" value="${request?.user?.id}" />
                <g:hiddenField name="friend.id" value="${userInstance?.id}" />
				<label for="title">Message to Mentor</label>
				<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500"/> characters</span>
				<textarea id="message" name="message" type="text" style="width:410px;height:180px;border:1px solid #000000;" maxlength="500" onKeyDown="textCounter(document.messageform.message,document.messageform.textcounter,500)" onKeyUp="(document.messageform.message,document.messageform.textcounter,500)"></textarea>
				<a href="javascript:submitformPopup('messageform')" class="nofold button">Request</a>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>