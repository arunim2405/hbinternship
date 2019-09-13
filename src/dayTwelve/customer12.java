package dayTwelve;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class customer12 {

	final static String USERNAME= "root";
	final static String PASSWORD="admin@123";
	final static String CONN_STRING="jdbc:mysql://localhost:3306/bank";
	static Scanner myObj=new Scanner(System.in);

	
	public static void welcome(){
		int choice=0;
		while(choice!=4)
		{
			System.out.println("Please Select a choice!");
			System.out.println("1.New Account\n2.Account Details\n3.Withdrawal\n4.Exit");
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
			else if (choice==4)
			{
				 System.exit(0); 
			}
			else
			{
				System.out.println("Invalid Choice");
			}
		}
	}
	
	public static void newAccount() throws SQLException			
	{	Connection conn=null;
	conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
	PreparedStatement stmt;
	//ResultSet rs= stmt.executeQuery("Select * from customerdetails");
		int age;
		int panCardNo;
		int balance;
		System.out.println("Enter Your Name");
		myObj.nextLine();
		String name=myObj.nextLine();
		System.out.println("Enter Age");
		age = myObj.nextInt();
		System.out.println("Enter Pan Card Number");
		panCardNo = myObj.nextInt();
		System.out.println("Enter Balance");
		balance = myObj.nextInt();
		
	      String sql = "INSERT into customerdetails (name,age,pancard,balance) VALUES (?,?,?,?)";
	      stmt = conn.prepareStatement(sql);
	      stmt.setString(1, name);
	      stmt.setInt(2, age);
	      
	      stmt.setInt(3,panCardNo);
	      stmt.setInt(4, balance);
	      stmt.executeUpdate();
	      System.out.println("Account Added Successfully!" );
	      
	    
	     stmt.close();
	     conn.close();


		
	}
	public static void viewAccount() throws SQLException
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
	    	System.out.println("Your account details are:" );
	     
	    	  
	    	  String name=rs.getString("name");
	    	  int age=rs.getInt("age");
	    	  int balance=rs.getInt("balance");
	    	  System.out.println("Name: "+ name);
	    	  System.out.println("Age: " + age);
	    	  System.out.println("Pan Card Number: "+ panCardNo);
	    	  System.out.println("Balance: " + balance); 	  
	      
	      }
	      else
	      {
	    	  System.out.println("Account with specified Pan Card Number not found !");
	      }
	      rs.close();
	      stmt2.close();
	      conn.close();
	}
	
	public static void withdrawAccount() throws SQLException
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
	    	  int wAmount;
       	   	  System.out.println("Enter the amount you wish to withdraw");
       	   	  wAmount=myObj.nextInt();
       	   if(wAmount > balance)
    	   {
    		   System.out.println("Not Enough Balance!");
    	   }
    	   else
    	   {
    		   int  newbalance= balance-wAmount;
    		   String sql3="UPDATE customerdetails SET balance=? WHERE pancard=?";
    		   PreparedStatement stmt3;
    		      stmt3 = conn.prepareStatement(sql3);
    		      stmt3.setInt(1, newbalance);
    		      stmt3.setInt(2, panCardNo);
    		      stmt3.executeUpdate();    		 
    		      System.out.println("New Balance is : " + newbalance);
    		      stmt3.close();
    	   }
       	   	
	      
	      }
	      else
	      {
	    	  System.out.println("Account Not found!");
	      }
	      rs.close();
		stmt2.close();
		conn.close();
		
	}
	
}
