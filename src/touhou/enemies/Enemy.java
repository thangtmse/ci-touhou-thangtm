package touhou.enemies;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;

public class Enemy extends GameObject {
    long time;
    public BoxCollider boxCollider;

    public Enemy() {
        this.image= Util.loadImage("assets/images/enemies/level0/blue/0.png");
        boxCollider=new BoxCollider(30,30);
    }
    public void run(){
        position.addUp(0,2);
        boxCollider.position.set(this.position);
        shoot();
    }
    public void shoot(){
        long start=System.currentTimeMillis();

        if(start>time){
            time=start+1000;
            EnemyBullets bullets=new EnemyBullets();

            bullets.position.set(this.position);
            GameObject.add(bullets);

        }
}

    public void getHit() {
        isActive=false;
    }
}
