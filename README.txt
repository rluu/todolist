##############################################################################


mvn package

mvn test


##############################################################################

PostgreSQL Database setup procedure:

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
