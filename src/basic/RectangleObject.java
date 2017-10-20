package basic;

import java.awt.*;

public class RectangleObject {
   public int x;
   public int y;
   public int width;
   public int height;

    public RectangleObject() {
    }

    public RectangleObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public Rectangle getBound(){
        return new Rectangle(x,y,width,height);
    }
}
