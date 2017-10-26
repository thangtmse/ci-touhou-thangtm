package touhou.enemies;

import basic.FrameCounter;
import basic.GameObject;
import touhou.BackGround;

import java.util.Random;

public class EnemySpawner extends GameObject {
    BackGround backGround=new BackGround();
    FrameCounter frameCounter=new FrameCounter(200);
    Random rd=new Random();
    @Override
    public void run() {
       if(frameCounter.run()){

           frameCounter.reset();
           spawn();
       }
    }

    private void spawn() {
        Enemy enemy=GameObject.recycle(Enemy.class);
        System.out.println("ok");
        enemy.position.set(rd.nextInt(backGround.image.getWidth()-50),10);

        //GameObject.add(enemy);
    }
}
