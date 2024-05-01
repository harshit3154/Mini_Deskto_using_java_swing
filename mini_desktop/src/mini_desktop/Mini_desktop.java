/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mini_desktop;

/**
 *
 * @author harsh
 */

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Mini_desktop extends JFrame{

    /**
     * @param args the command line arguments
     */
    
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1;
    
    Mini_desktop(){
        setTitle("Login Screen");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JPanel p = new JPanel();
        p.setBounds(3, 9, 1180, 550);
        p.setBackground(Color.WHITE);
        add(p);
        p.setLayout(null);

        l1=new JLabel("Login Screen.");
        l1.setBounds(390,40,500,40);
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
        l2.setBounds(450,160,200,37);
        l2.setFont(new Font("Algerian",Font.ITALIC,30));
        l2.setForeground(Color.WHITE);
        l2.setBackground(Color.BLUE);
        l2.setOpaque(true);
        l2.setVerticalAlignment(SwingConstants.CENTER);
        l2.setHorizontalAlignment(SwingConstants.CENTER);

        t1=new JTextField();
        t1.setBounds(660,160,200,35);
        t1.setFont(new Font("Arial",Font.ITALIC,30));
        t1.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(t1);
        p.add(l2);


        l3=new JLabel(" password :");
        l3.setForeground(Color.WHITE);
        l3.setBounds(450,230,200,35);
        l3.setFont(new Font("Algerian",Font.ITALIC,30));
        l3.setBackground(Color.BLUE);
        l3.setOpaque(true);
        l3.setVerticalAlignment(SwingConstants.CENTER);
        l3.setHorizontalAlignment(SwingConstants.CENTER);

        t2=new JTextField();
        t2.setBounds(660,230,200,35);
        t2.setFont(new Font("Arial",Font.ITALIC,30));
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        t2.setHorizontalAlignment(SwingConstants.CENTER);
        p.add(t2);
        p.add(l3);

        b1=new  JButton("Login");
        b1.setBounds(550,320,100,35);
        p.add(b1);
        b1.setBackground(Color.BLUE);
        b1.setOpaque(true);
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Arial",Font.BOLD,20));

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Initiating the prcoess");
        new Mini_desktop();
    }
    
}
