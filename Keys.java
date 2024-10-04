
package gamedev2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keys implements KeyListener{
    boolean keyUp, keyDown, keyLeft, keyRight;

    @Override
    public void keyTyped(KeyEvent ke) {
      // not used
    }

    @Override
    public void keyPressed(KeyEvent ke) {
      int code =  ke.getKeyCode();
      if (code == ke.VK_UP ){
          keyUp = true;
      }

      if (code == ke.VK_DOWN ){
          keyDown = true;
      }

      if (code == ke.VK_LEFT ){
          keyLeft = true;
      }

      if (code == ke.VK_RIGHT ){
          keyRight = true;
      }      
    }

    @Override
    public void keyReleased(KeyEvent ke) {
      int code =  ke.getKeyCode();
      if (code == ke.VK_UP ){
          keyUp = false;
      }

      if (code == ke.VK_DOWN ){
          keyDown = false;
      }

      if (code == ke.VK_LEFT ){
          keyLeft = false;
      }

      if (code == ke.VK_RIGHT ){
          keyRight = false;
      }   
    }
    
}
