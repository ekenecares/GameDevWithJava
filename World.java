package pkg2dgamedev;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class World {
    GameTerminal gt;
    Tile[] tiles;
    public World(GameTerminal gt){
        this.gt = gt;
        tiles = new Tile[11];
        load();
    }

    private World() {
    }
    
    public void load (){
        try {
            InputStream input = getClass().getResourceAsStream("/maps/normal_map.txt");
            BufferedReader read = new BufferedReader( new InputStreamReader(input));
                    String reader = read.readLine();
                    String[] allNum = reader.split(reader);
                   System.out.println(allNum[0]);
            tiles[1] = new Tile();
            tiles[1].tile = ImageIO.read(getClass().getResourceAsStream("/tile/grass.png"));
            tiles[2] = new Tile();
            tiles[2].tile = ImageIO.read(getClass().getResourceAsStream("/tile/tile2.png"));
            tiles[3] = new Tile();
            tiles[3].tile = ImageIO.read(getClass().getResourceAsStream("/tile/tile2.png"));
            tiles[4] = new Tile();
            tiles[4].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road.png"));
            tiles[5] = new Tile();
            tiles[5].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-left1.png"));
            tiles[6] = new Tile();
            tiles[6].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-right1.png"));
            tiles[7] = new Tile();
            tiles[7].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-up1.png"));
            tiles[8] = new Tile();
            tiles[8].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-down1.png"));
            tiles[9] = new Tile();
            tiles[9].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-right-curve.png"));        
            tiles[10] = new Tile();
            tiles[10].tile = ImageIO.read(getClass().getResourceAsStream("/tile/road-down-curve.png"));
        } catch (IOException ex) {
            Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void draw(Graphics2D g2){
        int x = 0;
        int y = 0;
        for(int col = 0; col<=gt.tileCol; col++ ){
            for(int row =0; row < gt.tileRow; row++){
                g2.drawImage(tiles[1].tile, x, y, gt.tileSize, gt.tileSize, null);
                y+=gt.tileSize;
            }
            x+=gt.tileSize;
            y=0;
        }
    }
}
