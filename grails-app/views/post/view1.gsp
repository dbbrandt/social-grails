<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'post.label', default: 'Post')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="body">
            <h1>Question</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
           	<div class="question">
	           	<gui:expandablePanel bounce="false" title="${postInstance.title}">	      
	           		<div class="dialog">
	                   	<div class="postDescription">
	                   	  <img src="${postInstance.author.avatarFile()}"/>
		                  <b><%=postInstance.description%></b>
		                </div>
		                <div class="author">
		                	Author: <g:link controller="memberProfile" action="view" id="${postInstance?.author?.id}">${postInstance?.author}</g:link><br/>
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
	                  <g:render template="/complaint/flag" model="['contentInstance':postInstance, 'type':'Post']"></g:render>
	                  <g:if test="${postInstance.isEditable(request?.user)}">
				          <div class="buttonlinks">
				               <span class="buttonlink"><g:link class="edit" action="modify" id="${postInstance?.id}">${message(code: 'default.button.edit.label', default: 'Edit')}</g:link></span>
			    	      </div>
			    	  </g:if>
	                  <div class="comments">
	                  		<b>Comments:</b><br><br>    
	                        <g:each in="${postInstance.comments}" var="c">
	                        	<g:if test= "${!c?.complaint}">
	                            <b>${c?.encodeAsHTML()}</b><br>
	                            ${c?.author}&nbsp;${c.lastUpdated}<br></br>
  			                    <g:render template="/complaint/flag" model="['contentInstance':c, 'type':'PostComment']"></g:render>
	                            </g:if>
	                        </g:each>
	                        <g:if test="${request?.user?.isMember()}">
	        					<div class="commentAdd">
						            <g:hasErrors bean="${postCommentInstance}">
						            <div class="errors">
						                <g:renderErrors bean="${postCommentInstance}" as="list" />
						            </div>
						            </g:hasErrors>
	            					<g:form name="postComments" controller="post" action="view" method="post" >
	                                    <g:hiddenField name="id" value="${postInstance?.id}" />
					 	                <g:hiddenField name="target" value="postComment" />
	                                    <g:textField name="postComment.description" size="90" maxlength="250"/>
						                <div class="buttonslink">
						                    <span class="buttons"><g:submitButton name="add" class="save" value="Add" /></span>
						                </div>
	            					</g:form>
	            				</div>
	            			</g:if>
	            	 </div>
	            </gui:expandablePanel>
	        </div>
	        <g:if test="${postInstance?.author != request?.user}">
	        	<g:render template="/post/ratingWidget" model="['rateingInstance':postInstance]"></g:render>
			</g:if>
	        <div class="answers">
	            <h1>Answers</h1>
                    <g:each in="${postInstance.answers}" var="a">
                       	<g:if test= "${!a?.complaint}">
			           	<gui:expandablePanel bounce="false" title="${a} ${(a.post.bestAnswer == a)?'--->BEST ANSWER! ':''}">	      
	                    	<div class="postDescription">
		                   	    <img src="${a.author.avatarFile()}"/>
					        	<g:render template="/answer/bestAnswerWidget" model="['answerInstance':a]"></g:render>
	                    		<b><%=a?.description%></b>
	                    	</div>
	                    	<div class="author">
		                	    Author: <g:link controller="memberProfile" action="view" id="${a?.author?.id}">${a?.author?.encodeAsHTML()}</g:link><br/>
	                    	    Last Updated:  ${a?.lastUpdated}
	                    	</div>
		                    <g:render template="/complaint/flag" model="['contentInstance':a, 'type':'Answer']"></g:render>
	                    	<div class="comments">
		                  		<b>Comments:</b><br><br>    
		                        <g:each in="${a?.comments}" var="c">
			                       	<g:if test= "${!c?.complaint}">
		                            <b>${c?.encodeAsHTML()}</b><br><br>
		                            ${c?.author}&nbsp;${c?.lastUpdated}<br></br>
 				                    <g:render template="/complaint/flag" model="['contentInstance':c, 'type':'AnswerComment']"></g:render>
		                            </g:if>
		                        </g:each>
	                        	<g:if test="${request?.user?.isMember()}">
		        					<div class="commentAdd">
		 	            					<g:form name="answerComments" controller="post" action="view" method="post" >
	               							<g:hiddenField name="id" value="${postInstance?.id}" />
		                                    <g:hiddenField name="answer.id" value="${a?.id}" />
					 	                	<g:hiddenField name="target" value="answerComment" />
		                                    <g:textField name="answerComment.description" size="90" maxlength="250"/>
							                <div class="buttonslink">
							                    <span class="buttons"><g:submitButton name="add" class="save" value="Add" /></span>
							                </div>
		            					</g:form>
		            				</div>
		            			</g:if>
	                    	</div>	
		            </gui:expandablePanel>
                   	<g:render template="/answer/ratingWidget" model="['answerInstance':a]"></g:render>
		            </g:if>
                    </g:each>
            </div>
        </div>
        <g:if test="${request?.user?.isMember()}">
	        <div class="answerEdit">
	            <h1>Add Answer</h1>
	            <g:hasErrors bean="${answerInstance}">
	            <div class="errors">
	                <g:renderErrors bean="${answerInstance}" as="list" />
	            </div>
	            </g:hasErrors>
	            <g:form name="answer" controller="post" action="view" method="post" >
	               <g:hiddenField name="id" value="${postInstance?.id}" />
	               <g:hiddenField name="target" value="answer" />
	                <div class="dialog">
	                    <table style="border:0px">
	                        <tbody>
	                            <tr class="prop">
	                                <td valign="top" class="value ${hasErrors(bean: answerInstance, field: 'description', 'errors')}">
	                                    <fckeditor:editor name="answer.description" width="600" height="300" toolbar="Basic"><%=answerInstance?.description%></fckeditor:editor>							
	                                </td>
	                            </tr>
	                        
	                        </tbody>
	                    </table>
	                </div>
	                <div class="buttonlinks">
	                    <span class="button"><g:submitButton name="create" class="save" value="Submit" /></span>
	                </div>
	            </g:form>
	        </div>
	    </g:if>
    </body>
</html>
