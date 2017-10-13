import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    BufferedImage player;
    int playerX=182;
    int playerY=300;
    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;
    public GameCanvas(){
        //1.load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player =ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

       g.drawImage(background,0,0,null);
       g.drawImage(player,playerX,playerY,null);
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){

            rightPressed = true;

        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){

            leftPressed =true;

        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
        upPressed=true;

        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=true;

        }

    }

    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){

            rightPressed = false;

        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){

            leftPressed =false;

        }
        if(e.getKeyCode()==KeyEvent.VK_UP){
            upPressed=false;

        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            downPressed=false;

        }
    }
    public void run(){
        int vx=0;
        int vy=0;

        if(rightPressed){
            vx+=5;
        }if(leftPressed){
            vx-=5;
        }if(upPressed){
            vy-=5;
        }if(downPressed){
            vy+=5;
        }
        playerX=playerX+vx;
        playerY=playerY+vy;
    }
}
