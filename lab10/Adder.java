
/**
 * Write a description of class Adder here.
 *
 * @author  Cipher
 * @version 20171110
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Adder extends JFrame {
    private JTextField operand1;
    private JTextField operand2;
    private JLabel result;
    private JButton button;
    final private int TEXT_FIELD_WIDTH = 16;
    
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            result.setText(Double.toString(
                Double.valueOf(operand1.getText()) + Double.valueOf(operand2.getText()) 
            ));
        }
    }
    
    
    public Adder() {
        super("Q4");
        this.setLayout(new GridLayout(1, 4));
        
        this.operand1 = new JTextField(TEXT_FIELD_WIDTH);
        this.add(operand1);
        
        this.operand2 = new JTextField(TEXT_FIELD_WIDTH);
        this.add(operand2);
        
        this.button = new JButton("Add");
        this.button.addActionListener(new ButtonListener());
        this.add(button);
        
        this.result = new JLabel();
        this.add(result);
    }
    
    
    public static void main(String[] args) {
        Adder adder = new Adder();
        adder.pack();
        adder.setVisible(true);
    }
}
