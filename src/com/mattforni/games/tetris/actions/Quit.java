package com.mattforni.games.tetris.actions;

/**
 * Quit.java
 * 
 * this is the quit action listener which is bound to the 'quit.' menuitem.
 * oddly enough it quits the program.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class Quit extends AbstractAction {

	public Quit() {
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}

}
