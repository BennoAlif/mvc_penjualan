/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_tmppenjualan;

/**
 *
 * @author tauhid
 */

public interface DAOTmpPenjualan {
    
    public List<m_tmppenjualan>getAll();
        
    public void add(m_tmppenjualan data);
    
    public void remove(String id);
    
    public void removeAll();
    
    
    
}
