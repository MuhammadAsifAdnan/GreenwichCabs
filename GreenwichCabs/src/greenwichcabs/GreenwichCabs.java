/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;
import java.util.ArrayList;
import java.util.List;
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
        
        createDriverList();
    }
    
    private static void createDriverList() {
        List<Driver> drivers = new ArrayList<Driver>();
        drivers.add(new Driver(1, "John Doe"));
        drivers.add(new Driver(2, "Jack Sparrow"));
        drivers.add(new Driver(3, "Hans Down"));
        drivers.add(new Driver(4, "Alan Fresco"));
        drivers.add(new Driver(5, "Malcom Function"));
        drivers.add(new Driver(6, "Sue Shei"));
        drivers.add(new Driver(7, "Richard Tea"));
        drivers.add(new Driver(8, "Theodore Handle"));
        drivers.add(new Driver(9, "Elenor Fant"));
        drivers.add(new Driver(10, "Archibald Northbottom"));
        
        
    }
    
}
