<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=7"/>
        <gui:resources components="['expandablePanel','accordion', 'menu', 'tabView', 'dialog', 'autoComplete']"/>
        <title><g:layoutTitle default="Grails" /></title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'esmzone.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
        <g:javascript library="yui" />
    </head>
    <body class="yui-skin-sam">
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="Spinner" />
        </div>
        <div id="loginBox" class="loginBox">
			<jsec:isLoggedIn>
				<g:render template="/user/welcomeMessage"></g:render>
			</jsec:isLoggedIn>
			<jsec:isNotLoggedIn>
				<g:render template="/user/loginForm"></g:render>				
			</jsec:isNotLoggedIn>
		</div>

        <div class="logo">
			<g:link controller="home"><img src="${createLinkTo(dir:'images',file:'esmzone-logo.gif')}" alt="ESMZone" /></g:link>
		</div>
		<div class='mainmenu' id='mainmenu'>
		</div>
         <gui:menubar id='mainmenubar' renderTo='mainmenu' autosubmenudisplay="true" shadow="true">
         
           	<gui:menuitem url="/esmzone">Home</gui:menuitem>
           	<jsec:hasRole name="ADMINISTRATOR">
            	<gui:submenu label='User'>
	             	<gui:menuitem url="${createLink(controller:'user', action:'list')}">Users</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'memberProfile', action:'list')}">User Profile</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'securityQuestion', action:'list')}">Security Questions</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'stateProvince', action:'list')}">States</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'subject', action:'list')}">Subjects</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'sport', action:'list')}">Sports</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'school', action:'list')}">Schools</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'networkConnection', action:'list')}">Connections</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'address', action:'list')}">Addresses</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'avatar', action:'list')}">Avatar</gui:menuitem>
				</gui:submenu>
            	<gui:submenu label='Competition'>
	             	<gui:menuitem url="${createLink(controller:'pointsType', action:'list')}">Points Types</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'points', action:'list')}">User Points</gui:menuitem>
				</gui:submenu>
            	<gui:submenu label='Subscription'>
	             	<gui:menuitem url="${createLink(controller:'paymentMethod', action:'list')}">Payment Methods</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'subscriptionType', action:'list')}">Suscription Type</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'billingInfo', action:'list')}">Billing Info</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'subscription', action:'list')}">Subscriptions</gui:menuitem>
				</gui:submenu>
            	<gui:submenu label='Dialog'>
	             	<gui:menuitem url="${createLink(controller:'post', action:'list')}">Posts</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'postRating', action:'list')}">Post Ratings</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'postComment', action:'list')}">Post Comments</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'answer', action:'list')}">Answers</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'answerRating', action:'list')}">Answer Ratings</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'answerComment', action:'list')}">Answer Comments</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'tag', action:'list')}">Tags</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'tag', action:'treeView')}">Tag Hierarchy</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'complaint', action:'list')}">Complaints</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'postType', action:'list')}">Post Types</gui:menuitem>
            	</gui:submenu>
            	<gui:submenu label='Mentor'>
	             	<gui:menuitem url="${createLink(controller:'mentorApplication', action:'list')}">Applications</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'mentorQuiz', action:'list')}">Quizes</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'reference', action:'list')}">References</gui:menuitem>
				</gui:submenu>            	
            	<gui:submenu label='Patron'>
	             	<gui:menuitem url="${createLink(controller:'patron', action:'list')}">Patron</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'source', action:'index')}">User Sources</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'patron', action:'patronRequests')}">Pending Requests</gui:menuitem>
				</gui:submenu>            	
            	<gui:submenu label='Survey'>
	             	<gui:menuitem url="${createLink(controller:'survey', action:'list')}">Surveys</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'question', action:'list')}">Questions</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'response', action:'list')}">Responses</gui:menuitem>
				</gui:submenu>            	
            	<gui:submenu label='Promotions'>
	             	<gui:menuitem url="${createLink(controller:'questionPromotion', action:'list')}">Promotions</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'questionPromotionEntry', action:'list')}">Promotion Entries</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'questionPromotion', action:'backdateEntries')}">Backdate Today's Entries</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'questionPromotion', action:'reActivate')}">Reactivate Promotion</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'questionPromotion', action:'backdateCurrentQuestion')}">Backdate Current Question</gui:menuitem>
				</gui:submenu>            	
            	<gui:submenu label='System'>
	             	<gui:menuitem url="${createLink(controller:'systemConfig', action:'index')}">System Config</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'backgroundImage', action:'index')}">Background Images</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'complaint', action:'report')}">Complaint Report</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'user', action:'admin')}">User Admin</gui:menuitem>
    			</gui:submenu>            	
            	<gui:submenu label='CMS'>
	             	<gui:menuitem url="${createLink(controller:'contentPage', action:'index')}">Content Page</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'contentSection', action:'index')}">Content Section</gui:menuitem>
	             	<gui:menuitem url="${createLink(controller:'contentTemplate', action:'index')}">Content Templates</gui:menuitem>
    			</gui:submenu>            	
            </jsec:hasRole>
            
           	<g:if test="${request?.user?.isMember()}">
            <gui:menuitem url="${createLink(controller:'user', action:'logout')}">Logout</gui:menuitem>
            </g:if>
         </gui:menubar>
       <g:layoutBody />
       <script type="text/javascript">
		var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
		document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
		</script>
		<script type="text/javascript">
		try {
		var pageTracker = _gat._getTracker("UA-15192439-1");
		pageTracker._trackPageview();
		} catch(err) {}
	   </script>
    </body>
</html>