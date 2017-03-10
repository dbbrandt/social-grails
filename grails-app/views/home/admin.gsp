<html>
    <head>
        <title>Welcome to ESMZone</title>
		<meta name="layout" content="mainAdmin" />
    </head>
    <body>
			<div class="homePagePanel">
		        <h1>Welcome to ESMZone</h1>
		        <g:if test="${flash.message}">
            		<div class="message">${flash.message}</div>
            	</g:if>
		        <g:else>
		        	<p>The place for student-athletes to meet and excel!</p>
		        </g:else>
			</div>
			<div id="brandingWidget">
				<g:render template="/home/brandingWidget"></g:render>
			</div>
			<div id="dialogWidget">
				<g:render template="/home/dialogWidget"></g:render>
			</div>
			<div id="scoreWidget">
				<g:render template="/home/scoreWidget"></g:render>
			</div>
			<div id="newsWidget">
				<g:render template="/home/newsWidget"></g:render>
			</div>
			
    </body>
</html>