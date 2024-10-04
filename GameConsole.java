
package gamedev2d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class GameConsole extends JPanel implements Runnable {
    int FPS = 60;
    public int tileSize = 180;
    public int screenColumn = 25;
    public int screenRow = 20;
    public int screenWidth = 2600;
    public int screenHeight = 1800;
    Thread threads;  
    Keys key = new Keys();
    Player player = new Player(this, key);
    
    public GameConsole() {
        this.setPreferredSize(new Dimension (screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.setBackground(Color.black);
        this.addKeyListener(key);
        this.setFocusable(true);
    }
    
    public void gameThread(){
        threads = new Thread(this);
        threads.start();
    }
      
    @Override
    public void run(){
            int perSecond = 1000000000/FPS;
           double gameTime = System.nanoTime() + perSecond;
            while (threads != null){
            update();
            repaint();
  
            try {
            double remainingTime = gameTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
            if (remainingTime < 0){
            remainingTime = 0;
            }
            threads.sleep((long) remainingTime);
            gameTime += perSecond;
        } catch (InterruptedException ex) {
            Logger.getLogger(GameConsole.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }
    
    public void update(){
       player.upDate();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        player.paint((Graphics2D) g);
    }
}
