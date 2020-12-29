/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOTPenjualan;
import DAO.DAOBarang;
import DAO.DAOTmpPenjualan;
import DAOImpl.DAOImplTmpPenjualan;
import DAOImpl.DAOImplTPenjualan;
import DAOImpl.DAOImplBarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.m_tmppenjualan;
import model.m_tpenjualan;
import model.m_barang;
import tablemodel.tm_tmppenjualan;
import tablemodel.tm_tpenjualan;
import tablemodel.tm_barang;
import view.JFPenjualan;

/**
 *
 * @author tauhid
 */
public class c_tpenjualan {
    
    JFPenjualan penjualan;
    DAOBarang implb;
    DAOTPenjualan implt;
    DAOTmpPenjualan impltmp;
    List<m_tmppenjualan> listmp;
    List<m_tpenjualan> list;
    List<m_barang> lisb;
    
    public c_tpenjualan(JFPenjualan penjualan){
        this.penjualan = penjualan;
        implt = new DAOImplTPenjualan();
        impltmp = new DAOImplTmpPenjualan();
        implb = new DAOImplBarang();
    }
    
    public void isiTabelt(){
        list = implt.getAll();
        tm_tpenjualan tm = new tm_tpenjualan(list);
        penjualan.getDataTableT().setModel(tm);
    }    

    public void isiTabeltmp(){
        listmp = impltmp.getAll();
        tm_tmppenjualan tm = new tm_tmppenjualan(listmp);
        penjualan.getDataTableTmp().setModel(tm);
    }   
    
    public void deletetmp(JFPenjualan jual, String id, String kodeb, String jmlb){           
        impltmp.remove(id);
                    
        lisb = implb.getByKode(kodeb);
        int total = Integer.parseInt(lisb.get(0).getHarga())*Integer.parseInt(jmlb);
        if (!jual.getTotal().getText().trim().isEmpty()){
        jual.getTotal().setText(Integer.toString(Integer.parseInt(jual.getTotal().getText())-total));
        } else {
        jual.getTotal().setText(Integer.toString(total));
        }
    }

    public void deletet(String id){           
        implt.remove(id);
    }

    public void removeall(){           
        impltmp.removeAll();
    }
        
    public void addtmp(JFPenjualan data){
        
        
        
        if (!data.getTanggal().getText().trim().isEmpty()
                && !data.getKodeBarang().getText().trim().isEmpty()
                && !data.getKodePelanggan().getText().trim().isEmpty()
                && !data.getJmlBarang().getText().trim().isEmpty()
                ){
            
            m_tmppenjualan u = new m_tmppenjualan();
            u.setTanggal(data.getTanggal().getText());
            u.setKodepelanggan(data.getKodePelanggan().getText().trim());
            u.setKodebarang(data.getKodeBarang().getText().trim());
            u.setJml_barang(data.getJmlBarang().getText().trim());
            
            impltmp.add(u);
            lisb = implb.getByKode(data.getKodeBarang().getText().trim());
            int total = Integer.parseInt(lisb.get(0).getHarga())*Integer.parseInt(data.getJmlBarang().getText().trim());
            if (!data.getTotal().getText().trim().isEmpty()){
            data.getTotal().setText(Integer.toString(Integer.parseInt(data.getTotal().getText())+total));
            } else {
            data.getTotal().setText(Integer.toString(total));
            }
            
        } else {
            JOptionPane.showMessageDialog(data, "Jangan Kosongkan Inputan!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void simpan(JFPenjualan data){
        
        if ( listmp.size() > 0 ){
           
           for (int i=0; i<listmp.size(); i++){
               
               m_tpenjualan mt = new m_tpenjualan();
               mt.setTanggal(listmp.get(i).getTanggal());
               mt.setKodepelanggan(listmp.get(i).getKodepelanggan());
               mt.setKodebarang(listmp.get(i).getKodebarang());
               mt.setJml_barang(listmp.get(i).getJml_barang());
               lisb = implb.getByKode(data.getKodeBarang().getText().trim());
               mt.setHarga_barang(lisb.get(0).getHarga());
               mt.setHarga_total(Integer.toString(Integer.parseInt(lisb.get(0).getHarga())*Integer.parseInt(listmp.get(i).getJml_barang())));
               implt.add(mt);
           }
           
           impltmp.removeAll();
           
           listmp.clear();

        } else {
            JOptionPane.showMessageDialog(data, "Data Penjualan Barang Masih Kosong!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
     
    }
}
