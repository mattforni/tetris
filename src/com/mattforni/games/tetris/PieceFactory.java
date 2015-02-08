package com.mattforni.games.tetris;

/**
 * PieceFactory.java
 * 
 * this class simply statically generates a random piece to be placed
 * on the grid
 * 
 * <@uthor Matt Fornaciari>
 * 
 */


import java.awt.Point;
import java.util.Random;

import com.mattforni.games.tetris.pieces.LLPiece;
import com.mattforni.games.tetris.pieces.LZPiece;
import com.mattforni.games.tetris.pieces.LinePiece;
import com.mattforni.games.tetris.pieces.Piece;
import com.mattforni.games.tetris.pieces.RLPiece;
import com.mattforni.games.tetris.pieces.RZPiece;
import com.mattforni.games.tetris.pieces.SquarePiece;
import com.mattforni.games.tetris.pieces.TPiece;

public class PieceFactory implements Constants {
    
	private static Random _rand = new Random();
	private static Point p = new Point(NUM_COLS/2, 0);
	
	public static Piece generatePiece(Grid grid){
    	int rand = _rand.nextInt(7)+1;
    	
		switch(rand){
			case 1:
			    return new LZPiece(grid, p);
			case 2:
			    return new RZPiece(grid, p);
			case 3:
			    return new TPiece(grid, p);
			case 4:
			    return new SquarePiece(grid, p);
			case 5:
			    return new LLPiece(grid, p);
			case 6:
			    return new RLPiece(grid, p);
			case 7:
			    return new LinePiece(grid, p);
			default:
			    return null;
		}
    }
}
