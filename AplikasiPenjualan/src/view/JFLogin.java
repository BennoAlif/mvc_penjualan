/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import controller.c_login;

/**
 *
 * @author tauhid
 */
public class JFLogin extends javax.swing.JFrame {

    c_login login;
    /**
     * Creates new form JFLogin
     */
    public JFLogin() {
        initComponents();
        this.setTitle("Silahkan Login");
        this.setLocationRelativeTo(getRootPane());
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        login = new c_login(this);
    }

    public JTextField getUser(){ return jtUser; }
    public JPasswordField getPass(){ return jtpass; }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtpass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jBCancel = new javax.swing.JButton();
        jBLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(260, 130));
        jPanel1.setPreferredSize(new java.awt.Dimension(305, 100));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Username");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));
        jPanel1.add(jtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 130, -1));

        jLabel4.setText("Password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));
        jPanel1.add(jtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 130, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(305, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Silahkan Login");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setPreferredSize(new java.awt.Dimension(305, 40));

        jBCancel.setText("Batal");
        jBCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelActionPerformed(evt);
            }
        });
        jPanel3.add(jBCancel);

        jBLogin.setText("Login");
        jBLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLoginActionPerformed(evt);
            }
        });
        jPanel3.add(jBLogin);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBCancelActionPerformed

    private void jBLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLoginActionPerformed
        // TODO add your handling code here:
       login.cek_login(this);
    }//GEN-LAST:event_jBLoginActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancel;
    private javax.swing.JButton jBLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jtUser;
    private javax.swing.JPasswordField jtpass;
    // End of variables declaration//GEN-END:variables
}
