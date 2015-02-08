package com.mattforni.games.tetris.pieces;

/**
 * Piece.java
 * 
 * this is the piece abstract class which defines the vast majority of the
 * piece subclass's methods.  However, each of the subclasses then design 
 * their own constructors and placement.  this class contains all four smartsquares
 * that make up the piece.  
 * 
 * <@uthor Matt Fornaciari>
 * 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Vector;

import com.mattforni.games.tetris.Constants;
import com.mattforni.games.tetris.Grid;

public abstract class Piece implements Constants {
	
    protected SmartSquare _rect1, _rect2, _rect3, _rect4;
    protected Vector<SmartSquare> _squares;
    protected Grid _grid;
    private boolean[][] _occupied;
    
    public Piece(Grid grid) {
    	_grid = grid;
    	_occupied = _grid.getOccupied();
    	_squares = new Vector<SmartSquare>();
    	
    	_rect1 = new SmartSquare(_grid, 0, 0);	
	    _rect2 = new SmartSquare(_grid, 0, 0);
	    _rect3 = new SmartSquare(_grid, 0, 0);	
	    _rect4 = new SmartSquare(_grid, 0, 0);
    	
	    _squares.add(_rect1);
    	_squares.add(_rect2);
    	_squares.add(_rect3);
    	_squares.add(_rect4);
    	setBorderColor(Color.WHITE);
    }

	public void left() {
		if(_rect1.canMove(_rect1.getRow(), _rect1.getCol()-1) && _rect1.canMove(_rect2.getRow(), _rect2.getCol()-1) &&
		   _rect3.canMove(_rect3.getRow(), _rect3.getCol()-1) && _rect4.canMove(_rect4.getRow(), _rect4.getCol()-1)){
			for(SmartSquare square : _squares)
		    	square.left();
			_grid.repaint();
		} 
	}
	
	public void right() {
		if(_rect1.canMove(_rect1.getRow(), _rect1.getCol()+1) && _rect1.canMove(_rect2.getRow(), _rect2.getCol()+1) &&
		   _rect3.canMove(_rect3.getRow(), _rect3.getCol()+1) && _rect4.canMove(_rect4.getRow(), _rect4.getCol()+1)){
			for(SmartSquare square : _squares)
			   	square.right();
			_grid.repaint();
		} 		
	}
	
	public void down() {
		if(_rect1.canMove(_rect1.getRow()+1, _rect1.getCol()) && _rect1.canMove(_rect2.getRow()+1, _rect2.getCol()) &&
		   _rect3.canMove(_rect3.getRow()+1, _rect3.getCol()) && _rect4.canMove(_rect4.getRow()+1, _rect4.getCol())){
			for(SmartSquare square : _squares)
			   	square.down();
			_grid.repaint();
		} else {
			for (SmartSquare square : _squares) {
				//System.out.println("Adding "+square.getRow()+", "+square.getCol());
				_occupied[square.getRow()][square.getCol()] = true;
				_grid.addSquare(square);
			}
			_grid.checkRows();
			//_grid.printOccupied();
		}
	}
	
	public void drop() {
		while(_rect1.canMove(_rect1.getRow()+1, _rect1.getCol()) && _rect1.canMove(_rect2.getRow()+1, _rect2.getCol()) &&
		   _rect3.canMove(_rect3.getRow()+1, _rect3.getCol()) && _rect4.canMove(_rect4.getRow()+1, _rect4.getCol())){
			for(SmartSquare square : _squares)
			   	square.down();
			_grid.repaint();
		}
	}	    

	public void rotate() {
		Point cor = new Point((int)_rect3.getX(), (int)_rect3.getY());
		
		Point p1 = new Point((int)_rect1.getX(), (int)_rect1.getY());
		int r1_x = cor.x - cor.y + p1.y;
		int r1_y = cor.x + cor.y - p1.x;
		
		Point p2 = new Point((int)_rect2.getX(), (int)_rect2.getY());
		int r2_x = cor.x - cor.y + p2.y;
		int r2_y = cor.x + cor.y - p2.x;
		
		Point p4 = new Point((int)_rect4.getX(), (int)_rect4.getY());
		int r4_x = cor.x - cor.y + p4.y;
		int r4_y = cor.x + cor.y - p4.x;

		if(_rect1.canMove(r1_y/SQ_SIZE, r1_x/SQ_SIZE) && _rect2.canMove(r2_y/SQ_SIZE, r2_x/SQ_SIZE) &&
		   _rect4.canMove(r4_y/SQ_SIZE, r4_x/SQ_SIZE)){
		    _rect1.setLocation(r1_x, r1_y);	
		    _rect2.setLocation(r2_x, r2_y);
		    _rect4.setLocation(r4_x, r4_y);
		    _grid.repaint();
		}

	}
	
	public void setBorderColor(Color color) {
		for (SmartSquare square : _squares)
			square.setBorderColor(color);
	}

	public void setFillColor(Color color) {
		for (SmartSquare square : _squares)
			square.setFillColor(color);
	}
	
	public void paint(Graphics2D brush){
		for (SmartSquare square : _squares)
			square.paint(brush);
	}
	
	public abstract void setLocationFromTop(int r, int c);
}
