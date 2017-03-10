<div class="scoreWidget">
	<div class="widgetHeading">ESMZone Stats</div>
 	<div id="visitorScoreWidget" style="display:${!request.user?'block' :'none'}">
            <div class="list">
                <table>
                    <thead>
                        <tr>
                            <th>#</td>
                                                    
                            <th>First Name</td>
                            
                            <th>Score</td>
                            
                            <th>State</td>
                            
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "score")}</td>

                            <td>${userInstance?.address?.state}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
	</div>
	<div id="userScoreWidget" style="display:${request?.user?'block' :'none'}">
           	<gui:tabView>
            <div class="list">
           	<gui:tab label="Top 10" active="${(params.scoreTab == 'top10')}">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                                                    
                            <g:sortableColumn property="firstName" title="Name"/>
                            
                            <g:sortableColumn property="score" title="Score"/>
                            
                            <th>City</th>
                            
                            <g:sortableColumn property="questionCount" title="Qs"/>

                            <g:sortableColumn property="answerCount" title="As"/>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userInstanceList}" status="i" var="userInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                        	<g:if test="${request?.user?.isMember() }">
    	                        <td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "firstName")} ${fieldValue(bean: userInstance, field: "lastName")}</g:link></td>
							</g:if>
							<g:else>
	                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
							</g:else>
                            <td>${fieldValue(bean: userInstance, field: "score")}</td>
                        
                            <td>${userInstance?.address?.city}, ${userInstance?.address?.state}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "questionCount")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "answerCount")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </gui:tab>
            </div>
            <div class="list">
           	<gui:tab label="Sport Played" active="${(params.scoreTab == 'sports')}">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                           
                            <g:sortableColumn property="firstName" title="First Name"/>
                            
                            <g:sortableColumn property="score" title="Score"/>

                            <td>City</td>
                            
                            <g:sortableColumn property="questionCount" title="Qs"/>

                            <g:sortableColumn property="answerCount" title="As"/>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userSportsList}" status="i" var="userInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>
                        
                        	<g:if test="${request?.user?.isMember() }">
    	                        <td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "firstName")} ${fieldValue(bean: userInstance, field: "lastName")}</g:link></td>
							</g:if>
							<g:else>
	                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
							</g:else>
                        
                            <td>${fieldValue(bean: userInstance, field: "score")}</td>

                            <td>${userInstance?.address?.city}, ${userInstance?.address?.state}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "questionCount")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "answerCount")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <g:formRemote 
                	name="scoreGrade" 
					url="[controller:'home',action:'scoreWidget']" 
					update="scoreWidget">
                	<g:hiddenField name="scoreTab" value="sports" />
                	<g:hiddenField name="grade" value="${params.grade}" />
                	<g:select name="sport" from="${com.esm.esmzone.Sport.list()}" optionKey="name" value="${params.sport}" />
                	<g:submitButton class="formButton" name="sports" value="Update"></g:submitButton>					
                </g:formRemote>
            </gui:tab>
            </div>
            <div class="list">
           	<gui:tab label="Grade" active="${(params.scoreTab == 'grade')}">
                <table>
                    <thead>
                        <tr>
                            <th>#</th>
                                                    
                            <g:sortableColumn property="firstName" title="firstName"/>

                            <g:sortableColumn property="score" title="Score"/>
                            
                            <th>City</th>
                            
                            <g:sortableColumn property="questionCount" title="Qs"/>

                            <g:sortableColumn property="answerCount" title="As"/>
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userGradeList}" status="i" var="userInstance">
                    	
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td>${i+1}</td>

                        	<g:if test="${request?.user?.isMember() }">
    	                        <td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "firstName")} ${fieldValue(bean: userInstance, field: "lastName")}</g:link></td>
							</g:if>
							<g:else>
	                            <td>${fieldValue(bean: userInstance, field: "firstName")}</td>
							</g:else>
                        
                            <td>${fieldValue(bean: userInstance, field: "score")}</td>

                            <td>${userInstance?.address?.city}, ${userInstance?.address?.state}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "questionCount")}</td>
                        
                            <td>${fieldValue(bean: userInstance, field: "answerCount")}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
                <g:formRemote 
                	name="scoreGrade" 
					url="[controller:'home',action:'scoreWidget']" 
					update="scoreWidget">
                	<g:hiddenField name="scoreTab" value="grade" />
                	<g:hiddenField name="sport" value="${params.sport}" />
                    <g:select name="grade" from="${com.esm.esmzone.GradeLevel?.values()}" optionKey="value" value="${params?.grade}" noSelection="['': '']" />
                	<g:submitButton class="formButton" name="sports" value="Update"></g:submitButton>					
                </g:formRemote>
            </gui:tab>
            </div>
            </gui:tabView>
	</div>
</div>
