<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:fb="http://www.facebook.com/2008/fbml">
<html>
	<head>
		<title>ESM ZONE - The Place for Student Athletes</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="title" content="ESM ZONE - The Place for Student Athletes" /> 
    	<meta name="description" content="A community for anyone participating in sports and the challenges of being a student." />
    	<link rel="image_src" href="images/logo.png" />
        <gui:resources components="['autoComplete']"/>
        <g:javascript library="prototype" />
		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="js/cycle.js"></script>
		<script type="text/javascript" src="js/expand.js"></script>
		<script>
			// needed for confilict between prototype and jquery
			// all references to $ must be replaced with $j in the scripts for jquery
	 		var $j = jQuery.noConflict();
		</script>
		<script type="text/javascript" src="js/functions.js"></script>
		<script type="text/javascript" src="${resource(dir:'images/fancybox',file:'jquery.fancybox-1.3.1.pack.js')}"></script>
		<script type="text/javascript" src="${resource(dir:'images/fancybox',file:'jquery.easing-1.3.pack.js')}"></script>
		<link href="images/fancybox/jquery.fancybox-1.3.1.css" type="text/css" rel="stylesheet" media="screen"/>
		<link href="css/style.css" type="text/css" rel="stylesheet" />
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
                            window.location ="${createLink(controller:'user', action:'fbLogin')}?source=esmzone";
                    }
            	});
    		}
		</script> 
		<style type="text/css">
			div#wrapper {
				background-image:url('images/${(session.backgroundImage)?session.backgroundImage:"football-stadium"}.jpg');
			}
		</style>
	</head>
    <body class="yui-skin-sam" onload="menuSlider.init('menu','slide')" >
		<fbg:resources/>
    	<script type="text/javascript">
    	    function fqlQuery(){
                FB.api('/me', function(response) {
                     var query = FB.Data.query('select name, email, birthday, sex, pic_square from user where uid={0}', response.id);
                     query.wait(function(rows) {
                       
                       document.getElementById('name').innerHTML =
                         'Your name: ' + rows[0].name + "<br />" +
                         'Your email: ' + rows[0].email + "<br />" +
                         'Your birthday: ' + rows[0].birthday + "<br />" +
                         'Your Sex: ' + rows[0].sex + "<br />" +
                         //'Your hometown: ' + rows[0].current_location + "<br />" +
                         '<img src="' + rows[0].pic_square + '" alt="" />' + "<br />";
                     });
                });
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
			    var fbml = '<fb:request-form action="http://dev.precidix.com:8090/esmzone" method="GET" invite="true" type="ESMZone" content="Join ESMZone, the place for student athletes. Ask and answer questons and win prizes. ${fbContent}"><fb:multi-friend-selector showborder="false" bypass="cancel" email_invite=true import_external_friends=false cols=4 actiontext="Invite your friends to join ESMZone"/></fb:request-form>';
			    return fbml;
			}
            
        </script>
		<a href="${createLink(controller:'post', action:'feedback')}" id="feedback-tab" class="iframe"></a>
		<div id="wrapper">
			<div id="wrapper-shadow-left"></div>
			<div id="wrapper-shadow-right"></div>
			<div id="header">
			<div id="header-left-fold"></div>
			<g:if test="${request?.user?.id}">
				<div id="user-info">
					<img id="user-avatar" alt="${request?.user}" src="${request?.avatar}?${request?.avatarVersion}" width="33" height="33" />
					<h1>${request?.user?.firstName}</h1>
					<span id="user-functions"><a href="${createLink(controller:'memberProfile', action:'editProfileInfo')}">profile</a> | <a href="${createLink(controller:'user', action:'logout')}">log out</a> 
					<jsec:hasRole name="ADMINISTRATOR">
					 | <a href="${createLink(controller:'home', action:'admin')}">admin</a> 
					</jsec:hasRole>
					</span>
				    <span id="user-score">Score ${request?.user.score} <img id="user-stars" alt="${request?.user.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-'+request?.user?.starRating()+'.png')}" /></span>
				</div><!-- end div#user-info -->
			</g:if>
			<g:else>
				<div id="user-info">
					<span id="visitor-options"><a href="${createLink(controller:"user", action:"register")}">Join</a> &nbsp; | &nbsp; <a href="${createLink(controller:"home", action:"index")}">Login</a> &nbsp; | &nbsp; <fb:login-button size="small" perms="email, publish_stream" onlogin="facebookLogin();">Login with Facebook</fb:login-button></span>
				</div><!-- end div#user-info -->
			</g:else>
			<g:render template="/layouts/menuWidget"/>
			<a href="${createLink(controller:'home', action:'index')}"><img id="esm-logo" alt="ESM Zone" src="${resource(dir:'images',file:'logo.png')}" /></a>
			<div id="header-right-fold"></div>
		</div><!-- end div#header -->
    	<g:layoutBody />
		<div id="footer">
			<ul id="footer-menu">
				<li><a href="${createLink(controller:"home", action:"about")}" alt="Read About Us">About Us</a> &#149; </li>
				<li><a href="${createLink(controller:"home", action:"contact")}" alt="Contact us">Contact</a> &#149; </li>
				<li><a href="${createLink(controller:"home", action:"privacy")}" alt="Privacy Policy">Privacy</a> &#149; </li>
				<li><a href="${createLink(controller:"home", action:"terms")}" alt="Terms Of Service">Terms Of Service</a> &#149; </li>
				<li><a href="${createLink(controller:"home", action:"faqs")}" alt="FAQs">FAQs</a> &#149; </li>
				<li><a alt="See Our Sponsors">Sponsors</a></li>
			</ul>
			<ul id="sponsor-list">
				<li>Our Sponsors</li>
				<li><a href="http://www.joenamathcamp.com"  target="_blank"><img src="${resource(dir:'images',file:'joenamathcamp.png')}" alt="Sponsor - Joe Namath Footbal Camp" title="Joe Namath Footbal Camp"></a></li>
				<li><a href="http://www.noblemaster.com"  target="_blank"><img src="${resource(dir:'images',file:'noble.png')}" alt="Sponsor - Noble Master Games" title="Noble Masters Games"></a></li>
			</ul>
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