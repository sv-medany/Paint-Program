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
public abstract class AbstractFactory { //factory used to create different types of shapes
         public abstract Shape CreateShape(String name);
}