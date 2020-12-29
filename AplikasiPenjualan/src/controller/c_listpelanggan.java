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
import view.JFLPelanggan;

/**
 *
 * @author tauhid
 */
public class c_listpelanggan {
    
    JFLPelanggan pelanggan;
    DAOPelanggan impl;
    List<m_pelanggan> lis;
    
    public c_listpelanggan(JFLPelanggan pelanggan){
        this.pelanggan = pelanggan;
        impl = new DAOImplPelanggan();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_pelanggan tm = new tm_pelanggan(lis);
        pelanggan.getDataTable().setModel(tm);
    }    
    
}


