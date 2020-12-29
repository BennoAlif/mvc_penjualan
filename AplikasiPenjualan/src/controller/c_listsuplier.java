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
import view.JFLSuplier;

/**
 *
 * @author tauhid
 */
public class c_listsuplier {
    
    JFLSuplier suplier;
    DAOSuplier impl;
    List<m_suplier> lis;
    
    public c_listsuplier(JFLSuplier suplier){
        this.suplier = suplier;
        impl = new DAOImplSuplier();
    }
    
    public void isiTabel(){
        lis = impl.getAll();
        tm_suplier tm = new tm_suplier(lis);
        suplier.getDataTable().setModel(tm);
    }    

}
