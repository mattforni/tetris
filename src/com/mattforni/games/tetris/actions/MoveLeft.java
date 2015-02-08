package com.mattforni.games.tetris.actions;

/**
 * MoveLeft.java
 * 
 * this is the move left abstract action which is bound to the 'j' key.
 * basically whenever the drawing panel receives input from the 'j' key
 * it tells the proxy to move the current piece left.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class MoveLeft extends AbstractAction {

	private PieceProxy _proxy;
	
	public MoveLeft(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("moving left");
		_proxy.moveLeft();
	}

}
