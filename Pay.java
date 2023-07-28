/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant.management.system;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.*;
public class Pay extends javax.swing.JFrame {
Connection cn;
    /**
     * Creates new form Pay
     */
    public Pay() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public Pay(String data){
         initComponents();
        this.setLocationRelativeTo(null);
        String text = data;
        jButton1.setEnabled(false);
        txtTotal.setText(""+text);
                
    }

    Pay(int data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtChange = new javax.swing.JLabel();
        txtCash = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtChange.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtChange.setText("0");
        getContentPane().add(txtChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 234, 36, -1));

        txtCash.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCashActionPerformed(evt);
            }
        });
        txtCash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCashKeyPressed(evt);
            }
        });
        getContentPane().add(txtCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 120, 169, 50));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 297, 273, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("TOTAL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 37, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("CASH");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 134, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("CHANGE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtTotal.setText("0");
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 31, 36, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void connection(){
    try 
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dborderingsystem","root",""); 
    }
    catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Connection is close!");
        }
    }

    private void txtCashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCashActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              connection();
        try{
            
                PreparedStatement ps = cn.prepareStatement("delete from tblcart");
                ps.execute();
                cn.close();
                JOptionPane.showMessageDialog(null, "P A I D!");
                this.dispose();
              new Main().setVisible(true);
                
        
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());             
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCashKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCashKeyPressed
        int cash = Integer.parseInt(txtCash.getText());
        int total = Integer.parseInt(txtTotal.getText());
        int change;
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(cash < total){
                JOptionPane.showMessageDialog(null, "Insufficient!");
            } 
             change = cash - total;
             txtChange.setText("" +change);
        }
        jButton1.setEnabled(true);
        
    }//GEN-LAST:event_txtCashKeyPressed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pay().setVisible(true);
            }
        });
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCash;
    private javax.swing.JLabel txtChange;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
