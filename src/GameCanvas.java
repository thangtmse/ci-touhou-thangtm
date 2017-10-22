import basic.GameObject;
import touhou.*;
import touhou.enemies.Enemy;
import touhou.enemies.EnemySpawner;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {

    //Enemies enemie = new Enemies();

    //ArrayList<Enemies> enemies = new ArrayList<>();
    Player player = new Player();
    BackGround backGround=new BackGround();
    ArrayList<PlayerSpell> spells = new ArrayList<>();
    private int y;
    //ArrayList<Enemies> enemies=new ArrayList<>();

    public GameCanvas() {
        //1.load background
        GameObject.add(backGround);
        GameObject.add(player);
        //GameObject.add(enemie);
        GameObject.add(new EnemySpawner());
        GameObject.add(new Enemy());
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }


    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }


    public void run() {

        GameObject.runAll();


    }

    @Override
    protected void paintComponent(Graphics g) {


        GameObject.renderAll(g);


    }


}
