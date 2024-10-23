package pkg2dgamedev;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame runner = new JFrame();
        GameTerminal gt = new GameTerminal();
        runner.add(gt);     
        runner.pack();
        runner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        runner.setFocusable(false);
        runner.setVisible(true);
        runner.setLocationRelativeTo(null);
        gt.run();
    }
}
