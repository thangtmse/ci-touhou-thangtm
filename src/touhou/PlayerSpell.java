package touhou;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;
import touhou.enemies.Enemy;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PlayerSpell extends GameObject {
        BoxCollider boxCollider;
    final int SPEED=8;

    public PlayerSpell() {

        image= Util.loadImage("assets/images/player-bullets/a/0.png");
        boxCollider=new BoxCollider(30,20);
    }

    public void run(){
        position.y-=SPEED;
        boxCollider.position.set(this.position);

        Enemy enemy=GameObject.collideWidth(this.boxCollider);
        if(enemy!=null){
            enemy.getHit();
        }
        }
    }

