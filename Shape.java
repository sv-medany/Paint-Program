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
public abstract class Shape{
    private Color color;  //current color
    private Color prevColor; //keep track of previous color for the processes like undo , copy 
    private boolean drawn; // to make sure that shape points are finalized 
    private boolean filled; // to determine whether to draw a filled or non filled shape

    public Shape(Color color, Color prevColor, boolean drawn, boolean filled) {
        this.color = color;
        this.prevColor = prevColor;
        this.drawn = drawn;
        this.filled = filled;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    public Shape() {
    }
    
    public Color getPrevColor() {
        return prevColor;
    }

    public void setPrevColor(Color prevColor) {
        this.prevColor = prevColor;
    }
    public boolean isDrawn() {
        return drawn;
    }

    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }
    

    public Color getColor() {
        return color;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void draw(Graphics g); //each shape has its own way of being drawn
}
