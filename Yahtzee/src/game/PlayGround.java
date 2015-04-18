package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PlayGround {
	private final JFrame window;
	private final JPanel mainPanel;
	private final JPanel scorePanel;
	private final JPanel dicePanel;
	private final JButton rollDice;

	
	public PlayGround(){
		
		window = new JFrame(); 
		mainPanel = new JPanel(new GridLayout(0,2));
		mainPanel.setPreferredSize(new Dimension(400, 350));
		
		scorePanel = new JPanel();
		scorePanel.add(new ScoreBoard());
		
		dicePanel = new JPanel(new GridLayout(5, 2));
		
		final Die[] dices = new Die[5];
		dices[0] = new Die();
		dices[1] = new Die();
		dices[2] = new Die();
		dices[3] = new Die();
		dices[4] = new Die();
		
		
		rollDice = new JButton("Roll Dice");
		for (Die i : dices){
			final Die die = i;
			
			rollDice.addActionListener(new ActionListener(){
			
				@Override
				public void actionPerformed(ActionEvent e) {
					die.setEnabled(true);
					die.rollDie();
				}
			
			});
	
				dicePanel.add(i);
		}
	
		for (Die i : dices) {
			final Die die = i;
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					die.changeLock();
					
				}
				
			});
			
			dicePanel.add(i);
		}
		
		dicePanel.add(rollDice);
		mainPanel.add(dicePanel);
		mainPanel.add(scorePanel);
		//mainPanel.add(rollDice);
		
		// configure GUI components
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(mainPanel);
	
		//make GUI visible
		window.pack();
		window.setVisible(true);
	}
	
	
	
}
