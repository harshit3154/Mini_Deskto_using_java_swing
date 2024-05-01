/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author harsh
 */




class manage extends Thread{
    Random r=new Random();
   
    int x=10+r.nextInt(600);
    int y=10+r.nextInt(600);
    
    private volatile boolean running=true;
    private volatile char key='f';

    public void run() {
        System.out.println("Thread started");
        try{
         
            while(running){
                if(x==0||x==800||y==0||y==800){
                    JOptionPane.showMessageDialog(null,"Game ended");
                    stoptThread();            
                    
                }
                
                if(key=='l')
                    x++;
                else if(key=='j')
                    x--;
                else if(key=='i')
                    y--;
                else if(key=='k')
                    y++;
                else{
                    x++;
                    y++;
                }
                
                MinGame.l.setBounds(x,y,100,100);
                Thread.sleep(8);
            }
        }catch(Exception e){
        }
    }
    
    public void stopThread(){
        running=false;
        Thread.currentThread().interrupt();
    }
    
    public void modify(char ch){
        key=ch;
    }
    
}
public class MinGame extends JFrame implements KeyListener{
 
    public static JLabel l;
    public static ImageIcon i;
    int x,y;
    manage m;
    MinGame(int xx,int yy){
        x=xx;
        y=yy;
        setTitle("Ball balancer game");
        setSize(900,800);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JPanel p=new JPanel();
        p.setBounds(0,0,900,800);
        add(p);
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        i=new ImageIcon(getClass().getResource("game45.png"));
        l=new JLabel(i);
        l.setBounds(x,y,i.getIconHeight(),i.getIconWidth());
        p.add(l);
        
//        t=new Thread(new manage());
//        t.start();

        m=new manage();
        m.start();
        
        JTextArea b=new JTextArea();
        b.setBounds(620,620,40,40);
        p.add(b);
        b.addKeyListener(this);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        m.modify(e.getKeyChar());
    }   

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public static void main(String... main){
        new MinGame(2,3);
    }
}
