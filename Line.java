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
public class Line extends Shape implements Cloneable {

    private int x1, x2, y1, y2;

    public Line(int x1, int x2, int y1, int y2, Color color, Color prevColor, boolean drawn, boolean filled) {
        super(color, prevColor, drawn, filled);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Line() { // to use by factory
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { //to make a copy of the line
        Line l = (Line) super.clone();
        return l;
    }

    public boolean contains(int x, int y) { // check if we are in bounds of line
        int length1 = (int) Math.sqrt(Math.pow(x1 - x, 2) + Math.pow(y1 - y, 2)); //distance of line1
        int length2 = (int) Math.sqrt(Math.pow(x - x2, 2) + Math.pow(y - y2, 2));  // distance of line 2
        int totalLength = (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // distance of primary line
        System.out.println("length 1: " + length1 + " length 2: " + length2 + " total: " + totalLength + " total12: " + (length1 + length2));
        if (totalLength == length1 + length2) {
            return true;
        } else if (totalLength == length1 + length2 + 1) {
            return true;
        }
        return false;
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        g.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
    }
}
