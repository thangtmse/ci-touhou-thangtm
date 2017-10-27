package touhou.enemies;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;
import touhou.Player;

public class EnemyBulletSuper extends GameObject {
    BoxCollider boxCollider;
    final int SPEED=5;
    public EnemyBulletSuper(){
        image= Util.loadImage("assets/images/enemies/bullets/pink.png");
        boxCollider=new BoxCollider(30,30);

    }
    public void run(){
        this.position.addUp(2,SPEED);
        boxCollider.position.set(this.position);
        Player player=GameObject.collideWith(this.boxCollider,Player.class);

        if(player!=null){

            player.getHit();
            this.isActive=false;




        }
    }
}
