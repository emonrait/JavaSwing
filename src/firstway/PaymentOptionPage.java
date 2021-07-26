/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstway;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reaz
 */
public class PaymentOptionPage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    public PaymentOptionPage() {
        initComponents();

        this.getContentPane().setBackground(new java.awt.Color(244, 244, 244));
    }

    public PaymentOptionPage(PreparedStatement pst, Double shipValue, String mony) {
        initComponents();
        domesticPst = pst;
        txtTotalBill.setText(shipValue.toString());
        txtMony.setText(mony);
    }
    PreparedStatement domesticPst;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        HeaderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FooterPanel = new javax.swing.JPanel();
        Copyright = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        loadingPage = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        processButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMony = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTotalBill = new javax.swing.JLabel();
        radioCredit = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        radioCash = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderPanel.setBackground(new java.awt.Color(102, 102, 102));
        HeaderPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        HeaderPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderPanelMouseDragged(evt);
            }
        });
        HeaderPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderPanelMousePressed(evt);
            }
        });
        HeaderPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/closes.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        HeaderPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minimizes.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        HeaderPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fastway_logo_100x30_gray.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(43, 30));
        HeaderPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        getContentPane().add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        FooterPanel.setBackground(new java.awt.Color(102, 102, 102));
        FooterPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        Copyright.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Copyright.setForeground(new java.awt.Color(255, 255, 255));
        Copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Copyright.setText("Copyright: Raihan Mahamud 2018  |  All Rights Reserved");

        javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
        FooterPanel.setLayout(FooterPanelLayout);
        FooterPanelLayout.setHorizontalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterPanelLayout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(Copyright, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        FooterPanelLayout.setVerticalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Copyright, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        getContentPane().add(FooterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 600, 20));

        bodyPanel.setBackground(new java.awt.Color(244, 244, 244));
        bodyPanel.setLayout(new java.awt.CardLayout());

        loadingPage.setBackground(new java.awt.Color(244, 244, 244));
        loadingPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        loadingPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Expressed Global Parcel Service");
        loadingPage.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 272, 22));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fastway_logo_220x60.png"))); // NOI18N
        loadingPage.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        processButton.setBackground(new java.awt.Color(255, 153, 0));
        processButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                processButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                processButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                processButtonMouseExited(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Process");

        javax.swing.GroupLayout processButtonLayout = new javax.swing.GroupLayout(processButton);
        processButton.setLayout(processButtonLayout);
        processButtonLayout.setHorizontalGroup(
            processButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(processButtonLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        processButtonLayout.setVerticalGroup(
            processButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        loadingPage.add(processButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        txtMony.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMony.setForeground(new java.awt.Color(120, 60, 60));
        txtMony.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtMony.setText("BDT");
        loadingPage.add(txtMony, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 40, 40));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Choose Payment Option");
        loadingPage.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 200, 30));

        txtTotalBill.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTotalBill.setForeground(new java.awt.Color(120, 60, 60));
        txtTotalBill.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTotalBill.setText("1500.0");
        loadingPage.add(txtTotalBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 80, 40));

        radioCredit.setBackground(new java.awt.Color(244, 244, 244));
        buttonGroup1.add(radioCredit);
        radioCredit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioCredit.setForeground(new java.awt.Color(120, 60, 60));
        radioCredit.setText(" Credit / Debit Card");
        radioCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCreditActionPerformed(evt);
            }
        });
        loadingPage.add(radioCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 170, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(120, 60, 60));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Total Bill:");
        loadingPage.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 90, 40));

        radioCash.setBackground(new java.awt.Color(244, 244, 244));
        buttonGroup1.add(radioCash);
        radioCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        radioCash.setForeground(new java.awt.Color(120, 60, 60));
        radioCash.setSelected(true);
        radioCash.setText(" Cash");
        radioCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCashActionPerformed(evt);
            }
        });
        loadingPage.add(radioCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 170, 40));

        bodyPanel.add(loadingPage, "card2");

        getContentPane().add(bodyPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int mousepX;
    int mousepY;
    private void HeaderPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPanelMouseDragged
        // TODO add your handling code here:
        int kordinatX = evt.getXOnScreen();
        int kordinatY = evt.getYOnScreen();
        this.setLocation(kordinatX - mousepX, kordinatY - mousepY);
    }//GEN-LAST:event_HeaderPanelMouseDragged

    private void HeaderPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderPanelMousePressed
        // TODO add your handling code here:
        mousepX = evt.getX();
        mousepY = evt.getY();
    }//GEN-LAST:event_HeaderPanelMousePressed

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setOpaque(true);
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(Color.red);
        jLabel1.setOpaque(true);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        PaymentOptionPage.this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jLabel2.setBackground(new java.awt.Color(144, 147, 255));
        jLabel2.setOpaque(true);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setOpaque(true);
    }//GEN-LAST:event_jLabel2MouseExited

    private void processButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processButtonMouseClicked
        try {
            // TODO add your handling code here:
            if (radioCredit.isSelected()) {
                domesticPst.setString(20, "Credit Card");
            }
            if (radioCash.isSelected()) {
                domesticPst.setString(20, "Cash");
            }

            int i = domesticPst.executeUpdate();
            if (i > 0) {
                PaymentOptionPage.this.dispose();
                JOptionPane.showMessageDialog(null, "Your Payment have Processed");
                JOptionPane.showMessageDialog(null, "Order Completed");
            }

            //Bill Print:
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String bill = "SELECT * FROM international_ship ORDER BY track_id DESC LIMIT 1";
            String bill2 = "SELECT * FROM domestic_ship ORDER BY track_id DESC LIMIT 1";
            
            if (txtMony.getText()=="USD") {
                PreparedStatement billquery = c.prepareStatement(bill);
                ResultSet rs = billquery.executeQuery();
                while (rs.next()) {
                    String from = rs.getString(3) + ", " + rs.getString(4);
                    String to = rs.getString(6) + ", " + rs.getString(7);
                    Object[] billstat = {rs.getInt(1), rs.getString(2), from, to, rs.getString(13), rs.getString(15), rs.getDouble(16), rs.getString(17), rs.getString(21)};
                    ShipDetailsPrint sdp = new ShipDetailsPrint(billstat);
                    sdp.setVisible(true);
                }
            }
            if (txtMony.getText()=="BDT") {
                PreparedStatement billquery2 = c.prepareStatement(bill);
                ResultSet rs2 = billquery2.executeQuery();
                while (rs2.next()) {
                    String from = rs2.getString(3) + ", " + rs2.getString(4);
                    String to = rs2.getString(6) + ", " + rs2.getString(7);
                    Object[] billstat2 = {rs2.getInt(1), rs2.getString(2), from, to, rs2.getString(13), rs2.getString(15), rs2.getDouble(16), rs2.getString(17), rs2.getString(21)};
                    ShipDetailsPrint sdp = new ShipDetailsPrint(billstat2);
                    sdp.setVisible(true);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_processButtonMouseClicked

    private void processButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processButtonMouseEntered
        // TODO add your handling code here:
        processButton.setBackground(new java.awt.Color(120, 60, 60));
    }//GEN-LAST:event_processButtonMouseEntered

    private void processButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_processButtonMouseExited
        // TODO add your handling code here:
        processButton.setBackground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_processButtonMouseExited

    private void radioCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCashActionPerformed

    private void radioCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCreditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioCreditActionPerformed

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
            java.util.logging.Logger.getLogger(PaymentOptionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentOptionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentOptionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentOptionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentOptionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Copyright;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel loadingPage;
    private javax.swing.JPanel processButton;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioCredit;
    private javax.swing.JLabel txtMony;
    private javax.swing.JLabel txtTotalBill;
    // End of variables declaration//GEN-END:variables
}
