package com.esm.esmzone;

import org.jsecurity.SecurityUtils

class AuthFilters {
	
	def onNotAuthenticated(subject, d) {
		if (d.request.xhr) {
			d.render(template:"/user/loginForm", model:[message:"user.not.logged.in"])
		}
		else {
			// Redirect to login page.
			d.flash.message = "user.not.logged.in"
			//if(d.actionName == 'buy') {
			//	d.redirect(controller:"album", action:"display", id:d.params.id)
			//}
			//else {
			d.redirect(controller:"home", action:"index")
			//}
		}
	}
	
	static filters = {
		loginCheck(controller:'*', action:'*') {
			before = {
				def subject = SecurityUtils.getSubject() 
				if((!actionName=='login') && !session.user && subject && subject?.principal) {
					org.jsecurity.SecurityUtils.getSubject().logout()
					redirect(controller: 'home',action:'index')
					return false
				}
			}       
		}
		
/*		
		blogEditing(controller:"blog", action:"(create|save)") {
			before = {
				accessControl {
					
					role(RoleName.ADMINISTRATOR.name())
				}
			}
		}
		purchasing(controller:"store", action:"buy") {
			before = {
				accessControl()
			}
		}
		library(controller:"user", action:"music") {
			before = {
				accessControl()
			}			
		}
		musicAccess(controller:"(artist|song)", action:"(play|subscribe|unsubscribe|stream)") {
			before = {
				accessControl()
			}						
		}
		*/
		admin(uri:'/admin/**') {
			before = {
				accessControl {
					role(RoleName.ADMINISTRATOR.name())
				}
			}			
		}
		userInRequest(controller:"*", action:"*") {
			before = {
				def subject = SecurityUtils.getSubject() 
				if(subject && subject?.principal) {
					//request.user = User.findByLogin(subject.principal, [fetch:[purchasedSongs:'join']])						
					request.user = User.findByLogin(subject.principal)		
					request.avatar = request?.user?.avatarFile()
					request.avatarVersion = request?.user?.avatarVersion()
				}
			}		
		}
	}
}