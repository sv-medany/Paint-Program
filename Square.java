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
 * @author DR- Mohamed
 */
public class Square extends Shape implements Cloneable {

    int x1, x2, y1, y2; //keep track of the 2 points in addition to the points that are sent by the mouse listener

    public Square(int x1, int x2, int y1, int y2, Color color, Color prevColor, boolean drawn, boolean filled) {
        super(color, prevColor, drawn, filled);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public Square() { // to use the factory

    }

    @Override
    protected Object clone() throws CloneNotSupportedException { //used in making a copy of a square
        Square s = (Square) super.clone(); //create square with exactly the same dimensions as the chosen square to copy
        return s;
    }

    public boolean contains(int x, int y) { // to test whether the user is pressing on a square or not
        if (getX1() < getX2() && getY1() < getY2()) { // test for the square in the positive direction
            if (x <= x2 && x >= x1 && y <= y2 && y >= y1) { //check the bounds of the square
                return true;
            }
        } else if (getX1() > getX2() && getY1() > getY2()) { //check square in second direction
            if (x <= x1 && x >= x2 && y <= y1 && y >= y2) { //check bounds of the square
                return true;
            }
        } else if (getX1() > getX2() && getY1() < getY2()) { // check square in the 3rd quadrant
            if (x <= x1 && x >= x2 && y <= y2 && y >= y1) {
                return true;
            }
        } else {
            if (x <= x2 && x >= x1 && y <= y1 && y >= y2) { //check square in fourth quadrant
                return true;
            }
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
        if (this.isFilled()) { //check if the user wants to draw a filled square or not
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) { //check if in 4th quadrant
                g.fillRect(this.getX1(), this.getY1(), this.getX2() - this.getX1(), this.getX2() - this.getX1());
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) { //check if in 2nd quad
                g.fillRect(this.getX1() - Math.abs(this.getY2() - this.getY1()), this.getY1() - Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() > this.getX1() && this.getY2() < this.getY1()) { // check if in 1st quad
                g.fillRect(this.getX1(), this.getY2(), Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() < this.getX1() && this.getY1() < this.getY2()) { // check if in 3rd quad
                g.fillRect(this.getX2(), this.getY1(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getX2() - this.getX1()));
            }
        } 
        else{
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
                g.drawRect(this.getX1(), this.getY1(), this.getX2() - this.getX1(), this.getX2() - this.getX1());
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
                g.drawRect(this.getX1() - Math.abs(this.getY2() - this.getY1()), this.getY1() - Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() > this.getX1() && this.getY2() < this.getY1()) {
                g.drawRect(this.getX1(), this.getY2(), Math.abs(this.getY2() - this.getY1()), Math.abs(this.getY2() - this.getY1()));
            } else if (this.getX2() < this.getX1() && this.getY1() < this.getY2()) {
                g.drawRect(this.getX2(), this.getY1(), Math.abs(this.getX2() - this.getX1()), Math.abs(this.getX2() - this.getX1()));
            }
        }
    }

}
