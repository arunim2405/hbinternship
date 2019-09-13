package dayTwelve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass 	 {
	final static String USERNAME= "root";
	final static String PASSWORD="admin@123";
	final static String CONN_STRING="jdbc:mysql://localhost:3306/bank";
	 
	public Connection connection_create() throws SQLException{
	Connection conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	return conn;
	 }
	
}
