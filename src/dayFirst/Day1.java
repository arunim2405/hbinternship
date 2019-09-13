package dayFirst;
import java.util.Scanner;
public class Day1 {

	public static void main(String[] args) {
		//firstPro();
		//secondPro();
		//thirdPro();
		fourthPro();
	
		
		
		
	}
	
	
	
	public static void fourthPro()
	{	
		int num=1;
		System.out.println("Enter the number");
		Scanner myyObj1 = new Scanner(System.in);
		int n = myyObj1.nextInt() ;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=i;j++)
			{
			System.out.print(num + " ");
			num=num+1;
				if(num>=n+1)
				{
				break;
				}
			}
			System.out.println();
			if(num>=n+1)
			{
			break;
			}
			
		}
	}

	public static void thirdPro()
	{
		System.out.println("Enter from");
		Scanner myyObj1 = new Scanner(System.in);
		int from1 = myyObj1.nextInt() ;
		System.out.println("Enter To");
		Scanner myyObj2 = new Scanner(System.in);
		int to2 = myyObj2.nextInt() ;
		int sum = 0;

		for(int i=from1+1; i<to2; i++)
		{
			sum=sum+i;
		}
		
		System.out.println("Sum is:  "+ sum);
	}



	public static void secondPro() {
		//int i=1;
		String str2="h";
		//while(i==1)
		do {
		System.out.println("Enter a value");
		Scanner myyObj1 = new Scanner(System.in);
		String str = myyObj1.nextLine() ;
		if (str.matches("exit")){
			System.out.println("Exiting...");
			
		}
		else if(str.matches("[0-9]+"))
		{ System.out.println("It is a Number");

		}
		else if(str.matches("[a-zA-Z]+"))
		{
			System.out.println("It is characters");
		}
		else
		{
			System.out.println("It is characters and numbers");
		}
		str2=str;
		}while(str2.matches("exit")==false);

	}

	public static void firstPro() {
		int a,b,c;
		System.out.println("Enter 1st Number");
		Scanner myObj = new Scanner(System.in);
		a = myObj.nextInt();

		System.out.println("Enter 2nd Number");
		Scanner myObj2 = new Scanner(System.in);
		b = myObj2.nextInt();

		c=a+b;
		System.out.println("Sum:  "+ c);
	}

}
