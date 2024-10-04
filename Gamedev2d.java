package gamedev2d;

import java.awt.Color;
import javax.swing.JFrame;

public class Gamedev2d {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        GameConsole gc = new GameConsole();
        
        jf.add(gc);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setBackground(Color.black);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        gc.gameThread();
        gc.run();
    }
}
