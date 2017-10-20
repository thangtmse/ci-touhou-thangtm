package touhou;

import basic.GameObject;
import basic.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Enemies extends GameObject {
    BufferedImage enemies;

    int SPEED ;
    int y=3;
    Random rd=new Random();
    long time;

    int x=rd.nextInt(200);
    public Enemies(){

        enemies= Util.loadImage("assets/images/enemies/level0/black/0.png");
    }
    public void render(Graphics g){


        g.drawImage(enemies,x,y, null);
        return;

    }


    public void shoot(){
        long start=System.currentTimeMillis();

        if(start>time){
            time=start+1000;
            EnemyBullets bullets=new EnemyBullets();

            bullets.x=x;
            bullets.y=y;
            GameObject.add(bullets);

        }

    }
    public void move(){
       x++;
       if(x<0){
           SPEED=3;
       }else if(x>360){
           SPEED=-3;
       }
       x+=SPEED;




    }

    public void run() {
       shoot();
       move();
    }


}
