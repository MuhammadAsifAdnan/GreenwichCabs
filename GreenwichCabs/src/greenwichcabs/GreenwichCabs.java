/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;
import javax.swing.*;

/**
 *
 * @author user
 */
public class GreenwichCabs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Greenwich Cabs");
        mainFrame.setSize(700,500);
        mainFrame.setLocationRelativeTo(null); // Starts the window at the center of the screen
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This makes sure when closing the window the app is
        // terminated. As we are using custom window close button, this actually wont do anything.
       
        mainFrame.setVisible(true);
    }
    
}
