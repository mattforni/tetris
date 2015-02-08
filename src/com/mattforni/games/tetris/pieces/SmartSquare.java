package com.mattforni.games.tetris.pieces;

/**
 * SmartSquare.java
 * 
 * this class models a single intelligent square which extends from gfx.Rectangle.  
 * this class is intelligent because it knows how to check to see if a move is allowed
 * as well as knowing how to respond to each of the actions called. it does the majority
 * of the work in moving pieces around.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;
import com.mattforni.graphics.shape.Rectangle;

public class SmartSquare extends Rectangle implements Constants {
	
	private boolean[][] _occupied;
	
    public SmartSquare(Grid grid, double x, double y){
    	super(grid, x, y, SQ_SIZE, SQ_SIZE);
    	_occupied = grid.getOccupied();
    }
    
    public boolean canMove(int row, int col){
    	if (row < 0 || row > NUM_ROWS-1 || col < 0 || col > NUM_COLS-1)
    		return false;
    	//System.out.println("["+row+", "+col+"]");
    	return !_occupied[row][col];
    }
    
    public int getRow(){
    	return (int)(getY()/SQ_SIZE);
    }

    public int getCol(){
    	return (int)(getX()/SQ_SIZE);
    }
    
    public void left(){
    	setLocation((getCol()-1)*SQ_SIZE, getRow()*SQ_SIZE);
    }

    public void right(){
    	setLocation((getCol()+1)*SQ_SIZE, getRow()*SQ_SIZE);
    }

    public void down(){
    	setLocation(getCol()*SQ_SIZE, (getRow()+1)*SQ_SIZE);
    }

}
