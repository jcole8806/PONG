import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player{
	
	private Paddle paddle;
	private int score = 0;
	
	public Player() {
		paddle = new Paddle(this);
	}
	
	public void movePaddle(int dir) {
		if(dir >= 1){
			paddle.move(dir);
		}else if(dir <= 0){
			
		}
	}
	
	int getScore(){
		return score;
	}
	
	
}
