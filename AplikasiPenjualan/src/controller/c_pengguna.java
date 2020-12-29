/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPengguna;
import DAOImpl.DAOImplPengguna;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_pengguna;
import tablemodel.tm_pengguna;
import view.JFPengguna;

/**
 *
 * @author tauhid
 */
public class c_pengguna {
    
    JFPengguna pengguna;
    DAOPengguna impl;
    List<m_pengguna> lis;
    
    public c_pengguna(JFPengguna pengguna){
        this.pengguna = pengguna;
        impl = new DAOImplPengguna();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_pengguna tm = new tm_pengguna(lis);
        pengguna.getDataTable().setModel(tm);
    }    
    
    public void delete(String id){           
        impl.remove(id);
    }
        
    public void insert(JFPengguna data){
        
        if (!data.getUser().getText().trim().isEmpty()
                && !data.getPass().getText().trim().isEmpty()){
            
            m_pengguna u = new m_pengguna();
            u.setNama(data.getUser().getText());
            u.setPass(data.getPass().getText().trim());
            impl.add(u);
            JOptionPane.showMessageDialog(data, "Data Pengguna Berhasil disimpan!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void update(JFPengguna data){
        
        if (!data.getUser().getText().trim().isEmpty()
                && !data.getPass().getText().trim().isEmpty()){
            
            m_pengguna u = new m_pengguna();
            u.setId(data.getID().getText());
            u.setNama(data.getUser().getText());
            u.setPass(data.getPass().getText().trim());
            impl.edit(u);
            JOptionPane.showMessageDialog(data, "Data Pengguna Berhasil diperbarui!","Sukses",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
}

