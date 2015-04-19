package game;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PlayGround {
	private final JFrame window;
	
	private final JPanel mainPanel;
	private final JPanel scorePanel;
	private final JPanel dicePanel;
	
	private final JButton rollDice;
	private final JComboBox selectType;
	String[] types = {"", "Ones", "Twos", "Threes", "Fours", "Fives", "Sixes",
			"3 of a kind", "4 of a kind", "Full House", "Small Straight", "Large Straight", "Yahtzee", "Chance"};
	private final JButton saveScore;

	private final JLabel topScore = new JLabel("Top Score");
	private final JLabel displayTopScore = new JLabel("0");
	private final JLabel bottomScore = new JLabel("Bottom Score");
	private final JLabel displayBottomScore = new JLabel("0");
	private final JLabel bonusScore = new JLabel("Bonus Score");
	private final JLabel displayBonusScore = new JLabel("0");
	private final JLabel totalScore = new JLabel("Total Score");
	private final JLabel displayTotalScore = new JLabel("0"); 
	
	private final ScoreBoard sb = new ScoreBoard();
	private final Die[] dices;
	private int clicked;
	
	public PlayGround(){
		
		clicked = 0;
		window = new JFrame(); 
		mainPanel = new JPanel(new GridLayout(0,2));
		mainPanel.setPreferredSize(new Dimension(700, 700));
		
		scorePanel = new JPanel(new GridLayout(2,4));
		scorePanel.add(topScore);
		scorePanel.add(displayTopScore);		
		scorePanel.add(bottomScore);
		scorePanel.add(displayBottomScore);
		scorePanel.add(bonusScore);
		scorePanel.add(displayBonusScore);
		scorePanel.add(totalScore);
		scorePanel.add(displayTotalScore);
		
		dicePanel = new JPanel(new GridLayout(4, 2));
		final Die[] dice = new Die[5];
		dice[0] = new Die();
		dice[1] = new Die();
		dice[2] = new Die();
		dice[3] = new Die();
		dice[4] = new Die();
		dices = new Die[5];
		dices[0] = new Die();
		dices[1] = new Die();
		dices[2] = new Die();
		dices[3] = new Die();
		dices[4] = new Die();
		
		
		
		rollDice = new JButton("Roll Dice");
		for (Die i : dice){
			final Die die = i;
			
			rollDice.addActionListener(new ActionListener(){
		
				@Override
				public void actionPerformed(ActionEvent e) {
					die.setEnabled(true);
					die.rollDie();
					if (dices[0] == die){
						clicked++;
						if (clicked % 3 == 0){
							rollDice.setEnabled(false);
						}
					}
				}
				
			});
				
				dicePanel.add(i);
		}
	
		for (Die i : dice) {
			final Die die = i;
			i.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					die.changeLock();
					
				}
				
			});
			
			dicePanel.add(i);
		}
		
		selectType = new JComboBox(types);
		selectType.setSelectedIndex(0);
		saveScore = new JButton("Save Score");
		saveScore.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int score;
				switch(selectType.getSelectedIndex()){
				case 1: 
					score = sb.count(1, dice);
					sb.setScore(0, score);
					break;
				case 2:
					score = sb.count(2, dice);
					sb.setScore(1, score);
					break;
				case 3:
					score =sb.count(3, dice);
					sb.setScore(2, score);
					break;
				case 4:
					score = sb.count(4, dice);
					sb.setScore(3, score);
					break;
				case 5:
					score = sb.count(5, dice);
					sb.setScore(4, score);
					break;
				case 6:
					score = sb.count(6, dice);
					sb.setScore(5, score);
					break;
				case 7:
					score = sb.numberOfAKind(3, dice);
					sb.setScore(6, score);
					break;
				case 8: 
					score = sb.numberOfAKind(4, dice);
					sb.setScore(7, score);
					break;
				case 9:
					if(sb.fullHouse(dice))
						sb.setScore(8, 25);
					else sb.setScore(9, 0);
					break;
				case 10:
					if(sb.numStraight(4, dice))
						sb.setScore(9, 30);
					else sb.setScore(10, 0);
					break;
				case 11:
					if(sb.numStraight(5, dice))
						sb.setScore(10, 40);
				case 12:
					if(sb.yahtzee(dice))
						sb.setScore(10, 50);
					break;
				case 13:
					score = sb.chance(dice);
					sb.setScore(11, score);
					break;
				default: break;
				
				}
				
				displayTopScore.setText(Integer.toString(sb.totaltopScore()));
				displayBottomScore.setText(Integer.toString(sb.bottomScore()));
				displayBonusScore.setText(Integer.toString(sb.bonusScore()));
				displayTotalScore.setText(Integer.toString(sb.grandTotal()));
			}
		});
		
		dicePanel.add(rollDice);
		dicePanel.add(selectType);
		dicePanel.add(saveScore);
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
