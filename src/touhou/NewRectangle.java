package touhou;

import basic.RectangleObject;

import java.awt.*;

public class NewRectangle extends RectangleObject {

    public NewRectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    public static void check(NewRectangle r1,NewRectangle r2){
        Rectangle test1=r1.getBound();
        Rectangle test2=r2.getBound();
        if(test1.intersects(test2)){
            System.out.println("overlap");
        }else{
            System.out.println("not overlap");
        }
    }


}
