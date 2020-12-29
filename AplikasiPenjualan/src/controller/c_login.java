/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DAOPengguna;
import DAOImpl.DAOImplPengguna;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.m_pengguna;
import view.JFLogin;
import view.JFUtama;


/**
 *
 * @author tauhid
 */
public class c_login {
    
    JFLogin login;
    JFUtama utama;
    DAOPengguna impl;
    List<m_pengguna> lis;
    
    
    public c_login(JFLogin login){
        this.login = login;  
        utama = new JFUtama();
        impl = new DAOImplPengguna();
    }
    
    public void cek_login(JFLogin data){
        
        if (!data.getUser().getText().trim().isEmpty()
                && !data.getPass().getText().trim().isEmpty()){
            
            String nama = data.getUser().getText();
            String pass = get_SHA_512_SecurePassword(data.getPass().getText(),"aplikasi");
            
            lis = impl.prosesLogin(nama, pass);
            
            if (lis.size()==1){
                utama.setVisible(true);
                login.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(data, "Username atau Password tidak cocok!","Pesan Kesalahan",JOptionPane.ERROR_MESSAGE);
            }
            
            
        } else {
            JOptionPane.showMessageDialog(data, "Isi Username dan Password!","Pesan Kesalahan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt){
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
            try {
                md.update(salt.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
             byte[] bytes = null;
            try {
                bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(c_login.class.getName()).log(Level.SEVERE, null, ex);
            }
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             generatedPassword = sb.toString();
            } 
           catch (NoSuchAlgorithmException e){
            e.printStackTrace();
           }
        return generatedPassword;
    }
}

