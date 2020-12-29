/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOSuplier;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_suplier;

/**
 *
 * @author tauhid
 */
public class DAOImplSuplier implements DAOSuplier{
    
    Connection kon;
    
    public DAOImplSuplier(){
    }

    @Override
    public List<m_suplier>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_suplier> lis = null;
        
        try{
            
          String sql = "select * from suplier order by id asc";

          lis = new ArrayList<m_suplier>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_suplier fi = new m_suplier();
                   fi.setId(rslt.getString("id"));
                   fi.setKode(rslt.getString("kode"));
                   fi.setNama(rslt.getString("nama"));
                   fi.setAlamat(rslt.getString("alamat"));
                   fi.setHp(rslt.getString("hp"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_suplier u){

        kon = new koneksi().connection();
        
        String kode = u.getKode();
        String nama = u.getNama();
        String alamat = u.getAlamat();
        String hp = u.getHp();
        
        try{
            String sql="insert into suplier(kode,nama,alamat,hp) values(?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,kode);
                stmt.setString(2,nama);
                stmt.setString(3,alamat);
                stmt.setString(4,hp);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_suplier u){

        kon = new koneksi().connection();
        
        String kode = u.getKode();
        String nama = u.getNama();
        String alamat = u.getAlamat();
        String hp = u.getHp();
        String id = u.getId();
        
        try{
            String sql="update suplier set kode=?, nama=?, alamat=?, hp=? where id=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,kode);
                stmt.setString(2,nama);
                stmt.setString(3,alamat);
                stmt.setString(4,hp);
                stmt.setString(5,id);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }    
    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from suplier where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Suplier GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
    
}


