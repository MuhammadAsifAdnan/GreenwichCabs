/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.awt.Cursor;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class JourneyForm extends javax.swing.JPanel {

    ArrayList<Driver> driverList = new ArrayList<>(); // storing driver list from database
    ArrayList<Journey> previousJourneys = new ArrayList<>(); // storing journey list from database
    Journey existingJourney; // If this object is initialized, we are editing an existing journey,
                             // otherwise creating a new journey.
    /**
     * Creates new form RecordJourney
     */
    public JourneyForm() {
        initComponents();
        loadDriverList();
        selectJourneyComboBox.setVisible(false);
        labelForSelectJourney.setVisible(false);
    }
    
    // Loads driver list from database
    private void loadDriverList() {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            ResultSet rows = dbManager.executeQuery(conn, "Select * from Drivers");
            while (rows.next()) {
                Driver driver = new Driver(Integer.parseInt(rows.getString("ID")), rows.getString("FIRSTNAME"), rows.getString("LASTNAME"), rows.getString("SSN"));
                driverList.add(driver);
                selectDriverComboBox.addItem(driver.toString());
            }
            conn.close();
        } catch(SQLNonTransientConnectionException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to database!", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading drivers from database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    // Loads journey list from database
    private void loadJourneyList() {
        previousJourneys.clear();
        selectJourneyComboBox.removeAllItems();

        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            ResultSet rows = dbManager.executeQuery(conn, "Select * from JOURNEYS");
            int rowCount = 0;
            while (rows.next()) {
                rowCount++;
                Journey journey = new Journey(
                        Integer.parseInt(rows.getString("ID")),
                        Integer.parseInt(rows.getString("DRIVERID")), 
                        rows.getString("JOURNEYSTARTTIME"),
                        rows.getString("PICKUPLOCATION"),
                        rows.getString("DESTINATION"),
                        rows.getString("PASSENGERNAME"),
                        Double.parseDouble(rows.getString("FARE")),
                        rows.getString("ACCOUNT"),
                        rows.getString("TELEPHONE"));
                previousJourneys.add(journey);
                selectJourneyComboBox.addItem(journey.toString());
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
    
    public void editMode() {
        loadJourneyList();
        labelForSelectJourney.setVisible(true);
        selectJourneyComboBox.setVisible(true);
        resetJourneyFormButton.setEnabled(false);
        resetJourneyFormButton.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        saveJourneyFormButton.setText("Update");
    }
    
    private void initializeForm() {
        int driverComboBoxIndex = -1;
        for(Driver driver: driverList){
            if(driver.getId() == existingJourney.getDriverId()){
                driverComboBoxIndex = driverList.indexOf(driver);
            }
        };
        selectDriverComboBox.setSelectedIndex(driverComboBoxIndex);
        journeyTimeTextField.setText(existingJourney.getTimeOfJourney());
        pickupLocationTextField.setText(existingJourney.getPickupLocation());
        destinationTextField.setText(existingJourney.getDestination());
        passengerNameTextField.setText(existingJourney.getPassengerName());
        fareTextField.setText(existingJourney.getFare().toString());
        accountTextField.setText(existingJourney.getAccount());
        telephoneTextField.setText(existingJourney.getTelephone());
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelForPickupLocation = new javax.swing.JLabel();
        labelForSelectDriver = new javax.swing.JLabel();
        labelForDestination = new javax.swing.JLabel();
        labelForPassengerName = new javax.swing.JLabel();
        labelForFare = new javax.swing.JLabel();
        labelForAccount = new javax.swing.JLabel();
        labelForTelephone = new javax.swing.JLabel();
        labelForTime = new javax.swing.JLabel();
        selectDriverComboBox = new javax.swing.JComboBox<>();
        resetJourneyFormButton = new javax.swing.JButton();
        saveJourneyFormButton = new javax.swing.JButton();
        destinationTextField = new javax.swing.JTextField();
        passengerNameTextField = new javax.swing.JTextField();
        accountTextField = new javax.swing.JTextField();
        telephoneTextField = new javax.swing.JFormattedTextField();
        pickupLocationTextField = new javax.swing.JTextField();
        journeyTimeTextField = new javax.swing.JTextField();
        fareTextField = new javax.swing.JTextField();
        labelForSelectJourney = new javax.swing.JLabel();
        selectJourneyComboBox = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(122, 72, 221));
        setForeground(new java.awt.Color(64, 43, 100));
        setMaximumSize(new java.awt.Dimension(550, 500));
        setPreferredSize(new java.awt.Dimension(550, 500));

        labelForPickupLocation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForPickupLocation.setForeground(new java.awt.Color(255, 255, 255));
        labelForPickupLocation.setLabelFor(labelForPickupLocation);
        labelForPickupLocation.setText("Pickup location*");

        labelForSelectDriver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForSelectDriver.setForeground(new java.awt.Color(255, 255, 255));
        labelForSelectDriver.setLabelFor(selectDriverComboBox);
        labelForSelectDriver.setText("Driver*");
        labelForSelectDriver.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        labelForDestination.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForDestination.setForeground(new java.awt.Color(255, 255, 255));
        labelForDestination.setLabelFor(labelForDestination);
        labelForDestination.setText("Destination*");

        labelForPassengerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForPassengerName.setForeground(new java.awt.Color(255, 255, 255));
        labelForPassengerName.setLabelFor(labelForPassengerName);
        labelForPassengerName.setText("Passenger Name");

        labelForFare.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForFare.setForeground(new java.awt.Color(255, 255, 255));
        labelForFare.setLabelFor(labelForFare);
        labelForFare.setText("Fare");

        labelForAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForAccount.setForeground(new java.awt.Color(255, 255, 255));
        labelForAccount.setLabelFor(labelForAccount);
        labelForAccount.setText("Account");

        labelForTelephone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForTelephone.setForeground(new java.awt.Color(255, 255, 255));
        labelForTelephone.setLabelFor(labelForTelephone);
        labelForTelephone.setText("Telephone");

        labelForTime.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForTime.setForeground(new java.awt.Color(255, 255, 255));
        labelForTime.setLabelFor(labelForTime);
        labelForTime.setText("Time*");

        selectDriverComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectDriverComboBox.setBorder(null);

        resetJourneyFormButton.setBackground(new java.awt.Color(64, 43, 100));
        resetJourneyFormButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        resetJourneyFormButton.setForeground(new java.awt.Color(255, 255, 255));
        resetJourneyFormButton.setText("Reset");
        resetJourneyFormButton.setBorder(null);
        resetJourneyFormButton.setBorderPainted(false);
        resetJourneyFormButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetJourneyFormButtonMouseClicked(evt);
            }
        });

        saveJourneyFormButton.setBackground(new java.awt.Color(64, 43, 100));
        saveJourneyFormButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveJourneyFormButton.setForeground(new java.awt.Color(255, 255, 255));
        saveJourneyFormButton.setText("Save");
        saveJourneyFormButton.setBorder(null);
        saveJourneyFormButton.setBorderPainted(false);
        saveJourneyFormButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveJourneyFormButtonMouseClicked(evt);
            }
        });

        destinationTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        destinationTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        passengerNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passengerNameTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        accountTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        accountTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        telephoneTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));
        telephoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pickupLocationTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pickupLocationTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        journeyTimeTextField.setColumns(5);
        journeyTimeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        journeyTimeTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        fareTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fareTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10)));

        labelForSelectJourney.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelForSelectJourney.setForeground(new java.awt.Color(255, 255, 255));
        labelForSelectJourney.setLabelFor(selectDriverComboBox);
        labelForSelectJourney.setText("Select Journey");
        labelForSelectJourney.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        selectJourneyComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectJourneyComboBox.setBorder(null);
        selectJourneyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJourneyComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelForSelectJourney, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(selectJourneyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelForTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(resetJourneyFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveJourneyFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelForSelectDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForPickupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForPassengerName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForFare, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelForAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectDriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pickupLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(journeyTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passengerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {labelForAccount, labelForDestination, labelForFare, labelForPassengerName, labelForPickupLocation, labelForSelectDriver, labelForTelephone, labelForTime});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {accountTextField, destinationTextField, passengerNameTextField, pickupLocationTextField, selectDriverComboBox, telephoneTextField});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {resetJourneyFormButton, saveJourneyFormButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForSelectJourney, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectJourneyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForSelectDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectDriverComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(journeyTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForPickupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickupLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destinationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForPassengerName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passengerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForFare, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelForTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telephoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetJourneyFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveJourneyFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {labelForAccount, labelForDestination, labelForFare, labelForPassengerName, labelForPickupLocation, labelForSelectDriver, labelForTelephone, labelForTime});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {accountTextField, destinationTextField, passengerNameTextField, pickupLocationTextField, selectDriverComboBox, telephoneTextField});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {resetJourneyFormButton, saveJourneyFormButton});

    }// </editor-fold>//GEN-END:initComponents

    
    // This method performs save or edit operation depending on which tab user is in
    private void saveJourneyFormButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveJourneyFormButtonMouseClicked
        int driverComboBoxSelectedItemIndex = selectDriverComboBox.getSelectedIndex(); // Getting the selected driver index of combo box
        if(driverComboBoxSelectedItemIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a driver!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int driverID = driverList.get(driverComboBoxSelectedItemIndex).getId(); // getting the driver from driverList and then its ID
        if(journeyTimeTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter journey time!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(pickupLocationTextField.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(this, "Please enter pickup location!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(destinationTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter destination!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String journeyStartTime = journeyTimeTextField.getText();
        String pickupLocation = pickupLocationTextField.getText();
        String destination = destinationTextField.getText();
        String passengerName = passengerNameTextField.getText();
        Double fare = 0.0;
        if(!fareTextField.getText().isEmpty()) {
            try{
                fare = Double.parseDouble(fareTextField.getText());
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Please provide a valid number in fare field.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        String account = accountTextField.getText();
        String telephone = telephoneTextField.getText();
                
        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            PreparedStatement pstmt;
            String operationName;
            if(existingJourney == null){ // new journey save mode. write insert sql statement
                pstmt = conn.prepareStatement("INSERT INTO JOURNEYS (DRIVERID,JOURNEYSTARTTIME,PICKUPLOCATION,DESTINATION,PASSENGERNAME,FARE,ACCOUNT,TELEPHONE) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                operationName = "Sav";
            }else { // journey edit mode. write update sql statement
                pstmt = conn.prepareStatement("UPDATE JOURNEYS SET DRIVERID=?,JOURNEYSTARTTIME=?,PICKUPLOCATION=?,DESTINATION=?,PASSENGERNAME=?,FARE=?,ACCOUNT=?,TELEPHONE=? WHERE ID=?");
                operationName = "Updat";
            }
            
            pstmt.setInt(1, driverID);
            pstmt.setString(2, journeyStartTime);
            pstmt.setString(3, pickupLocation);
            pstmt.setString(4, destination);
            pstmt.setString(5, passengerName);
            pstmt.setDouble(6, fare);
            pstmt.setString(7, account);
            pstmt.setString(8, telephone);
            
            if(existingJourney != null){ // again, if we are updating, we need to give the ID to which journey row we want to update in db
                pstmt.setInt(9, existingJourney.getID());
            }

            int i = pstmt.executeUpdate();
            // executeUpdate method executes insert, update, delete operation. if the return value is 0, the operation
            // failed. if greater than 0, it succeded
            if(i>0){
                JOptionPane.showMessageDialog(this, "Journey information " + operationName + "ed successfully");
            }else {
                JOptionPane.showMessageDialog(this, "Error  " + operationName + "ing. Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            if(existingJourney == null) { // reseting fields after saving
                resetFields();
            } else{
                loadJourneyList();
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error executing database query!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
                
    }//GEN-LAST:event_saveJourneyFormButtonMouseClicked

    private void resetJourneyFormButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetJourneyFormButtonMouseClicked
        if(!resetJourneyFormButton.isEnabled()){
            return;
        }
        resetFields();
    }//GEN-LAST:event_resetJourneyFormButtonMouseClicked

    // Event handler for any type of change in select journey combo box.. like load items, reload items, click
    // on item etc.
    private void selectJourneyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJourneyComboBoxActionPerformed
        // TODO add your handling code here:
        if(!evt.getActionCommand().equals("comboBoxChanged")){
            return;
        }
        int selectedJourneyInComboBoxIndex = selectJourneyComboBox.getSelectedIndex();
        if(selectedJourneyInComboBoxIndex != -1){ // Checking if there is any item selected
            this.existingJourney = previousJourneys.get(selectedJourneyInComboBoxIndex);
            initializeForm();
            this.repaint();
        }else {
            this.existingJourney = null;
        }
    }//GEN-LAST:event_selectJourneyComboBoxActionPerformed

     // Resets all the fields 
    private void resetFields(){
        if(selectDriverComboBox.getItemCount() > 0){
            selectDriverComboBox.setSelectedIndex(0);
        }
        journeyTimeTextField.setText("");
        pickupLocationTextField.setText("");
        destinationTextField.setText("");
        passengerNameTextField.setText("");
        fareTextField.setText("");
        accountTextField.setText("");
        telephoneTextField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountTextField;
    private javax.swing.JTextField destinationTextField;
    private javax.swing.JTextField fareTextField;
    private javax.swing.JTextField journeyTimeTextField;
    private javax.swing.JLabel labelForAccount;
    private javax.swing.JLabel labelForDestination;
    private javax.swing.JLabel labelForFare;
    private javax.swing.JLabel labelForPassengerName;
    private javax.swing.JLabel labelForPickupLocation;
    private javax.swing.JLabel labelForSelectDriver;
    private javax.swing.JLabel labelForSelectJourney;
    private javax.swing.JLabel labelForTelephone;
    private javax.swing.JLabel labelForTime;
    private javax.swing.JTextField passengerNameTextField;
    private javax.swing.JTextField pickupLocationTextField;
    private javax.swing.JButton resetJourneyFormButton;
    private javax.swing.JButton saveJourneyFormButton;
    private javax.swing.JComboBox<String> selectDriverComboBox;
    private javax.swing.JComboBox<String> selectJourneyComboBox;
    private javax.swing.JFormattedTextField telephoneTextField;
    // End of variables declaration//GEN-END:variables
}
