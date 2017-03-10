package com.esm.esmzone;

import org.jsecurity.authc.AccountException
import org.jsecurity.authc.IncorrectCredentialsException
import org.jsecurity.authc.UnknownAccountException
import org.jsecurity.authc.SimpleAccount

import com.esm.esmzone.User
import org.jsecurity.authc.credential.CredentialsMatcher

class AuthRealm {
	static authTokenClass = org.jsecurity.authc.UsernamePasswordToken
	
	def facebookGraphService
	
	CredentialsMatcher credentialMatcher
	
	String checkFacebookSession() {
		def result
		def facebookData = facebookGraphService.getFacebookData()
		if (facebookData) {
				result = facebookData.get("uid")
		}
		return result
	}

	def authenticate(authToken) {
		println "Attempting to authenticate ${authToken.username} in DB realm..."
		def login = authToken.username
		
		// Null login is invalid
		if (login == null) {
			throw new AccountException('Null usernames are not allowed by this realm.')
		}

		// Get the user with the given login. If the user is not
		// found, then they don't have an account and we throw an
		// exception.
		def user = User.findByLogin(login)
		if (!user) {
			throw new UnknownAccountException("No account found for user [${username}]")
		}
		println "Found user '${user?.login}' in DB"
		
		// check for a facebook user (their password will be their login - their facebook user id)
		String facebookLogin = this.checkFacebookSession()
		println facebookLogin + 'END' + facebookLogin?.size()
		println login + 'END' + login.size()
		if (login == facebookLogin) {
			println "Returning without check for logged in Facebook User"
			return login
		}
		
		
		// Now check the user's password against the hashed value stored
		// in the database.
		def account = new SimpleAccount(login, user.password, "gTunesRealm")
		if (!credentialMatcher.doCredentialsMatch(authToken, account)) {
			println 'Invalid password (DB realm)'
			throw new IncorrectCredentialsException("Invalid password for user '${login}'")
		}
		
		return login
	}
	
	def hasRole(principal, roleName) {
		def user = User.findByLogin(principal, [fetch:[roles:'join']])
		return user.roles.any { it.name == RoleName.valueOf(roleName) }
	}
	
	def hasAllRoles(principal, userRoles) {
		def foundRoles = User.withCriteria {
			roles {
				'in'('name', roles.collect { RoleName.valueOf(it) })
			}
			eq('login', principal)
		}
		
		return foundRoles.size() == roles.size()
	}
	
	def isPermitted(principal, requiredPermission) {
		if(requiredPermission instanceof Permission) {
			def permissions = Permission.withCriteria {
				user {
					eq('login', principal)
				}
			}
			return permissions.any { permission -> permission.implies(requiredPermission) }			
		}
		else {
			return true
		}
	}	
}