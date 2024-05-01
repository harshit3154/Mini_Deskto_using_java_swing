/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

/**
 *
 * @author harsh
 */

import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import java.sql.PreparedStatement;
import java.sql.*;
public class Signup extends JFrame {
    
    public JFrame frame2;
    public JLabel l1,l2,l3,l4;
    public JTextField t1,t2;
    public JButton b1,b2;
    
    Signup(){
        frame2=new JFrame();
        frame2.setTitle("Login Screen");
        frame2.setSize(600, 600);
        frame2.setLocationRelativeTo(null);
        frame2.setLayout(null);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 600, 600);
        p.setBackground(new Color(0,90,90));
        frame2.add(p);
        p.setLayout(null);

        l1=new JLabel("Create account!!!");
        l1.setBounds(110,70,420,40);
        l1.setFont(new Font("Algerian",Font.ITALIC,30));

        l1.setHorizontalAlignment(SwingConstants.CENTER);
        l1.setVerticalAlignment(SwingConstants.CENTER);

        l1.setBackground(Color.YELLOW);
        l1.setOpaque(true);

        Border b=BorderFactory.createLineBorder(Color.RED,2);
        l1.setBorder(b);

        p.add(l1);
        p.setBorder(b);
        
        l2=new JLabel(" user_name : ");
        l2.setBounds(110,220,200,37);
        l2.setFont(new Font("Algerian",Font.ITALIC,30));
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.BLUE);
        l2.setOpaque(true);
        l2.setVerticalAlignment(SwingConstants.CENTER);
        l2.setHorizontalAlignment(SwingConstants.CENTER);

        t1=new JTextField();
        t1.setBounds(320,220,200,35);
        t1.setFont(new Font("Arial",Font.ITALIC,30));
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(t1);
        p.add(l2);


        l3=new JLabel(" password :");
        l3.setForeground(Color.WHITE);
        l3.setBounds(110,290,200,35);
        l3.setFont(new Font("Algerian",Font.ITALIC,30));
        l3.setBackground(Color.BLUE);
        l3.setOpaque(true);
        l3.setVerticalAlignment(SwingConstants.CENTER);
        l3.setHorizontalAlignment(SwingConstants.CENTER);

        t2=new JTextField();
        t2.setBounds(320,290,200,35);
        t2.setFont(new Font("Arial",Font.ITALIC,30));
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(t2);
        p.add(l3);

        b1=new  JButton("Create");
        b1.setBounds(240,370,100,35);
        p.add(b1);
        b1.setBackground(Color.BLUE);
        b1.setOpaque(true);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 if(insert(t1.getText(),t2.getText())){
                     setVisible(false);
                     new LoginPage();
                 }
             }
        });
        
        
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public static boolean insert(String user_name,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lpu","root","");
            String q="""
                     insert into user_info(user_name,password) 
                     value(?,?)
                     """;
            PreparedStatement stmt=conn.prepareStatement(q);
            stmt.setString(1,user_name);
            stmt.setString(2,password);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"User account has been created succcessfully");
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public static void main(String... args){
        new Signup();
    }
}
