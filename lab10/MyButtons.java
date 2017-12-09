
/**
 * Write a description of class MyButtons here.
 *
 * @author  Cipher
 * @version 20171110
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// The questions says "each one of the four questions should be a separate 
// class of its own, created as a separate class file inside the same BlueJ 
// project", so I "packed" them in a single class, though ugly. 

public class MyButtons extends JPanel {
    final static int HEIGHT = 250;
    final static int WIDTH = 150;
    
    private JButton red;
    private JButton green;
    private JButton blue;
    
    // the question says "use a nested ActionListener subclass to listen to the 
    // action events of these three buttons.", which contrasts the spirit of 
    // inner-class ActionListener
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("Red")) {
                setBackground(Color.RED);
            }
            else if (cmd.equals("Green")) {
                setBackground(Color.GREEN);
            }
            else if (cmd.equals("Blue")) {
                setBackground(Color.BLUE);
            }
            else {
                // Should throw exception here; 
                // but this course is too shitty;
            }
        }
    }

    
    public MyButtons() {
        super();

        setSize(250, 100);
        
        red = new JButton("Red");
        green = new JButton("Green");
        blue = new JButton("Blue");
        
        ActionListener listener = new ButtonListener();
        red.addActionListener(listener);
        green.addActionListener(listener);
        blue.addActionListener(listener);
        
        add(red);
        add(green);
        add(blue);
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Q2");
        
        final int NUM_MY_BUTTONS = 6;
        final int NUM_ROW = 2;
        final int NUM_COL = 3;
        
        GridLayout grid = new GridLayout(NUM_ROW, NUM_COL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(grid);
        
        for (int i = 0; i < NUM_MY_BUTTONS; i++) {
            frame.add(new MyButtons());
        }
        
        frame.pack();
        frame.setVisible(true);
    }
}   
