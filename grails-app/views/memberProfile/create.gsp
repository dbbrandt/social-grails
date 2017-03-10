
<%@ page import="com.esm.esmzone.MemberProfile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'memberProfile.label', default: 'MemberProfile')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${memberProfileInstance}">
            <div class="errors">
                <g:renderErrors bean="${memberProfileInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
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
                                    <label for="lastUpdated"><g:message code="memberProfile.lastUpdated.label" default="Last Updated" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: memberProfileInstance, field: 'lastUpdated', 'errors')}">
                                    <g:datePicker name="lastUpdated" precision="day" value="${memberProfileInstance?.lastUpdated}"  />
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
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
