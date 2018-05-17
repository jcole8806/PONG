
public class Player{
	
	protected Paddle paddle;
	private int score = 0;
	
	public void movePaddle(int dir) {
		if(dir >= 1)
			paddle.move(dir);
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
