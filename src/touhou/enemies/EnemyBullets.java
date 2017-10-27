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

        position.addUp(0,SPEED);
        boxCollider.position.set(this.position);
       Player player=GameObject.collideWith(this.boxCollider,Player.class);

       if(player!=null){

               player.getHit();
               this.isActive=false;




       }

    }



}
