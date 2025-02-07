/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.awt.print.PrinterException;
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

public class BillPrint extends javax.swing.JFrame {

    String id=BillLDetails.id;
    String nm;
    String mobileno;
    //String email;
    String roomnumber;
    String bedtype;
    String roomtype;
    String indate;
    String outdate;
    String price;
    String days;
    String amount;
    public BillPrint() {
        initComponents();
        Connect();
        txtbill.setText("\t\t-: HOTEL MANAGEMENT SYSTEM :-\n");
        txtbill.setText(txtbill.getText()+"********************************************************************\n");
        txtbill.setText(txtbill.getText()+"Bill ID:- "+id+"\n");
        txtbill.setText(txtbill.getText()+"Customer Details:- \n");
        txtbill.setText(txtbill.getText()+"Name:- "+nm+"\n");
        txtbill.setText(txtbill.getText()+"Mobile Number:- "+mobileno+"\n");
        //txtbill.setText(txtbill.getText()+"Email:- "+email+"\n");
        txtbill.setText(txtbill.getText()+"********************************************************************\n");
        txtbill.setText(txtbill.getText()+"Room Details:- \n");
        txtbill.setText(txtbill.getText()+"Room Number:- "+roomnumber+"\n");
        txtbill.setText(txtbill.getText()+"Room Type:- "+roomtype+"\n");
        txtbill.setText(txtbill.getText()+"Bed Type:- "+bedtype+"\n");
        txtbill.setText(txtbill.getText()+"Price:- "+price+"\n");
        txtbill.setText(txtbill.getText()+"Check In Date:- "+indate+"\t\tNumber of Days="+days+"\n");
        txtbill.setText(txtbill.getText()+"Check Out Date:- "+outdate+"\t\tTotal Amount="+amount+"\n");
        txtbill.setText(txtbill.getText()+"********************************************************************\n");
        txtbill.setText(txtbill.getText()+"\t\t"+"                           Thank You ,Please Visit Again.");
    }
public void Connect(){
    PreparedStatement pst;
    ResultSet rs;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
         java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","kopal@1904");
         pst=con.prepareStatement("Select * from customer where billid=?");
         pst.setString(1,id);
         rs=pst.executeQuery();
         if(rs.next()){
          // email= rs.getString("email");
           nm= rs.getString("name");
           mobileno= rs.getString("mobileno");
           roomnumber= rs.getString("roomnumber");
           bedtype= rs.getString("bedtype");
           roomtype= rs.getString("roomtype");
           indate= rs.getString("indate");
           outdate= rs.getString("outdate");
           price= rs.getString("price");
           days= rs.getString("days");
           amount= rs.getString("amount");
         }
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
    }
           
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbill = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtbill.setEditable(false);
        txtbill.setColumns(20);
        txtbill.setRows(5);
        jScrollPane1.setViewportView(txtbill);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 63, 720, 425));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 6, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 513, 110, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\ll.png")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 560));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            txtbill.print();
        } catch (PrinterException ex) {
            Logger.getLogger(BillPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtbill;
    // End of variables declaration//GEN-END:variables
}
