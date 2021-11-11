package project;

import java.util.Scanner;
import java.lang.Math;    // Accessing the methods in math class

abstract class findDistance 
{  
    //non-static method
	abstract protected int Distance(String a, String b,boolean caseSensitive) ;
    
}

   // inheritance for accessing the method defined in the superclass
   // Super class --> findDistance
   // Sub class --> Levenshtein_Distance

 public class Levenshtein_Distance extends findDistance{
	
	public int Distance(String a, String b,boolean caseSensitive)	{
	
			// If we want to ignore case sensitivity,lower case the strings
			 if(!caseSensitive)
		       {
		           a = a.toLowerCase();
		           b = b.toLowerCase();
		       }
			
			 // Storing the lengths of the strings as integers 
			 
			int m= a.length();
			int n= b.length();
			
			// Creating an array of size (length+1) due to considering the null columns and rows too
			
			int d[][] = new int[m+1][n+1];
			
			// Initializing first row:
			
			for(int i = 0; i <= m; i++) {
				d[i][0] = i;
			}
			
			// Initializing first column:
			
			for(int j = 0; j <= n; j++) {
				d[0][j] = j;}
			
			// Applying the algorithm:
			
			int x,y,z; //declaring the variables x,y,z
			
			   for(int i = 1;i <= m; i++) { // Outer loop Iteration
				
				  for(int j = 1; j<= n; j++) { // Inner Loop Iteration
					
					if(a.charAt(i - 1) == (b.charAt(j - 1))) { 
						
						// Taking the condition where the characters are equal at the given positions
						
						d[i][j] = d[i - 1][j - 1];}
					
				       	else { 
						
						// 	Taking the condition where the characters are not equal at the given positions.
				       		
						x= d[i][j - 1];
						y= d[i - 1][j];
						z= d[i - 1][j - 1];
						
						int miny = Math.min(y, z);
						int minx = Math.min(x, miny);
						
					    // Initializing the array 'd' by finding the minimum of the above arrays 
						d[i][j] = 1 + minx;
					}
				}
			 }
			
		   return d[m][n];	
	  }
	
	    //defining a method called operation of return type int 
	
	 int operation() 
	{
		 Scanner sc=new Scanner(System.in);    
		 
		 //Taking user input for the string 1
		System.out.println("Enter The string 1:");
		String a = sc.nextLine();
		
		//Taking user input for the string 2
		System.out.println("Enter the String 2: ");
		String b = sc.nextLine();
		
		
		System.out.println("Levenshtein Distance: " + Distance(a, b, true));
				
		sc.close();
		
	   return 0;
	}
	public static void main(String[] args)
	{
		
		Levenshtein_Distance obj = new Levenshtein_Distance ();
		
		obj.operation(); //invoking the method operation 
		
	}
}
 
 
 