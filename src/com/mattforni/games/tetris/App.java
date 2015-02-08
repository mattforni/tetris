package com.mattforni.games.tetris;

import javax.swing.JFrame;

/**
 * App.java
 * 
 * App class pretty much wraps the entire program up and instantiates
 * the tetris frame which is the top-level class.  
 * 
 * I want to take a moment to let you know that I've implemented 
 * 	keep score and line count
 * 	make the game progressively harder (every five lines cleared)
 * 	allow the player to restart whenever
 * 	allow the user to see the next piece
 * 
 * and just for kicks
 * 
 * 	there are three settings to start on
 * 
 * enjoy
 *
 * @uthor <Matthew Fornaciari>
 */

@SuppressWarnings("serial")
public class App extends JFrame{

	public App() {
        new TetrisFrame();
    }

    public static void main(String[] argv) {
    	new App();
    }
}