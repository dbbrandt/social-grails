<%@ page import="com.esm.esmzone.MemberProfile" %>
<%@ page import="com.esm.esmzone.SystemConfig" %>
<%@ page import="com.esm.promotion.QuestionPromotion" %>
<%@ page import="com.esm.esmzone.ESMTransactionController" %>
<g:set var="transCtlr" value="${new ESMTransactionController()}"/>
<g:if test="${homepage}">
	<div id="personal-stats">
</g:if>
<g:else>
<div id="personal-stats-container">
	<div id="personal-stats">
</g:else>
		<div class="transactions section"><!-- begin transactions section -->
			<g:set var="transactionCount" value="${request?.user?.alertCount}"/>
			<g:set var="transactionsFound" value="${false}"/>
			<span class="counter">${transactionCount}</span><!-- transactions number goes here -->
			<h3>Transactions</h3>
			<ul>
				<g:each in="${request?.user?.transactionList(5)}" var="trans">  
					<g:set var="transactionsFound" value="${true}"/>
					<li>
						<a id="trans_${trans?.id}" title="${trans?.message}" alt="${trans?.message}" href="${createLink(controller:'ESMTransaction', action:'viewDetail',id:trans?.id)}" class="see-more-link ${transCtlr.isIframe(trans.type,'iframe')}">
							<div style="${transCtlr.alertFormat(trans)}">${trans.type.toString().toLowerCase()} from ${trans.member} - <g:formatDate format="M/d hh:mm" date="${trans.dateCreated}" /></div> 
						</a>
					</li>
				</g:each>
			</ul>
			<g:if test="${transactionsFound}">
				<a href="${createLink(controller:'ESMTransaction', action:'transactionReport')}" class="see-more-link iframe">See all transations</a>
			</g:if>
			<g:else>
				No transactions
			</g:else>
		</div><!-- end alerts section -->
		<div class="fans-mentors section"><!-- begin fans/mentors section -->
			<g:set var="fanlist" value="${request?.user?.connectionList(10)}"/>
			<span class="counter" sytle="margin-top:-10px;">${fanlist.size()}</span><!-- fans/mentor number goes here -->
			<h3>My Fans &#149; Mentors</h3>
			<div id="avatar-gallery">
				<g:each in="${fanlist}" var="fan">
					<a href="${createLink(controller:'memberProfile', action:'view')}?userId=${fan?.id}">
						<img id="avatar_${fan?.id}"  title="${fan}" src="${fan?.avatarFile()}" class="avatar" />
					</a>
				</g:each>
			</div><!-- end div#avatar-gallery -->
			<a href="${createLink(controller:'user', action:'fanReport')}" class="see-more-link iframe">See all fans and mentors</a>
			<g:set var="fanRequestCount" value="${request?.user?.fanRequests(0).size()}"/>
			<br><br>
			<h3>Fan Requests</h3>
			<ul>
				<g:each in="${request?.user?.fanRequests(5)}" var="fanRequest">  
					<li>${fanRequest.user} has sent you a <a id="request_${fanRequest?.id}" title="${fanRequest?.message}" alt="${fanRequest?.message}" href="${createLink(controller:'networkConnection', action:'requestReport')}" class="see-more-link iframe">${fanRequest.type.toString().toLowerCase()}</a> request.</li>
				</g:each>
			</ul>
			<g:if test="${fanRequestCount > 0}">
				<a href="${createLink(controller:'networkConnection', action:'requestReport')}" class="see-more-link iframe">See all requests</a>
			</g:if>
			<g:else>
				No requests
			</g:else>

		</div><!-- end fans/mentors section -->
		<div class="medals section"><!-- begin medals section -->
			<h3>Medals</h3>
			<ul>
				<g:set var="medals" value="${request?.user?.medals()}"/>
				<g:each in="${medals}" var="medal">			
					<li>
						<img  id="medal_${medal.value}" title="${medal.name}" alt="${medal.name}"  src="${resource(dir:'images',file:'medal'+medal.value+'.png')}">
					</li>
				</g:each>
				
			</ul>
		</div><!-- end medals section -->
		<div class="prizes section"><!-- begin medals section -->
			<h3>Prizes</h3>
			<g:set var="config" value="${SystemConfig.get(1)}"/>
			<g:set var="promotion" value="${QuestionPromotion.get(config.questionPromotion?.id)}"/>
			<g:set var="messages" value="${promotion?.userStatus(request?.user)}"/>
			${messages?.wins}
			<g:if test="${messages?.wins && messages?.status}">
				<br><br> 
			</g:if>
			${messages?.status}
		</div><!-- end medals section -->
		<div class="stats section"><!-- begin stats section -->
			<h3>Stats</h3>
			<table>
				<colgroup class="left"></colgroup>
				<colgroup></colgroup>
				<tr><td>Total Ratings</td><td>${request?.user?.ratingCount}&nbsp; <img alt="${request?.user?.averageRating} stars" src="${resource(dir:'images/stars',file:'stars-'+request?.user?.starRating()+'.png')}" /></td></tr>
				<tr><td>Questions Asked</td><td>${request?.user?.questionCount}</td></tr>
				<tr><td>Questions Answered</td><td>${request?.user?.answerCount}</td></tr>
				<tr><td>Total Points Earned</td><td>${request?.user?.points}</td></tr>
				<tr><td>Score</td><td>${request?.user?.score}</td></tr>
				<tr><td>Division ${request?.user?.division} Rank</td><td>${request?.user.rank()}</td></tr>
			</table>
		</div><!-- end stats section -->
	</div><!-- end div#personal-stats -->
<g:if test="${homepage}">
	<div id="personal-stats-tab">
		<h3>Personal Stats</h3>
		<span class="counter">${transactionCount}</span>
	</div><!-- end div#personal-stats-tab -->
</g:if>
<g:else>
	<div id="personal-stats-tab" onMouseover="personalStats('bumpopen');" onMouseout="personalStats('bumpclose');" onClick="personalStats('switch');">
		<h3>Personal Stats</h3>
		<div id="personal-stats-tab-counter" class="counter"><div class="round-right"></div><div class="number">${transactionCount}</div><div class="round-left"></div></div>
		<img id="personal-stats-close-button" src="${resource(dir:'images',file:'close-button.png')}" alt="Close your Personal Stats" />
	</div><!-- end div#personal-stats-tab -->
</div><!-- end div#personal-stats-container -->
</g:else>
