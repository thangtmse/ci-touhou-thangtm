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

    BufferedImage enemies;
   Player player=new Player();
    ArrayList<PlayerSpell> spells=new ArrayList<>();


    public GameCanvas() {
        //1.load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));

            enemies = ImageIO.read(new File("assets/images/enemies/explosion-big/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void keyPressed(KeyEvent e){
        player.keyPressed(e);

    }


    public void keyReleased(KeyEvent e){
        player.keyReleased(e);

    }

    public void run(){
        player.run();
       player.shoot(spells);


    }
    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(background, 0, 0, null);
           player.render(g);
              for(PlayerSpell spell: spells){
                  spell.render(g);
              }



        g.drawImage(enemies, 0, 0, null);
    }



}
