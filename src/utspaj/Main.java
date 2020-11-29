/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utspaj;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author vava
 */
public class Main extends JFrame{
    
    JPanel panelAtas, panelBody, panelBawah, panelUmur;
    JLabel lblJudul, lblUsername, lblUmur, lblPassword, lblConPass;
    JTextField txtUsername;
    JPasswordField txtPassword, txtConPass;
    JRadioButton radioDewasa, radioAnak;
    ButtonGroup groupUmur;
    JButton btnReset, btnDaftar;
    
    public Main(){
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        init();
        
        //Menambah panel ke JFrame
        add(panelAtas,BorderLayout.NORTH);
        add(panelBody,BorderLayout.CENTER);
        add(panelBawah,BorderLayout.SOUTH);
        
        //Menambah Judul ke Panel Atas
        panelAtas.add(lblJudul);
        
        //Menambah Label ke Panel Body
        
        //username
        panelBody.add(lblUsername);
        panelBody.add(txtUsername);
        
        //umur
        panelBody.add(lblUmur);
        panelUmur.add(radioDewasa);
        panelUmur.add(radioAnak);
        panelBody.add(panelUmur);
              
        //password
        panelBody.add(lblPassword);
        panelBody.add(txtPassword);
        
        //confirmarion password
        panelBody.add(lblConPass);
        panelBody.add(txtConPass);
        
        //tambah button ke panel bawah
        panelBawah.add(btnReset);
        panelBawah.add(btnDaftar);
        
        //menambah listener untuk reset
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
                }
        });
        
        //menambah listener untuk Daftar
        btnDaftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(groupUmur.getSelection() == null){
                    JOptionPane.showMessageDialog(null, "Tolong pilih Umur!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(getPass(txtPassword).length()<6){
                    JOptionPane.showMessageDialog(null, "Password harus lebih dari 5!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(!getPass(txtPassword).equals(getPass(txtConPass))) {
                    JOptionPane.showMessageDialog(null, "Confirmation Password tidak sama!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    clearAll();
                }
            }
        });
        
        
        
        setVisible(true);
    }
    
    private String getPass(JPasswordField pass){
        return new String(pass.getPassword());
    }
    
    private void clearAll(){
        txtUsername.setText("");
        txtPassword.setText("");
        txtConPass.setText("");
        groupUmur.clearSelection();
    }
    
    private void init() {
        //Inisialisasi
        panelAtas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelAtas.setBackground(Color.pink);
        
        panelBody = new JPanel (new GridLayout(4,2));
        panelBody.setBackground(Color.WHITE);
        
        panelBawah = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBawah.setBackground(Color.pink);
        
        panelUmur = new JPanel(new GridLayout(2,1));
        
        lblJudul = new JLabel("Registration Form");
        lblUsername = new JLabel("Username");
        lblUmur = new JLabel("Umur");
        lblPassword = new JLabel("Password");
        lblConPass = new JLabel("Confirmation Password");
        
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtConPass = new JPasswordField();
        
        radioDewasa = new JRadioButton("18+");
        radioAnak = new JRadioButton("<18");
        
        groupUmur = new ButtonGroup();
        groupUmur.add(radioAnak);
        groupUmur.add(radioDewasa);
        
        btnDaftar = new JButton("Daftar");
        btnReset = new JButton("Reset");
        
    }
    
    public static void main(String[] args) {
        new Main();
    }

    
}
