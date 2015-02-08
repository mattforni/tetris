package com.mattforni.games.tetris.pieces;

/**
 * LinePiece.java
 * 
 * this class models the line piece from tetris.  it places four squares
 * along a single row creating a line of four smartsquares. 
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.Point;

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;

public class LinePiece extends Piece implements Constants {

	public LinePiece(Grid grid, Point p) {
		super(grid);
		setFillColor(java.awt.Color.DARK_GRAY);
    	if(insertFromTop(p)){
    	    _rect1.setLocation((p.x-1)*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect2.setLocation(p.x*SQ_SIZE, p.y*SQ_SIZE);
    	    _rect3.setLocation((p.x+1)*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect4.setLocation((p.x+2)*SQ_SIZE, p.y*SQ_SIZE);
    	} else {
    		_grid.endGame();
    		//System.err.println("End Game.");
    	}
    	grid.repaint();
	}
	
    private boolean insertFromTop(Point p) {
    	return (_rect1.canMove(p.y, p.x-1) && _rect2.canMove(p.y, p.x) &&
    		_rect3.canMove(p.y, p.x+1) && _rect4.canMove(p.y, p.x+2));
    }	

    public void setLocationFromTop(int r, int c) {
        _rect1.setLocation((c-1)*SQ_SIZE, r*SQ_SIZE);	
        _rect2.setLocation(c*SQ_SIZE, r*SQ_SIZE);
        _rect3.setLocation((c+1)*SQ_SIZE, r*SQ_SIZE);	
        _rect4.setLocation((c+2)*SQ_SIZE, r*SQ_SIZE);
    }
    
}
