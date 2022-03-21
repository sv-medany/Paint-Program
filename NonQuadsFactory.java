/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming.pkgfinal.paint;

/**
 *
 * @author DR- Mohamed
 */
public class NonQuadsFactory extends AbstractFactory { // creates any non quad shape

    @Override
    public Shape CreateShape(String name) { // instance is created according to the name sent
        Shape s = null;
        if (name.equals("Line")) {
            s = new Line();
        } else if (name.equals("Circle")) {
            s = new Circle();
        } else if (name.equals("Triangle")) {
            s = new Triangle();
        }
        return s;
    }

}
