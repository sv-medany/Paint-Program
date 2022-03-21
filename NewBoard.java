/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.pkgfinal.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class NewBoard extends JPanel implements MouseListener, MouseMotionListener {

    public static enum shape { //determine the shape we are drawing
        line, rectangle, circle, square, triangle, fady;
    }

    public static enum modes { //determine which mode we are in
        draw, select, resize, copy, delete, move
    }
    NonQuadsFactory masna3 = new NonQuadsFactory(); //to create non quads
    QuadsFactory masna3Quads = new QuadsFactory(); // to create quads
    public modes mode;
    public shape myshapes;
    Color currentColor = Color.BLACK; //default color 
    Color preColor = Color.WHITE; //flag for change of colors 
    int x1, y1; // first x and y determined by the mouse listener
    int x2, y2; // second x and y determined by the mouse listener
    int indextoop = -1; // to insert the indexes we want to operate on in 
    Boolean setFill = false; //to check the user input for filling the shape
    ArrayList<Shape> shapeTopres = new ArrayList<>(); // store shapes that we will delete
    int presindextoop = -1; // store index of shape we want to delete
    int noOfUndo = 0; //undo counter
    int noOfRedo = 0; // redo counter 
    boolean canUndo = true; //check the ability to undo something
    boolean canRedo = false; //check the ability to redo something
    ArrayList<Shape> copyRedoList = new ArrayList<>(); //to add to redo list 
    ArrayList<Integer> Selected = new ArrayList<>(); // add indexes of selected shapes
    ArrayList<Shape> recentlyDeleted = new ArrayList<>(); //add shapes that have been recently deleted
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
     */
    ArrayList<Shape> x = new ArrayList<Shape>(); //array list that contains all shapes currently displayed on the board
//    Iterator <Shape>xIT=x.iterator();
    ArrayList<Shape> redolist = new ArrayList<Shape>(); // to store the shapes that we can redo again

    public NewBoard() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void undo() {

        if (mode == modes.delete) { //if the mode is delete
            if (recentlyDeleted.size() > 0) {
                x.add(recentlyDeleted.get(recentlyDeleted.size() - 1)); //to insert back the recently deleted shape to the main array list
                recentlyDeleted.remove(recentlyDeleted.size() - 1); // remove the shape we just returned to the main array list
                noOfUndo++;
            }
            repaint(); // to show the modification on board
        } else if (mode == modes.move || mode == modes.resize) { //if mode is resize or move
            if (canUndo && shapeTopres != null) { //if we can undo , and the shape to preserve has a shape in it 
                Shape temp = x.get(presindextoop); //store the modified shape
                x.remove(presindextoop); // remove the shape with the modified coordinates from the main array list
                x.add(presindextoop, shapeTopres.get(0)); //add the  original shape back to the main array list
                shapeTopres.set(0, temp); // add the modified shape
                canUndo = false;
                canRedo = true;
            }
            repaint();
        } else if (mode == modes.draw) {//if the mode is draw
            if (x.size() > 0) {
                redolist.add(x.get(x.size() - 1)); // add the latest drawn shape to the list
                x.remove(x.size() - 1); //remove the latest drawn shape
                repaint();
            }
        } else if (mode == modes.copy) { // if mode is copy
            if (canUndo) {

                copyRedoList.add(x.get(presindextoop));//add shape with modified dimensions 
                x.remove(presindextoop); //remove shape with modified dimensions from main array
                canUndo = false;
                canRedo = true;
            }
            repaint();
        }
    }
    public void returnColor() { //to return each shape to its original color after being selected and changing the mode back
        for (int i = 0; i < x.size(); i++) {
            if (x.get(i).getPrevColor() != Color.WHITE) {
                x.get(i).setColor(x.get(i).getPrevColor());
                x.get(i).setPrevColor(Color.WHITE);
            }
        }
        repaint();
    }

    public void clearRecentlyDeleted() { //empty the array list of recently deleted after changing the mode from deleted to something else
        while (recentlyDeleted.size() > 0) {
            recentlyDeleted.remove(recentlyDeleted.size() - 1);
        }
    }

    public void clearSelected() { //empty the array list of recently selected after changing the mode from deleted to something else
        while (Selected.size() > 0) {
            Selected.remove(Selected.size() - 1);
        }
    }

    public void clearshapepres() { //clear array list that contains modified shapes 
        while (shapeTopres.size() > 0) {
            shapeTopres.remove(shapeTopres.size() - 1);
        }
    }

    public void clearCopyRedoList() { //clear array list that contains items we can redo
        while (copyRedoList.size() > 0) {
            copyRedoList.remove(copyRedoList.size() - 1);
        }
    }

    public void finalize() { // to make sure that all shapes are drawn correctly with all their coordinates present
        for (int i = 0; i < x.size(); i++) {
            x.get(i).setDrawn(true);
        }
    }

    public void redo() {
        if (mode == modes.delete) {
            if (noOfUndo > 0 && x.size() > 0) {//check undo counter as you can't redo something you did not undo
                recentlyDeleted.add(x.get(x.size() - 1)); //store the recently undeleted shape
                x.remove(x.size() - 1); //remove this shape again from the array list
                noOfUndo--; //decrease number of undo that you can do
                noOfRedo++;
                repaint();
            }
        } else if (mode == modes.move || mode == modes.resize) {
            if (canRedo) {
                Shape temp = x.get(presindextoop); // store original shape
                x.remove(presindextoop);//remove the original shape from original array list
                x.add(presindextoop, shapeTopres.get(0)); // add the modified shape back in
                shapeTopres.set(0, temp); //store the original shape at index 0 to be able to undo
                canUndo = true;
                canRedo = false;
            }
            repaint();
        } else if (mode == modes.draw) {
            if (redolist.size() > 0) {
                x.add(redolist.get(redolist.size() - 1)); //add the last shape added in the redo list back to the board
                redolist.remove(redolist.size() - 1); //remove the shape we just redoed 
                repaint();
            }
        } else if (mode == modes.copy) {
            if (canRedo && copyRedoList.size() > 0) {
                x.add(copyRedoList.get(copyRedoList.size() - 1));//add the last object we made a copy of and undoed
                copyRedoList.remove(copyRedoList.size() - 1); // remove from the array list that contains the undoed copies
                repaint();
                canUndo = true;
                canRedo = false;
            }
        }
    }

    public void delete() {
        boolean found = false;//test for shape i want to delete
        Collections.sort(Selected); //sort indexes in selected
        if (Selected.size() > 0) {
            for (int i = 0; i < Selected.size(); i++) {
                for (int j = 0; j < x.size(); j++) {
                    System.out.println("yarab");
                    if (Selected.get(i) == j) { //found the index of the shape i want to delete
                        Shape clone = x.get(j); //make a clone to add in recently deleted list
                        x.remove(j); //remove shape from main array list
                        Selected.remove(i); //remove shape from array list of selected array lists
                        found = true;
                        recentlyDeleted.add(clone);
                        break;
                    }
                }
                if (found) { //if index is found 
                    for (int z = 0; z < Selected.size(); z++) {
                        Selected.set(z, Selected.get(z) - 1);
                    }
                    i--;
                    found = false;
                }
            }
            repaint();
        }
    }

    public void flush() { //clear redo list 
        while (redolist.size() > 0) {
            redolist.remove(redolist.size() - 1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Iterator<Shape> xIT = x.iterator(); //loop on main array list
        while (xIT.hasNext()) {
            Shape s = xIT.next(); //check type of shape to draw
            if (s instanceof Line) {
                Line l = (Line) s;
                l.draw(g);
            } else if (s instanceof Rectangle) {
                Rectangle l = (Rectangle) s;
                l.draw(g);
            } else if (s instanceof Circle) {
                Circle c = (Circle) s;
                c.draw(g);
            } else if (s instanceof Square) {
                Square sqr = (Square) s;
                sqr.draw(g);
            } else if (s instanceof Triangle) {
                Triangle t1 = (Triangle) s;
                t1.draw(g);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        int j;
        boolean found = false;//check if instance is found
        if (mode == modes.select) {
            for (int i = x.size() - 1; i >= 0; i--) { // loop on shapes in main array list
                found = false;
                if (x.get(i) instanceof Circle) {
                    Circle c = (Circle) x.get(i); //operate on circle
                    if (c.contains(me.getX(), me.getY())) {//check if within bounds
                        if (c.getPrevColor() == Color.WHITE) { //check if it is not selected
                            c.setPrevColor(c.getColor());
                            c.setColor(Color.GREEN);//if not selected make its color green
                            Selected.add(i);
                            break;
                        } else {
                            for (j = 0; j < Selected.size(); j++) {
                                if (Selected.get(j) == i) {//if already selected 
                                    found = true;
                                    break;
                                }
                            }
                            if (found) { //if found in selected array list
                                Selected.remove(j); //remove selection 
                                c.setColor(c.getPrevColor());//return to original color
                                c.setPrevColor(Color.WHITE); // set previous as a flag that is not selected any more
                            }
                            break;
                        }
                    }
                } else if (x.get(i) instanceof Triangle) {//check if instance is found
                    Triangle tri = (Triangle) x.get(i);
                    if (tri.contains(me.getX(), me.getY())) { //check if within bounds
                        if (tri.getPrevColor() == Color.WHITE) {//check if it is not selected
                            tri.setPrevColor(tri.getColor());
                            tri.setColor(Color.GREEN);//if not selected make its color green
                            Selected.add(i);
                            break;
                        } else {
                            for (j = 0; j < Selected.size(); j++) {//loop on selected array list
                                if (Selected.get(j) == i) {//if already selected
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {//if found in selected array list
                                Selected.remove(j);//remove selection 
                                tri.setColor(tri.getPrevColor());//return to original color
                                tri.setPrevColor(Color.WHITE);// set previous as a flag that is not selected any more
                            }
                            break;
                        }
                    }
                } else if (x.get(i) instanceof Rectangle) {//check if instance is found
                    Rectangle rec = (Rectangle) x.get(i);
                    if (rec.contains(me.getX(), me.getY())) {//check if within bounds
                        if (rec.getPrevColor() == Color.WHITE) {
                            rec.setPrevColor(rec.getColor());
                            rec.setColor(Color.GREEN);//if not selected make its color green
                            Selected.add(i);
                            break;
                        } else {
                            for (j = 0; j < Selected.size(); j++) { //loops on selectd shapes 
                                if (Selected.get(j) == i) { // if index is found
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {//if found in selected array list
                                Selected.remove(j);//remove selection 
                                rec.setColor(rec.getPrevColor());//return to original color
                                rec.setPrevColor(Color.WHITE);
// set previous as a flag that is not selected any more
                            }
                            break;
                        }
                    }
                } else if (x.get(i) instanceof Square) {//check if instance is found
                    Square sq = (Square) x.get(i);
                    if (sq.contains(me.getX(), me.getY())) {//check if within bounds
                        if (sq.getPrevColor() == Color.WHITE) {//check if it is not selected
                            sq.setPrevColor(sq.getColor());
//if not selected make its color green
                            sq.setColor(Color.GREEN);
                            Selected.add(i);
                            break;
                        } else {
                            for (j = 0; j < Selected.size(); j++) {
                                if (Selected.get(j) == i) {//if already selected
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {//if found in selected array list
                                Selected.remove(j);//remove selection 
                                sq.setColor(sq.getPrevColor());//return to original color
                                sq.setPrevColor(Color.WHITE);
// set previous as a flag that is not selected any more
                            }
                            break;
                        }
                    }
                } else if (x.get(i) instanceof Line) {//check if instance is found
                    Line li = (Line) x.get(i);
                    if (li.contains(me.getX(), me.getY())) {//check if within bounds
                        if (li.getPrevColor() == Color.WHITE) {//check if it is not selected
                            li.setPrevColor(li.getColor());
                            li.setColor(Color.GREEN);//if not selected make its color green
                            Selected.add(i);
                            break;
                        } else {
                            for (j = 0; j < Selected.size(); j++) {
                                if (Selected.get(j) == i) {//if already selected 
                                    found = true;
                                    break;
                                }
                            }
                            if (found) {//if found in selected array list
                                Selected.remove(j);//remove selection 
                                li.setColor(li.getPrevColor());//return to original color
                                li.setPrevColor(Color.WHITE);// set previous as a flag that is not selected any more
                            }
                            break;
                        }
                    }
                }
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (mode == modes.draw) { //draw mode
            x1 = me.getX(); //get xcoordinate of mouse listener
            y1 = me.getY();//get y coordinate of mouse listener
            if (myshapes == shape.line) { // if the drawn shape is line
                Line l = (Line) masna3.CreateShape("Line"); //use of factory
                l.setX1(x1);
                l.setX2(x1);
                l.setY1(y1);
                l.setY2(y1);
                //draw a dot 
                l.setColor(currentColor);
                l.setPrevColor(preColor);
                l.setDrawn(false);
                l.setFilled(false);
                x.add(l);//add line to main array list
                repaint();
            } else if (myshapes == shape.rectangle) {
                Rectangle r = (Rectangle) masna3Quads.CreateShape("Rectangle");//use of factory
                r.setX1(x1);
                r.setX2(x1);
                r.setY1(y1);
                r.setY2(y1);
                r.setColor(currentColor);
                r.setPrevColor(preColor);
                r.setDrawn(false);
                r.setFilled(setFill);
                x.add(r);
                repaint();
            } else if (myshapes == shape.circle) {
                Circle c = (Circle) masna3.CreateShape("Circle");
                c.setRadius(0);
                c.setX1(x1);
                c.setY1(y1);
                c.setColor(currentColor);
                c.setPrevColor(preColor);
                c.setDrawn(false);
                c.setFilled(setFill);
                x.add(c);
                repaint();
            } else if (myshapes == shape.square) {
                Square sq = (Square) masna3Quads.CreateShape("Square");
                sq.setX1(x1);
                sq.setX2(x1);
                sq.setY1(y1);
                sq.setY2(y1);
                sq.setColor(currentColor);
                sq.setPrevColor(preColor);
                sq.setDrawn(false);
                sq.setFilled(setFill);
                x.add(sq);
                repaint();
            } else if (myshapes == shape.triangle) {
                Triangle tri = (Triangle) masna3.CreateShape("Triangle");
                tri.setX1(x1);
                tri.setX2(x1);
                tri.setX3(x1);
                tri.setY1(y1);
                tri.setY2(y1);
                tri.setY3(y1);
                tri.setColor(currentColor);
                tri.setPrevColor(preColor);
                tri.setDrawn(false);
                tri.setFilled(setFill);
                x.add(tri);
                repaint();
            }
        } else if (mode == modes.resize) {
            for (int i = x.size() - 1; i >= 0; i--) {//loop on main array
                if (x.get(i) instanceof Circle) {
                    Circle c = (Circle) x.get(i);
                    if (c.contains(me.getX(), me.getY())) {//check if circle in bounds
                        indextoop = i;
                        presindextoop = i;
                        //store index to preserve with original shape
                        Circle c1 = (Circle) masna3.CreateShape("Circle");
                        try {
                            c1 = (Circle) (c.clone());
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a circle with the original shape attributes
                        shapeTopres.add(c1);
                        myshapes = shape.circle;
                        break;
                    }
                } else if (x.get(i) instanceof Triangle) {//check if instance of traingle
                    Triangle tri = (Triangle) x.get(i);
                    if (tri.contains(me.getX(), me.getY())) {//check if in bounds of a triangle
                        indextoop = i;
                        //store index to preserve with original shape
                        Triangle tri1 = (Triangle) masna3.CreateShape("Triangle");
                        try {
                            tri1 = (Triangle) tri.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a triangle with the original shape attributes
                        shapeTopres.add(tri1);
                        presindextoop = i;
                        myshapes = shape.triangle;
                        tri.setDrawn(false);
                        x1 = tri.getX1();
                        y1 = tri.getY1();

                        break;
                    }
                } else if (x.get(i) instanceof Rectangle) {
                    Rectangle rec = (Rectangle) x.get(i);
                    if (rec.contains(me.getX(), me.getY())) {
                        indextoop = i;
                        Rectangle rec1 = (Rectangle) masna3Quads.CreateShape("Rectangle");
                        try {
                            rec1 = (Rectangle) rec.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a rectangle with the original shape attributes
                        shapeTopres.add(rec1);
                        presindextoop = i;
                        myshapes = shape.rectangle;
                        rec.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Square) {
                    Square sq = (Square) x.get(i);
                    if (sq.contains(me.getX(), me.getY())) {
                        indextoop = i;
                        Square sq1 = (Square) masna3Quads.CreateShape("Square");
                        try {
                            sq1 = (Square) sq.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a square with the original shape attributes
                        shapeTopres.add(sq1);
                        presindextoop = i;
                        myshapes = shape.square;
                        x1 = sq.getX1();
                        y1 = sq.getY1();
                        sq.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Line) {
                    Line li = (Line) x.get(i);
                    if (li.contains(me.getX(), me.getY())) {
                        System.out.println("shaker");
                        indextoop = i;
                        Line li1 = (Line) masna3.CreateShape("Line");
                        try {
                            li1 = (Line) li.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a line with the original shape attributes
                        shapeTopres.add(li1);
                        presindextoop = i;
                        myshapes = shape.line;
                        x1 = li.getX1();
                        y1 = li.getY1();
                        li.setDrawn(false);
                        break;
                    }
                }
            }
        } else if (mode == modes.move) { //if mode is move
            for (int i = x.size() - 1; i >= 0; i--) {//loop on original array 
                if (x.get(i) instanceof Circle) { //if instance of circle
                    Circle c = (Circle) x.get(i);
                    if (c.contains(me.getX(), me.getY())) {//if in bounds of circle 
                        indextoop = i;
                        presindextoop = i;
                        Circle c1 = (Circle) masna3.CreateShape("Circle");
                        try {
                            c1 = (Circle) c.clone(); //make a clone with original dimensions
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a circle with the original shape attributes
                        shapeTopres.add(c1);
                        myshapes = shape.circle;
                        break;
                    }
                } else if (x.get(i) instanceof Triangle) {
                    Triangle tri = (Triangle) x.get(i);
                    if (tri.contains(me.getX(), me.getY())) {
                        indextoop = i;
                        myshapes = shape.triangle;
                        Triangle tri1 = (Triangle) masna3.CreateShape("Triangle");
                        try {
                            tri1 = (Triangle) tri.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a triangle with the original shape attributes
                        shapeTopres.add(tri1);
                        presindextoop = i;
                        tri.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Rectangle) {
                    Rectangle rec = (Rectangle) x.get(i);
                    if (rec.contains(me.getX(), me.getY())) {//instance of rectangle
                        indextoop = i;
                        Rectangle rec1 = (Rectangle) masna3Quads.CreateShape("Rectangle");
                        try {
                            rec1 = (Rectangle) rec.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a rectangle with the original shape attributes
                        shapeTopres.add(rec1);
                        presindextoop = i;
                        myshapes = shape.rectangle;
                        rec.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Square) { //make instance of square
                    Square sq = (Square) x.get(i);
                    if (sq.contains(me.getX(), me.getY())) {
                        indextoop = i;
                        Square sq1 = (Square) masna3Quads.CreateShape("Square");
                        try {
                            sq1 = (Square) sq.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a square with the original shape attributes
                        shapeTopres.add(sq1);
                        presindextoop = i;
                        myshapes = shape.square;
                        x1 = sq.getX1();
                        y1 = sq.getY1();
                        sq.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Line) {//if instance of line
                    Line li = (Line) x.get(i);
                    if (li.contains(me.getX(), me.getY())) {
                        System.out.println("shaker");
                        indextoop = i;
                        Line li1 = (Line) masna3.CreateShape("Line");
                        try {
                            li1 = (Line) li.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //make a line with the original shape attributes
                        shapeTopres.add(li1);
                        presindextoop = i;
                        myshapes = shape.line;
                        li.setDrawn(false);
                        break;
                    }
                }
            }
        } else if (mode == modes.copy) {//if mode is copy
            for (int i = x.size() - 1; i >= 0; i--) {
                if (x.get(i) instanceof Circle) {
                    Circle c = (Circle) x.get(i);
                    if (c.contains(me.getX(), me.getY())) {

                        Circle c1 = (Circle) masna3.CreateShape("Circle");
                        try {
                            c1 = (Circle) c.clone(); //make a clone with original dimensions
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x.add(c1);
                        indextoop = x.size() - 1;
                        presindextoop = x.size() - 1;
                        myshapes = shape.circle;
                        break;
                    }
                } else if (x.get(i) instanceof Triangle) {
                    Triangle tri = (Triangle) x.get(i);
                    if (tri.contains(me.getX(), me.getY())) {

                        myshapes = shape.triangle;
                        Triangle tri1 = (Triangle) masna3.CreateShape("Triangle");
                        try {
                            tri1 = (Triangle) tri.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x.add(tri1);
                        indextoop = x.size() - 1;
                        presindextoop = x.size() - 1;
                        tri1.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Rectangle) {
                    Rectangle rec = (Rectangle) x.get(i);
                    if (rec.contains(me.getX(), me.getY())) {
                        System.out.println("shaker");

                        Rectangle rec1 = (Rectangle) masna3Quads.CreateShape("Rectangle");
                        try {
                            rec1 = (Rectangle) rec.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x.add(rec1);
                        indextoop = x.size() - 1;
                        presindextoop = x.size() - 1;
                        myshapes = shape.rectangle;
                        rec1.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Square) {
                    Square sq = (Square) x.get(i);
                    if (sq.contains(me.getX(), me.getY())) {
                        System.out.println("shaker");
                        Square sq1 = (Square) masna3Quads.CreateShape("Square");
                        try {
                            sq1 = (Square) sq.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x.add(sq1);
                        indextoop = x.size() - 1;
                        presindextoop = x.size() - 1;
                        myshapes = shape.square;
                        x1 = sq.getX1();
                        y1 = sq.getY1();
                        sq1.setDrawn(false);
                        break;
                    }
                } else if (x.get(i) instanceof Line) {
                    Line li = (Line) x.get(i);
                    if (li.contains(me.getX(), me.getY())) {
                        System.out.println("shaker");
                        Line li1 = (Line) masna3.CreateShape("Line");
                        try {
                            li1 = (Line) li.clone();
                        } catch (CloneNotSupportedException ex) {
                            Logger.getLogger(NewBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        x.add(li1);
                        indextoop = x.size() - 1;
                        presindextoop = x.size() - 1;
                        myshapes = shape.line;
                        li1.setDrawn(false);
                        break;
                    }
                }
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent me) {
        finalize();
        indextoop = -1;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        Shape s = null;
        if (myshapes == shape.line) {//if instance of line
            x2 = me.getX();
            y2 = me.getY();
            if (mode == modes.draw) {
                s = x.get(x.size() - 1);
            } else if ((mode == modes.resize || mode == modes.move || mode == modes.copy) && (indextoop != -1)) {
                s = x.get(indextoop); //store clone
            }
            if (s instanceof Line) {
                Line l = (Line) s;
                if (mode == modes.draw || mode == modes.resize) {
                    l.setX1(x1);
                    l.setY1(y1);
                    l.setX2(x2);
                    l.setY2(y2);
                    //store new coordinates
                } else if (mode == modes.move || mode == modes.copy) {
                    l.setX2(x2 + l.getX2() - l.getX1());
                    l.setY2(y2 + l.getY2() - l.getY1());
                    l.setX1(x2);
                    l.setY1(y2);
                    //move shape to new place
                }
            }
            repaint();
        } else if (myshapes == shape.rectangle) {
            x2 = me.getX();
            y2 = me.getY();
            if (mode == modes.draw) {
                s = x.get(x.size() - 1);
            } else if ((mode == modes.resize || mode == modes.move || mode == modes.copy) && (indextoop != -1)) {
                s = x.get(indextoop);
            }
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                if (mode == modes.draw || mode == modes.resize) {
                    r.setX2(x2);
                    r.setY2(y2);
                    //store new coordinates
                } else if (mode == modes.move || mode == modes.copy) {
                    r.setX2(x2 + r.getX2() - r.getX1());
                    r.setY2(y2 + r.getY2() - r.getY1());
                    r.setX1(x2);
                    r.setY1(y2);
                    //move shape to new place
                }

            }
            repaint();
        } else if (myshapes == shape.circle) {
            x2 = me.getX();
            y2 = me.getY();
            if (mode == modes.draw) {
                s = x.get(x.size() - 1);
            } else if ((mode == modes.resize || mode == modes.move || mode == modes.copy) && (indextoop != -1)) {
                s = x.get(indextoop);
            }
            if (s instanceof Circle) {
                Circle c = (Circle) s;
                if (mode == modes.draw || mode == modes.resize) {
                    c.setRadius(y2, x2);
                } else if (mode == modes.move || mode == modes.copy) {
                    c.setRadius(c.getRadius());
                    c.setX1(x2);
                    c.setY1(y2);
                    //move shape to new place
                }
            }
            repaint();
        } else if (myshapes == shape.square) {
            x2 = me.getX();
            y2 = me.getY();
            if (mode == modes.draw) {
                s = x.get(x.size() - 1);
            } else if ((mode == modes.resize || mode == modes.move || mode == modes.copy) && (indextoop != -1)) {
                s = x.get(indextoop);
            }
            if (s instanceof Square) {
                Square sq = (Square) s;
                if (mode == modes.draw || mode == modes.resize) {
                    sq.setX1(x1);
                    sq.setY1(y1);
                    sq.setX2(x2);
                    sq.setY2(y2);
                    //set new coordinates
                } else if (mode == modes.move || mode == modes.copy) {
                    sq.setX2(x2 + sq.getX2() - sq.getX1());
                    sq.setY2(y2 + sq.getY2() - sq.getY1());
                    sq.setX1(x2);
                    sq.setY1(y2);
                    //move shape to new place
                }

            }
            repaint();
        } else if (myshapes == shape.triangle) {
            x2 = me.getX();
            y2 = me.getY();
            if (mode == modes.draw) {
                s = x.get(x.size() - 1);
            } else if ((mode == modes.resize || mode == modes.move || mode == modes.copy) && (indextoop != -1)) {
                s = x.get(indextoop);
            }
            if (s instanceof Triangle) {
                Triangle tr = (Triangle) s;
                if (mode == modes.draw || mode == modes.resize) {
                    tr.setX1(x1);
                    tr.setY1(y1);
                    tr.setX2(x2);
                    tr.setY2(y2);
                    //set new coordinates
                } else if (mode == modes.move || mode == modes.copy) {
                    tr.setX2(x2 + tr.getX2() - tr.getX1());
                    tr.setY2(y2 + tr.getY2() - tr.getY1());
                    tr.setY3(y2 - tr.getY1() + tr.getY3());
                    tr.setX3(x2 - tr.getX1() + tr.getX3());
                    tr.setX1(x2);
                    tr.setY1(y2);
                    tr.setDrawn(true);
                    //move shape to new place
                }
            }
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

}
