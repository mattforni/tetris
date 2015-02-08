package com.mattforni.games.tetris.pieces;

/**
 * LLPiece.java
 * 
 * this class models the left-facing L piece from tetris.  it places three squares
 * along a single column and one square to the left of the last square,
 * creating a left-facing L of four smartsquares. 
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.Point;

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;

public class LLPiece extends Piece implements Constants {

    public LLPiece(Grid grid, Point p) {
    	super(grid);
    	setFillColor(java.awt.Color.RED);
    	if(insertFromTop(p)){
    	    _rect1.setLocation(p.x*SQ_SIZE, p.y*SQ_SIZE);	
    	    _rect2.setLocation(p.x*SQ_SIZE, (p.y+1)*SQ_SIZE);
    	    _rect3.setLocation(p.x*SQ_SIZE, (p.y+2)*SQ_SIZE);	
    	    _rect4.setLocation((p.x-1)*SQ_SIZE, (p.y+2)*SQ_SIZE);
    	} else {
    		_grid.endGame();
    		//System.err.println("End Game.");
    	}
    	grid.repaint();
    }
    
    private boolean insertFromTop(Point p) {
    	return (_rect1.canMove(p.y, p.x) && _rect2.canMove(p.y+1, p.x) &&
    		_rect3.canMove(p.y+2, p.x) && _rect4.canMove(p.y+2, p.x-1));
    }

    public void setLocationFromTop(int r, int c) {
    	_rect1.setLocation(c*SQ_SIZE, r*SQ_SIZE);	
    	_rect2.setLocation(c*SQ_SIZE, (r+1)*SQ_SIZE);
    	_rect3.setLocation(c*SQ_SIZE, (r+2)*SQ_SIZE);	
    	_rect4.setLocation((c-1)*SQ_SIZE, (r+2)*SQ_SIZE);    		
    }
}
