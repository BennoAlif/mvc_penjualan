/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOSuplier;
import DAOImpl.DAOImplSuplier;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_suplier;
import tablemodel.tm_suplier;
import view.JFSuplier;

/**
 *
 * @author tauhid
 */
public class c_suplier {
    
    JFSuplier suplier;
    DAOSuplier impl;
    List<m_suplier> lis;
    
    public c_suplier(JFSuplier suplier){
        this.suplier = suplier;
        impl = new DAOImplSuplier();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_suplier tm = new tm_suplier(lis);
        suplier.getDataTable().setModel(tm);
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFSuplier data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getAlamat().getText().trim().isEmpty()
                && !data.getHp().getText().trim().isEmpty()
                ){
            
            m_suplier u = new m_suplier();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setAlamat(data.getAlamat().getText().trim());
            u.setHp(data.getHp().getText().trim());
            
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Suplier Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFSuplier data){
        
        if (!data.getKode().getText().trim().isEmpty()
                && !data.getNama().getText().trim().isEmpty()
                && !data.getAlamat().getText().trim().isEmpty()
                && !data.getHp().getText().trim().isEmpty()
                ){
            
            m_suplier u = new m_suplier();
            u.setKode(data.getKode().getText());
            u.setNama(data.getNama().getText().trim());
            u.setAlamat(data.getAlamat().getText().trim());
            u.setHp(data.getHp().getText().trim());
            u.setId(data.getID().getText().trim());
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Suplier Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}
