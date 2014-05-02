
This README contains instructions on how to build ClimateAdapt from source
and install the resulting WAR and JAR files onto Liferay's Tomcat.

!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
!!!    This branch and the below instructions is work under construction:   !!!
!!!    you may experience errors and unstable behavior.                     !!!
!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

************************************
1. Prerequisites
************************************

Make sure you have Java 1.6 and Maven 3.0.5 or higher.
This branch assumes that the built portlets, themes and layouts will be run on Liferay portal 6.2.0.
Maven 3.0.5 or higher is used for building.
On first build, Maven downloads the necessary Liferay Plugins SDK, and uses it for building.

******************************
2. Download the source code
******************************

ClimateAdapt source code is available on GitHub.
You can clone the respitory from https://github.com/eea/eea.climateadapt.git.
In the below instructions, the root of the code is denoted as CODEBASE.

***************************************************
3. Build and deploy your ClimateAdapt source code
***************************************************

Before building with Maven, you need to give it at least the following amount of memory:
MAVEN_OPTS=“-Xmx1024m -XX:MaxPermSize=512m”

Go into CODEBASE root. There you should see the "root-level" pom.xml for Maven.
Execute the following command:

> mvn package

As a result, all portlets, themes, layouts and hooks will be built as WAR files into CODEBASE/target.
From there you can simply copy them into your Liferay's deploy directory and performs the deployment.

********************
4. Further notes
********************

In addition to the above "root-level" pom.xml, there is also a pom.xml inside every buildable portlet,
so each of them can be built separately by going into the portlet's root directory and executing
"mvn package".

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
