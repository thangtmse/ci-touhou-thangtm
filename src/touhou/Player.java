package touhou;

import basic.GameObject;
import basic.Util;

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
    final int SPEED=2;
    final int LEFT=0;
    final int RIGHT=360;
    final int TOP=0;
    boolean xPressed;
    final int BOTTON=500;

     long time;
    public Player(){
        x=182;
        y=500;
        image= Util.loadImage("assets/images/players/straight/0.png");
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
        move();
  shoot();
    }

    private void move() {
        int vx = 0;
        int vy = 0;

        if (rightPressed) {
            vx += SPEED;
        }
        if (leftPressed) {
            vx -= SPEED;
        }
        if (upPressed) {
            vy -= SPEED;
        }
        if (downPressed) {
            vy += SPEED;
        }
        x = x + vx;
        y = y + vy;
        x=(int)clamp(x,LEFT,RIGHT);
        y=(int)clamp(y,TOP,BOTTON);
    }


     public void shoot(){

           long start=System.currentTimeMillis();

         if(xPressed){
             if(start>time){
                 time=start+200;
                 PlayerSpell newSpell=new PlayerSpell();
                 newSpell.x=x;
                 newSpell.y=y;
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
}
