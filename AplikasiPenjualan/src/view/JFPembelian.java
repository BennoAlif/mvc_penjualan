/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JTable;
import javax.swing.JTextField;
import controller.c_tpembelian;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author tauhid
 */
public class JFPembelian extends javax.swing.JFrame {

    /**
     * Creates new form JFPembelian
     */
    c_tpembelian pembelian;
    
    public JFPembelian() {
        initComponents();
        this.setTitle("Transaksi Pembelian");
        this.setLocationRelativeTo(getRootPane());
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        pembelian = new c_tpembelian(this);
        pembelian.isiTabelt();
        pembelian.removeall();
        pembelian.isiTabeltmp();
        // Tanggal
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date today = Calendar.getInstance().getTime();        
        String reportDate = df.format(today);
        jTextField1.setText(reportDate);
    }
    
    public JTable getDataTableT(){ return jTable1; }
    public JTable getDataTableTmp(){ return jTable2; }
    public JTextField getTanggal(){ return jTextField1; }
    public JTextField getKodeSuplier(){ return jTextField2; }
    public JTextField getKodeBarang(){ return jTextField3; }
    public JTextField getJmlBarang(){ return jTextField4; }
    public JTextField getHargaBarang(){ return jTextField5; }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_tabel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel_form = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel_tabel.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Transaksi Pembelian Barang"));
        panel_tabel.setPreferredSize(new java.awt.Dimension(550, 200));
        panel_tabel.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        panel_tabel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panel_tabel, java.awt.BorderLayout.CENTER);

        panel_form.setPreferredSize(new java.awt.Dimension(610, 250));
        panel_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tanggal");
        panel_form.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Kode Suplier");
        panel_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jButton1.setText("Tambahkan ke Keranjang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_form.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        jButton2.setText("Simpan Barang");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_form.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_form.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel3.setText("Kode Barang");
        panel_form.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setText("Jumlah Barang");
        panel_form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Keranjang Belanja"));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        panel_form.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 270, 150));

        jLabel5.setText("Harga Barang");
        panel_form.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jTextField1.setEditable(false);
        panel_form.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 180, -1));
        panel_form.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 150, -1));

        jTextField3.setEditable(false);
        panel_form.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, -1));
        panel_form.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 180, -1));
        panel_form.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 180, -1));

        jButton4.setText("Batal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panel_form.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panel_form.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 30, -1));

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panel_form.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 30, -1));

        getContentPane().add(panel_form, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        pembelian.addtmp(this);
        pembelian.isiTabeltmp();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (jTable2.getSelectedRow()>=0){
         String id = jTable2.getValueAt(jTable2.getSelectedRow(),0).toString();
         pembelian.deletetmp(id);
         pembelian.isiTabeltmp();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jTable1.getSelectedRow()>=0){
            int dialogResult = JOptionPane.showConfirmDialog (this, "Anda Yakin Akan Menghapus Data Ini?","Peringatan",JOptionPane.WARNING_MESSAGE);
            if(dialogResult == JOptionPane.YES_OPTION){
                String id = jTable1.getValueAt(jTable1.getSelectedRow(),0).toString();
                pembelian.deletet(id);
                pembelian.isiTabelt();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Data Pada Tabel Sebelum Hapus","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        pembelian.simpan(this);
        pembelian.isiTabelt();
        pembelian.isiTabeltmp();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new JFLSuplier(this).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new JFLBarang(this,new JFPenjualan()).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel panel_form;
    private javax.swing.JPanel panel_tabel;
    // End of variables declaration//GEN-END:variables
}
