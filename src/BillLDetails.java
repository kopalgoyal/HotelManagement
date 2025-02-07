
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class BillLDetails extends javax.swing.JFrame {

   Connection con=null;
   Statement st=null;
   PreparedStatement pst=null;
   ResultSet rs=null;
   static String id;
   
    public BillLDetails() {
        initComponents();
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
            pst.setString(1, "CHECK-OUT");
            rs=pst.executeQuery();
            ResultSetMetaData ob=rs.getMetaData();
            int n=ob.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v=new Vector();
                for(int i=1;i<n;i++){
                     v.add(rs.getString("billid"));
                      v.add(rs.getString("roomnumber"));
                       v.add(rs.getString("name"));
                        v.add(rs.getString("mobileno"));
                         v.add(rs.getString("gender"));
                          v.add(rs.getString("nationality"));
                           v.add(rs.getString("id"));
                            v.add(rs.getString("indate"));
                             v.add(rs.getString("outdate"));
                              v.add(rs.getString("price"));
                               v.add(rs.getString("days"));
                                v.add(rs.getString("amount"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtcheckoutdetails = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(204, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 0, 51));
        jButton1.setText("CLOSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1176, 0, -1, -1));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("CUSTOMER BILL DETAILS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 540, 50));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "BILL ID", "ROOM NUMBER", "CUSTOMER NAME", "MOBILE NUMBER", "GENDER", "NATIONALITY", "AADHAR NUMBER", "CHECK IN DATE", "CHECKOUT DATE", "PRICE", "NUMBER OF DAYS", "TOTAL AMOUNT"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 253, 1188, 550));

        jLabel2.setFont(new java.awt.Font("Eras Bold ITC", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("SEARCH BY CHECK OUT DETAILS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 340, 40));

        txtcheckoutdetails.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        txtcheckoutdetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcheckoutdetailsActionPerformed(evt);
            }
        });
        getContentPane().add(txtcheckoutdetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 210, -1));

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton2.setText("SEARCH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, 140, -1));

        jButton3.setBackground(new java.awt.Color(255, 51, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton3.setText("REFRESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 180, 150, -1));

        jLabel3.setFont(new java.awt.Font("Colonna MT", 1, 24)); // NOI18N
        jLabel3.setText("DOUBLE CLICK ON ROW TO OPEN BILL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\LENOVO\\OneDrive\\Desktop\\l.png")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcheckoutdetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcheckoutdetailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcheckoutdetailsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        showDataIntoTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            pst=con.prepareStatement("select * from customer where status=? and outdate=?");
            pst.setString(1, "CHECK-OUT");
            pst.setString(2, txtcheckoutdetails.getText());
            rs=pst.executeQuery();
            ResultSetMetaData ob=rs.getMetaData();
            int n=ob.getColumnCount();
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v=new Vector();
                for(int i=1;i<n;i++){
                     v.add(rs.getString("billid"));
                      v.add(rs.getString("roomnumber"));
                       v.add(rs.getString("name"));
                        v.add(rs.getString("mobileno"));
                         v.add(rs.getString("gender"));
                          v.add(rs.getString("nationality"));
                           v.add(rs.getString("id"));
                            v.add(rs.getString("indate"));
                             v.add(rs.getString("outdate"));
                              v.add(rs.getString("price"));
                               v.add(rs.getString("days"));
                                v.add(rs.getString("amount"));
                }
                df.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount()==1){
            DefaultTableModel df=(DefaultTableModel) jTable1.getModel();
            id=(String) df.getValueAt(jTable1.getSelectedRow(),0);
             new BillPrint().setVisible(true);
        }
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(BillLDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillLDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillLDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillLDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillLDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcheckoutdetails;
    // End of variables declaration//GEN-END:variables
}
