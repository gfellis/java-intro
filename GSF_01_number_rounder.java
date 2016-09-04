/**
* This program takes a user input decimal and rounds it to the nearest integer.
*
* @author	Gregory S. Fellis
* @version	1.0
* @since	2016-06-01
*/

import java.util.Scanner;		// used to read the input available from an InputStream Object (user input)

public class GSF_01_number_rounder {		
    static Scanner kbScanner = new Scanner(System.in);    //creates a handle to read user's keyboard input
    
    public static void main(String[] args) {
		// Variables
        double userDecimal;     // large decimal for user input
        long roundedInt;        // large int for rounding the user input value 
        String roundTest;       // String updated based on direction of the rounding
        
        // Print what the program does and inital prompt for input.
        System.out.println("+------------------------------+");
        System.out.println("|     .. Number Rounder ..     |");
        System.out.println("+------------------------------+");
        System.out.println("| This program takes a decimal |");
        System.out.println("| and rounds it to the nearest |");
        System.out.println("| whole number!                |");
        System.out.println("+------------------------------+");
        System.out.println();
        System.out.print("Please type a decimal number and press ENTER: ");
        
        //  If the kbScanner doesn't read a valid Double input
        //  it will display a message and continue to ask for one.
        while (!kbScanner.hasNextDouble()) {
            System.out.println(kbScanner.next() + " is not a valid number!");
            System.out.print("Please type a decimal number and press ENTER: ");
        }
        
        userDecimal = kbScanner.nextDouble();       // Assigns a valid double input from the kbScanner into the userDecimal variable
        roundedInt = Math.round(userDecimal);       // Takes the userDecimal and rounds to the nearest whole number using Math.Round, storing it into a long(int).
        
        kbScanner.close();   // Close the scanner, no further input is necessary.

        /*  The If,else statement below will change 
            the value of the roundTest string for the final output
            based on if the number was rounded up, down, or was the same. */                 
        if (userDecimal > roundedInt) {
            roundTest = "rounded down to ";
        } else if (userDecimal < roundedInt) {
            roundTest = "rounded up to ";
        } else {
            roundTest = "already equals ";
        }        

        // Output the text with the original number entered, the direction of the rounding, and the actual rounded number.
        System.out.print("The number you entered, " + userDecimal + ", " + roundTest + roundedInt + "!");        
   }
}