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
					<h1>Privacy Policy</h1>
				</div><!-- end div#content-header -->
				<div id="page">

					<g:each var="section" in="${sections}">
			            <div class="section">
			                <div class="section-titles">
			                    <a name="${section?.name}"><h2>${section?.title}</h2></a>
			                </div>
			                <div class="main-content">
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
    </body>
</html>