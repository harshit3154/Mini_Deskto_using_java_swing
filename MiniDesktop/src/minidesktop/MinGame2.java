/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minidesktop;

/**
 *
 * @author harsh
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MinGame2 extends Canvas
{
    int x=0, y=0;
    static private boolean left, right = true;
    static public void main(String... ss)
    {
        JFrame f = new JFrame("Graphics Demo");
        f.setSize(500, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        MinGame2 ob = new MinGame2();
        f.add(ob);

        class Listener extends KeyAdapter
        {
            public void keyPressed(KeyEvent k)
            {
                if(k.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    left = true; right = false;
                }
                else if(k.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    left = false; right = !false;
                }
            }
        }

            ob.addKeyListener(new Listener());

            f.setVisible(true);
        }

    void move()
    {
        if(right) x++;
            else if(left) x--;
        if(x ==450) x = 0;
        try{ Thread.sleep(10); }
        catch(Exception ex) {}
        repaint();
    }
    public void paint(Graphics g){
    g.setColor(Color.BLUE);
    g.setFont(new Font("ROCKWELL", 3, 36));
    g.drawString("India", 100, 100 );
    g.setColor(Color.YELLOW);
    g.fillRoundRect(0+x, 300+y, 100, 60, 35, 20);
    move();
    }
}
