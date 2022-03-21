/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.pkgfinal.paint;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Galaxy
 */
public class Circle extends Shape implements Cloneable {

    private int radius; 
    private int x1, y1;

    public Circle(int radius, int x1, int y1, Color color, Color prevColor, boolean drawn, boolean filled) {
        super(color, prevColor, drawn, filled);
        this.radius = radius;
        this.x1 = x1;
        this.y1 = y1;
    }

    public Circle() { // to use by factory

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int y2, int x2) { //use equation of circle
        this.radius = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public boolean contains(double x, double y) { //check if we are in the bounds of a circle
        if (Math.pow(this.x1 - x, 2) + Math.pow(this.y1 - y, 2) < Math.pow(radius, 2)) { //check if we are inside the area of the circle
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { // create a copy of the clicked circle with same radius
        Circle s = (Circle) super.clone();
        return s;
    }

    @Override
    public void draw(Graphics g) {
        if (this.isFilled()) { // check if user wants the circle to be filled
            g.setColor(this.getColor());
            g.fillOval(Math.abs(this.getX1() - this.getRadius()), Math.abs(this.getY1() - this.getRadius()), 2 * this.getRadius(), 2 * this.getRadius());
        }
        else{
            g.setColor(this.getColor());
            g.drawOval(Math.abs(this.getX1() - this.getRadius()), Math.abs(this.getY1() - this.getRadius()), 2 * this.getRadius(), 2 * this.getRadius());
        }
    }

}
