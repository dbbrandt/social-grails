<div class="dialogWidget">
	<div class="widgetHeading">Questions &amp; Answers</div>
 	<div id="visitorDialogWidget" style="display:${!request.user?'block' :'none'}">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <th>#</td>
                                                    
                            <th>Title</td>
                            
                            <th>Score</td>
                            
                            <th>State</td>
                      </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postInstanceList}" status="i" var="postInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                            <td><%=postInstance%></td>

                            <td>${fieldValue(bean: postInstance, field: "score")}</td>
                        
                            <td>${postInstance?.author?.address?.state}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
	</div>
	<div id="userDialogWidget" style="display:${request?.user?'block' :'none'}">
           	<gui:tabView>
           	<gui:tab label="Top 10" active="${(params.dialogTab == 'top10')}">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                                                    
                            <g:sortableColumn property="title" title="Title"/>
                            
                            <g:sortableColumn property="score" title="Score"/>
                            
                            <th>City</th>
                            
                            <g:sortableColumn property="answerCount" title="As"/>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postInstanceList}" status="i" var="postInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                            <td><g:link controller="post" action="view" id="${postInstance.id}"><%=postInstance%></g:link></td>

                            <td>${fieldValue(bean: postInstance, field: "score")}</td>
                        
                            <td>${postInstance?.author?.address?.city}, ${postInstance?.author?.address?.state}</td>
                        
                            <td>${postInstance?.answers.size()} ${fieldValue(bean: postInstance, field: "answerCount")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            </gui:tab>
           	<gui:tab label="Sport Played" active="${(params.dialogTab == 'sports')}">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                           
                            <g:sortableColumn property="title" title="Title"/>
                            
                            <g:sortableColumn property="score" title="Score"/>

                            <th>City</th>

                            <g:sortableColumn property="answerCount" title="As"/>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postSportsList}" status="i" var="postInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                            <td><g:link controller="post" action="view" id="${postInstance.id}"><%=postInstance%></g:link></td>
                        
                            <td>${fieldValue(bean: postInstance, field: "score")}</td>

                            <td>${postInstance?.author?.address?.city}, ${postInstance?.author?.address?.state}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "answerCount")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <g:formRemote 
                	name="dialogGrade" 
					url="[controller:'home',action:'dialogWidget']" 
					update="dialogWidget">
                	<g:hiddenField name="dialogTab" value="sports" />
                	<g:hiddenField name="grade" value="${params.grade}" />
                	<g:select name="sport" from="${com.esm.esmzone.Sport.list()}" optionKey="name" value="${params.sport}" />
                	<g:submitButton class="formButton" name="sports" value="Update"></g:submitButton>					
                </g:formRemote>
            </div>
            </gui:tab>
           	<gui:tab label="Grade" active="${(params.dialogTab == 'grade')}">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                                                    
                            <g:sortableColumn property="title" title="Title"/>

                            <g:sortableColumn property="score" title="Score"/>
                            
							<th>City</th>                            
							
                            <g:sortableColumn property="answerCount" title="As"/>

                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${postGradeList}" status="i" var="postInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>

                            <td><g:link controller="post" action="view" id="${postInstance.id}"><%=postInstance%></g:link></td>
                        
                            <td>${fieldValue(bean: postInstance, field: "score")}</td>

                            <td>${postInstance?.author?.address?.city}, ${postInstance?.author?.address?.state}</td>
                        
                            <td>${fieldValue(bean: postInstance, field: "answerCount")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <g:formRemote 
                	name="dialogGrade" 
					url="[controller:'home',action:'dialogWidget']" 
					update="dialogWidget">
                	<g:hiddenField name="dialogTab" value="grade" />
                	<g:hiddenField name="sport" value="${params.sport}" />
                    <g:select name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${params?.grade}" noSelection="['': '']" />
                	<g:submitButton class="formButton" name="sports" value="Update"></g:submitButton>					
                </g:formRemote>
            </div>
            </gui:tab>
            </gui:tabView>
	</div>
</div>
