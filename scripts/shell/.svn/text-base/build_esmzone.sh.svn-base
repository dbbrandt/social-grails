#!/bin/bash

logfile="/ebs1/opt/TcatServer6/webapps/ROOT/build_log.html"
echo "<html><body><pre>" > $logfile
echo `date` >> $logfile
cd /ebs1/www/esmzone >> $logfile
svn update --username esmzone --password esmzone13 >> $logfile
grails prod war >> $logfile
echo "Completed Build Script" >> $logfile
echo `date` >> $logfile
echo "</pre></body></html>" >> $logfile
