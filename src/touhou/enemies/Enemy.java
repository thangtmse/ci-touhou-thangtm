package touhou.enemies;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;
import basic.physics.PhysicsBody;
import touhou.Player;

public class Enemy extends GameObject implements PhysicsBody {
    long time;
    public BoxCollider boxCollider;
    PlayerDamage playerDamage=new PlayerDamage();

    public Enemy() {
        this.image= Util.loadImage("assets/images/enemies/level0/blue/0.png");
        boxCollider=new BoxCollider(30,30);
    }
    public void run(){
        position.addUp(0,2);
        boxCollider.position.set(this.position);
        shoot();
       playerDamage.run(this);
        }

    public void shoot(){
        long start=System.currentTimeMillis();

        if(start>time){
            time=start+1000;
            EnemyBullets bullets=GameObject.recycle(EnemyBullets.class);
            //System.out.println("shoot");

            bullets.position.set(this.position);
            //GameObject.add(bullets);

        }
}


    public void getHit() {
        isActive=false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
