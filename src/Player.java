import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player{
	
	protected Paddle paddle;
	private int score = 0;
	
	public Player() {
		
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

	public Paddle getPaddle() {
		return paddle;
	}
	
	public void initPaddle(int side){
		paddle = new Paddle(side);
	}
}
