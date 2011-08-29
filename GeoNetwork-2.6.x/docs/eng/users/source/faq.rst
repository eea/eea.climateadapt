.. _faq:

Frequently Asked Questions
==========================

This is a list of frequently encountered problems, suggestions that help to find the cause of the 
problem and possible solutions. The list is by no means exhaustive. Feel free to contribute by 
submitting new problems and their solutions to the developer mailinglist.

.. note:: <install directory> is a placeholder for the GeoNetwork installation directory.

  <some file> should be read as some random file name.
  
.. warning:: Be very careful when issuing commands on the terminal! You can easily damage your 
  operating system with no way back. If you are not familiar with using the terminal: **don't do it, 
  contact an expert instead!** Make a backup of your data before you make any of the suggested changes below!

HTTP Status 400 Bad request
---------------------------

Check the availability and write permissions of the data and tmp directories. 

See :ref:`temp-dir`

Metadata insert fails
---------------------

Inserting an XML or MEF file through the Metadata insert form fails silently. Verify if the data directory is available and writable.

See :ref:`temp-dir`

Thumbnail insert fails
----------------------

Nothing happens when inserting a thumbnail through the wizard in the metadata editor.

Error in your log file looks like::

  HTTP Status 400 - Cannot build ServiceRequest Cause : <install directory>/data/tmp/<some file> (No such file or directory) Error : java.io.FileNotFoundException

Then check :ref:`temp-dir`

.. _temp-dir:

The data and data/tmp directories
---------------------------------

On Linux or OS X systems verify from a terminal if the data directory is existing and is writable.

:command:`ls -la <install directory>/data`

This should show the permissions on the data directory. For example::

  total 0
  drwxr-xr-x   6 tomcat  tomcat  204 19 jan 15:34 .
  drwxr-xr-x   8 tomcat  tomcat  272 23 dec 19:30 ..
  drwxr-xr-x  10 tomcat  tomcat  340 19 jan 15:47 00000-00099
  drwxr-xr-x  21 tomcat  tomcat  714 23 dec 19:30 geoserver_data
  drwxr-xr-x   3 tomcat  tomcat  102 23 dec 19:30 removed
  drwxr-xr-x   3 tomcat  tomcat  102 19 jan 15:47 tmp

The above example shows that only the user tomcat has write access on the directories listed. 
All other users have read (and execute) rights only. 
See http://en.wikipedia.org/wiki/Filesystem_permissions for more details on file permissions.

Make sure your web server is running as user tomcat. Check this with the command:

:command:`ps aux | grep tomcat`
  
You should see the processes that have tomcat in their description. Something like this::

  bash-3.2# ps aux | grep tomcat
  tomcat     22253   0,7  0,0  2435120    532 s000  S+    5:03pm   0:00.00 grep tomcat
  tomcat     22251   0,0  1,9  2861960  80596 s000  S     5:03pm   0:03.85 /System/Library/Frameworks/JavaVM.framework/Versions/CurrentJDK/Home/bin/java -Djava.util.logging.config.file=/usr/local/apache-tomcat-6.0.32/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djava.endorsed.dirs=/usr/local/apache-tomcat-6.0.32/endorsed -classpath /usr/local/apache-tomcat-6.0.32/bin/bootstrap.jar -Dcatalina.base=/usr/local/apache-tomcat-6.0.32 -Dcatalina.home=/usr/local/apache-tomcat-6.0.32 -Djava.io.tmpdir=/usr/local/apache-tomcat-6.0.32/temp org.apache.catalina.startup.Bootstrap start

If all is well, the user referred to at the start of this string (in this case tomcat) is the same user that has write permissions on the data and tmp directories.

You now have two possible solutions:

- Make the data and temporary directories writable to all users. You can change this using the command:

:command:`chmod -R a+w <install directory>/data`
  
Your permissions should now look like this::

    drwxrwxrwx   6 tomcat  tomcat  204 19 jan 15:34 .
    etc..
    
.. note:: the 'w' refers to 'write' access

- The second solution is to ensure the user running the webserver is the same user that holds write access to the data directory (in this case tomcat). For this, you can (a) change the user running the process, or (b) change ownership of the directory using the chown command:

:command:`chown -R tomcat:tomcat <install directory>/data`

