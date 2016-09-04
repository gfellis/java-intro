/**
* This program takes a user input from a dialog box (weight in kilograms) and 
* converts it to pounds.  The user has the option to see the same weight converted
* for other celestial bodies.
*
* @author	Gregory S. Fellis
* @version	1.0
* @since	2016-06-15
*/

import javax.swing.JOptionPane;     // used to display the GUI dialog for user input and output

public class GSF_02_weight_converter {		
    
    public static void main(String[] args) {

        // Variables
        String str;             // generic string for formatting dialog boxes
        int dialogButton;       // integer used for showConfirmDialog values
        double weightInKilos;   // double for user input
        double weightInPounds;  // convert user input to pounds

        // Try/Catch block to ensure valid user input
        try {
            // assign the user input to a double variable, weightInKilos, using a showInputDialog box
            weightInKilos = Double.parseDouble(JOptionPane.showInputDialog(
                null,                                               //parentComponent - specified as null to appear in the middle of the screen
                "Please enter the mass of a person in kilograms:",  //messageStringExpression - prompts the user for a weight in KiloGrams
                "Weight Converter",                                 //boxTitleString - Changes the title of the dialog box
                JOptionPane.QUESTION_MESSAGE                        //messageType - Changes appearance of the dialog box based on type. A question mark is appropriate for user input dialog
            ));

            // convert user input to pounds
            weightInPounds = weightInKilos * 2.2;
            
            // setup string for output in dialog box
            str = String.format("The weight you entered in kilograms: %.2f%n" +
                                "Here on Earth, that's %.2f pounds%n%n" + 
                                "Do you wish to see what this weight is on other celestial bodies?",
                                weightInKilos, weightInPounds);
            
            // yes/no dialog also displaying the converted weight in pounds.
            dialogButton = JOptionPane.showConfirmDialog(
                null,
                str,                            // Use the variable defined above as the output string
                "Weight Converted",
                JOptionPane.YES_NO_OPTION,      // Changes dialog buttons to Yes/No instead of OK/Cancel
                JOptionPane.INFORMATION_MESSAGE // Displays an i icon in the upper left of the dialog box
            );

            // the showConfirmDialog returns an int of 0 or 1 depending on button selection            
            // if the user selects Yes(0), then the following message is displayed:
            if (dialogButton == 0) {
                str = String.format("User Weight: %.2f kgs%n" +
                                    "Earth: %.2f lbs%n%n" +
                                    "Mercury: %.2f lbs%n" +
                                    "Venus: %.2f lbs%n" + 
                                    "Earth Moon: %.2f lbs%n" +
                                    "Mars: %.2f lbs%n" +
                                    "Jupiter: %.2f lbs%n" +
                                    "Saturn: %.2f lbs%n" +
                                    "Uranus: %.2f lbs%n" +
                                    "Neptune: %.2f lbs%n" +
                                    "Pluto: %.2f lbs%n%n",
                                    weightInKilos,          // user input
                                    weightInPounds,         // Earth
                                    weightInPounds * .38,   // Mercury
                                    weightInPounds * .91,   // Venus
                                    weightInPounds * .17,   // Earth Moon
                                    weightInPounds * .38,   // Mars
                                    weightInPounds * 2.54,  // Jupiter
                                    weightInPounds * 1.08,  // Saturn
                                    weightInPounds * .91,   // Uranus
                                    weightInPounds * 1.19,  // Neptune
                                    weightInPounds * .06);  // Pluto
                                    // Conversion ratios provided from:
                                    // www.easycalculation.com/physics/geophysics/weight-in-planets.php
                
                JOptionPane.showMessageDialog(null, str, "Weight on Other Celestial Bodies", JOptionPane.INFORMATION_MESSAGE);
            }

            // if the user selects No(1), then the IF statement above is skipped.  Either way, we exit the program
            System.exit(0); 

        } catch (NumberFormatException numberFormatException) {
            // if a valid number was not entered, show a message and send the user back to main()
            JOptionPane.showMessageDialog (null, "Please enter a valid decimal.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            
            main(null);
        } catch (NullPointerException nullPointerException) {
            // Should the user decide to close the first dialog, or select the cancel button, this option will show
            // Display a dialog confirming the user's desire to quit
            dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you wish to quit?", "Quit?", JOptionPane.YES_NO_OPTION);

            // showConfirmDialog returns a 0 for Yes, and 1 for no.
            // If the user hits Yes, then exit.  Otherwise, start over in main.
            if(dialogButton == 0) {
                System.exit(0);
            }
            
            main(null);
        }
    }
}