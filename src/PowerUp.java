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
import java.awt.Rectangle;
import java.util.Random;

public class PowerUp extends Rectangle{
	private static final long serialVersionUID = 1L;
	private Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};
	private Color color;
	
	public PowerUp() {
		Random rand = new Random();
		color = colors[rand.nextInt(colors.length) + 0];
	}
	
	public Color getColor() {
		return color;
	}

}
