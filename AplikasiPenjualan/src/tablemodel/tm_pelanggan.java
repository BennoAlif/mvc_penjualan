/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.m_pelanggan;

/**
 *
 * @author tauhid
 */

public class tm_pelanggan extends AbstractTableModel{
    
    List<m_pelanggan> lis;
    
    public tm_pelanggan(List<m_pelanggan> lis){
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
        case 1  : return "Kode Pelanggan";
        case 2  : return "Nama Pelanggan";
        case 3  : return "Alamat";
        case 4  : return "Nomor HP";
        default : return null;
    }
    }
    
    public Object getValueAt(int row, int column){
       switch(column){
           case 0  : return lis.get(row).getId();
           case 1  : return lis.get(row).getKode();
           case 2  : return lis.get(row).getNama();
           case 3  : return lis.get(row).getAlamat();
           case 4  : return lis.get(row).getHp();
           default : return null;
       }
    }
}
