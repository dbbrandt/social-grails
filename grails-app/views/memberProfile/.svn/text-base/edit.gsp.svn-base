
<%@ page import="com.esm.esmzone.MemberProfile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'memberProfile.label', default: 'MemberProfile')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${memberProfileInstance}">
            <div class="errors">
                <g:renderErrors bean="${memberProfileInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${memberProfileInstance?.id}" />
                <g:hiddenField name="version" value="${memberProfileInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteProPlayer"><g:message code="memberProfile.favoriteProPlayer.label" default="Favorite Pro Player" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteProPlayer', 'errors')}">
                                    <g:textField name="favoriteProPlayer" value="${memberProfileInstance?.favoriteProPlayer}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteProTeam"><g:message code="memberProfile.favoriteProTeam.label" default="Favorite Pro Team" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteProTeam', 'errors')}">
                                    <g:textField name="favoriteProTeam" value="${memberProfileInstance?.favoriteProTeam}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteMovie"><g:message code="memberProfile.favoriteMovie.label" default="Favorite Movie" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteMovie', 'errors')}">
                                    <g:textField name="favoriteMovie" value="${memberProfileInstance?.favoriteMovie}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="roleModel"><g:message code="memberProfile.roleModel.label" default="Role Model" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'roleModel', 'errors')}">
                                    <g:textField name="roleModel" value="${memberProfileInstance?.roleModel}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="careerInterests"><g:message code="memberProfile.careerInterests.label" default="Career Interests" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'careerInterests', 'errors')}">
                                    <g:textField name="careerInterests" value="${memberProfileInstance?.careerInterests}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteActivities"><g:message code="memberProfile.favoriteActivities.label" default="Favorite Activities" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteActivities', 'errors')}">
                                    <g:textField name="favoriteActivities" value="${memberProfileInstance?.favoriteActivities}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="gpa"><g:message code="memberProfile.gpa.label" default="Gpa" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'gpa', 'errors')}">
                                    <g:textField name="gpa" value="${fieldValue(bean: memberProfileInstance, field: 'gpa')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="grade"><g:message code="memberProfile.grade.label" default="Grade" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'grade', 'errors')}">
                                    <g:textField name="grade" value="${fieldValue(bean: memberProfileInstance, field: 'grade')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="currentSchool"><g:message code="memberProfile.currentSchool.label" default="Current School" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'currentSchool', 'errors')}">
                                    <g:select name="currentSchool.id" from="${com.esm.esmzone.School.list()}" optionKey="id" value="${memberProfileInstance?.currentSchool?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="gainFromSite"><g:message code="memberProfile.gainFromSite.label" default="Gain From Site" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'gainFromSite', 'errors')}">
                                    <g:textField name="gainFromSite" value="${memberProfileInstance?.gainFromSite}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="wantToMentor"><g:message code="memberProfile.wantToMentor.label" default="Want To Mentor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'wantToMentor', 'errors')}">
                                    <g:checkBox name="wantToMentor" value="${memberProfileInstance?.wantToMentor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="needMentor"><g:message code="memberProfile.needMentor.label" default="Need Mentor" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'needMentor', 'errors')}">
                                    <g:checkBox name="needMentor" value="${memberProfileInstance?.needMentor}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="avatar"><g:message code="memberProfile.avatar.label" default="Avatar" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'avatar', 'errors')}">
                                    <g:select name="avatar.id" from="${com.esm.esmzone.Avatar.list()}" optionKey="id" value="${memberProfileInstance?.avatar?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="playedSports"><g:message code="memberProfile.playedSports.label" default="Played Sports" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'playedSports', 'errors')}">
                                    <g:select name="playedSports" from="${com.esm.esmzone.Sport.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.playedSports}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="strongestSubjects"><g:message code="memberProfile.strongestSubjects.label" default="Strongest Subjects" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'strongestSubjects', 'errors')}">
                                    <g:select name="strongestSubjects" from="${com.esm.esmzone.Subject.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.strongestSubjects}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="leastFavoriteSubjects"><g:message code="memberProfile.leastFavoriteSubjects.label" default="Least Favorite Subjects" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'leastFavoriteSubjects', 'errors')}">
                                    <g:select name="leastFavoriteSubjects" from="${com.esm.esmzone.Subject.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.leastFavoriteSubjects}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="formerSchools"><g:message code="memberProfile.formerSchools.label" default="Former Schools" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'formerSchools', 'errors')}">
                                    <g:select name="formerSchools" from="${com.esm.esmzone.School.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.formerSchools}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteSubjects"><g:message code="memberProfile.favoriteSubjects.label" default="Favorite Subjects" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteSubjects', 'errors')}">
                                    <g:select name="favoriteSubjects" from="${com.esm.esmzone.Subject.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.favoriteSubjects}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="lastUpdated"><g:message code="memberProfile.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${memberProfileInstance?.lastUpdated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="collegeInterest"><g:message code="memberProfile.collegeInterest.label" default="College Interest" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'collegeInterest', 'errors')}">
                                    <g:select name="collegeInterest" from="${com.esm.esmzone.School.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.collegeInterest}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="dateCreated"><g:message code="memberProfile.dateCreated.label" default="Date Created" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'dateCreated', 'errors')}">
                                    <g:datePicker name="dateCreated" precision="day" value="${memberProfileInstance?.dateCreated}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="user"><g:message code="memberProfile.user.label" default="User" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'user', 'errors')}">
                                    <g:select name="user.id" from="${com.esm.esmzone.User.list()}" optionKey="id" value="${memberProfileInstance?.user?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="favoriteSports"><g:message code="memberProfile.favoriteSports.label" default="Favorite Sports" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'favoriteSports', 'errors')}">
                                    <g:select name="favoriteSports" from="${com.esm.esmzone.Sport.list()}" multiple="yes" optionKey="id" size="5" value="${memberProfileInstance?.favoriteSports}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
