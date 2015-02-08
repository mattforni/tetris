package com.mattforni.games.tetris;

/**
 * PieceProxy.java
 * 
 * since the current piece is constantly changing we use the proxy pattern
 * to tell the current piece to respond to the actions.  this proxy actually
 * keeps track of the current piece as well as the next piece so the user
 * can know what to expect.
 * 
 * this class also controls if the game is paused or not by controlling the
 * current pieces drop timer.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */


import com.mattforni.games.tetris.actions.DropTimer;
import com.mattforni.games.tetris.pieces.Piece;

public class PieceProxy implements Constants {

    private Piece _proxy, _next;
    private Grid _grid;
    private DropTimer _drop;
    private boolean _isPaused;
    
    public PieceProxy(Grid grid) {
    	_grid = grid;
    	_drop = new DropTimer(this);
    	_drop.start();
    	
    	_next = PieceFactory.generatePiece(_grid);
    	_isPaused = false;
    	
    	newPiece();
    }
    
    public void newPiece() {
    	_proxy = _next;
    	_proxy.setLocationFromTop(0, (int)(NUM_COLS/2.0));
    	_grid.setPiece(_proxy);
    	_next = PieceFactory.generatePiece(_grid);
    	_next.setLocationFromTop(2, NUM_COLS+2);
    	_grid.setNext(_next);
    }

    public void moveLeft() {
    	_proxy.left();
    }

    public void moveRight() {
    	_proxy.right();
    }    
    
    public int getDelay() {
    	return _drop.getDelay();
    }
    
    public void setDelay(int delay) {
    	_drop.setDelay(delay);
    }
    
    public void moveDown() {
    	_proxy.down();
    }

    public void drop() {
    	_proxy.drop();
    }
        
    public void rotate() {
    	_proxy.rotate();
    }
    
    public void setPaused(boolean pause) {
    	_isPaused = pause;
    	if (_isPaused) {
    		_drop.stop();
    	} else {
    		_drop.start();
    	}
    	_grid.pause(_isPaused);
    	_grid.repaint();
    }
    
    public boolean getPaused() {
    	return _isPaused;
    }
    
    public void stop() {
    	_drop.stop();
    }
}
