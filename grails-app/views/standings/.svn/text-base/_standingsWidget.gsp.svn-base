<g:if test="${standingsTab == 'Division2'}">
   	<g:set var="tabValue" value="['standingsTab':'Division2']"/>
</g:if>
<g:elseif test="${standingsTab == 'Division3'}">
   	<g:set var="tabValue" value="['standingsTab':'Division3']"/>
</g:elseif>
<g:else>
   	<g:set var="tabValue" value="['standingsTab':'Division1']"/>
</g:else>
<div class="list">
   <table>
       <thead>
           <tr>
               <th>#</th>
                                       
               <g:sortableColumn property="firstName" title="Name" params="${tabValue}"/>

               <g:sortableColumn property="memberProfile.grade" title="Grade" params="${tabValue}"/>

               <g:sortableColumn property="score" title="Score" params="${tabValue}"/>
               
               <g:sortableColumn property="address.city" title="City" params="${tabValue}"/>
               
               <g:sortableColumn property="memberProfile.playedSports[0]" title="Sport Played" params="${tabValue}"/>
               
               <g:sortableColumn property="questionCount" title="Qs" params="${tabValue}"/>

               <g:sortableColumn property="answerCount" title="As" params="${tabValue}"/>
           </tr>
       </thead>
       <tbody>
       <g:each in="${userInstanceList}" status="i" var="userInstance">
           <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

           		<td>${i+1}</td>

            	<td><g:link controller="memberProfile" action="view" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "firstName")} ${fieldValue(bean: userInstance, field: "lastName")}</g:link></td>

                <td>${userInstance?.memberProfile?.gradeLevel()}</td>

            	<td>${fieldValue(bean: userInstance, field: "score")}</td>
           
                <td>${userInstance?.address?.city}, ${userInstance?.address?.state}</td>

                <td>${userInstance?.memberProfile?.playedSports}</td>
           
                <td>${fieldValue(bean: userInstance, field: "questionCount")}</td>
           
                <td>${fieldValue(bean: userInstance, field: "answerCount")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>
</div>
