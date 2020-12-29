/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPelanggan;
import DAOImpl.DAOImplPelanggan;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_pelanggan;
import tablemodel.tm_pelanggan;
import view.JFPelanggan;

/**
 *
 * @author tauhid
 */
public class c_pelanggan {
    
    JFPelanggan pelanggan;
    DAOPelanggan impl;
    List<m_pelanggan> lis;
    
    public c_pelanggan(JFPelanggan pelanggan){
        this.pelanggan = pelanggan;
        impl = new DAOImplPelanggan();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_pelanggan tm = new tm_pelanggan(lis);
        pelanggan.getDataTable().setModel(tm);
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFPelanggan data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getAlamat().getText().trim().isEmpty()
                && !data.getHp().getText().trim().isEmpty()
                ){
            
            m_pelanggan u = new m_pelanggan();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setAlamat(data.getAlamat().getText().trim());
            u.setHp(data.getHp().getText().trim());
            
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Pelanggan Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFPelanggan data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getAlamat().getText().trim().isEmpty()
                && !data.getHp().getText().trim().isEmpty()
                ){
            
            m_pelanggan u = new m_pelanggan();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setAlamat(data.getAlamat().getText().trim());
            u.setHp(data.getHp().getText().trim());
            u.setId(data.getID().getText().trim());
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Pelanggan Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}


