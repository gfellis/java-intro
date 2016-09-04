/**
* This program tests the functionality of the custom class, Day.
* A custom jFrame has been created to test the operations of the Day class.
* which include:
*   Set the day
*   Print the day
*   Return the day
*   Return the previous day
*   Calculate appropriate day by adding X number of days to current day
*       Monday + 4 = Friday, Tuesday + 13 = Monday
*
* @author	Gregory S. Fellis
* @version	2.0
* @since	2016-08-01
*/

import java.awt.Color;  // Used to set Label Colors for errors
import java.util.Arrays;    // Used by Day class to manipulate daysOfWeek array
import java.util.Calendar;  // Used by Day class to get current system day

// Day Class
/* Normally I would make this a public class and put into it's own file
 * Day.java, but the the 8-4 instructions specifically say:
 * "compress the .java file into a single .zip file."
 * So I've placed it here as it's own class. */
class Day {
    // DAY FIELDS
    public String day; // String to hold the current set day
    public String[] daysOfWeek = { // Array to hold all the daysOfWeek
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday"            
    };    

    // DAY CONSTRUCTORS
    /* Overloaded constructors, Day() and Day(string) */
    public Day() {                      
        // Construct a Day to the current System Clock day
        int i = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
        this.setDay(i - 1);
    }        

    public Day(String day) {            
        // Construct a Day to the string passed
        /* This constructor isn't used in the test program, but could be 
         * useful for a different program */
        try {
            this.setDay(getDayNumber(day));
        } catch (ArrayIndexOutOfBoundsException oob) {
            System.err.println("Requested day not found.");
        }
    }        

    // DAY METHODS        
    public void setDay(int day) {
        // Set the day field to the string provided by getDay(int)
        this.day = getDay(day);
    }

    /* Overloaded methods: getDay() and getDay(int) */
    public String getDay() {
        // Return the current value of day
        return this.day;   
    }

    public String getDay(int day) {
        // Return the string of day
        return this.daysOfWeek[day];      
    }

    public String nextDay () {
        // Return a string by sending current day index number +1 to calcDay 
        return this.getDay(this.calcDay(this.getDayNumber(this.day) + 1));
    }

    public String prevDay () {
        // Return a string by sending current day index number -1 to calcDay
        return this.getDay(this.calcDay(this.getDayNumber(this.day) - 1));
    }

    public int calcDay(int days) {
        /* Adding negative numbers resulted in an 
         * ArrayIndexOutOfBoundsException.  To keep values within 0-6 
         * use the abs value of the abs value of days minus the 
         * daysOfWeek.length (7). */
        if (days < 0) { 
            days = Math.abs(Math.abs(days) - daysOfWeek.length); 
        }

        /* This takes the modulus of days and the daysOfWeek.length (7)
         * which will return a value of 0-6 */
        return days % this.daysOfWeek.length;
    }

    public int getDayNumber(String day) {
        // Returns the index int of a given day within the daysOfWeek array
        return Arrays.asList(this.daysOfWeek).indexOf(day);            
    }
}

public class GSF_08_Day_class_tester extends javax.swing.JFrame {
    // Variables
    Day myDay = new Day();  // Instantiate a new Day
    boolean init = false;   // Determines when all initilization is complete
    
    /**
     * Creates new form GSF_08_Day_class_tester
     */
    public GSF_08_Day_class_tester() {

        initComponents();  
        updateLabels();

        // Set the JComboBox values to Days of Week from myDay
        for (String days : myDay.daysOfWeek) {
            dayBox.addItem(days);
        }
        
        // Set the Daybox to the appropriate day
        dayBox.setSelectedIndex(myDay.getDayNumber(myDay.getDay()));
                
        init = true;   // Initialization of the JFrame complete.
    }
    
    public void updateLabels() {
        // Update label values on the JFrame
        lblDay.setText(myDay.getDay()); // Call getDay() to get current day
        lblPrevDay.setText(myDay.prevDay()); // set label to yesterday
        lblNextDay.setText(myDay.nextDay()); // set label to tomorrow
        
        // Calculate the value in the text field and change the label to the 
        // appropriate day.        
        try {
            String calcDay = myDay.getDay(
                myDay.calcDay(
                    myDay.getDayNumber(myDay.day) + 
                    Integer.parseInt(daysText.getText())
                )
            );
            
            lblCalcDay.setForeground(Color.black);
            lblCalcDay.setText(calcDay);
        } catch (NumberFormatException nfe) {
            lblCalcDay.setForeground(Color.red);
            lblCalcDay.setText("Invalid # of days");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDay = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblNextDay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPrevDay = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dayBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        daysText = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblCalcDay = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        calcBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Day() Tester");
        setResizable(false);

        lblDay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDay.setText("Day");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Day is:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Tomorrow is:");

        lblNextDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNextDay.setText("NextDay");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Yesterday was:");

        lblPrevDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPrevDay.setText("PrevDay");

        dayBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dayBoxItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Set day to:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("What if I added");

        daysText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        daysText.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("days?");

        lblCalcDay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCalcDay.setText("CalcDay");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Day would be:");

        calcBtn.setText("Calculate");
        calcBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNextDay, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrevDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCalcDay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(daysText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(calcBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(lblPrevDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNextDay))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(daysText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(calcBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblCalcDay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dayBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dayBoxItemStateChanged
        /* Wrapped code within a boolean to prevent the for loop used to 
         * populate the menu from setting the day incorrectly. */         
        if (init) {
            myDay.setDay(dayBox.getSelectedIndex());            
            updateLabels();
        }        
    }//GEN-LAST:event_dayBoxItemStateChanged

    private void calcBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcBtnActionPerformed
        // Just recall updateLabels, don't need to reinvent the wheel
        updateLabels();
    }//GEN-LAST:event_calcBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GSF_08_Day_class_tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GSF_08_Day_class_tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GSF_08_Day_class_tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GSF_08_Day_class_tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GSF_08_Day_class_tester().setVisible(true);
            }
        });                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcBtn;
    private javax.swing.JComboBox<String> dayBox;
    private javax.swing.JTextField daysText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCalcDay;
    private javax.swing.JLabel lblDay;
    private javax.swing.JLabel lblNextDay;
    private javax.swing.JLabel lblPrevDay;
    // End of variables declaration//GEN-END:variables
}
