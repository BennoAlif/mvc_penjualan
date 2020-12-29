/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_barang;

/**
 *
 * @author tauhid
 */

public class tm_barang extends AbstractTableModel{
    
    List<m_barang> lis;
    
    public tm_barang(List<m_barang> lis){
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
        case 1  : return "Kode Barang";
        case 2  : return "Nama Barang";
        case 3  : return "Harga Barang";
        case 4  : return "Jumlah Barang";
        case 5  : return "Keterangan";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getKode();
           case 2  : return lis.get(row).getNama();
           case 3  : return lis.get(row).getHarga();
           case 4  : return lis.get(row).getJumlah();
           case 5  : return lis.get(row).getKeterangan();
           default : return null;
       }
    }
}

