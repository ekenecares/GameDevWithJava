package pkg2dgamedev;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Hero {
    GameTerminal gt;
    BufferedImage hero;
    public Hero(GameTerminal gt){
        this.gt = gt;
        load();
    }
    
    public void load(){
        try {
            hero = ImageIO.read(getClass().getResourceAsStream("/idle/idle1.png"));
        } catch (IOException ex) {
            Logger.getLogger(Hero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void draw(Graphics2D g2){
       g2.drawImage(hero, 0, 0, gt.tileSize, gt.tileSize, null);
    }
}
