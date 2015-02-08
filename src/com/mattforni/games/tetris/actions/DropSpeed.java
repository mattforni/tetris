package com.mattforni.games.tetris.actions;

/**
 * DropSpeed.java
 * 
 * this is the drop speed action listener which responds to the difficulty menu bar.
 * whenever the difficulty of a game is changed this action is called.  it resets
 * the proxy's drop timer to the corresponding speed and then restarts the game at
 * the new level.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mattforni.games.tetris.Grid;
import com.mattforni.games.tetris.PieceProxy;

public class DropSpeed implements ActionListener {

	private int _delay;
    private PieceProxy _proxy;
    private Grid _grid;

    public DropSpeed(Grid grid, PieceProxy proxy, int delay){
    	_proxy = proxy;
		_delay = delay;
		_grid = grid;
    }

    public void actionPerformed(ActionEvent e){
    	System.out.println(_proxy);
    	_proxy.setDelay(_delay);
    	_grid.newGame();
    }

}
