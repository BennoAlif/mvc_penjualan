/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOBarang;
import DAOImpl.DAOImplBarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_barang;
import tablemodel.tm_barang;
import view.JFBarang;

/**
 *
 * @author tauhid
 */
public class c_barang {
    
    JFBarang barang;
    DAOBarang impl;
    List<m_barang> lis;
    
    public c_barang(JFBarang barang){
        this.barang = barang;
        impl = new DAOImplBarang();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_barang tm = new tm_barang(lis);
        barang.getDataTable().setModel(tm);
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFBarang data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getKeterangan().getText().trim().isEmpty()
                ){
            
            m_barang u = new m_barang();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setHarga("0");
            u.setJumlah("0");
            u.setKeterangan(data.getKeterangan().getText().trim());
            
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Barang Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFBarang data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getKeterangan().getText().trim().isEmpty()
                ){
            
            m_barang u = new m_barang();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setHarga("0");
            u.setJumlah("0");
            u.setKeterangan(data.getKeterangan().getText().trim());
            
            u.setId(data.getID().getText().trim());
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Barang Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
