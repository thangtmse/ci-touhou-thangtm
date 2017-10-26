package basic;

import basic.physics.BoxCollider;
import basic.physics.PhysicsBody;
import touhou.Player;
import touhou.PlayerCastSpell;
import touhou.PlayerSpell;
import touhou.enemies.Enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public BufferedImage image;
    static Vector<GameObject> gameObjects = new Vector<>();
    static Vector<GameObject> newGameObject = new Vector<>();
    public boolean isActive;

    // public boolean isActives;
    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.run();
            }

        }
        gameObjects.addAll(newGameObject);
        newGameObject.clear();
    }

    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g);
            }

        }
        //gameObjects.addAll(newGameObject);
        //newGameObject.clear();
    }

    public static void add(GameObject gameObject) {
        newGameObject.add(gameObject);
    }

    public void run() {

    }

    public void render(Graphics g) {
        if (image != null) {
            g.drawImage(image, (int) position.x - image.getWidth() / 2, (int) position.y - image.getHeight() / 2, null);
        }
    }

    public static <T extends PhysicsBody> T collideWith(BoxCollider boxCollider, Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (!gameObject.isActive) continue;
            if (!(gameObject instanceof PhysicsBody)) continue;
            if (!(gameObject.getClass().equals(cls))) continue;

            BoxCollider otherBoxCollider = ((PhysicsBody) gameObject).getBoxCollider();
            if (otherBoxCollider.collideWidth(boxCollider)) {
                return (T) gameObject;
            }
        }
        return null;
    }


    public static <T extends GameObject>T recycle(Class<T> cls) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive == false && gameObject.getClass().equals(cls)) {
                gameObject.isActive=true;

                return (T) gameObject;


            }
        }
        try {
            T newGameObject=cls.newInstance();//new
            GameObject.add(newGameObject);
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }


    }


}
