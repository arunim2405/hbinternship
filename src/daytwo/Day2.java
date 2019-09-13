package daytwo;

import java.util.Scanner;

public class Day2 {
	public static void main(String[] args) {
		
		
		
	//	fifthPro();
		//sixthPro();
		seventhPro();
		
	}
	


public static void seventhPro() 
{
	System.out.println("Enter the array size");
	Scanner myyObj1 = new Scanner(System.in);
	int as = myyObj1.nextInt();
	int arr1[] = new int[as];
	System.out.println("Enter the array ");
	for(int i=0;i<as;i++)
	{
		
		arr1[i]=myyObj1.nextInt();
	}
	System.out.println("Unsorted Array");
	printArray(arr1);
	System.out.println(" 1.Bubble\n 2.Selection\n 3.Insertion\n ");
	
	
	int ch = myyObj1.nextInt();
	if(ch==1)
	{
		bubbleSort(arr1);
		System.out.println("Sorted Array");
		printArray(arr1);
	}
	
	else if(ch==2)
	{
		selectSort(arr1);
		System.out.println("Sorted Array");
		printArray(arr1);
	}
	
	else if(ch==3)
	{
		insertionSort(arr1);
		System.out.println("Sorted Array");
		printArray(arr1);
	}
	else
	{
		System.out.println("Wrong choice!");
	}
	
}

static void insertionSort(int arr[])  
{  
	int n=arr.length;
    int i, key, j;  
    for (i = 1; i < n; i++) 
    {  
        key = arr[i];  
        j = i - 1;  
  
     
        while (j >= 0 && arr[j] > key) 
        {  
            arr[j + 1] = arr[j];  
            j = j - 1;  
        }  
        arr[j + 1] = key;  
    }  
}  

 static void selectSort(int arr[])
    {
        int n = arr.length;
 
     
        for (int i = 0; i < n-1; i++)
        {
            
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
         
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
static void printArray(int arr[])
 	{
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


public static void sixthPro()
{
	int num=1,i=0;
	System.out.println("Enter the number of rows");
	Scanner myyObj1 = new Scanner(System.in);
	int n = myyObj1.nextInt();
	do { int j=n-i+1;
		int k=0;
		do {
			j--;
			 System.out.print(" "); 
			
			
		}while(j>1);
		do {
			 System.out.print(num+ " ");
                num=num+1;
                k++;
		}while(k<=i);
		 System.out.println(); 
		i++;
	}while(i<n);
}

public static void fifthPro()
{
	int num=1;
	System.out.println("Enter the number of rows");
	Scanner myyObj1 = new Scanner(System.in);
	int n = myyObj1.nextInt();
	for (int i=0; i<n ; i++)
	{
		  for (int j=n-i; j>1; j--) 
            { 
               
                System.out.print(" "); 
            } 
   
           
            for (int j=0; j<=i; j++ ) 
            { 
               
                System.out.print(num+ " ");
                num=num+1;
            } 
   
            // ending line after each row 
            System.out.println(); 
	}
	
}
}