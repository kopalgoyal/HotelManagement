/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class Checkout extends javax.swing.JFrame {

    Connection con=null;
   Statement st=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
    public Checkout() {
        initComponents();
        SimpleDateFormat obj=new SimpleDateFormat("yyyy-MM-dd");
        Date date= new Date();
        txtcheckoutdate.setText(obj.format(date));
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","kopal@1904");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
       }
        showDataIntoTable();
    }
   public void showDataIntoTable(){
        try {
            pst=con.prepareStatement("select * from customer where status=?");
            pst.setString(1, "NULL");
            rs=pst.executeQuery();
            ResultSetMetaData ob=rs.getMetaData();
            int n=ob.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v=new Vector();
                for(int i=1;i<n;i++){
                    v.add(rs.getString("name"));
                       v.add(rs.getString("mobileno"));                  
                   v.add(rs.getString("id"));
                    v.add(rs.getString("roomnumber"));
                     v.add(rs.getString("bedtype"));
                      v.add(rs.getString("roomtype"));
                       v.add(rs.getString("indate"));
                       v.add(rs.getString("price"));
                       v.add(rs.getString("nationality"));
                       
                }
                df.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtroomnumber = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmobilenumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtaadharnumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcheckindate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcheckoutdate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtnumberofdays = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttotalamount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1163, 0, 97, -1));

        jLabel1.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CUSTOMER CHECK OUT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 270, -1));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ROOM NUMBER");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 170, 23));

        txtroomnumber.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtroomnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomnumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 140, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setText("SEARCH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 100, -1));

        jLabel3.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CUSTOMER NAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 129, 180, 30));

        txtname.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 180, -1));

        jLabel4.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MOBILE NUMBER");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 170, 20));

        txtmobilenumber.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtmobilenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(386, 180, 160, -1));

        jLabel5.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("AADHAR NUMBER");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 180, -1));

        txtaadharnumber.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtaadharnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 170, -1));

        jLabel6.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRICE PER DAY");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 160, -1));

        txtprice.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 190, -1));

        jLabel7.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CHECK IN DATE");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 160, -1));

        txtcheckindate.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtcheckindate, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 150, -1));

        jLabel8.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("CHECK OUT DATE(TODAY)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, -1, 30));

        txtcheckoutdate.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtcheckoutdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 180, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CUSTOMER NAME", "MOBILE NO", "AADHAR NUMBER", "ROOM NUMBER", "BED TYPE", "ROOM TYPE", "CHECK IN DATE", "PRICE PER DAY", "Nationality"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 410, 1210, 380));

        jButton3.setBackground(new java.awt.Color(255, 0, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setText("CHECK OUT NOW");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 170, -1));

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 360, 100, -1));

        jLabel9.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("NUMBER OF DAYS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 130, 180, -1));

        txtnumberofdays.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txtnumberofdays, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 180, 170, -1));

        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TOTAL AMOUNT");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 250, 170, -1));

        txttotalamount.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        getContentPane().add(txttotalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 170, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\dd.png")); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtroomnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomnumberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
            pst=con.prepareStatement("Select * from customer where roomnumber=? and status=?");
            pst.setString(1, txtroomnumber.getText());
            pst.setString(2, "NULL");
            rs=pst.executeQuery();
            if(rs.next()){
                txtname.setText(rs.getString("name"));
                txtmobilenumber.setText(rs.getString("mobileno"));
                txtaadharnumber.setText(rs.getString("id"));
                txtprice.setText(rs.getString("price"));
                txtcheckindate.setText(rs.getString("indate"));
                
            }
            String s1,s2;
            s1=txtcheckoutdate.getText();
            s2=rs.getString("indate");
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            Date d1=format.parse(s1);
            Date d2=format.parse(s2);
            long diff=d1.getTime()-d2.getTime();
            int days=(int)diff/(24*60*60*1000);
            if(days==0)
                days=1;
            txtnumberofdays.setText(String.valueOf(days));
            double price=Double.parseDouble(rs.getString("price"))*days;
            txttotalamount.setText(String.valueOf(price));
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        txtname.setText("");
        txtmobilenumber.setText("");
        txtaadharnumber.setText("");
        txtprice.setText("");
        txtnumberofdays.setText("");
        txtcheckindate.setText("");
      //  txtcheckoutdate.setText("");
        txttotalamount.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
        try {      
            pst=con.prepareStatement("update customer set outdate=? where roomnumber=? and indate=?");
            pst.setString(1,txtcheckoutdate.getText());
            pst.setString(2,txtroomnumber.getText());
            pst.setString(3,txtcheckindate.getText());
            pst.executeUpdate();
            pst=con.prepareStatement("update customer set amount=? where roomnumber=? and indate=?");
            pst.setString(1,txttotalamount.getText());
            pst.setString(2,txtroomnumber.getText());
            pst.setString(3,txtcheckindate.getText());
            pst.executeUpdate();
            pst=con.prepareStatement("update customer set days=? where roomnumber=? and indate=?");
            pst.setString(1,txtnumberofdays.getText());
            pst.setString(2,txtroomnumber.getText());
            pst.setString(3,txtcheckindate.getText());
            pst.executeUpdate();
            pst=con.prepareStatement("update customer set status=? where roomnumber=? and indate=?");
            pst.setString(1,"CHECK-OUT");
            pst.setString(2,txtroomnumber.getText());
            pst.setString(3,txtcheckindate.getText());
            pst.executeUpdate();
            pst=con.prepareStatement("update room set status=? where roomnumber=?");
             pst.setString(1,"NOT-BOOKED");
            pst.setString(2,txtroomnumber.getText());
             pst.executeUpdate();
                                  
            JOptionPane.showMessageDialog(this,"Check Out Successfully");
            showDataIntoTable();
            
            txtname.setText("");
        txtmobilenumber.setText("");
        txtaadharnumber.setText("");
        txtprice.setText("");
        txtnumberofdays.setText("");
        txtcheckindate.setText("");
      //  txtcheckoutdate.setText("");
        txttotalamount.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    

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
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checkout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checkout().setVisible(true);
}
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtaadharnumber;
    private javax.swing.JTextField txtcheckindate;
    private javax.swing.JTextField txtcheckoutdate;
    private javax.swing.JTextField txtmobilenumber;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnumberofdays;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtroomnumber;
    private javax.swing.JTextField txttotalamount;
    // End of variables declaration//GEN-END:variables
}
