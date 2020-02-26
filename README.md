# hsqldb-server-start
This project will consist of files to start an HSQL server.

## Instructions to use Persisted HSQLDB
1. Clone https://github.com/timfrichard/hsqldb-server-start repository
2. Run **com.sparkys.start.hsqldb.util.StartServer** as a Java application using *Program argument* like below.
   - EXAMPLE "/temp/flyway/flyway-db" "FLYWAY_DB" "flywayDB" "9090"
     - "/temp/flyway/flyway-db" *hard drive location*
     - "FLYWAY_DB" *location name*
     - "flywayDB" *database name*
     - "9090" *port number*
