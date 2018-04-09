import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	private int width, gameHeight, gameWidth, size;
	private int yPos, xPos;
	private Color paddleCol = Color.white;
	
	
	public Paddle(Player player) {
		
	}
	
	public int getSize(){
		return size;
	}
	
	public void move(int change){
		int newPos = yPos + change;
		newPos = Math.max(0, newPos);
		newPos = Math.min(gameHeight - size, newPos);
		this.yPos = newPos;
	}
	
	public void paint(Graphics g){
		g.setColor(paddleCol);
		
	}

}
