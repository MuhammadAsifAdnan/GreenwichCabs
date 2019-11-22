/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenwichcabs;

import java.awt.*; // color, layout etc
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*; // JFrame, JPanel, JLabel, JButtons etc

/**
 *
 * @author user
 */
public class MainFrame extends javax.swing.JFrame {
    
    /*** Variable declaration of custom panels to be displayed in ContentPane ****/
    JourneyForm createJourneyForm;
    JourneyForm editJourneyForm;
    DayTotal dayTotalPanel;
    DriverForm driverForm;
    GridBagLayout contentPaneLayout;
    
    ArrayList<Journey> previousJourneys = new ArrayList<>();;
    
    GridBagConstraints contentPaneLayoutConstraints = new GridBagConstraints();

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents(); // Generated code. Initializes the panels and components added via GUI design tab
        setupContentPanelComponents(); // Initializes custom panels (New journey, edit journey, Day total, driver panel forms
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        sidePane = new javax.swing.JPanel();
        newJourneyButton = new javax.swing.JPanel();
        newJourneyIcon = new javax.swing.JLabel();
        newJourneyLabel = new javax.swing.JLabel();
        addDriverButton = new javax.swing.JPanel();
        addDriverIcon = new javax.swing.JLabel();
        addDriverLabel = new javax.swing.JLabel();
        editJourneyButton = new javax.swing.JPanel();
        editJourneyIcon = new javax.swing.JLabel();
        editJourneyLabel = new javax.swing.JLabel();
        totalOfTheDayButton = new javax.swing.JPanel();
        totalOfTheDayIcon = new javax.swing.JLabel();
        totalOfTheDayLabel = new javax.swing.JLabel();
        appTitle = new javax.swing.JLabel();
        appTitleUnderline = new javax.swing.JSeparator();
        contentPane = new javax.swing.JPanel();
        contentPaneTitle = new javax.swing.JLabel();
        selectJourneyComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setMaximumSize(new java.awt.Dimension(800, 500));
        container.setMinimumSize(new java.awt.Dimension(800, 500));
        container.setPreferredSize(new java.awt.Dimension(800, 500));
        container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePane.setBackground(new java.awt.Color(54, 33, 89));
        sidePane.setMaximumSize(new java.awt.Dimension(200, 500));
        sidePane.setPreferredSize(new java.awt.Dimension(200, 500));
        sidePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newJourneyButton.setBackground(new java.awt.Color(64, 43, 100));

        newJourneyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_commute_white_18dp.png"))); // NOI18N

        newJourneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newJourneyLabel.setForeground(new java.awt.Color(255, 255, 255));
        newJourneyLabel.setText("New Journey");
        newJourneyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newJourneyLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout newJourneyButtonLayout = new javax.swing.GroupLayout(newJourneyButton);
        newJourneyButton.setLayout(newJourneyButtonLayout);
        newJourneyButtonLayout.setHorizontalGroup(
            newJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newJourneyButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(newJourneyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newJourneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        newJourneyButtonLayout.setVerticalGroup(
            newJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newJourneyButtonLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(newJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(newJourneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newJourneyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        sidePane.add(newJourneyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 250, 50));

        addDriverButton.setBackground(new java.awt.Color(64, 43, 100));

        addDriverIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_account_circle_white_18dp.png"))); // NOI18N

        addDriverLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addDriverLabel.setForeground(new java.awt.Color(255, 255, 255));
        addDriverLabel.setText("Add Driver");
        addDriverLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addDriverLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout addDriverButtonLayout = new javax.swing.GroupLayout(addDriverButton);
        addDriverButton.setLayout(addDriverButtonLayout);
        addDriverButtonLayout.setHorizontalGroup(
            addDriverButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addDriverButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(addDriverIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addDriverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        addDriverButtonLayout.setVerticalGroup(
            addDriverButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addDriverButtonLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(addDriverButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addDriverIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addDriverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidePane.add(addDriverButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 50));

        editJourneyButton.setBackground(new java.awt.Color(64, 43, 100));

        editJourneyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_edit_white_18dp.png"))); // NOI18N

        editJourneyLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editJourneyLabel.setForeground(new java.awt.Color(255, 255, 255));
        editJourneyLabel.setText("Edit Journey");
        editJourneyLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editJourneyLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout editJourneyButtonLayout = new javax.swing.GroupLayout(editJourneyButton);
        editJourneyButton.setLayout(editJourneyButtonLayout);
        editJourneyButtonLayout.setHorizontalGroup(
            editJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editJourneyButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(editJourneyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editJourneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        editJourneyButtonLayout.setVerticalGroup(
            editJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editJourneyButtonLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(editJourneyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(editJourneyIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editJourneyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidePane.add(editJourneyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 250, 50));

        totalOfTheDayButton.setBackground(new java.awt.Color(64, 43, 100));

        totalOfTheDayIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/outline_dashboard_white_18dp.png"))); // NOI18N

        totalOfTheDayLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalOfTheDayLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalOfTheDayLabel.setText("Total of The Day");
        totalOfTheDayLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                totalOfTheDayLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout totalOfTheDayButtonLayout = new javax.swing.GroupLayout(totalOfTheDayButton);
        totalOfTheDayButton.setLayout(totalOfTheDayButtonLayout);
        totalOfTheDayButtonLayout.setHorizontalGroup(
            totalOfTheDayButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalOfTheDayButtonLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(totalOfTheDayIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalOfTheDayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        totalOfTheDayButtonLayout.setVerticalGroup(
            totalOfTheDayButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalOfTheDayButtonLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(totalOfTheDayButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(totalOfTheDayIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalOfTheDayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        sidePane.add(totalOfTheDayButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 250, 50));

        appTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        appTitle.setForeground(new java.awt.Color(255, 255, 255));
        appTitle.setText("Greenwich Cabs");
        sidePane.add(appTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 45));
        sidePane.add(appTitleUnderline, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 10));

        container.add(sidePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, -1));

        contentPane.setBackground(new java.awt.Color(122, 72, 221));
        contentPane.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        contentPane.setMaximumSize(new java.awt.Dimension(600, 450));
        contentPane.setMinimumSize(new java.awt.Dimension(600, 450));
        contentPane.setPreferredSize(new java.awt.Dimension(600, 450));

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        container.add(contentPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 550, 430));

        contentPaneTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        contentPaneTitle.setForeground(new java.awt.Color(122, 72, 221));
        container.add(contentPaneTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 520, 30));

        selectJourneyComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        selectJourneyComboBox.setBorder(null);
        selectJourneyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectJourneyComboBoxActionPerformed(evt);
            }
        });
        container.add(selectJourneyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 520, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setupContentPanelComponents() {
        contentPaneLayoutConstraints.gridx = 0;
        contentPaneLayoutConstraints.gridy = 0;
        // creating custom panel objects
        createJourneyForm = new JourneyForm();
        editJourneyForm = new JourneyForm();
        dayTotalPanel = new DayTotal();
        driverForm = new DriverForm();
        contentPaneLayout = new GridBagLayout();
        
        // Setting up layout for contentPane.
        contentPane.setLayout(contentPaneLayout);
        
        
        // adding custom panels to contentPane
        contentPane.add(createJourneyForm, contentPaneLayoutConstraints);
        contentPane.add(editJourneyForm, contentPaneLayoutConstraints);
        contentPane.add(dayTotalPanel, contentPaneLayoutConstraints);
        contentPane.add(driverForm, contentPaneLayoutConstraints);
        
        // setting all the custom panels visibility to false. we will make them visible when user clicks respective button
        // on the sidePane
        createJourneyForm.setVisible(false);
        editJourneyForm.setVisible(false);
        dayTotalPanel.setVisible(false);
        driverForm.setVisible(false);
        selectJourneyComboBox.setVisible(false);
    }
    
    private void setActiveColor(JPanel jPanel) {
        jPanel.setBackground(new Color(85,65,111));
    }
    
    private void setDefaultColor(JPanel jPanel) {
        jPanel.setBackground(new Color(64,43,100));
    }
    
    private void addDriverLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDriverLabelMousePressed
        setActiveColor(addDriverButton);
        setDefaultColor(newJourneyButton);
        setDefaultColor(editJourneyButton);
        setDefaultColor(totalOfTheDayButton);
        
        contentPaneTitle.setText("Add new Driver");
        driverForm.setVisible(true);
        createJourneyForm.setVisible(false);
        editJourneyForm.setVisible(false);
        dayTotalPanel.setVisible(false);
        selectJourneyComboBox.setVisible(false);
        contentPane.repaint();
    }//GEN-LAST:event_addDriverLabelMousePressed

    private void totalOfTheDayLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalOfTheDayLabelMousePressed
        setActiveColor(totalOfTheDayButton);
        setDefaultColor(newJourneyButton);
        setDefaultColor(editJourneyButton);
        setDefaultColor(addDriverButton);
        
        contentPaneTitle.setText("Total of The Day");
        dayTotalPanel.setVisible(true);
        createJourneyForm.setVisible(false);
        editJourneyForm.setVisible(false);
        driverForm.setVisible(false);
        selectJourneyComboBox.setVisible(false);
        contentPane.repaint();
    }//GEN-LAST:event_totalOfTheDayLabelMousePressed

    private void editJourneyLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editJourneyLabelMousePressed
        setActiveColor(editJourneyButton);
        setDefaultColor(newJourneyButton);
        setDefaultColor(totalOfTheDayButton);
        setDefaultColor(addDriverButton);
        
        contentPaneTitle.setText("Select Journey to edit: ");
        
        loadJourneyList();
        dayTotalPanel.setVisible(false);
        createJourneyForm.setVisible(false);
        editJourneyForm.setVisible(true);
        driverForm.setVisible(false);
        selectJourneyComboBox.setVisible(true);
        
    }//GEN-LAST:event_editJourneyLabelMousePressed

    private void newJourneyLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newJourneyLabelMousePressed
        setActiveColor(newJourneyButton);
        setDefaultColor(editJourneyButton);
        setDefaultColor(totalOfTheDayButton);
        setDefaultColor(addDriverButton);
        
        contentPaneTitle.setText("Record new journey");
        createJourneyForm.setVisible(true);
        editJourneyForm.setVisible(false);
        dayTotalPanel.setVisible(false);
        driverForm.setVisible(false);
        selectJourneyComboBox.setVisible(false);
        contentPane.repaint();
    }//GEN-LAST:event_newJourneyLabelMousePressed

    private void selectJourneyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectJourneyComboBoxActionPerformed
        // TODO add your handling code here:
        if(!evt.getActionCommand().equals("comboBoxChanged")){
            return;
        }
        loadEditJourneyForm();
    }//GEN-LAST:event_selectJourneyComboBoxActionPerformed

    private void loadEditJourneyForm() {
        int selectedJourneyInComboBoxIndex = selectJourneyComboBox.getSelectedIndex();
        if(selectedJourneyInComboBoxIndex != -1){
            editJourneyForm.initializeEditMode(previousJourneys.get(selectedJourneyInComboBoxIndex));
            editJourneyForm.repaint();
            editJourneyForm.setVisible(true);
            contentPane.repaint();
        }
    }
    
    public void loadJourneyList() {
        previousJourneys.clear();
        selectJourneyComboBox.removeAllItems();

        DatabaseManager dbManager = new DatabaseManager();
        try {
            Connection conn = dbManager.getConnection();
            ResultSet rows = dbManager.executeQuery(conn, "Select * from JOURNEYS");
            int rowCount = 0;
            while (rows.next()) {
                rowCount++;
                Journey journey = new Journey(Integer.parseInt(rows.getString("DRIVERID")), 
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
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading journeys from database!", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addDriverButton;
    private javax.swing.JLabel addDriverIcon;
    private javax.swing.JLabel addDriverLabel;
    private javax.swing.JLabel appTitle;
    private javax.swing.JSeparator appTitleUnderline;
    private javax.swing.JPanel container;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel contentPaneTitle;
    private javax.swing.JPanel editJourneyButton;
    private javax.swing.JLabel editJourneyIcon;
    private javax.swing.JLabel editJourneyLabel;
    private javax.swing.JPanel newJourneyButton;
    private javax.swing.JLabel newJourneyIcon;
    private javax.swing.JLabel newJourneyLabel;
    private javax.swing.JComboBox<String> selectJourneyComboBox;
    private javax.swing.JPanel sidePane;
    private javax.swing.JPanel totalOfTheDayButton;
    private javax.swing.JLabel totalOfTheDayIcon;
    private javax.swing.JLabel totalOfTheDayLabel;
    // End of variables declaration//GEN-END:variables

}
