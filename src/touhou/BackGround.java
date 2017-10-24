package touhou;

import basic.GameObject;
import basic.Util;

public class BackGround extends GameObject{

    public BackGround() {

        image= Util.loadImage("assets/images/background/0.png");
        position.set(0+image.getWidth()/2,0+image.getHeight()/2);
    }
    public void run(){
        position.y--;
        if(position.y<=-image.getHeight()){
            position.y++;
        }
    }
}
