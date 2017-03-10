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
				<g:form action="contact" name="contactForm">
				<div id="content-header">
					<h1>Contact Us</h1>
				</div><!-- end div#content-header -->
				<div id="page">
					<p class="output">
						<g:if test="${flash.message}">
							<g:message code="${flash.message}"></g:message>
						</g:if>
					</p>
					<table>
						<col id="section-titles"></col><col id="input-titles"></col><col id="inputs"></col><col id="notes-instructions"></col>
						<g:each var="section" in="${sections}">
							<tr>
								<td><h2>${section?.title}</h2></td>
								<td colspan="3">
									<%=section?.content%>	
									<div class="clearer"></div>
								</td>
							</tr>
						</g:each>
						<tr><td><h2>Send us a message</h2></td><td>Name</td><td colspan="2"><input type="text" name="name"/></td></tr>
						<tr><td></td><td>Email</td><td colspan="2"><input type="text" name="email"/></td></tr>
						<tr><td></td><td>Message</td><td colspan="2"><textarea name="message"></textarea></td></tr>
					</table>
					</div><!-- end div#page -->
					<div id="content-footer">
						<a href="javascript:submitform('contactForm')" class="right button">Send</a>
					</div><!-- end div#content-footer -->
				</g:form>
			</div><!-- end div#content -->
		</div><!-- end div#container -->			
    </body>
</html>