/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOTPembelian;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_tpembelian;

/**
 *
 * @author tauhid
 */
public class DAOImplTPembelian implements DAOTPembelian{
    
    Connection kon;
    
    public DAOImplTPembelian(){
    }

    @Override
    public List<m_tpembelian>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_tpembelian> lis = null;
        
        try{
            
          String sql = "select * from pembelian order by id asc";

          lis = new ArrayList<m_tpembelian>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_tpembelian fi = new m_tpembelian();
                   fi.setId(rslt.getString("id"));
                   fi.setTanggal(rslt.getString("tanggal"));
                   fi.setKodesuplier(rslt.getString("kode_suplier"));
                   fi.setKodebarang(rslt.getString("kode_barang"));
                   fi.setJml_barang(rslt.getString("jumlah_barang"));
                   fi.setHarga_barang(rslt.getString("harga_barang"));
                   fi.setHarga_total(rslt.getString("harga_total"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_tpembelian u){

        kon = new koneksi().connection();
        
        String kodesup = u.getKodesuplier();
        String kodebar = u.getKodebarang();
        String tanggal = u.getTanggal();
        String jmlbarang = u.getJml_barang();
        String hargabarang = u.getHarga_barang();
        String hargatotal = u.getHarga_total();
        
        try{
            String sql="insert into pembelian(tanggal,kode_suplier,kode_barang,jumlah_barang,harga_barang,harga_total) values(?,?,?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,tanggal);
                stmt.setString(2,kodesup);
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
            String sql="update barang set harga=?,jumlah=jumlah+? where kode=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,hargabarang);
                stmt.setString(2,jmlbarang);
                stmt.setString(3,kodebar);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }


    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from pembelian where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Data Pembelian Barang GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
}



