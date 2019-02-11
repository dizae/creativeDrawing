/**
* An interactive creative drawing of a car.
* 
* @Diza
*/

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.util.Scanner;


public class BoardFace  extends JPanel implements Runnable, MouseListener
{
    
    private Dimension d;
    int BOARD_WIDTH=500;
    int BOARD_HEIGHT=500;
    int x = 0;
    private Thread animator;
    private boolean clicked;
     
    public BoardFace()
                {
                    addMouseListener(this);
                    setFocusable(true);
                    d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
                   
                    if (animator == null ) {
                        animator = new Thread(this);
                        animator.start();
                    }         
              
                      setDoubleBuffered(true);
                     }
    
    
    public void paint(Graphics g){
            super.paint(g);
            //background
            g.setColor(Color.white);
            g.fillRect(0,0, d.height, d.width);
            //car body
            Color red = new Color (255, 0, 0);
            g.setColor(red);
            g.fillRect(100, 200, 300, 150);
            g.fillRect(125, 100, 250, 100);
            //car tires
            g.setColor(Color.black);
            g.fillRect(110, 340, 60, 50);
            g.fillRect(330, 340, 60, 50);
            //car rear window
            Color lightblue = new Color (139, 216, 244);
            g.setColor(lightblue);
            g.fillRect(140, 110, 220, 85);
            //car side windows
            g.fillRect(80, 170, 45, 30);
            g.fillRect(375, 170, 45, 30);
            //car license plate
            g.setColor(Color.white);
            g.fillRect(205, 300, 90, 40);
            //car trunk
            Color darkred = new Color (214, 2, 2);
            g.setColor(darkred);
            g.fillRect(110, 205, 280, 60);
            g.setColor(red);
            g.fillRect(114, 205, 272, 55);
            //car rear lights
            Color lightyellow = new Color (255, 235, 181);
            g.setColor(lightyellow);
            g.fillOval(110, 290, 60, 35);
            g.fillOval(330, 290, 60, 35);
            
            
            //writing- your brand new car!
            //and to add text to the drawing with a slight shadow...
            g.setColor(darkred);
            g.setFont (new Font("Arial", Font.PLAIN, 40));
            g.drawString("Your Brand New Car!" ,  72,  452);
            g.setColor(Color.black);
            g.setFont (new Font("Arial", Font.PLAIN, 40));
            g.drawString("Your Brand New Car!" ,  70,  450);
            
            
            if (clicked == true) { //following boolean of mouseClicked
                //rear lights flash orange
                g.setColor(Color.orange);
                g.fillOval(110, 290, 60, 35);
                g.fillOval(330, 290, 60, 35);
                //car honks
                g.setColor(Color.black);
                g.setFont (new Font("Arial", Font.BOLD, 60));
                g.drawString("HONK!" , 150,  70);
            } 
          
            
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
    }
   
    public void run() {
    
        long beforeTime, timeDiff, sleep;
    
        beforeTime = System.currentTimeMillis();
        int animationDelay = 500;
        long time = 
                System.currentTimeMillis();
        while (true) {//infinite loop
         // spriteManager.update();
          repaint();
          try {
            time += animationDelay;
            Thread.sleep(Math.max(0,time - 
              System.currentTimeMillis()));
          }
          catch (InterruptedException e) {
            System.out.println(e);
          }//end catch
        }//end while loop
    
    }//end of run
    
    
    
    public void mousePressed(MouseEvent e) {
         int x = e.getX();
         int y = e.getY();
    
    }
    
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void mouseEntered(MouseEvent e) {
    
    }
    
    public void mouseExited(MouseEvent e) {
    
    }
    
    public void mouseClicked(MouseEvent e) {
        clicked = true; //identifies when to do clicked action
    }

}//end of class