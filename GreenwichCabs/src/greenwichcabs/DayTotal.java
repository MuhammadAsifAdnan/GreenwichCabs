/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class DayTotal extends javax.swing.JPanel {

    ArrayList<Driver> DriverList = new ArrayList<>();
    ArrayList<Journey> JourneyList = new ArrayList<>(); // storing journey list from database
    /**
     * Creates new form DayTotal
     */
    public DayTotal() {
        initComponents();
        loadDriverList();
        loadJourneyList();
                
        DefaultTableModel summaryTable = (DefaultTableModel)totalForTheDaySummary.getModel();
        DefaultTableModel detailTable = (DefaultTableModel)totalForTheDayDetails.getModel();
        
        double totalForTheDay = 0.0;
        int numberOfJourneys = JourneyList.size();
        for(int i = 0; i < JourneyList.size(); i++) {
            totalForTheDay += JourneyList.get(i).getFare();
        }
        double expectedPercentage = (totalForTheDay * 20) / 100;

        summaryTable.addRow(new Object[]{"Total for the day", totalForTheDay});
        summaryTable.addRow(new Object[]{"Total jobs of the day", numberOfJourneys});
        summaryTable.addRow(new Object[]{"Expected % of the day", expectedPercentage});
        
        String[] detailTableHeaders = {"Driver", "Takings", "%", "Jobs done"};
        detailTable.setColumnIdentifiers( detailTableHeaders );
        
        for(int i = 0; i< DriverList.size(); i++){            
            final int driverId = DriverList.get(i).getId();
            double driverEarnings = 0.0;
            int driverJobsCount = 0;
            for(int j=0; j<JourneyList.size(); j++){
                if(driverId == JourneyList.get(j).getDriverId()){
                    driverEarnings += JourneyList.get(j).getFare();
                    driverJobsCount++;
                }
            }
            double driverPercentage = (driverEarnings * 20) / 100;
            detailTable.addRow(new Object[] {driverId , driverEarnings, driverPercentage, driverJobsCount});
        }    
    }
    
    
    // Loads driver list from database
    private void loadDriverList() {
        DriverList.clear(); // emptying the list
        
        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            ResultSet rows = dbManager.executeQuery(conn, "Select * from Drivers");
            int rowCount = 0;
            while (rows.next()) {
                int ID = Integer.parseInt(rows.getString("ID"));
                String firstName = rows.getString("FIRSTNAME");
                String lastName = rows.getString("LASTNAME");
                String SSN = rows.getString("SSN");
                
                Driver driver = new Driver(ID , firstName, lastName, SSN);
                DriverList.add(driver); // Adding the driver object we got from db to driverList 
                rowCount++;
            }
            conn.close();
        } catch(SQLNonTransientConnectionException ex) { // Catching DB connection error
            JOptionPane.showMessageDialog(this, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading drivers from database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    
// Loads journey list from database
    private void loadJourneyList() {
        JourneyList.clear();

        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            ResultSet rows = dbManager.executeQuery(conn, "Select * from JOURNEYS");
            int rowCount = 0;
            while (rows.next()) {
    
                int ID = Integer.parseInt(rows.getString("ID"));
                int driverID = Integer.parseInt(rows.getString("DRIVERID"));
                String journeyStartTime = rows.getString("JOURNEYSTARTTIME");
                String pickupLocation = rows.getString("PICKUPLOCATION");
                String destination = rows.getString("DESTINATION");
                String passengerName = rows.getString("PASSENGERNAME");
                Double fare = Double.parseDouble(rows.getString("FARE"));
                String account = rows.getString("ACCOUNT");
                String telephone = rows.getString("TELEPHONE");
                
                Journey journey = new Journey(ID, driverID, journeyStartTime, pickupLocation, destination,
                                                passengerName, fare, account, telephone);
                JourneyList.add(journey); // Adding the journey object we got from db to journeyList
                rowCount++;
            }
            if(rowCount == 0){
                JOptionPane.showMessageDialog(this, "No journey recorded yet! Please add a journey first.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            conn.close();
            
        } catch(SQLNonTransientConnectionException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading journeys from database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        totalForTheDaySummary = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        totalForTheDayDetails = new javax.swing.JTable();

        setBackground(new java.awt.Color(122, 72, 221));
        setPreferredSize(new java.awt.Dimension(550, 430));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 100));

        totalForTheDaySummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(totalForTheDaySummary);

        totalForTheDayDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Driver", "Takings", "%", "Jobs done"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        totalForTheDayDetails.setPreferredSize(new java.awt.Dimension(150, 200));
        jScrollPane2.setViewportView(totalForTheDayDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable totalForTheDayDetails;
    private javax.swing.JTable totalForTheDaySummary;
    // End of variables declaration//GEN-END:variables
}
