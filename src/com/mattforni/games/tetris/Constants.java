package com.mattforni.games.tetris;

/**
 * Constants.java
 * 
 * this class simply holds some important constants.
 * 
 * ps. you can change the side of my board by changing num_rows and num_cols
 * go ahead. play around with it.
 *  
 * <@uthor Matt Fornaciari>
 * 
 */


public interface Constants {

	public static final int NUM_ROWS = 27;
	public static final int NUM_COLS = 21;
	
	public static final int NP_SIZE = 100;

	public static final int SQ_SIZE = 20;
	
	public static final int SIDE_PANEL = 6*SQ_SIZE;
	
	public static final int GRID_W = NUM_COLS*SQ_SIZE;
	public static final int GRID_H = NUM_ROWS*SQ_SIZE;
}
