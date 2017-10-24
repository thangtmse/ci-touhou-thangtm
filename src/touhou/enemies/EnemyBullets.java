package touhou.enemies;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;
import touhou.Player;

import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyBullets extends GameObject {
   BoxCollider boxCollider;
   //long start;
   //long time;

    final int SPEED=5;

    public EnemyBullets(){
        image= Util.loadImage("assets/images/enemies/bullets/blue.png");
        boxCollider=new BoxCollider(30,20);
    }

    public void run(){
       // int count=0;
        position.y+=SPEED;
        boxCollider.position.set(this.position);
       Player player=GameObject.collideWidths(this.boxCollider);

       if(player!=null){
           //start=System.currentTimeMillis();
           //if(count==3){
               player.getHit();
               this.isActive=false;
               //count=0;
           //}

           //count++;
           //isActives=false;

//           if(time>start){
//            time=start+1000;
//               isActives=true;
//           }



       }

    }



}
