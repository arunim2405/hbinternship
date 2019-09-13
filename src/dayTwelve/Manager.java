package dayTwelve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

public class Manager extends Accountant {

	public static void welcome()
	{	int password=3312;
	System.out.println("Enter password");
	int epassword=myObj.nextInt();
	if(epassword==password)
	{
		int choice=0;
		while(choice!=11)
		{
			System.out.println("Please Select a choice!");
			System.out.println("1.New Customer Account\n2.View particular Customer Account Details\n3.Withdraw from a Customer Account\n4.Add balance to Customer Account \n5.Edit Customer Acccount \n6.Delete Customer Account \n7.View all Customer Accounts \n8.Add new Accountant. \n9.Remove Accountant \n10.View all Accountants \n11.Exit");
			choice = myObj.nextInt();
			if(choice==1)
			{
				try {
					newAccount();
					
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
			}
			else if(choice==2)
			{
				try {
					viewAccount();
					
				}catch(SQLException e)
				{
					System.out.println(e);
				}
				
			}
			else if(choice==3)
			{
				try {
					withdrawAccount();
				}catch(SQLException e )
				{
					System.out.println(e);
				}																
			}
			else if(choice==4)
			{
				try {
					addBal();
					
				}catch(SQLException e)
				{
					System.out.println(e);
				}
			}
				else if(choice==5)
				{
					try {
						editAccount();
						
					}catch(SQLException e)
					{
						System.out.println(e);
					}
				}
					else if(choice==6)
					{
						try {
							deleteAccount();
							
						}catch(SQLException e)
						{
							System.out.println(e);
						}
					}
						else if(choice==7)
						{
							try {
								viewAllAccounts();
								
							}catch(SQLException e)
							{
								System.out.println(e);
							}
						}
						else if(choice==8)
						{
							try {
								createAccountant();
								
							}catch(SQLException e)
							{
								System.out.println(e);
							}
						}
						else if(choice==9)
						{
							try {
								deleteAccountant();
								
							}catch(SQLException e)
							{
								System.out.println(e);
							}
						}
						else if(choice==10)
						{
							try {
								viewAllAccountants();
								
							}catch(SQLException e)
							{
								System.out.println(e);
							}
						}
					
			else if (choice==11)
			{
				 System.exit(0); 
			}
			
			else
			{
				System.out.println("Invalid Choice");
			}
		}
		
	}
	else
	{
		System.out.println("Invalid Password");
	}
	}
	public static void viewAllAccountants() throws SQLException
	{
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		String sql2 = "SELECT * FROM accountantdetails";
	      PreparedStatement stmt2;
	      stmt2 = conn.prepareStatement(sql2);
	      ResultSet rs = stmt2.executeQuery();
	      int i=1;
	      while(rs.next())
	      {		
	    	  
	    	  String name=rs.getString("name");
	    	  int aid=rs.getInt("accountantid");
	    	  int salary=rs.getInt("salary");
	    	  System.out.println("***************ACCOUNTANT NUMBER "+ i + "***************");
	    	  System.out.println("Name: "+ name);
	    	 
	    	  System.out.println("Accountant ID: "+ aid);
	    	  System.out.println("Salary: " + salary);
	    	  ++i;
	      }
	      rs.close();
	      stmt2.close();
	      conn.close();
	}
	
	
	
	
	public static void deleteAccountant() throws SQLException
	{
		System.out.println("Enter Accountant id");
		myObj.nextLine();
		int aid = myObj.nextInt();
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		PreparedStatement stmt;
		String sql2 = "DELETE FROM accountantdetails WHERE accountantid=?";
		stmt = conn.prepareStatement(sql2);
		stmt.setInt(1,aid);
		stmt.executeUpdate();
		System.out.println("Accountant Deleted!" ); 
		stmt.close();
	    conn.close();
		  
		
	}
	public static void createAccountant() throws SQLException
	{
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		PreparedStatement stmt;
		int aid;
	    String name;
	    int salary;
	    System.out.println("Enter Name");
		myObj.nextLine();
		name=myObj.nextLine();
		System.out.println("Enter Accountant id");
		aid = myObj.nextInt();
		System.out.println("Enter Salary");
		salary = myObj.nextInt();
		String sql = "INSERT into accountantdetails (name,accountantid,salary) VALUES (?,?,?)";
		 stmt = conn.prepareStatement(sql);
	      stmt.setString(1, name);
	      stmt.setInt(2, aid);
	      
	      stmt.setInt(3,salary);
	      
	      stmt.executeUpdate();
	      System.out.println("Accountant Added Successfully!" );
	      stmt.close();
		  conn.close();
	}
	
	
}
