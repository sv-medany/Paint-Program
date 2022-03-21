/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionStates;

/**
 *
 * @author DR- Mohamed
 */
import programming.pkgfinal.paint.NewBoard;
import programming.pkgfinal.paint.NewBoard.modes;

/**
 *
 * @author DR- Mohamed
 */
public class MoveState implements State{

    @Override
    public void doFunction(NewBoard board) {
        board.mode=modes.move;
    } 
}
