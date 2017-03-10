<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
	<script type="text/javascript" src="js/functions.js"></script>
    <script type="text/javascript">
			function facebookLogin() {
        	    FB.getLoginStatus(function(response) {
                    if (response.session) {
                            // logged in and connected user, someone you know
                            window.location ="${createLink(controller:'user', action:'fbLogin')}?source=esmzone&friendId=${params?.friendId}";
                    }
            	});
    		}
	</script>
</head>
<body class="yui-skin-sam" onload="${(onLoadFunction)?onLoadFunction:''}">
	<fbg:resources/>
    	<script type="text/javascript">
    		function fb_submitAndInvite(form) {
    			document.forms[0].inviteFriends.value = "true";
    			document.getElementById(form).submit();
    		}
    			
            function fb_inviteFriends() {
                var fbml = fb_getInviteFBML() ;
             	FB.ui(
                {
				    method: 'fbml.dialog',
				    display: 'dialog',
				    fbml: fbml,
				    width: 800,
				    height: 100
                },
                function(response) {
                });
            } 

			function fb_getInviteFBML() {
			    var fbml = '<fb:request-form action="${fbAction}" method="GET" invite="true" type="ESMZone" content="Join ESMZone, the place for student athletes. Compete for points and prizes with other athletes. ${fbContent}"><fb:multi-friend-selector showborder="false" bypass="cancel" import_external_friends="false" cols=4 actiontext="Invite your friends to join ESMZone"/></fb:request-form>';
			    return fbml;
			}
            
            function fb_logout() {
            	FB.logout(function(response) {
            		  // user is now logged out
           		});
            } 
        </script>
<div id="popup" class="join_today">
	<div id="popup_header">
		<h1 id="popup_logo">ESMZone</h1>
		<div id="popup_user_info">    
			<div id="login-form">
				<g:form name="logonform" controller="user" action="login" method="post" >
					<input name="login" type="text" value="user id" class="login-input" id="login-id" />
							
					<input type="password" name="password" id="pass" class="login-input" />

					<a href="javascript:submitform('logonform')" class="login-submit"></a>

					<script type="text/javascript">
							var p = document.getElementById('pass');
							/*@cc_on
 								@if (@_jscript)
								var inp = document.createElement("<input name='password'>");
 								inp.id = 'pass1';
 								inp.type = 'text';
 								inp.value = 'password';
 								p.parentNode.insertBefore(inp,p);
 								p.parentNode.removeChild(p);
 								p = document.getElementById('pass1');
 							@else */
								p.type = 'text';
								p.value = 'password';
							/* @end @*/
							p.onfocus = function() {
							if (this.type == 'text') {
								/*@cc_on
 									@if (@_jscript)
 								var inp = document.createElement("<input name='password'>");
 									inp.id = 'pass';
									inp.type = 'password';
 									inp.value = '';
 									this.parentNode.insertBefore(inp,this);
 									this.parentNode.removeChild(this);
 									inp.focus();
 								@else */
									this.value = '';
									this.type = 'password';
									this.focus();
								/* @end @*/
							}
						}
					</script> 

				</g:form>
			</div><!-- end of #login-form -->
			<span id="visitor-options">
				<fb:login-button size="small" perms="email, publish_stream" onlogin="facebookLogin();">Login with Facebook</fb:login-button><span class="divider">|</span>
				<a href="http://test13.esmzone.com/esmzone/forgotPassword" id="password-link" class="iframe">forgot your password</a>
			</span>
		</div><!-- end of #user-info -->
	</div><!-- end of #popup_header -->
	<div id="popup_content">
		<p>Welcome to ESMZone. To explore or play<br />in the zone, you need to get on our roster.</p>
		<a href="register" id="athlete_button" class="popup_button" name="athletes" target="_parent">Athletes Join Here</a>
		<a href="register?player=no" id="spectator_button" class="popup_button" name="spectators" target="_parent">Spectators Join Here</a>
	</div>
	<div id="popup_footer">
		<a href="javascript:parent.jQuery.fancybox.close()" id="fancybox-close">Just Previewing the Zone</a>
	</div>
</div><!-- end div#popup -->
</body>
</html>
