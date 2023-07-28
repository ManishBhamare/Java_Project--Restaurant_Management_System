
package restaurant.management.system;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Main extends javax.swing.JFrame {
    Connection cn;

    private int rowIndex;
    private String id;
    private String prod;
    private String price;
    

    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnAdd.setEnabled(false);
        btnRemove.setEnabled(false);
        connection(); 
        loadrecord(jTable1);
        btnPay.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnPay = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtProduct = new javax.swing.JLabel();
        txtPrice = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProductID", "ProductName", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 380, 210));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 370, 170));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("CART");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 52, 70, -1));

        btnAdd.setText("Add to Cart");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 130, 70));

        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 320, 150, 70));

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 144, 70));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("ID:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Product Name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        txtID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtID.setText("0");
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 25, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Price:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, -1));

        txtProduct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 80, 20));

        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 100, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Quantity:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        txtqty.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtqty.setText("1");
        getContentPane().add(txtqty, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 101, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("TOTAL:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, -1));

        txtSum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSum.setText("0");
        getContentPane().add(txtSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 280, 90, 20));

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
public void loadrecord (JTable table) {
        connection();
        try
        {
         PreparedStatement ps =cn.prepareStatement("Select * from tblproducts");
        ResultSet rs = ps.executeQuery();
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        Object [] row;
        while (rs.next())
        {
            row = new Object[3];
            row [0] = rs.getInt(1);
            row [1] = rs.getString(2);
            row [2] = rs.getInt(3);
            model.addRow(row);
        }cn.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        }
    }
public void loadrecord1 (JTable table) {
        connection();
        try
        {
         PreparedStatement ps =cn.prepareStatement("Select * from tblcart");
        ResultSet rs = ps.executeQuery();
        DefaultTableModel model =(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        Object [] row;
        while (rs.next())
        {
            row = new Object[4];
            row [0] = rs.getInt(1);
            row [1] = rs.getString(2);
            row [2] = rs.getString(3);
            row [3] = rs.getInt(4);
            model.addRow(row);
        }cn.close();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage()); 
        }
    }

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        String s = txtSum.getText();
        Pay p = new Pay(s);
        p.setVisible(true);
        this.setLocationRelativeTo(p);
                    
    }//GEN-LAST:event_btnPayActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        btnAdd.setEnabled(true);
        int rowIndex = jTable1.getSelectedRow();
        txtID.setText(jTable1.getValueAt(rowIndex, 0).toString());
        txtProduct.setText(jTable1.getValueAt(rowIndex, 1).toString());
        txtPrice.setText(jTable1.getValueAt(rowIndex, 2).toString());      
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        connection();
            int i = Integer.parseInt(txtSum.getText());
            int ii = Integer.parseInt(txtPrice.getText());
            int t = i - ii;
            String f = String.valueOf(t);
            txtSum.setText(f);
        try{
            String id = txtID.getText();
            if(id.equals("0"))
            {
                JOptionPane.showMessageDialog(null, "No Data Selected!"); 
            }
            else
            {
                PreparedStatement ps = cn.prepareStatement("delete from tblcart where id = '"+id+"'");
                ps.execute();
                cn.close();
                loadrecord1(jTable2);
                txtID.setText("0");
                txtProduct.setText("");
                txtPrice.setText("");

            }
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());             
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Option().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        btnRemove.setEnabled(true);
        int rowIndex = jTable2.getSelectedRow();
        txtID.setText(jTable2.getValueAt(rowIndex, 0).toString());
        txtProduct.setText(jTable2.getValueAt(rowIndex, 1).toString());
        txtPrice.setText(jTable2.getValueAt(rowIndex, 3).toString());      
    
    }//GEN-LAST:event_jTable2MouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        connection(); 
        String id = txtID.getText();
        String prod = txtProduct.getText();
        String price = txtPrice.getText();
        int prices = Integer.parseInt(price);
        int qty = Integer.parseInt(txtqty.getText());
        int total = prices * qty;
        String tot = String.valueOf(total);
        String Quant = String.valueOf(qty);
        try{
         PreparedStatement ps = cn.prepareStatement("insert into tblcart (id, Products,Quantity, Price) values (?,?,?,?)");
         ps.setString(1, id);
         ps.setString(2, prod);
         ps.setString(3, Quant);
         ps.setString(4, tot);
         ps.execute();
         loadrecord(jTable1);
         cn.close();
         txtID.setText("0");
         txtProduct.setText("");
         txtPrice.setText("");
         loadrecord1(jTable2);
         int sum = Integer.parseInt(txtSum.getText());
         int over = sum + total;
         String t = String.valueOf(over);
         txtSum.setText(t);
        }
         catch(Exception ex)
         {
         JOptionPane.showMessageDialog(null, ex.getMessage()); 
         }        
        btnPay.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel txtID;
    private javax.swing.JLabel txtPrice;
    private javax.swing.JLabel txtProduct;
    private javax.swing.JLabel txtSum;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables

}
