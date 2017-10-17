import touhou.Enemies;
import touhou.EnemyBullets;
import touhou.PlayerSpell;
import touhou.Player;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
   BufferedImage background;
    Enemies enemie = new Enemies();
    ArrayList<EnemyBullets> bullets = new ArrayList<>();
    ArrayList<Enemies> enemies = new ArrayList<>();
    Player player = new Player();
    ArrayList<PlayerSpell> spells = new ArrayList<>();
    private int y;
    //ArrayList<Enemies> enemies=new ArrayList<>();

    public GameCanvas() {
        //1.load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }


    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }


    public void run() {
        player.run();
        player.shoot(spells);

        enemie.run(getWidth());
        enemie.shoot(bullets);
        for (EnemyBullets bullet : bullets) {
            bullet.run();
        }
        y--;
    }
    public int getWidth(){
        return background.getWidth();
    }
    public int getHeight(){
        return background.getHeight();
    }
    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(background, 0,y, null);
        player.render(g);
        for (PlayerSpell spell : spells) {
            spell.render(g);
        }


        enemie.render(g);
        for (EnemyBullets bullet : bullets) {
            bullet.render(g);
        }


    }


}
