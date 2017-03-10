<html>
    <head>
    	<resource:tabView/>
        <title>ESMZone Standings</title>
		<meta name="layout" content="mainAdmin" />
    </head>
    <body>
			<div class="homePagePanel">
		        <h1>ESMZone Divisional Standings</h1>
			</div>
			<div class="standings">
				<richui:tabView id="standings">
					<richui:tabLabels>
						<richui:tabLabel selected="${(params.standingsTab == 'Division1')? 'true':'false'}" title="8th and Under"/>
						<richui:tabLabel selected="${(params.standingsTab == 'Division2')? 'true':'false'}" title="9th and 10th"/>
						<richui:tabLabel selected="${(params.standingsTab == 'Division3')? 'true':'false'}" title="11th and Over"/>
					</richui:tabLabels>
					
					<richui:tabContents>
						<richui:tabContent>
						   <div class="standingsWidget">
						   		<g:render template="/standings/standingsWidget" model="['userInstanceList':userDivision1List, 'standingsTab':'Division1']"></g:render>
						   </div>
						</richui:tabContent>
						<richui:tabContent>
						   <div class="standingsWidget">
						   		<g:render template="/standings/standingsWidget" model="['userInstanceList':userDivision2List,'standingsTab':'Division2']"></g:render>
						   </div>
						</richui:tabContent>
						<richui:tabContent>
						   <div class="standingsWidget">
						   		<g:render template="/standings/standingsWidget" model="['userInstanceList':userDivision3List,'standingsTab':'Division3']"></g:render>
						   </div>
						</richui:tabContent>
					</richui:tabContents>
				</richui:tabView>
			</div>
			
    </body>
</html>