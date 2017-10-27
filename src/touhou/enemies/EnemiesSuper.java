package touhou.enemies;

import basic.GameObject;
import basic.Util;
import basic.physics.BoxCollider;
import basic.physics.PhysicsBody;

public class EnemiesSuper extends GameObject implements PhysicsBody{
    BoxCollider boxCollider;
    long time;
    PlayerDamage playerDamage=new PlayerDamage();
    public EnemiesSuper(){
        image= Util.loadImage("assets/images/enemies/level0/pink/0.png");
     boxCollider =new BoxCollider(30,30);
    }
    public void run(){
        position.addUp(0,2);
        boxCollider.position.set(this.position);
        shoot();
        playerDamage.otherRun(this);
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
