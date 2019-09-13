package daySix;

import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class Customer implements Bank{ 
	static String thisline;
	public static Scanner myObj = new Scanner(System.in);



	public static void welcome()
	{
		Customer c=new Customer();
		int choice=0;
		
		while(choice!=4)
		{
			System.out.println("Please Select a choice!");
			System.out.println("1.New Account\n2.Account Details\n3.Withdrawal\n4.Exit");
			choice = myObj.nextInt();
			if(choice==1)
			{
				try {
					c.newAccount();
					
				}catch(IOException e)
				{
					System.out.println(e);
				}
				
			}
			else if(choice==2)
			{
				try {
					c.viewAccount();
					
				}catch(IOException e)
				{
					System.out.println(e);
				}
				
			}
			else if(choice==3)
			{
				try {
					c.withdrawAccount();
				}catch(IOException e )
				{
					System.out.println(e);
				}catch(ClassNotFoundException e2){
					System.out.println(e2);
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
	public  void updateRecord() throws IOException, ClassNotFoundException
	{
		File inputFile = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
		File tempFile = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails2.txt");
		 
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		String currentLine;
		while((currentLine = reader.readLine()) != null) {
			 
			// trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();
			   
			    if(trimmedLine.equals(thisline)) continue;
			 
			    writer.write(currentLine + System.getProperty("line.separator"));
			}
			 
		 
			boolean c1=inputFile.delete();
			boolean c2=tempFile.renameTo(inputFile);
			System.out.println(c1);
			System.out.println(c2);
			writer.close(); 
			reader.close();
			
	}
	
	
	
	
	
	public void withdrawAccount() throws IOException, ClassNotFoundException 
	{
		int flag=0;
		//LinkedHashMap<Integer, Integer> lhmap =  null;
		System.out.println("Enter Pan Card Number");
		//myObj.nextLine();
		int panCardNo = myObj.nextInt();
		String strPan=Integer.toString(panCardNo);
//		FileInputStream fis = new FileInputStream("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\hashmap.ser");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        lhmap = (LinkedHashMap<Integer, Integer>) ois.readObject();
//        ois.close();
//        fis.close();
//        Set set = lhmap.entrySet();
//        Iterator iterator = set.iterator();
		File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
		InputStream in = new FileInputStream(myFile1);
		BufferedReader  in2 = new BufferedReader(new InputStreamReader(in));
		String line;
		StringBuilder buffer = new StringBuilder();
		line = in2.readLine();
		while ((line = in2.readLine()) != null) 
		{
			String[] arrSplit = line.split("\t");
			int bal=Integer.parseInt(arrSplit[3]);
			int key1=Integer.parseInt(arrSplit[2]);
//        while(iterator.hasNext()) {
//        	System.out.println(iterator);
//        	Map.Entry<Integer, Integer> mentry = (Map.Entry)iterator.next();
//        	 System.out.println(mentry);
           if(key1==panCardNo) 
           {
        	  
//        	   int key=(int) mentry.getKey();
        	   int wAmount;
        	   System.out.println("Enter the amount you wish to withdraw");
        	   wAmount=myObj.nextInt();
        	
        	   if(wAmount > bal)
        	   {
        		   System.out.println("Not Enough Balance!");
        	   }
        	   else
        	   {
//        		   int balance;
//        		   balance=(int) mentry.getValue();
        		 int  newbalance= bal-wAmount;
        		 String strbal=Integer.toString(newbalance);
        		//  lhmap.replace(key1, newbalance);
        		  System.out.println("New Balance");
        		  System.out.println(newbalance);
//        		 File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
        		
        		 //Path p1=myFile1.toPath();
        	
//        		  InputStream in = new FileInputStream(myFile1);
//        			 BufferedReader  in2 = new BufferedReader(new InputStreamReader(in));
//        			  String line;
//        			  line = in2.readLine();
//        			  while (line != null) {
        			       
        			        int myindex;
        					myindex= line.indexOf(strPan);
        					
        					if(myindex!=-1)
        					{
        					System.out.println(myindex);
        						
        					
        					
        						
        						File myFile2 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
        						myFile2.createNewFile();
        						OutputStream out2 = new FileOutputStream(myFile2, true);
        						PrintStream out = new PrintStream(out2);
//        						
//        						  
//        						  StringBuilder buffer = new StringBuilder();
        						  StringBuilder buffer2 = new StringBuilder();
          						  buffer2.append(line);
          						  thisline=buffer2.toString();
        						  buffer.append(line);
        						  buffer.replace (myindex+5, line.length()-1, strbal);
        						  buffer.deleteCharAt(buffer.length() - 1);
        						  buffer.append('\n');
        						  out.append(buffer); 
        						  System.out.println("Record updated");
//        						List <String> fileContent = new ArrayList<>(Files.readAllLines(p1, StandardCharsets.UTF_8));
//
//        						for (int i = 0; i < fileContent.size(); i++)
//        						{
//        							if (fileContent.get(i).equals("old line"))
//        							{
//        								fileContent.set(i, "new line");
//        								break;
//        							}										
//        						}
//
//Files.write(p1, fileContent, StandardCharsets.UTF_8);
        						  out.close();
        	        			  out2.close();
        					
        					
        					}
        					
        					
        					
        					
        			      }
        			  
        			   flag++;      			  
        			   break;
        	   }
          // line = in2.readLine();
           
          
           }
		if(flag==0)
        {
     	   System.out.println("Account Not Found!");
        }
		 try {
			  updateRecord();
			 
		  }catch(IOException e)
		 {
			  System.out.println(e);
		 }
			  finally {
		 
			  
		
		  in.close();
		  in2.close();
		  }

        
	}
//        FileOutputStream fos =
//                new FileOutputStream("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\hashmap.ser", true);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             oos.writeObject(lhmap);
//             oos.close();
//             fos.close();  
             
	
	
	public  void viewAccount() throws IOException 
	{	
		
		System.out.println("Enter Pan Card Number");
		myObj.nextLine();
		String panCardNo = myObj.nextLine();
		File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
		InputStream in = new FileInputStream(myFile1);
		 BufferedReader  in2 = new BufferedReader(new InputStreamReader(in));
		  String line;
		  line = in2.readLine();
		  int flag=0;
		  while (line != null) {
		       
		        int myindex;
				myindex= line.indexOf(panCardNo);
				if(myindex==-1)
				{
					line = in2.readLine();
					continue;
					
				}
				else
				{	System.out.println("Your Account Details Are:");
					System.out.println(line);
					flag++;
					line = in2.readLine();
					break;
				}
			
		      }
		  if(flag==0)
		  System.out.println("Not Found!");
		  in.close();
		  in2.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void newAccount()throws IOException
	{
		//LinkedHashMap<Integer, Integer> lhmap =  new LinkedHashMap<Integer, Integer>();
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
		
		
		
		
	//	lhmap.put(panCardNo, balance);
//		Properties properties = new Properties();
//		properties.putAll(lhmap);
//		//File myFile1map = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\Map.properties");
//		properties.store(new FileOutputStream("data.properties", true), null);
//		FileOutputStream fos = new FileOutputStream("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\hashmap.ser",true);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             AppendingObjectOutputStream ot=new AppendingObjectOutputStream(fos);
//             ot.writeObject(lhmap);
//             oos.close();
//             fos.close();
//             ot.close();
		
		File myFile1 = new File("C:\\Users\\arunim.chaudhary\\eclipse-workspace\\Hostbooks\\src\\daySix\\customerDetails.txt");
		myFile1.createNewFile();
		OutputStream out2 = new FileOutputStream(myFile1, true);
		PrintStream out = new PrintStream(out2);
		
		  
		  StringBuilder buffer = new StringBuilder();
		  buffer.append(name).append('\t').append(age).append('\t').append(panCardNo).append('\t').append(balance).append('\n');
		  
		  out.append(buffer); 
		  System.out.println("Account Created Successfully!");
		  out.close();
		  out2.close();   
		 
		
	}
}
