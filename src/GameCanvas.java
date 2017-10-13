import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    BufferedImage background;
    BufferedImage player;
    public GameCanvas(){
        //1.load background
        try {
            background = ImageIO.read(new File("assets/images/background/0.png"));
            player =ImageIO.read(new File("assets/images/players/straight/0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {

       g.drawImage(background,0,0,null);
       g.drawImage(player,150,300,null);
    }
}
