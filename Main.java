import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JButton increaseButton;
  JButton resetButton;

  JLabel increaseLabel;
  JLabel counterLabel;

  JTextField increaseTextField;
  JTextField counterTextField;

  JPanel mainPanel;

  //sum integer
  int sum = 0;
  

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("A8 Test");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    //sets up main mainPanel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);
    frame.add(mainPanel);

    //sets up j labels
    increaseLabel = new JLabel("Increase By:");
    increaseLabel.setBounds(240, 180, 150, 25);
    counterLabel = new JLabel("Counter:");
    counterLabel.setBounds(240, 220, 150, 25);

    //makes labels setVisible
    mainPanel.add(increaseLabel);
    mainPanel.add(counterLabel);
 

    //sets up J text fields
    increaseTextField = new JTextField();
    increaseTextField.setBounds(410, 180, 150, 25);
    counterTextField = new JTextField("0");
    counterTextField.setBounds(410, 220, 150, 25);

    //to make counter text field not editable
    counterTextField.setEnabled(false);

    //makes the text fields setVisible
    mainPanel.add(increaseTextField);
    mainPanel.add(counterTextField);


    //creates and sets bounds for buttons
    increaseButton = new JButton ("Increase");
    increaseButton.setBounds(240, 135, 140, 25);
    resetButton = new JButton("Reset");
    resetButton.setBounds(410, 135, 140, 25);

    //sets action command
    increaseButton.setActionCommand("increase");
    resetButton.setActionCommand("reset");

    //adds action ActionListener
    increaseButton.addActionListener(this);
    resetButton.addActionListener(this);

    //adds buttons to main mainPanel
    mainPanel.add(increaseButton);
    mainPanel.add(resetButton);

    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

  
    if(command.equals("increase")){
      //to chnage users number into an int
      String increaseText = increaseTextField.getText();
      int increaseBy = Integer.parseInt(increaseText);
      //if statements for  adding to sum and showing it on counter
      if(sum < 10 && sum != 10){
        sum = sum + increaseBy;
        counterTextField.setText("" + sum);
      //if statement for keeping the sum the same if its over 10
      }else if (sum == 10){
        sum = sum;
        counterTextField.setText("" + sum);
      }
    //if statmenet for if user hits reset
    }else if (command.equals("reset")){
      //resets everything back to 0
      sum = 0;
      counterTextField.setText("0");
      increaseTextField.setText("");
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
