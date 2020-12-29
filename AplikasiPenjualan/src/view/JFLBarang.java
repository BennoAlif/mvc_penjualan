/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.c_listbarang;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author tauhid
 */
public class JFLBarang extends javax.swing.JFrame {

    /**
     * Creates new form JFLBarang
     */
    c_listbarang barang;
    JFPembelian beli;
    JFPenjualan jual;
    
    public JFLBarang(JFPembelian beli, JFPenjualan jual) {
        initComponents();
        this.setTitle("List Barang");
        this.setLocationRelativeTo(getRootPane());
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        this.beli = beli;
        this.jual = jual;
        barang = new c_listbarang(this);
        barang.isiTabel();
    }
    public JTable getDataTable(){
        return jTable2;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jbCariPenyakit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(250, 300));

        jPanel2.setPreferredSize(new java.awt.Dimension(333, 25));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jbCariPenyakit.setText("Pilih");
        jbCariPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCariPenyakitActionPerformed(evt);
            }
        });
        jPanel2.add(jbCariPenyakit, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

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

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCariPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCariPenyakitActionPerformed
        // TODO add your handling code here
        if (jTable2.getSelectedRow()>=0){
            jual.getKodeBarang().setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
            beli.getKodeBarang().setText(jTable2.getValueAt(jTable2.getSelectedRow(),1).toString());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Pilih Data Hama Pada Tabel","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbCariPenyakitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbCariPenyakit;
    // End of variables declaration//GEN-END:variables
}