package dayTen;
import java.sql.*;  

public class Day10 {

	public static void main(String[] args) {
		try
		{
			pro1();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	
		}
	
	public static void pro1()throws Exception
	{	int row=0;
		String USERNAME= "root";
		String PASSWORD="admin@123";
		 String CONN_STRING="jdbc:mysql://localhost:3306/myfirstdatabase";
		Class.forName("com.mysql.jdbc.Driver");  
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
		ResultSet rs= stmt.executeQuery("Select * from employee");
		while(rs.next())
		{
			System.out.println(rs.getString("FIRST_NAME")+" "+rs.getString("LAST_NAME"));
			row++;
		}
		rs.afterLast();
		System.out.println("Number of Rows "+ row);
		rs.close();
		conn.close();
		

	}
}
