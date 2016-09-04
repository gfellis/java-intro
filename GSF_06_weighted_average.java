/**
* This program calculates the weighted average of four test scores.
* The four test scores and weights can be entered by the user.
*
* @author	Gregory S. Fellis
* @version	1.0
* @since	2016-07-19
*/

import javax.swing.*;       // needed to add swing elements to the GUI
import java.awt.*;          // needed to include GridLayout
import java.awt.event.*;    // needed for Event Listeners

public class GSF_06_weighted_average extends javax.swing.JFrame {
    // Variables
    private JLabel lblScore1, lblScore2, lblScore3, lblScore4, 
                lblWeight1, lblWeight2, lblWeight3, lblWeight4, lblAvg;
    private JTextField txtScore1, txtScore2, txtScore3, txtScore4, 
                txtWeight1, txtWeight2, txtWeight3, txtWeight4, txtAvg;
    private JButton btnCalc;
    private JMenuBar menuBar; 
    private JMenu menu;
    private JMenuItem helpMI, aboutMI, exitMI;    
    
    private CalcButtonHandler cbHandler;
    
    public GSF_06_weighted_average () {
        // Call initComponents to define the form elements
        initComponents();        
    }
    
    public static void main(String[] args) {
        // Instantiate the form and set it visible.
        new GSF_06_weighted_average().setVisible(true);
    }
    
    // ActionListener Class that performs calculations when the Calculate Button
    // is pressed.
    private class CalcButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double avg1, avg2, avg3, avg4, avgScore;
            
            // Try/Catch to parse for valid input
            try {
                // parse each text field for it's value and perform calculations
                avg1 = Double.parseDouble(txtScore1.getText()) *
                        Double.parseDouble(txtWeight1.getText());
                avg2 = Double.parseDouble(txtScore2.getText()) *
                        Double.parseDouble(txtWeight2.getText());
                avg3 = Double.parseDouble(txtScore3.getText()) *
                        Double.parseDouble(txtWeight3.getText());
                avg4 = Double.parseDouble(txtScore4.getText()) *
                        Double.parseDouble(txtWeight4.getText());               
                
                avgScore = (avg1 + avg2 + avg3 + avg4);                        
                
                // Set the output text field to the avgScore with 3 decimals
                txtAvg.setText(String.format("%.3f", avgScore));
                
            } catch (NumberFormatException nfe) {                
                // On error, set the output text as Invalid entry
                txtAvg.setText("Invalid entry");
            }
        }
    }
    
    private void initComponents() {
        // Setup Frame
        setTitle("Weighted Average Calculator");    // Title
        setSize(500, 150);  // Size (overridden when frame is packed
        setResizable(false);    // Don't resize frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);    // Exit program on close
        
        // Setup menu
        menuBar = new JMenuBar();
        menu = new JMenu("Menu");
        
        // Configure Exit menu item
        exitMI = new JMenuItem("Exit");
        exitMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dispose();      // Dispose of the JFrame
                System.exit(0); // Exit the program
            }
            
        });

        // Configure Info menu item
        helpMI = new JMenuItem("Help");
        helpMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"This program calculates the weighted average of four test scores.\n\n"
                + "Enter the scores in the textfields on the left side between the values of 0 and 100.\n"
                + "On the right, enter the percentage weight of each corresponding test in decimal form\n"
                + "For example: 93% = 0.93", "Help",  JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        // Configure About menu item
        aboutMI = new JMenuItem("About");
        aboutMI.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent evt) {
                JOptionPane.showMessageDialog(null,"GSF_06_weighted_average v1.0\n"
                + "Gregory S. Fellis", "About",  JOptionPane.PLAIN_MESSAGE);
            }
        });
                
        menu.add(helpMI);   // add Info under Menu
        menu.add(aboutMI);  // add About under Menu
        menu.add(new JSeparator()); // Add a seperator under Menu
        menu.add(exitMI);   // add Exit under Menu
        menuBar.add(menu);  // add Menu to the Menu Bar
        setJMenuBar(menuBar);   // add Menu Bar to the JFrame
        
        // Set JLabels
        lblScore1 = new JLabel("Test 1 Score: ", SwingConstants.RIGHT);
        lblScore2 = new JLabel("Test 2 Score: ", SwingConstants.RIGHT);
        lblScore3 = new JLabel("Test 3 Score: ", SwingConstants.RIGHT);
        lblScore4 = new JLabel("Test 4 Score: ", SwingConstants.RIGHT);
        lblWeight1 = new JLabel("Test 1 Weight: ", SwingConstants.RIGHT);
        lblWeight2 = new JLabel("Test 2 Weight: ", SwingConstants.RIGHT);
        lblWeight3 = new JLabel("Test 3 Weight: ", SwingConstants.RIGHT);
        lblWeight4 = new JLabel("Test 4 Weight: ", SwingConstants.RIGHT);
        lblAvg = new JLabel("Weighted Average: ", SwingConstants.RIGHT);
        
        // Set a FocusAdapter for all textfields
        FocusAdapter txtFocusAdapter = new FocusAdapter() {
            public void focusGained(FocusEvent fe) {
                ((JTextField)fe.getComponent()).selectAll(); 
            }
        };
        
        // Set JTextFields
        // All JTextField inputs will select all text when they gain focus
        txtScore1 = new JTextField("70", 5);
        txtScore1.addFocusListener(txtFocusAdapter);
        
        txtScore2 = new JTextField("95", 5);
        txtScore2.addFocusListener(txtFocusAdapter);
        
        txtScore3 = new JTextField("85", 5);
        txtScore3.addFocusListener(txtFocusAdapter);        
        
        txtScore4 = new JTextField("65", 5);
        txtScore4.addFocusListener(txtFocusAdapter);
        
        txtWeight1 = new JTextField("0.20", 5);
        txtWeight1.addFocusListener(txtFocusAdapter);
        
        txtWeight2 = new JTextField("0.35", 5);
        txtWeight2.addFocusListener(txtFocusAdapter);
        
        txtWeight3 = new JTextField("0.15", 5);
        txtWeight3.addFocusListener(txtFocusAdapter);
        
        txtWeight4 = new JTextField("0.30", 5);
        txtWeight4.addFocusListener(txtFocusAdapter);
        
        txtAvg = new JTextField("0", 5);
        txtAvg.setEditable(false);  // Don't allow the output field to be edited
        txtAvg.setFocusable(false); // Don't allow the output field to be focused

        // Set JButton
        btnCalc = new JButton("Calculate");
        cbHandler = new CalcButtonHandler();
        btnCalc.addActionListener(cbHandler);
        
        // Setup content pane and Grid Layout
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(5, 1));
        
        // Add Test1 Elements
        contentPane.add(lblScore1);
        contentPane.add(txtScore1);
        contentPane.add(lblWeight1);
        contentPane.add(txtWeight1);
        
        // Add Test2 Elements
        contentPane.add(lblScore2);
        contentPane.add(txtScore2);
        contentPane.add(lblWeight2);
        contentPane.add(txtWeight2);
        
        // Add Test3 Elements
        contentPane.add(lblScore3);
        contentPane.add(txtScore3);
        contentPane.add(lblWeight3);
        contentPane.add(txtWeight3);
        
        // Add Test4 Elements
        contentPane.add(lblScore4);
        contentPane.add(txtScore4);
        contentPane.add(lblWeight4);
        contentPane.add(txtWeight4);
        
        // Add Output Elements 
        contentPane.add(lblAvg);
        contentPane.add(txtAvg);
        
        // Add Calc Button and blank JLabel as a spacer
        contentPane.add(new JLabel(""));
        contentPane.add(btnCalc);
        
        //pack(); // Set components to default size
        setLocationRelativeTo(null);    // Spawn in center screen
    }
}