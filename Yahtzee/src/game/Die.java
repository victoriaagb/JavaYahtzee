package game;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Die {
	int  weight;
	
	public Die(JPanel mainPanel){
		JButton piece = new JButton("");
		mainPanel.add(piece);
	}
	
	int currentNumber(){
		return weight;
	}
	
	void setNumber(int amount){
		weight = amount;
	}
	
	
}
