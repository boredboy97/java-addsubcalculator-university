// -------------------------------------------------------
// Assignment {3}
// Written by: {Brian Ly 40028072}
// For COMP 248 Section {H} – Fall 2023

/*Description: A program that offers two calculator operations: addition and subtraction. The user may enter any
 * 			   amount of numbers and may continue to repeat an operation indefinitely.
 */

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
		/* Algorithm 1: Basic Calculator: Addition and Subtraction
		 * Steps of algorithm are described before each section of code to facilitate reading
		 */
		
		// Step 1: Print welcome message
		
		System.out.println("Welcome to this calculator, offering Addition and Subtraction.");
		
		/* Step 2: Declaration and initialization of variables
		 * 		   - Declare scanner variable for user input
		 * 		   - Initialize count variable
		 * 		   - Initialize double variables to read number and to use for addition and subtraction
		 * 		   - Initialize string variables to use for user input 
		 */
		
		Scanner keyIn = new Scanner(System.in);
		int count = 0;
		double num = 0; // double variable that will be used to parse each element of string array
		double addition = 0, subtraction = 0;
		double numbersTosubtract = 0; //sum of input numbers excluding first input to facilitate subtraction
		String input; //To validate selection of operation
		int operation = 0; //To use for valid input to select addition or subtraction
		String another = ""; 
		
		
		/*Step 3: Outer do-while loop that prompts user to select the desired operation
		 * 		   - Prompt user for input to select operation 
		 *		   - Increment count at the end of do-while loop
		 *		   - The while condition is true if user enters (y,Y or Yes) to perform another operation,
		 *			 and the loop is repeated.
		 *
		 * Step 4: Check user input for operation selection:
		 * 		   - Use an inner do-while loop to validate user's selection of operation. 
		 * 		   - If user inputs anything other than 1 or 2, print error message and prompt user again.
		 */
		
		do {
			System.out.print("Please select 1 for Addition or 2 for Subtraction: ");
			input = keyIn.next(); //to read any input even strings
			
			while (!(input.contains("1")||input.contains("2"))) //while input is not 1 or 2, prompt user for valid input
			{
				System.out.print("Operation not supported, please make another choice: "); 
				input = keyIn.next();
			}
			
			operation = Integer.parseInt(input);
			
			
		//Step 5: Prompt user for numbers
		//Step 6: Store the first number as a count variable to indicate how many numbers user will input
			
			System.out.print("Please input your numbers: ");
			count = keyIn.nextInt();
			
		/* Step 7: Switch statement inside second do-while loop for addition or subtraction
		 * 		   There will be two cases: Addition and subtraction. Operations are described in step 6
		 * 		   For subtraction, store the first number after count as the number to subtract from.
		 * Step 8: For loops within each switch case to perform operations
		 * 		   Number of iterations will equal count variable that user inputs
		 * 		   - Case 1 (Addition):
		 * 			 - For each iteration, store next input as a double then add it to the addition variable
		 * 			 - Display addition output
		 * 		   - Case 2 (Subtraction):
		 * 			 - For each iteration, starting from second number, store as a double
		 * 			 - Sum these subsequent numbers as a sum to subtract from first number
		 * 			 - Subtract sum of numbers from first number	
		 * 			 - Display subtraction output
		 */
			
			switch (operation) //Two cases: addition or subtraction
			{ 
			case 1:
				
				for (int i = 1; i <= count; i++)
				{
					num = keyIn.nextDouble();
					addition += num; // To sum all the numbers entered one by one
				}
				System.out.printf("The result of your addition is: " + "%.2f", addition);
				break;
			case 2:
				subtraction = keyIn.nextDouble(); //Store first number to subtract from
				for (int i = 1; i < count; i++)
				{
					num = keyIn.nextDouble(); 
					numbersTosubtract += num; //Sum subsequent numbers to subtract
				}
				subtraction -= numbersTosubtract;
				System.out.printf("The result of your subtraction is: " + "%.2f", subtraction);
				break; 
				
			}
			
		/* From Step 3: Prompting user to repeat operation
		 * In the do-while loop, the condition is true if user enters (y,Y or Yes) to perform another operation,
		   and the loop is repeated.	
		 */
			
			System.out.print("\nDo you want to perform another operation? y/yes: ");
			another = keyIn.next();
			addition = 0; subtraction = 0; //Resetting sum and difference to 0
			count++;
		
		}
		while (another.equals("y")|| another.equals("Y") || another.equals("Yes")); // as shown in sample output
		
		keyIn.close(); // close scanner object
		
		// Step 7: Print goodbye message.
		
		System.out.println("Goodbye!");	
		
		}
		
	}
