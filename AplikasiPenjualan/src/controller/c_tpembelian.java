/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOTPembelian;
import DAO.DAOTmpPembelian;
import DAOImpl.DAOImplTmpPembelian;
import DAOImpl.DAOImplTPembelian;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_tmppembelian;
import model.m_tpembelian;
import tablemodel.tm_tmppembelian;
import tablemodel.tm_tpembelian;
import view.JFPembelian;

/**
 *
 * @author tauhid
 */
public class c_tpembelian {
    
    JFPembelian pembelian;
    DAOTPembelian implt;
    DAOTmpPembelian impltmp;
    List<m_tmppembelian> listmp;
    List<m_tpembelian> list;
    
    public c_tpembelian(JFPembelian pembelian){
        this.pembelian = pembelian;
        implt = new DAOImplTPembelian();
        impltmp = new DAOImplTmpPembelian();
    }
    
    public void isiTabelt(){
        list = implt.getAll();
        tm_tpembelian tm = new tm_tpembelian(list);
        pembelian.getDataTableT().setModel(tm);
    }    

    public void isiTabeltmp(){
        listmp = impltmp.getAll();
        tm_tmppembelian tm = new tm_tmppembelian(listmp);
        pembelian.getDataTableTmp().setModel(tm);
    }   
    
    public void deletetmp(String id){           
        impltmp.remove(id);
    }

    public void deletet(String id){           
        implt.remove(id);
    }
 
    public void removeall(){           
        impltmp.removeAll();
    }
        
    public void addtmp(JFPembelian data){
        
        if (!data.getTanggal().getText().trim().isEmpty()
                && !data.getKodeBarang().getText().trim().isEmpty()
                && !data.getKodeSuplier().getText().trim().isEmpty()
                && !data.getHargaBarang().getText().trim().isEmpty()
                && !data.getJmlBarang().getText().trim().isEmpty()
                ){
            
            m_tmppembelian u = new m_tmppembelian();
            u.setTanggal(data.getTanggal().getText());
            u.setKodesuplier(data.getKodeSuplier().getText().trim());
            u.setKodebarang(data.getKodeBarang().getText().trim());
            u.setJml_barang(data.getJmlBarang().getText().trim());
            u.setHarga_barang(data.getHargaBarang().getText().trim());
            
            impltmp.add(u);
            
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void simpan(JFPembelian data){
        
        if ( listmp.size() > 0 ){
           
           for (int i=0; i<listmp.size(); i++){
               
               m_tpembelian mt = new m_tpembelian();
               mt.setTanggal(listmp.get(i).getTanggal());
               mt.setKodesuplier(listmp.get(i).getKodesuplier());
               mt.setKodebarang(listmp.get(i).getKodebarang());
               mt.setJml_barang(listmp.get(i).getJml_barang());
               mt.setHarga_barang(listmp.get(i).getHarga_barang());
               mt.setHarga_total(Integer.toString(Integer.parseInt(listmp.get(i).getHarga_barang())*Integer.parseInt(listmp.get(i).getJml_barang())));
               implt.add(mt);
           }
           
           impltmp.removeAll();
           
           listmp.clear();

        } else {
            JOptionPane.showMessageDialog(data, "Data Pembelian Barang Masih Kosong!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
     
    }
}
