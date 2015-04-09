package game;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Die {
	int  value = 6;
	boolean locked = false;
	
	public Die(JPanel mainPanel){
		
	}
	
	void changeLock(){
		locked = !locked;
	}
	
	int roll(){
		Random rng = new Random();
		int newNum = rng.nextInt();
		
		
		
		return newNum;
		
	}
	
}
