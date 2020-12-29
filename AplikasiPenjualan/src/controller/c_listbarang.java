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
import view.JFLBarang;

/**
 *
 * @author tauhid
 */
public class c_listbarang {
    
    JFLBarang barang;
    DAOBarang impl;
    List<m_barang> lis;
    
    public c_listbarang(JFLBarang barang){
        this.barang = barang;
        impl = new DAOImplBarang();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_barang tm = new tm_barang(lis);
        barang.getDataTable().setModel(tm);
    }    
}
