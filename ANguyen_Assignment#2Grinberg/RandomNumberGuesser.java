/*
 * Class: CMSC203 
 * Instructor:Grigoriy Grinberg
 * Description: (Give a brief description for each Class)
 * Due: 9/26/2022
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Andy Nguyen
*/

import java.util.Random;
import java.util.Scanner;// imported utility Scanner and Random for this program to work.

public class RandomNumberGuesser {

	public static void main(String[]args) { // could've organized better.
		Random rng = new Random(); 
		int rand = rng.nextInt(100);
		int resetCount = 7;
		int getCount = 1;
		int input;
		int low = 0;
		int high = 100;
		int validInput;
		boolean correctNum = false;
		do {
			
			System.out.println("Guess a number between 0 and 100! You only have 7 attempts! Please do not input any letters only numbers!");
			System.out.print("Input your first guess: ");
			Scanner inputted = new Scanner(System.in);
			input = inputted.nextInt();
			validInput = validation(input, low, high); // Using the int void methods?			
			if(validInput > rand || validInput < rand) { // If input not equal to the random number
			
				do {
					if (getCount != resetCount) { // If the amount of guesses the same as resetCount will lead to the end of program
						
					
						if (validInput < rand)
						{
							System.out.println("Number too low! \n" + "Number of guesses: " + getCount);
							getCount++;
							low = validInput;
							System.out.println("Guess another number between "+ low +  " and " + high);
							input = inputted.nextInt();
							validInput = validation(input, low, high);
						
						
						
						}
						else if (validInput > rand)
							{
							System.out.println("Number too high! \n" + "Number of guesses: " + getCount);
							getCount++;
							high = validInput;
							System.out.println("Guess another number between "+ low +  " and " + high);
							input = inputted.nextInt();
							validInput = validation(input,low,high);
						
							}
					}
					else if (getCount == resetCount)
					{
						System.out.println("You have exceeded the amount of guesses you have!\nThe random number is " + rand + "\nTry again.");
						end();
						System.exit(0); //Method to terminate the program
					}
				}while(validInput != rand);
			}
			else if (validInput == rand);
			{
				System.out.println("Congratulation, you've guessed correctly!\n Try again? (Yes or No, don't do y or n)" );
				Scanner yesOrNo = new Scanner(System.in);
				String ans;
				
				do // anything other than yes or no is invalid
				{	
					
					ans = yesOrNo.nextLine();
					if(	(ans.equalsIgnoreCase("no")))
					{
						correctNum = true;// If true then it'll finished the program
					}
					else if ((ans.equalsIgnoreCase("yes")))
					{
						correctNum = false; // make program restart
					}
					else
					{
						System.out.println("Invalid input! Please input Yes or No (Can't be y or n)");	
						
		
						
					}
				} while (!(ans.equalsIgnoreCase("no")) && !(ans.equalsIgnoreCase("yes")));
				rand = rng.nextInt(100); //restart the rng.
				low = 0;
				high = 100;
				getCount = 1;
				
				
			}
			
			
			
		}
		while(correctNum == false); // if false then it restart.
			
          end();
          
		
		
	}
	public static int validation(int inputValidation, int lowest, int highest) // using methods for input validations
	{
		int result = 0;
		Scanner inputt = new Scanner(System.in);
		do {
			if (inputValidation <lowest || inputValidation >highest)
			{
				System.out.println("Invalid input! Pick a number between " + lowest +  " and " +highest);
				inputValidation = inputt.nextInt();
			}
		}while(inputValidation <lowest || inputValidation >highest);
		result = inputValidation;
		return result;
		
		
	}
	public static void end() {
		System.out.print("Thanks for playing!\n\nProgrammer: Andy Nguyen.");
		
	}//void methods of the end message.


	
}
