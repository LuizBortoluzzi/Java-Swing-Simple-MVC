package daos;

import java.sql.Connection;

import database.PostgresConnection;

public class DataAccessObject {

    protected Connection dbc;
	
    public DataAccessObject(){
        this.dbc = new PostgresConnection().getDbc();
    }
}
