/**
* This program takes a user input of three numbers from a dialog box and 
* outputs the given numbers in non-descending (ascending) order one of two
* user selectable solutions, Arrays.sort or for loops.
*
* @author	Gregory S. Fellis
* @version	1.0
* @since	2016-06-28
*/

import javax.swing.*;       // used to display a custom GUI dialog user input and output
import java.util.Arrays;    // used for manipulating arrays

public class GSF_03_number_sorter {
    
    public static void main(String[] args) {

        // Variables
        int btn;   // integer used for showConfirmDialog values         
        double[] numbers = new double[3];        // Array to hold the values from the input dialog
        String output, solution;       // strings for output and solution type used
        boolean useArray = false;       // boolean to select solution to use
        double min, mid, max;        // doubles for the three values
        
        // Custom Dialog Box -- BEGIN
        // Generate 3 text fields for user input
        JTextField numText1 = new JTextField(10);
        JTextField numText2 = new JTextField(10);
        JTextField numText3 = new JTextField(10);
        
        // Create radio buttons to select a solution
        JRadioButton solution1 = new JRadioButton("Arrays.sort");
        solution1.setSelected(true);
        JRadioButton solution2 = new JRadioButton("For Loops");
        
        // Group the radio buttons together
        ButtonGroup solutions = new ButtonGroup();
        solutions.add(solution1);
        solutions.add(solution2);
                
        // Create a new panel for the elements to be housed in
        JPanel numberPanel = new JPanel();
        
        // Set the panel layout to BoxLayout for nice formatting
        numberPanel.setLayout(new BoxLayout(numberPanel, BoxLayout.PAGE_AXIS));
        
        // Label at the top to prompt the user what to do
        JPanel msgPanel = new JPanel();
        numberPanel.add(msgPanel);
            msgPanel.add(new JLabel("Please enter three numbers below:"));
        
        // Panel containing label and text field for Number 1
        JPanel numPanel1 = new JPanel();
        numberPanel.add(numPanel1);        
            numPanel1.add(new JLabel("Number 1: "));
            numPanel1.add(numText1);
        
        // Panel containing label and text field for Number 2
        JPanel numPanel2 = new JPanel();
        numberPanel.add(numPanel2);       
            numPanel2.add(new JLabel("Number 2: "));
            numPanel2.add(numText2);
        
        // Panel containing label and text field for Number 3
        JPanel numPanel3 = new JPanel();
        numberPanel.add(numPanel3);       
            numPanel3.add(new JLabel("Number 3: "));
            numPanel3.add(numText3);
        
        // Add radio buttons to select a solution with label
        JPanel checkPanel = new JPanel();
        numberPanel.add(checkPanel);
            checkPanel.add(new JLabel("Choose a solution: "));
            checkPanel.add(solution1);
            checkPanel.add(solution2);
        
            
        // Custom Dialog Box -- END
        
        try {
            // Display the Dialog Box built above for user input
            btn = JOptionPane.showConfirmDialog(null, numberPanel, "Input Numbers", JOptionPane.OK_CANCEL_OPTION);
            
            if (solution1.isSelected()) {
                useArray = true;
            }
                        
            // If the user presses OK, continue to process the numbers
            if (btn == JOptionPane.OK_OPTION) {
                
                // Assign the values of the text boxes to the array
                numbers[0] = Double.parseDouble(numText1.getText());
                numbers[1] = Double.parseDouble(numText2.getText());
                numbers[2] = Double.parseDouble(numText3.getText());              

                // Sorts the array from lowest to highest values
                //Arrays.sort(numbers);
                
                if (useArray) {                
                    // Using Array.sort organizes the array from lowest to highest values                    
                    Arrays.sort(numbers);
                    
                    solution = "Array.sort";
                    
                    min = numbers[0];
                    mid = numbers[1];
                    max = numbers[2];                    
                    
                } else {                           
                    // set all values to the first number entered to be overwritten as necessary in the for loops
                    min = numbers[0];
                    mid = numbers[0];
                    max = numbers[0];
                    
                    solution = "for loops";
                            
                    // get min
                    for (int i = 1; i < numbers.length; i++) {
                        if (numbers[i] < min) {
                            min = numbers[i];
                        }
                    }

                    // get max
                    for (int i = 1; i < numbers.length; i++) {                    
                        if (numbers[i] > max) {
                            max = numbers[i];
                        }
                    }

                    // get mid
                    for (int i = 1; i < numbers.length; i++) {
                        if (numbers[i] < max && numbers[i] > min) {
                            mid = numbers[i];
                        }
                    }
                }
                
                output = String.format("Solution: " + solution + "\n\nYour numbers in non-descending order are:\n %.2f, %.2f, %.2f", min, mid, max);
                  
                // Display the output in a new message dialog from lowest to highest
                JOptionPane.showMessageDialog(null, 
                    output, 
                    "Numbers In Order", 
                    JOptionPane.INFORMATION_MESSAGE);
            } else {            
                // Should the user decide to close the first dialog, or select the cancel button, this option will show
                // Display a dialog confirming the user's desire to quit
                btn = JOptionPane.showConfirmDialog (null, "Are you sure you wish to quit?", "Quit?", JOptionPane.YES_NO_OPTION);

                // showConfirmDialog returns a 0 for Yes, and 1 for no.
                // If the user hits Yes, then exit.  Otherwise, start over in main.
                if(btn == 0) {
                    System.exit(0);
                }
                
                main(null);
            }
        } catch (NumberFormatException numberFormatException) {
            // if a valid number was not entered, show a message and send the user back to main()
            JOptionPane.showMessageDialog (null, "Please enter valid decimals into the text boxes.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
            
            main(null);
        }
    }
}