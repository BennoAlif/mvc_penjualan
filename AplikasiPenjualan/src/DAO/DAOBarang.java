/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_barang;

/**
 *
 * @author tauhid
 */

public interface DAOBarang {
    
    public List<m_barang>getAll();
    
    public List<m_barang>getByKode(String kode);
        
    public void add(m_barang data);
    
    public void edit(m_barang data);
    
    public void remove(String id);
    
}
