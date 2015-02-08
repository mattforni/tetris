package com.mattforni.games.tetris.actions;

/**
 * MoveDown.java
 * 
 * this is the move down abstract action which is bound to the 'm' key.
 * basically whenever the drawing panel receives input from the 'm' key
 * it tells the proxy to move the current piece down.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class MoveDown extends AbstractAction {

	private PieceProxy _proxy;
	
	public MoveDown(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_proxy.moveDown();
	}

}
