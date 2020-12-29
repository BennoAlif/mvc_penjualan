/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.m_pengguna;

/**
 *
 * @author tauhid
 */

public interface DAOPengguna {
    
    public List<m_pengguna>getAll();
    
    public List<m_pengguna>prosesLogin(String user, String pass);
        
    public void add(m_pengguna data);
    
    public void edit(m_pengguna data);
    
    public void remove(String id);
    
}
