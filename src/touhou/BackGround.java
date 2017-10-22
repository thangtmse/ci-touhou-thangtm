package touhou;

import basic.GameObject;
import basic.Util;

public class BackGround extends GameObject{

    public BackGround() {
        position.set(0,0);
        image= Util.loadImage("assets/images/background/0.png");
    }
    public void run(){
        position.y--;
        if(position.y<=-image.getHeight()){
            position.y++;
        }
    }
}
