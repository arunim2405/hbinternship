package dayThird;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Day3 {
	public static void main(String[] args) {
		pro1();
	
	}
public static void pro1() {
	int[] printcount=new int[256];
	System.out.println("Enter the string");
	Scanner myyObj1 = new Scanner(System.in);
	String str = myyObj1.nextLine();
	int length = str.length();
	 System.out.println("Length of a String is: " + length);
	 int count[] = new int[256]; 
	 for (int i = 0; i < length; i++) 
	 {  count[str.charAt(i)]++;
	 	printcount[str.charAt(i)]=0;
	 }
        // Create an array of given String size 
        	char ch[] = new char[str.length()]; 
        	for (int i = 0; i < length; i++) { 
        	ch[i] = str.charAt(i); 
            int find = 0; 
            for (int j = 0; j <= i; j++) { 
  
                // If any matches found 
                if (str.charAt(i) == ch[j])  
                    find++;                 
            } 
  
            if ( find >1 && printcount[str.charAt(i)]==0)  
             {
            	
            		 System.out.println("Number of Occurrences of " + 
        	                 str.charAt(i) + " is:" + count[str.charAt(i)]);
            		 printcount[str.charAt(i)]++;
            
             }
            
            
            	
            
                            
        } 
        	for (int i = 0; i < length; i++) 
       	 {  
        		if(count[str.charAt(i)]>=2);
        		{	System.out.println("********************** ");
        			System.out.println("Number of Occurrences of " + 
	                 str.charAt(i) + " is:" + count[str.charAt(i)]);
        		}
       	 	
       	 }
    }
}
