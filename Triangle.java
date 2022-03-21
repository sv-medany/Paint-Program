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
public class Triangle extends Shape implements Cloneable {

    private int x1, x2, x3, y1, y2, y3;

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

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
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

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public Triangle(int x1, int x2, int x3, int y1, int y2, int y3, Color color, Color prevColor, boolean drawn, boolean filled) {
        super(color, prevColor, drawn, filled);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public Triangle() {

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Triangle t = (Triangle) super.clone();
        return t;
    }

    double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    boolean contains(int curx1, int cury1) { //check if we are in bounds of triangle
        double area0 = area(x1, y1, x2, y2, x3, y3); //calculate area of the triangle
        double area1 = area(curx1, cury1, x2, y2, x3, y3); 
        double area2 = area(x1, y1, curx1, cury1, x3, y3);
        double area3 = area(x1, y1, x2, y2, curx1, cury1);
        return area0 == area1 + area2 + area3; //compare area of sub triangles with area of the large triangle 
    }

    @Override
    public void draw(Graphics g) {
        if (this.isFilled()) {//check if filled 
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() > this.getY2()) { //check if trianlge is in 1st quad
                if (!this.isDrawn()) { // check if it is drawn or not
                    this.setX3(this.getX2()); 
                    this.setX2(this.getX1() + (this.getX2() - this.getX1()) / 2);
                    this.setY3(this.getY1());
                    //assigning the points of the polygon
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()}; //array contatining the 3 x-coordinates of the triangle
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};//array containing the 3 y-coordinates of the triangle
                g.fillPolygon(xcoord, ycoord, 3);
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) { // if triangle is in second quad
                if (!this.isDrawn()) {
                    this.setX3(this.getX2());
                    this.setX2(this.getX1() - (this.getX1() - this.getX2()) / 2);
                    this.setY3(this.getY1());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.fillPolygon(xcoord, ycoord, 3);

            } else if (this.getX1() > this.getX2() && this.getY1() < this.getY2()) { // if triangle is in third quad
                if (!this.isDrawn()) {
                    this.setX3(this.getX1());
                    this.setX1(this.getX1() - (this.getX1() - this.getX2()) / 2);
                    this.setY3(this.getY2());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.fillPolygon(xcoord, ycoord, 3);
            } else if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) { // if triangle is in 4th quad
                if (!this.isDrawn()) {
                    this.setX3(this.getX1());
                    this.setX1(this.getX1() + (this.getX2() - this.getX1()) / 2);
                    this.setY3(this.getY2());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.fillPolygon(xcoord, ycoord, 3);
            }
        } else { // to draw an unfilled polygon 
            g.setColor(this.getColor());
            if (this.getX1() < this.getX2() && this.getY1() > this.getY2()) {
                if (!this.isDrawn()) {
                    this.setX3(this.getX2());
                    this.setX2(this.getX1() + (this.getX2() - this.getX1()) / 2);
                    this.setY3(this.getY1());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.drawPolygon(xcoord, ycoord, 3);
            } else if (this.getX1() > this.getX2() && this.getY1() > this.getY2()) {
                if (!this.isDrawn()) {
                    this.setX3(this.getX2());
                    this.setX2(this.getX1() - (this.getX1() - this.getX2()) / 2);
                    this.setY3(this.getY1());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.drawPolygon(xcoord, ycoord, 3);
            } else if (this.getX1() > this.getX2() && this.getY1() < this.getY2()) {
                if (!this.isDrawn()) {
                    this.setX3(this.getX1());
                    this.setX1(this.getX1() - (this.getX1() - this.getX2()) / 2);
                    this.setY3(this.getY2());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.drawPolygon(xcoord, ycoord, 3);
            } else if (this.getX1() < this.getX2() && this.getY1() < this.getY2()) {
                if (!this.isDrawn()) {
                    this.setX3(this.getX1());
                    this.setX1(this.getX1() + (this.getX2() - this.getX1()) / 2);
                    this.setY3(this.getY2());
                }
                int[] xcoord = {this.getX1(), this.getX2(), this.getX3()};
                int[] ycoord = {this.getY1(), this.getY2(), this.getY3()};
                g.drawPolygon(xcoord, ycoord, 3);

            }
        }
    }
}
