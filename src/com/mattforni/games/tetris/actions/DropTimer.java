package com.mattforni.games.tetris.actions;

import javax.swing.Timer;

import com.mattforni.games.tetris.PieceProxy;

/**
 * This is the timer that controls the speed of the drop. Every
 * 'delay' milliseconds we tell the proxy to attepmt a down move.
 * If the piece can't move it's time for a new piece. 
 *
 * @uthor <Matt Fornaciari>
 */

@SuppressWarnings("serial")
public class DropTimer extends Timer{
    
    private PieceProxy _proxy;

    public DropTimer(PieceProxy proxy){
    	super(800, null);
    	_proxy = proxy;
    	addActionListener(new DropListener());
    }

    private class DropListener implements java.awt.event.ActionListener{
    	public void actionPerformed(java.awt.event.ActionEvent e){
    		_proxy.moveDown();
    	}
    }
}