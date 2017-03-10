<div class="menu">
	<ul id="menu">
		<g:if test="${!request.menu}"><g:set var="menu" value="home"/></g:if>
		<g:else><g:set var="menu" value="${request.menu}"/></g:else>
		<li value="${(menu=="home")?1:0}"><a href="${createLink(controller:'home', action:'index')}" alt="Home">Home</a><span class="divider">|</span></li>
		<li value="${(menu=="search")?1:0}"><a href="${createLink(controller:'post', action:'search')}" alt="Search">Search</a><span class="divider">|</span></li>
       	<g:if test="${request?.user?.isMember()}">
			<li value="${(menu=="ask")?1:0}"><a href="${createLink(controller:'post', action:'add')}" alt="Ask a Question">Ask a Question</a><span class="divider">|</span></li>
       	</g:if>
       	<g:else>
			<li class="disable" value="${(menu=="ask")?1:0}"><a alt="Ask a Question">Ask a Question</a><span class="divider">|</span></li>
       	</g:else>
       	<li value="${(menu=="standings")?1:0}"><a href="${createLink(controller:'user', action:'standings')}" alt="Standings">Standings</a></li>
	</ul><!-- end ul#menu -->
	<div id="slide"></div>
</div><!-- end div.menu -->
