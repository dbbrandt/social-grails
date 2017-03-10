
<%@ page import="com.esm.esmzone.MemberProfile" %>
<div class="memberProfile">
    <table>
        <tbody>
         <tr class="prop">
             <td valign="top" class="name"><g:message code="user.firstName.label" default="First Name" /></td>
             
             <td valign="top" class="value">${memberProfileInstance?.user?.firstName?.encodeAsHTML()}</td>
             
         </tr>

         <tr class="prop">
             <td valign="top" class="name"><g:message code="user.lastName.label" default="Last Name" /></td>
             
             <td valign="top" class="value">${memberProfileInstance?.user?.lastName?.encodeAsHTML()}</td>
             
         </tr>

         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.grade.label" default="Grade" /></td>
             
             <td valign="top" class="value">${memberProfileInstance?.gradeLevel()}</td>
             
         </tr>
         
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.currentSchool.label" default="Current School" /></td>
             
             <td valign="top" class="value"><g:link controller="school" action="show" id="${memberProfileInstance?.currentSchool?.id}">${memberProfileInstance?.currentSchool?.encodeAsHTML()}</g:link></td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.formerSchools.label" default="Former Schools" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.formerSchools}" var="f">
                     <li><g:link controller="school" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>

         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.strongestSubjects.label" default="Strongest Subjects" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.strongestSubjects}" var="s">
                     <li><g:link controller="subject" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>
         
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.favoriteSubjects.label" default="Favorite Subjects" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.favoriteSubjects}" var="f">
                     <li><g:link controller="subject" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>

         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.leastFavoriteSubjects.label" default="Least Favorite Subjects" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.leastFavoriteSubjects}" var="l">
                     <li><g:link controller="subject" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.playedSports.label" default="Played Sports" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.playedSports}" var="p">
                     <li><g:link controller="sport" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>

         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.careerInterests.label" default="Career Interests" /></td>
             
             <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "careerInterests")}</td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.favoriteActivities.label" default="Favorite Activities" /></td>
             
             <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "favoriteActivities")}</td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.favoriteSports.label" default="Favorite Sports" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.favoriteSports}" var="f">
                     <li><g:link controller="sport" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.collegeInterest.label" default="College Interest" /></td>
             
             <td valign="top" style="text-align: left;" class="value">
                 <ul>
                 <g:each in="${memberProfileInstance?.collegeInterest}" var="c">
                     <li><g:link controller="school" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
                 </g:each>
                 </ul>
             </td>
             
         </tr>
     
         <tr class="prop">
             <td valign="top" class="name"><g:message code="memberProfile.roleModel.label" default="Role Model" /></td>
             
             <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "roleModel")}</td>
             
         </tr>
     
     </tbody>
 </table>
</div>
