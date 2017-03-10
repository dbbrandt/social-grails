
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title>Private Questions</title>
    </head>
    <body>
        <div class="body">
            <h1>Private Questions</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
       		<g:if test="${postInstanceList}">
            <div class="list">
                   	<gui:accordion multiple="false" fade="false" vertical="false"> 
                    <g:each in="${postInstanceList}" status="i" var="postInstance">
                          	<div class="question">
				           	<g:link controller="post" action="view" id="${postInstance.id}"><gui:accordionElement title="${(postInstance?.author == request?.user)? 'Member':'Author' }: ${postInstance?.getFan(request?.user)} &nbsp;&nbsp;Modified: ${postInstance?.lastUpdated}  &nbsp;&nbsp; ${postInstance.title}">
				            	<div class="dialog">
				                   	<div class="postDescription">
				                   	  <g:link controller="post" action="view" id="${postInstance.id}">${postInstance?.title}</g:link><br>
					                  <%=postInstance.description%>
					                </div>
					                <div class="author">
					                	Author: <g:link controller="memberProfile" action="view" id="${postInstance?.author?.id}">${postInstance?.author?.encodeAsHTML()}</g:link><br/>
					                	<g:if test="${postInstance?.member}">
						                	Member: <g:link controller="memberProfile" action="view" id="${postInstance?.member?.id}">${postInstance?.member}</g:link><br/>
					                	</g:if>
					                	Last Modified: ${postInstance?.lastUpdated}
					                </div>     
					                <div class="tags">
			                            <b>Tags:</b>
			                            <g:each in="${postInstance.tags}" var="t">
			                                <g:link controller="post" action="tagDirectory" id="${t.id}">${t?.encodeAsHTML()}</g:link>&nbsp;
			                            </g:each>
				                  </div>     
				                  <div class="comments">
				                  		<b>Comments</b><br><br>    
				                        <g:each in="${postInstance.comments}" var="c">
				                            ${c?.encodeAsHTML()}<br><br>
				                            ${c?.author}&nbsp;${c.lastUpdated}<br></br>
				                        </g:each>
				            	 </div>
				            	 <div class="answers">
				            	 
				                   	  <div class="displayLink"><g:link controller="post" action="view" id="${postInstance?.id}">${postInstance?.answers.size()} Answers</g:link></div>
				                   	  
				            	 </div>
				            </div>
				            </gui:accordionElement></g:link>
				        </div>         
                    </g:each>
               </gui:accordion>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postInstanceTotal}" />
            </div>
            </g:if>
            <g:else>
            <div>
            <b>No private questions.</b>
            </div>
            </g:else>
        </div>
    </body>
</html>
