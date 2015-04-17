package game;

import java.awt.Image;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Die extends JButton{
	int  value = 6;
	boolean locked = false;
	
	public Die(){
		setImage();
	}
	
	public void changeLock(){
		// flips whether this die is locked 
		locked = !locked;
	}
	
	public void  roll(){
		// selects random number
		Random rng = new Random();
		this.value = rng.nextInt();
		setImage();
	}
	
	public void setImage(){
		
		this.setIcon(new ImageIcon("/images/one.png"));
		
		/*switch(value){
			case 1: 
				try{
					Image img = ImageIO.read(getClass().getResource("images/one.png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
			case 2:
				try{
					Image img = ImageIO.read(getClass().getResource("images/two.png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
			case 3:
				try{
					Image img = ImageIO.read(getClass().getResource("images/three.png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
			case 4:
				try{
					Image img = ImageIO.read(getClass().getResource("images/four.png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
			case 5:
				try{
					Image img = ImageIO.read(getClass().getResource("images/five.png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
			case 6:
				try{
					Image img = ImageIO.read(getClass().getResource("images/six .png"));
					this.setIcon(new ImageIcon(img));
				} catch(IOException ex){}
		}*/
	}
	
}
