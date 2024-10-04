package gamedev2d;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Player extends Entity{
    GameConsole gc;
    Keys key = new Keys();

    public Player( GameConsole gc, Keys key){
        this.gc = gc;
        this.key = key;
        setEntity();
        playerImgs();
    }
    
    public void playerImgs(){
        try{
            img1 = ImageIO.read(getClass().getResourceAsStream("/idle/idle1.png"));
            img2 = ImageIO.read(getClass().getResourceAsStream("/idle/idle3.png"));
            img3 = ImageIO.read(getClass().getResourceAsStream("/idle/idle5.png"));
            img4 = ImageIO.read(getClass().getResourceAsStream("/idle/idle6.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/up/up1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/idle/idle6.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/left/left (1).png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/right/right (1).png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public final void setEntity(){
     centerX = 1300;
     centerY = 900;
     objWidth = 180;
     objHeight = 180;
     moveSpeed = 5;
    }
    
    public void upDate(){
        if(key.keyUp == true){
            direction = "up";
            centerY -=moveSpeed;
        }
        
        else if(key.keyDown == true){
            direction = "down";
            centerY += moveSpeed;
        }
                
        else if(key.keyLeft == true){
            direction = "left";
            centerX -=moveSpeed;
        } 
        
        else if(key.keyRight == true){
            direction = "right";
            centerX +=moveSpeed;
        }
    }
    
    public void paint(Graphics2D g2){
        BufferedImage image = null;
        switch(direction){
            case "up": image = up1;
            break;
            case "left": image = left1;
            break;
            case "down": image = down1;
            break;
            case "right": image = right1;
            break;
        }
        g2.drawImage(image, centerX, centerY, objWidth, objHeight, null);
        g2.dispose();
    }
}
