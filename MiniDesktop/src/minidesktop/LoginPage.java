/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 *
 * @author harsh
 */
public class LoginPage extends JFrame{
    public JFrame frame;
    public JLabel l1,l2,l3,l4;
    public JTextField t1,t2;
    public JButton b1,b2;
    LoginPage(){
        frame=new JFrame();
        frame.setTitle("Login Screen");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 600, 600);
        p.setBackground(Color.WHITE);
        frame.add(p);
        p.setLayout(null);

        l1=new JLabel("Login Screen.");
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

        b1=new  JButton("Login");
        b1.setBounds(240,370,100,35);
        p.add(b1);
        b1.setBackground(Color.BLUE);
        b1.setOpaque(true);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,20));
        b1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 //Verify verify=new Verify();
                 boolean flag=Verify.check(t1.getText(),t2.getText());
                 if(flag){
                     JOptionPane.showMessageDialog(null,"Logged in succesfully");
                     frame.setVisible(false);
                     new Home();
                 }
                 else{
                     JOptionPane.showMessageDialog(null,"Wrong Password");
                     
                 }
             }
        });
        
        l4=new JLabel("Donot have account..?");
        l4.setFont(new Font("Algerian",Font.BOLD,20));
        l4.setBounds(130,440,260,35);
        p.add(l4);
       
        b2=new  JButton("Create One");
        b2.setBounds(260,500,230,35);
        p.add(b2);
        b2.setBackground(Color.BLUE);
        b2.setOpaque(true);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial",Font.BOLD,20));
        b2.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                 frame.setVisible(false);
                 new Signup();
             }
        });
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String... args){
        new LoginPage();
    }
}
