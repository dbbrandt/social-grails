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
		<h1>Remove Fan</h1>
	</div><!-- end div.menu -->
	<div id="content">
		<g:form name="messageform" method="post" controller="networkConnection" action="removeAConnection">
                <g:hiddenField name="id" value="${networkConnectionInstance.id}" />
				<label for="prompt">Are you sure you want to remove your connection with ${userInstance}</label>
				<a href="javascript:submitformPopup('messageform')" class="nofold button">Remove</a>
		</g:form>
	</div><!-- end div#content -->
</div><!-- end div#popup -->
</body>
</html>
