/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_tmppenjualan;

/**
 *
 * @author tauhid
 */

public class tm_tmppenjualan extends AbstractTableModel{
    
    List<m_tmppenjualan> lis;
    
    public tm_tmppenjualan(List<m_tmppenjualan> lis){
    this.lis = lis;
    }
    
    public int getColumnCount(){
        return 5;
    }
    
    public int getRowCount(){
        return lis.size();
    }
    
    public String getColumnName(int column){
    switch (column){
        case 0  : return "ID";
        case 1  : return "Tanggal";
        case 2  : return "Kode Pelanggan";
        case 3  : return "Kode Barang";
        case 4  : return "Jumlah Barang";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getTanggal();
           case 2  : return lis.get(row).getKodepelanggan();
           case 3  : return lis.get(row).getKodebarang();
           case 4  : return lis.get(row).getJml_barang();
           default : return null;
       }
    }
}
