<html>
    <head>
        <title>ESM ZONE - The Place For Student Athletes</title>
		<meta name="layout" content="mainA1" />
    </head>
    <body>
        <g:set var="containerClass" value="${(request?.user)?'homepage':'landing'}"/>
		<div id="container" class="${containerClass}">
			<div id="left">
				<g:if test="${request?.user}">
					<div class="box">
						<g:render template="/memberProfile/personalStatsWidget" model="['homepage':true]"/>
					</div><!-- end div.box -->
				</g:if>
				<g:else>
					<div class="box">
						<h1>Welcome to ESM Zone</h1>
						<p>ESM Zone is this awesome new tool for athelete students to come together in this online platform to share their experiences in sports and acedemics.</p>
						<a href="${createLink(controller:'user', action:'register')}">Join us today</a>
						<img id="sports-icons" src="${resource(dir:'images',file:'sports-icons.png')}" alt="Cycling Football Skating Basketball Bowling" />
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque eget eleifend est. Sed sed scelerisque nibh. Mauris volutpat turpis a magna placerat non tempor arcu gravida.</p>
						<p>Donec laoreet mi sed lorem lobortis suscipit. Proin eget justo odio, vehicula accumsan tortor. Nullam vulputate nulla enim, eu semper nisi. Maecenas eu odio turpis, bibendum tempus sem. Pellentesque id posuere nulla. Nullam malesuada urna non enim congue fringilla. Mauris placerat mattis ligula ut feugiat.</p>
						<a href="${createLink(controller:'user', action:'register')}" class="right button">Register and Join ESM Zone</a>
					</div><!-- end div.box -->
					<div class="ad box">
						<h1>Page sponsored by HP</h1>
						<a href="#" class="ad-link"><img src="${resource(dir:'images',file:"ad-large.jpg")}" alt="Printing Payback Guaranteed - by HP" class="ad" /></a>
					</div><!-- end div.ad.box -->
				</g:else>
			</div><!-- end div#left -->
			<g:if test="${!request?.user}">
				<div id="banner">
					<div id="banner-splash">
						<a href="${createLink(controller:'user', action:'register')}" class="join-link right button">Join ESM Today</a>
			            <g:form name="login" controller="user" action="login" method="post" >
							<h2>The Place For Student Athletes</h2>
							<label for="username">Log on to ESM</label>
							<g:textField name="login" class="loginText" value="${loginError}></g:textField>
							<g:passwordField name="password" class="loginText"></g:passwordField>
							<input type="submit" class="submit button right" value="Go" />
						</g:form>
					</div>
				</div>
			</g:if>
			<div id="content" class="narrow">
				<div id="content-header">
					<g:form name="search-form" id="search-form" method="get" action="indexA1">
						<input type="hidden" name="homeTab" value="${params.homeTab}"/>
				        <g:textField name="q" class="entry-field" value="${params.q?params.q:'Find Questions and Answers'}" size="62"/> 
						<input type="image" class="submit" src="${resource(dir:'images',file:'search-button.gif')}" alt="Submit Question" />    
					</g:form>
					<ul class="menu">
						<li><a class="${(params.homeTab == 'Everyone')?'current':''}" href="?homeTab=Everyone">Everyone</a></li>
						<li><a class="${(params.homeTab == 'Mine')?'current':''}" href="?homeTab=Mine">Mine</a></li>
						<li><a class="${(params.homeTab == 'Fans')?'current':''}" href="?homeTab=Fans">My Fans</a></li>
						<li><a class="${(params.homeTab == 'Mentors')?'current':''}" href="?homeTab=Mentors">My Mentors</a></li>
						<li><a class="${(params.homeTab == 'Private')?'current':''}" href="?homeTab=Private">Private</a></li>
					</ul>
				</div><!-- end div.content-header -->
				<g:if test="${postInstanceList?.size() > 0}">
				<g:each in="${postInstanceList}" var="postInstance">
					<div id="conversationQuestion${postInstance.id}" class="conversation" >
						<g:render template="/post/conversationWidget" model="['postInstance':postInstance, 'answerInstance':postInstance.topAnswer()]"/>
					</div><!-- end div.conversation -->
				</g:each>
				</g:if>
				<g:else>
					<div class="conversation" >
						<p>&nbsp;&nbsp;No results found.</p>
					</div><!-- end div.conversation -->
				</g:else>
				<div id="content-footer">
					<a href="[PATH TO PREVIOUS PAGE IF EXTANT]" class="left button">Previous</a>
					<ul>
						<li>1 &#149; </li>
						<li><a href="[PAGE 2 PATH]">2</a> &#149; </li>
						<li><a href="[PAGE 3 PATH]">3</a> &#149; </li>
						<li><a href="[PAGE 4 PATH]">4</a> &#149; </li>
						<li><a href="[PAGE 5 PATH]">5</a></li>
					</ul>
					<a href="[PATH TO NEXT PAGE IF EXTANT]" class="right button">Next</a>
				</div><!-- end div#content-footer -->
			</div><!-- end div#content -->
			<div id="right">
				<div class="box">
					<div id="shoutOutWidget">
						<g:render template="/post/shoutOutWidget"></g:render>
					</div>
					<g:render template="/user/standingsWidget"></g:render>
				</div><!-- end div.box -->
			</div><!-- end div#right -->
		</div><!-- end div#container -->			
    </body>
</html>