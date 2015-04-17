package game;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Die extends JButton{
	private int  value = 6;
	boolean locked = false;
	
	public Die(){
		this.setSelected(true);
	    this.setBorderPainted(true); 
	    this.setContentAreaFilled(false); 
	    this.setFocusPainted(false); 
	    this.setOpaque(false);
		this.setValue(value);
		
	}
	
	public void changeLock(){
		// flips whether this die is locked 
		locked = !locked;
		this.setSelected(locked);
		if (locked){
			this.setInactive();
		}
		else{
			this.setImage();
		}
		
	}
	
	int getValue(){
		return value;
	}
	
	void setValue(int amount){
		value = amount;
		this.setImage();
	}
	
	
	private void setInactive(){
		
		List<String> diceImages = Arrays.asList("Dice/one.png", "Dice/two.png", "Dice/three.png", "Dice/four.png", "Dice/five.png", "Dice/six.png");
		this.setIcon(new ImageIcon(diceImages.get(value-1)));
		
	}
	
	private void setImage(){
		
		List<String> diceInactive = Arrays.asList("Dice/die1.png", "Dice/die2.png", "Dice/die3.png", "Dice/die4.png", "Dice/die5.png", "Dice/die6.png");
		this.setIcon(new ImageIcon(diceInactive.get(value-1)));
	}
	
	void rollDie(){
		if(!locked){
			setValue(getRandom());
		}
	}
	
	private int getRandom(){
		Random rand = new Random();
		int n = rand.nextInt(6) + 1;
		return n;
	}
	
}
