import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener {
	
	private Paddle paddle;
	private int score = 0;
	
	public Player() {
		paddle = new Paddle(this);
	}
	
	public void movePaddle() {
		
	}
	
	int getScore(){
		return score;
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
