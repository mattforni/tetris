package com.mattforni.games.tetris.actions;

/**
 * NewGame.java
 * 
 * this is the new game action listener which is bound to the 'new.' menuitem.
 * if the 'new.' menuitem is selected it tells the grid to abort the current
 * game and reset everything.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mattforni.games.tetris.Grid;

public class NewGame implements ActionListener {

	public Grid _grid;
	
	public NewGame(Grid grid) {
		_grid = grid;
	}

	public void actionPerformed(ActionEvent e) {
		_grid.newGame();
	}
}
