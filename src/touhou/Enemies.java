package touhou;

import basic.Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Enemies {
    BufferedImage enemies;
    //EnemyBullets bullets=new EnemyBullets();
    int SPEED ;
    int y=3;
    Random rd=new Random();
    long time;

    int x=rd.nextInt(200);
    public Enemies(){
//        enemies= Util.loadImage("assets/images/enemies/explosion-big/0.png");
        enemies= Util.loadImage("assets/images/enemies/level0/black/0.png");
    }
    public void render(Graphics g){


        g.drawImage(enemies,x,y, null);
        return;

    }


    public void shoot(ArrayList<EnemyBullets> enemyBullet){
        long start=System.currentTimeMillis();

        if(start>time){
            time=start+400;
            EnemyBullets bullets=new EnemyBullets();
            bullets.x=x;
            bullets.y=y;
            enemyBullet.add(bullets);

        }

    }

    public void run(int width) {
        x++;
       if(x>width){
           SPEED=-3;
       }else if(x<0){
           SPEED=2;
       }
       x+=SPEED;
    }

    @Override
    public String toString() {
        return "Enemies{" +
                ", x=" + x +
                ", y=" + y +
                ", rd=" + rd +
                '}';
    }
}
