
This README contains instructions on how to build ClimateAdapt from source
and install the resulting WAR and JAR files onto Liferay's Tomcat.

NB! It is not a guide for doing a full-scale installation of ClimateAdapt
software from scratch. It assumes that the steps described in docs/ClearinghouseInstallationGuide.doc
have already been carried out.

********************************************
1. Make sure you have Ant 1.7.0 and Java 1.6
********************************************

As of July 2012, ClimateAdapt runs on Liferay portal 6.0.5 which means that ClimateAdapt's
portlets, themes and layouts must be built with Liferay Plugins SDK (see further below)
which requires Ant 1.7.0 or higher as the building tool.

Java runtime and compiler of version 1.6 is also required.

******************************************
2. Download and set up Liferay Plugins SDK
******************************************

Liferay Plugins SDK is a set of Ant build files and resources structured
into a certain directory tree. It is used for creating and building
portlets, themes, layouts and other components (aka plugins) of Liferay.
You can read more at http://www.liferay.com/documentation/liferay-portal/6.0/development/-/ai/the-plugins-sdk

Download it from the below page and unzip into a directory of your choice.
Lets call that directory as PLUGINS_SDK_HOME.

http://sourceforge.net/projects/lportal/files/Liferay%20Portal/6.0.5/liferay-plugins-sdk-6.0.5.zip/download

In PLUGINS_SDK_HOME create a file called build.${username}.properties,
where ${username} is your user name on your machine.
Into that file, add the following lines where ${app.server.dir} denotes full
path to your Liferay portal's Tomcat directory (for example /var/local/liferay-portal-6.0.5/tomcat-6.0.26):

app.server.dir=${app.server.dir}
ant.build.javac.source=1.6
ant.build.javac.target=1.6

***************************
3. Checkout the source code
***************************

Go to the location where you want to build your code. E.g. /local/build

svn checkout https://svn.eionet.europa.eu/repositories/ClimateAdapt/trunk ClimateAdapt

Your TRUNK then becomes /local/build/ClimateAdapt

To be able to build the AceSearchEngine you must add a build.properties file.
In TRUNK do:
    cp AceSearchEngine/build.properties.sample AceSearchEngine/build.properties
    edit AceSearchEngine/build.properties

*******************************************************
4. Create symbolic links to ClimateAdapt portlets, etc.
*******************************************************

Let's call the directory where you have downloaded ClimateAdapt's trunk as TRUNK.
While in PLUGINS_SDK_HOME/portlets, create the following symbolic links:

ln -s TRUNK/AceItem-portlet AceItem-portlet
ln -s TRUNK/AceMap-portlet AceMap-portlet
ln -s TRUNK/AceSearch-portlet AceSearch-portlet
ln -s TRUNK/AdaptationTools-portlet AdaptationTools-portlet
ln -s TRUNK/ASTHeader-portlet ASTHeader-portlet
ln -s TRUNK/Countries-portlet Countries-portlet
ln -s TRUNK/FilterAceItem-portlet FilterAceItem-portlet
ln -s TRUNK/HomeNewsEvent-portlet HomeNewsEvent-portlet
ln -s TRUNK/IFrame-portlet IFrame-portlet
ln -s TRUNK/MapViewer-portlet MapViewer-portlet
ln -s TRUNK/Measure-portlet Measure-portlet
ln -s TRUNK/Project-portlet Project-portlet
ln -s TRUNK/SimilarAreasTool-portlet SimilarAreasTool-portlet
ln -s TRUNK/SimpleFilter-portlet SimpleFilter-portlet
ln -s TRUNK/web-form-portlet web-form-portlet

While in PLUGINS_SDK_HOME/layouttpl, create the following symbolic link:
ln -s TRUNK/ace-layouttpl ace-layouttpl

While in PLUGINS_SDK_HOME/themes, create the following symbolic link:
ln -s TRUNK/ace-theme ace-theme
ln -s TRUNK/ace-baltic-sea-theme ace-baltic-sea-theme

While in PLUGINS_SDK_HOME/ext, create the following symbolic link:
ln -s TRUNK/ldapImport-ext ldapImport-ext

While in PLUGINS_SDK_HOME/ext, create the following symbolic link:
ln -s TRUNK/uiError-hook uiError-hook

*****************************
5. Set a few build properties
*****************************

In TRUNK create a copy of build.properties.sample and rename it to build.properties.
In the resulting file set "plugins.sdk.home" to your PLUGINS_SDK_HOME
and set "app.server.dir" to the full path of your Liferay portal's Tomcat directory.

Do the same in TRUNK/AceSearchEngine, i.e. create build.properties from
build.properties.sample and replace "app.server.dir" property.

*************************************************
6. Build and deploy your ClimateAdapt source code
*************************************************

While in TRUNK, execute the following command to build your ClimateAdapt source code
(this will create relevant WAR files into PLUGINS_SDK_HOME/dist):

> ant war

While in TRUNK, execute the following command to deploy the created WAR files into
your Liferay portal. The portal's Tomcat does not have to be stopped for this, as it
works as a "hot-deploy". But it also works if you stop Tomcat first and then restart it after.

> ant deploy

NB! Note that you must always deploy via Ant deploy, as a direct copy-paste of
portlet/theme/layout WAR files into Tomcat webapps does not properly deploy them.

*****************************************************************
7. Build and install GeoNetwork (requires Maven as building tool)
*****************************************************************

GeoNetwork code does not change that often and its build takes quite a bit of time.
However, when it has been changed and it needs to be built and installed, go into
TRUNK/GeoNetwork-2.6.x and simply execute the following Maven command:

> mvn -Dmaven.test.skip=true clean install

The resulting TRUNK/GeoNetwork-2.6.x/web/target/geonetwork.war must be copied
copied into Tomcat's webapps directory, and Tomcat must be restarted.


***********************
8. Notes for developers
***********************

{PORTLET}/docroot/WEB-INF/src/service.properties contains a build number. If
it is lower than the number of the running system, then the deployment will
log an error in catalina.out that says: OldServiceComponentException: Build
namespace Ace has build number 9850 which is newer than 28. The deployment
still happens though.

If you need persistence in your portlet, you describe the entities in the
service.xml using Java types. This will then create a table structure where
the length of the strings are 75 characters. The previous developers have then
manually changed the table structure (expanded the length of the columns etc.)
and left the service.xml untouched. As long as the build number is lower than
the running system, the portlet deployment won't reinstall the tables to match
the *obsolete* format in service.xml.

There is a way to tell Liferay to use other lengths than 75. You can do it in
docroot/WEB-INF/src/META-INF/portlet-model-hints.xml, but that feature wasn't
used.  You rebuild the Java files from service.xml by running ant build-service
