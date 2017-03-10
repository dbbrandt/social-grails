
<%@ page import="com.esm.esmzone.MemberProfile" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="mainAdmin" />
        <g:set var="entityName" value="${message(code: 'memberProfile.label', default: 'MemberProfile')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.favoriteProPlayer.label" default="Favorite Pro Player" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "favoriteProPlayer")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.favoriteProTeam.label" default="Favorite Pro Team" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "favoriteProTeam")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.favoriteMovie.label" default="Favorite Movie" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "favoriteMovie")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.roleModel.label" default="Role Model" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "roleModel")}</td>
                            
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
                            <td valign="top" class="name"><g:message code="memberProfile.gpa.label" default="Gpa" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "gpa")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.grade.label" default="Grade" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "grade")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.currentSchool.label" default="Current School" /></td>
                            
                            <td valign="top" class="value"><g:link controller="school" action="show" id="${memberProfileInstance?.currentSchool?.id}">${memberProfileInstance?.currentSchool?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.gainFromSite.label" default="Gain From Site" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: memberProfileInstance, field: "gainFromSite")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.wantToMentor.label" default="Want To Mentor" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${memberProfileInstance?.wantToMentor}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.needMentor.label" default="Need Mentor" /></td>
                            
                            <td valign="top" class="value"><g:formatBoolean boolean="${memberProfileInstance?.needMentor}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.avatar.label" default="Avatar" /></td>
                            
                            <td valign="top" class="value"><g:link controller="avatar" action="show" id="${memberProfileInstance?.avatar?.id}">${memberProfileInstance?.avatar?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.playedSports.label" default="Played Sports" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.playedSports}" var="p">
                                    <li><g:link controller="sport" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.strongestSubjects.label" default="Strongest Subjects" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.strongestSubjects}" var="s">
                                    <li><g:link controller="subject" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.leastFavoriteSubjects.label" default="Least Favorite Subjects" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.leastFavoriteSubjects}" var="l">
                                    <li><g:link controller="subject" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.formerSchools.label" default="Former Schools" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.formerSchools}" var="f">
                                    <li><g:link controller="school" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.favoriteSubjects.label" default="Favorite Subjects" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.favoriteSubjects}" var="f">
                                    <li><g:link controller="subject" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.lastUpdated.label" default="Last Updated" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${memberProfileInstance?.lastUpdated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.collegeInterest.label" default="College Interest" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.collegeInterest}" var="c">
                                    <li><g:link controller="school" action="show" id="${c.id}">${c?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.dateCreated.label" default="Date Created" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${memberProfileInstance?.dateCreated}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.user.label" default="User" /></td>
                            
                            <td valign="top" class="value"><g:link controller="user" action="show" id="${memberProfileInstance?.user?.id}">${memberProfileInstance?.user?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="memberProfile.favoriteSports.label" default="Favorite Sports" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${memberProfileInstance.favoriteSports}" var="f">
                                    <li><g:link controller="sport" action="show" id="${f.id}">${f?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${memberProfileInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
