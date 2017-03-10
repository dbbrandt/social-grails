<%@ page import="com.esm.esmzone.ESMTransactionController" %>
<g:set var="transCtlr" value="${new ESMTransactionController()}"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN"
"http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <link rel="stylesheet" href="${resource(dir:'css',file:'style.css')}" />
</head>
<body>
<div id="popup">
	<div class="menu">
		<h1>Transaction Report</h1>
		<span class="counter">${request?.user?.alertCount}</span>
	</div><!-- end div#menu -->
	<div id="content">
		<table>
		    <g:each in="${transactionList}" status="i" var="trans">
				<tr style="${transCtlr.alertFormat(trans,false)}">
					<td><a title="View ${trans.type}" alt="VIEW ${trans.type}" href="${createLink(action:'viewDetail',id:trans.id)}" target="${transCtlr.isIframe(trans.type,'','_top')}"><div style="${transCtlr.alertFormat(trans,false)}"><g:formatDate format="hh:mm M/d/yyyy" date="${trans.dateCreated}" /></a></td>
					<td>${trans.type}</td>
					<td><a title="View PROFILE" alt="View PROFILE" href="${createLink(controller:'memberProfile', action:'view')}?userId=${trans.member.id}" target="_top"><div style="${transCtlr.alertFormat(trans,false)}">${trans.member}</div></a></td>
					<td>&nbsp;</td>
					<td><a title="Clear" alt="Clear" href="${createLink(action:'clearTransaction',id:trans.id)}"><img src="${resource(dir:'images',file:'close-button-dark.png')}" alt="Clear transaction" /></a></td>
				</tr>
				<tr>
					<td colspan="4" style="padding:0px 0px 0px 20px;"><a title="${trans.message}" alt="${trans.message}" href="${createLink(action:'viewDetail',id:trans.id)}" target="${transCtlr.isIframe(trans.type,'','_top')}"><div style="font-size:10px;${transCtlr.alertFormat(trans,false)}">${transCtlr.shortMessage(trans)}</div></a></td>
					<td style="padding:0px;">&nbsp;</td>
				</tr>
			</g:each>
		</table>
	</div><!-- end div#content -->
</div><!-- end div#popup --></body>
</html>
