package com.cisco.app.dbconnector.model;

public interface ConnectionPoolDb {

	String getInitialPoolSize();

	void setInitialPoolSize(String initialPoolSize);

	String getMinPoolSize();

	void setMinPoolSize(String minPoolSize);

	String getAcquireIncrement();

	void setAcquireIncrement(String acquireIncrement);

	String getMaxPoolSize();

	void setMaxPoolSize(String maxPoolSize);

	String getMaxStatements();

	void setMaxStatements(String maxStatements);

	String getUnreturnedConnectionTimeout();

	void setUnreturnedConnectionTimeout(String unreturnedConnectionTimeout);

}