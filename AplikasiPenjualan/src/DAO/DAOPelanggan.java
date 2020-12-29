/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_pelanggan;

/**
 *
 * @author tauhid
 */

public interface DAOPelanggan {
    
    public List<m_pelanggan>getAll();
        
    public void add(m_pelanggan data);
    
    public void edit(m_pelanggan data);
    
    public void remove(String id);
    
}
