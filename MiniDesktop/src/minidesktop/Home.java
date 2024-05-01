/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

/**
 *
 * @author harsh
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.Random;

public class Home extends JFrame{
    Home(){
        new JFrame();
        setTitle("Home Page");
        setSize(900,600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JPanel p=new JPanel();
        p.setBounds(0,0,900,600);
        p.setBackground(Color.white);
        p.setLayout(null);
        add(p);
        
        ImageIcon i=new ImageIcon(getClass().getResource("Notpad.png"));
        JButton b1=new JButton(i);
        b1.setBounds(120,120,i.getIconWidth(),i.getIconHeight());
        p.add(b1);

        b1.addActionListener((ActionEvent e) -> {
            new Notepad();
        });
        
        ImageIcon i2=new ImageIcon(getClass().getResource("game45.png"));
        JButton b2=new JButton(i2);
        b2.setBounds(120,280,i.getIconWidth(),i.getIconHeight());
        p.add(b2);

        b2.addActionListener((ActionEvent e) -> {
            Random r=new Random();
            new MinGame(r.nextInt(500)+200,r.nextInt(500)+200);
        });
        
        JButton b3=new JButton("Logout");
        b3.setFont(new Font("Aerial",Font.BOLD,20));
        b3.setBounds(620,10,100,30);
        p.add(b3);

        b3.addActionListener((ActionEvent e) -> {
            new LoginPage();
        });
        
        JButton b4=new JButton("Date and time");
        b4.setFont(new Font("Aerial",Font.BOLD,20));
        b4.setBounds(620,500,180,25);
        p.add(b4);

        b4.addActionListener((ActionEvent e) -> {
            LocalDateTime ob=LocalDateTime.now();
            JOptionPane.showMessageDialog(null,"data and time is\n"+ob);
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String... args){
        new Home();
    }
}
