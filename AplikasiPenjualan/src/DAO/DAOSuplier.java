/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_suplier;

/**
 *
 * @author tauhid
 */

public interface DAOSuplier {
    
    public List<m_suplier>getAll();
        
    public void add(m_suplier data);
    
    public void edit(m_suplier data);
    
    public void remove(String id);
    
}
