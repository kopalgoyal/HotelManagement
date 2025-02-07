/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */

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
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
public class ManageRoom extends javax.swing.JFrame {
   Connection con=null;
   Statement st=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
   
    public ManageRoom() {
        initComponents();
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotels","root","kopal@1904");
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
       }
       ShowRecordInTable();
    }
    public void ShowRecordInTable(){
        int c=0;
       try {
           pst=con.prepareStatement("select * from room ");
           rs=pst.executeQuery();
           ResultSetMetaData rsmd=rs.getMetaData();
           c=rsmd.getColumnCount();
           DefaultTableModel DModel=(DefaultTableModel) jTable1.getModel();
           DModel.setRowCount(0);
           while(rs.next()){
               Vector column=new Vector();
               for(int i=1;i<=c;i++){
                   column.add(rs.getString("roomnumber"));
                   column.add(rs.getString("roomtype"));
                   column.add(rs.getString("bedtype"));
                   column.add(rs.getString("price"));
                   column.add(rs.getString("status"));
               }
               DModel.addRow(column);
           }
       } catch (SQLException ex) {
           Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtroomnumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboroomtype = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtprice = new javax.swing.JTextField();
        jCombobedtype = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 204));
        jLabel2.setText("Manage Room");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, 330, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Room Number", "Room Type", "Bed Type", "Price", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1230, 490));

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1155, 0, 90, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROOM NUMBER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 586, 200, 30));

        txtroomnumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtroomnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtroomnumberActionPerformed(evt);
            }
        });
        getContentPane().add(txtroomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 190, -1));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ROOM TYPE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 140, 40));

        jComboroomtype.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jComboroomtype.setForeground(new java.awt.Color(255, 255, 255));
        jComboroomtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "NON AC" }));
        jComboroomtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboroomtypeActionPerformed(evt);
            }
        });
        getContentPane().add(jComboroomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 650, 160, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Maiandra GD", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BED TYPE");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 710, 190, -1));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRICE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 720, 130, -1));

        txtprice.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        txtprice.setForeground(new java.awt.Color(0, 51, 51));
        txtprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpriceActionPerformed(evt);
            }
        });
        getContentPane().add(txtprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 770, 160, -1));

        jCombobedtype.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        jCombobedtype.setForeground(new java.awt.Color(255, 255, 255));
        jCombobedtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Double" }));
        getContentPane().add(jCombobedtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 770, 190, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jButton2.setText("Add Room Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 630, 260, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\rr.png")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtroomnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtroomnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtroomnumberActionPerformed

    private void txtpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpriceActionPerformed

    private void jComboroomtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboroomtypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboroomtypeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(txtroomnumber.getText().equals("")){
            JOptionPane.showMessageDialog(this,"All Field is required");
            txtroomnumber.requestFocus();
        }else if(txtprice.getText().equals("")){
            JOptionPane.showMessageDialog(this,"All Field is required");
            txtprice.requestFocus();
        }else{
            try {
                pst=con.prepareStatement("select * from room where roomnumber=?");
                pst.setString(1,txtroomnumber.getText());
                rs=pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this,"Room Number Already Exits");
                }
                else{
                    pst=con.prepareStatement("insert into room(roomnumber,roomtype,bedtype,price,status)values(?,?,?,?,?)");
               pst.setString(1,txtroomnumber.getText());
               pst.setString(2,jComboroomtype.getItemAt(jComboroomtype.getSelectedIndex()));
               pst.setString(3,jCombobedtype.getItemAt(jCombobedtype.getSelectedIndex()));
               pst.setString(4,txtprice.getText());
              pst.setString(5, "NOT-BOOKED");
              pst.executeUpdate();
              JOptionPane.showMessageDialog(this,"Room Added");
              ShowRecordInTable();
              txtroomnumber.setText("");
              txtprice.setText("");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageRoom.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCombobedtype;
    private javax.swing.JComboBox<String> jComboroomtype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtprice;
    private javax.swing.JTextField txtroomnumber;
    // End of variables declaration//GEN-END:variables
}
