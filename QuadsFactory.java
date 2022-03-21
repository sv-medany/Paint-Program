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
public class QuadsFactory extends AbstractFactory{ //creates only shapes with 4 sides 

    @Override
    public Shape CreateShape(String name) { //according to the name of the shape sent , the instance is returned
         Shape s = null;
        if (name.equals("Square")) {
            s = new Square();
        } else if (name.equals("Rectangle")) {
            s = new Rectangle();
        }
        return s;
    }
    
}
