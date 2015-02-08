package com.mattforni.games.tetris.actions;

/**
 * Pause.java
 * 
 * this is the pause abstract action which is bound to the 'p' key.
 * basically whenever the drawing panel receives input from the 'p' key
 * it tells the proxy to pause the game and to display the 'paused.' message
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class Pause extends AbstractAction {

	private PieceProxy _proxy;
	
	public Pause(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_proxy.setPaused(!_proxy.getPaused());
	}

}
