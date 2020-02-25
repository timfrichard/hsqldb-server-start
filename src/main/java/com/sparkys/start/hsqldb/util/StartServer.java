/**
 * Property of Gifted Concepts LLC.
 */
package com.sparkys.start.hsqldb.util;

import java.util.logging.Logger;

import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.springframework.util.SocketUtils;

/**
 * @author Tim Richard
 *
 */
public class StartServer {

    private final static Logger LOGGER = Logger
            .getLogger(StartServer.class.getName());

    private static final String SERVER_DATABASE_0 = "server.database.0";
    private static final String SERVER_DBNAME_0 = "server.dbname.0";
    private static final String SERVER_PORT = "server.port";

    /**
     * @param args
     */
    public static void main(final String[] args) {

	final String dbLocation = args[0];
	final String locationName = args[1];
	final String databaseName = args[2];
	String portNum = null;
	if (args.length == 4) {
	    portNum = args[3];
	}

	startDBServer(dbLocation, locationName, databaseName, portNum);
    }

    public static void startDBServer(final String dbLocation,
            final String locationName, final String databaseName,
            final String portNum) {

	Integer availablePort = null;

	if (portNum == null) {
	    availablePort = SocketUtils.findAvailableTcpPort(9000, 9999);
	} else {
	    availablePort = Integer.valueOf(portNum);
	}

	final String dbNameAndLocation = String.format("file:%s/%s;",
	        dbLocation, locationName);
	LOGGER.info("Database Name and Location: " + dbNameAndLocation);

	final HsqlProperties props = new HsqlProperties();
	props.setProperty(SERVER_DATABASE_0, dbNameAndLocation);
	props.setProperty(SERVER_DBNAME_0, databaseName);
	props.setProperty(SERVER_PORT, availablePort);
	final Server dbServer = new org.hsqldb.Server();
	try {
	    dbServer.setProperties(props);
	} catch (final Exception e) {
	    return;
	}

	LOGGER.info("jdbc:hsqldb:hsql://localhost:" + availablePort + "/"
	        + databaseName);
	dbServer.start();
    }
}
