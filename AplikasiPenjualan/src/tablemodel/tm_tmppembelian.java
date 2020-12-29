/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_tmppembelian;

/**
 *
 * @author tauhid
 */

public class tm_tmppembelian extends AbstractTableModel{
    
    List<m_tmppembelian> lis;
    
    public tm_tmppembelian(List<m_tmppembelian> lis){
    this.lis = lis;
    }
    
    public int getColumnCount(){
        return 6;
    }
    
    public int getRowCount(){
        return lis.size();
    }
    
    public String getColumnName(int column){
    switch (column){
        case 0  : return "ID";
        case 1  : return "Tanggal";
        case 2  : return "Kode Suplier";
        case 3  : return "Kode Barang";
        case 4  : return "Jumlah Barang";
        case 5  : return "Harga Barang";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getTanggal();
           case 2  : return lis.get(row).getKodesuplier();
           case 3  : return lis.get(row).getKodebarang();
           case 4  : return lis.get(row).getJml_barang();
           case 5  : return lis.get(row).getHarga_barang();
           default : return null;
       }
    }
}
