# social-grails

Developed for ESMZone in 2009-2010
By Dan Brandt

# Build Inventory

One prominent feature of Grails is its use of a plug-in approach to adding functionality. With many plug-ins available to the developer, functionality that previously required work to developer or integrate 3rd party class libraries not can be added with ease. Examples include search, fancy UI components, and AJAX support.

The basic building blocks of the system are Grails and Groovy

* Grails.1.2.1
* Groovy-1.7.0

EMSZone leverage several plugins to provide functionality and run in a Tomcat servlet container using MYSQL for the database.

#### Grails Plugins

    plugins.bubbling=2.1.2   (AJAX extensions to YUI)
    plugins.fckeditor=0.9.4 (HTML editor not currently used in the production build)
    plugins.grails-ui=1.2-SNAPSHOT (UI components use primarily in the admin)
    plugins.hibernate=1.2.1 (Database framework)
    plugins.jquery=1.4.1.1 (AJAX alternative to YUI used by some components)
    plugins.jsecurity=0.4.1 (Provides login security)
    plugins.mail=0.9 (Provides support for email)
    plugins.nested-set=0.1 (provides support for tag hierarchy not currently used in production)
    plugins.richui=0.7 (provides some AJAX components)
    plugins.searchable=0.5.5 (provides search functionality)
    plugins.tomcat=1.2.1 (Support for Tomcat)
    plugins.yui=2.7.0.1 (Primary AJAX library used for remote forms and other UI components)

* The database used is MYSQL  5.0

The development environment is Windows Vista using the Springsource Tool Suite (STS). 
STS is a customized version of Eclipse created by Springsource to support Java development using the Spring framework and Grails.

##### Noble Avatar    
The generate avatar feature of ESMZone is provided by software from Noble Games. 
Noble provided java applet code that was modified to work with ESMZone. 
This java applet runs in the user’s browser and allows the user to create and upload an avatar to the server. 
The avatar is build using JDK 1.5 to give it compatibility with users that have JRE 1.5 or higher on the PC.

Noble avatar software leverages a library file which provides user interface components (jgoodies-forms-1.0.4.jar). 
When running applets in a browser, the applet must be signed for the security features of many browsers to allow the applet to run. 
Ideally, the applet should be signed by a recognized authority so the browser can indicate this to the user. 
When signing noble avatar, you must sign both the avatar applet (avatar.jar) and the interface library (jgoodies-forms-1.0.4.jar) for the browser to acknowledge the applet is fully signed.


## Build Description


To build and test locally in a development environment 
* Download STS from springsource
`SprintSource Tool Suite 2.3.0.RELEASE`

* Add the plugins for Grails and Groovy development.

```
  Plugins:
  Grails 1.2.1
  Groovy-Eclipse Feature 2.00
  Subclipse 1.6.6
 ```

* Add in the subversion plugin to connection to the Codesion repository. 

* Install MYSQL 5.0

### Noble Avatar

The Noble Avatar applet is build using the Eclipse IDE in this project. 
The source code is stored in Codesion.  
If the code needs to be changed follow the direction below to recompile, sign and copy to the ESMZone project.  
Normally, the applet will not change and the latest copy (jar files) will be stored in the ESMZone code repository ready to be packaged and released along with ESMZone.jar.

Repository Root:  https://esmzone.svn.cvsdude.com/avatar/trunk

1.	Checkout the project from the repository root.
2.	Build the applet
3.	The built classes will be created in the bin directory under the avatar source code directory. 
4.	Package the class in a jar file using the command:

```
a. Change directory to the bin directory under avatar
b. jar cvf avatar.jar *
c. Copy avatar.jar to the esmzone/web-app directory
```

5.	Sign the avatar.jar

```
a.	First you must setup a development keyfile or get a production file from a signing authority like Thawte.
b.	To generate a development key, go to the esmzone/web-app directory execute the following command  
   i.	keytool –genkeypair –alias signFiles –keystore esmzone
   ii.	Enter a keystore password
   iii.	Complete the information about your organization
    Last Name: 
    FirstName:
    Organization Unit:
    Organization:
    Locality:
    State: 
    Country:
   iv.	Enter a password for signFiles
c.	Sign the jar file
   jarsigner -keystore esmzone avatar.jar signFiles
d.	If not already done, sign the jgoodies jar file in the same way
   jarsigner -keystore esmzone jgoodies-forms-1.0.4.jar signFiles
```

## ESMZone

ESMzone is a standard Grails 1.2 application. 

* The build can be done either in the STS IDE or from the command line (ex. for test and production environments). 
* Since the commands are essentially the same this description will focus on the command line. 
* The product of the build is generally a “war” file that can be deployed on the Tomcat server. 
* Deployment is simply copying the new esmzone.war to the web-apps directory under Tomcat. 

Test and production have identical directory structures and build procedures.

#### Directory Structure

For this example, all data and code are stored on an Amazon EBS volume and not on the AMI. 
This means that the EC2 instance can be started and stopped without loss of the database or application data. 

```
/ebs1 : the EBS volume is mounted at this location
/ebls1/opt : all 3rd party software is in this subdirectory
/ebs1/TcatServer6 : the version of Tomcat (customized by Mulesoft) that runs test and production
/ebs1/TcatServer6/bin : the  directory where the startup and stop scripts for Tomcat are
/ebs1/TcatServer6/webapps: the directory where the application esmzone.war is placed
/ebs1/TcatServer6/logs: the directory where Tomcat system logs are created and can be viewed.

/ebs1/www/esmzone: The directory where source code is kept, checked out to and built.
```

#### Build Steps
* Insure the latest code is checked into SVN.
* Connect to the desired server (test or production) using your SSH client as the root user.
* Change directory to esmzone: cd /ebs1/www/esmzone
* Checkout the latest code: git pull
* Build the new war: `grails prod war`

#### Deployment Steps
* Connect to the desired server as root
* Login as the tomcat user: su – tomcat
* Go to the web-app directory: cd ../webapps
* Run the update script to copy the war: ./ updateEsmzone.sh   
* The system will start tailing the log (/logs/cataling.out). You should see:

INFO: Deploying web application archive esmzone.war 

When the war is fully deployed you will see the following debug information

```
    driverClassName=com.mysql.jdbc.Driver
    minEvictableIdleTimeMillis=1800000
    maxOpenPreparedStatements=-1
    removeAbandoned=false
    minIdle=0
    defaultReadOnly=false
    initialSize=0
    timeBetweenEvictionRunsMillis=1800000
    maxIdle=8
    maxWait=-1
    testOnBorrow=true
    username=esmzone
    url=jdbc:mysql://localhost/esmzone
    numActive=0
    defaultTransactionIsolation=-1
    maxActive=8
    logWriter=java.io.PrintWriter@ebf5ae
    accessToUnderlyingConnectionAllowed=false
    password=esmzone13
    testWhileIdle=false
    connection=jdbc:mysql://localhost/esmzone, UserName=esmzone@localhost, MySQL-AB JDBC Driver
    class=class org.apache.commons.dbcp.BasicDataSource
    testOnReturn=false
    validationQuery=SELECT 1
    numTestsPerEvictionRun=3
    poolPreparedStatements=false
    logAbandoned=false
    numIdle=6
    defaultAutoCommit=true
    removeAbandonedTimeout=300
    defaultCatalog=nul
```