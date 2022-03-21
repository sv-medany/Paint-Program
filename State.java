/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionStates;

import programming.pkgfinal.paint.NewBoard;

/**
 *
 * @author DR- Mohamed
 */
public interface State {
    public abstract void doFunction(NewBoard board);
}
