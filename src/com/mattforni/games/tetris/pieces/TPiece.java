package com.mattforni.games.tetris.pieces;

/**
 * TPiece.java
 * 
 * this class models the T piece from tetris.  it places one square
 * along a row, then drops a row and places three more,
 * creating a T of four smartsquares. 
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.Point;

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;

public class TPiece extends Piece implements Constants {

	public TPiece(Grid grid, Point p) {
		super(grid);
		setFillColor(java.awt.Color.LIGHT_GRAY);
    	if(insertFromTop(p)){
    	    _rect1.setLocation(p.x*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect2.setLocation((p.x-1)*SQ_SIZE, p.y*SQ_SIZE);
    	    _rect3.setLocation((p.x+1)*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect4.setLocation(p.x*SQ_SIZE, (p.y+1)*SQ_SIZE);
    	} else {
    		_grid.endGame();
    		//System.err.println("End Game.");
    	}
    	grid.repaint();
	}
	
    private boolean insertFromTop(Point p) {
    	return (_rect1.canMove(p.y, p.x) && _rect2.canMove(p.y, p.x-1) &&
    		_rect3.canMove(p.y, p.x+1) && _rect4.canMove(p.y+1, p.x));
    }	

    public void setLocationFromTop(int r, int c) {
        _rect1.setLocation(c*SQ_SIZE, r*SQ_SIZE);	
        _rect2.setLocation((c-1)*SQ_SIZE, r*SQ_SIZE);
        _rect3.setLocation((c+1)*SQ_SIZE, r*SQ_SIZE);	
        _rect4.setLocation(c*SQ_SIZE, (r+1)*SQ_SIZE);
    }

}
