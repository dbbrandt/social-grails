<html>
    <head>
        <title>ESM ZONE - Spectator Page</title>
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
					<h1>Spectators</h1>
				</div><!-- end div#content-header -->
				<div id="page">

					<g:each var="section" in="${contentPage?.sections}">
						<div class="section">
							<div class="section-titles">
								<h2>${section?.name}</h2>
							</div>
							<a class="expand" href="#">${section?.title}</a>
							<div class="main-content collapse" style="margin-top:10px;">
								<%=section?.content%>	
							</div>
							<!-- <div class="clearer"></div> -->
						</div><!-- end div.section -->
					</g:each>

				</div><!--  end#page -->
				<div id="content-footer">
				</div><!-- end div#content-footer -->
			</div><!-- end div#content -->
		</div><!-- end div#container -->
		<script type="text/javascript">
			jQuery(function() {
				jQuery("a.expand").toggler({method: "slideFadeToggle"});
				jQuery("#content").expandAll({trigger: "a.expand", ref: "div.conversation", showMethod: "slideDown", hideMethod: "slideUp", speed: 300, oneSwitch: false});
			});
		</script>
    </body>
</html>