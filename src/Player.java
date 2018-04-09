import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player{
	
	private Paddle paddle;
	private int score = 0;
	
	public Player() {
		paddle = new Paddle(this);
	}
	
	public void movePaddle(int dir) {
		
	}
	
	int getScore(){
		return score;
	}
	
	
}
