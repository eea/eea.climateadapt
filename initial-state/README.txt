
Files to set up a new instance of the climate-adapt portal for test or development.
The production system is installed in /var/local/liferay-portal-6.0.5/

ace.custom.properties is in ../AceItem-portlet/sql/ace.custom.properties

aceindex.properties is to be installed in /var/local/liferay-portal-6.0.5/tomcat-6.0.26/lib/ext/

liferaydata.tgz is created like this:
  cd /var/local/liferay-portal-6.0.5/
  tar cvfz liferaydata.tgz data

geoserverdata.tgz is created like this:
  cd /var/local/liferay-portal-6.0.5/tomcat-6.0.26/webapps/geoserver/
  tar cvfz geoserverdata.tgz data


Databases
=========

geoserver.backup is created like this:
  pg_dump -U postgres geoserver >geoserver.backup

geonetwork.backup is created like this:
  pg_dump -U postgres geonetwork >geonetwork.backup

lfacegis.backup is the renamed CHMdatabase.backup and is created like this:
  pg_dump -U postgres lfacegis >lfacegis.backup

climwatadapt.backup is the renamed climwatadapt_db.sql and is created like this:
  pg_dump -U postgres climwatadapt >climwatadapt.backup


JAR-files
=========

The source for AceItem-portlet-service.jar is in ../AceItem-portlet/docroot/WEB-INF/service/
It is deployed directly into /var/local/liferay-portal-6.0.5/tomcat-6.0.26/lib/ext even
if you only do 'ant war'

The source for AceSearchEngine.jar is in ../AceSearchEngine/src
It is deployed directly into /var/local/liferay-portal-6.0.5/tomcat-6.0.26/lib/ext even
if you only do 'ant war'
