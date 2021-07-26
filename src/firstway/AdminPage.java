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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Reaz
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    public AdminPage() {
        initComponents();
        
        this.getContentPane().setBackground(new java.awt.Color(244, 244, 244));
        BalanceButton.setBackground(new java.awt.Color(120, 60, 60));
        InternationalButton02.setBackground(new java.awt.Color(120, 60, 60));
        FooterPanel.setVisible(true);
        BalancePanel.setVisible(true);
        CostPanel.setVisible(false);
        domstat();
        
        internationalRevenue();
        domesticRevenue();
    }
    
//    public EmployeePage(String adminName) {
//        initComponents();
//        txtAdminName.
//    }
    
      public AdminPage(String adminName) {
        initComponents();
        txtEmpName.setText(adminName);
        
        internationalRevenue();
        domesticRevenue();
    }
    
    
    //Methods---
    
    
    //International Revenue, Cost :
    public void internationalRevenue(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            
            Double retun;
            Double cst;
            Double trevenu;
            String getData="SELECT SUM(ship_value), SUM(cost) FROM fastway.international_ship";
            PreparedStatement pst=c.prepareStatement(getData);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                retun=rs.getDouble(1);
                cst=rs.getDouble(2);
                trevenu=retun-cst;
                txtIntReturn.setText(retun.toString());
                txtIntCost.setText(cst.toString());
                txtIntRevenue.setText(trevenu.toString());
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    //Domestic Total Return, Cost and Revenue:
    public void domesticRevenue(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            
            Double retun;
            Double cst;
            Double trevenu;
            String getData="SELECT SUM(ship_value), SUM(cost) FROM fastway.domestic_ship";
            PreparedStatement pst=c.prepareStatement(getData);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                retun=rs.getDouble(1);
                cst=rs.getDouble(2);
                trevenu=retun-cst;
                txtDomReturn.setText(retun.toString());
                txtDomCost.setText(cst.toString());
                txtDomRevenue.setText(trevenu.toString());
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    //Cost show International
        public void internationalCost(){
        try {
            DefaultTableModel dtm=(DefaultTableModel)intCostTable.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");

            String getData="SELECT track_id, type, cost FROM fastway.international_ship";
            PreparedStatement pst=c.prepareStatement(getData);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String cst=String.valueOf(rs.getDouble(3))+" USD";
                Object [] costData={rs.getInt(1), rs.getString(2), cst};
                dtm.addRow(costData);
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
        
        //Cost show Domestic
        public void domesticCost(){
        try {
            DefaultTableModel dtm=(DefaultTableModel)domCostTable.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");

            String getData="SELECT track_id, type, cost FROM fastway.domestic_ship";
            PreparedStatement pst=c.prepareStatement(getData);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                String cst=String.valueOf(rs.getDouble(3))+" BDT";
                Object [] costData={rs.getInt(1), rs.getString(2), cst};
                dtm.addRow(costData);
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
        
        
    //International status:
    public void intstat() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) intStatusTable.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.international_ship";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String cst=String.valueOf(rs.getDouble(16))+" USD";
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), cst, rs.getString(20), rs.getString(17), rs.getString(22)};
                dtm.addRow(data);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //domestic status:
    public void domstat() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) domStatusTable.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.domestic_ship";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String cst=String.valueOf(rs.getDouble(16))+" BDT";
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), cst, rs.getString(20), rs.getString(17), rs.getString(22)};
                dtm.addRow(data);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    //getName From Login Page;
    
    
    
    //sysdate:
    Thread t=new Thread(new Runnable(){
        @Override
        public void run(){
            while(true){
//            shipDate.setDate(new java.util.Date());
            }
        }
    });
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        HeaderPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        FooterPanel = new javax.swing.JPanel();
        Copyright = new javax.swing.JLabel();
        LeftSidePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtEmpName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        BodyBgPanel = new javax.swing.JPanel();
        RevenueCostPanel = new javax.swing.JPanel();
        BalanceButton = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        CostButton = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        BalancePanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        from3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        txtDomReturn = new javax.swing.JTextField();
        txtDomCost = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        comboDomRevenue = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        txtDomRevenue = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        from4 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboIntRevenue = new javax.swing.JComboBox<>();
        jLabel91 = new javax.swing.JLabel();
        txtIntReturn = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtIntCost = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        txtIntRevenue = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        CostPanel = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        txtShipValue = new javax.swing.JLabel();
        txtTK = new javax.swing.JLabel();
        from9 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        intCostTable = new javax.swing.JTable();
        from10 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        domCostTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        StatusPanel = new javax.swing.JPanel();
        InternationalButton02 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        DomesticButton02 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        ExportButton02 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        ImportButton02 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        InternationalStatus = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        intStatusTable = new javax.swing.JTable();
        DomesticStatus = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        domStatusTable = new javax.swing.JTable();
        ExportStatus = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        domesticStat1 = new javax.swing.JTable();
        ImportStatus = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        domesticStat2 = new javax.swing.JTable();
        TrackingPanel = new javax.swing.JPanel();
        DomesticButton03 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        InternationalButton03 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        ExportButton03 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        ImportButton03 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        InterTrack = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        DomesticTrack = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        ExportTrack = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jButton18 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        ImportTrack = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jButton20 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        EmployeeMemberPanel = new javax.swing.JPanel();
        AddEmployeeButton = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        EmployeeInfoButton = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        AddMemberButton = new javax.swing.JPanel();
        jLabel216 = new javax.swing.JLabel();
        MemberInfoButton = new javax.swing.JPanel();
        jLabel217 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        AddEmployeePanel = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jTextField33 = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField61 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        EmployeeInfoPanel = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel198 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jLabel195 = new javax.swing.JLabel();
        jTextField41 = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        jTextField42 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        AddMemberPanel = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jTextField45 = new javax.swing.JTextField();
        jLabel220 = new javax.swing.JLabel();
        jTextField46 = new javax.swing.JTextField();
        jLabel221 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jLabel222 = new javax.swing.JLabel();
        jTextField48 = new javax.swing.JTextField();
        jButton32 = new javax.swing.JButton();
        jTextField49 = new javax.swing.JTextField();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jTextField51 = new javax.swing.JTextField();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        MemberInfoPanel = new javax.swing.JPanel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel230 = new javax.swing.JLabel();
        jTextField54 = new javax.swing.JTextField();
        jLabel231 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jLabel233 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jButton33 = new javax.swing.JButton();
        jLabel234 = new javax.swing.JLabel();
        jTextField57 = new javax.swing.JTextField();
        jLabel235 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jLabel236 = new javax.swing.JLabel();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox<>();
        RatePanel = new javax.swing.JPanel();
        DomesticButton04 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        InternationalButton04 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        ExportButton04 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        ImportButton04 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        InternationalRate = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        DomesticRate = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        ExportRate = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jTextField13 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        ImportRate = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jTextField15 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        SetingPanel = new javax.swing.JPanel();
        ChangePassButton = new javax.swing.JPanel();
        jLabel161 = new javax.swing.JLabel();
        ProfileButton = new javax.swing.JPanel();
        jLabel160 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        ChangePassPanel = new javax.swing.JPanel();
        jLabel162 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        ProfilePanel = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jTextField16 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HeaderPanel.setBackground(new java.awt.Color(102, 102, 102));
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
        HeaderPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 30, 30));

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
        HeaderPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 30, 30));

        jLabel4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/maximiz.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });
        HeaderPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 30, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fastway_logo_100x30_gray.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(43, 30));
        HeaderPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        getContentPane().add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        FooterPanel.setBackground(new java.awt.Color(102, 102, 102));

        Copyright.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Copyright.setForeground(new java.awt.Color(255, 255, 255));
        Copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Copyright.setText("Copyright: Raihan Mahamud 2018  |  All Rights Reserved");

        javax.swing.GroupLayout FooterPanelLayout = new javax.swing.GroupLayout(FooterPanel);
        FooterPanel.setLayout(FooterPanelLayout);
        FooterPanelLayout.setHorizontalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FooterPanelLayout.createSequentialGroup()
                .addContainerGap(348, Short.MAX_VALUE)
                .addComponent(Copyright, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(347, 347, 347))
        );
        FooterPanelLayout.setVerticalGroup(
            FooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Copyright, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
        );

        getContentPane().add(FooterPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1000, 20));

        LeftSidePanel.setBackground(new java.awt.Color(48, 24, 24));
        LeftSidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(64, 32, 32));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel7MouseReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Logout");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 220, 50));

        txtEmpName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmpName.setForeground(new java.awt.Color(255, 255, 255));
        txtEmpName.setText("Raihan Mahamud");
        LeftSidePanel.add(txtEmpName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, 150, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emp_adm_name (2).png"))); // NOI18N
        LeftSidePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 30, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Admin");
        LeftSidePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 150, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText(" @");
        LeftSidePanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 30, 30));

        jPanel12.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Setting");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings (2).png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 220, 50));

        jPanel13.setBackground(new java.awt.Color(90, 45, 45));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel13MouseEntered(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Revenue & Cost");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cost_revenue.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 50));

        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Shiping Status");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/statuses.png"))); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 220, 50));

        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Tracking");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tracking.png"))); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 50));

        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Employee & Member");

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/member.png"))); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 220, 50));

        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Rate");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rate.png"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        LeftSidePanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 220, 50));

        getContentPane().add(LeftSidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 220, 560));

        BodyBgPanel.setBackground(new java.awt.Color(255, 255, 255));
        BodyBgPanel.setLayout(new java.awt.CardLayout());

        RevenueCostPanel.setBackground(new java.awt.Color(244, 244, 244));
        RevenueCostPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BalanceButton.setBackground(new java.awt.Color(120, 60, 60));
        BalanceButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BalanceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BalanceButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BalanceButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BalanceButtonMouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Balance");

        javax.swing.GroupLayout BalanceButtonLayout = new javax.swing.GroupLayout(BalanceButton);
        BalanceButton.setLayout(BalanceButtonLayout);
        BalanceButtonLayout.setHorizontalGroup(
            BalanceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BalanceButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        BalanceButtonLayout.setVerticalGroup(
            BalanceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RevenueCostPanel.add(BalanceButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        CostButton.setBackground(new java.awt.Color(255, 153, 0));
        CostButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CostButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CostButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CostButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CostButtonMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cost");

        javax.swing.GroupLayout CostButtonLayout = new javax.swing.GroupLayout(CostButton);
        CostButton.setLayout(CostButtonLayout);
        CostButtonLayout.setHorizontalGroup(
            CostButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CostButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        CostButtonLayout.setVerticalGroup(
            CostButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RevenueCostPanel.add(CostButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        jPanel19.setBackground(new java.awt.Color(244, 244, 244));
        jPanel19.setLayout(new java.awt.CardLayout());

        BalancePanel.setBackground(new java.awt.Color(244, 244, 244));
        BalancePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Balance & Revenue");
        BalancePanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        from3.setBackground(new java.awt.Color(244, 244, 244));
        from3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        from3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("Domestic (BDT)");
        from3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 218, -1));

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Total Return");
        from3.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 31));

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setText("Cost");
        from3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 144, 100, 30));

        txtDomReturn.setEditable(false);
        txtDomReturn.setBackground(new java.awt.Color(236, 236, 236));
        txtDomReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDomReturn.setForeground(new java.awt.Color(51, 51, 51));
        txtDomReturn.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDomReturn.setBorder(null);
        from3.add(txtDomReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 31));

        txtDomCost.setEditable(false);
        txtDomCost.setBackground(new java.awt.Color(236, 236, 236));
        txtDomCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDomCost.setForeground(new java.awt.Color(51, 51, 51));
        txtDomCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDomCost.setBorder(null);
        from3.add(txtDomCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 141, 180, 33));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Search By Date");
        from3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 54, -1, 20));

        comboDomRevenue.setBackground(new java.awt.Color(244, 244, 244));
        comboDomRevenue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboDomRevenue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Today", "This Week", "This Month", "This Year", "Last Year" }));
        comboDomRevenue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDomRevenueItemStateChanged(evt);
            }
        });
        from3.add(comboDomRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 54, 80, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(51, 51, 51));
        jLabel87.setText("Total Revenue");
        from3.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 185, 110, 30));

        txtDomRevenue.setBackground(new java.awt.Color(236, 236, 236));
        txtDomRevenue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDomRevenue.setForeground(new java.awt.Color(51, 51, 51));
        txtDomRevenue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        from3.add(txtDomRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 185, 110, 30));

        jLabel88.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(51, 51, 51));
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("BDT");
        from3.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 185, 40, 30));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(51, 51, 51));
        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel89.setText("BDT");
        from3.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 40, 30));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(51, 51, 51));
        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel90.setText("BDT");
        from3.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 144, 40, 30));

        BalancePanel.add(from3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 360, 240));

        from4.setBackground(new java.awt.Color(244, 244, 244));
        from4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));
        from4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setText("International & Export & Import (USD)");
        from4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 218, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Search By Date");
        from4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 54, -1, 20));

        comboIntRevenue.setBackground(new java.awt.Color(244, 244, 244));
        comboIntRevenue.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboIntRevenue.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Today", "This Week", "This Month", "This Year", "Last Year" }));
        comboIntRevenue.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboIntRevenueItemStateChanged(evt);
            }
        });
        from4.add(comboIntRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 54, 80, -1));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(51, 51, 51));
        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel91.setText("USD");
        from4.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 40, 30));

        txtIntReturn.setEditable(false);
        txtIntReturn.setBackground(new java.awt.Color(236, 236, 236));
        txtIntReturn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIntReturn.setForeground(new java.awt.Color(51, 51, 51));
        txtIntReturn.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIntReturn.setBorder(null);
        from4.add(txtIntReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 31));

        jLabel48.setBackground(new java.awt.Color(204, 204, 204));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("Total Return");
        from4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 31));

        jLabel53.setBackground(new java.awt.Color(204, 204, 204));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Cost");
        from4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 144, 100, 30));

        txtIntCost.setEditable(false);
        txtIntCost.setBackground(new java.awt.Color(236, 236, 236));
        txtIntCost.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtIntCost.setForeground(new java.awt.Color(51, 51, 51));
        txtIntCost.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIntCost.setBorder(null);
        from4.add(txtIntCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 141, 180, 33));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(51, 51, 51));
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel93.setText("USD");
        from4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 144, 40, 30));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel96.setText("USD");
        from4.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 185, 40, 30));

        txtIntRevenue.setBackground(new java.awt.Color(236, 240, 236));
        txtIntRevenue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIntRevenue.setForeground(new java.awt.Color(51, 51, 51));
        txtIntRevenue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        from4.add(txtIntRevenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 185, 110, 30));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 51, 51));
        jLabel103.setText("Total Revenue");
        from4.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 185, 110, 30));

        BalancePanel.add(from4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 240));

        jPanel19.add(BalancePanel, "card2");

        CostPanel.setBackground(new java.awt.Color(244, 244, 244));
        CostPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Cost Status");
        CostPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        txtShipValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtShipValue.setForeground(new java.awt.Color(51, 51, 51));
        txtShipValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CostPanel.add(txtShipValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 30));

        txtTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTK.setForeground(new java.awt.Color(51, 51, 51));
        txtTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CostPanel.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 30));

        from9.setBackground(new java.awt.Color(244, 244, 244));
        from9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(51, 51, 51));
        jLabel39.setText("International & Export & Import (USD)");

        intCostTable.setBackground(new java.awt.Color(204, 204, 204));
        intCostTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        intCostTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        intCostTable.setForeground(new java.awt.Color(51, 51, 51));
        intCostTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Track/Exp/Imp  Id", "Shiping Option", "Cost"
            }
        ));
        jScrollPane13.setViewportView(intCostTable);

        javax.swing.GroupLayout from9Layout = new javax.swing.GroupLayout(from9);
        from9.setLayout(from9Layout);
        from9Layout.setHorizontalGroup(
            from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from9Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        from9Layout.setVerticalGroup(
            from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        CostPanel.add(from9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 370));

        from10.setBackground(new java.awt.Color(244, 244, 244));
        from10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 51));
        jLabel40.setText("Domestic (BDT)");

        domCostTable.setBackground(new java.awt.Color(204, 204, 204));
        domCostTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        domCostTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        domCostTable.setForeground(new java.awt.Color(51, 51, 51));
        domCostTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking Id", "Shiping Option", "Cost"
            }
        ));
        jScrollPane15.setViewportView(domCostTable);

        javax.swing.GroupLayout from10Layout = new javax.swing.GroupLayout(from10);
        from10.setLayout(from10Layout);
        from10Layout.setHorizontalGroup(
            from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from10Layout.createSequentialGroup()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 120, Short.MAX_VALUE))
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        from10Layout.setVerticalGroup(
            from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        CostPanel.add(from10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 370));

        jButton14.setBackground(new java.awt.Color(255, 153, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(51, 51, 51));
        jButton14.setText("Details");
        CostPanel.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 100, -1));

        jPanel19.add(CostPanel, "card2");

        RevenueCostPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(RevenueCostPanel, "card2");

        StatusPanel.setBackground(new java.awt.Color(244, 244, 244));
        StatusPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InternationalButton02.setBackground(new java.awt.Color(120, 60, 60));
        InternationalButton02.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InternationalButton02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InternationalButton02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InternationalButton02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InternationalButton02MouseExited(evt);
            }
        });

        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel77.setText("International");

        javax.swing.GroupLayout InternationalButton02Layout = new javax.swing.GroupLayout(InternationalButton02);
        InternationalButton02.setLayout(InternationalButton02Layout);
        InternationalButton02Layout.setHorizontalGroup(
            InternationalButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InternationalButton02Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel77, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        InternationalButton02Layout.setVerticalGroup(
            InternationalButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        StatusPanel.add(InternationalButton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        DomesticButton02.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton02.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DomesticButton02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DomesticButton02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DomesticButton02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DomesticButton02MouseExited(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel76.setText("Domestic");

        javax.swing.GroupLayout DomesticButton02Layout = new javax.swing.GroupLayout(DomesticButton02);
        DomesticButton02.setLayout(DomesticButton02Layout);
        DomesticButton02Layout.setHorizontalGroup(
            DomesticButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DomesticButton02Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        DomesticButton02Layout.setVerticalGroup(
            DomesticButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        StatusPanel.add(DomesticButton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        ExportButton02.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton02.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExportButton02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExportButton02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExportButton02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExportButton02MouseExited(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Export");

        javax.swing.GroupLayout ExportButton02Layout = new javax.swing.GroupLayout(ExportButton02);
        ExportButton02.setLayout(ExportButton02Layout);
        ExportButton02Layout.setHorizontalGroup(
            ExportButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExportButton02Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ExportButton02Layout.setVerticalGroup(
            ExportButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        StatusPanel.add(ExportButton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, -1));

        ImportButton02.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton02.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImportButton02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportButton02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImportButton02MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImportButton02MouseExited(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel75.setText("Import");

        javax.swing.GroupLayout ImportButton02Layout = new javax.swing.GroupLayout(ImportButton02);
        ImportButton02.setLayout(ImportButton02Layout);
        ImportButton02Layout.setHorizontalGroup(
            ImportButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportButton02Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel75, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ImportButton02Layout.setVerticalGroup(
            ImportButton02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        StatusPanel.add(ImportButton02, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, -1));

        jPanel25.setBackground(new java.awt.Color(244, 244, 244));
        jPanel25.setLayout(new java.awt.CardLayout());

        InternationalStatus.setBackground(new java.awt.Color(244, 244, 244));
        InternationalStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Internatioanl: Status");
        InternationalStatus.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        intStatusTable.setBackground(new java.awt.Color(204, 204, 204));
        intStatusTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        intStatusTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        intStatusTable.setForeground(new java.awt.Color(51, 51, 51));
        intStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value", "Status", "Order By", "Last Update"
            }
        ));
        jScrollPane2.setViewportView(intStatusTable);

        InternationalStatus.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 720, 370));

        jPanel25.add(InternationalStatus, "card2");

        DomesticStatus.setBackground(new java.awt.Color(244, 244, 244));
        DomesticStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(51, 51, 51));
        jLabel100.setText("Domestic: Status");
        DomesticStatus.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        domStatusTable.setBackground(new java.awt.Color(204, 204, 204));
        domStatusTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        domStatusTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        domStatusTable.setForeground(new java.awt.Color(51, 51, 51));
        domStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value", "Status", "Order By", "Last Update"
            }
        ));
        jScrollPane4.setViewportView(domStatusTable);

        DomesticStatus.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 720, 370));

        jPanel25.add(DomesticStatus, "card2");

        ExportStatus.setBackground(new java.awt.Color(244, 244, 244));
        ExportStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(51, 51, 51));
        jLabel150.setText("Export: Status");
        ExportStatus.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        domesticStat1.setBackground(new java.awt.Color(204, 204, 204));
        domesticStat1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        domesticStat1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        domesticStat1.setForeground(new java.awt.Color(51, 51, 51));
        domesticStat1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Export Id", "Order Name", "From", "Destination", "Export Value (USD)", "Status"
            }
        ));
        jScrollPane8.setViewportView(domesticStat1);

        ExportStatus.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 720, 370));

        jPanel25.add(ExportStatus, "card2");

        ImportStatus.setBackground(new java.awt.Color(244, 244, 244));
        ImportStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(51, 51, 51));
        jLabel151.setText("Import: Status");
        ImportStatus.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        domesticStat2.setBackground(new java.awt.Color(204, 204, 204));
        domesticStat2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        domesticStat2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        domesticStat2.setForeground(new java.awt.Color(51, 51, 51));
        domesticStat2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Import Id", "Order Name", "From", "Destination", "Import Value (USD)", "Status"
            }
        ));
        jScrollPane9.setViewportView(domesticStat2);

        ImportStatus.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 40, 720, 370));

        jPanel25.add(ImportStatus, "card2");

        StatusPanel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(StatusPanel, "card3");

        TrackingPanel.setBackground(new java.awt.Color(244, 244, 244));
        TrackingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DomesticButton03.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton03.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DomesticButton03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DomesticButton03MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DomesticButton03MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DomesticButton03MouseExited(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Domestic");

        javax.swing.GroupLayout DomesticButton03Layout = new javax.swing.GroupLayout(DomesticButton03);
        DomesticButton03.setLayout(DomesticButton03Layout);
        DomesticButton03Layout.setHorizontalGroup(
            DomesticButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DomesticButton03Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel78, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        DomesticButton03Layout.setVerticalGroup(
            DomesticButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        TrackingPanel.add(DomesticButton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        InternationalButton03.setBackground(new java.awt.Color(120, 60, 60));
        InternationalButton03.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InternationalButton03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InternationalButton03MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InternationalButton03MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InternationalButton03MouseExited(evt);
            }
        });

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("International");

        javax.swing.GroupLayout InternationalButton03Layout = new javax.swing.GroupLayout(InternationalButton03);
        InternationalButton03.setLayout(InternationalButton03Layout);
        InternationalButton03Layout.setHorizontalGroup(
            InternationalButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InternationalButton03Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel79, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        InternationalButton03Layout.setVerticalGroup(
            InternationalButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        TrackingPanel.add(InternationalButton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton03.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExportButton03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExportButton03MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExportButton03MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExportButton03MouseExited(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setText("Export");

        javax.swing.GroupLayout ExportButton03Layout = new javax.swing.GroupLayout(ExportButton03);
        ExportButton03.setLayout(ExportButton03Layout);
        ExportButton03Layout.setHorizontalGroup(
            ExportButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExportButton03Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ExportButton03Layout.setVerticalGroup(
            ExportButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel94, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        TrackingPanel.add(ExportButton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, -1));

        ImportButton03.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton03.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImportButton03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportButton03MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImportButton03MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImportButton03MouseExited(evt);
            }
        });

        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Import");

        javax.swing.GroupLayout ImportButton03Layout = new javax.swing.GroupLayout(ImportButton03);
        ImportButton03.setLayout(ImportButton03Layout);
        ImportButton03Layout.setHorizontalGroup(
            ImportButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportButton03Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ImportButton03Layout.setVerticalGroup(
            ImportButton03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel95, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        TrackingPanel.add(ImportButton03, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, -1));

        jPanel28.setBackground(new java.awt.Color(244, 244, 244));
        jPanel28.setLayout(new java.awt.CardLayout());

        InterTrack.setBackground(new java.awt.Color(244, 244, 244));
        InterTrack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Tracking Number");
        InterTrack.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jTable3.setBackground(new java.awt.Color(204, 204, 204));
        jTable3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable3.setForeground(new java.awt.Color(51, 51, 51));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Value (USD)", "Status"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        InterTrack.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton8.setBackground(new java.awt.Color(255, 153, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 51, 51));
        jButton8.setText("Print");
        InterTrack.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setText("Internatioanl: Tracking");
        InterTrack.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jTextField1.setBackground(new java.awt.Color(244, 244, 244));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        InterTrack.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Search");
        InterTrack.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jPanel28.add(InterTrack, "card2");

        DomesticTrack.setBackground(new java.awt.Color(244, 244, 244));
        DomesticTrack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(51, 51, 51));
        jLabel101.setText("Domestic: Tracking");
        DomesticTrack.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton9.setBackground(new java.awt.Color(255, 153, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setText("Print");
        DomesticTrack.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jTable5.setBackground(new java.awt.Color(204, 204, 204));
        jTable5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable5.setForeground(new java.awt.Color(51, 51, 51));
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Value (BDT)", "Status"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        DomesticTrack.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton10.setBackground(new java.awt.Color(255, 153, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("Search");
        DomesticTrack.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jTextField2.setBackground(new java.awt.Color(244, 244, 244));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DomesticTrack.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setText("Tracking Number");
        DomesticTrack.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jPanel28.add(DomesticTrack, "card2");

        ExportTrack.setBackground(new java.awt.Color(244, 244, 244));
        ExportTrack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel152.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(51, 51, 51));
        jLabel152.setText("Export: Tracking");
        ExportTrack.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton17.setBackground(new java.awt.Color(255, 153, 0));
        jButton17.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(51, 51, 51));
        jButton17.setText("Print");
        ExportTrack.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jTable8.setBackground(new java.awt.Color(204, 204, 204));
        jTable8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable8.setForeground(new java.awt.Color(51, 51, 51));
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Export Id", "Order Name", "From", "Destination", "Export Value (USD)", "Status"
            }
        ));
        jScrollPane10.setViewportView(jTable8);

        ExportTrack.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton18.setBackground(new java.awt.Color(255, 153, 0));
        jButton18.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton18.setForeground(new java.awt.Color(51, 51, 51));
        jButton18.setText("Search");
        ExportTrack.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jTextField4.setBackground(new java.awt.Color(244, 244, 244));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ExportTrack.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel153.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(51, 51, 51));
        jLabel153.setText("Export Id");
        ExportTrack.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jPanel28.add(ExportTrack, "card2");

        ImportTrack.setBackground(new java.awt.Color(244, 244, 244));
        ImportTrack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(51, 51, 51));
        jLabel154.setText("Import: Tracking");
        ImportTrack.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton19.setBackground(new java.awt.Color(255, 153, 0));
        jButton19.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton19.setForeground(new java.awt.Color(51, 51, 51));
        jButton19.setText("Print");
        ImportTrack.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jTable9.setBackground(new java.awt.Color(204, 204, 204));
        jTable9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable9.setForeground(new java.awt.Color(51, 51, 51));
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Import Id", "Order Name", "From", "Destination", "Import Value (USD)", "Status"
            }
        ));
        jScrollPane11.setViewportView(jTable9);

        ImportTrack.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton20.setBackground(new java.awt.Color(255, 153, 0));
        jButton20.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton20.setForeground(new java.awt.Color(51, 51, 51));
        jButton20.setText("Search");
        ImportTrack.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jTextField6.setBackground(new java.awt.Color(244, 244, 244));
        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ImportTrack.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel155.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(51, 51, 51));
        jLabel155.setText("Import Id");
        ImportTrack.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jPanel28.add(ImportTrack, "card2");

        TrackingPanel.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(TrackingPanel, "card4");

        EmployeeMemberPanel.setBackground(new java.awt.Color(244, 244, 244));
        EmployeeMemberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddEmployeeButton.setBackground(new java.awt.Color(120, 60, 60));
        AddEmployeeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddEmployeeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddEmployeeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddEmployeeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddEmployeeButtonMouseExited(evt);
            }
        });

        jLabel171.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("Add Employee");

        javax.swing.GroupLayout AddEmployeeButtonLayout = new javax.swing.GroupLayout(AddEmployeeButton);
        AddEmployeeButton.setLayout(AddEmployeeButtonLayout);
        AddEmployeeButtonLayout.setHorizontalGroup(
            AddEmployeeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddEmployeeButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        AddEmployeeButtonLayout.setVerticalGroup(
            AddEmployeeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel171, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        EmployeeMemberPanel.add(AddEmployeeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        EmployeeInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        EmployeeInfoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        EmployeeInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeInfoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmployeeInfoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmployeeInfoButtonMouseExited(evt);
            }
        });

        jLabel172.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel172.setText("Employee Info");

        javax.swing.GroupLayout EmployeeInfoButtonLayout = new javax.swing.GroupLayout(EmployeeInfoButton);
        EmployeeInfoButton.setLayout(EmployeeInfoButtonLayout);
        EmployeeInfoButtonLayout.setHorizontalGroup(
            EmployeeInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeeInfoButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        EmployeeInfoButtonLayout.setVerticalGroup(
            EmployeeInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        EmployeeMemberPanel.add(EmployeeInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        AddMemberButton.setBackground(new java.awt.Color(255, 153, 0));
        AddMemberButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AddMemberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMemberButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMemberButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMemberButtonMouseExited(evt);
            }
        });

        jLabel216.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(255, 255, 255));
        jLabel216.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel216.setText("Add Member");

        javax.swing.GroupLayout AddMemberButtonLayout = new javax.swing.GroupLayout(AddMemberButton);
        AddMemberButton.setLayout(AddMemberButtonLayout);
        AddMemberButtonLayout.setHorizontalGroup(
            AddMemberButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMemberButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel216, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        AddMemberButtonLayout.setVerticalGroup(
            AddMemberButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel216, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        EmployeeMemberPanel.add(AddMemberButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, -1));

        MemberInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        MemberInfoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MemberInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MemberInfoButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MemberInfoButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MemberInfoButtonMouseExited(evt);
            }
        });

        jLabel217.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(255, 255, 255));
        jLabel217.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel217.setText("Member Info");

        javax.swing.GroupLayout MemberInfoButtonLayout = new javax.swing.GroupLayout(MemberInfoButton);
        MemberInfoButton.setLayout(MemberInfoButtonLayout);
        MemberInfoButtonLayout.setHorizontalGroup(
            MemberInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MemberInfoButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel217, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MemberInfoButtonLayout.setVerticalGroup(
            MemberInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel217, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        EmployeeMemberPanel.add(MemberInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, -1));

        jPanel33.setBackground(new java.awt.Color(244, 244, 244));
        jPanel33.setLayout(new java.awt.CardLayout());

        AddEmployeePanel.setBackground(new java.awt.Color(244, 244, 244));
        AddEmployeePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(51, 51, 51));
        jLabel174.setText("Add New Employee");
        AddEmployeePanel.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel182.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(51, 51, 51));
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel182.setText("New Employee Id");
        AddEmployeePanel.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jTextField29.setBackground(new java.awt.Color(244, 244, 244));
        jTextField29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel183.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(51, 51, 51));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel183.setText("Name");
        AddEmployeePanel.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        jTextField30.setBackground(new java.awt.Color(244, 244, 244));
        jTextField30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel184.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(51, 51, 51));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel184.setText("Address");
        AddEmployeePanel.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jTextField31.setBackground(new java.awt.Color(244, 244, 244));
        jTextField31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel185.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(51, 51, 51));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel185.setText("Contact");
        AddEmployeePanel.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        jTextField32.setBackground(new java.awt.Color(244, 244, 244));
        jTextField32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jButton29.setBackground(new java.awt.Color(255, 153, 0));
        jButton29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton29.setForeground(new java.awt.Color(51, 51, 51));
        jButton29.setText("Add");
        AddEmployeePanel.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        jTextField33.setBackground(new java.awt.Color(244, 244, 244));
        jTextField33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jLabel186.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(51, 51, 51));
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel186.setText("Password");
        AddEmployeePanel.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        jLabel187.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(51, 51, 51));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel187.setText("Retype Password");
        AddEmployeePanel.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        jLabel188.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(51, 51, 51));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel188.setText("Section");
        AddEmployeePanel.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 30));

        jLabel189.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(51, 51, 51));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel189.setText("Last Used Id");
        AddEmployeePanel.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jTextField36.setEditable(false);
        jTextField36.setBackground(new java.awt.Color(244, 244, 244));
        jTextField36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField36, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jTextField61.setBackground(new java.awt.Color(244, 244, 244));
        jTextField61.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddEmployeePanel.add(jTextField61, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 260, 30));

        jComboBox1.setBackground(new java.awt.Color(244, 244, 244));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accountent", "Order Man" }));
        AddEmployeePanel.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 260, 30));

        jPanel33.add(AddEmployeePanel, "card2");

        EmployeeInfoPanel.setBackground(new java.awt.Color(244, 244, 244));
        EmployeeInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(51, 51, 51));
        jLabel177.setText("Profile");
        EmployeeInfoPanel.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel190.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(51, 51, 51));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel190.setText("Employee Id");
        EmployeeInfoPanel.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jLabel191.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(51, 51, 51));
        jLabel191.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel191.setText("Employee Name");
        EmployeeInfoPanel.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jTextField35.setBackground(new java.awt.Color(244, 244, 244));
        jTextField35.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel192.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(51, 51, 51));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel192.setText("Address");
        EmployeeInfoPanel.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        jTextField38.setBackground(new java.awt.Color(244, 244, 244));
        jTextField38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel193.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(51, 51, 51));
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel193.setText("Contact");
        EmployeeInfoPanel.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jTextField39.setBackground(new java.awt.Color(244, 244, 244));
        jTextField39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel194.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(51, 51, 51));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel194.setText("Preority");
        EmployeeInfoPanel.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        jTextField40.setBackground(new java.awt.Color(244, 244, 244));
        jTextField40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jLabel197.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(51, 51, 51));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel197.setText("Section");
        EmployeeInfoPanel.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 30));

        jButton30.setBackground(new java.awt.Color(255, 153, 0));
        jButton30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton30.setForeground(new java.awt.Color(51, 51, 51));
        jButton30.setText("Search");
        EmployeeInfoPanel.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 100, 30));

        jLabel198.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(51, 51, 51));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel198.setText("Search By Employee Id");
        EmployeeInfoPanel.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 30));

        jTextField43.setBackground(new java.awt.Color(244, 244, 244));
        jTextField43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 30));

        jButton31.setBackground(new java.awt.Color(255, 153, 0));
        jButton31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton31.setForeground(new java.awt.Color(51, 51, 51));
        jButton31.setText("Refress");
        EmployeeInfoPanel.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        jLabel195.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(51, 51, 51));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel195.setText("Last Shiped");
        EmployeeInfoPanel.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        jTextField41.setBackground(new java.awt.Color(244, 244, 244));
        jTextField41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jLabel196.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(51, 51, 51));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel196.setText("Last Shiped Value");
        EmployeeInfoPanel.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        jTextField42.setBackground(new java.awt.Color(244, 244, 244));
        jTextField42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 130, 30));

        jTextField44.setBackground(new java.awt.Color(244, 244, 244));
        jTextField44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        EmployeeInfoPanel.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 260, 30));

        jButton35.setBackground(new java.awt.Color(255, 153, 0));
        jButton35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton35.setForeground(new java.awt.Color(51, 51, 51));
        jButton35.setText("Update");
        EmployeeInfoPanel.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        jButton36.setBackground(new java.awt.Color(255, 153, 0));
        jButton36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton36.setForeground(new java.awt.Color(51, 51, 51));
        jButton36.setText("Delete");
        EmployeeInfoPanel.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 100, -1));

        jComboBox2.setBackground(new java.awt.Color(244, 244, 244));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(51, 51, 51));
        EmployeeInfoPanel.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jComboBox5.setBackground(new java.awt.Color(244, 244, 244));
        jComboBox5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Accountent", "Order Man" }));
        EmployeeInfoPanel.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 120, 30));

        jPanel33.add(EmployeeInfoPanel, "card2");

        AddMemberPanel.setBackground(new java.awt.Color(244, 244, 244));
        AddMemberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel218.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(51, 51, 51));
        jLabel218.setText("Add New Member");
        AddMemberPanel.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel219.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(51, 51, 51));
        jLabel219.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel219.setText("New Member Id");
        AddMemberPanel.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jTextField45.setBackground(new java.awt.Color(244, 244, 244));
        jTextField45.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel220.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(51, 51, 51));
        jLabel220.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel220.setText("Member Name");
        AddMemberPanel.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        jTextField46.setBackground(new java.awt.Color(244, 244, 244));
        jTextField46.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel221.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(51, 51, 51));
        jLabel221.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel221.setText("Address");
        AddMemberPanel.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jTextField47.setBackground(new java.awt.Color(244, 244, 244));
        jTextField47.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel222.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(51, 51, 51));
        jLabel222.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel222.setText("Contact");
        AddMemberPanel.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        jTextField48.setBackground(new java.awt.Color(244, 244, 244));
        jTextField48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jButton32.setBackground(new java.awt.Color(255, 153, 0));
        jButton32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton32.setForeground(new java.awt.Color(51, 51, 51));
        jButton32.setText("Add");
        AddMemberPanel.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        jTextField49.setBackground(new java.awt.Color(244, 244, 244));
        jTextField49.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jLabel223.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(51, 51, 51));
        jLabel223.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel223.setText("Password");
        AddMemberPanel.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        jLabel224.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(51, 51, 51));
        jLabel224.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel224.setText("Retype Password");
        AddMemberPanel.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        jTextField50.setBackground(new java.awt.Color(244, 244, 244));
        jTextField50.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 260, 30));

        jLabel225.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(51, 51, 51));
        jLabel225.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel225.setText("Shiping Option");
        AddMemberPanel.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 30));

        jLabel226.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(51, 51, 51));
        jLabel226.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel226.setText("Last Used Id");
        AddMemberPanel.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jTextField51.setEditable(false);
        jTextField51.setBackground(new java.awt.Color(244, 244, 244));
        jTextField51.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jCheckBox5.setBackground(new java.awt.Color(244, 244, 244));
        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox5.setText("Import");
        AddMemberPanel.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        jCheckBox6.setBackground(new java.awt.Color(244, 244, 244));
        jCheckBox6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox6.setText("Export");
        AddMemberPanel.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jPanel33.add(AddMemberPanel, "card2");

        MemberInfoPanel.setBackground(new java.awt.Color(244, 244, 244));
        MemberInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel227.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(51, 51, 51));
        jLabel227.setText("Profile");
        MemberInfoPanel.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel228.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(51, 51, 51));
        jLabel228.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel228.setText("Member Id");
        MemberInfoPanel.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jLabel229.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(51, 51, 51));
        jLabel229.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel229.setText("Member Name");
        MemberInfoPanel.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jTextField53.setBackground(new java.awt.Color(244, 244, 244));
        jTextField53.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel230.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(51, 51, 51));
        jLabel230.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel230.setText("Address");
        MemberInfoPanel.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        jTextField54.setBackground(new java.awt.Color(244, 244, 244));
        jTextField54.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel231.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(51, 51, 51));
        jLabel231.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel231.setText("Contact");
        MemberInfoPanel.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jTextField55.setBackground(new java.awt.Color(244, 244, 244));
        jTextField55.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel233.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(51, 51, 51));
        jLabel233.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel233.setText("Shiping Option");
        MemberInfoPanel.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        jCheckBox7.setBackground(new java.awt.Color(244, 244, 244));
        jCheckBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox7.setText("Export");
        MemberInfoPanel.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, -1, -1));

        jCheckBox8.setBackground(new java.awt.Color(244, 244, 244));
        jCheckBox8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox8.setForeground(new java.awt.Color(51, 51, 51));
        jCheckBox8.setText("Import");
        MemberInfoPanel.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, -1, -1));

        jButton33.setBackground(new java.awt.Color(255, 153, 0));
        jButton33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton33.setForeground(new java.awt.Color(51, 51, 51));
        jButton33.setText("Search");
        MemberInfoPanel.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 100, 30));

        jLabel234.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(51, 51, 51));
        jLabel234.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel234.setText("Search By Member Id");
        MemberInfoPanel.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 30));

        jTextField57.setBackground(new java.awt.Color(244, 244, 244));
        jTextField57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 30));

        jLabel235.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(51, 51, 51));
        jLabel235.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel235.setText("Last Shiped");
        MemberInfoPanel.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        jTextField58.setBackground(new java.awt.Color(244, 244, 244));
        jTextField58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField58, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jLabel236.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(51, 51, 51));
        jLabel236.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel236.setText("Last Shiped Value");
        MemberInfoPanel.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        jTextField59.setBackground(new java.awt.Color(244, 244, 244));
        jTextField59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField59, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 100, 30));

        jTextField60.setBackground(new java.awt.Color(244, 244, 244));
        jTextField60.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(jTextField60, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jButton37.setBackground(new java.awt.Color(255, 153, 0));
        jButton37.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton37.setForeground(new java.awt.Color(51, 51, 51));
        jButton37.setText("Refress");
        MemberInfoPanel.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        jButton38.setBackground(new java.awt.Color(255, 153, 0));
        jButton38.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton38.setForeground(new java.awt.Color(51, 51, 51));
        jButton38.setText("Delete");
        MemberInfoPanel.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 100, -1));

        jButton39.setBackground(new java.awt.Color(255, 153, 0));
        jButton39.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton39.setForeground(new java.awt.Color(51, 51, 51));
        jButton39.setText("Update");
        MemberInfoPanel.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        jComboBox8.setBackground(new java.awt.Color(244, 244, 244));
        jComboBox8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jComboBox8.setForeground(new java.awt.Color(51, 51, 51));
        MemberInfoPanel.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jPanel33.add(MemberInfoPanel, "card2");

        EmployeeMemberPanel.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(EmployeeMemberPanel, "card5");

        RatePanel.setBackground(new java.awt.Color(244, 244, 240));
        RatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DomesticButton04.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton04.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        DomesticButton04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DomesticButton04MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DomesticButton04MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DomesticButton04MouseExited(evt);
            }
        });

        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel82.setText("Domestic");

        javax.swing.GroupLayout DomesticButton04Layout = new javax.swing.GroupLayout(DomesticButton04);
        DomesticButton04.setLayout(DomesticButton04Layout);
        DomesticButton04Layout.setHorizontalGroup(
            DomesticButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DomesticButton04Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        DomesticButton04Layout.setVerticalGroup(
            DomesticButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel82, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RatePanel.add(DomesticButton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        InternationalButton04.setBackground(new java.awt.Color(120, 60, 60));
        InternationalButton04.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        InternationalButton04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InternationalButton04MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                InternationalButton04MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InternationalButton04MouseExited(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel83.setText("International");

        javax.swing.GroupLayout InternationalButton04Layout = new javax.swing.GroupLayout(InternationalButton04);
        InternationalButton04.setLayout(InternationalButton04Layout);
        InternationalButton04Layout.setHorizontalGroup(
            InternationalButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InternationalButton04Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        InternationalButton04Layout.setVerticalGroup(
            InternationalButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel83, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RatePanel.add(InternationalButton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        ExportButton04.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton04.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ExportButton04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExportButton04MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExportButton04MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExportButton04MouseExited(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Export");

        javax.swing.GroupLayout ExportButton04Layout = new javax.swing.GroupLayout(ExportButton04);
        ExportButton04.setLayout(ExportButton04Layout);
        ExportButton04Layout.setHorizontalGroup(
            ExportButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExportButton04Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ExportButton04Layout.setVerticalGroup(
            ExportButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel97, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RatePanel.add(ExportButton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, -1));

        ImportButton04.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton04.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ImportButton04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImportButton04MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImportButton04MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImportButton04MouseExited(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Import");

        javax.swing.GroupLayout ImportButton04Layout = new javax.swing.GroupLayout(ImportButton04);
        ImportButton04.setLayout(ImportButton04Layout);
        ImportButton04Layout.setHorizontalGroup(
            ImportButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImportButton04Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel98, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ImportButton04Layout.setVerticalGroup(
            ImportButton04Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel98, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        RatePanel.add(ImportButton04, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, -1));

        jPanel31.setBackground(new java.awt.Color(244, 244, 244));
        jPanel31.setLayout(new java.awt.CardLayout());

        InternationalRate.setBackground(new java.awt.Color(244, 244, 244));
        InternationalRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(51, 51, 51));
        jLabel84.setText("From Country");
        InternationalRate.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jTable6.setBackground(new java.awt.Color(204, 204, 204));
        jTable6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable6.setForeground(new java.awt.Color(51, 51, 51));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "Countries Name", "Destination Countries", "Weight", "Shiping Option", "Ship Value"
            }
        ));
        jScrollPane6.setViewportView(jTable6);

        InternationalRate.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton11.setBackground(new java.awt.Color(255, 153, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(51, 51, 51));
        jButton11.setText("Print");
        InternationalRate.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(51, 51, 51));
        jLabel85.setText("International: Rate Chart");
        InternationalRate.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jTextField7.setBackground(new java.awt.Color(244, 244, 244));
        jTextField7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        InternationalRate.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Search");
        InternationalRate.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jPanel31.add(InternationalRate, "card2");

        DomesticRate.setBackground(new java.awt.Color(244, 244, 244));
        DomesticRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setText("Domestic: Rate Chart");
        DomesticRate.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton12.setBackground(new java.awt.Color(255, 153, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 51));
        jButton12.setText("Print");
        DomesticRate.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jButton13.setBackground(new java.awt.Color(255, 153, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(51, 51, 51));
        jButton13.setText("Search");
        DomesticRate.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jTextField10.setBackground(new java.awt.Color(244, 244, 244));
        jTextField10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DomesticRate.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(51, 51, 51));
        jLabel86.setText("From District");
        DomesticRate.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jTable12.setBackground(new java.awt.Color(204, 204, 204));
        jTable12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable12.setForeground(new java.awt.Color(51, 51, 51));
        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "District From", "District To", "Weight", "Shiping Option", "Price (BDT)"
            }
        ));
        jScrollPane14.setViewportView(jTable12);

        DomesticRate.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jPanel31.add(DomesticRate, "card2");

        ExportRate.setBackground(new java.awt.Color(244, 244, 244));
        ExportRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(51, 51, 51));
        jLabel156.setText("Export: Rate Chart");
        ExportRate.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton21.setBackground(new java.awt.Color(255, 153, 0));
        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton21.setForeground(new java.awt.Color(51, 51, 51));
        jButton21.setText("Print");
        ExportRate.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jButton22.setBackground(new java.awt.Color(255, 153, 0));
        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton22.setForeground(new java.awt.Color(51, 51, 51));
        jButton22.setText("Search");
        ExportRate.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jTextField13.setBackground(new java.awt.Color(244, 244, 244));
        jTextField13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ExportRate.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel157.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(51, 51, 51));
        jLabel157.setText("From Country");
        ExportRate.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jTable7.setBackground(new java.awt.Color(204, 204, 204));
        jTable7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable7.setForeground(new java.awt.Color(51, 51, 51));
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "Countries Name", "Destination Countries", "Container", "Export Option", "Ship By", "Export Value (BDT)"
            }
        ));
        jScrollPane7.setViewportView(jTable7);

        ExportRate.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jPanel31.add(ExportRate, "card2");

        ImportRate.setBackground(new java.awt.Color(244, 244, 244));
        ImportRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(51, 51, 51));
        jLabel158.setText("Import: Rate Chart");
        ImportRate.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton23.setBackground(new java.awt.Color(255, 153, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton23.setForeground(new java.awt.Color(51, 51, 51));
        jButton23.setText("Print");
        ImportRate.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jButton24.setBackground(new java.awt.Color(255, 153, 0));
        jButton24.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton24.setForeground(new java.awt.Color(51, 51, 51));
        jButton24.setText("Search");
        ImportRate.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, -1, 30));

        jTextField15.setBackground(new java.awt.Color(244, 244, 244));
        jTextField15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ImportRate.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 160, 30));

        jLabel159.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(51, 51, 51));
        jLabel159.setText("Destination Country");
        ImportRate.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 30));

        jTable10.setBackground(new java.awt.Color(204, 204, 204));
        jTable10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        jTable10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTable10.setForeground(new java.awt.Color(51, 51, 51));
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Port From", "Destination Country", "Container", "Import Option", "Ship By", "Import Value (BDT)"
            }
        ));
        jScrollPane12.setViewportView(jTable10);

        ImportRate.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jPanel31.add(ImportRate, "card2");

        RatePanel.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(RatePanel, "card6");

        SetingPanel.setBackground(new java.awt.Color(244, 244, 244));
        SetingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ChangePassButton.setBackground(new java.awt.Color(120, 60, 60));
        ChangePassButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ChangePassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChangePassButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ChangePassButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ChangePassButtonMouseExited(evt);
            }
        });

        jLabel161.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(255, 255, 255));
        jLabel161.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel161.setText("Change Password");

        javax.swing.GroupLayout ChangePassButtonLayout = new javax.swing.GroupLayout(ChangePassButton);
        ChangePassButton.setLayout(ChangePassButtonLayout);
        ChangePassButtonLayout.setHorizontalGroup(
            ChangePassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePassButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel161, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ChangePassButtonLayout.setVerticalGroup(
            ChangePassButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel161, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        SetingPanel.add(ChangePassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        ProfileButton.setBackground(new java.awt.Color(255, 153, 0));
        ProfileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ProfileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfileButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProfileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProfileButtonMouseExited(evt);
            }
        });

        jLabel160.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(255, 255, 255));
        jLabel160.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel160.setText("Profile Setting");

        javax.swing.GroupLayout ProfileButtonLayout = new javax.swing.GroupLayout(ProfileButton);
        ProfileButton.setLayout(ProfileButtonLayout);
        ProfileButtonLayout.setHorizontalGroup(
            ProfileButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel160, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        ProfileButtonLayout.setVerticalGroup(
            ProfileButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        SetingPanel.add(ProfileButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        jPanel32.setBackground(new java.awt.Color(244, 244, 244));
        jPanel32.setLayout(new java.awt.CardLayout());

        ChangePassPanel.setBackground(new java.awt.Color(244, 244, 244));
        ChangePassPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel162.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(51, 51, 51));
        jLabel162.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel162.setText("Type Old Password");
        ChangePassPanel.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 170, 30));

        jButton25.setBackground(new java.awt.Color(255, 153, 0));
        jButton25.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton25.setForeground(new java.awt.Color(51, 51, 51));
        jButton25.setText("Change");
        ChangePassPanel.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 100, -1));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(51, 51, 51));
        jLabel163.setText("Change Admin Password");
        ChangePassPanel.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jTextField9.setBackground(new java.awt.Color(244, 244, 244));
        jTextField9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ChangePassPanel.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 180, 30));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(51, 51, 51));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel166.setText("Type New Password");
        ChangePassPanel.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 170, 30));

        jTextField17.setBackground(new java.awt.Color(244, 244, 244));
        jTextField17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ChangePassPanel.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 180, 30));

        jLabel167.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(51, 51, 51));
        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel167.setText("Re-Type New Password");
        ChangePassPanel.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 170, 30));

        jTextField18.setBackground(new java.awt.Color(244, 244, 244));
        jTextField18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ChangePassPanel.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 180, 30));

        jPanel32.add(ChangePassPanel, "card2");

        ProfilePanel.setBackground(new java.awt.Color(244, 244, 244));
        ProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(51, 51, 51));
        jLabel164.setText("Admin Profile");
        ProfilePanel.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton27.setBackground(new java.awt.Color(255, 153, 0));
        jButton27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton27.setForeground(new java.awt.Color(51, 51, 51));
        jButton27.setText("Change");
        ProfilePanel.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 100, -1));

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(244, 244, 244));
        jTextField16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jLabel165.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(51, 51, 51));
        jLabel165.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel165.setText("User Id");
        ProfilePanel.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        jLabel168.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(51, 51, 51));
        jLabel168.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel168.setText("Name");
        ProfilePanel.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        jTextField19.setBackground(new java.awt.Color(244, 244, 244));
        jTextField19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel169.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(51, 51, 51));
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel169.setText("Address");
        ProfilePanel.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        jTextField20.setBackground(new java.awt.Color(244, 244, 244));
        jTextField20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel170.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(51, 51, 51));
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel170.setText("Contact");
        ProfilePanel.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        jTextField21.setBackground(new java.awt.Color(244, 244, 244));
        jTextField21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jPanel32.add(ProfilePanel, "card2");

        SetingPanel.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(SetingPanel, "card7");

        getContentPane().add(BodyBgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 780, 550));

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
        AdminPage.this.dispose();
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

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(98, 49, 49));
        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.setBackground(new java.awt.Color(48, 24, 24));

        //Panel Visible
        RevenueCostPanel.setVisible(true);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        EmployeeMemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        BalancePanel.setVisible(true);
        CostPanel.setVisible(false);
        
        internationalRevenue();
        domesticRevenue();
        
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.setBackground(new java.awt.Color(98, 49, 49));
        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.setBackground(new java.awt.Color(48, 24, 24));

        //Panel Visible
        RevenueCostPanel.setVisible(false);
        StatusPanel.setVisible(true);
        TrackingPanel.setVisible(false);
        EmployeeMemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        
        intstat();
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.setBackground(new java.awt.Color(98, 49, 49));
        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.setBackground(new java.awt.Color(48, 24, 24));

        //Panel Visible
        RevenueCostPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(true);
        EmployeeMemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.setBackground(new java.awt.Color(98, 49, 49));
        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.setBackground(new java.awt.Color(48, 24, 24));

        //Panel Visible
        RevenueCostPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        EmployeeMemberPanel.setVisible(true);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.setBackground(new java.awt.Color(98, 49, 49));
        jPanel12.setBackground(new java.awt.Color(48, 24, 24));

        //Panel Visible
        RevenueCostPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        EmployeeMemberPanel.setVisible(false);
        RatePanel.setVisible(true);
        SetingPanel.setVisible(false);
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // TODO add your handling code here:
        jPanel13.setBackground(new java.awt.Color(48, 24, 24));
        jPanel14.setBackground(new java.awt.Color(48, 24, 24));
        jPanel15.setBackground(new java.awt.Color(48, 24, 24));
        jPanel16.setBackground(new java.awt.Color(48, 24, 24));
        jPanel17.setBackground(new java.awt.Color(48, 24, 24));
        jPanel12.setBackground(new java.awt.Color(98, 49, 49));

        //Panel Visible
        RevenueCostPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        EmployeeMemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(true);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        
        //Panel Visible
                RevenueCostPanel.setVisible(false);
                StatusPanel.setVisible(false);
                TrackingPanel.setVisible(false);
                EmployeeMemberPanel.setVisible(false);
                RatePanel.setVisible(false);
                SetingPanel.setVisible(false);
                LogoutPage logout=new LogoutPage();
                logout.show();
                AdminPage.this.dispose();
                
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        jPanel7.setBackground(new java.awt.Color(98, 49, 49));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        jPanel7.setBackground(new java.awt.Color(64, 32, 32));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel7MouseReleased

    private void jPanel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseEntered
        // TODO add your handling code here:
//        jPanel13.setBackground(new java.awt.Color(64, 32, 32));
    }//GEN-LAST:event_jPanel13MouseEntered

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
//        jPanel14.setBackground(new java.awt.Color(64, 32, 32));
    }//GEN-LAST:event_jPanel14MouseEntered

    private void BalanceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BalanceButtonMouseClicked
        // TODO add your handling code here:
        BalanceButton.setBackground(new java.awt.Color(120, 60, 60));
        CostButton.setBackground(new java.awt.Color(255, 153, 0));

        BalancePanel.setVisible(true);
        CostPanel.setVisible(false);
        
        internationalRevenue();
        domesticRevenue();
    }//GEN-LAST:event_BalanceButtonMouseClicked

    private void CostButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CostButtonMouseClicked
        // TODO add your handling code here: 
        BalanceButton.setBackground(new java.awt.Color(255, 153, 0));
        CostButton.setBackground(new java.awt.Color(120, 60, 60));

        BalancePanel.setVisible(false);
        CostPanel.setVisible(true);
        
        internationalCost();
        domesticCost();
    }//GEN-LAST:event_CostButtonMouseClicked

    private void BalanceButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BalanceButtonMouseEntered
        // TODO add your handling code here:
//        jPanel20.setBackground(new java.awt.Color(120, 60, 60));
    }//GEN-LAST:event_BalanceButtonMouseEntered

    private void BalanceButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BalanceButtonMouseExited
        // TODO add your handling code here:
//        jPanel20.setBackground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_BalanceButtonMouseExited

    private void CostButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CostButtonMouseEntered
        // TODO add your handling code here:
//        jPanel18.setBackground(new java.awt.Color(120, 60, 60));
    }//GEN-LAST:event_CostButtonMouseEntered

    private void CostButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CostButtonMouseExited
        // TODO add your handling code here:
//        jPanel18.setBackground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_CostButtonMouseExited

    private void DomesticButton02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton02MouseClicked
        // TODO add your handling code here:
        InternationalButton02.setBackground(new java.awt.Color(255, 153, 60));
        DomesticButton02.setBackground(new java.awt.Color(120, 60, 60));
        ExportButton02.setBackground(new java.awt.Color(255, 153, 60));
        ImportButton02.setBackground(new java.awt.Color(255, 153, 60));
        
        InternationalStatus.setVisible(false);
        DomesticStatus.setVisible(true);
        ExportStatus.setVisible(false);
        ImportStatus.setVisible(false);
        domstat();
    }//GEN-LAST:event_DomesticButton02MouseClicked

    private void DomesticButton02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton02MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton02MouseEntered

    private void DomesticButton02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton02MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton02MouseExited

    private void InternationalButton02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton02MouseClicked
        // TODO add your handling code here:
        InternationalButton02.setBackground(new java.awt.Color(120, 60, 60));
        DomesticButton02.setBackground(new java.awt.Color(255, 153, 60));
        ExportButton02.setBackground(new java.awt.Color(255, 153, 60));
        ImportButton02.setBackground(new java.awt.Color(255, 153, 60));
        
        InternationalStatus.setVisible(true);
        DomesticStatus.setVisible(false);
        ExportStatus.setVisible(false);
        ImportStatus.setVisible(false);
        intstat();
    }//GEN-LAST:event_InternationalButton02MouseClicked

    private void InternationalButton02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton02MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton02MouseEntered

    private void InternationalButton02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton02MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton02MouseExited

    private void DomesticButton03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton03MouseClicked
        // TODO add your handling code here:
        InternationalButton03.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton03.setBackground(new java.awt.Color(120, 60, 60));
        ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton03.setBackground(new java.awt.Color(255, 153, 0));
        
        InterTrack.setVisible(false);
        DomesticTrack.setVisible(true);
        ExportTrack.setVisible(false);
        ImportTrack.setVisible(false);
    }//GEN-LAST:event_DomesticButton03MouseClicked

    private void DomesticButton03MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton03MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton03MouseEntered

    private void DomesticButton03MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton03MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton03MouseExited

    private void InternationalButton03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton03MouseClicked
        // TODO add your handling code here:
        InternationalButton03.setBackground(new java.awt.Color(120, 60, 60));
        DomesticButton03.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton03.setBackground(new java.awt.Color(255, 153, 0));
        
        InterTrack.setVisible(true);
        DomesticTrack.setVisible(false);
        ExportTrack.setVisible(false);
        ImportTrack.setVisible(false);
    }//GEN-LAST:event_InternationalButton03MouseClicked

    private void InternationalButton03MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton03MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton03MouseEntered

    private void InternationalButton03MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton03MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton03MouseExited

    private void DomesticButton04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton04MouseClicked
        // TODO add your handling code here:
        InternationalButton04.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton04.setBackground(new java.awt.Color(120, 60, 60));
        ExportButton04.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton04.setBackground(new java.awt.Color(255, 153, 0));

        InternationalRate.setVisible(false);
        DomesticRate.setVisible(true);
        ExportRate.setVisible(false);
        ImportRate.setVisible(false);
    }//GEN-LAST:event_DomesticButton04MouseClicked

    private void DomesticButton04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton04MouseEntered

    private void DomesticButton04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DomesticButton04MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_DomesticButton04MouseExited

    private void InternationalButton04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton04MouseClicked
        // TODO add your handling code here:
        InternationalButton04.setBackground(new java.awt.Color(120, 60, 60));
        DomesticButton04.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton04.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton04.setBackground(new java.awt.Color(255, 153, 0));

        InternationalRate.setVisible(true);
        DomesticRate.setVisible(false);
        ExportRate.setVisible(false);
        ImportRate.setVisible(false);
    }//GEN-LAST:event_InternationalButton04MouseClicked

    private void InternationalButton04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton04MouseEntered

    private void InternationalButton04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton04MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton04MouseExited
       

    //Global Date Variables:---
        java.util.Date shipDat;
        java.sql.Date sqlShipDat;
        
        java.util.Date richDat;
        java.sql.Date sqlRichDat;
    private void ExportButton02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton02MouseClicked
        // TODO add your handling code here:
        InternationalButton02.setBackground(new java.awt.Color(255, 153, 60));
        DomesticButton02.setBackground(new java.awt.Color(255, 153, 60));
        ExportButton02.setBackground(new java.awt.Color(120, 60, 60));
        ImportButton02.setBackground(new java.awt.Color(255, 153, 60));
        
        InternationalStatus.setVisible(false);
        DomesticStatus.setVisible(false);
        ExportStatus.setVisible(true);
        ImportStatus.setVisible(false);
    }//GEN-LAST:event_ExportButton02MouseClicked

    private void ExportButton02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton02MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton02MouseEntered

    private void ExportButton02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton02MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton02MouseExited

    private void ImportButton02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton02MouseClicked
        // TODO add your handling code here:
        InternationalButton02.setBackground(new java.awt.Color(255, 153, 60));
        DomesticButton02.setBackground(new java.awt.Color(255, 153, 60));
        ExportButton02.setBackground(new java.awt.Color(255, 153, 60));
        ImportButton02.setBackground(new java.awt.Color(120, 60, 60));
        
        InternationalStatus.setVisible(false);
        DomesticStatus.setVisible(false);
        ExportStatus.setVisible(false);
        ImportStatus.setVisible(true);
    }//GEN-LAST:event_ImportButton02MouseClicked

    private void ImportButton02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton02MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton02MouseEntered

    private void ImportButton02MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton02MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton02MouseExited

    private void ExportButton03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton03MouseClicked
        // TODO add your handling code here:
        InternationalButton03.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton03.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton03.setBackground(new java.awt.Color(120, 60, 60));
        ImportButton03.setBackground(new java.awt.Color(255, 153, 0));
        
        InterTrack.setVisible(false);
        DomesticTrack.setVisible(false);
        ExportTrack.setVisible(true);
        ImportTrack.setVisible(false);
    }//GEN-LAST:event_ExportButton03MouseClicked

    private void ExportButton03MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton03MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton03MouseEntered

    private void ExportButton03MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton03MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton03MouseExited

    private void ImportButton03MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton03MouseClicked
        // TODO add your handling code here:
        InternationalButton03.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton03.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton03.setBackground(new java.awt.Color(120, 60, 60));
        
        InterTrack.setVisible(false);
        DomesticTrack.setVisible(false);
        ExportTrack.setVisible(false);
        ImportTrack.setVisible(true);
    }//GEN-LAST:event_ImportButton03MouseClicked

    private void ImportButton03MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton03MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton03MouseEntered

    private void ImportButton03MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton03MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton03MouseExited

    private void ExportButton04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton04MouseClicked
        // TODO add your handling code here:
        InternationalButton04.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton04.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton04.setBackground(new java.awt.Color(120, 60, 60));
        ImportButton04.setBackground(new java.awt.Color(255, 153, 0));

        InternationalRate.setVisible(false);
        DomesticRate.setVisible(false);
        ExportRate.setVisible(true);
        ImportRate.setVisible(false);
    }//GEN-LAST:event_ExportButton04MouseClicked

    private void ExportButton04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton04MouseEntered

    private void ExportButton04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportButton04MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ExportButton04MouseExited

    private void ImportButton04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton04MouseClicked
        // TODO add your handling code here:
        InternationalButton04.setBackground(new java.awt.Color(255, 153, 0));
        DomesticButton04.setBackground(new java.awt.Color(255, 153, 0));
        ExportButton04.setBackground(new java.awt.Color(255, 153, 0));
        ImportButton04.setBackground(new java.awt.Color(120, 60, 60));

        InternationalRate.setVisible(false);
        DomesticRate.setVisible(false);
        ExportRate.setVisible(false);
        ImportRate.setVisible(true);
    }//GEN-LAST:event_ImportButton04MouseClicked

    private void ImportButton04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton04MouseEntered

    private void ImportButton04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImportButton04MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportButton04MouseExited

    private void ProfileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileButtonMouseClicked
        // TODO add your handling code here:
        ChangePassButton.setBackground(new java.awt.Color(255, 153, 0));
        ProfileButton.setBackground(new java.awt.Color(120, 60, 60));
        
        ChangePassPanel.setVisible(false);
        ProfilePanel.setVisible(true);
    }//GEN-LAST:event_ProfileButtonMouseClicked

    private void ProfileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileButtonMouseEntered

    private void ProfileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfileButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfileButtonMouseExited

    private void ChangePassButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassButtonMouseClicked
        // TODO add your handling code here:
        ChangePassButton.setBackground(new java.awt.Color(120, 60, 60));
        ProfileButton.setBackground(new java.awt.Color(255, 153, 0));
        
        ChangePassPanel.setVisible(true);
        ProfilePanel.setVisible(false);
    }//GEN-LAST:event_ChangePassButtonMouseClicked

    private void ChangePassButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePassButtonMouseEntered

    private void ChangePassButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChangePassButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ChangePassButtonMouseExited

    private void AddEmployeeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEmployeeButtonMouseClicked
        // TODO add your handling code here:
        AddEmployeeButton.setBackground(new java.awt.Color(120, 60, 60));
        EmployeeInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        AddMemberButton.setBackground(new java.awt.Color(255, 153, 0));
        MemberInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        
        AddEmployeePanel.setVisible(true);
        EmployeeInfoPanel.setVisible(false);
        AddMemberPanel.setVisible(false);
        MemberInfoPanel.setVisible(false);
    }//GEN-LAST:event_AddEmployeeButtonMouseClicked

    private void AddEmployeeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEmployeeButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddEmployeeButtonMouseEntered

    private void AddEmployeeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEmployeeButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddEmployeeButtonMouseExited

    private void EmployeeInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeInfoButtonMouseClicked
        // TODO add your handling code here:
        AddEmployeeButton.setBackground(new java.awt.Color(255, 153, 0));
        EmployeeInfoButton.setBackground(new java.awt.Color(120, 60, 60));
        AddMemberButton.setBackground(new java.awt.Color(255, 153, 0));
        MemberInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        
        AddEmployeePanel.setVisible(false);
        EmployeeInfoPanel.setVisible(true);
        AddMemberPanel.setVisible(false);
        MemberInfoPanel.setVisible(false);
    }//GEN-LAST:event_EmployeeInfoButtonMouseClicked

    private void EmployeeInfoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeInfoButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeInfoButtonMouseEntered

    private void EmployeeInfoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeInfoButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_EmployeeInfoButtonMouseExited

    private void AddMemberButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseClicked
        // TODO add your handling code here:
        AddEmployeeButton.setBackground(new java.awt.Color(255, 153, 0));
        EmployeeInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        AddMemberButton.setBackground(new java.awt.Color(120, 60, 60));
        MemberInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        
        AddEmployeePanel.setVisible(false);
        EmployeeInfoPanel.setVisible(false);
        AddMemberPanel.setVisible(true);
        MemberInfoPanel.setVisible(false);
    }//GEN-LAST:event_AddMemberButtonMouseClicked

    private void AddMemberButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemberButtonMouseEntered

    private void AddMemberButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemberButtonMouseExited

    private void MemberInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseClicked
        // TODO add your handling code here:
        AddEmployeeButton.setBackground(new java.awt.Color(255, 153, 0));
        EmployeeInfoButton.setBackground(new java.awt.Color(255, 153, 0));
        AddMemberButton.setBackground(new java.awt.Color(255, 153, 0));
        MemberInfoButton.setBackground(new java.awt.Color(120, 60, 60));
        
        AddEmployeePanel.setVisible(false);
        EmployeeInfoPanel.setVisible(false);
        AddMemberPanel.setVisible(false);
        MemberInfoPanel.setVisible(true);
    }//GEN-LAST:event_MemberInfoButtonMouseClicked

    private void MemberInfoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberInfoButtonMouseEntered

    private void MemberInfoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberInfoButtonMouseExited

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void comboDomRevenueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDomRevenueItemStateChanged
        // TODO add your handling code here:
        int domIndex=comboDomRevenue.getSelectedIndex();
        if(domIndex==0){
            domesticRevenue();
        }else{
            txtDomReturn.setText("None");
            txtDomCost.setText("None");
            txtDomRevenue.setText("None");
        }
    }//GEN-LAST:event_comboDomRevenueItemStateChanged

    private void comboIntRevenueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboIntRevenueItemStateChanged
        // TODO add your handling code here:
        int intIndex=comboIntRevenue.getSelectedIndex();
        if(intIndex==0){
            internationalRevenue();
        }else{
            txtIntReturn.setText("None");
            txtIntCost.setText("None");
            txtIntRevenue.setText("None");
        }
    }//GEN-LAST:event_comboIntRevenueItemStateChanged

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddEmployeeButton;
    private javax.swing.JPanel AddEmployeePanel;
    private javax.swing.JPanel AddMemberButton;
    private javax.swing.JPanel AddMemberPanel;
    private javax.swing.JPanel BalanceButton;
    private javax.swing.JPanel BalancePanel;
    private javax.swing.JPanel BodyBgPanel;
    private javax.swing.JPanel ChangePassButton;
    private javax.swing.JPanel ChangePassPanel;
    private javax.swing.JLabel Copyright;
    private javax.swing.JPanel CostButton;
    private javax.swing.JPanel CostPanel;
    private javax.swing.JPanel DomesticButton02;
    private javax.swing.JPanel DomesticButton03;
    private javax.swing.JPanel DomesticButton04;
    private javax.swing.JPanel DomesticRate;
    private javax.swing.JPanel DomesticStatus;
    private javax.swing.JPanel DomesticTrack;
    private javax.swing.JPanel EmployeeInfoButton;
    private javax.swing.JPanel EmployeeInfoPanel;
    private javax.swing.JPanel EmployeeMemberPanel;
    private javax.swing.JPanel ExportButton02;
    private javax.swing.JPanel ExportButton03;
    private javax.swing.JPanel ExportButton04;
    private javax.swing.JPanel ExportRate;
    private javax.swing.JPanel ExportStatus;
    private javax.swing.JPanel ExportTrack;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel ImportButton02;
    private javax.swing.JPanel ImportButton03;
    private javax.swing.JPanel ImportButton04;
    private javax.swing.JPanel ImportRate;
    private javax.swing.JPanel ImportStatus;
    private javax.swing.JPanel ImportTrack;
    private javax.swing.JPanel InterTrack;
    private javax.swing.JPanel InternationalButton02;
    private javax.swing.JPanel InternationalButton03;
    private javax.swing.JPanel InternationalButton04;
    private javax.swing.JPanel InternationalRate;
    private javax.swing.JPanel InternationalStatus;
    private javax.swing.JPanel LeftSidePanel;
    private javax.swing.JPanel MemberInfoButton;
    private javax.swing.JPanel MemberInfoPanel;
    private javax.swing.JPanel ProfileButton;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JPanel RatePanel;
    private javax.swing.JPanel RevenueCostPanel;
    private javax.swing.JPanel SetingPanel;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JPanel TrackingPanel;
    private javax.swing.JComboBox<String> comboDomRevenue;
    private javax.swing.JComboBox<String> comboIntRevenue;
    private javax.swing.JTable domCostTable;
    private javax.swing.JTable domStatusTable;
    private javax.swing.JTable domesticStat1;
    private javax.swing.JTable domesticStat2;
    private javax.swing.JPanel from10;
    private javax.swing.JPanel from3;
    private javax.swing.JPanel from4;
    private javax.swing.JPanel from9;
    private javax.swing.JTable intCostTable;
    private javax.swing.JTable intStatusTable;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField txtDomCost;
    private javax.swing.JTextField txtDomReturn;
    private javax.swing.JLabel txtDomRevenue;
    private javax.swing.JLabel txtEmpName;
    private javax.swing.JTextField txtIntCost;
    private javax.swing.JTextField txtIntReturn;
    private javax.swing.JLabel txtIntRevenue;
    private javax.swing.JLabel txtShipValue;
    private javax.swing.JLabel txtTK;
    // End of variables declaration//GEN-END:variables
}
