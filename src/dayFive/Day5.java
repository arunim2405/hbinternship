package dayFive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.LinkedHashMap;
import java.util.Map;
import static java.nio.file.StandardCopyOption.*;

public class Day5 {

	public static void main(String[] args) {
		//pro1();
//pro3();
		try {
			pro4();
		}catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
	public static void pro5()throws IOException
	{
		File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\dayFive\\Untitled.txt");
		File myFile2 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\dayFive\\Untitled12.txt");
		myFile2.createNewFile();
		Path p1=myFile1.toPath();
		Path p2=myFile2.toPath();
		Files.copy(p1, p2, REPLACE_EXISTING);
		System.out.println("File Successfully Copied!");
		
	}
	
	
	
	public static void pro4()throws IOException
	{
		File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\dayFive\\Untitled.txt");
		File myFile2 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\dayFive\\Untitled12.txt");
		myFile2.createNewFile();
		 InputStream in = new FileInputStream(myFile1);
		OutputStream out2 = new FileOutputStream(myFile2, true);
		 PrintStream out = new PrintStream(out2);
		 try 
			{
				   
				  BufferedReader  in2 = new BufferedReader(new InputStreamReader(in));
				  String line;
				  StringBuilder buffer = new StringBuilder();
				  while ((line = in2.readLine()) != null) {
				        buffer.append(line).append('\n');
				      }
				  buffer.deleteCharAt(buffer.length() - 1);
				  out.append(buffer); 
				  in2.close();
				 //   byte[] buf = new byte[1024];
				   // int len;
				 System.out.println("File Appended Successfully!");
				   
				} finally {
				    if (out != null) {
				        out.close();
				    }
				    if (in != null) {
				        in.close();
				    }
				    if (out2 != null) {
				        out2.close();
				    }
				    
				    
				}
	}
	
	
	
	
	
	
	
	public static void pro3()
	{
		Map<Integer, String>lmap = new LinkedHashMap<Integer, String>();
		lmap.put(12, "Mahesh");
		lmap.put(5, "Naresh");
		lmap.put(23, "Suresh");
		lmap.put(9, "Sachin");
		System.out.println("LinkedHashMap before modification" + lmap);
		System.out.println("Is Employee ID 12 exists: " +lmap.containsKey(12));
		System.out.println("Is Employee name Amit Exists: "+lmap.containsValue("Amit"));
		System.out.println("Total number of employees: "+ lmap.size());
		System.out.println("Removing Employee with ID 5: " + lmap.remove(5));
		System.out.println("Removing Employee with ID 3 (which does not exist): " + lmap.remove(3));
		System.out.println("LinkedHashMap After modification" + lmap );
		
	}
	
public static void pro2(int num)throws MyException, ClassNotFoundException
{
	if(num==1)
        throw new MyException("IOException Occurred");
    else
       throw new ClassNotFoundException("ClassNotFoundException");
}

public static void pro1()
{
	try{
		System.out.println("Starting of try block");
		// I'm throwing the custom exception using throw
	//	throw new MyException("Gotcha Error!");
		pro2(4);
		
	}
	catch(MyException exp){
		System.out.println("Catch Block") ;
		System.out.println(exp.toString()) ;
	} catch(ClassNotFoundException exp2) {
		System.out.println(exp2);
	}
	System.out.println("Will this run?");
}
// public static class MyException extends Exception{
//	   String str1;
//	   /* Constructor of custom exception class
//	    * here I am copying the message that we are passing while
//	    * throwing the exception to a string and then displaying 
//	    * that string along with the message.
//	    */
//	   MyException(String str2) {
//		str1=str2;
//	   }
//	   public String toString(){ 
//		return ("MyException Occurred: "+str1);
//	   }
// }

	
}