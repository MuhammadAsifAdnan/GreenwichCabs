/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.sql.*;

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
        databaseConnection();
    }
    
    private static void createDriverList() {
        List<Driver> drivers = new ArrayList<Driver>();
        drivers.add(new Driver(1, "John Doe", "1234-4321-5678-8765"));
        drivers.add(new Driver(2, "Jack Sparrow", "1234-4321-5678-8765"));
        drivers.add(new Driver(3, "Hans Down", "1234-4321-5678-8765"));
        drivers.add(new Driver(4, "Alan Fresco", "1234-4321-5678-8765"));
        drivers.add(new Driver(5, "Malcom Function", "1234-4321-5678-8765"));
        drivers.add(new Driver(6, "Sue Shei", "1234-4321-5678-8765"));
        drivers.add(new Driver(7, "Richard Tea", "1234-4321-5678-8765"));
        drivers.add(new Driver(8, "Theodore Handle", "1234-4321-5678-8765"));
        drivers.add(new Driver(9, "Elenor Fant", "1234-4321-5678-8765"));
        drivers.add(new Driver(10, "Archibald Northbottom", "1234-4321-5678-8765"));
        
        
    }
    
    private static void databaseConnection() {
        Connection conn = null; // A connection object is used to provide access to a database
        try{
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/greenwichcabs", "asif", "Wonder4U");
            // Statement objects executes a SQL query
            // createStatement returns a Statement object
            Statement sqlStatement = conn.createStatement();
            String selectStuff = "Select * from Drivers";
            ResultSet rows = sqlStatement.executeQuery(selectStuff);
            
            while(rows.next()){
                System.out.println(rows.getString("ID"));
                System.out.println(rows.getString("NAME"));
                System.out.println(rows.getString("ssn"));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
