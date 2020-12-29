/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOTPenjualan;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_tpenjualan;

/**
 *
 * @author tauhid
 */
public class DAOImplTPenjualan implements DAOTPenjualan{
    
    Connection kon;
    
    public DAOImplTPenjualan(){
    }

    @Override
    public List<m_tpenjualan>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_tpenjualan> lis = null;
        
        try{
            
          String sql = "select * from penjualan order by id asc";

          lis = new ArrayList<m_tpenjualan>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_tpenjualan fi = new m_tpenjualan();
                   fi.setId(rslt.getString("id"));
                   fi.setTanggal(rslt.getString("tanggal"));
                   fi.setKodepelanggan(rslt.getString("kode_pelanggan"));
                   fi.setKodebarang(rslt.getString("kode_barang"));
                   fi.setJml_barang(rslt.getString("jumlah_barang"));
                   fi.setHarga_barang(rslt.getString("harga_barang"));
                   fi.setHarga_total(rslt.getString("total_harga"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_tpenjualan u){

        kon = new koneksi().connection();
        
        String kodepel = u.getKodepelanggan();
        String kodebar = u.getKodebarang();
        String tanggal = u.getTanggal();
        String jmlbarang = u.getJml_barang();
        String hargabarang = u.getHarga_barang();
        String hargatotal = u.getHarga_total();
        
        try{
            String sql="insert into penjualan(tanggal,kode_pelanggan,kode_barang,jumlah_barang,harga_barang,total_harga) values(?,?,?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,tanggal);
                stmt.setString(2,kodepel);
                stmt.setString(3,kodebar);
                stmt.setString(4,jmlbarang);
                stmt.setString(5,hargabarang);
                stmt.setString(6,hargatotal);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
        // Update Barang
        try{
            String sql="update barang set jumlah=jumlah-? where kode=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,jmlbarang);
                stmt.setString(2,kodebar);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }


    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from penjualan where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Penjualan Barang GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
}



