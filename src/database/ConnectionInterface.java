package database;

import java.sql.Connection;

public interface ConnectionInterface {
	
	public Connection getConnection(String driver, String url, String user, String pwd);

}
