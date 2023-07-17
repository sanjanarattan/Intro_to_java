import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LavaLamp {
    
    private static final int TIMER_DELAY = 100; //milliseconds
    private static final int MAX_COLOR_CHANGE = 50; 
    
    private static boolean Updating = true;
    private static Color bgColor;
    private static Timer timer;
    
    public static void main(String[] args) {
        // Create a new JFrame 
        JFrame frame = new JFrame("LavaLamp");
        // Create a new JPanel
        JPanel panel = new JPanel();
        // Create a new JButton 
        JButton button = new JButton("Click me!!");
        
        // Set the initial background color to white
        bgColor = Color.WHITE;
        // Set the background color of the panel
        panel.setBackground(bgColor);
        
        // ActionListener for the button
        button.addActionListener(new ActionListener() {
            // When the button is pressed
            public void actionPerformed(ActionEvent e) {
                // If colors are updating
                if (Updating) {
                    Updating = false;
                    timer.stop();
                    System.out.println(bgColor.getRed() + "," + bgColor.getGreen() + "," + bgColor.getBlue());
                } 
                // Otherwise, start 
                else {
                    Updating = true;
                    timer.start();
                }
            }
        });
        
        // Add the button to the panel
        panel.add(button);
        // Add the panel to the frame
        frame.add(panel);
        // Set the default close operation for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Pack the frame
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);
        
        // Create a new Timer to time color change
        timer = new Timer(TIMER_DELAY, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Generate random values for color
                int red = bgColor.getRed() + (int)(Math.random() * MAX_COLOR_CHANGE) - MAX_COLOR_CHANGE/2;
                int green = bgColor.getGreen() + (int)(Math.random() * MAX_COLOR_CHANGE) - MAX_COLOR_CHANGE/2;
                int blue = bgColor.getBlue() + (int)(Math.random() * MAX_COLOR_CHANGE) - MAX_COLOR_CHANGE/2;
                // Limit the color values to a range of [0, 255]
                red = Math.max(0, Math.min(255, red));
                green = Math.max(0, Math.min(255, green));
                blue = Math.max(0, Math.min(255, blue));
                
                // Set the new background color
                bgColor = new Color(red, green, blue);
                panel.setBackground(bgColor);
            }
        });
        
        // Start the timer
        timer.start();
    }
}

