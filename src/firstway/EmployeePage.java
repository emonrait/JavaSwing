/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstway;

import java.awt.Color;
import java.awt.print.PrinterException;
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
public class EmployeePage extends javax.swing.JFrame {

    /**
     * Creates new form EmployeePage
     */
    public EmployeePage() {
        initComponents();

        this.getContentPane().setBackground(new java.awt.Color(244, 244, 244));
        international_button.setBackground(new java.awt.Color(120, 60, 60));
        InternationalButton02.setBackground(new java.awt.Color(120, 60, 60));
        FooterPanel.setVisible(true);
        intstat();
        domstat();
    }

//    public EmployeePage(String adminName) {
//        initComponents();
//        txtAdminName.
//    }
    public EmployeePage(String empName) {
        initComponents();
        txtEmpName.setText(empName);
    }

    //Methods---
    //International status:
    public void intstat() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) internationalState.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.international_ship";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), rs.getDouble(16), rs.getString(15), rs.getString(20)};
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
            DefaultTableModel dtm = (DefaultTableModel) domesticStatTable.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.domestic_ship";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(6), rs.getDouble(16), rs.getString(15), rs.getString(20)};
                dtm.addRow(data);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Last Member Id
    public void lastMemberId() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.member_info ORDER BY mid DESC LIMIT 1";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                txtLastMemberId.setText(rs.getString(1));
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //International Rate Chart:
    public void InternationalRate() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tableIntRate.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.international_rate";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String rates = String.valueOf(rs.getDouble(6)) + " USD";
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rates};
                dtm.addRow(data);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Domestic Rate Chart:
    public void DomesticRate() {
        try {
            DefaultTableModel dtm = (DefaultTableModel) tableDomRate.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.domestic_rate";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String rates = String.valueOf(rs.getDouble(6)) + " BDT";
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rates};
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
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                shipDate.setDate(new java.util.Date());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        NewShipPanel = new javax.swing.JPanel();
        international_button = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        domestic_bitton = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        export_button = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        import_button = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        InternationalShipPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        from1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        toIntCountry = new javax.swing.JComboBox<>();
        toIntZip = new javax.swing.JTextField();
        toIntCity = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        toIntAddress = new javax.swing.JTextField();
        from3 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        originIntCountry = new javax.swing.JComboBox<>();
        originIntZip = new javax.swing.JTextField();
        originIntCity = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        txtIntFromLane = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        toIntName = new javax.swing.JTextField();
        fromIntName = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        txtIntUsd = new javax.swing.JLabel();
        txtIntValueShow = new javax.swing.JLabel();
        from13 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        txtIntWeight = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox<>();
        packageInt = new javax.swing.JComboBox<>();
        txtIntProductName = new javax.swing.JTextField();
        txtIntPiece = new javax.swing.JTextField();
        from14 = new javax.swing.JPanel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        shipOptionInt = new javax.swing.JComboBox<>();
        jLabel135 = new javax.swing.JLabel();
        txtIntProductValue = new javax.swing.JTextField();
        txtIntReachDate = new javax.swing.JTextField();
        shipDateInt = new com.toedter.calendar.JDateChooser();
        jComboBox28 = new javax.swing.JComboBox<>();
        DomesticShipPanel = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        from5 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        toDistrict = new javax.swing.JComboBox<>();
        toZip = new javax.swing.JTextField();
        toCity = new javax.swing.JComboBox<>();
        jLabel58 = new javax.swing.JLabel();
        toLane = new javax.swing.JTextField();
        from6 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        txtOption = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        txtDomProductName = new javax.swing.JTextField();
        txtReached = new javax.swing.JTextField();
        shipDate = new com.toedter.calendar.JDateChooser();
        jComboBox25 = new javax.swing.JComboBox<>();
        from7 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        fromDistrict = new javax.swing.JComboBox<>();
        fromZip = new javax.swing.JTextField();
        fromCity = new javax.swing.JComboBox<>();
        jLabel68 = new javax.swing.JLabel();
        fromLane = new javax.swing.JTextField();
        from8 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtWeight = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jComboBox23 = new javax.swing.JComboBox<>();
        txtPackag = new javax.swing.JComboBox<>();
        txtProductName = new javax.swing.JTextField();
        txtpiece = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        fromName = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        toName = new javax.swing.JTextField();
        txtShipValue = new javax.swing.JLabel();
        txtTK = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        ExportShipPanel = new javax.swing.JPanel();
        jLabel99 = new javax.swing.JLabel();
        from9 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        toDistrict1 = new javax.swing.JComboBox<>();
        toZip1 = new javax.swing.JTextField();
        toCity1 = new javax.swing.JComboBox<>();
        jLabel107 = new javax.swing.JLabel();
        toLane1 = new javax.swing.JTextField();
        from10 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        txtOption1 = new javax.swing.JComboBox<>();
        jLabel112 = new javax.swing.JLabel();
        txtReached1 = new javax.swing.JTextField();
        shipDate1 = new com.toedter.calendar.JDateChooser();
        txtOption3 = new javax.swing.JComboBox<>();
        from11 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        fromDistrict1 = new javax.swing.JComboBox<>();
        fromZip1 = new javax.swing.JTextField();
        fromCity1 = new javax.swing.JComboBox<>();
        jLabel117 = new javax.swing.JLabel();
        fromLane1 = new javax.swing.JTextField();
        from12 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        txtWeight1 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        jComboBox24 = new javax.swing.JComboBox<>();
        txtPackag1 = new javax.swing.JComboBox<>();
        txtDomPiece1 = new javax.swing.JTextField();
        txtDomPiece3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        fromName1 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        toName1 = new javax.swing.JTextField();
        txtShipValue1 = new javax.swing.JLabel();
        txtTK1 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        ImportShipPanel = new javax.swing.JPanel();
        jLabel173 = new javax.swing.JLabel();
        from17 = new javax.swing.JPanel();
        jLabel175 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        toDistrict3 = new javax.swing.JComboBox<>();
        toZip3 = new javax.swing.JTextField();
        toCity3 = new javax.swing.JComboBox<>();
        jLabel180 = new javax.swing.JLabel();
        toLane3 = new javax.swing.JTextField();
        from18 = new javax.swing.JPanel();
        jLabel181 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        txtOption4 = new javax.swing.JComboBox<>();
        jLabel202 = new javax.swing.JLabel();
        txtReached3 = new javax.swing.JTextField();
        shipDate3 = new com.toedter.calendar.JDateChooser();
        txtOption5 = new javax.swing.JComboBox<>();
        from19 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        fromDistrict3 = new javax.swing.JComboBox<>();
        fromZip3 = new javax.swing.JTextField();
        fromCity3 = new javax.swing.JComboBox<>();
        jLabel207 = new javax.swing.JLabel();
        fromLane3 = new javax.swing.JTextField();
        from20 = new javax.swing.JPanel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        txtWeight3 = new javax.swing.JTextField();
        jLabel212 = new javax.swing.JLabel();
        jComboBox26 = new javax.swing.JComboBox<>();
        txtPackag3 = new javax.swing.JComboBox<>();
        txtDomPiece4 = new javax.swing.JTextField();
        txtDomPiece5 = new javax.swing.JTextField();
        jButton26 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel213 = new javax.swing.JLabel();
        fromName4 = new javax.swing.JTextField();
        jLabel214 = new javax.swing.JLabel();
        toName4 = new javax.swing.JTextField();
        txtShipValue3 = new javax.swing.JLabel();
        txtTK3 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
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
        jScrollPane13 = new javax.swing.JScrollPane();
        internationalState = new javax.swing.JTable();
        jLabel137 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        DomesticStatus = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        domesticStatTable = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jLabel136 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        ExportStatus = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        domesticStat4 = new javax.swing.JTable();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        ImportStatus = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        domesticStat5 = new javax.swing.JTable();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        TrackingPanel = new javax.swing.JPanel();
        InternationalButton03 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        DomesticButton03 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        ExportButton03 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        ImportButton03 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        InterTrack = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableIntTrack = new javax.swing.JTable();
        jLabel80 = new javax.swing.JLabel();
        txtIntTrack = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton56 = new javax.swing.JButton();
        jButton57 = new javax.swing.JButton();
        DomesticTrack = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        domTrackTable = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        txtDomTrackNumber = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
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
        MemberPanel = new javax.swing.JPanel();
        AddMemberButton = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        MemberInfoButton = new javax.swing.JPanel();
        jLabel172 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        AddMemberPanel = new javax.swing.JPanel();
        jLabel174 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        txtMemberId = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        txtMemberName = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        txtMemberAddress = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        txtMemberEmail = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jLabel188 = new javax.swing.JLabel();
        jLabel189 = new javax.swing.JLabel();
        txtLastMemberId = new javax.swing.JTextField();
        checkImport = new javax.swing.JCheckBox();
        checkExport = new javax.swing.JCheckBox();
        jButton47 = new javax.swing.JButton();
        repassmatch = new javax.swing.JLabel();
        txtMemberRepassword = new javax.swing.JPasswordField();
        txtMemberPassword = new javax.swing.JPasswordField();
        MemberInfoPanel = new javax.swing.JPanel();
        jLabel177 = new javax.swing.JLabel();
        jLabel190 = new javax.swing.JLabel();
        txtMemberId2 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        txtMemberName2 = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        txtMemberAddress2 = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        txtMemberEmail2 = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        txtMemberPreority = new javax.swing.JTextField();
        jLabel197 = new javax.swing.JLabel();
        checkExport2 = new javax.swing.JCheckBox();
        checkImport2 = new javax.swing.JCheckBox();
        jButton30 = new javax.swing.JButton();
        jLabel198 = new javax.swing.JLabel();
        txtMId = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jLabel195 = new javax.swing.JLabel();
        txtLastShip = new javax.swing.JTextField();
        jLabel196 = new javax.swing.JLabel();
        txtLastShipValue = new javax.swing.JTextField();
        jButton48 = new javax.swing.JButton();
        jButton49 = new javax.swing.JButton();
        RatePanel = new javax.swing.JPanel();
        InternationalButton04 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        DomesticButton04 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        ExportButton04 = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        ImportButton04 = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        InternationalRate = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableIntRate = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton50 = new javax.swing.JButton();
        txtFromCountry = new javax.swing.JComboBox<>();
        DomesticRate = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        txtFromDistrict = new javax.swing.JComboBox<>();
        jButton51 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tableDomRate = new javax.swing.JTable();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();
        ExportRate = new javax.swing.JPanel();
        jLabel156 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        txtFromExpCountry = new javax.swing.JComboBox<>();
        jButton12 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tableExpRate = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jButton54 = new javax.swing.JButton();
        ImportRate = new javax.swing.JPanel();
        jLabel158 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        txtFromImpCountry = new javax.swing.JComboBox<>();
        jButton21 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableImpRate = new javax.swing.JTable();
        jButton22 = new javax.swing.JButton();
        jButton55 = new javax.swing.JButton();
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
        txtOldEmployeePass = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        txtNewEmployeeRepass = new javax.swing.JPasswordField();
        txtNewEmployeePass = new javax.swing.JPasswordField();
        ProfilePanel = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        txtEmployeeId3 = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        txtEmployeeName3 = new javax.swing.JTextField();
        jLabel169 = new javax.swing.JLabel();
        txtEmployeeAddress3 = new javax.swing.JTextField();
        jLabel170 = new javax.swing.JLabel();
        txtEmployeeContact3 = new javax.swing.JTextField();
        UpdateDeletePanel = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        UpdateDelete = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDom01 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        txtDom09 = new javax.swing.JTextField();
        txtDom10 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtDom02 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtDom03 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtDom11 = new javax.swing.JTextField();
        txtDom12 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtDom13 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtDom14 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtDom15 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtDom16 = new javax.swing.JTextField();
        comboDomDetails = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        txtDom08 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txtDom07 = new javax.swing.JTextField();
        txtDom06 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDom05 = new javax.swing.JTextField();
        txtDom04 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton42 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        txtDetail = new javax.swing.JLabel();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/fastway_logo_100x30_gray.png"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(43, 30));
        HeaderPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

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

        getContentPane().add(HeaderPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        FooterPanel.setBackground(new java.awt.Color(102, 102, 102));

        Copyright.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Copyright.setForeground(new java.awt.Color(255, 255, 255));
        Copyright.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Copyright.setText("Copyright: Reaz Uddin Samrat 2018  |  All Rights Reserved");

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
        jLabel10.setText("Employee");
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
        jLabel22.setText("New Ship");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shiping (2).png"))); // NOI18N

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
        jLabel24.setText("Shipment Status");

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
        jLabel28.setText("Member");

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

        NewShipPanel.setBackground(new java.awt.Color(244, 244, 244));
        NewShipPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        international_button.setBackground(new java.awt.Color(120, 60, 60));
        international_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        international_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                international_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                international_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                international_buttonMouseExited(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("International");

        javax.swing.GroupLayout international_buttonLayout = new javax.swing.GroupLayout(international_button);
        international_button.setLayout(international_buttonLayout);
        international_buttonLayout.setHorizontalGroup(
            international_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(international_buttonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        international_buttonLayout.setVerticalGroup(
            international_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        NewShipPanel.add(international_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        domestic_bitton.setBackground(new java.awt.Color(255, 153, 0));
        domestic_bitton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        domestic_bitton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                domestic_bittonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                domestic_bittonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                domestic_bittonMouseExited(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Domestic");

        javax.swing.GroupLayout domestic_bittonLayout = new javax.swing.GroupLayout(domestic_bitton);
        domestic_bitton.setLayout(domestic_bittonLayout);
        domestic_bittonLayout.setHorizontalGroup(
            domestic_bittonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(domestic_bittonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        domestic_bittonLayout.setVerticalGroup(
            domestic_bittonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        NewShipPanel.add(domestic_bitton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        export_button.setBackground(new java.awt.Color(255, 153, 0));
        export_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        export_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                export_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                export_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                export_buttonMouseExited(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Export");

        javax.swing.GroupLayout export_buttonLayout = new javax.swing.GroupLayout(export_button);
        export_button.setLayout(export_buttonLayout);
        export_buttonLayout.setHorizontalGroup(
            export_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(export_buttonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        export_buttonLayout.setVerticalGroup(
            export_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        NewShipPanel.add(export_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 160, -1));

        import_button.setBackground(new java.awt.Color(255, 153, 0));
        import_button.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        import_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                import_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                import_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                import_buttonMouseExited(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Import");

        javax.swing.GroupLayout import_buttonLayout = new javax.swing.GroupLayout(import_button);
        import_button.setLayout(import_buttonLayout);
        import_buttonLayout.setHorizontalGroup(
            import_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(import_buttonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        import_buttonLayout.setVerticalGroup(
            import_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        NewShipPanel.add(import_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, -1));

        jPanel19.setBackground(new java.awt.Color(244, 244, 244));
        jPanel19.setLayout(new java.awt.CardLayout());

        InternationalShipPanel.setBackground(new java.awt.Color(244, 244, 244));
        InternationalShipPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Internatioanl: Shiping Details");
        InternationalShipPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        from1.setBackground(new java.awt.Color(244, 244, 244));
        from1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("To*");

        jLabel32.setBackground(new java.awt.Color(204, 204, 204));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(51, 51, 51));
        jLabel32.setText("Destination Country");

        jLabel33.setBackground(new java.awt.Color(204, 204, 204));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(51, 51, 51));
        jLabel33.setText("Destination Zip");

        jLabel34.setBackground(new java.awt.Color(204, 204, 204));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText("Destination City");

        toIntCountry.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        toIntCountry.setForeground(new java.awt.Color(51, 51, 51));
        toIntCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Bangladesh", "Canada", "England", "Africa" }));
        toIntCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toIntCountryItemStateChanged(evt);
            }
        });

        toIntZip.setBackground(new java.awt.Color(244, 244, 244));
        toIntZip.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        toIntCity.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel36.setBackground(new java.awt.Color(204, 204, 204));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 51, 51));
        jLabel36.setText("Lane/Apartment/Suit");

        toIntAddress.setBackground(new java.awt.Color(244, 244, 244));
        toIntAddress.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from1Layout = new javax.swing.GroupLayout(from1);
        from1.setLayout(from1Layout);
        from1Layout.setHorizontalGroup(
            from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toIntCountry, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toIntCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from1Layout.createSequentialGroup()
                        .addComponent(toIntZip, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(toIntAddress))
                .addContainerGap())
        );
        from1Layout.setVerticalGroup(
            from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(toIntCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(toIntZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(toIntCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(toIntAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        InternationalShipPanel.add(from1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 200));

        from3.setBackground(new java.awt.Color(244, 244, 244));
        from3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 51, 51));
        jLabel37.setText("From*");

        jLabel42.setBackground(new java.awt.Color(204, 204, 204));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(51, 51, 51));
        jLabel42.setText("Origin Country");

        jLabel47.setBackground(new java.awt.Color(204, 204, 204));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 51));
        jLabel47.setText("Origin Zip");

        jLabel52.setBackground(new java.awt.Color(204, 204, 204));
        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(51, 51, 51));
        jLabel52.setText("Origin City");

        originIntCountry.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        originIntCountry.setForeground(new java.awt.Color(51, 51, 51));
        originIntCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Bangladesh", "Canada", "England", "Africa" }));
        originIntCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                originIntCountryItemStateChanged(evt);
            }
        });

        originIntZip.setBackground(new java.awt.Color(244, 244, 244));
        originIntZip.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        originIntCity.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel53.setBackground(new java.awt.Color(204, 204, 204));
        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(51, 51, 51));
        jLabel53.setText("Lane/Apartment/Suit");

        txtIntFromLane.setBackground(new java.awt.Color(244, 244, 244));
        txtIntFromLane.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from3Layout = new javax.swing.GroupLayout(from3);
        from3.setLayout(from3Layout);
        from3Layout.setHorizontalGroup(
            from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(originIntCountry, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(originIntCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from3Layout.createSequentialGroup()
                        .addComponent(originIntZip, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(txtIntFromLane))
                .addContainerGap())
        );
        from3Layout.setVerticalGroup(
            from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(originIntCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(originIntZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(originIntCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(txtIntFromLane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        InternationalShipPanel.add(from3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 200));

        jButton1.setBackground(new java.awt.Color(180, 180, 180));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Clear");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        InternationalShipPanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, -1));

        jButton2.setBackground(new java.awt.Color(255, 153, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Order");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        InternationalShipPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 450, 100, -1));

        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 153, 0));
        jLabel92.setText("From Name*");
        InternationalShipPanel.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 20));

        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 153, 0));
        jLabel93.setText("To Name*");
        InternationalShipPanel.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 90, 20));

        toIntName.setBackground(new java.awt.Color(244, 244, 244));
        toIntName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        toIntName.setForeground(new java.awt.Color(51, 51, 51));
        InternationalShipPanel.add(toIntName, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 140, -1));

        fromIntName.setBackground(new java.awt.Color(244, 244, 244));
        fromIntName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fromIntName.setForeground(new java.awt.Color(51, 51, 51));
        InternationalShipPanel.add(fromIntName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 140, -1));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(51, 51, 51));
        jLabel87.setText("Shiping Value: ");
        InternationalShipPanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 110, 30));

        txtIntUsd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIntUsd.setForeground(new java.awt.Color(51, 51, 51));
        txtIntUsd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        InternationalShipPanel.add(txtIntUsd, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 30));

        txtIntValueShow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtIntValueShow.setForeground(new java.awt.Color(51, 51, 51));
        txtIntValueShow.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        InternationalShipPanel.add(txtIntValueShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 30));

        from13.setBackground(new java.awt.Color(244, 244, 244));
        from13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(51, 51, 51));
        jLabel126.setText("Product Information*");

        jLabel127.setBackground(new java.awt.Color(204, 204, 204));
        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(51, 51, 51));
        jLabel127.setText("Product Name");

        jLabel128.setBackground(new java.awt.Color(204, 204, 204));
        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setText("Weight");

        jLabel129.setBackground(new java.awt.Color(204, 204, 204));
        jLabel129.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(51, 51, 51));
        jLabel129.setText("Pieces");

        txtIntWeight.setBackground(new java.awt.Color(244, 244, 244));
        txtIntWeight.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel130.setBackground(new java.awt.Color(204, 204, 204));
        jLabel130.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(51, 51, 51));
        jLabel130.setText("Packaging");

        jComboBox27.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox27.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg" }));

        packageInt.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        packageInt.setForeground(new java.awt.Color(51, 51, 51));
        packageInt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Letter", "Small Box", "Medium Box", "Large Box" }));

        txtIntProductName.setBackground(new java.awt.Color(244, 244, 244));
        txtIntProductName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtIntProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIntProductNameActionPerformed(evt);
            }
        });
        txtIntProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIntProductNameKeyReleased(evt);
            }
        });

        txtIntPiece.setBackground(new java.awt.Color(244, 244, 244));
        txtIntPiece.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from13Layout = new javax.swing.GroupLayout(from13);
        from13.setLayout(from13Layout);
        from13Layout.setHorizontalGroup(
            from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel130, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel129, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel127, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel128, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel126, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(packageInt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIntProductName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, from13Layout.createSequentialGroup()
                        .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIntPiece, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIntWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        from13Layout.setVerticalGroup(
            from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel126)
                .addGap(18, 18, 18)
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(txtIntProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel128)
                    .addComponent(txtIntWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(txtIntPiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(packageInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        InternationalShipPanel.add(from13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 200));

        from14.setBackground(new java.awt.Color(244, 244, 244));
        from14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(51, 51, 51));
        jLabel131.setText("Value & Others*");

        jLabel132.setBackground(new java.awt.Color(204, 204, 204));
        jLabel132.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(51, 51, 51));
        jLabel132.setText("Product Value");

        jLabel133.setBackground(new java.awt.Color(204, 204, 204));
        jLabel133.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(51, 51, 51));
        jLabel133.setText("Shiping Date");

        jLabel134.setBackground(new java.awt.Color(204, 204, 204));
        jLabel134.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(51, 51, 51));
        jLabel134.setText("Shiping Option");

        shipOptionInt.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        shipOptionInt.setForeground(new java.awt.Color(51, 51, 51));
        shipOptionInt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Expressed", "General" }));
        shipOptionInt.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                shipOptionIntItemStateChanged(evt);
            }
        });

        jLabel135.setBackground(new java.awt.Color(204, 204, 204));
        jLabel135.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(51, 51, 51));
        jLabel135.setText("Will be reached");

        txtIntProductValue.setBackground(new java.awt.Color(244, 244, 244));
        txtIntProductValue.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtIntReachDate.setEditable(false);
        txtIntReachDate.setBackground(new java.awt.Color(244, 244, 244));
        txtIntReachDate.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtIntReachDate.setForeground(new java.awt.Color(255, 102, 0));

        shipDateInt.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                shipDateIntAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        shipDateInt.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                shipDateIntPropertyChange(evt);
            }
        });

        jComboBox28.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox28.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox28.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USD" }));

        javax.swing.GroupLayout from14Layout = new javax.swing.GroupLayout(from14);
        from14.setLayout(from14Layout);
        from14Layout.setHorizontalGroup(
            from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel135, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel131, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from14Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(shipOptionInt, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shipDateInt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, from14Layout.createSequentialGroup()
                                .addComponent(txtIntProductValue, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(from14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIntReachDate)))
                .addContainerGap())
        );
        from14Layout.setVerticalGroup(
            from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel131)
                .addGap(18, 18, 18)
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel132)
                    .addComponent(txtIntProductValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shipDateInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(shipOptionInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(txtIntReachDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        InternationalShipPanel.add(from14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 360, 200));

        jPanel19.add(InternationalShipPanel, "card2");

        DomesticShipPanel.setBackground(new java.awt.Color(244, 244, 244));
        DomesticShipPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(51, 51, 51));
        jLabel46.setText("Domestic: Shiping Details");
        DomesticShipPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        from5.setBackground(new java.awt.Color(244, 244, 244));
        from5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(51, 51, 51));
        jLabel48.setText("To*");

        jLabel49.setBackground(new java.awt.Color(204, 204, 204));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(51, 51, 51));
        jLabel49.setText("Destination District");

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(51, 51, 51));
        jLabel50.setText("Destination Zip");

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 51, 51));
        jLabel51.setText("Destination Thana");

        toDistrict.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        toDistrict.setForeground(new java.awt.Color(51, 51, 51));
        toDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Dhaka", "Khulna", "Rajshahi" }));
        toDistrict.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toDistrictItemStateChanged(evt);
            }
        });

        toZip.setBackground(new java.awt.Color(244, 244, 244));
        toZip.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        toCity.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel58.setBackground(new java.awt.Color(204, 204, 204));
        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(51, 51, 51));
        jLabel58.setText("Lane/Apartment/Suit");

        toLane.setBackground(new java.awt.Color(244, 244, 244));
        toLane.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from5Layout = new javax.swing.GroupLayout(from5);
        from5.setLayout(from5Layout);
        from5Layout.setHorizontalGroup(
            from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDistrict, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from5Layout.createSequentialGroup()
                        .addComponent(toZip, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(toLane))
                .addContainerGap())
        );
        from5Layout.setVerticalGroup(
            from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGap(18, 18, 18)
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(toDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(toZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(toCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(toLane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        DomesticShipPanel.add(from5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 200));

        from6.setBackground(new java.awt.Color(244, 244, 244));
        from6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 51));
        jLabel59.setText("Value & Others*");

        jLabel60.setBackground(new java.awt.Color(204, 204, 204));
        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(51, 51, 51));
        jLabel60.setText("Product Value");

        jLabel61.setBackground(new java.awt.Color(204, 204, 204));
        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(51, 51, 51));
        jLabel61.setText("Shiping Date");

        jLabel62.setBackground(new java.awt.Color(204, 204, 204));
        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(51, 51, 51));
        jLabel62.setText("Shiping Type");

        txtOption.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtOption.setForeground(new java.awt.Color(51, 51, 51));
        txtOption.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Expressed", "General" }));
        txtOption.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtOptionItemStateChanged(evt);
            }
        });

        jLabel63.setBackground(new java.awt.Color(204, 204, 204));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(51, 51, 51));
        jLabel63.setText("Will be reached");

        txtDomProductName.setBackground(new java.awt.Color(244, 244, 244));
        txtDomProductName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        txtReached.setEditable(false);
        txtReached.setBackground(new java.awt.Color(244, 244, 244));
        txtReached.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtReached.setForeground(new java.awt.Color(255, 102, 0));

        shipDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                shipDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        shipDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                shipDatePropertyChange(evt);
            }
        });

        jComboBox25.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox25.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox25.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BDT" }));

        javax.swing.GroupLayout from6Layout = new javax.swing.GroupLayout(from6);
        from6.setLayout(from6Layout);
        from6Layout.setHorizontalGroup(
            from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtOption, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shipDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, from6Layout.createSequentialGroup()
                                .addComponent(txtDomProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(from6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtReached)))
                .addContainerGap())
        );
        from6Layout.setVerticalGroup(
            from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addGap(18, 18, 18)
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(txtDomProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shipDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(txtOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(txtReached, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        DomesticShipPanel.add(from6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 360, 200));

        from7.setBackground(new java.awt.Color(244, 244, 244));
        from7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(51, 51, 51));
        jLabel64.setText("From*");

        jLabel65.setBackground(new java.awt.Color(204, 204, 204));
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(51, 51, 51));
        jLabel65.setText("Origin District");

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(51, 51, 51));
        jLabel66.setText("Origin Zip");

        jLabel67.setBackground(new java.awt.Color(204, 204, 204));
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 51));
        jLabel67.setText("Origin Thana");

        fromDistrict.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        fromDistrict.setForeground(new java.awt.Color(51, 51, 51));
        fromDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Dhaka", "Khulna", "Chitagong" }));
        fromDistrict.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fromDistrictItemStateChanged(evt);
            }
        });

        fromZip.setBackground(new java.awt.Color(244, 244, 244));
        fromZip.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        fromCity.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel68.setBackground(new java.awt.Color(204, 204, 204));
        jLabel68.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(51, 51, 51));
        jLabel68.setText("Lane/Apartment/Suit");

        fromLane.setBackground(new java.awt.Color(244, 244, 244));
        fromLane.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from7Layout = new javax.swing.GroupLayout(from7);
        from7.setLayout(from7Layout);
        from7Layout.setHorizontalGroup(
            from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDistrict, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromCity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from7Layout.createSequentialGroup()
                        .addComponent(fromZip, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(fromLane))
                .addContainerGap())
        );
        from7Layout.setVerticalGroup(
            from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel64)
                .addGap(18, 18, 18)
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(fromDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(fromZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(fromCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(fromLane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        DomesticShipPanel.add(from7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 200));

        from8.setBackground(new java.awt.Color(244, 244, 244));
        from8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(51, 51, 51));
        jLabel69.setText("Product Information*");

        jLabel70.setBackground(new java.awt.Color(204, 204, 204));
        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(51, 51, 51));
        jLabel70.setText("Product Name");

        jLabel71.setBackground(new java.awt.Color(204, 204, 204));
        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(51, 51, 51));
        jLabel71.setText("Weight");

        jLabel72.setBackground(new java.awt.Color(204, 204, 204));
        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(51, 51, 51));
        jLabel72.setText("Pieces");

        txtWeight.setBackground(new java.awt.Color(244, 244, 244));
        txtWeight.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel73.setBackground(new java.awt.Color(204, 204, 204));
        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(51, 51, 51));
        jLabel73.setText("Packaging");

        jComboBox23.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox23.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox23.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg" }));

        txtPackag.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPackag.setForeground(new java.awt.Color(51, 51, 51));
        txtPackag.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Letter", "Small Box", "Medium Box", "Large Box" }));

        txtProductName.setBackground(new java.awt.Color(244, 244, 244));
        txtProductName.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductNameActionPerformed(evt);
            }
        });
        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
        });

        txtpiece.setBackground(new java.awt.Color(244, 244, 244));
        txtpiece.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from8Layout = new javax.swing.GroupLayout(from8);
        from8.setLayout(from8Layout);
        from8Layout.setHorizontalGroup(
            from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPackag, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProductName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, from8Layout.createSequentialGroup()
                        .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtpiece, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        from8Layout.setVerticalGroup(
            from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addGap(18, 18, 18)
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72)
                    .addComponent(txtpiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(txtPackag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        DomesticShipPanel.add(from8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 200));

        jButton3.setBackground(new java.awt.Color(180, 180, 180));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        DomesticShipPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, -1));

        jButton4.setBackground(new java.awt.Color(255, 153, 0));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("Order");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        DomesticShipPanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 450, 100, -1));

        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 153, 0));
        jLabel90.setText("From Name*");
        DomesticShipPanel.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 20));

        fromName.setBackground(new java.awt.Color(244, 244, 244));
        fromName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fromName.setForeground(new java.awt.Color(51, 51, 51));
        DomesticShipPanel.add(fromName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 140, -1));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 153, 0));
        jLabel91.setText("To Name*");
        DomesticShipPanel.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 90, 20));

        toName.setBackground(new java.awt.Color(244, 244, 244));
        toName.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        toName.setForeground(new java.awt.Color(51, 51, 51));
        DomesticShipPanel.add(toName, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 140, -1));

        txtShipValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtShipValue.setForeground(new java.awt.Color(51, 51, 51));
        txtShipValue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DomesticShipPanel.add(txtShipValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 30));

        txtTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTK.setForeground(new java.awt.Color(51, 51, 51));
        txtTK.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        DomesticShipPanel.add(txtTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 30));

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setText("Shiping Value: ");
        DomesticShipPanel.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 110, 30));

        jPanel19.add(DomesticShipPanel, "card2");

        ExportShipPanel.setBackground(new java.awt.Color(244, 244, 244));
        ExportShipPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(51, 51, 51));
        jLabel99.setText("Export: Shiping Details");
        ExportShipPanel.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        from9.setBackground(new java.awt.Color(244, 244, 244));
        from9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel103.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(51, 51, 51));
        jLabel103.setText("To*");

        jLabel104.setBackground(new java.awt.Color(204, 204, 204));
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(51, 51, 51));
        jLabel104.setText("Destination Country");

        jLabel105.setBackground(new java.awt.Color(204, 204, 204));
        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(51, 51, 51));
        jLabel105.setText("Destination Zip");

        jLabel106.setBackground(new java.awt.Color(204, 204, 204));
        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(51, 51, 51));
        jLabel106.setText("Destination City");

        toDistrict1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        toDistrict1.setForeground(new java.awt.Color(51, 51, 51));
        toDistrict1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Afganistan", "Bangladesh", "Indai" }));
        toDistrict1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toDistrict1ItemStateChanged(evt);
            }
        });

        toZip1.setBackground(new java.awt.Color(244, 244, 244));
        toZip1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        toCity1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel107.setBackground(new java.awt.Color(204, 204, 204));
        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(51, 51, 51));
        jLabel107.setText("Port/Station/Address");

        toLane1.setBackground(new java.awt.Color(244, 244, 244));
        toLane1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from9Layout = new javax.swing.GroupLayout(from9);
        from9.setLayout(from9Layout);
        from9Layout.setHorizontalGroup(
            from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel107, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel106, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel104, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel105, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel103, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDistrict1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toCity1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from9Layout.createSequentialGroup()
                        .addComponent(toZip1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(toLane1))
                .addContainerGap())
        );
        from9Layout.setVerticalGroup(
            from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel103)
                .addGap(18, 18, 18)
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel104)
                    .addComponent(toDistrict1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(toZip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel106)
                    .addComponent(toCity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel107)
                    .addComponent(toLane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ExportShipPanel.add(from9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 200));

        from10.setBackground(new java.awt.Color(244, 244, 244));
        from10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel108.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(51, 51, 51));
        jLabel108.setText("Shiping Options*");

        jLabel109.setBackground(new java.awt.Color(204, 204, 204));
        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(51, 51, 51));
        jLabel109.setText("Ship By");

        jLabel110.setBackground(new java.awt.Color(204, 204, 204));
        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(51, 51, 51));
        jLabel110.setText("Loading Date");

        jLabel111.setBackground(new java.awt.Color(204, 204, 204));
        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(51, 51, 51));
        jLabel111.setText("Shiping Option");

        txtOption1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtOption1.setForeground(new java.awt.Color(51, 51, 51));
        txtOption1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Tornado", "General" }));
        txtOption1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtOption1ItemStateChanged(evt);
            }
        });

        jLabel112.setBackground(new java.awt.Color(204, 204, 204));
        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(51, 51, 51));
        jLabel112.setText("Will be reached");

        txtReached1.setEditable(false);
        txtReached1.setBackground(new java.awt.Color(244, 244, 244));
        txtReached1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtReached1.setForeground(new java.awt.Color(255, 153, 0));

        shipDate1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                shipDate1AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        shipDate1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                shipDate1PropertyChange(evt);
            }
        });

        txtOption3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtOption3.setForeground(new java.awt.Color(51, 51, 51));
        txtOption3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Ship", "Railway", "Airoplan" }));
        txtOption3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtOption3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout from10Layout = new javax.swing.GroupLayout(from10);
        from10.setLayout(from10Layout);
        from10Layout.setHorizontalGroup(
            from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel112, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel108, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtReached1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(from10Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOption1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(from10Layout.createSequentialGroup()
                                .addComponent(shipDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtOption3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        from10Layout.setVerticalGroup(
            from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel108)
                .addGap(18, 18, 18)
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(txtOption3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shipDate1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel111)
                    .addComponent(txtOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(txtReached1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        ExportShipPanel.add(from10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 360, 200));

        from11.setBackground(new java.awt.Color(244, 244, 244));
        from11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel113.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(51, 51, 51));
        jLabel113.setText("From*");

        jLabel114.setBackground(new java.awt.Color(204, 204, 204));
        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(51, 51, 51));
        jLabel114.setText("Origin Country");

        jLabel115.setBackground(new java.awt.Color(204, 204, 204));
        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(51, 51, 51));
        jLabel115.setText("Origin Zip");

        jLabel116.setBackground(new java.awt.Color(204, 204, 204));
        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 51, 51));
        jLabel116.setText("Origin City");

        fromDistrict1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        fromDistrict1.setForeground(new java.awt.Color(51, 51, 51));
        fromDistrict1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Afganistan", "Bangladesh", "Indai" }));
        fromDistrict1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fromDistrict1ItemStateChanged(evt);
            }
        });

        fromZip1.setBackground(new java.awt.Color(244, 244, 244));
        fromZip1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        fromCity1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel117.setBackground(new java.awt.Color(204, 204, 204));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(51, 51, 51));
        jLabel117.setText("Port/Station/Address");

        fromLane1.setBackground(new java.awt.Color(244, 244, 244));
        fromLane1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from11Layout = new javax.swing.GroupLayout(from11);
        from11.setLayout(from11Layout);
        from11Layout.setHorizontalGroup(
            from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel117, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel115, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDistrict1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromCity1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from11Layout.createSequentialGroup()
                        .addComponent(fromZip1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(fromLane1))
                .addContainerGap())
        );
        from11Layout.setVerticalGroup(
            from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addGap(18, 18, 18)
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(fromDistrict1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(fromZip1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(fromCity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(fromLane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ExportShipPanel.add(from11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 200));

        from12.setBackground(new java.awt.Color(244, 244, 244));
        from12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(51, 51, 51));
        jLabel118.setText("Product Information*");

        jLabel119.setBackground(new java.awt.Color(204, 204, 204));
        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(51, 51, 51));
        jLabel119.setText("Product Name");

        jLabel120.setBackground(new java.awt.Color(204, 204, 204));
        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setText("Weight");

        jLabel121.setBackground(new java.awt.Color(204, 204, 204));
        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(51, 51, 51));
        jLabel121.setText("Container Amount");

        txtWeight1.setBackground(new java.awt.Color(244, 244, 244));
        txtWeight1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel122.setBackground(new java.awt.Color(204, 204, 204));
        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(51, 51, 51));
        jLabel122.setText("Container Size");

        jComboBox24.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox24.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox24.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ton", "Kg" }));

        txtPackag1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPackag1.setForeground(new java.awt.Color(51, 51, 51));
        txtPackag1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Small Container", "Medium Container", "Large Container" }));

        txtDomPiece1.setBackground(new java.awt.Color(244, 244, 244));
        txtDomPiece1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDomPiece1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomPiece1ActionPerformed(evt);
            }
        });
        txtDomPiece1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDomPiece1KeyReleased(evt);
            }
        });

        txtDomPiece3.setBackground(new java.awt.Color(244, 244, 244));
        txtDomPiece3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDomPiece3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomPiece3ActionPerformed(evt);
            }
        });
        txtDomPiece3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDomPiece3KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout from12Layout = new javax.swing.GroupLayout(from12);
        from12.setLayout(from12Layout);
        from12Layout.setHorizontalGroup(
            from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel122, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel121, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPackag1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDomPiece1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, from12Layout.createSequentialGroup()
                        .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDomPiece3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight1, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        from12Layout.setVerticalGroup(
            from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel118)
                .addGap(18, 18, 18)
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(txtDomPiece1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel120)
                    .addComponent(txtWeight1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(txtDomPiece3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel122)
                    .addComponent(txtPackag1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ExportShipPanel.add(from12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 200));

        jButton7.setBackground(new java.awt.Color(180, 180, 180));
        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(51, 51, 51));
        jButton7.setText("Clear");
        ExportShipPanel.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, -1));

        jButton14.setBackground(new java.awt.Color(255, 153, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(51, 51, 51));
        jButton14.setText("Order");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        ExportShipPanel.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 450, 100, -1));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(255, 153, 0));
        jLabel123.setText("From Name*");
        ExportShipPanel.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 20));

        fromName1.setBackground(new java.awt.Color(244, 244, 244));
        fromName1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fromName1.setForeground(new java.awt.Color(51, 51, 51));
        ExportShipPanel.add(fromName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 140, -1));

        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(255, 153, 0));
        jLabel124.setText("To Name*");
        ExportShipPanel.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 90, 20));

        toName1.setBackground(new java.awt.Color(244, 244, 244));
        toName1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        toName1.setForeground(new java.awt.Color(51, 51, 51));
        ExportShipPanel.add(toName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 140, -1));

        txtShipValue1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtShipValue1.setForeground(new java.awt.Color(51, 51, 51));
        txtShipValue1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ExportShipPanel.add(txtShipValue1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 30));

        txtTK1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTK1.setForeground(new java.awt.Color(51, 51, 51));
        txtTK1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ExportShipPanel.add(txtTK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 30));

        jLabel125.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(51, 51, 51));
        jLabel125.setText("Export Value: ");
        ExportShipPanel.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 110, 30));

        jPanel19.add(ExportShipPanel, "card2");

        ImportShipPanel.setBackground(new java.awt.Color(244, 244, 244));
        ImportShipPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel173.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(51, 51, 51));
        jLabel173.setText("Import: Shiping Details");
        ImportShipPanel.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 20));

        from17.setBackground(new java.awt.Color(244, 244, 244));
        from17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel175.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(51, 51, 51));
        jLabel175.setText("To*");

        jLabel176.setBackground(new java.awt.Color(204, 204, 204));
        jLabel176.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(51, 51, 51));
        jLabel176.setText("Destination Country");

        jLabel178.setBackground(new java.awt.Color(204, 204, 204));
        jLabel178.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(51, 51, 51));
        jLabel178.setText("Destination Zip");

        jLabel179.setBackground(new java.awt.Color(204, 204, 204));
        jLabel179.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel179.setForeground(new java.awt.Color(51, 51, 51));
        jLabel179.setText("Destination City");

        toDistrict3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        toDistrict3.setForeground(new java.awt.Color(51, 51, 51));
        toDistrict3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Afganistan", "Bangladesh", "Indai" }));
        toDistrict3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                toDistrict3ItemStateChanged(evt);
            }
        });

        toZip3.setBackground(new java.awt.Color(244, 244, 244));
        toZip3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        toCity3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel180.setBackground(new java.awt.Color(204, 204, 204));
        jLabel180.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel180.setForeground(new java.awt.Color(51, 51, 51));
        jLabel180.setText("Port/Station/Address");

        toLane3.setBackground(new java.awt.Color(244, 244, 244));
        toLane3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from17Layout = new javax.swing.GroupLayout(from17);
        from17.setLayout(from17Layout);
        from17Layout.setHorizontalGroup(
            from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel180, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel179, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel176, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel178, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel175, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDistrict3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(toCity3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from17Layout.createSequentialGroup()
                        .addComponent(toZip3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(toLane3))
                .addContainerGap())
        );
        from17Layout.setVerticalGroup(
            from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel175)
                .addGap(18, 18, 18)
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel176)
                    .addComponent(toDistrict3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel178)
                    .addComponent(toZip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel179)
                    .addComponent(toCity3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel180)
                    .addComponent(toLane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ImportShipPanel.add(from17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 360, 200));

        from18.setBackground(new java.awt.Color(244, 244, 244));
        from18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel181.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel181.setForeground(new java.awt.Color(51, 51, 51));
        jLabel181.setText("Shiping Options*");

        jLabel199.setBackground(new java.awt.Color(204, 204, 204));
        jLabel199.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(51, 51, 51));
        jLabel199.setText("Ship By");

        jLabel200.setBackground(new java.awt.Color(204, 204, 204));
        jLabel200.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(51, 51, 51));
        jLabel200.setText("Loading Time");

        jLabel201.setBackground(new java.awt.Color(204, 204, 204));
        jLabel201.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(51, 51, 51));
        jLabel201.setText("Shiping Option");

        txtOption4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtOption4.setForeground(new java.awt.Color(51, 51, 51));
        txtOption4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Tornado", "General" }));
        txtOption4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtOption4ItemStateChanged(evt);
            }
        });

        jLabel202.setBackground(new java.awt.Color(204, 204, 204));
        jLabel202.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(51, 51, 51));
        jLabel202.setText("Time to Get");

        txtReached3.setEditable(false);
        txtReached3.setBackground(new java.awt.Color(244, 244, 244));
        txtReached3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtReached3.setForeground(new java.awt.Color(255, 153, 0));

        shipDate3.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                shipDate3AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        shipDate3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                shipDate3PropertyChange(evt);
            }
        });

        txtOption5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtOption5.setForeground(new java.awt.Color(51, 51, 51));
        txtOption5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Ship", "Railway", "Airoplan" }));
        txtOption5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                txtOption5ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout from18Layout = new javax.swing.GroupLayout(from18);
        from18.setLayout(from18Layout);
        from18Layout.setHorizontalGroup(
            from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel202, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel201, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel199, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel200, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel181, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(from18Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtReached3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                    .addGroup(from18Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOption4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(from18Layout.createSequentialGroup()
                                .addComponent(shipDate3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtOption5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        from18Layout.setVerticalGroup(
            from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel181)
                .addGap(18, 18, 18)
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel199)
                    .addComponent(txtOption5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(shipDate3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel200, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel201)
                    .addComponent(txtOption4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel202)
                    .addComponent(txtReached3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        ImportShipPanel.add(from18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 360, 200));

        from19.setBackground(new java.awt.Color(244, 244, 244));
        from19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel203.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(51, 51, 51));
        jLabel203.setText("From*");

        jLabel204.setBackground(new java.awt.Color(204, 204, 204));
        jLabel204.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(51, 51, 51));
        jLabel204.setText("Origin Country");

        jLabel205.setBackground(new java.awt.Color(204, 204, 204));
        jLabel205.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(51, 51, 51));
        jLabel205.setText("Origin Zip");

        jLabel206.setBackground(new java.awt.Color(204, 204, 204));
        jLabel206.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(51, 51, 51));
        jLabel206.setText("Origin City");

        fromDistrict3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        fromDistrict3.setForeground(new java.awt.Color(51, 51, 51));
        fromDistrict3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Afganistan", "Bangladesh", "Indai" }));
        fromDistrict3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fromDistrict3ItemStateChanged(evt);
            }
        });

        fromZip3.setBackground(new java.awt.Color(244, 244, 244));
        fromZip3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        fromCity3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel207.setBackground(new java.awt.Color(204, 204, 204));
        jLabel207.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(51, 51, 51));
        jLabel207.setText("Port/Station/Address");

        fromLane3.setBackground(new java.awt.Color(244, 244, 244));
        fromLane3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        javax.swing.GroupLayout from19Layout = new javax.swing.GroupLayout(from19);
        from19.setLayout(from19Layout);
        from19Layout.setHorizontalGroup(
            from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel207, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel206, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel204, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel205, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel203, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDistrict3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fromCity3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(from19Layout.createSequentialGroup()
                        .addComponent(fromZip3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addComponent(fromLane3))
                .addContainerGap())
        );
        from19Layout.setVerticalGroup(
            from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel203)
                .addGap(18, 18, 18)
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel204)
                    .addComponent(fromDistrict3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel205)
                    .addComponent(fromZip3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel206)
                    .addComponent(fromCity3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel207)
                    .addComponent(fromLane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ImportShipPanel.add(from19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 200));

        from20.setBackground(new java.awt.Color(244, 244, 244));
        from20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 1, true));

        jLabel208.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel208.setForeground(new java.awt.Color(51, 51, 51));
        jLabel208.setText("Product Information*");

        jLabel209.setBackground(new java.awt.Color(204, 204, 204));
        jLabel209.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(51, 51, 51));
        jLabel209.setText("Product Name");

        jLabel210.setBackground(new java.awt.Color(204, 204, 204));
        jLabel210.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(51, 51, 51));
        jLabel210.setText("Weight");

        jLabel211.setBackground(new java.awt.Color(204, 204, 204));
        jLabel211.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(51, 51, 51));
        jLabel211.setText("Container Amount");

        txtWeight3.setBackground(new java.awt.Color(244, 244, 244));
        txtWeight3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N

        jLabel212.setBackground(new java.awt.Color(204, 204, 204));
        jLabel212.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(51, 51, 51));
        jLabel212.setText("Container Size");

        jComboBox26.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox26.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ton", "Kg" }));

        txtPackag3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPackag3.setForeground(new java.awt.Color(51, 51, 51));
        txtPackag3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Small Container", "Medium Container", "Large Container" }));

        txtDomPiece4.setBackground(new java.awt.Color(244, 244, 244));
        txtDomPiece4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDomPiece4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomPiece4ActionPerformed(evt);
            }
        });
        txtDomPiece4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDomPiece4KeyReleased(evt);
            }
        });

        txtDomPiece5.setBackground(new java.awt.Color(244, 244, 244));
        txtDomPiece5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtDomPiece5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomPiece5ActionPerformed(evt);
            }
        });
        txtDomPiece5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDomPiece5KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout from20Layout = new javax.swing.GroupLayout(from20);
        from20.setLayout(from20Layout);
        from20Layout.setHorizontalGroup(
            from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel212, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel211, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel209, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                    .addComponent(jLabel210, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel208, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPackag3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDomPiece4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, from20Layout.createSequentialGroup()
                        .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDomPiece5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWeight3, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        from20Layout.setVerticalGroup(
            from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(from20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel208)
                .addGap(18, 18, 18)
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel209)
                    .addComponent(txtDomPiece4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel210)
                    .addComponent(txtWeight3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel211)
                    .addComponent(txtDomPiece5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(from20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel212)
                    .addComponent(txtPackag3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        ImportShipPanel.add(from20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 360, 200));

        jButton26.setBackground(new java.awt.Color(180, 180, 180));
        jButton26.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton26.setForeground(new java.awt.Color(51, 51, 51));
        jButton26.setText("Clear");
        ImportShipPanel.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 450, 100, -1));

        jButton28.setBackground(new java.awt.Color(255, 153, 0));
        jButton28.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton28.setForeground(new java.awt.Color(51, 51, 51));
        jButton28.setText("Order");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        ImportShipPanel.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 450, 100, -1));

        jLabel213.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(255, 153, 0));
        jLabel213.setText("From Name*");
        ImportShipPanel.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 80, 20));

        fromName4.setBackground(new java.awt.Color(244, 244, 244));
        fromName4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        fromName4.setForeground(new java.awt.Color(51, 51, 51));
        ImportShipPanel.add(fromName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 140, -1));

        jLabel214.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(255, 153, 0));
        jLabel214.setText("To Name*");
        ImportShipPanel.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 90, 20));

        toName4.setBackground(new java.awt.Color(244, 244, 244));
        toName4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        toName4.setForeground(new java.awt.Color(51, 51, 51));
        ImportShipPanel.add(toName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 140, -1));

        txtShipValue3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtShipValue3.setForeground(new java.awt.Color(51, 51, 51));
        txtShipValue3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ImportShipPanel.add(txtShipValue3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 60, 30));

        txtTK3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTK3.setForeground(new java.awt.Color(51, 51, 51));
        txtTK3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ImportShipPanel.add(txtTK3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 40, 30));

        jLabel215.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(51, 51, 51));
        jLabel215.setText("Import Value: ");
        ImportShipPanel.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 110, 30));

        jPanel19.add(ImportShipPanel, "card2");

        NewShipPanel.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(NewShipPanel, "card2");

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

        internationalState.setBackground(new java.awt.Color(204, 204, 204));
        internationalState.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        internationalState.setForeground(new java.awt.Color(51, 51, 51));
        internationalState.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value (USD)", "Delivery Date", "Status"
            }
        ));
        internationalState.setSelectionBackground(new java.awt.Color(255, 153, 0));
        internationalState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                internationalStateMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(internationalState);

        InternationalStatus.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 720, 350));

        jLabel137.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(51, 51, 51));
        jLabel137.setText("Select Desire Row and Click Details Button to Show Order Details and make Update or Delete Any Entry.");
        InternationalStatus.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 30));

        jButton33.setBackground(new java.awt.Color(255, 153, 0));
        jButton33.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton33.setForeground(new java.awt.Color(51, 51, 51));
        jButton33.setText("Refresh");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        InternationalStatus.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        jButton34.setBackground(new java.awt.Color(255, 153, 0));
        jButton34.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton34.setForeground(new java.awt.Color(51, 51, 51));
        jButton34.setText("Details");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        InternationalStatus.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton35.setBackground(new java.awt.Color(255, 153, 0));
        jButton35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton35.setForeground(new java.awt.Color(51, 51, 51));
        jButton35.setText("Print");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        InternationalStatus.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jPanel25.add(InternationalStatus, "card2");

        DomesticStatus.setBackground(new java.awt.Color(244, 244, 244));
        DomesticStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(51, 51, 51));
        jLabel100.setText("Select Desire Row and Click Details Button to Show Order Details and make Update or Delete Any Entry.");
        DomesticStatus.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 30));

        domesticStatTable.setBackground(new java.awt.Color(204, 204, 204));
        domesticStatTable.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        domesticStatTable.setForeground(new java.awt.Color(51, 51, 51));
        domesticStatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value (BDT)", "Delivery Date", "Status"
            }
        ));
        domesticStatTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        domesticStatTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        domesticStatTable.setShowVerticalLines(false);
        domesticStatTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                domesticStatTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(domesticStatTable);

        DomesticStatus.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 720, 350));

        jButton15.setBackground(new java.awt.Color(255, 153, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(51, 51, 51));
        jButton15.setText("Refresh");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        DomesticStatus.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        jLabel136.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(51, 51, 51));
        jLabel136.setText("Domestic: Status");
        DomesticStatus.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton16.setBackground(new java.awt.Color(255, 153, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(51, 51, 51));
        jButton16.setText("Print");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        DomesticStatus.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jButton32.setBackground(new java.awt.Color(255, 153, 0));
        jButton32.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton32.setForeground(new java.awt.Color(51, 51, 51));
        jButton32.setText("Details");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        DomesticStatus.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jPanel25.add(DomesticStatus, "card2");

        ExportStatus.setBackground(new java.awt.Color(244, 244, 244));
        ExportStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel150.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(51, 51, 51));
        jLabel150.setText("Export: Status");
        ExportStatus.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(51, 51, 51));
        jLabel138.setText("Select Desire Row and Click Details Button to Show Order Details and make Update or Delete Any Entry.");
        ExportStatus.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 30));

        domesticStat4.setBackground(new java.awt.Color(204, 204, 204));
        domesticStat4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        domesticStat4.setForeground(new java.awt.Color(51, 51, 51));
        domesticStat4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value (USD)", "Delivery Date", "Status"
            }
        ));
        domesticStat4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                domesticStat4MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(domesticStat4);

        ExportStatus.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 720, 350));

        jButton36.setBackground(new java.awt.Color(255, 153, 0));
        jButton36.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton36.setForeground(new java.awt.Color(51, 51, 51));
        jButton36.setText("Refresh");
        ExportStatus.add(jButton36, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        jButton37.setBackground(new java.awt.Color(255, 153, 0));
        jButton37.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton37.setForeground(new java.awt.Color(51, 51, 51));
        jButton37.setText("Details");
        ExportStatus.add(jButton37, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton38.setBackground(new java.awt.Color(255, 153, 0));
        jButton38.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton38.setForeground(new java.awt.Color(51, 51, 51));
        jButton38.setText("Print");
        ExportStatus.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jPanel25.add(ExportStatus, "card2");

        ImportStatus.setBackground(new java.awt.Color(244, 244, 244));
        ImportStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel151.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(51, 51, 51));
        jLabel151.setText("Import: Status");
        ImportStatus.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(51, 51, 51));
        jLabel139.setText("Select Desire Row and Click Details Button to Show Order Details and make Update or Delete Any Entry.");
        ImportStatus.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 30));

        domesticStat5.setBackground(new java.awt.Color(204, 204, 204));
        domesticStat5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        domesticStat5.setForeground(new java.awt.Color(51, 51, 51));
        domesticStat5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Ship value (USD)", "Delivery Date", "Status"
            }
        ));
        domesticStat5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                domesticStat5MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(domesticStat5);

        ImportStatus.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 60, 720, 350));

        jButton39.setBackground(new java.awt.Color(255, 153, 0));
        jButton39.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton39.setForeground(new java.awt.Color(51, 51, 51));
        jButton39.setText("Refresh");
        ImportStatus.add(jButton39, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        jButton40.setBackground(new java.awt.Color(255, 153, 0));
        jButton40.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton40.setForeground(new java.awt.Color(51, 51, 51));
        jButton40.setText("Details");
        ImportStatus.add(jButton40, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton41.setBackground(new java.awt.Color(255, 153, 0));
        jButton41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton41.setForeground(new java.awt.Color(51, 51, 51));
        jButton41.setText("Print");
        ImportStatus.add(jButton41, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jPanel25.add(ImportStatus, "card2");

        StatusPanel.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(StatusPanel, "card3");

        TrackingPanel.setBackground(new java.awt.Color(244, 244, 244));
        TrackingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        tableIntTrack.setBackground(new java.awt.Color(204, 204, 204));
        tableIntTrack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tableIntTrack.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableIntTrack.setForeground(new java.awt.Color(51, 51, 51));
        tableIntTrack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Value (USD)", "Status"
            }
        ));
        tableIntTrack.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableIntTrack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableIntTrackMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableIntTrack);

        InterTrack.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jLabel80.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(51, 51, 51));
        jLabel80.setText("Internatioanl: Tracking");
        InterTrack.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        txtIntTrack.setBackground(new java.awt.Color(244, 244, 244));
        txtIntTrack.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        InterTrack.add(txtIntTrack, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jButton5.setBackground(new java.awt.Color(255, 153, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        InterTrack.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jButton23.setBackground(new java.awt.Color(255, 153, 0));
        jButton23.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton23.setForeground(new java.awt.Color(51, 51, 51));
        jButton23.setText("Clear Table");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        InterTrack.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        jButton56.setBackground(new java.awt.Color(255, 153, 0));
        jButton56.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton56.setForeground(new java.awt.Color(51, 51, 51));
        jButton56.setText("Details");
        jButton56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton56ActionPerformed(evt);
            }
        });
        InterTrack.add(jButton56, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton57.setBackground(new java.awt.Color(255, 153, 0));
        jButton57.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton57.setForeground(new java.awt.Color(51, 51, 51));
        jButton57.setText("Print");
        jButton57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton57ActionPerformed(evt);
            }
        });
        InterTrack.add(jButton57, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

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
        jButton9.setText("Clear Table");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        DomesticTrack.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 100, -1));

        domTrackTable.setBackground(new java.awt.Color(204, 204, 204));
        domTrackTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        domTrackTable.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        domTrackTable.setForeground(new java.awt.Color(51, 51, 51));
        domTrackTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tracking ", "Order Name", "From", "Destination", "Value (BDT)", "Status"
            }
        ));
        domTrackTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        domTrackTable.setSelectionForeground(new java.awt.Color(51, 51, 51));
        domTrackTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                domTrackTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(domTrackTable);

        DomesticTrack.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton10.setBackground(new java.awt.Color(255, 153, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("Search");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        DomesticTrack.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        txtDomTrackNumber.setBackground(new java.awt.Color(244, 244, 244));
        txtDomTrackNumber.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DomesticTrack.add(txtDomTrackNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 160, 30));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(51, 51, 51));
        jLabel81.setText("Tracking Number");
        DomesticTrack.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        jButton45.setBackground(new java.awt.Color(255, 153, 0));
        jButton45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton45.setForeground(new java.awt.Color(51, 51, 51));
        jButton45.setText("Print");
        jButton45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton45ActionPerformed(evt);
            }
        });
        DomesticTrack.add(jButton45, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jButton46.setBackground(new java.awt.Color(255, 153, 0));
        jButton46.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton46.setForeground(new java.awt.Color(51, 51, 51));
        jButton46.setText("Details");
        jButton46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton46ActionPerformed(evt);
            }
        });
        DomesticTrack.add(jButton46, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

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

        MemberPanel.setBackground(new java.awt.Color(244, 244, 244));
        MemberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AddMemberButton.setBackground(new java.awt.Color(120, 60, 60));
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

        jLabel171.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(255, 255, 255));
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel171.setText("Add Member");

        javax.swing.GroupLayout AddMemberButtonLayout = new javax.swing.GroupLayout(AddMemberButton);
        AddMemberButton.setLayout(AddMemberButtonLayout);
        AddMemberButtonLayout.setHorizontalGroup(
            AddMemberButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMemberButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel171, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        AddMemberButtonLayout.setVerticalGroup(
            AddMemberButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel171, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        MemberPanel.add(AddMemberButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

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

        jLabel172.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(255, 255, 255));
        jLabel172.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel172.setText("Member Info");

        javax.swing.GroupLayout MemberInfoButtonLayout = new javax.swing.GroupLayout(MemberInfoButton);
        MemberInfoButton.setLayout(MemberInfoButtonLayout);
        MemberInfoButtonLayout.setHorizontalGroup(
            MemberInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MemberInfoButtonLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel172, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MemberInfoButtonLayout.setVerticalGroup(
            MemberInfoButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel172, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        MemberPanel.add(MemberInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 160, -1));

        jPanel33.setBackground(new java.awt.Color(244, 244, 244));
        jPanel33.setLayout(new java.awt.CardLayout());

        AddMemberPanel.setBackground(new java.awt.Color(244, 244, 244));
        AddMemberPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel174.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(51, 51, 51));
        jLabel174.setText("Add New Member");
        AddMemberPanel.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel182.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel182.setForeground(new java.awt.Color(51, 51, 51));
        jLabel182.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel182.setText("Member Id");
        AddMemberPanel.add(jLabel182, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        txtMemberId.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(txtMemberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel183.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(51, 51, 51));
        jLabel183.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel183.setText("Name");
        AddMemberPanel.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        txtMemberName.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(txtMemberName, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel184.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(51, 51, 51));
        jLabel184.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel184.setText("Address");
        AddMemberPanel.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        txtMemberAddress.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberAddress.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(txtMemberAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel185.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(51, 51, 51));
        jLabel185.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel185.setText("Email");
        AddMemberPanel.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        txtMemberEmail.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberEmail.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(txtMemberEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jButton29.setBackground(new java.awt.Color(255, 153, 0));
        jButton29.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton29.setForeground(new java.awt.Color(51, 51, 51));
        jButton29.setText("Clear");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        AddMemberPanel.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 100, -1));

        jLabel186.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(51, 51, 51));
        jLabel186.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel186.setText("Password");
        AddMemberPanel.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        jLabel187.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(51, 51, 51));
        jLabel187.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel187.setText("Retype Password");
        AddMemberPanel.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        jLabel188.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel188.setForeground(new java.awt.Color(51, 51, 51));
        jLabel188.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel188.setText("Shiping Option");
        AddMemberPanel.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 30));

        jLabel189.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(51, 51, 51));
        jLabel189.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel189.setText("Last Used Id");
        AddMemberPanel.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        txtLastMemberId.setEditable(false);
        txtLastMemberId.setBackground(new java.awt.Color(244, 244, 244));
        txtLastMemberId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AddMemberPanel.add(txtLastMemberId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        checkImport.setBackground(new java.awt.Color(244, 244, 244));
        checkImport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkImport.setForeground(new java.awt.Color(51, 51, 51));
        checkImport.setText("Import");
        AddMemberPanel.add(checkImport, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, -1, -1));

        checkExport.setBackground(new java.awt.Color(244, 244, 244));
        checkExport.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkExport.setForeground(new java.awt.Color(51, 51, 51));
        checkExport.setText("Export");
        AddMemberPanel.add(checkExport, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jButton47.setBackground(new java.awt.Color(255, 153, 0));
        jButton47.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton47.setForeground(new java.awt.Color(51, 51, 51));
        jButton47.setText("Add");
        jButton47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton47ActionPerformed(evt);
            }
        });
        AddMemberPanel.add(jButton47, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        repassmatch.setBackground(new java.awt.Color(244, 244, 244));
        repassmatch.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        repassmatch.setForeground(new java.awt.Color(255, 255, 255));
        repassmatch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        repassmatch.setText("jLabel141");
        AddMemberPanel.add(repassmatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(579, 330, 110, 30));

        txtMemberRepassword.setBackground(new java.awt.Color(244, 244, 255));
        txtMemberRepassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMemberRepassword.setForeground(new java.awt.Color(51, 51, 51));
        txtMemberRepassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMemberRepasswordKeyReleased(evt);
            }
        });
        AddMemberPanel.add(txtMemberRepassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 260, 30));

        txtMemberPassword.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberPassword.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtMemberPassword.setForeground(new java.awt.Color(51, 51, 51));
        AddMemberPanel.add(txtMemberPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jPanel33.add(AddMemberPanel, "card2");

        MemberInfoPanel.setBackground(new java.awt.Color(244, 244, 244));
        MemberInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel177.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(51, 51, 51));
        jLabel177.setText("Member: Profile");
        MemberInfoPanel.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel190.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(51, 51, 51));
        jLabel190.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel190.setText("Member Id");
        MemberInfoPanel.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 130, 30));

        txtMemberId2.setEditable(false);
        txtMemberId2.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberId2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMemberId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

        jLabel191.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(51, 51, 51));
        jLabel191.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel191.setText("Name");
        MemberInfoPanel.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, 30));

        txtMemberName2.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberName2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMemberName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel192.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(51, 51, 51));
        jLabel192.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel192.setText("Address");
        MemberInfoPanel.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        txtMemberAddress2.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberAddress2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMemberAddress2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel193.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(51, 51, 51));
        jLabel193.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel193.setText("Email");
        MemberInfoPanel.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        txtMemberEmail2.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberEmail2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMemberEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jLabel194.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(51, 51, 51));
        jLabel194.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel194.setText("Preority");
        MemberInfoPanel.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 130, 30));

        txtMemberPreority.setEditable(false);
        txtMemberPreority.setBackground(new java.awt.Color(244, 244, 244));
        txtMemberPreority.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMemberPreority, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 260, 30));

        jLabel197.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(51, 51, 51));
        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel197.setText("Shiping Option");
        MemberInfoPanel.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 130, 30));

        checkExport2.setBackground(new java.awt.Color(244, 244, 244));
        checkExport2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkExport2.setForeground(new java.awt.Color(51, 51, 51));
        checkExport2.setText("Export");
        MemberInfoPanel.add(checkExport2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        checkImport2.setBackground(new java.awt.Color(244, 244, 244));
        checkImport2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        checkImport2.setForeground(new java.awt.Color(51, 51, 51));
        checkImport2.setText("Import");
        MemberInfoPanel.add(checkImport2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        jButton30.setBackground(new java.awt.Color(255, 153, 0));
        jButton30.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton30.setForeground(new java.awt.Color(51, 51, 51));
        jButton30.setText("Search");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        MemberInfoPanel.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 100, 30));

        jLabel198.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(51, 51, 51));
        jLabel198.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel198.setText("Search By Member Id");
        MemberInfoPanel.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, 30));

        txtMId.setBackground(new java.awt.Color(244, 244, 244));
        txtMId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtMId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 30));

        jButton31.setBackground(new java.awt.Color(255, 153, 0));
        jButton31.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton31.setForeground(new java.awt.Color(51, 51, 51));
        jButton31.setText("Clear");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        MemberInfoPanel.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        jLabel195.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(51, 51, 51));
        jLabel195.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel195.setText("Last Shiped");
        MemberInfoPanel.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 130, 30));

        txtLastShip.setEditable(false);
        txtLastShip.setBackground(new java.awt.Color(244, 244, 244));
        txtLastShip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtLastShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 260, 30));

        jLabel196.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(51, 51, 51));
        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel196.setText("Last Shiped Value");
        MemberInfoPanel.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 130, 30));

        txtLastShipValue.setEditable(false);
        txtLastShipValue.setBackground(new java.awt.Color(244, 244, 244));
        txtLastShipValue.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MemberInfoPanel.add(txtLastShipValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 260, 30));

        jButton48.setBackground(new java.awt.Color(255, 153, 0));
        jButton48.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton48.setForeground(new java.awt.Color(51, 51, 51));
        jButton48.setText("Update");
        jButton48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton48ActionPerformed(evt);
            }
        });
        MemberInfoPanel.add(jButton48, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 100, -1));

        jButton49.setBackground(new java.awt.Color(255, 153, 0));
        jButton49.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton49.setForeground(new java.awt.Color(51, 51, 51));
        jButton49.setText("Delete");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });
        MemberInfoPanel.add(jButton49, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 100, -1));

        jPanel33.add(MemberInfoPanel, "card2");

        MemberPanel.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(MemberPanel, "card5");

        RatePanel.setBackground(new java.awt.Color(244, 244, 240));
        RatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel84.setText("Country From");
        InternationalRate.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        tableIntRate.setBackground(new java.awt.Color(204, 204, 204));
        tableIntRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tableIntRate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableIntRate.setForeground(new java.awt.Color(51, 51, 51));
        tableIntRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "Countries Name", "Destination Countries", "Weight", "Shiping Option", "Ship Value"
            }
        ));
        tableIntRate.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jScrollPane6.setViewportView(tableIntRate);

        InternationalRate.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton11.setBackground(new java.awt.Color(255, 153, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(51, 51, 51));
        jButton11.setText("Refress");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        InternationalRate.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jLabel85.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(51, 51, 51));
        jLabel85.setText("International: Rate Chart");
        InternationalRate.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton6.setBackground(new java.awt.Color(255, 153, 0));
        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 51, 51));
        jButton6.setText("Search");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        InternationalRate.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        jButton50.setBackground(new java.awt.Color(255, 153, 0));
        jButton50.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton50.setForeground(new java.awt.Color(51, 51, 51));
        jButton50.setText("Print");
        jButton50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton50ActionPerformed(evt);
            }
        });
        InternationalRate.add(jButton50, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        txtFromCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Bangladesh", "Canada", "England", "Africa" }));
        InternationalRate.add(txtFromCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 140, 30));

        jPanel31.add(InternationalRate, "card2");

        DomesticRate.setBackground(new java.awt.Color(244, 244, 244));
        DomesticRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(51, 51, 51));
        jLabel102.setText("Domestic: Rate Chart");
        DomesticRate.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel141.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(51, 51, 51));
        jLabel141.setText("District From");
        DomesticRate.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        txtFromDistrict.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "All" }));
        DomesticRate.add(txtFromDistrict, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 140, 30));

        jButton51.setBackground(new java.awt.Color(255, 153, 0));
        jButton51.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton51.setForeground(new java.awt.Color(51, 51, 51));
        jButton51.setText("Search");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });
        DomesticRate.add(jButton51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        tableDomRate.setBackground(new java.awt.Color(204, 204, 204));
        tableDomRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tableDomRate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableDomRate.setForeground(new java.awt.Color(51, 51, 51));
        tableDomRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "District Name", "Destination District", "Weight", "Shiping Option", "Ship Value"
            }
        ));
        tableDomRate.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jScrollPane8.setViewportView(tableDomRate);

        DomesticRate.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton52.setBackground(new java.awt.Color(255, 153, 0));
        jButton52.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton52.setForeground(new java.awt.Color(51, 51, 51));
        jButton52.setText("Refress");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });
        DomesticRate.add(jButton52, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton53.setBackground(new java.awt.Color(255, 153, 0));
        jButton53.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton53.setForeground(new java.awt.Color(51, 51, 51));
        jButton53.setText("Print");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });
        DomesticRate.add(jButton53, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jPanel31.add(DomesticRate, "card2");

        ExportRate.setBackground(new java.awt.Color(244, 244, 244));
        ExportRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel156.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(51, 51, 51));
        jLabel156.setText("Export: Rate Chart");
        ExportRate.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(51, 51, 51));
        jLabel86.setText("Country From");
        ExportRate.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        txtFromExpCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Bangladesh", "Canada", "England", "Africa" }));
        ExportRate.add(txtFromExpCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 140, 30));

        jButton12.setBackground(new java.awt.Color(255, 153, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(51, 51, 51));
        jButton12.setText("Search");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        ExportRate.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        tableExpRate.setBackground(new java.awt.Color(204, 204, 204));
        tableExpRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tableExpRate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableExpRate.setForeground(new java.awt.Color(51, 51, 51));
        tableExpRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "Countries Name", "Destination Countries", "Weight", "Shiping Option", "Ship Value"
            }
        ));
        tableExpRate.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jScrollPane9.setViewportView(tableExpRate);

        ExportRate.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton13.setBackground(new java.awt.Color(255, 153, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(51, 51, 51));
        jButton13.setText("Refress");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        ExportRate.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton54.setBackground(new java.awt.Color(255, 153, 0));
        jButton54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton54.setForeground(new java.awt.Color(51, 51, 51));
        jButton54.setText("Print");
        jButton54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton54ActionPerformed(evt);
            }
        });
        ExportRate.add(jButton54, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

        jPanel31.add(ExportRate, "card2");

        ImportRate.setBackground(new java.awt.Color(244, 244, 244));
        ImportRate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel158.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(51, 51, 51));
        jLabel158.setText("Import: Rate Chart");
        ImportRate.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(51, 51, 51));
        jLabel143.setText("Country From");
        ImportRate.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 130, 30));

        txtFromImpCountry.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Australia", "Bangladesh", "Canada", "England", "Africa" }));
        ImportRate.add(txtFromImpCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 140, 30));

        jButton21.setBackground(new java.awt.Color(255, 153, 0));
        jButton21.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton21.setForeground(new java.awt.Color(51, 51, 51));
        jButton21.setText("Search");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        ImportRate.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 30));

        tableImpRate.setBackground(new java.awt.Color(204, 204, 204));
        tableImpRate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)));
        tableImpRate.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tableImpRate.setForeground(new java.awt.Color(51, 51, 51));
        tableImpRate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zone", "Countries Name", "Destination Countries", "Weight", "Shiping Option", "Ship Value"
            }
        ));
        tableImpRate.setSelectionBackground(new java.awt.Color(255, 204, 0));
        jScrollPane7.setViewportView(tableImpRate);

        ImportRate.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, 720, 320));

        jButton22.setBackground(new java.awt.Color(255, 153, 0));
        jButton22.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton22.setForeground(new java.awt.Color(51, 51, 51));
        jButton22.setText("Refress");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        ImportRate.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 100, -1));

        jButton55.setBackground(new java.awt.Color(255, 153, 0));
        jButton55.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton55.setForeground(new java.awt.Color(51, 51, 51));
        jButton55.setText("Print");
        jButton55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton55ActionPerformed(evt);
            }
        });
        ImportRate.add(jButton55, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, 100, -1));

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
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        ChangePassPanel.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 100, -1));

        jLabel163.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(51, 51, 51));
        jLabel163.setText("Change Password");
        ChangePassPanel.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        txtOldEmployeePass.setBackground(new java.awt.Color(244, 244, 244));
        txtOldEmployeePass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ChangePassPanel.add(txtOldEmployeePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 180, 30));

        jLabel166.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(51, 51, 51));
        jLabel166.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel166.setText("Type New Password");
        ChangePassPanel.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 170, 30));

        jLabel167.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(51, 51, 51));
        jLabel167.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel167.setText("Re-Type New Password");
        ChangePassPanel.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 170, 30));

        txtNewEmployeeRepass.setBackground(new java.awt.Color(244, 244, 244));
        txtNewEmployeeRepass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNewEmployeeRepass.setForeground(new java.awt.Color(51, 51, 51));
        ChangePassPanel.add(txtNewEmployeeRepass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 180, 30));

        txtNewEmployeePass.setBackground(new java.awt.Color(244, 244, 244));
        txtNewEmployeePass.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtNewEmployeePass.setForeground(new java.awt.Color(51, 51, 51));
        ChangePassPanel.add(txtNewEmployeePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 180, 30));

        jPanel32.add(ChangePassPanel, "card2");

        ProfilePanel.setBackground(new java.awt.Color(244, 244, 244));
        ProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(51, 51, 51));
        jLabel164.setText("Profile Setting");
        ProfilePanel.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 220, 30));

        jButton27.setBackground(new java.awt.Color(255, 153, 0));
        jButton27.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton27.setForeground(new java.awt.Color(51, 51, 51));
        jButton27.setText("Change");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        ProfilePanel.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 100, -1));

        txtEmployeeId3.setBackground(new java.awt.Color(244, 244, 244));
        txtEmployeeId3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(txtEmployeeId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 260, 30));

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

        txtEmployeeName3.setBackground(new java.awt.Color(244, 244, 244));
        txtEmployeeName3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(txtEmployeeName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 260, 30));

        jLabel169.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(51, 51, 51));
        jLabel169.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel169.setText("Address");
        ProfilePanel.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, 30));

        txtEmployeeAddress3.setBackground(new java.awt.Color(244, 244, 244));
        txtEmployeeAddress3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(txtEmployeeAddress3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 260, 30));

        jLabel170.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(51, 51, 51));
        jLabel170.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel170.setText("Contact");
        ProfilePanel.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 130, 30));

        txtEmployeeContact3.setBackground(new java.awt.Color(244, 244, 244));
        txtEmployeeContact3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ProfilePanel.add(txtEmployeeContact3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 260, 30));

        jPanel32.add(ProfilePanel, "card2");

        SetingPanel.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(SetingPanel, "card7");

        UpdateDeletePanel.setBackground(new java.awt.Color(244, 244, 244));
        UpdateDeletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel34.setBackground(new java.awt.Color(244, 244, 244));
        jPanel34.setLayout(new java.awt.CardLayout());

        UpdateDelete.setBackground(new java.awt.Color(244, 244, 244));
        UpdateDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tracking Id");
        UpdateDelete.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 30));

        txtDom01.setEditable(false);
        txtDom01.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom01.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom01, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 200, 30));

        jLabel140.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(51, 51, 51));
        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel140.setText("Product Value");
        UpdateDelete.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, 30));

        txtDom09.setEditable(false);
        txtDom09.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom09.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom09, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 200, 30));

        txtDom10.setEditable(false);
        txtDom10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom10.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 200, 30));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 51));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel43.setText("Shiping Date");
        UpdateDelete.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 100, 30));

        txtDom02.setEditable(false);
        txtDom02.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom02.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom02, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Order Name");
        UpdateDelete.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("From");
        UpdateDelete.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        txtDom03.setEditable(false);
        txtDom03.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom03.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom03, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 200, 30));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(51, 51, 51));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel44.setText("Shiping Type");
        UpdateDelete.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 100, 30));

        txtDom11.setEditable(false);
        txtDom11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom11.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 200, 30));

        txtDom12.setEditable(false);
        txtDom12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom12.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 200, 30));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(51, 51, 51));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel45.setText("Reaching Date");
        UpdateDelete.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 100, 30));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(51, 51, 51));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel54.setText("Shiping Value");
        UpdateDelete.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 100, 30));

        txtDom13.setEditable(false);
        txtDom13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDom13.setForeground(new java.awt.Color(255, 153, 0));
        UpdateDelete.add(txtDom13, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 200, 30));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(51, 51, 51));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel55.setText("Order By");
        UpdateDelete.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 100, 30));

        txtDom14.setEditable(false);
        txtDom14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom14.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom14, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 200, 30));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(51, 51, 51));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel56.setText("Payment By");
        UpdateDelete.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, 100, 30));

        txtDom15.setEditable(false);
        txtDom15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom15.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom15, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 200, 30));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 153, 0));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel57.setText("Change Status");
        UpdateDelete.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 100, 30));

        txtDom16.setEditable(false);
        txtDom16.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom16.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 100, 30));

        comboDomDetails.setBackground(new java.awt.Color(244, 244, 244));
        comboDomDetails.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        comboDomDetails.setForeground(new java.awt.Color(51, 51, 51));
        comboDomDetails.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Shiped", "On Way", "Deleveried" }));
        comboDomDetails.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboDomDetailsItemStateChanged(evt);
            }
        });
        UpdateDelete.add(comboDomDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 90, 30));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(51, 51, 51));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel41.setText("KG");
        UpdateDelete.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 20, 30));

        txtDom08.setEditable(false);
        txtDom08.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom08.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom08, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 110, 30));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(51, 51, 51));
        jLabel142.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel142.setText("Weight");
        UpdateDelete.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 100, 30));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(51, 51, 51));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel38.setText("Product Name");
        UpdateDelete.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 30));

        txtDom07.setEditable(false);
        txtDom07.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom07.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom07, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 200, 30));

        txtDom06.setEditable(false);
        txtDom06.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom06.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom06, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 200, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Address To");
        UpdateDelete.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 100, 30));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 51, 51));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Destination");
        UpdateDelete.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 100, 30));

        txtDom05.setEditable(false);
        txtDom05.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom05.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom05, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 200, 30));

        txtDom04.setEditable(false);
        txtDom04.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtDom04.setForeground(new java.awt.Color(51, 51, 51));
        UpdateDelete.add(txtDom04, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 200, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Address From");
        UpdateDelete.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 100, 30));

        jButton42.setBackground(new java.awt.Color(255, 153, 0));
        jButton42.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton42.setForeground(new java.awt.Color(51, 51, 51));
        jButton42.setText("Back");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });
        UpdateDelete.add(jButton42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 100, -1));

        jButton44.setBackground(new java.awt.Color(255, 153, 0));
        jButton44.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton44.setForeground(new java.awt.Color(51, 51, 51));
        jButton44.setText("Update");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });
        UpdateDelete.add(jButton44, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 100, -1));

        jButton43.setBackground(new java.awt.Color(255, 153, 0));
        jButton43.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jButton43.setForeground(new java.awt.Color(51, 51, 51));
        jButton43.setText("Delete");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });
        UpdateDelete.add(jButton43, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 100, -1));

        txtDetail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDetail.setForeground(new java.awt.Color(51, 51, 51));
        txtDetail.setText("Shiping Details");
        UpdateDelete.add(txtDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 250, 30));

        jPanel34.add(UpdateDelete, "card2");

        UpdateDeletePanel.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 780, 490));

        BodyBgPanel.add(UpdateDeletePanel, "card7");

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
        EmployeePage.this.dispose();
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
        NewShipPanel.setVisible(true);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(false);

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
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(true);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(false);
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
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(true);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(false);
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
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(true);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(false);
        lastMemberId();
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
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(true);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(false);

        InternationalRate();
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
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(true);
        UpdateDeletePanel.setVisible(false);
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:

        //Panel Visible
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        LogoutPage logout = new LogoutPage();
        logout.show();
        EmployeePage.this.dispose();

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

    private void international_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_international_buttonMouseClicked
        // TODO add your handling code here:
        international_button.setBackground(new java.awt.Color(120, 60, 60));
        domestic_bitton.setBackground(new java.awt.Color(255, 153, 0));
        export_button.setBackground(new java.awt.Color(255, 153, 0));
        import_button.setBackground(new java.awt.Color(255, 153, 0));

        InternationalShipPanel.setVisible(true);
        DomesticShipPanel.setVisible(false);
        ExportShipPanel.setVisible(false);
        ImportShipPanel.setVisible(false);
    }//GEN-LAST:event_international_buttonMouseClicked

    private void domestic_bittonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domestic_bittonMouseClicked
        // TODO add your handling code here: 
        international_button.setBackground(new java.awt.Color(255, 153, 0));
        domestic_bitton.setBackground(new java.awt.Color(120, 60, 60));
        export_button.setBackground(new java.awt.Color(255, 153, 0));
        import_button.setBackground(new java.awt.Color(255, 153, 0));

        InternationalShipPanel.setVisible(false);
        DomesticShipPanel.setVisible(true);
        ExportShipPanel.setVisible(false);
        ImportShipPanel.setVisible(false);
    }//GEN-LAST:event_domestic_bittonMouseClicked

    private void international_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_international_buttonMouseEntered
        // TODO add your handling code here:
//        jPanel20.setBackground(new java.awt.Color(120, 60, 60));
    }//GEN-LAST:event_international_buttonMouseEntered

    private void international_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_international_buttonMouseExited
        // TODO add your handling code here:
//        jPanel20.setBackground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_international_buttonMouseExited

    private void domestic_bittonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domestic_bittonMouseEntered
        // TODO add your handling code here:
//        jPanel18.setBackground(new java.awt.Color(120, 60, 60));
    }//GEN-LAST:event_domestic_bittonMouseEntered

    private void domestic_bittonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domestic_bittonMouseExited
        // TODO add your handling code here:
//        jPanel18.setBackground(new java.awt.Color(255, 153, 0));
    }//GEN-LAST:event_domestic_bittonMouseExited

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

        DomesticRate();
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

        InternationalRate();
    }//GEN-LAST:event_InternationalButton04MouseClicked

    private void InternationalButton04MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton04MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton04MouseEntered

    private void InternationalButton04MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InternationalButton04MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_InternationalButton04MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Domestic Shiping Order
        try {
            //Variables start
            String fromNam = fromName.getText();
            String fromD = fromDistrict.getSelectedItem().toString();
            String fromZp = fromZip.getText();
            String fromCty = fromCity.getSelectedItem().toString();
            String fromRod = fromLane.getText();
            String fromAddrs = fromZp + ", " + fromCty + ", " + fromRod;

            String toNam = toName.getText();
            String toD = toDistrict.getSelectedItem().toString();
            String toZp = toZip.getText();
            String toCty = toCity.getSelectedItem().toString();
            String toRod = toLane.getText();
            String toAddrs = toZp + ", " + toCty + ", " + toRod;

            String pNam = txtProductName.getText();
            Double weit = Double.parseDouble(txtWeight.getText());
            int piec = Integer.parseInt(txtpiece.getText());
            String pac = txtPackag.getSelectedItem().toString();

            Double pValu = Double.parseDouble(txtDomProductName.getText());
            try {
                SimpleDateFormat smd = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                java.util.Date d = shipDate.getDate();
                String dt = smd.format(d);
                java.util.Date d1 = smd.parse(dt);
                java.sql.Date sqlShipDate = new java.sql.Date(d1.getTime());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            String opton = txtOption.getSelectedItem().toString();
            String rDate = txtReached.getText();

            Double shipValue = Double.parseDouble(txtShipValue.getText());
            String empName = txtEmpName.getText();
            Double shipcost = shipValue - shipValue * 60 / 100;
            Double revnu = shipValue - shipcost;
            String shipStat = "Shiped";

            String paymentBy = "";
            String lstUpdate = txtEmpName.getText();
            //Variables end
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String insertData = "INSERT INTO domestic_ship (from_name, from_district, from_address, to_name, to_district, to_address, pname, weight, piece, packag, product_value, ship_time, type, reaching_time, ship_value, employee_name, cost, revenue, status, payment_by, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(insertData);
            pst.setString(1, fromNam);
            pst.setString(2, fromD);
            pst.setString(3, fromAddrs);

            pst.setString(4, toNam);
            pst.setString(5, toD);
            pst.setString(6, toAddrs);

            pst.setString(7, pNam);
            pst.setDouble(8, weit);
            pst.setInt(9, piec);
            pst.setString(10, pac);

            pst.setDouble(11, pValu);
            pst.setDate(12, sqlShipDate);
            pst.setString(13, opton);
            pst.setString(14, rDate);

            pst.setDouble(15, shipValue);
            pst.setString(16, empName);
            pst.setDouble(17, shipcost);
            pst.setDouble(18, revnu);
            pst.setString(19, shipStat);
            pst.setString(21, lstUpdate);

            String mony = "BDT";

            PaymentOptionPage payments = new PaymentOptionPage(pst, shipValue, mony);
            payments.show();

        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void shipDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_shipDatePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDatePropertyChange

    private void shipDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_shipDateAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDateAncestorAdded

    //Global Date Variables:---
    java.util.Date shipDat;
    java.sql.Date sqlShipDate;

    java.util.Date richDat;
    java.sql.Date sqlRichDate;
    private void txtOptionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtOptionItemStateChanged
        // TODO add your handling code here:
        String taka = "BDT";
        try {
            SimpleDateFormat smf = new SimpleDateFormat("MMM dd, yyyy");
            java.util.Date sDate = shipDate.getDate();
            String dt = smf.format(sDate);
            shipDat = smf.parse(dt);
            sqlShipDate = new java.sql.Date(shipDat.getTime());

            Calendar calExp = Calendar.getInstance();
            calExp.setTime(smf.parse(dt));
            calExp.add(Calendar.DATE, 1);
            String exDat = smf.format(calExp.getTime());
            java.util.Date expDate = smf.parse(exDat);

            Calendar calGen = Calendar.getInstance();
            calGen.setTime(smf.parse(dt));
            calGen.add(Calendar.DATE, 3);
            String genDat = smf.format(calGen.getTime());
            java.util.Date genDate = smf.parse(genDat);

            int opton = txtOption.getSelectedIndex();
            if (opton == 1) {
                txtReached.setText(exDat);
                richDat = expDate;
                sqlRichDate = new java.sql.Date(expDate.getTime());

                //Expressed Value:--
                Double vl = 40.00;
                int pc = Integer.parseInt(txtpiece.getText());
                Double wt = Double.parseDouble(txtWeight.getText());
                Double shipVal = vl * pc * wt;
                txtShipValue.setText(shipVal.toString());
                txtTK.setText(taka);

            }
            if (opton == 2) {
                txtReached.setText(genDat);
                richDat = genDate;
                sqlRichDate = new java.sql.Date(genDate.getTime());

                //Expressed Value:--
                Double vl = 25.00;
                int pc = Integer.parseInt(txtpiece.getText());
                Double wt = Double.parseDouble(txtWeight.getText());
                Double shipVal = vl * pc * wt;
                txtShipValue.setText(shipVal.toString());
                txtTK.setText(taka);
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }   catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        }


    }//GEN-LAST:event_txtOptionItemStateChanged

    private void fromDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromDistrictItemStateChanged
        // TODO add your handling code here:
        String[] dhakaThanas = {"Gulshan", "Cantonment", "Mirpur"};
        String[] khulnaThanas = {"Halisohor", "Khulna2", "Khulna3"};
        String[] chitThanas = {"Mirsorai", "Hathazari", "chitagong3"};
        int distrc = fromDistrict.getSelectedIndex();
        fromCity.removeAllItems();
        if (distrc == 1) {
            DefaultComboBoxModel dm = new DefaultComboBoxModel(dhakaThanas);
            fromCity.setModel(dm);
        }
        if (distrc == 2) {
            DefaultComboBoxModel dm2 = new DefaultComboBoxModel(khulnaThanas);
            fromCity.setModel(dm2);
        }
        if (distrc == 3) {
            DefaultComboBoxModel dm3 = new DefaultComboBoxModel(chitThanas);
            fromCity.setModel(dm3);
        }
    }//GEN-LAST:event_fromDistrictItemStateChanged

    private void txtProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtProductNameActionPerformed

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtProductNameKeyReleased

    private void toDistrictItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toDistrictItemStateChanged
        // TODO add your handling code here:
        String[] dhakaThanas = {"Gulshan", "Cantonment", "Mirpur"};
        String[] khulnaThanas = {"Halisohor", "Khulna2", "Khulna3"};
        String[] chitThanas = {"Mirsorai", "Hathazari", "chitagong3"};
        int distrc = toDistrict.getSelectedIndex();
        toCity.removeAllItems();
        if (distrc == 1) {
            DefaultComboBoxModel dm = new DefaultComboBoxModel(dhakaThanas);
            toCity.setModel(dm);
        }
        if (distrc == 2) {
            DefaultComboBoxModel dm2 = new DefaultComboBoxModel(khulnaThanas);
            toCity.setModel(dm2);
        }
        if (distrc == 3) {
            DefaultComboBoxModel dm3 = new DefaultComboBoxModel(chitThanas);
            toCity.setModel(dm3);
        }
    }//GEN-LAST:event_toDistrictItemStateChanged

    private void export_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_buttonMouseClicked
        // TODO add your handling code here:
        international_button.setBackground(new java.awt.Color(255, 153, 0));
        domestic_bitton.setBackground(new java.awt.Color(255, 153, 0));
        export_button.setBackground(new java.awt.Color(120, 60, 60));
        import_button.setBackground(new java.awt.Color(255, 153, 0));

        InternationalShipPanel.setVisible(false);
        DomesticShipPanel.setVisible(false);
        ExportShipPanel.setVisible(true);
        ImportShipPanel.setVisible(false);
    }//GEN-LAST:event_export_buttonMouseClicked

    private void export_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_buttonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_export_buttonMouseEntered

    private void export_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_buttonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_export_buttonMouseExited

    private void import_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_buttonMouseClicked
        // TODO add your handling code here:
        international_button.setBackground(new java.awt.Color(255, 153, 0));
        domestic_bitton.setBackground(new java.awt.Color(255, 153, 0));
        export_button.setBackground(new java.awt.Color(255, 153, 0));
        import_button.setBackground(new java.awt.Color(120, 60, 60));

        InternationalShipPanel.setVisible(false);
        DomesticShipPanel.setVisible(false);
        ExportShipPanel.setVisible(false);
        ImportShipPanel.setVisible(true);
    }//GEN-LAST:event_import_buttonMouseClicked

    private void import_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_buttonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_import_buttonMouseEntered

    private void import_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_import_buttonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_import_buttonMouseExited

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

    private void toDistrict1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toDistrict1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_toDistrict1ItemStateChanged

    private void txtOption1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtOption1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption1ItemStateChanged

    private void shipDate1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_shipDate1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDate1AncestorAdded

    private void shipDate1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_shipDate1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDate1PropertyChange

    private void fromDistrict1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromDistrict1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fromDistrict1ItemStateChanged

    private void txtDomPiece1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomPiece1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece1ActionPerformed

    private void txtDomPiece1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDomPiece1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece1KeyReleased

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

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

    private void AddMemberButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseClicked
        // TODO add your handling code here:
        AddMemberButton.setBackground(new java.awt.Color(120, 60, 60));
        MemberInfoButton.setBackground(new java.awt.Color(255, 153, 0));

        AddMemberPanel.setVisible(true);
        MemberInfoPanel.setVisible(false);
        lastMemberId();
    }//GEN-LAST:event_AddMemberButtonMouseClicked

    private void AddMemberButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemberButtonMouseEntered

    private void AddMemberButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AddMemberButtonMouseExited

    private void MemberInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseClicked
        // TODO add your handling code here:
        AddMemberButton.setBackground(new java.awt.Color(255, 153, 0));
        MemberInfoButton.setBackground(new java.awt.Color(120, 60, 60));

        AddMemberPanel.setVisible(false);
        MemberInfoPanel.setVisible(true);
    }//GEN-LAST:event_MemberInfoButtonMouseClicked

    private void MemberInfoButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberInfoButtonMouseEntered

    private void MemberInfoButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MemberInfoButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_MemberInfoButtonMouseExited

    private void txtOption3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtOption3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption3ItemStateChanged

    private void txtDomPiece3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomPiece3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece3ActionPerformed

    private void txtDomPiece3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDomPiece3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece3KeyReleased

    private void toDistrict3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toDistrict3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_toDistrict3ItemStateChanged

    private void txtOption4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtOption4ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption4ItemStateChanged

    private void shipDate3AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_shipDate3AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDate3AncestorAdded

    private void shipDate3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_shipDate3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDate3PropertyChange

    private void txtOption5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_txtOption5ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOption5ItemStateChanged

    private void fromDistrict3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fromDistrict3ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fromDistrict3ItemStateChanged

    private void txtDomPiece4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomPiece4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece4ActionPerformed

    private void txtDomPiece4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDomPiece4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece4KeyReleased

    private void txtDomPiece5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomPiece5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece5ActionPerformed

    private void txtDomPiece5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDomPiece5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomPiece5KeyReleased

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void txtIntProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIntProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntProductNameActionPerformed

    private void txtIntProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIntProductNameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIntProductNameKeyReleased

    private void shipOptionIntItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_shipOptionIntItemStateChanged
        // TODO add your handling code here:
        try {
            SimpleDateFormat smf = new SimpleDateFormat("MMM dd, yyyy");
            java.util.Date sDate = shipDateInt.getDate();
            String dt = smf.format(sDate);
            shipDat = smf.parse(dt);
            sqlShipDate = new java.sql.Date(shipDat.getTime());

            Calendar calExp = Calendar.getInstance();
            calExp.setTime(smf.parse(dt));
            calExp.add(Calendar.DATE, 2);
            String exDat = smf.format(calExp.getTime());
            java.util.Date expDate = smf.parse(exDat);

            Calendar calGen = Calendar.getInstance();
            calGen.setTime(smf.parse(dt));
            calGen.add(Calendar.DATE, 5);
            String genDat = smf.format(calGen.getTime());
            java.util.Date genDate = smf.parse(genDat);

            int optonInt = shipOptionInt.getSelectedIndex();
            if (optonInt == 1) {
                txtIntReachDate.setText(exDat);
                richDat = expDate;
                sqlRichDate = new java.sql.Date(expDate.getTime());

                //Expressed Value:--
                Double vl = 7.00;
                int pc = Integer.parseInt(txtIntPiece.getText());
                Double wt = Double.parseDouble(txtIntWeight.getText());
                Double shipVal = vl * pc * wt;
                txtIntValueShow.setText(shipVal.toString());
                txtIntUsd.setText("USD");

            }
            if (optonInt == 2) {
                txtIntReachDate.setText(genDat);
                richDat = genDate;
                sqlRichDate = new java.sql.Date(genDate.getTime());

                //Expressed Value:--
                Double vl = 4.00;
                int pc = Integer.parseInt(txtIntPiece.getText());
                Double wt = Double.parseDouble(txtIntWeight.getText());
                Double shipVal = vl * pc * wt;
                txtIntValueShow.setText(shipVal.toString());
                txtIntUsd.setText("USD");
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        }
    }//GEN-LAST:event_shipOptionIntItemStateChanged

    private void shipDateIntAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_shipDateIntAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDateIntAncestorAdded

    private void shipDateIntPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_shipDateIntPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_shipDateIntPropertyChange

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel4MouseExited

    private void domesticStatTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domesticStatTableMouseClicked
        // TODO add your handling code here:
        try {
            int row = domesticStatTable.getSelectedRow();
            String table_click = (domesticStatTable.getModel().getValueAt(row, 0).toString());

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getData = "SELECT * FROM fastway.domestic_ship WHERE track_id='" + table_click + "' ";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtDom01.setText(rs.getString(1));
                txtDom02.setText(rs.getString(2));
                txtDom03.setText(rs.getString(3));
                txtDom04.setText(rs.getString(4));
                txtDom05.setText(rs.getString(6));
                txtDom06.setText(rs.getString(7));
                txtDom07.setText(rs.getString(8));
                txtDom08.setText(rs.getString(9));
                txtDom09.setText(rs.getString(12));
                txtDom10.setText(rs.getString(13));
                txtDom11.setText(rs.getString(14));
                txtDom12.setText(rs.getString(15));
                txtDom13.setText(rs.getString(16));
                txtDom14.setText(rs.getString(17));
                txtDom15.setText(rs.getString(21));
                txtDom16.setText(rs.getString(20));

                NewShipPanel.setVisible(false);
                StatusPanel.setVisible(true);
                TrackingPanel.setVisible(false);
                MemberPanel.setVisible(false);
                RatePanel.setVisible(false);
                SetingPanel.setVisible(false);
                UpdateDeletePanel.setVisible(false);
                jPanel34.setVisible(false);

//                Object [] billstat={rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(20), rs.getString(21)};
//                ShipDetailsPrint sdp=new ShipDetailsPrint(billstat);
//                sdp.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_domesticStatTableMouseClicked

    private void internationalStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_internationalStateMouseClicked
        // TODO add your handling code here:
        try {
            int row = internationalState.getSelectedRow();
            String table_click = (internationalState.getModel().getValueAt(row, 0).toString());

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getData = "SELECT * FROM fastway.international_ship WHERE track_id='" + table_click + "' ";
            PreparedStatement pst = c.prepareStatement(getData);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtDom01.setText(rs.getString(1));
                txtDom02.setText(rs.getString(2));
                txtDom03.setText(rs.getString(3));
                txtDom04.setText(rs.getString(4));
                txtDom05.setText(rs.getString(6));
                txtDom06.setText(rs.getString(7));
                txtDom07.setText(rs.getString(8));
                txtDom08.setText(rs.getString(9));
                String pvalue = rs.getString(12) + " USD";
                txtDom09.setText(pvalue);
                txtDom10.setText(rs.getString(13));
                txtDom11.setText(rs.getString(14));
                txtDom12.setText(rs.getString(15));
                String svalue = rs.getString(16) + " USD";
                txtDom13.setText(svalue);
                txtDom14.setText(rs.getString(17));
                txtDom15.setText(rs.getString(21));
                txtDom16.setText(rs.getString(20));

                NewShipPanel.setVisible(false);
                StatusPanel.setVisible(true);
                TrackingPanel.setVisible(false);
                MemberPanel.setVisible(false);
                RatePanel.setVisible(false);
                SetingPanel.setVisible(false);
                UpdateDeletePanel.setVisible(false);
                jPanel34.setVisible(false);

//                Object [] billstat={rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(20), rs.getString(21)};
//                ShipDetailsPrint sdp=new ShipDetailsPrint(billstat);
//                sdp.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_internationalStateMouseClicked

    private void domesticStat4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domesticStat4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_domesticStat4MouseClicked

    private void domesticStat5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domesticStat5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_domesticStat5MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        domstat();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            // TODO add your handling code here:
            domesticStatTable.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        // TODO add your handling code here:
        String intDetail = "International: Shiping Details";
        String domDetail = "Domestic: Shiping Details";
        String intTrack = "International: Tracking Details";
        String domTrack = "Domestic: Tracking Details";
        if (txtDetail.getText() == intDetail) {
            jPanel13.setBackground(new java.awt.Color(48, 24, 24));
            jPanel14.setBackground(new java.awt.Color(98, 49, 49));
            jPanel15.setBackground(new java.awt.Color(48, 24, 24));
            jPanel16.setBackground(new java.awt.Color(48, 24, 24));
            jPanel17.setBackground(new java.awt.Color(48, 24, 24));
            jPanel12.setBackground(new java.awt.Color(48, 24, 24));

            //Panel Visible
            NewShipPanel.setVisible(false);
            StatusPanel.setVisible(true);
            TrackingPanel.setVisible(false);
            MemberPanel.setVisible(false);
            RatePanel.setVisible(false);
            SetingPanel.setVisible(false);
            UpdateDeletePanel.setVisible(false);
            intstat();
        }
        if (txtDetail.getText() == domDetail) {
            InternationalButton02.setBackground(new java.awt.Color(255, 153, 60));
            DomesticButton02.setBackground(new java.awt.Color(120, 60, 60));
            ExportButton02.setBackground(new java.awt.Color(255, 153, 60));
            ImportButton02.setBackground(new java.awt.Color(255, 153, 60));

            InternationalStatus.setVisible(false);
            ExportStatus.setVisible(false);
            ImportStatus.setVisible(false);
            NewShipPanel.setVisible(false);
            StatusPanel.setVisible(true);
            DomesticStatus.setVisible(true);
            TrackingPanel.setVisible(false);
            MemberPanel.setVisible(false);
            RatePanel.setVisible(false);
            SetingPanel.setVisible(false);
            UpdateDeletePanel.setVisible(false);
            domstat();
        }
        if (txtDetail.getText() == intTrack) {
            jPanel13.setBackground(new java.awt.Color(48, 24, 24));
            jPanel14.setBackground(new java.awt.Color(48, 24, 24));
            jPanel15.setBackground(new java.awt.Color(98, 49, 49));
            jPanel16.setBackground(new java.awt.Color(48, 24, 24));
            jPanel17.setBackground(new java.awt.Color(48, 24, 24));
            jPanel12.setBackground(new java.awt.Color(48, 24, 24));
            
            InternationalButton03.setBackground(new java.awt.Color(120, 60, 60));
            DomesticButton03.setBackground(new java.awt.Color(255, 153, 0));
            ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
            ImportButton03.setBackground(new java.awt.Color(255, 153, 0));

            //Panel Visible
            NewShipPanel.setVisible(false);
            StatusPanel.setVisible(false);
            TrackingPanel.setVisible(true);
            MemberPanel.setVisible(false);
            RatePanel.setVisible(false);
            SetingPanel.setVisible(false);
            UpdateDeletePanel.setVisible(false);

            InterTrack.setVisible(true);
            DomesticTrack.setVisible(false);
            ExportTrack.setVisible(false);
            ImportTrack.setVisible(false);
        }
        if (txtDetail.getText() == domTrack) {
            jPanel13.setBackground(new java.awt.Color(48, 24, 24));
            jPanel14.setBackground(new java.awt.Color(48, 24, 24));
            jPanel15.setBackground(new java.awt.Color(98, 49, 49));
            jPanel16.setBackground(new java.awt.Color(48, 24, 24));
            jPanel17.setBackground(new java.awt.Color(48, 24, 24));
            jPanel12.setBackground(new java.awt.Color(48, 24, 24));
            
            InternationalButton03.setBackground(new java.awt.Color(255, 153, 0));
            DomesticButton03.setBackground(new java.awt.Color(120, 60, 60));
            ExportButton03.setBackground(new java.awt.Color(255, 153, 0));
            ImportButton03.setBackground(new java.awt.Color(255, 153, 0));

            //Panel Visible
            NewShipPanel.setVisible(false);
            StatusPanel.setVisible(false);
            TrackingPanel.setVisible(true);
            MemberPanel.setVisible(false);
            RatePanel.setVisible(false);
            SetingPanel.setVisible(false);
            UpdateDeletePanel.setVisible(false);

            InterTrack.setVisible(false);
            DomesticTrack.setVisible(true);
            ExportTrack.setVisible(false);
            ImportTrack.setVisible(false);
        }
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        // TODO add your handling code here:
        String inter = "International: Shiping Details";
        String dom = "Domestic: Shiping Details";
        String exp = "Export: Shiping Details";
        String imp = "Import: Shiping Details";
        
        String inTrack = "International: Trcking Details";
        String dTrack = "Domestic: Tracking Details";
        String exTrack = "Export: Tracking Details";
        String imTrack = "Import: Tracking Details";

        try {
            String stat = comboDomDetails.getSelectedItem().toString();
            int tid = Integer.parseInt(txtDom01.getText());
            Class.forName("com.mysql.jdbc.Driver");

            if (inter.matches(txtDetail.getText()) || inTrack.matches(txtDetail.getText())) {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
                String upData = "DELETE FROM fastway.international_ship WHERE track_id=? ";
                PreparedStatement pst = c.prepareStatement(upData);
                pst.setInt(1, tid);

                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Delete",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                }
                if (response == JOptionPane.YES_OPTION) {
                    int i = pst.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Delete Successful");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Fill Correct Info");
                    }
                }
            }
            if (dom.matches(txtDetail.getText()) || dTrack.matches(txtDetail.getText())) {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
                String upData = "DELETE FROM fastway.domestic_ship WHERE track_id=? ";
                PreparedStatement pst = c.prepareStatement(upData);
                pst.setInt(1, tid);

                int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Delete",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                }
                if (response == JOptionPane.YES_OPTION) {
                    int i = pst.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(null, "Delete Successful");
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Fill Correct Info");
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please select any row from status");
        }
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        // TODO add your handling code here:
        String detail = "Domestic: Shiping Details";
        txtDetail.setText(detail);
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(true);
        jPanel34.setVisible(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void comboDomDetailsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboDomDetailsItemStateChanged
        // TODO add your handling code here:
        String statusChange = comboDomDetails.getSelectedItem().toString();
        txtDom16.setText(statusChange);
    }//GEN-LAST:event_comboDomDetailsItemStateChanged

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        // TODO add your handling code here:
        String inter = "International: Shiping Details";
        String dom = "Domestic: Shiping Details";
        String exp = "Export: Shiping Details";
        String imp = "Import: Shiping Details";
        
        String inTrack = "International: Trcking Details";
        String dTrack = "Domestic: Tracking Details";
        String exTrack = "Export: Tracking Details";
        String imTrack = "Import: Tracking Details";

        try {
            String stat = comboDomDetails.getSelectedItem().toString();
            int tid = Integer.parseInt(txtDom01.getText());
            Class.forName("com.mysql.jdbc.Driver");

            if (inter.matches(txtDetail.getText()) || inTrack.matches(txtDetail.getText())) {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
                String upData = "UPDATE fastway.international_ship SET status=?, last_update=? WHERE track_id=? ";
                PreparedStatement pst = c.prepareStatement(upData);
                pst.setString(1, stat);
                pst.setString(2, txtEmpName.getText());
                pst.setInt(3, tid);
                int i = pst.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Update Complete");
                }
            }
            if (dom.matches(txtDetail.getText()) || dTrack.matches(txtDetail.getText())) {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
                String upData = "UPDATE fastway.domestic_ship SET status=?, last_update=? WHERE track_id=? ";
                PreparedStatement pst = c.prepareStatement(upData);
                pst.setString(1, stat);
                pst.setString(2, txtEmpName.getText());
                pst.setInt(3, tid);
                int i = pst.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(null, "Update Complete");
                }
            }
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please select any row from status");
        }

    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel dtm = (DefaultTableModel) domTrackTable.getModel();
            int domTrackId = Integer.parseInt(txtDomTrackNumber.getText());
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getData = "SELECT * FROM fastway.domestic_ship WHERE track_id=?";
            PreparedStatement pst = c.prepareStatement(getData);
            pst.setInt(1, domTrackId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String addresFrom = rs.getString(3) + ", " + rs.getString(4);
                String addresTo = rs.getString(6) + ", " + rs.getString(7);

                Object[] domTrackInfo = {rs.getInt(1), rs.getString(2), addresFrom, addresTo, rs.getString(16), rs.getString(20)};
                dtm.addRow(domTrackInfo);
            }else{
                JOptionPane.showMessageDialog(null, "Data Doesn't Found! Enter Correct Tracking Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter Your Correct Tracking Number");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton46ActionPerformed
        // TODO add your handling code here:
        String detail = "Domestic: Tracking Details";
        txtDetail.setText(detail);
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(true);
        jPanel34.setVisible(true);
    }//GEN-LAST:event_jButton46ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) domTrackTable.getModel();
        txtDomTrackNumber.setText("");
        dtm.setNumRows(0);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void domTrackTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_domTrackTableMouseClicked
        // TODO add your handling code here:
        try {
            int row = domTrackTable.getSelectedRow();
            String table_click = (domTrackTable.getModel().getValueAt(row, 0).toString());

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "4321");
            String getData = "SELECT * FROM fastway.domestic_ship WHERE track_id=?";
            PreparedStatement pst = c.prepareStatement(getData);
            pst.setString(1, table_click);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtDom01.setText(rs.getString(1));
                txtDom02.setText(rs.getString(2));
                txtDom03.setText(rs.getString(3));
                txtDom04.setText(rs.getString(4));
                txtDom05.setText(rs.getString(6));
                txtDom06.setText(rs.getString(7));
                txtDom07.setText(rs.getString(8));
                txtDom08.setText(rs.getString(9));
                txtDom09.setText(rs.getString(12));
                txtDom10.setText(rs.getString(13));
                txtDom11.setText(rs.getString(14));
                txtDom12.setText(rs.getString(15));
                txtDom13.setText(rs.getString(16));
                txtDom14.setText(rs.getString(17));
                txtDom15.setText(rs.getString(21));
                txtDom16.setText(rs.getString(20));

                NewShipPanel.setVisible(false);
                StatusPanel.setVisible(false);
                TrackingPanel.setVisible(true);
                MemberPanel.setVisible(false);
                RatePanel.setVisible(false);
                SetingPanel.setVisible(false);
                UpdateDeletePanel.setVisible(false);
                jPanel34.setVisible(false);

//                Object [] billstat={rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(20), rs.getString(21)};
//                ShipDetailsPrint sdp=new ShipDetailsPrint(billstat);
//                sdp.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_domTrackTableMouseClicked

    private void jButton45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton45ActionPerformed
        try {
            // TODO add your handling code here:
            domTrackTable.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Printer Not Found!");
        }
    }//GEN-LAST:event_jButton45ActionPerformed

    private void jButton47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton47ActionPerformed
        // TODO add your handling code here:
        try {
            String memberId = txtMemberId.getText();
            String memberName = txtMemberName.getText();
            String memberAddr = txtMemberAddress.getText();
            String memberEmail = txtMemberEmail.getText();
            String memberRepass = txtMemberRepassword.getText();
            String shipOpt = "";
            if (checkExport.isSelected()) {
                shipOpt = "Export";
            }
            if (checkImport.isSelected()) {
                shipOpt = "Import";
            }
            if (checkExport.isSelected() && checkImport.isSelected()) {
                shipOpt = "Export, " + "Import";
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String addMember = "INSERT INTO fastway.member_info (mid, name, address, email, password, ship_option) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(addMember);
            pst.setString(1, memberId);
            pst.setString(2, memberName);
            pst.setString(3, memberAddr);
            pst.setString(4, memberEmail);
            pst.setString(5, memberRepass);
            pst.setString(6, shipOpt);
            int m = pst.executeUpdate();
            if (m > 0) {
                JOptionPane.showMessageDialog(null, "Member Added");
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill Correct Info");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton47ActionPerformed

    private void txtMemberRepasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMemberRepasswordKeyReleased
        // TODO add your handling code here:
        String a = txtMemberPassword.getText();
        String b = txtMemberRepassword.getText();

        if (b.matches(a)) {
            repassmatch.setForeground(Color.green);
            repassmatch.setText("Pass Matched");
        } else {
            repassmatch.setForeground(Color.red);
            repassmatch.setText("Pass not matching");
        }
    }//GEN-LAST:event_txtMemberRepasswordKeyReleased

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        txtMemberId.setText("");
        txtMemberName.setText("");
        txtMemberAddress.setText("");
        txtMemberEmail.setText("");
        txtMemberPassword.setText("");
        txtMemberRepassword.setText("");
        checkExport.setSelected(false);
        checkImport.setSelected(false);
        repassmatch.setText("");
        lastMemberId();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        try {
            String memid = txtMId.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getMemberData = "SELECT * FROM fastway.member_info WHERE mid=?";
            PreparedStatement pst = c.prepareStatement(getMemberData);
            pst.setString(1, memid);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtMemberId2.setText(rs.getString(1));
                txtMemberName2.setText(rs.getString(2));
                txtMemberAddress2.setText(rs.getString(3));
                txtMemberEmail2.setText(rs.getString(4));
                txtMemberPreority.setText(rs.getString(6));
                txtLastShip.setText("None");
                txtLastShipValue.setText("None");
            } else {
                JOptionPane.showMessageDialog(null, "Enter Your Correct Member Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter Your Correct Tracking Number");
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // TODO add your handling code here:
        txtMId.setText("");
        txtMemberId2.setText("");
        txtMemberName2.setText("");
        txtMemberAddress2.setText("");
        txtMemberEmail2.setText("");
        txtMemberPreority.setText("");
        txtLastShip.setText("");
        txtLastShipValue.setText("");
        checkExport2.setSelected(false);
        checkImport2.setSelected(false);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton48ActionPerformed
        // TODO add your handling code here:
        try {
            String mIdd = txtMemberId2.getText();
            String mName = txtMemberName2.getText();
            String mAddr = txtMemberAddress2.getText();
            String mEmail = txtMemberEmail2.getText();
            String shipOpt = "";
            if (checkExport2.isSelected()) {
                shipOpt = "Export";
            }
            if (checkImport2.isSelected()) {
                shipOpt = "Import";
            }
            if (checkExport2.isSelected() && checkImport2.isSelected()) {
                shipOpt = "Export, " + "Import";
            }

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String addMember = "UPDATE fastway.member_info SET name=?, address=?, email=?, ship_option=? WHERE mid=? ";
            PreparedStatement pst = c.prepareStatement(addMember);
            pst.setString(1, mName);
            pst.setString(2, mAddr);
            pst.setString(3, mEmail);
            pst.setString(4, shipOpt);
            pst.setString(5, mIdd);
            int m = pst.executeUpdate();
            if (m > 0) {
                JOptionPane.showMessageDialog(null, "Member Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill Correct Info");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton48ActionPerformed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed
        // TODO add your handling code here:
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String addMember = "DELETE FROM fastway.member_info WHERE mid=? ";
            PreparedStatement pst = c.prepareStatement(addMember);
            pst.setString(1, txtMemberId2.getText());

            int response = JOptionPane.showConfirmDialog(null, "Do you want to Continue?", "Delete!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {

            }
            if (response == JOptionPane.YES_OPTION) {
                int m = pst.executeUpdate();
                if (m > 0) {
                    JOptionPane.showMessageDialog(null, "Member Deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Please Fill Correct Info");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");

            String oldEpass = txtOldEmployeePass.getText();
            String newEpass = txtNewEmployeePass.getText();
            String newERpass = txtNewEmployeeRepass.getText();

            if (newERpass.matches(newEpass)) {
                String addemp = "UPDATE fastway.employee SET password=? WHERE password=? ";
                PreparedStatement pst = c.prepareStatement(addemp);
                pst.setString(1, newERpass);
                pst.setString(2, oldEpass);

                int response = JOptionPane.showConfirmDialog(null, "Do you want to Continue?", "Change Password!",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION) {

                }
                if (response == JOptionPane.YES_OPTION) {
                    int m = pst.executeUpdate();
                    if (m > 0) {
                        JOptionPane.showMessageDialog(null, "Password Changed");
                    } else {
                        JOptionPane.showMessageDialog(null, "Password incorrect!");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password doesn't match!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");

            String empId3 = txtEmployeeId3.getText();
            String empName3 = txtEmployeeName3.getText();
            String empAddr3 = txtEmployeeAddress3.getText();
            String empCon3 = txtEmployeeContact3.getText();

            String addemp = "UPDATE fastway.employee SET name=?, address=?, contact=? WHERE user_id=? ";
            PreparedStatement pst = c.prepareStatement(addemp);
            pst.setString(1, empName3);
            pst.setString(2, empAddr3);
            pst.setString(3, empCon3);
            pst.setString(4, empId3);

            int response = JOptionPane.showConfirmDialog(null, "Do you want to Continue?", "Change Info!",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {

            }
            if (response == JOptionPane.YES_OPTION) {
                int m = pst.executeUpdate();
                if (m > 0) {
                    JOptionPane.showMessageDialog(null, "Info Changed");
                } else {
                    JOptionPane.showMessageDialog(null, "User Id Doesn't Match!");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        InternationalRate();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton50ActionPerformed
        try {
            // TODO add your handling code here:
            tableIntRate.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Printer Not Found!");
        }
    }//GEN-LAST:event_jButton50ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel dtm = (DefaultTableModel) tableIntRate.getModel();
            dtm.setNumRows(0);
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String getData = "SELECT * FROM fastway.international_rate WHERE country_from=?";
            PreparedStatement pst = c.prepareStatement(getData);
            pst.setString(1, txtFromCountry.getSelectedItem().toString());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String rates = String.valueOf(rs.getDouble(6)) + " USD";
                Object[] data = {rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rates};
                dtm.addRow(data);
            }

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "All data are below");
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        // TODO add your handling code here:
        DomesticRate();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        try {
            // TODO add your handling code here:
            tableDomRate.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Printer Not Found!");
        }
    }//GEN-LAST:event_jButton53ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton54ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton55ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            //Variables start
            String fromNam = fromIntName.getText();
            String fromD = originIntCountry.getSelectedItem().toString();
            String fromZp = originIntZip.getText();
            String fromCty = originIntCity.getSelectedItem().toString();
            String fromRod = txtIntFromLane.getText();
            String fromAddrs = fromZp + ", " + fromCty + ", " + fromRod;

            String toNam = toIntName.getText();
            String toD = toIntCountry.getSelectedItem().toString();
            String toZp = toIntZip.getText();
            String toCty = toIntCity.getSelectedItem().toString();
            String toRod = toIntAddress.getText();
            String toAddrs = toZp + ", " + toCty + ", " + toRod;

            String pNam = txtIntProductName.getText();
            Double weit = Double.parseDouble(txtIntWeight.getText());
            int piec = Integer.parseInt(txtIntPiece.getText());
            String pac = packageInt.getSelectedItem().toString();

            Double pValu = Double.parseDouble(txtIntProductValue.getText());
            try {
                SimpleDateFormat smd = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
                java.util.Date d = shipDateInt.getDate();
                String dt = smd.format(d);
                java.util.Date d1 = smd.parse(dt);
                java.sql.Date sqlShipDate = new java.sql.Date(d1.getTime());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            String opton = shipOptionInt.getSelectedItem().toString();
            String rDate = txtIntReachDate.getText();

            Double shipValue = Double.parseDouble(txtIntValueShow.getText());
            String empName = txtEmpName.getText();
            Double shipcost = shipValue - shipValue * 45 / 100;
            Double revnu = shipValue - shipcost;
            String shipStat = "Shiped";

            String paymentBy = "";
            String lstUpdate = txtEmpName.getText();
            //Variables end
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
//            if(c!=null){JOptionPane.showMessageDialog(null, "connected");}
            String insertData = "INSERT INTO international_ship (from_name, from_country, from_address, to_name, to_country, to_address, pname, weight, piece, packag, product_value, ship_time, type, reaching_time, ship_value, employee_name, cost, revenue, status, payment_by, last_update) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(insertData);
            pst.setString(1, fromNam);
            pst.setString(2, fromD);
            pst.setString(3, fromAddrs);

            pst.setString(4, toNam);
            pst.setString(5, toD);
            pst.setString(6, toAddrs);

            pst.setString(7, pNam);
            pst.setDouble(8, weit);
            pst.setInt(9, piec);
            pst.setString(10, pac);

            pst.setDouble(11, pValu);
            pst.setDate(12, sqlShipDate);
            pst.setString(13, opton);
            pst.setString(14, rDate);

            pst.setDouble(15, shipValue);
            pst.setString(16, empName);
            pst.setDouble(17, shipcost);
            pst.setDouble(18, revnu);
            pst.setString(19, shipStat);
            pst.setString(21, lstUpdate);

            String mony = "USD";

            PaymentOptionPage payments = new PaymentOptionPage(pst, shipValue, mony);
            payments.show();

        } catch (NullPointerException ne) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Fill Requiered Field");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void originIntCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_originIntCountryItemStateChanged
        // TODO add your handling code here:
        String[] australiaCity = {"Adelaide", "Brisbane", "Melbourne", "Perth", "Sydney"};
        String[] bangladeshCity = {"Barisal", "Dhaka", "Khulna", "Rajshahi", "Syhlet"};
        String[] canadaCity = {"Alberta", "Manitoba", "Ontario", "Quebec", "Yukon"};
        String[] englandCity = {"Belfast", "Birmingham", "Cambridge", "Derby", "London"};
        String[] africaCity = {"Cape Town", "Cairo", "Durban", "Istanbul", "Johannesburg"};
        int intFromCountry = originIntCountry.getSelectedIndex();
        originIntCity.removeAllItems();
        if (intFromCountry == 1) {
            DefaultComboBoxModel dm = new DefaultComboBoxModel(australiaCity);
            originIntCity.setModel(dm);
        }
        if (intFromCountry == 2) {
            DefaultComboBoxModel dm2 = new DefaultComboBoxModel(bangladeshCity);
            originIntCity.setModel(dm2);
        }
        if (intFromCountry == 3) {
            DefaultComboBoxModel dm3 = new DefaultComboBoxModel(canadaCity);
            originIntCity.setModel(dm3);
        }
        if (intFromCountry == 4) {
            DefaultComboBoxModel dm4 = new DefaultComboBoxModel(englandCity);
            originIntCity.setModel(dm4);
        }
        if (intFromCountry == 5) {
            DefaultComboBoxModel dm5 = new DefaultComboBoxModel(africaCity);
            originIntCity.setModel(dm5);
        }
    }//GEN-LAST:event_originIntCountryItemStateChanged

    private void toIntCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_toIntCountryItemStateChanged
        // TODO add your handling code here:
        String[] australiaCity = {"Adelaide", "Brisbane", "Melbourne", "Perth", "Sydney"};
        String[] bangladeshCity = {"Barisal", "Dhaka", "Khulna", "Rajshahi", "Syhlet"};
        String[] canadaCity = {"Alberta", "Manitoba", "Ontario", "Quebec", "Yukon"};
        String[] englandCity = {"Belfast", "Birmingham", "Cambridge", "Derby", "London"};
        String[] africaCity = {"Cape Town", "Cairo", "Durban", "Istanbul", "Johannesburg"};
        int intToCountry = toIntCountry.getSelectedIndex();
        toIntCity.removeAllItems();
        if (intToCountry == 1) {
            DefaultComboBoxModel dm = new DefaultComboBoxModel(australiaCity);
            toIntCity.setModel(dm);
        }
        if (intToCountry == 2) {
            DefaultComboBoxModel dm2 = new DefaultComboBoxModel(bangladeshCity);
            toIntCity.setModel(dm2);
        }
        if (intToCountry == 3) {
            DefaultComboBoxModel dm3 = new DefaultComboBoxModel(canadaCity);
            toIntCity.setModel(dm3);
        }
        if (intToCountry == 4) {
            DefaultComboBoxModel dm4 = new DefaultComboBoxModel(englandCity);
            toIntCity.setModel(dm4);
        }
        if (intToCountry == 5) {
            DefaultComboBoxModel dm5 = new DefaultComboBoxModel(africaCity);
            toIntCity.setModel(dm5);
        }
    }//GEN-LAST:event_toIntCountryItemStateChanged

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        // TODO add your handling code here:
        String detail = "International: Shiping Details";
        txtDetail.setText(detail);
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(true);
        jPanel34.setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        intstat();
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        try {
            // TODO add your handling code here:
            internationalState.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Printer Not Found!");
        }
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            fromIntName.setText("");
            originIntCountry.setSelectedIndex(0);
            originIntZip.setText("");
            originIntCity.setSelectedIndex(0);
            txtIntFromLane.setText("");

            toIntName.setText("");
            toIntCountry.setSelectedIndex(0);
            toIntZip.setText("");
            toIntCity.setSelectedIndex(0);
            toIntAddress.setText("");

            txtIntProductName.setText("");
            txtIntWeight.setText("");
            txtIntPiece.setText("");
            packageInt.setSelectedIndex(0);

            txtIntProductValue.setText("");
            shipDateInt.setDateFormatString("");
            shipOptionInt.setSelectedIndex(0);
            txtIntReachDate.setText("");

            txtIntValueShow.setText("");
            txtIntUsd.setText("");
        } catch (IndexOutOfBoundsException ix) {
            JOptionPane.showMessageDialog(null, "Enter Your Information");
        } catch (IllegalArgumentException ix) {
            JOptionPane.showMessageDialog(null, "Enter Your Information");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            fromName.setText("");
            fromDistrict.setSelectedIndex(0);
            fromZip.setText("");
            fromCity.setSelectedIndex(0);
            fromLane.setText("");

            toName.setText("");
            toDistrict.setSelectedIndex(0);
            toZip.setText("");
            toCity.setSelectedIndex(0);
            toLane.setText("");

            txtProductName.setText("");
            txtWeight.setText("");
            txtpiece.setText("");
            txtPackag.setSelectedIndex(0);

            txtDomProductName.setText("");
            shipDate.setDateFormatString("");
            txtOption.setSelectedIndex(0);
            txtReached.setText("");

            txtShipValue.setText("");
            txtTK.setText("");
        } catch (IndexOutOfBoundsException ix) {
            JOptionPane.showMessageDialog(null, "Enter Your Information");
        } catch (IllegalArgumentException ix) {
            JOptionPane.showMessageDialog(null, "Enter Your Information");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel dtm = (DefaultTableModel) tableIntTrack.getModel();
            int intTrackId = Integer.parseInt(txtIntTrack.getText());
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getData = "SELECT * FROM fastway.international_ship WHERE track_id=?";
            PreparedStatement pst = c.prepareStatement(getData);
            pst.setInt(1, intTrackId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String addresFrom = rs.getString(3) + ", " + rs.getString(4);
                String addresTo = rs.getString(6) + ", " + rs.getString(7);

                Object[] intTrackInfo = {rs.getInt(1), rs.getString(2), addresFrom, addresTo, rs.getString(16), rs.getString(20)};
                dtm.addRow(intTrackInfo);
            }else{
                JOptionPane.showMessageDialog(null, "Data Doesn't Found! Enter Correct Tracking Id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Enter Your Correct Tracking Number");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tableIntTrackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableIntTrackMouseClicked
        // TODO add your handling code here:
        try {
            int row = tableIntTrack.getSelectedRow();
            String table_click = (tableIntTrack.getModel().getValueAt(row, 0).toString());

            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/fastway", "root", "root");
            String getData = "SELECT * FROM fastway.international_ship WHERE track_id=?";
            PreparedStatement pst = c.prepareStatement(getData);
            pst.setString(1, table_click);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtDom01.setText(rs.getString(1));
                txtDom02.setText(rs.getString(2));
                txtDom03.setText(rs.getString(3));
                txtDom04.setText(rs.getString(4));
                txtDom05.setText(rs.getString(6));
                txtDom06.setText(rs.getString(7));
                txtDom07.setText(rs.getString(8));
                txtDom08.setText(rs.getString(9));
                String pmony = rs.getString(12) + " USD";
                txtDom09.setText(pmony);
                txtDom10.setText(rs.getString(13));
                txtDom11.setText(rs.getString(14));
                txtDom12.setText(rs.getString(15));
                String smony = rs.getString(16) + " USD";
                txtDom13.setText(smony);
                txtDom14.setText(rs.getString(17));
                txtDom15.setText(rs.getString(21));
                txtDom16.setText(rs.getString(20));

                NewShipPanel.setVisible(false);
                StatusPanel.setVisible(false);
                TrackingPanel.setVisible(true);
                MemberPanel.setVisible(false);
                RatePanel.setVisible(false);
                SetingPanel.setVisible(false);
                UpdateDeletePanel.setVisible(false);
                jPanel34.setVisible(false);

//                Object [] billstat={rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(20), rs.getString(21)};
//                ShipDetailsPrint sdp=new ShipDetailsPrint(billstat);
//                sdp.setVisible(true);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tableIntTrackMouseClicked

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) tableIntTrack.getModel();
        txtIntTrack.setText("");
        dtm.setNumRows(0);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton56ActionPerformed
        // TODO add your handling code here:
        String detail = "International: Tracking Details";
        txtDetail.setText(detail);
        NewShipPanel.setVisible(false);
        StatusPanel.setVisible(false);
        TrackingPanel.setVisible(false);
        MemberPanel.setVisible(false);
        RatePanel.setVisible(false);
        SetingPanel.setVisible(false);
        UpdateDeletePanel.setVisible(true);
        jPanel34.setVisible(true);
    }//GEN-LAST:event_jButton56ActionPerformed

    private void jButton57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton57ActionPerformed
        // TODO add your handling code here:
        try {
            tableIntTrack.print();
        } catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Printer Not Found!");
        }

    }//GEN-LAST:event_jButton57ActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddMemberButton;
    private javax.swing.JPanel AddMemberPanel;
    private javax.swing.JPanel BodyBgPanel;
    private javax.swing.JPanel ChangePassButton;
    private javax.swing.JPanel ChangePassPanel;
    private javax.swing.JLabel Copyright;
    private javax.swing.JPanel DomesticButton02;
    private javax.swing.JPanel DomesticButton03;
    private javax.swing.JPanel DomesticButton04;
    private javax.swing.JPanel DomesticRate;
    private javax.swing.JPanel DomesticShipPanel;
    private javax.swing.JPanel DomesticStatus;
    private javax.swing.JPanel DomesticTrack;
    private javax.swing.JPanel ExportButton02;
    private javax.swing.JPanel ExportButton03;
    private javax.swing.JPanel ExportButton04;
    private javax.swing.JPanel ExportRate;
    private javax.swing.JPanel ExportShipPanel;
    private javax.swing.JPanel ExportStatus;
    private javax.swing.JPanel ExportTrack;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeaderPanel;
    private javax.swing.JPanel ImportButton02;
    private javax.swing.JPanel ImportButton03;
    private javax.swing.JPanel ImportButton04;
    private javax.swing.JPanel ImportRate;
    private javax.swing.JPanel ImportShipPanel;
    private javax.swing.JPanel ImportStatus;
    private javax.swing.JPanel ImportTrack;
    private javax.swing.JPanel InterTrack;
    private javax.swing.JPanel InternationalButton02;
    private javax.swing.JPanel InternationalButton03;
    private javax.swing.JPanel InternationalButton04;
    private javax.swing.JPanel InternationalRate;
    private javax.swing.JPanel InternationalShipPanel;
    private javax.swing.JPanel InternationalStatus;
    private javax.swing.JPanel LeftSidePanel;
    private javax.swing.JPanel MemberInfoButton;
    private javax.swing.JPanel MemberInfoPanel;
    private javax.swing.JPanel MemberPanel;
    private javax.swing.JPanel NewShipPanel;
    private javax.swing.JPanel ProfileButton;
    private javax.swing.JPanel ProfilePanel;
    private javax.swing.JPanel RatePanel;
    private javax.swing.JPanel SetingPanel;
    private javax.swing.JPanel StatusPanel;
    private javax.swing.JPanel TrackingPanel;
    private javax.swing.JPanel UpdateDelete;
    private javax.swing.JPanel UpdateDeletePanel;
    private javax.swing.JCheckBox checkExport;
    private javax.swing.JCheckBox checkExport2;
    private javax.swing.JCheckBox checkImport;
    private javax.swing.JCheckBox checkImport2;
    private javax.swing.JComboBox<String> comboDomDetails;
    private javax.swing.JTable domTrackTable;
    private javax.swing.JTable domesticStat4;
    private javax.swing.JTable domesticStat5;
    private javax.swing.JTable domesticStatTable;
    private javax.swing.JPanel domestic_bitton;
    private javax.swing.JPanel export_button;
    private javax.swing.JPanel from1;
    private javax.swing.JPanel from10;
    private javax.swing.JPanel from11;
    private javax.swing.JPanel from12;
    private javax.swing.JPanel from13;
    private javax.swing.JPanel from14;
    private javax.swing.JPanel from17;
    private javax.swing.JPanel from18;
    private javax.swing.JPanel from19;
    private javax.swing.JPanel from20;
    private javax.swing.JPanel from3;
    private javax.swing.JPanel from5;
    private javax.swing.JPanel from6;
    private javax.swing.JPanel from7;
    private javax.swing.JPanel from8;
    private javax.swing.JPanel from9;
    private javax.swing.JComboBox<String> fromCity;
    private javax.swing.JComboBox<String> fromCity1;
    private javax.swing.JComboBox<String> fromCity3;
    private javax.swing.JComboBox<String> fromDistrict;
    private javax.swing.JComboBox<String> fromDistrict1;
    private javax.swing.JComboBox<String> fromDistrict3;
    private javax.swing.JTextField fromIntName;
    private javax.swing.JTextField fromLane;
    private javax.swing.JTextField fromLane1;
    private javax.swing.JTextField fromLane3;
    private javax.swing.JTextField fromName;
    private javax.swing.JTextField fromName1;
    private javax.swing.JTextField fromName4;
    private javax.swing.JTextField fromZip;
    private javax.swing.JTextField fromZip1;
    private javax.swing.JTextField fromZip3;
    private javax.swing.JPanel import_button;
    private javax.swing.JTable internationalState;
    private javax.swing.JPanel international_button;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton50;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JButton jButton54;
    private javax.swing.JButton jButton55;
    private javax.swing.JButton jButton56;
    private javax.swing.JButton jButton57;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox23;
    private javax.swing.JComboBox<String> jComboBox24;
    private javax.swing.JComboBox<String> jComboBox25;
    private javax.swing.JComboBox<String> jComboBox26;
    private javax.swing.JComboBox<String> jComboBox27;
    private javax.swing.JComboBox<String> jComboBox28;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel158;
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
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
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
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
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
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JComboBox<String> originIntCity;
    private javax.swing.JComboBox<String> originIntCountry;
    private javax.swing.JTextField originIntZip;
    private javax.swing.JComboBox<String> packageInt;
    private javax.swing.JLabel repassmatch;
    private com.toedter.calendar.JDateChooser shipDate;
    private com.toedter.calendar.JDateChooser shipDate1;
    private com.toedter.calendar.JDateChooser shipDate3;
    private com.toedter.calendar.JDateChooser shipDateInt;
    private javax.swing.JComboBox<String> shipOptionInt;
    private javax.swing.JTable tableDomRate;
    private javax.swing.JTable tableExpRate;
    private javax.swing.JTable tableImpRate;
    private javax.swing.JTable tableIntRate;
    private javax.swing.JTable tableIntTrack;
    private javax.swing.JComboBox<String> toCity;
    private javax.swing.JComboBox<String> toCity1;
    private javax.swing.JComboBox<String> toCity3;
    private javax.swing.JComboBox<String> toDistrict;
    private javax.swing.JComboBox<String> toDistrict1;
    private javax.swing.JComboBox<String> toDistrict3;
    private javax.swing.JTextField toIntAddress;
    private javax.swing.JComboBox<String> toIntCity;
    private javax.swing.JComboBox<String> toIntCountry;
    private javax.swing.JTextField toIntName;
    private javax.swing.JTextField toIntZip;
    private javax.swing.JTextField toLane;
    private javax.swing.JTextField toLane1;
    private javax.swing.JTextField toLane3;
    private javax.swing.JTextField toName;
    private javax.swing.JTextField toName1;
    private javax.swing.JTextField toName4;
    private javax.swing.JTextField toZip;
    private javax.swing.JTextField toZip1;
    private javax.swing.JTextField toZip3;
    private javax.swing.JLabel txtDetail;
    private javax.swing.JTextField txtDom01;
    private javax.swing.JTextField txtDom02;
    private javax.swing.JTextField txtDom03;
    private javax.swing.JTextField txtDom04;
    private javax.swing.JTextField txtDom05;
    private javax.swing.JTextField txtDom06;
    private javax.swing.JTextField txtDom07;
    private javax.swing.JTextField txtDom08;
    private javax.swing.JTextField txtDom09;
    private javax.swing.JTextField txtDom10;
    private javax.swing.JTextField txtDom11;
    private javax.swing.JTextField txtDom12;
    private javax.swing.JTextField txtDom13;
    private javax.swing.JTextField txtDom14;
    private javax.swing.JTextField txtDom15;
    private javax.swing.JTextField txtDom16;
    private javax.swing.JTextField txtDomPiece1;
    private javax.swing.JTextField txtDomPiece3;
    private javax.swing.JTextField txtDomPiece4;
    private javax.swing.JTextField txtDomPiece5;
    private javax.swing.JTextField txtDomProductName;
    private javax.swing.JTextField txtDomTrackNumber;
    private javax.swing.JLabel txtEmpName;
    private javax.swing.JTextField txtEmployeeAddress3;
    private javax.swing.JTextField txtEmployeeContact3;
    private javax.swing.JTextField txtEmployeeId3;
    private javax.swing.JTextField txtEmployeeName3;
    private javax.swing.JComboBox<String> txtFromCountry;
    private javax.swing.JComboBox<String> txtFromDistrict;
    private javax.swing.JComboBox<String> txtFromExpCountry;
    private javax.swing.JComboBox<String> txtFromImpCountry;
    private javax.swing.JTextField txtIntFromLane;
    private javax.swing.JTextField txtIntPiece;
    private javax.swing.JTextField txtIntProductName;
    private javax.swing.JTextField txtIntProductValue;
    private javax.swing.JTextField txtIntReachDate;
    private javax.swing.JTextField txtIntTrack;
    private javax.swing.JLabel txtIntUsd;
    private javax.swing.JLabel txtIntValueShow;
    private javax.swing.JTextField txtIntWeight;
    private javax.swing.JTextField txtLastMemberId;
    private javax.swing.JTextField txtLastShip;
    private javax.swing.JTextField txtLastShipValue;
    private javax.swing.JTextField txtMId;
    private javax.swing.JTextField txtMemberAddress;
    private javax.swing.JTextField txtMemberAddress2;
    private javax.swing.JTextField txtMemberEmail;
    private javax.swing.JTextField txtMemberEmail2;
    private javax.swing.JTextField txtMemberId;
    private javax.swing.JTextField txtMemberId2;
    private javax.swing.JTextField txtMemberName;
    private javax.swing.JTextField txtMemberName2;
    private javax.swing.JPasswordField txtMemberPassword;
    private javax.swing.JTextField txtMemberPreority;
    private javax.swing.JPasswordField txtMemberRepassword;
    private javax.swing.JPasswordField txtNewEmployeePass;
    private javax.swing.JPasswordField txtNewEmployeeRepass;
    private javax.swing.JTextField txtOldEmployeePass;
    private javax.swing.JComboBox<String> txtOption;
    private javax.swing.JComboBox<String> txtOption1;
    private javax.swing.JComboBox<String> txtOption3;
    private javax.swing.JComboBox<String> txtOption4;
    private javax.swing.JComboBox<String> txtOption5;
    private javax.swing.JComboBox<String> txtPackag;
    private javax.swing.JComboBox<String> txtPackag1;
    private javax.swing.JComboBox<String> txtPackag3;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtReached;
    private javax.swing.JTextField txtReached1;
    private javax.swing.JTextField txtReached3;
    private javax.swing.JLabel txtShipValue;
    private javax.swing.JLabel txtShipValue1;
    private javax.swing.JLabel txtShipValue3;
    private javax.swing.JLabel txtTK;
    private javax.swing.JLabel txtTK1;
    private javax.swing.JLabel txtTK3;
    private javax.swing.JTextField txtWeight;
    private javax.swing.JTextField txtWeight1;
    private javax.swing.JTextField txtWeight3;
    private javax.swing.JTextField txtpiece;
    // End of variables declaration//GEN-END:variables
}
