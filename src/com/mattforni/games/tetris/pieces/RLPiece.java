package com.mattforni.games.tetris.pieces;

/**
 * RLPiece.java
 * 
 * this class models the right-facing L piece from tetris.  it places three squares
 * along a single column and one square to the right of the last square,
 * creating a right-facing L of four smartsquares. 
 * 
 * <@uthor Matt Fornaciari>
 * 
 */


import java.awt.Point;

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;

public class RLPiece extends Piece implements Constants {

	public RLPiece(Grid grid, Point p) {
		super(grid);
		setFillColor(java.awt.Color.GREEN);
    	if(insertFromTop(p)){
    	    _rect1.setLocation(p.x*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect2.setLocation(p.x*SQ_SIZE, (p.y+1)*SQ_SIZE);
    	    _rect3.setLocation(p.x*SQ_SIZE, (p.y+2)*SQ_SIZE);	
    	    _rect4.setLocation((p.x+1)*SQ_SIZE, (p.y+2)*SQ_SIZE);
    	} else {
    		//System.err.println("End Game.");
    		_grid.endGame();
    	}
    	grid.repaint();
	}

    private boolean insertFromTop(Point p) {
    	return (_rect1.canMove(p.y, p.x) && _rect2.canMove(p.y+1, p.x) &&
    		_rect3.canMove(p.y+2, p.x) && _rect4.canMove(p.y+2, p.x+1));
    }	

    public void setLocationFromTop(int r, int c) {
        _rect1.setLocation(c*SQ_SIZE, r*SQ_SIZE);	
        _rect2.setLocation(c*SQ_SIZE, (r+1)*SQ_SIZE);
        _rect3.setLocation(c*SQ_SIZE, (r+2)*SQ_SIZE);	
        _rect4.setLocation((c+1)*SQ_SIZE, (r+2)*SQ_SIZE);
    }

}
