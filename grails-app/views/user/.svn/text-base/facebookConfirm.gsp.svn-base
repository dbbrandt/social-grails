<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="static">
			<div id="left">
				<div class="box">
					<g:render template="/home/introWidget"/>
				</div><!-- end div.box -->
			</div><!-- end div#left -->
			<div id="content" class="wide">
				<div id="content-header">
					<h1>Welcome to the ESMZone</h1>
				</div><!-- end div#content-header -->
                <g:form action="facebookConfirm" name="confirmForm">
				<input type="hidden" name="id" value="${params.id}"/>
				<input type="hidden" name="inviteFriends" value="">
				<div id="page">
					<p class="output">
						<g:if test="${flash.message}">
							<b><g:message code="${flash.message}"></g:message></b>
						</g:if>
						<g:if test="${user?.hasErrors()}">
							<b><g:renderErrors bean="${user}"/></b>
						</g:if>
					</p>
					<div class="section">
						<div class="section-titles">
							<h2>One more step and you're in...</h2>
						</div>

						<div class="main-content">
							<p>Thank you for joining.  You are almost part of The Place for Student Athletes.
							<p>In order to particiate in prizes and recieve your gifts we need your email address and current grade.</b>.</p> 
						</div>
					</div><!-- end div.section -->
					
					<div class="section">
						<div class="section-titles">
							<h2>Please complete Registration</h2>

						</div>
						<div class="main-content">
							<p>Email Address:&nbsp;&nbsp;<g:textField name="email" value="${params?.email}"/></p>					
							<p>Grade:&nbsp;&nbsp;<g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${params?.grade}" noSelection="['': '']" /></p>					
						</div>
					</div><!-- end div.section -->

    				<div class="section">
						<div class="section-titles">
							<h2>Getting started...</h2>

						</div>
						<div class="main-content">
							<p>You will be able to create a new avatar or upload a different photo after you login.</p>
							<p>Good luck in the competition.  The more you play, the better your chances of winning!</p>
							
						</div>
                    </div><!-- end div.section -->
                    <div class="section">
                        <div class="section-titles">
                            <h2>Invite your friends...</h2>
                        </div>
						<g:if test="${fbContent}">
	                        <div class="main-content">
	                            <p>Earn 50 points for each friend that joins!</p>
	                            <p><a href="javascript:fb_submitAndInvite('confirmForm')">Invite Your Facebook Friends</a></p> 
	                        </div>
	                    </g:if>
                    </div>
				</div><!-- end div#page -->
				<div id="content-footer">
                    <a href="javascript:submitform('confirmForm')" class="right button">Complete Registration</a>
				</div><!-- end div#content-footer -->
            </g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>