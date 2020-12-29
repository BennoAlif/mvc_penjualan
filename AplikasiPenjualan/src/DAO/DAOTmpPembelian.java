/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_tmppembelian;

/**
 *
 * @author tauhid
 */

public interface DAOTmpPembelian {
    
    public List<m_tmppembelian>getAll();
        
    public void add(m_tmppembelian data);
    
    public void remove(String id);
    
    public void removeAll();
    
    
    
}
