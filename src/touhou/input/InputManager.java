package touhou.input;

import java.awt.event.KeyEvent;

public class InputManager {
    //tracking user input
    //provide input states for other class
   public boolean rightPressed;
  public  boolean leftPressed;
    public  boolean upPressed;
    public boolean downPressed;
    public boolean xPressed;
    //singleton
    public final static InputManager instance=new InputManager();
    private  InputManager(){

    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            rightPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            leftPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;
        }


    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            rightPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            leftPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }
    }
}
