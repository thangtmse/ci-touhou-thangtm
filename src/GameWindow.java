import touhou.input.InputManager;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow() {
        this.setSize(800, 600);
        this.canvas = new GameCanvas();
        this.setContentPane(this.canvas);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setResizable(false);
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
             //canvas.keyPressed(e);
                InputManager.instance.keyPressed( e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //canvas.keyReleased(e);
                InputManager.instance.keyReleased( e);
            }
        });
        this.canvas.setVisible(true);
        this.setVisible(true);


    }

public void gameloop(){
        while(true){
            try {
                Thread.sleep(17);
                canvas.run();
                canvas.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
}
