/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOTmpPenjualan;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_tmppenjualan;

/**
 *
 * @author tauhid
 */
public class DAOImplTmpPenjualan implements DAOTmpPenjualan{
    
    Connection kon;
    
    public DAOImplTmpPenjualan(){
    }

    @Override
    public List<m_tmppenjualan>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_tmppenjualan> lis = null;
        
        try{
            
          String sql = "select * from tmp_penjualan order by id asc";

          lis = new ArrayList<m_tmppenjualan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_tmppenjualan fi = new m_tmppenjualan();
                   fi.setId(rslt.getString("id"));
                   fi.setTanggal(rslt.getString("tanggal"));
                   fi.setKodepelanggan(rslt.getString("kode_pelanggan"));
                   fi.setKodebarang(rslt.getString("kode_barang"));
                   fi.setJml_barang(rslt.getString("jumlah_barang"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_tmppenjualan u){

        kon = new koneksi().connection();
        
        String kodepel = u.getKodepelanggan();
        String kodebar = u.getKodebarang();
        String tanggal = u.getTanggal();
        String jmlbarang = u.getJml_barang();
        
        try{
            String sql="insert into tmp_penjualan(tanggal,kode_pelanggan,kode_barang,jumlah_barang) values(?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,tanggal);
                stmt.setString(2,kodepel);
                stmt.setString(3,kodebar);
                stmt.setString(4,jmlbarang);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
        
    }


    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from tmp_penjualan where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Barang yang dibeli GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
 
    public void removeAll(){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="truncate tmp_penjualan";
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Barang yang dibeli GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}




