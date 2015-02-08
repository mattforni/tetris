package com.mattforni.games.tetris.actions;

/**
 * MoveRight.java
 * 
 * this is the move right abstract action which is bound to the 'l' key.
 * basically whenever the drawing panel receives input from the 'l' key
 * it tells the proxy to move the current piece right.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class MoveRight extends AbstractAction {

	private PieceProxy _proxy;
	
	public MoveRight(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_proxy.moveRight();
	}

}
