package game;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class PlayGround {
	private final JFrame window;
	private final JPanel mainPanel;
	private final JButton rollDice;
	private Die dieOne;
	private Die dieTwo;
	private Die dieThree;
	private Die dieFour;
	private Die dieFive;
	
	public PlayGround(){
		window = new JFrame(); 
		mainPanel = new JPanel(new GridLayout(10,20));
		mainPanel.setPreferredSize(new Dimension(400, 350));
		rollDice = new JButton("Roll Dice");
		rollDice.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		dieOne = new Die(mainPanel);
		dieTwo = new Die(mainPanel);
		dieThree = new Die(mainPanel);
		dieFour = new Die(mainPanel);
		dieFive = new Die(mainPanel);
		
		// configure GUI components
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mainPanel.add(rollDice);
		window.add(mainPanel);
	
		//make GUI visible
		window.pack();
		window.setVisible(true);
	}
}
