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
        // TODO code application logic here
        MainFrame mainFrame = new MainFrame();
        mainFrame.setTitle("Greenwich Cabs");
        mainFrame.setSize(700,500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        mainFrame.setVisible(true);
    }
    
}
