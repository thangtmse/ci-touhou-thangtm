package touhou;

import basic.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell {
    BufferedImage bullets;
   public int x;
   public int y;
    final int SPEED=8;

    public PlayerSpell() {
        bullets= Util.loadImage("assets/images/player-bullets/a/0.png");
    }
    public void render(Graphics graphics){
        graphics.drawImage(bullets,x,y,null);
    }
//   public void keyPressed(KeyEvent e){
//        if(e.getKeyCode()==KeyEvent.VK_X){
//
//        }
//   }
    public void run(){
        y-=SPEED;
        }
    }

