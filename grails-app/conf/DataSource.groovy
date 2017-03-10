dataSource {
	pooled = true
	dbCreate = "update"
	url = "jdbc:mysql://localhost/esmzone"
	driverClassName = "com.mysql.jdbc.Driver"
	username = "esmzone"
	password = "esmzone13"	
	logSql = false
}
hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='net.sf.ehcache.hibernate.EhCacheProvider'
	connection.pool_size=20
}
// environment specific settings
environments {
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost/esmzone"
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "esmzone"
			password = "esmzone13"	
			logSql = false
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost/esmzone"
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "esmzone"
			password = "esmzone13"	
			logSql = false
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost/esmzone"
			pooled = true
			driverClassName = "com.mysql.jdbc.Driver"
			username = "esmzone"
			password = "esmzone13"	
			logSql = false
		}
	}
}