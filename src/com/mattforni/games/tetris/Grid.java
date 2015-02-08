package com.mattforni.games.tetris;

/**
 * Grid.java
 * 
 * this is the meat of the program and contains both the logical and graphical
 * containment.  this class knows how to check the rows after a piece has finished
 * dropping.  it knows how to clear and realign rows.  essentially it handles the majority
 * of gameplay with the help of a few other classes.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.mattforni.games.tetris.pieces.Piece;
import com.mattforni.games.tetris.pieces.SmartSquare;

@SuppressWarnings("serial")
public class Grid extends JPanel implements Constants {
	
	private boolean[][] _occupied;
	private Vector<SmartSquare> _squares;
	private Piece _currPiece, _nextPiece;
	private TetrisFrame _tetris;
	private int _rowsCleared, _score;
	private Font _pauseFont;
	private boolean _isOver;
	
	public Grid(TetrisFrame tetris) {
		super();
		_tetris = tetris;
		setSize(new Dimension(NUM_COLS*SQ_SIZE+SIDE_PANEL, NUM_ROWS*SQ_SIZE));
		setPreferredSize(new Dimension(NUM_COLS*SQ_SIZE+SIDE_PANEL, NUM_ROWS*SQ_SIZE));
		
		_occupied = new boolean[NUM_ROWS][NUM_COLS];
		_squares = new Vector<SmartSquare>();
		
		constructBorders();
		
		_currPiece = null; _nextPiece = null;
		_rowsCleared = 0;
		_score = 0;
		
		_pauseFont = new Font("SansSerif", Font.PLAIN, 20);
		_isOver = false;

		//printOccupied();
	}
	
	public PieceProxy getProxy() {
		return _tetris.getProxy();
	}
	
	public void addSquare(SmartSquare square) {
		//System.out.println("square "+square.getRow()+", "+square.getCol());
		_squares.add(square);
		//System.out.println(_squares.size());
	}
	
    public void newGame(){
    	// clears the logical containment
    	for(int r = 0; r < NUM_ROWS-1; r++) {
    	    for(int c = 1; c < NUM_COLS-1; c++){
    	    	_occupied[r][c] = false;
    	    }
    	}
    	//printOccupied();
    	// clears and reconstructs the borders
    	// of the graphical containment
    	_squares.clear();
    	constructBorders();
    	
    	// makes sure the game is not paused
    	_tetris.getProxy().setPaused(false);
    	_tetris.getProxy().newPiece();
    	// resets the rows cleared
    	_rowsCleared = 0;
    	_score = 0;
    	_isOver = false;
    	pause(false);
    }
    
    public void endGame() {
    	// when a shape cannot be inserted the game ends
    	_tetris.getProxy().stop();
    	_isOver = true;
    	pause(true);
    }
    
    public boolean[][] getOccupied() {
    	return _occupied;
    }
    
    public void setPiece(Piece currPiece) {
    	_currPiece = currPiece;
    }
    
    public void setNext(Piece nextPiece) {
    	_nextPiece = nextPiece;
    }

	private void constructBorders() {
		for (int i = 0; i < NUM_ROWS; i++) {
			if (i == (NUM_ROWS-1)) { 
				for (int j = 0; j < NUM_COLS; j++) {
					_occupied[i][j] = true;
					_squares.add(new SmartSquare(this, j*SQ_SIZE, i*SQ_SIZE));
				}
			} else {
				_occupied[i][0] = true;
				_squares.add(new SmartSquare(this, 0, i*SQ_SIZE));
				_occupied[i][(NUM_COLS-1)] = true;
				_squares.add(new SmartSquare(this, (NUM_COLS-1)*SQ_SIZE, i*SQ_SIZE));
			}
		}
		repaint();
	}

    public void paintComponent(java.awt.Graphics g){
    	super.paintComponent(g);
        Graphics2D brush = (Graphics2D) g;
        
        // paint all squares
    	for (SmartSquare square : _squares)
    		square.paint(brush);
    	
    	//System.out.println(_currPiece);
    	// also paint the current moving piece
    	_currPiece.paint(brush) ;
    	_nextPiece.paint(brush);
    	
    	brush.setColor(Color.RED);
    	brush.setFont(_pauseFont);
    	//System.out.println(_tetris.getProxy().getPaused());
    	if (_tetris.getProxy().getPaused()) {
    		brush.drawString("paused.", (int)(((double)NUM_COLS*SQ_SIZE - getFontMetrics(_pauseFont).stringWidth("paused."))/2.0), (int)(((double)NUM_ROWS*SQ_SIZE)/2.0));
    		//brush.drawString("paused.", 0, 0);
    	}
    	brush.drawString("next piece.", (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth("next piece."))/2.0), SQ_SIZE);
    
    	brush.drawString("rows clear.", (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth("rows clear."))/2.0), (int)(7*SQ_SIZE));
    	brush.setColor(Color.WHITE);
    	brush.drawString(""+_rowsCleared, (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth(""+_rowsCleared))/2.0), (int)(8.5*SQ_SIZE));
    	brush.setColor(Color.RED);
    	brush.drawString("score.", (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth("score."))/2.0), (int)(11*SQ_SIZE));	
    	brush.setColor(Color.WHITE);
    	brush.drawString(""+_score, (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth(""+_score))/2.0), (int)(12.5*SQ_SIZE));	
    	brush.setColor(Color.RED);
    	brush.drawString("speed.", (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth("speed."))/2.0), (int)(15*SQ_SIZE));	
    	brush.setColor(Color.WHITE);
    	brush.drawString(""+(800-_tetris.getProxy().getDelay()), (int)(NUM_COLS*SQ_SIZE + (SIDE_PANEL - getFontMetrics(_pauseFont).stringWidth(""+(800-_tetris.getProxy().getDelay())))/2.0), (int)(16.5*SQ_SIZE));	

    	if (_isOver) {
    		brush.drawString("end game.", (int)(((double)NUM_COLS*SQ_SIZE - getFontMetrics(_pauseFont).stringWidth("end game."))/2.0), (int)(((double)NUM_ROWS*SQ_SIZE)/2.0));
    	}
    }

	public void printOccupied() {
    	for (int r = 0; r < NUM_ROWS; r++) {
    		for (int c = 0; c < NUM_COLS; c++) {
    			if (_occupied[r][c] == true)
    				System.out.print("x ");
    			else
    				System.out.print("- ");
    		}
    		System.out.println();
    	}
    }
    
    public void checkRows(){
    	for(int r = NUM_ROWS-2; r > -1; r--) {
    	    for(int c = 1 ; c < NUM_COLS-1; c++) {
	    		// if row == 1 check the whole row regardless
	    		// System.out.print("Col "+col+"\t");
	    		if(_occupied[r][c] == false)
	    		    break;
	    		
	    		if(c == (NUM_COLS-2) && _occupied[r][c] == true) {
	    		    removeRow(r);
	    			realign(r);
	    			//System.out.println("row "+r+" adjusted");
	    			_rowsCleared++;
	    			_score += 100;
	    			// this makes sure that every 5 rows the timer delay decreases
	    	    	// there is a clamp at 200
	    	    	PieceProxy proxy = _tetris.getProxy();
	    	    	if (_rowsCleared % 5 == 0 && _rowsCleared != 0) {
	    	    		int delay = (int)((double)proxy.getDelay()-50.0);
	    	    		if (delay > 200)
	    	    			proxy.setDelay(delay);
	    	    	}
	    			r++;
	    			//printOccupied();
	    		}
    	    }
    	}
    	//System.out.println("rows cleared "+_rowsCleared);
    	// new piece
    	_tetris.getProxy().newPiece();
    }
    
    private void removeRow(int r) {
    	// create a new collection of squares to remove [ the squares with row == r ]
    	Vector<SmartSquare> remove = new Vector<SmartSquare>();
    	for(SmartSquare square : _squares) {
    		//System.out.println(square.getRow()+", "+square.getCol());
    		if (square.getRow() == r && square.getCol() != 0 && square.getCol() != NUM_COLS-1) {
    			//System.out.println("===>"+square.getRow()+", "+square.getCol());
    			remove.add(square);
    		}
    	}
    	_squares.removeAll(remove);
    	
    	// also update the logical containment
    	for (int c = 1; c < NUM_COLS-1; c++) {
    		_occupied[r][c] = false;
    	}
    }
    
    private void realign(int row) {
    	// update the graphical containment
    	for (SmartSquare square : _squares) {
    		if (square.getRow() < row && square.getCol() != 0 && square.getCol() != NUM_COLS-1) 
    			square.down();
    	}
    	
    	// update the logical containment
    	for (int r = row; r > 0; r--) {
    		for (int c = 1; c < NUM_COLS-1; c++) {
	    			_occupied[r][c] = _occupied[r-1][c];
	    	}
    	}
    	//printOccupied();
    }
    
    public void pause(boolean pause) {
		InputMap iMap = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);

    	if (pause) {
    		iMap.put(KeyStroke.getKeyStroke('j'), null);
    		iMap.put(KeyStroke.getKeyStroke('k'), null);
    		iMap.put(KeyStroke.getKeyStroke('l'), null);
    		iMap.put(KeyStroke.getKeyStroke('m'), null);
    		iMap.put(KeyStroke.getKeyStroke(' '), null);
    		iMap.put(KeyStroke.getKeyStroke('q'), null);
    	} else {
    		iMap.put(KeyStroke.getKeyStroke('j'), "left");
    		iMap.put(KeyStroke.getKeyStroke('k'), "rotate");
    		iMap.put(KeyStroke.getKeyStroke('l'), "right");
    		iMap.put(KeyStroke.getKeyStroke('m'), "down");
    		iMap.put(KeyStroke.getKeyStroke(' '), "drop");
    		iMap.put(KeyStroke.getKeyStroke('q'), "quit");   		
    	}
    }
    
}
