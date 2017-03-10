
<%@ page import="com.esm.dialog.Post" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title>${directoryTitle}</title>
    </head>
    <body>
        <div class="body">
            <h1>${directoryTitle}</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
        	<div class="search">
			    <g:form action="searchPosts" name="searchPosts" method="get">
			        <g:textField name="q" value="${params.q}" size="50"/> <input type="submit" value="Search" />
			    </g:form>
			    <g:if test="${postInstanceList.size() == 0}">
			      <br>
			      <p>Nothing matched your query - <strong>${params.q}</strong></p>
			    </g:if>
			</div>
            <div class="list">
                   	<gui:accordion multiple="false" fade="false" vertical="false"> 
                    <g:each in="${postInstanceList}" status="i" var="postInstance">
                    		<g:if test= "${!postInstance?.complaint}">
                          	<div class="question">
				           	<g:link controller="post" action="view" id="${postInstance.id}"><gui:accordionElement title="Score: ${postInstance?.score} &nbsp;&nbsp;Rating: ${postInstance?.ratingValue()} &nbsp;&nbsp;Votes: ${postInstance?.ratings?.size()}  &nbsp;&nbsp; ${postInstance?.title}">
				            	<div class="dialog">
				                   	<div class="postDescription">
				                   	  <img src="${postInstance.author.avatarFile()}"/>
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
			                            <g:each in="${postInstance?.tags}" var="t">
			                                <g:link controller="post" action="tagDirectory" id="${t.tag.id}">${t.tag}</g:link>&nbsp;
			                            </g:each>
				                  </div>
				                  <g:render template="/complaint/flag" model="['contentInstance':postInstance, 'type':'Post']"></g:render>
				                  <div class="comments">
				                  		<b>Comments</b><br><br>    
				                        <g:each in="${postInstance?.comments}" var="c">
				                    		<g:if test= "${!c?.complaint}">
				                            ${c?.encodeAsHTML()}<br><br>
				                            ${c?.author}&nbsp;${c?.lastUpdated}<br></br>
							                  <g:render template="/complaint/flag" model="['contentInstance':c, 'type':'PostComment']"></g:render>
				                            </g:if>
				                        </g:each>
				            	 </div>
				            	 <div class="answers">
				            	 
				                   	  <div class="displayLink"><g:link controller="post" action="view" id="${postInstance?.id}">${postInstance?.answers.size()} Answers</g:link></div>
				                   	  
				            	 </div>
				            </div>
				            </gui:accordionElement></g:link>
				        </div>
				        </g:if>         
                    </g:each>
               </gui:accordion>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${postInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
