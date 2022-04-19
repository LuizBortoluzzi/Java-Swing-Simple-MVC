package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnection implements ConnectionInterface{
	
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/solid"; 
	private String user = "postgres"; 
	private String pwd = "postgres";
	private Connection dbc;
	
	public PostgresConnection() {
		this.dbc = this.getConnection(this.driver, this.url, this.user, this.pwd);
	}
		
	@Override
	public Connection getConnection(String driver, String url, String user, String pwd) {

		Connection dbc = null;

		try {
			Class.forName(driver);
			dbc = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Não foi possível encontrar o driver JDBC");
		} catch (SQLException se) {
			System.out.println("Não foi possível conectar ao Banco de Dados");
		}

		return dbc;
	}

	public Connection getDbc() {
		return this.dbc;
	}

}
