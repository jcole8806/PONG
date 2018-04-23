/*
 * How PowerUp fill work:
 * It will be a square the same size as the ball
 * It will have a color randomly chosen
 * The effect will depend on what color it is
 * It will appear every so often, and disappear soon after appearing
 * When the powerup is hit by the ball, the powerup will be applied to the player that hit it there
 * The powerup only lasts a small amount of time
 */

//TODO select random position
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class PowerUp extends Rectangle implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
	private Timer timer = new Timer(10,this);
	private Color color;
	private int size, x, y;
	
	public PowerUp() {
		Random rand = new Random();
		color = colors[rand.nextInt(colors.length) + 0];
		size = 20;
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public void paint(Graphics g) {
	   	g.setColor(color);
	    g.fillRect(x, y, size, size);
	}
	
	public void randLocation(){
		x = (int) Math.random();
		y = (int) Math.random();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
	

}
