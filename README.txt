##############################################################################
Eclipse IDE instructions
##############################################################################

Make sure that the version of Eclipse that is installed is Eclipse IDE for Java EE Developers.  

Setting up the eclipse project (or refreshing the setup):
Run the following to re-generate and set up the eclipse project files.  


Run this whenever I update the pom.xml with new dependencies or settings.  This will add maven dependencies to the Eclipse project.

  mvn eclipse:eclipse


Then make sure that the project's target runtime is set (Tomcat, TomEE, etc.):

  Project --> Properties --> Targeted Runtimes --> Apache Tomcat v7.0 (TomEE 1.7.1).

Then make sure that the project's exports are set:

  Project --> Properties --> Java Build Path --> Select All.



##############################################################################
Maven command-line instructions
##############################################################################


Run the following to create the war file.  (from the commandline)

mvn package


Run the following to run TomEE with the already-built war file.  (from the commandline)

mvn tomee:run


##############################################################################
PostgreSQL Database setup procedure
##############################################################################


Installation instructions:
http://www.postgresql.org/docs/9.3/static/install-short.html
	   
./configure
gmake
su
gmake install
adduser postgres
mkdir /usr/local/pgsql/data
chown postgres /usr/local/pgsql/data
su - postgres
/usr/local/pgsql/bin/initdb -D /usr/local/pgsql/data
/usr/local/pgsql/bin/postgres -D /usr/local/pgsql/data >logfile 2>&1 &
/usr/local/pgsql/bin/createdb test
/usr/local/pgsql/bin/psql test


Then the following setup steps I did as user postgres was:
	   
createuser -P todolist_user
createdb todolist_db --owner=todolist_user
psql
GRANT ALL PRIVILEGES ON DATABASE todolist_db TO todolist_user

Note: To start and stop the PostgreSQL database, run on the commandline as user postgres:

pg_ctl start -D /usr/local/pgsql/data
pg_ctl stop -D /usr/local/pgsql/data


##############################################################################
