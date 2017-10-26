package touhou;

import basic.GameObject;

public class PlayerCastSpell {
    long time;

    public void run(Player owner){
        long start=System.currentTimeMillis();


            if(start>time){
                time=start+200;
                PlayerSpell newSpell=GameObject.recycle(PlayerSpell.class);
                newSpell.position.set(owner.position);








        }
}}
