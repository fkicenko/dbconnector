package com.cisco.app.dbconnector.model;

public interface DbConnection {

	public static final String SERVER_TYPE_MYSQL = "MySQL";
	public static final String SERVER_TYPE_SQL_SERVER = "SQL_Server";

	ConnectionPoolDb getConnectionPool();

	void setConnectionPool(ConnectionPoolDb connectionPool);

	String getType();

	void setType(String type);

	String getVersion();

	void setVersion(String version);

	String getHostname();

	void setHostname(String hostname);

	String getPort();

	void setPort(String port);

	String getDatabase();

	void setDatabase(String database);

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password);

	String getDriver();

	void setDriver(String driver);

	String getConnectionString();

	void setConnectionString(String connectionString);

}