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
public class Rectangle extends Shape implements Cloneable {

    private int x1, x2, y1, y2;

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

    public Rectangle(int x1, int x2, int y1, int y2, Color color, Color prevColor, boolean drawn, boolean filled) {
        super(color, prevColor, drawn, filled);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Rectangle() {
    }

    @Override
    protected Object clone() throws CloneNotSupportedException { //make a copy of rectangle with exact same dimensions
        Rectangle r = (Rectangle) super.clone();
        return r;
    }

    public boolean contains(int x, int y) { //check if we are in the bounds of a drawn rectangle
        if (getX1() < getX2() && getY1() < getY2()) { // check if we are in 4th quad
            if (x <= x2 && x >= x1 && y <= y2 && y >= y1) {
                return true;
            }
        } else if (getX1() > getX2() && getY1() > getY2()) { //check if in 2nd quad
            if (x <= x1 && x >= x2 && y <= y1 && y >= y2) {
                return true;
            }
        } else if (getX1() > getX2() && getY1() < getY2()) { //check if in 3rd quad
            if (x <= x1 && x >= x2 && y <= y2 && y >= y1) {
                return true;
            }
        } else {
            if (x <= x2 && x >= x1 && y <= y1 && y >= y2) {//check if in 1st quad
                return true;
            }
        }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        if (this.isFilled()) {
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
                g.fillRect(this.getX1(), this.getY1(), this.getX2() - this.getX1(), this.getY2() - this.getY1());
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
                g.fillRect(this.getX2(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() > this.getX1() && this.getY2() < this.getY1()) {
                g.fillRect(this.getX1(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() < this.getX1() && this.getY1() < this.getY2()) {
                g.fillRect(this.getX2(), this.getY1(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            }
        }
        else{
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
                g.drawRect(this.getX1(), this.getY1(), this.getX2() - this.getX1(), this.getY2() - this.getY1());
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
                g.drawRect(this.getX2(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() > this.getX1() && this.getY2() < this.getY1()) {
                g.drawRect(this.getX1(), this.getY2(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() < this.getX1() && this.getY1() < this.getY2()) {
                g.drawRect(this.getX2(), this.getY1(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getY2() - this.getY1()));
            }
        }
    }

}
