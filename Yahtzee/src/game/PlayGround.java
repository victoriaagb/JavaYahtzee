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
	private Die dieOne;
	private Die dieTwo;
	private Die dieThree;
	private Die dieFour;
	private Die dieFive;
	
	public PlayGround(){
		
		window = new JFrame(); 
		mainPanel = new JPanel(new GridLayout(0,2));
		mainPanel.setPreferredSize(new Dimension(400, 350));
		
		scorePanel = new JPanel();
		scorePanel.add(new ScoreBoard());
		
		dieOne = new Die();
		dieTwo = new Die();
		dieThree = new Die();
		dieFour = new Die();
		dieFive = new Die();
		rollDice = new JButton("Roll Dice");
		rollDice.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				
			}
		});
		
		dicePanel = new JPanel(new GridLayout(5, 2));
		dicePanel.add(dieOne);
		dicePanel.add(dieTwo);
		dicePanel.add(dieThree);
		dicePanel.add(dieFour);
		dicePanel.add(dieFive);
		dicePanel.add(rollDice);
		
		mainPanel.add(dicePanel);
		mainPanel.add(scorePanel);
		
		// configure GUI components
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.add(mainPanel);
	
		//make GUI visible
		window.pack();
		window.setVisible(true);
	}
}
