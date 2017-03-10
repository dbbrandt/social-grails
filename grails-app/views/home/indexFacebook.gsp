<html>
    <head>
        <title>Welcome to ESMZone</title>
		<meta name="layout" content="mainFacebook" />
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
				<fb:login-button autologoutLink="true" perms="email,user_birthday,status_update,publish_stream"></fb:login-button>
			</div>
			<a href="#" onclick="fqlQuery(); return false;">FQL Query Example</a> <br>
			<a href="#" onclick="fb_inviteFriends(); return false;">Invite Friends</a> 
			
	        <div id="name"></div>
    </body>
</html>