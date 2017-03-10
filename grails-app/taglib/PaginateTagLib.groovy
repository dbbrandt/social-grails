/* Copyright 2004-2005 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT c;pWARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.springframework.web.servlet.support.RequestContextUtils as RCU

import com.opensymphony.module.sitemesh.Factory
import com.opensymphony.module.sitemesh.RequestConstants
import grails.util.GrailsNameUtils
import groovy.text.Template
import java.util.concurrent.ConcurrentHashMap
import javax.servlet.ServletConfig
import org.codehaus.groovy.grails.plugins.GrailsPluginManager
import org.codehaus.groovy.grails.web.mapping.ForwardUrlMappingInfo
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.pages.GroovyPagesTemplateEngine
import org.codehaus.groovy.grails.web.sitemesh.FactoryHolder
import org.codehaus.groovy.grails.web.sitemesh.GSPSitemeshPage
import org.codehaus.groovy.grails.web.sitemesh.GrailsPageFilter
import org.codehaus.groovy.grails.web.util.StreamCharBuffer
import org.codehaus.groovy.grails.web.util.WebUtils

class PaginateTagLib implements com.opensymphony.module.sitemesh.RequestConstants {
	def out // to facilitate testing
	
	ServletConfig servletConfig
	GroovyPagesTemplateEngine groovyPagesTemplateEngine
	GrailsPluginManager pluginManager
	
	static Map TEMPLATE_CACHE = new ConcurrentHashMap()
	
	protected getPage() {
		return request[PAGE]
	}
	
	static namespace = 'esm'
	
	/**
	 * Creates next/previous links to support pagination for the current controller
	 *
	 * <g:paginate total="${Account.count()}" />
	 */
	def paginate = { attrs ->
		def writer = out
		if(attrs.total == null)
		throwTagError("Tag [paginate] is missing required attribute [total]")
		
		def messageSource = grailsAttributes.messageSource
		def locale = RCU.getLocale(request)
		
		def total = attrs.int('total') ?: 0
		def action = (attrs.action ? attrs.action : (params.action ? params.action : "list"))
		def offset = params.int('offset') ?: 0
		def max = params.int('max')
		def maxsteps = (attrs.int('maxsteps') ?: 10)
		
		if(!offset) offset = (attrs.int('offset') ?: 0)
		if(!max) max = (attrs.int('max') ?: 10)
		
		def linkParams = [:]
		if(attrs.params) linkParams.putAll(attrs.params)
		linkParams.offset = offset - max
		linkParams.max = max
		if(params.sort) linkParams.sort = params.sort
		if(params.order) linkParams.order = params.order
		if(params.userId) linkParams.userId = params.userId
		if(params.homeTab) linkParams.homeTab = params.homeTab
		if(params.q) linkParams.q = params.q
		if(params.tag) linkParams.tag = params.tag
		if(params.mentors) linkParams.mentors = params.mentors
		if(params.answers) linkParams.answers = params.answers
		if(params.postCount) linkParams.postCount = params.postCount
		if(params.rating) linkParams.rating = params.rating
		if(params.gender) linkParams.gender = params.gender
		if(params.grade) linkParams.grade = params.grade
		if(params.playedSport) linkParams.playedSport = params.playedSport
		if(params.schoolAutoInput_id) linkParams.schoolAutoInput_id = params.schoolAutoInput_id
		if(params.city) linkParams.city = params.city
		linkParams.paginateTotal = attrs.total
																		
		def linkTagAttrs = [action:action]
		if(attrs.controller) {
			linkTagAttrs.controller = attrs.controller
		}
		if(attrs.id!=null) {
			linkTagAttrs.id = attrs.id
		}
		linkTagAttrs.params = linkParams
		
		// determine paging variables
		def steps = maxsteps > 0
		int currentstep = (offset / max) + 1
		int firststep = 1
		int laststep = Math.round(Math.ceil(total / max))
		
		// display previous link when not on firststep
		if(currentstep > firststep) {
			linkTagAttrs.class = 'left button'
			linkParams.offset = offset - max
			writer << link(linkTagAttrs.clone()) {
				(attrs.prev ? attrs.prev : messageSource.getMessage('paginate.prev', null, messageSource.getMessage('default.paginate.prev', null, 'Previous', locale), locale))
			}
		}
		
		writer << "<ul>"
		
		linkTagAttrs.class = ''
		
		// display steps when steps are enabled and laststep is not firststep
		if(steps && laststep > firststep) {
			
			// determine begin and endstep paging variables
			int beginstep = currentstep - Math.round(maxsteps / 2) + (maxsteps % 2)
			int endstep = currentstep + Math.round(maxsteps / 2) - 1
			
			if(beginstep < firststep) {
				beginstep = firststep
				endstep = maxsteps
			}
			if(endstep > laststep) {
				beginstep = laststep - maxsteps + 1
				if(beginstep < firststep) {
					beginstep = firststep
				}
				endstep = laststep
			}
			
			// display firststep link when beginstep is not firststep
			if(beginstep > firststep) {
				linkParams.offset = 0
				writer << link(linkTagAttrs.clone()) {firststep.toString()}
				writer << '<li>..</li>'
			}
			
			// display paginate steps
			(beginstep..endstep).each { i ->
				if(currentstep == i) {
					writer << "<li><u>${i}</u>"
				}
				else {
					linkParams.offset = (i - 1) * max
					writer << "<li>"
					writer << link(linkTagAttrs.clone()) {i.toString()}
				}
				if (i != endstep) {
					writer << " &#149; " 
				}
				writer << " </li>"  
			}
			
			// display laststep link when endstep is not laststep
			if(endstep < laststep) {
				writer << '<li>..</li>'
				linkParams.offset = (laststep -1) * max
				writer << link(linkTagAttrs.clone()) { laststep.toString() }
			}
		}
		
		writer << "</ul>"
		
		// display next link when not on laststep
		if(currentstep < laststep) {
			linkTagAttrs.class = 'right button'
			linkParams.offset = offset + max
			writer << link(linkTagAttrs.clone()) {
				(attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, messageSource.getMessage('default.paginate.next', null, 'Next', locale), locale))
			}
		}
		
	}
}
