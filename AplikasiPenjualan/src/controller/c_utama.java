/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.koneksi;
import java.io.File;
import java.sql.Connection;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author tauhid
 */
public class c_utama {
    
    Connection kon;
    
    public void LapBarang(){
       try {
            kon = new koneksi().connection();
            String namafile = "src/laporan/laporanbarang.jasper";
            // End Parameter
            File report = new File(namafile);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report.getPath());
            // Untuk Print Report Tanpa Parameter
             JasperPrint jprintt = JasperFillManager.fillReport(jreprt, null, kon);
            JasperViewer.viewReport(jprintt,false);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Cetak Laporan",JOptionPane.ERROR_MESSAGE);
          }     
    }
    
    public void LapPelanggan(){
       try {
            kon = new koneksi().connection();
            String namafile = "src/laporan/laporanpelanggan.jasper";
            // End Parameter
            File report = new File(namafile);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report.getPath());
            // Untuk Print Report Tanpa Parameter
             JasperPrint jprintt = JasperFillManager.fillReport(jreprt, null, kon);
            JasperViewer.viewReport(jprintt,false);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Cetak Laporan",JOptionPane.ERROR_MESSAGE);
          }     
    }
    public void LapSuplier(){
       try {
            kon = new koneksi().connection();
            String namafile = "src/laporan/laporansuplier.jasper";
            // End Parameter
            File report = new File(namafile);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report.getPath());
            // Untuk Print Report Tanpa Parameter
             JasperPrint jprintt = JasperFillManager.fillReport(jreprt, null, kon);
            JasperViewer.viewReport(jprintt,false);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Cetak Laporan",JOptionPane.ERROR_MESSAGE);
          }     
    }
    public void LapPenjualan(){
       try {
            kon = new koneksi().connection();
            String namafile = "src/laporan/laporanpenjualan.jasper";
            // End Parameter
            File report = new File(namafile);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report.getPath());
            // Untuk Print Report Tanpa Parameter
             JasperPrint jprintt = JasperFillManager.fillReport(jreprt, null, kon);
            JasperViewer.viewReport(jprintt,false);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Cetak Laporan",JOptionPane.ERROR_MESSAGE);
          }     
    }
    public void LapPembelian(){
       try {
            kon = new koneksi().connection();
            String namafile = "src/laporan/laporanpembelian.jasper";
            // End Parameter
            File report = new File(namafile);
            JasperReport jreprt = (JasperReport)JRLoader.loadObject(report.getPath());
            // Untuk Print Report Tanpa Parameter
             JasperPrint jprintt = JasperFillManager.fillReport(jreprt, null, kon);
            JasperViewer.viewReport(jprintt,false);
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),"Cetak Laporan",JOptionPane.ERROR_MESSAGE);
          }     
    }    
}
