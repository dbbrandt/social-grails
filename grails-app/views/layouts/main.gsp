<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="title" content="ESMZONE - Where Student Athletes Train to Lead" /> 
    	<meta name="description" content="The community game rewarding student athletes for mentoring their peers and developing leadership skills." />
		<meta name="msvalidate.01" content="36574B0B8F4B9AEE1D37851A4720F864" />
		<title>ESMZONE - Where Student Athletes Train to Lead</title>
        <gui:resources components="['autoComplete']"/>
        <g:javascript library="prototype" />
		<script type="text/javascript" src="${resource(dir:'js',file:'jquery-1.4.2.min.js')}"></script>
		<script type="text/javascript" src="${resource(dir:'js',file:'cycle.js')}"></script>
		<script type="text/javascript" src="${resource(dir:'js',file:'expand.js')}"></script>
		<script>
			// needed for confilict between prototype and jquery
			// all references to $ must be replaced with $j in the scripts for jquery
	 		var $j = jQuery.noConflict();
		</script>
		
		<script type="text/javascript" src="${resource(dir:'js',file:'functions.js')}"></script> 
		<script type="text/javascript" src="${resource(dir:'images/fancybox/',file:'jquery.fancybox-1.3.1.pack.js')}"></script>
		<script type="text/javascript" src="${resource(dir:'images/fancybox/',file:'jquery.easing-1.3.pack.js')}"></script>
		<script src="http://widgets.twimg.com/j/2/widget.js"></script>
		<link href="${resource(dir:'images/fancybox/',file:'jquery.fancybox-1.3.1.css')}" type="text/css" rel="stylesheet" media="screen"/>
		<link href="${resource(dir:'css', file:'style.css')}" type="text/css" rel="stylesheet" />
		<script src="http://widgets.twimg.com/j/2/widget.js"></script>
	   	<script type="text/javascript">
			/*Fancybox-
			http://fancybox.net/*/
			jQuery(document).ready(function() {
				jQuery("a.iframe").fancybox({
						'width'				: 450,
						'height'			: 350,
						'type'				: 'iframe',
						'autoScale'     	: false,
						'padding' : '0',
						'titleShow' : false,
					'overlayOpacity'	:0.6,
					'overlayColor'	:'#000',
					'onClosed' : function() {jQuery(parent.document)[0].location.reload();}
				});
			});
			jQuery(function() {
				jQuery('#slideshow').cycle({ 
					 timeout:       6000,  // milliseconds between slide transitions (0 to disable auto advance) 
					speed:         1000,  // speed of the transition (any valid fx speed value) 
					height:       'auto', // container height 
					sync:          1,     // true if in/out transitions should occur simultaneously 
					fit:           1,     // force slides to fit container 
					delay:         0     // additional delay (in ms) for first transition (hint: can be negative) 
				});
			});

			function facebookLogin() {
        	    FB.getLoginStatus(function(response) {
                    if (response.session) {
                            // logged in and connected user, someone you know
                            window.location ="${createLink(controller:'user', action:'fbLogin')}?source=esmzone&friendId=${params?.friendId}";
                    }
            	});
    		}
		</script>
	

		<style type="text/css">
			div#wrapper {
				background-image:${resource(dir:'images', file: (session.backgroundImage)?session.backgroundImage:"bkgd_football_field2")}.jpg');
			}
		</style>
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
		<a href="${createLink(controller:'post', action:'feedback')}" id="feedback-tab" class="iframe"></a>
		<div id="wrapper">
			<div id="wrapper-shadow-left"></div>
			<div id="wrapper-shadow-right"></div>
			<div id="header">
				<a href="${createLink(controller:'home', action:'index')}"><img id="esm-logo" alt="ESMZone" src="${resource(dir:'images',file:'logo.jpg')}"></a>
			    <g:render template="/layouts/menuWidget"/>
				<g:if test="${request?.user?.id}">
					<div id="user-info">
						<img id="user-avatar" src="${request?.avatar}?${request?.avatarVersion}" width="33" height="33" />
						<h1>${request?.user?.firstName}</h1>
						<span id="user-functions"><a href="${createLink(controller:'memberProfile', action:'editProfileInfo')}">profile</a> | <a href="${createLink(controller:'user', action:'logout')}" onclick="fb_logout();">log out</a> 
						<jsec:hasRole name="ADMINISTRATOR">
						 | <a href="${createLink(controller:'home', action:'admin')}">admin</a> 
						</jsec:hasRole>
						</span>
					    <span id="user-score">Score ${request?.user.score} <img id="user-stars" alt="${request?.user.averageRating} stars" src="${resource(dir:'images/stars/', file:'stars-'+request?.user?.starRating()+'.png')}" /></span>
					</div><!-- end div#user-info -->
				</g:if>
				<g:else>
					<div id="user-info">
						<a href="${createLink(controller:'user', action:'joinToday')}" id="join-link" class="iframe">JOIN ESMZone Today</a>
     				    
						<div id="login-form">
							<g:form name="logonform" controller="user" action="login" method="post" >
								<input name="login" type="text" value="user id" class="login-input" id="login-id" />
								
								<input type="password" name="password" id="pass" class="login-input" />

								<input name="submit" type="submit" id="login-submit" value="Go" />
								
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
						</div><!-- end of div#login-form -->
						
						<span id="visitor-options">
							<fb:login-button size="small" perms="email, publish_stream" onlogin="facebookLogin();">Login with Facebook</fb:login-button><span class="divider">|</span>
							<a href="http://test13.esmzone.com/esmzone/forgotPassword" id="password-link" class="iframe">forgot your password</a>
						</span>
					</div><!-- end div#user-info -->
				</g:else>
			</div><!-- end div#header -->
	    	<g:layoutBody />
			<div id="footer">
				<ul id="sponsor-list">
					<li class="sponsor-header">sponsored by</li>
					<li><a href="http://www.chalktalksports.com"  target="_blank"><img src="${resource(dir:'images', file:'chalktalksports.png')}" alt="Sponsor - Chalktalk SPORTS" title="Chalktalk SPORTS"></a></li>
					<li><a href="http://www.joenamathcamp.com"  target="_blank"><img src="${resource(dir:'images', file:'joenamathcamp.png')}" alt="Sponsor - Joe Namath Footbal Camp" title="Joe Namath Football Camp"></a></li>
					<li><a href="http://www.noblemaster.com"  target="_blank"><img src="${resource(dir:'images', file:'noble.png')}" alt="Sponsor - Noble Master Games" title="Noble Masters Games"></a></li>
					<li><a href="http://www.usta.com"  target="_blank"><img src="${resource(dir:'images', file:'usta.png')}" alt="Sponsor - USTA" title="USTA"></a></li>
				</ul>
				<div id="footer-menu-wrapper">
					<span class="copyright">&copy;2011 ESMZone. All Rights Reserved.</span>
					<ul id="footer-menu">
						<li><a href="${createLink(controller:"home", action:"about")}" alt="Read About Us">About Us</a> &#149; </li>
						<li><a href="${createLink(controller:"home", action:"contact")}" alt="Contact us">Contact</a> &#149; </li>
						<li><a href="${createLink(controller:"home", action:"privacy")}" alt="Privacy Policy">Privacy</a> &#149; </li>
						<li><a href="${createLink(controller:"home", action:"terms")}" alt="Terms Of Service">Terms Of Service</a> &#149; </li>
						<li><a href="${createLink(controller:"home", action:"faqs")}" alt="FAQs">FAQs</a> &#149; </li>
						<li><a href="${createLink(controller:"home", action:"spectators")}" alt="Spectators">Spectators</a> &#149;  </li>
						<li><a href="http://blog.esmzone.com" alt="Blog">Blog</a></li>
					</ul>
				</div>
			</div><!-- end div#footer -->
		</div><!-- end div#wrapper -->
	    <script type="text/javascript">
			var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
			document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
			</script>
			<script type="text/javascript">
			try {
			var pageTracker = _gat._getTracker("UA-15192439-2");
			pageTracker._trackPageview();
			} catch(err) {}
	   </script>
  </body>
</html>