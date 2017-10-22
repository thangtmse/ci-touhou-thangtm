package basic.physics;

import basic.Vector2D;

public class BoxCollider {
    public Vector2D position;
    public float width;
    public float height;

    public BoxCollider(float width, float height) {
        this.position=new Vector2D();
        this.width = width;
        this.height = height;
    }

    public float left(){
        return position.x-width/2;
    }
    public float right(){
        return position.x+width/2;
    }
    public float top(){
        return position.y-height/2;
    }
    public float bot(){
        return position.y+height/2;
    }

    public boolean collideWidth(BoxCollider other){
        if(this.left()>=other.left()&&this.left()<=other.right()&&this.bot()>=other.top()&&this.top()<=other.bot()){
            return true;
        }else{
            return false;
        }
    }
}
