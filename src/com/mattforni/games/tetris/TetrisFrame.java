package com.mattforni.games.tetris;

/**
 * TetrisFrame.java
 * 
 * this is the top-level class which creates the graphical portion of the app,
 * grid, and adds it to the scene.  it also initialized the input and action
 * maps for the grid.  lastly, it is this class that starts the game by telling 
 * the proxy to generate its first piece.
 * 
 * <@uthor Matt Fornaciari>
 * 
 */


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.mattforni.games.tetris.actions.DropPiece;
import com.mattforni.games.tetris.actions.DropSpeed;
import com.mattforni.games.tetris.actions.MoveDown;
import com.mattforni.games.tetris.actions.MoveLeft;
import com.mattforni.games.tetris.actions.MoveRight;
import com.mattforni.games.tetris.actions.NewGame;
import com.mattforni.games.tetris.actions.Pause;
import com.mattforni.games.tetris.actions.Quit;
import com.mattforni.games.tetris.actions.RotatePiece;

@SuppressWarnings("serial")
public class TetrisFrame extends JFrame implements Constants {

	private Grid _grid;
	private PieceProxy _proxy;
	
	public TetrisFrame() {
		super("the game of tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		construct();
		initMaps();
		
		startGame();
		
		pack();
    	setVisible(true);
	}
	
	public PieceProxy getProxy() {
		return _proxy;
	}
	
	private void startGame() {
		_proxy.newPiece();
	}
	
	private void construct() {
		_grid = new Grid(this);
		_grid.setBackground(Color.BLACK);
		add(_grid);

		_proxy = new PieceProxy(_grid);
		
		// construction and addition of the menu bar
		JMenuBar menuBar = new JMenuBar();
		JMenu game = new JMenu("Game");
		JMenuItem newGame = new JMenuItem("new.");
		newGame.addActionListener(new NewGame(_grid));
		JMenuItem quitGame = new JMenuItem("quit.");
		quitGame.addActionListener(new QuitGame());
		game.add(newGame);
		game.add(quitGame);
		
		JMenu diff = new JMenu("Difficulty");
		JMenuItem easy = new JMenuItem("play nice.");
		easy.addActionListener(new DropSpeed(_grid, _proxy, 800));
		JMenuItem med = new JMenuItem("50 percent.");	
		med.addActionListener(new DropSpeed(_grid, _proxy, 600));
		JMenuItem hard = new JMenuItem("bring it.");
		hard.addActionListener(new DropSpeed(_grid, _proxy, 400));
		diff.add(easy);	
		diff.add(med);
		diff.add(hard);
		menuBar.add(game);
		menuBar.add(diff);
		setJMenuBar(menuBar);
	}
	
	private void initMaps() {
		InputMap iMap = _grid.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		ActionMap aMap = _grid.getActionMap();

		iMap.put(KeyStroke.getKeyStroke('j'), "left");
		iMap.put(KeyStroke.getKeyStroke('k'), "rotate");
		iMap.put(KeyStroke.getKeyStroke('l'), "right");
		iMap.put(KeyStroke.getKeyStroke('m'), "down");
		iMap.put(KeyStroke.getKeyStroke('p'), "pause");
		iMap.put(KeyStroke.getKeyStroke(' '), "drop");
		iMap.put(KeyStroke.getKeyStroke('q'), "quit");

		aMap.put("left", new MoveLeft(_proxy));
		aMap.put("rotate", new RotatePiece(_proxy));
		aMap.put("right", new MoveRight(_proxy));
		aMap.put("down", new MoveDown(_proxy));
		aMap.put("pause", new Pause(_proxy));
		aMap.put("drop", new DropPiece(_proxy));
		aMap.put("quit", new Quit());
		/** end code for actionMap and InputMap for the GameBoard **/
	}

	private class QuitGame implements ActionListener {

		public QuitGame() {
		}
		
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
}
