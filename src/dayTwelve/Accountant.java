package dayTwelve;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Accountant extends customer12 {
	public static void welcome() 
	{
		try {
		System.out.println("Enter Accountant id");
		//myObj.nextLine();
		int aid = myObj.nextInt();
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		PreparedStatement stmt;
		String sql2 = "SELECT * FROM accountantdetails WHERE accountantid=?";
		stmt = conn.prepareStatement(sql2);
		stmt.setInt(1,aid);
		ResultSet rs=stmt.executeQuery();
		int flag=0;
		if(rs.next())
		{
		flag++;
		int choice=0;
 		while(choice!=8)
		{
			System.out.println("Please Select a choice!");
			System.out.println("1.New Customer Account\n2.View particular Customer Account Details\n3.Withdraw from a Customer Account\n4.Add balance to Customer Account \n5.Edit Customer Acccount \n6.Delete Customer Account \n7.View all Customer Accounts \n8.Exit");
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
					
			else if (choice==8)
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
			System.out.println("Accountant id not found");
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void addBal() throws SQLException
	{
		System.out.println("Enter Pan Card Number");
		myObj.nextLine();
		int panCardNo = myObj.nextInt();
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		String sql2 = "SELECT * FROM customerdetails WHERE pancard=?";
	      PreparedStatement stmt2;
	      stmt2 = conn.prepareStatement(sql2);
	      stmt2.setInt(1,panCardNo);
	      ResultSet rs = stmt2.executeQuery();
	      if(rs.next())
	      {
	    	
	    	  
	    	  String name=rs.getString("name");
	    	  int age=rs.getInt("age");
	    	  int balance=rs.getInt("balance");
	    	  int addAmount;
       	   	  System.out.println("Enter the amount you wish to add to Balance");
       	   	  addAmount=myObj.nextInt();
       	   
    	  
    		   int  newbalance= balance+addAmount;
    		   String sql3="UPDATE customerdetails SET balance=? WHERE pancard=?";
    		   PreparedStatement stmt3;
    		      stmt3 = conn.prepareStatement(sql3);
    		      stmt3.setInt(1, newbalance);
    		      stmt3.setInt(2, panCardNo);
    		      stmt3.executeUpdate();    		 
    		      System.out.println("New Balance is : " + newbalance);
    		      stmt3.close();
    	   
       	   	
	      
	      }
	      else
	      {
	    	  System.out.println("Account Not found!");
	      }
	      rs.close();
		stmt2.close();
		conn.close();
	}
	
	public static void editAccount() throws SQLException
	{
		System.out.println("Enter Pan Card Number");
		myObj.nextLine();
		int panCardNo = myObj.nextInt();
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		String sql2 = "SELECT * FROM customerdetails WHERE pancard=?";
	      PreparedStatement stmt2;
	      stmt2 = conn.prepareStatement(sql2);
	      stmt2.setInt(1,panCardNo);
	      ResultSet rs = stmt2.executeQuery();
	      if(rs.next())
	      {
	    	int age;
	  		int balance;
	  		System.out.println("Enter Your Name");
	  		myObj.nextLine();
	  		String name=myObj.nextLine();
	  		System.out.println("Enter Age");
	  		age = myObj.nextInt();
	  		System.out.println("Enter Balance");
	  		balance = myObj.nextInt();
	  		
	  	      String sql = "UPDATE customerdetails SET name=?,age=?,pancard=?,balance=? WHERE pancard=?";
	  	      stmt2 = conn.prepareStatement(sql);
	  	      stmt2.setString(1, name);
	  	      stmt2.setInt(2, age);
	  	      stmt2.setInt(3,panCardNo);
	  	      stmt2.setInt(4, balance);
	  	    stmt2.setInt(5, panCardNo);
	  	      stmt2.executeUpdate();
	  	      System.out.println("Account Edited Successfully!" );  
	  	    rs.close();
		      stmt2.close();
		      conn.close();
	      }
	      else
	      {
	    	  System.out.println("Account not found" );   
	      }
	      
	}
	public static void deleteAccount() throws SQLException
	{
		System.out.println("Enter Pan Card Number");
		myObj.nextLine();
		int panCardNo = myObj.nextInt();
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		String sql2 = "DELETE FROM customerdetails WHERE pancard=?";
	      PreparedStatement stmt2;
	      stmt2 = conn.prepareStatement(sql2);
	      stmt2.setInt(1,panCardNo);
	      stmt2.executeUpdate();
	      System.out.println("Account Deleted!" ); 
	      stmt2.close();
	      conn.close();
	      
	}
	public static void viewAllAccounts() throws SQLException
	{
		Connection conn=null;
		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
		String sql2 = "SELECT * FROM customerdetails";
	      PreparedStatement stmt2;
	      stmt2 = conn.prepareStatement(sql2);
	      ResultSet rs = stmt2.executeQuery();
	      int i=1;
	      while(rs.next())
	      {		
	    	  
	    	  String name=rs.getString("name");
	    	  int age=rs.getInt("age");
	    	  int balance=rs.getInt("balance");
	    	  int panCardNo=rs.getInt("pancard");
	    	  System.out.println("***************RECORD NUMBER "+ i + "***************");
	    	  System.out.println("Name: "+ name);
	    	  System.out.println("Age: " + age);
	    	  System.out.println("Pan Card Number: "+ panCardNo);
	    	  System.out.println("Balance: " + balance);
	    	  ++i;
	      }
	      rs.close();
	      stmt2.close();
	      conn.close();
	}
}
