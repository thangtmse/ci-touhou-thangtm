package basic;

import java.util.Vector;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }


    public Vector2D clone() {

        return new Vector2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return "Vector2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void print(Vector2D vTest) {

        System.out.println(vTest.x + " " + vTest.y);

    }

    public void set(float a, float b) {
        this.x = a;
        this.y = b;
    }


    public void addUp(float a, float b) {
        this.x = this.x + a;
        this.y = this.y + b;

    }

    public void add(Vector2D other) {


        this.x += other.x;
        this.y += other.y;

    }

    public void subtractby(Vector2D v2) {
        this.x -= v2.x;
        this.y -= v2.y;
    }

    public Vector2D subtract(float a, float b) {

        Vector2D v1 = new Vector2D(this.x - a, this.y - b);
        return v1;
    }

    public Vector2D multiply(int a) {
        Vector2D v = new Vector2D();
        v.x = this.x * a;
        v.y = this.y * a;
        return v;
    }
    public void Vector2DBy(Vector2D v2){
        this.x*=v2.x;
        this.y*=v2.y;
    }
    public Vector2D normalize(){
        float length=length();
        return new Vector2D(this.x/length,this.y/length);
    }

    public float length() {
        double length = Math.sqrt(this.x * this.x + this.y * this.y);
        return (float)length;
    }

    public void set(Vector2D position) {
        set(position.x,position.y);
    }
}
