package dayTwelve;

import java.util.Scanner;

public class Day12 {
	
	static Scanner myObj = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		System.out.println("WELCOME TO HOSTBOOKS BANK!");
		System.out.println("Please Select a choice!");
		System.out.println("1.Customer\n2.Accountant\n3.Manager\n4.Exit");

		choice = myObj.nextInt();
		while(choice!=4)
		{
			if(choice==1)
			{
				try {
				customer12.welcome();
				}catch(Exception e)
				{
					System.out.println(e);
					
				}
			}
			else if(choice==2)
				{
					try {
					Accountant.welcome();
					}catch(Exception e)
					{
						System.out.println(e);
						
					}
				}
					else if(choice==3)
					{
						try {
						Manager.welcome();
						}catch(Exception e)
						{
							System.out.println(e);
							
						}
				
			}
			else if (choice==4)
			{
				 System.exit(0); 
			}
		}
		
	}
//	public static void pro1()throws Exception
//	{	int row=0;
//		String USERNAME= "root";
//		String PASSWORD="admin@123";
//		 String CONN_STRING="jdbc:mysql://localhost:3306/bank";
//		Class.forName("com.mysql.jdbc.Driver");  
//		Connection conn=null;
//		conn=DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
//		Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);  
//		//ResultSet rs= stmt.executeQuery("Select * from employee");
//		System.out.println("Connected!");
//		
//		
//		//rs.close();
//		conn.close();
//		
//
//	}
}
