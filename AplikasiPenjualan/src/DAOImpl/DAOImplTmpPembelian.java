/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOTmpPembelian;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_tmppembelian;

/**
 *
 * @author tauhid
 */
public class DAOImplTmpPembelian implements DAOTmpPembelian{
    
    Connection kon;
    
    public DAOImplTmpPembelian(){
    }

    @Override
    public List<m_tmppembelian>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_tmppembelian> lis = null;
        
        try{
            
          String sql = "select * from tmp_pembelian order by id asc";

          lis = new ArrayList<m_tmppembelian>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_tmppembelian fi = new m_tmppembelian();
                   fi.setId(rslt.getString("id"));
                   fi.setTanggal(rslt.getString("tanggal"));
                   fi.setKodesuplier(rslt.getString("kode_suplier"));
                   fi.setKodebarang(rslt.getString("kode_barang"));
                   fi.setJml_barang(rslt.getString("jumlah_barang"));
                   fi.setHarga_barang(rslt.getString("harga_barang"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }
    
    public void add(m_tmppembelian u){

        kon = new koneksi().connection();
        
        String kodesup = u.getKodesuplier();
        String kodebar = u.getKodebarang();
        String tanggal = u.getTanggal();
        String jmlbarang = u.getJml_barang();
        String hargabarang = u.getHarga_barang();

        try{
            String sql="insert into tmp_pembelian(tanggal,kode_suplier,kode_barang,jumlah_barang,harga_barang) values(?,?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,tanggal);
                stmt.setString(2,kodesup);
                stmt.setString(3,kodebar);
                stmt.setString(4,jmlbarang);
                stmt.setString(5,hargabarang);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        } 

    }


    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from tmp_pembelian where id="+id;
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
            
            String sql="truncate tmp_pembelian";
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Barang yang dibeli GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}



