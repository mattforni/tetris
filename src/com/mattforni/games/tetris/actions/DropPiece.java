package com.mattforni.games.tetris.actions;

/**
 * DropPiece.java
 * 
 * this is the drop piece abstract action which is bound to the space bar.
 * basically whenever the drawing panel receives input from the space bar
 * it tells the proxy to drop the current piece.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.mattforni.games.tetris.PieceProxy;

@SuppressWarnings("serial")
public class DropPiece extends AbstractAction {

	private PieceProxy _proxy;
	
	public DropPiece(PieceProxy proxy) {
		_proxy = proxy;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		_proxy.drop();
	}

}
