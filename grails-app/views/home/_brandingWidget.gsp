<div class="brandingWidget" >
	<div id="visitorBrandingWidget" style="display:${!request.user?'block' :'none'}">
	    <div class="widgetText">Visitor branding. <g:link controller="user" action="register">Join ESMZone Now!</g:link></div>
	    <img src="${createLinkTo(dir:'images',file:'visitorBrandingWrestling.jpg')}" alt="Join ESMZone Now!" />
	</div>
	<div id="memberBrandingWidget" style="display:${request.user?.isMember()?'block' :'none'}">
	    <div class="widgetText">Member branding.</div>
	    <img src="${createLinkTo(dir:'images',file:'memberBrandingFootball.jpg')}" alt="Welcome Back!" />
	</div>
	<div id ="userBrandingWidget" style="display:${request?.user && !request.user?.isMember() ?'block' :'none'}">
	    <div class="widgetText">User branding. Get the benefits of membership. <g:link controller="user" action="subscribe">Subscribe Now!</g:link></div>
	    <g:link controller="user" action="subscribe"><img src="${createLinkTo(dir:'images',file:'userBrandingSoccer.jpg')}" alt="Get the benefits of membership now!" /></g:link>
	</div>
</div>
