package basic;

import basic.physics.BoxCollider;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
   public Vector2D position;
    public BufferedImage image;
    static Vector<GameObject> gameObjects=new Vector<>();
    static Vector<GameObject> newGameObject=new Vector<>();
    public boolean isActive;
    public static void runAll(){
        for(GameObject gameObject:gameObjects){
            if(gameObject.isActive){
                gameObject.run();
            }

        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }
    public GameObject(){
      position=new Vector2D();
      isActive=true;
    }
    public static void renderAll(Graphics g){
        for(GameObject gameObject:gameObjects){
            if(gameObject.isActive){
                gameObject.render(g);
            }

        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }
    public static void add(GameObject gameObject){
        newGameObject.add(gameObject);
    }
    public void run(){

    }
    public void render(Graphics g){
        if(image!=null){
            g.drawImage(image,(int)position.x-image.getWidth()/2,(int)position.y-image.getHeight()/2,null);
        }
    }
     public static Enemy collideWidth(BoxCollider boxCollider){
        for(GameObject gameObject:gameObjects){
            if(gameObject instanceof  Enemy){
                Enemy enemy=(Enemy)gameObject;
                if(enemy.boxCollider.collideWidth(boxCollider)){
                    return enemy;
                }
            }
        }
        return null;
     }


}
