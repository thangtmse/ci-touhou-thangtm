package touhou;

import basic.GameObject;
import basic.Util;
import basic.Vector2D;
import basic.physics.BoxCollider;
import basic.physics.PhysicsBody;
import touhou.input.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;

public class Player extends GameObject implements PhysicsBody {


//    boolean rightPressed;
//    boolean leftPressed;
//    boolean upPressed;
//    boolean downPressed;
    final int SPEED = 5;
    final int LEFT = 0;
    final int RIGHT = 370;
    final int TOP = 0;
    //boolean xPressed;
    final int BOTTON = 500;
    public BoxCollider boxCollider;
    PlayerCastSpell spell = new PlayerCastSpell();

    long time;

    public Player() {
        position.set(182, 500);
//        isActives=true;
//        if(isActives==true){
        this.image = Util.loadImage("assets/images/players/straight/0.png");
        // }

        boxCollider = new BoxCollider(30, 30);
    }




    public void run() {

        move();
        if (InputManager.instance.xPressed) {
            spell.run(this);
        }
        boxCollider.position.set(this.position);
    }

    Vector2D velocity = new Vector2D();

    private void move() {
        velocity.set(0, 0);

        InputManager inputManager=InputManager.instance;
        if (inputManager.rightPressed) {
            velocity.x += SPEED;
        }
        if (inputManager.leftPressed) {
            velocity.x -= SPEED;
        }
        if (inputManager.upPressed) {
            velocity.y -= SPEED;
        }
        if (inputManager.downPressed) {
            velocity.y += SPEED;
        }
        position.add(velocity);
        position.x = (int) clamp(position.x, LEFT, RIGHT);
        position.y = (int) clamp(position.y, TOP, BOTTON);
    }


    private float clamp(float value, float min, float max) {
        if (value < min) {
            return min;

        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public void getHit() {
        isActive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
