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

/** A representation of a die in 2d space with modifiable components
 *
 * @class Die.java
 * @authors Victoria Garcia, Brian Rosfelder
 * @date 04/26/2015
 * 
 */
public class Die extends JButton{
	//initiate values
	private int  value;
	boolean locked = false;
	// list of available images
	private List<String> diceImages = Arrays.asList(
			"/one.png", "/two.png", "/three.png", "/four.png", "/five.png", "/six.png");
	private List<String> diceInactive = Arrays.asList(
			"/die1.png", "/die2.png", "/die3.png", "/die4.png", "/die5.png", "/die6.png");
	
	/** 
	* constructor 
	*/
	public Die(){
		//create die
		this.setSelected(true);
	    this.setBorderPainted(false); 
	    this.setContentAreaFilled(false); 
	    this.setFocusPainted(false); 
	    this.setOpaque(false);
		this.setValue(6);
		this.setEnabled(false);
		
	}
	
	/** changes the availability of the die
     */
	public void changeLock(){
		// flips to opposite 
		locked = !locked;
		this.setSelected(locked);
		//deactivated image
		if (locked){
			this.setInactive();
		}
		//activated image
		else{
			this.setImage();
		}
		
	}
	
	/** returns the current value of the die
	 * @return current value of the die
     */
	int getValue(){
		return value;
	}
	
	/** changes the value of the die
	 * @param new value of die
     */
	void setValue(int amount){
		value = amount;
		this.setImage();
	}
	
	/** changes the icon of the die to deactivated version
     */
	private void setInactive(){
		this.setIcon(new ImageIcon(getClass().getResource(diceImages.get(value-1))));	
	}
	
	/** changes the icon of the die to activated version
     */
	private void setImage(){	
		this.setIcon(new ImageIcon(getClass().getResource(diceInactive.get(value-1))));
	}
	
	/** changes value of die to a random number
     */
	void rollDie(){
		if(!locked){
			setValue(getRandom());
		}
	}
	
	/** returns a random number
	 * @return random number between 1 and 6
     */
	private int getRandom(){
		Random rand = new Random();
		//generate random number
		int n = rand.nextInt(6) + 1;
		return n;
	}
	
}
