package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PlayGame {
	
	public static void main(String[] args){
		
		//declare controls
		final JFrame mainMenu = new JFrame();
		final JPanel startPanel = new JPanel();
		final JButton singleGame;
		final JButton duoGame;
		
		mainMenu.add(startPanel);
		startPanel.setPreferredSize(new Dimension(300, 200));
		
		//add single player game button
		singleGame = new JButton("Play a one player game");
		singleGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				mainMenu.setVisible(false);
				PlayGround playground = new PlayGround();
			}
		});
		
		//add two player game button
		duoGame = new JButton("Play a two player game");
		duoGame.setEnabled(false);
		
		startPanel.add(singleGame);
		startPanel.add(duoGame);
		mainMenu.pack(); //resizes components to make them fit
		mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //ends event thread after closing window
		mainMenu.setVisible(true);
	}
}
