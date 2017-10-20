package touhou;

import basic.GameObject;
import basic.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject {

    final int SPEED=8;

    public PlayerSpell() {
        image= Util.loadImage("assets/images/player-bullets/a/0.png");
    }

    public void run(){
        y-=SPEED;
        }
    }

