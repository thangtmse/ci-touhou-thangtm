package touhou;

import basic.GameObject;
import basic.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullets extends GameObject {
    BufferedImage image;
    int x;
    int y;
    final int SPEED=5;

    public EnemyBullets(){
        image= Util.loadImage("assets/images/enemies/bullets/blue.png");
    }
    public void render(Graphics g){
        g.drawImage(image,x,y,null);

    }
    public void run(){
        y+=SPEED;
    }


}
