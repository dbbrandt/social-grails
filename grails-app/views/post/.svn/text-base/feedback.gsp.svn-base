<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="${resource(dir:'js',file:'functions.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.4.2.min.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'images/fancybox',file:'jquery.fancybox-1.3.1.pack.js')}"></script>
	<script type="text/javascript" src="${resource(dir:'images/fancybox',file:'jquery.easing-1.3.pack.js')}"></script>
	<script type="text/javascript">
	jQuery('.close_popup_never').live('click',function(){
	    fancybox_close();  //closes the fancybox
	    return false;
	}
	</script>
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>Feedback</h1>
	</div><!-- end div.menu -->
	<div id="content">
		<g:form id="messageform" name="messageform" method="post" controller="post" action="feedback">
				<label for="message">Give us feedback on ESM Zone</label>
				<span class="text-counter"><input name="textcounter" class="textcounter" readonly="readonly" value="500" /> characters</span>

				<select name="title">
					<option value="">Select a category</option>
					<option value="Suggestion">Suggestions</option>
					<option value="Functional Bug">Something didn't work right</option>
					<option value="UI Bug">Something doesn't look right</option>
					<option value="Error">I got a system error message</option>
					<option value="Other">Other</option>
				</select>
				<textarea id="message" name="description" type="text" style="height:120px;border:1px solid #000000;" maxlength="500" onKeyDown="textCounter(document.messageform.message,document.messageform.textcounter,500)" onKeyUp="(document.messageform.message,document.messageform.textcounter,500)"></textarea>
				<a href="javascript:submitform('messageform')" class="nofold button">Submit</a>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>