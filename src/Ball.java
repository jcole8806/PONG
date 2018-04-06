import java.awt.Graphics;
import java.awt.Rectangle;


public class Ball {
    private static final int WIDTH = 30, HEIGHT = 30;
    private Game game;
    private int x, y, xDirection = 2, yDirection = 2;

    public Ball(Game game) {
        this.game = game;
        x = 800;
        y = 400;
    }

    public void update() {
    	updateLocation();
    	checkCollisionWithTopOrBottom();
        checkVictoryConditions();
        checkCollisionWithPaddles();
    }
    
    private void checkCollisionWithPaddles() {
		
	}

	private void checkVictoryConditions() {
		if(game.player1.getScore() == 3){
			Winner player1Winner = new Winner(game.player1);
		}else if(game.player2.getScore() == 3){
			Winner player2Winner = new Winner(game.player2);
		}
	}

	private void checkCollisionWithTopOrBottom() {
		if(hasHitTopOrBottom()){
			y+= -yDirection;
		}
	}

	private void updateLocation() {
		x += xDirection;
		y += yDirection;
	}

	private boolean hasHitTopOrBottom() {
        return y < 0 || y > Pong.screenSize.getHeight();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void paint(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}