<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="main" />
    </head>
    <body>
		<div id="container" class="static">
			<div id="left">
				<p class="ask_answer_win"><img src="${resource(dir:'images', file:'ask_answer_win.png')}" alt="Ask. Answer. WIN!" width="254" height="107" /></p>
				<p class="bulletedText">At ESM Zone you can...<br /> + Build a Character Credential<br /> + Standout as a Leader<br /> + Make Friends and be a Mentor<br /> + Share Sports Knowledge<br /> + Win Cool Stuff</p>
				<p class="bulletedText">Get in the game today.<br /> Earn 50 bonus points now!</p>
				<div id="about-info">
					<p><span style="color: #4169e1; font-family: Verdana, sans-serif; font-size: xx-small;">ESMZone is based on a simple concept &mdash;<br />Character is as important as Academic<br />Achievement and Athletic Accomplishment.<br /><br />Create your <strong><em><span style="text-decoration: underline;">Character Credential today!</span></em></strong><br />Simply participate. You and your peers do the rest.<br /><br />+ ASK a good question: Get Points.<br />+ Good ANSWERS: Get More Points.<br />+ WIN PRIZES for highly rated contributions.<br /><br />You and your peers rate each other's questions and answers. Highly rated contributions earn more points. The more your peers like what you have to say, the better your rating. Start building your Character Credential now.</span></p>
				</div>
				<div id="register-button">
						<p><a href="${createLink(controller:'user', action:'joinToday')}" class="iframe">Join ESMZone Today</a> &gt;&gt;</p>
				</div>
			</div><!-- end div#left -->
			<div id="content" class="wide">
				<g:form action="register" name="registerForm">
				<div id="content-header">
					<g:if test="${params.player == 'no'}">
						<h1>Athlete Registration</h1>
					</g:if>
					<g:else>
						<h1>Spectator Registration</h1>
					</g:else>
				</div><!-- end div#content-header -->
				<div id="page">
						<g:if test="${!source?.message}">
							<center><p class="output"><b>A promotion code is required for FREE early access to the ESMZone beta release.</b></p></center>
						</g:if>
						<g:else>
							<p class="output"><%=source?.message%></p>
						</g:else>
						<p class="output" id="error">
							<g:if test="${flash.message}">
								<g:message code="${flash.message}"></g:message>
							</g:if>
						</p>
						<div class="output" id="error">
							<g:if test="${user?.hasErrors()}">
								<g:renderErrors bean="${user}"/>
							</g:if>
						</div>
						<div class="output" id="error">
							<g:if test="${profile?.hasErrors()}">
								<g:renderErrors bean="${profile}"/>
							</g:if>
						</div>
						<div class="output" id="error">
							<g:if test="${address?.hasErrors()}">
								<g:renderErrors bean="${address}"/>
							</g:if>
						</div>										
						<table>
							<col id="section-titles"/>
							<col id="input-titles"/>
	
							<col id="inputs"/>
							<col id="notes-instructions"/>
							<tbody>
								<tr>
									<td colspan="2"><fb:login-button size="small" perms="email, publish_stream" onlogin="facebookLogin();">Join with your Facebook Login</fb:login-button></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td>&nbsp;&nbsp;- or -</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="2"><h2>Join using your email address:</h2></td>
									<td></td>
									<td></td>
								</tr>															
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td></td>
									<td>Promotion Code</td>
									<td><g:textField name="coupon" value="${source?.coupon}"/></td>
									<td>All fields are required</td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td><h2>General information</h2></td>
									<td>First Name</td>
									<td><g:textField name="firstName" value="${user?.firstName}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Last Name</td>
									<td><g:textField name="lastName" value="${user?.lastName}"/></td>
									<td></td>
								</tr>
								<g:if test="${params.player == 'no'}">
									<tr>
										<td></td>
										<td>Role</td>
										<td>
											<g:select class="role" name="role" from="${[['id':5, 'value':'Coach'],['id':6, 'value':'Recruiter'],['id':7, 'value':'Sponsor/Advertiser'],['id':8, 'value':'Parent']]}" optionValue="value" optionKey="id" value="${params?.role}" noSelection="['': '']" />
										</td>
										<td></td>
									</tr>
						        </g:if>
						        <g:else>
									<tr>
										<td></td>
										<td>Grade</td>
										<td>
											<g:select class="grade" name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${profile?.grade}" noSelection="['': '']" />
										</td>
										<td>Grade is required for division standings</td>
									</tr>
								</g:else>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
								<tr>
									<td><h2>Account Information</h2></td>
									<td>Email Address</td>
									<td><g:textField name="email" value="${user?.email}"/></td>
									<td>Earn 50 points for membership</td>
								</tr>
								<tr>
									<td></td>
									<td>Choose password</td>
									<td><g:passwordField name="password" value="${params?.password}"/></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td>Re-enter password</td>
									<td><g:passwordField name="confirm" value="${params?.confirm}"/></td>
									<td></td>
								</tr>
								<tr>
									<td colspan="4">&nbsp;</td>
								</tr>
                                <tr>
                                    <td colspan="3"><b>Check here to confirm you are at least 13 years old &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</a></b>
                                    <input style="margin-top:2px;margin-left:40px;margin-botom:10px;" type="checkbox" name="ageTerms" id="checkbox"/></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan="3"><b>Check the following box to accept the <a href="${createLink(controller:"home", action:"terms")}" alt="Terms of Service"><u>terms of service</u>: &nbsp;</a></b>
                                    <input style="margin-top:2px;margin-left:40px;margin-botom:10px;" type="checkbox" name="acceptTerms" id="checkbox"/></td>
                                    <td></td>
                                </tr>
    						</tbody>
						</table>
					</div><!-- end div#page -->
					<div id="content-footer">
						<a href="javascript:submitform('registerForm')" class="right button">Join</a>
					</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>