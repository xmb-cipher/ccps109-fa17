
/**
 * Write a description of class MyLabels here.
 *
 * @author  Cipher
 * @version 20171006
 */

import java.awt.*;
import javax.swing.*;


public class MyLabels extends JPanel {
    public MyLabels() {
        super();
        this.add(new JLabel("One"));
        this.add(new JLabel("Two"));
        this.add(new JLabel("Three"));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setSize(200, 100);
    }
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Q1");
        frame.setLayout(new FlowLayout());
        
        frame.add(new MyLabels());
        frame.add(new MyLabels());
        frame.add(new MyLabels());
        
        frame.pack();
        frame.setVisible(true);
    }
}
