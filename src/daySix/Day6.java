package daySix;

import java.util.Scanner;

public class Day6 {

	public static void main(String[] args) {
		int choice;
		System.out.println("WELCOME TO HOSTBOOKS BANK!");
		System.out.println("Please Select a choice!");
		System.out.println("1.Customer\n2.Accountant\n3.Manager\n4.Exit");
		Scanner myObj = new Scanner(System.in);
		choice = myObj.nextInt();
		while(choice!=4)
		{
			if(choice==1)
			{
				Customer c1=new Customer();
				c1.welcome();
				
			}
			else if (choice==4)
			{
				 System.exit(0); 
			}
		}
		
		

	}

}
