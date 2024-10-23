package pkg2dgamedev;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GameTerminal extends JPanel implements Runnable{
    int FPS  = 60;
    public int tileCol = 20;
    public int tileRow = 12;
    public int tileSize = 150;
    public int screenWidth = tileCol * tileSize ;
    public int screenHeight = tileRow * tileSize;
    
    BufferedImage img;
    Thread thread;
    World world1 = new World(this);
    Hero hero = new Hero(this);
    public GameTerminal(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setFocusable(false);
        this.setBackground(Color.black);
    }
 
    @Override
    public void run() {
        thread = new Thread();
        thread.start();
        while (thread!=null){
            double sysTime = System.nanoTime();
            System.out.println(sysTime);
            double frameMiliss = FPS/1_000_000_000;
            update();
            repaint();
        }
    }
    
    public void update(){
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/idle/idle1.png"));
        } catch (IOException ex) {
            ex.getMessage();
        } 
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        world1.draw(g2);
        //hero.draw(g2);
        g2.dispose();
    }
}
