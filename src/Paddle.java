import java.awt.Color;
import java.awt.Graphics;

public class Paddle {
	int width;
	private int gameHeight;
	private int gameWidth;
	int size;
	int yPos;
	int xPos;
	private Color paddleCol = Color.white;
	private int side;
	public static int LEFT = 0, RIGHT = 1;
	
	
	public Paddle(int side) {
		this.side = side;
		initSizeVar();
		
	}
	
	private void initSizeVar() {
		gameHeight = Pong.screenSize.height;
		gameWidth = Pong.screenSize.width;
		yPos = gameHeight/2 - 50;
		width = 20;
		size = 100;
		if(side == LEFT){
			xPos =  100; 
		}else if(side == RIGHT){
			xPos = gameWidth-100;
		}
		
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
		g.fillRect(xPos, yPos, width, size);
	}
	
	
	
}
