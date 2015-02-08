package com.mattforni.games.tetris.actions;

/**
 * RotatePiece.java
 * 
 * this is the rotate piece abstract action which is bound to the 'k' key.
 * basically whenever the drawing panel receives input from the 'k' key
 * it tells the proxy to rotate the current piece.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class RotatePiece extends AbstractAction {

	private PieceProxy _proxy;
	
	public RotatePiece(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_proxy.rotate();
	}

}
