/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_tpembelian;

/**
 *
 * @author tauhid
 */

public interface DAOTPembelian {
    
    public List<m_tpembelian>getAll();
        
    public void add(m_tpembelian data);
    
    public void remove(String id);
    
}
