import basic.GameObject;
import touhou.*;

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

    //ArrayList<Enemies> enemies = new ArrayList<>();
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
        GameObject.add(player);
        GameObject.add(enemie);
    }

    public void keyPressed(KeyEvent e) {
        player.keyPressed(e);

    }


    public void keyReleased(KeyEvent e) {
        player.keyReleased(e);

    }


    public void run() {

        GameObject.runAll();

        y--;
    }
    public  int getWidths(){
        return background.getWidth();
    }
    public int getHeights(){
        return background.getHeight();
    }
    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(background, 0,y, null);
        GameObject.renderAll(g);


    }


}
