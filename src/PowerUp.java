/*
 * How PowerUp fill work:
 * It will be a square the same size as the ball
 * It will have a color randomly chosen
 * The effect will depend on what color it is
 * It will appear every so often, and disappear soon after appearing
 * When the powerup is hit by the ball, the powerup will be applied to the player that hit it there
 * The powerup only lasts a small amount of time
 */

//TODO Add effects for powerups
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

public class PowerUp extends Rectangle implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.ORANGE};
	private Timer timer = new Timer(10,this);
	private Color color;
	private int size = 20, i = 0;
	private Random rand = new Random();
	public boolean gameStart;
	
	public PowerUp() {
		setRand();
		//if(gameStart){
			timer.start();
		//}
		
	}
	
	public Color getColor() {
		return color;
	}
	
	public void paint(Graphics g) {
	   	g.setColor(color);
	    g.fillRect(x, y, size, size);
	}
	
	public void setRand() {
		if(i % 1000 == 0)
			this.setLocation(100 + (int) (Math.random() * (Pong.screenSize.width - 20)), 100 + (int) (Math.random() * (Pong.screenSize.height - 20)));
		color = colors[rand.nextInt(colors.length)];
	}
	
	public void actionPerformed(ActionEvent arg0) {
		i++;
		setRand();
		if(color != null){
			if(color == Color.RED){
				
			}else if(color == Color.YELLOW){
				
			}else if(color == Color.BLUE){
				
			}else if(color == Color.GREEN){
				
			}
		}
	}
	
	

}
