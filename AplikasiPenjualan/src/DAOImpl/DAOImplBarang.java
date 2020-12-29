/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImpl;

import java.util.ArrayList;
import java.util.List;
import DAO.DAOBarang;
import config.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.m_barang;

/**
 *
 * @author tauhid
 */
public class DAOImplBarang implements DAOBarang{
    
    Connection kon;
    
    public DAOImplBarang(){
    }

    @Override
    public List<m_barang>getAll(){
        
        kon = new koneksi().connection();
        
        List<m_barang> lis = null;
        
        try{
            
          String sql = "select * from barang order by id asc";

          lis = new ArrayList<m_barang>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_barang fi = new m_barang();
                   fi.setId(rslt.getString("id"));
                   fi.setKode(rslt.getString("kode"));
                   fi.setNama(rslt.getString("nama"));
                   fi.setHarga(rslt.getString("harga"));
                   fi.setJumlah(rslt.getString("jumlah"));
                   fi.setKeterangan(rslt.getString("keterangan"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }

    public List<m_barang>getByKode(String kode){
        
        kon = new koneksi().connection();
        
        List<m_barang> lis = null;
        
        try{
            
          String sql = "select * from barang where kode="+kode;

          lis = new ArrayList<m_barang>();
          
          Statement stmt=kon.createStatement();
          ResultSet rslt=stmt.executeQuery(sql);
          
               while(rslt.next()){
                   m_barang fi = new m_barang();
                   fi.setId(rslt.getString("id"));
                   fi.setKode(rslt.getString("kode"));
                   fi.setNama(rslt.getString("nama"));
                   fi.setHarga(rslt.getString("harga"));
                   fi.setJumlah(rslt.getString("jumlah"));
                   fi.setKeterangan(rslt.getString("keterangan"));
                   lis.add(fi);   
               }
          
        }catch(Exception err){
            err.printStackTrace();
        }
         
        return lis;
    }

    public void add(m_barang u){

        kon = new koneksi().connection();
        
        String kode = u.getKode();
        String nama = u.getNama();
        String harga = u.getHarga();
        String jumlah = u.getJumlah();
        String keterangan = u.getKeterangan();
        
        try{
            String sql="insert into barang(kode,nama,harga,jumlah,keterangan) values(?,?,?,?,?)";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,kode);
                stmt.setString(2,nama);
                stmt.setString(3,harga);
                stmt.setString(4,jumlah);
                stmt.setString(5,keterangan);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }

    public void edit(m_barang u){

        kon = new koneksi().connection();
        
        String kode = u.getKode();
        String nama = u.getNama();
        String harga = u.getHarga();
        String jumlah = u.getJumlah();
        String keterangan = u.getKeterangan();
        String id = u.getId();
        
        try{
            String sql="update barang set kode=?, nama=?, harga=?, jumlah=?, keterangan=? where id=?";
            PreparedStatement stmt=kon.prepareStatement(sql);
            
                stmt.setString(1,kode);
                stmt.setString(2,nama);
                stmt.setString(3,harga);
                stmt.setString(4,jumlah);
                stmt.setString(5,keterangan);
                stmt.setString(6,id);

                stmt.executeUpdate();
                
            stmt.close();

        }catch(Exception err){
            err.printStackTrace();
        }
    }    
    
    public void remove(String id){
        
        kon = new koneksi().connection();
        
        try{
            
            String sql="delete from barang where id="+id;
            PreparedStatement stmt=kon.prepareStatement(sql);

            stmt.executeUpdate();
                
            stmt.close();
            
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"Barang GAGAL dihapus!","Kesalahan",JOptionPane.ERROR_MESSAGE);
        }
    }        
    
    
}


