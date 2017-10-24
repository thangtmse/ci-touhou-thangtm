package touhou;

import basic.GameObject;
import basic.Util;
import basic.Vector2D;
import basic.physics.BoxCollider;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Timer;

public class Player extends GameObject {



    boolean rightPressed;
    boolean leftPressed;
    boolean upPressed;
    boolean downPressed;
    final int SPEED=5;
    final int LEFT=0;
    final int RIGHT=370;
    final int TOP=0;
    boolean xPressed;
    final int BOTTON=500;
    public BoxCollider boxCollider;

     long time;
    public Player(){
        position.set(182,500);
//        isActives=true;
//        if(isActives==true){
            this.image= Util.loadImage("assets/images/players/straight/0.png");
       // }

        boxCollider=new BoxCollider(30,30);
    }


    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            rightPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            leftPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;

        }
        if(e.getKeyCode()==KeyEvent.VK_X){
            xPressed=true;
        }


    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

            rightPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {

            leftPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;

        }
        if(e.getKeyCode()==KeyEvent.VK_X){
            xPressed=false;
        }
    }

    public void run() {
        boxCollider.position.set(this.position);
        move();
  shoot();
    }
    Vector2D velocity=new Vector2D();
    private void move() {
        velocity.set(0,0);


        if (rightPressed) {
            velocity.x += SPEED;
        }
        if (leftPressed) {
            velocity.x -= SPEED;
        }
        if (upPressed) {
            velocity.y -= SPEED;
        }
        if (downPressed) {
            velocity.y += SPEED;
        }
        position.add(velocity);
        position.x=(int)clamp(position.x,LEFT,RIGHT);
        position.y=(int)clamp(position.y,TOP,BOTTON);
    }


     public void shoot(){

           long start=System.currentTimeMillis();

         if(xPressed){
             if(start>time){
                 time=start+200;
                 PlayerSpell newSpell=new PlayerSpell();
                 newSpell.position.set(this.position);

                 GameObject.add(newSpell);



             }


         }


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
         isActive=false;
    }
}
