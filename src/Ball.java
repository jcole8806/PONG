import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class Ball {
    //private static final int WIDTH = 30, HEIGHT = 30;
    private Game game;
    private int x, y, size, xDirection = 2, yDirection = 2;
    private Color ballColor;
    private List<LocationListener> locationListeners = new ArrayList<LocationListener>();
    
    public Ball(Game game) {
        this.game = game;
        ballColor = Color.white;
        x = 800;
        y = 400;
    }

    public void update() {
    	updateLocation();
    	checkCollisionWithTopOrBottom();
        checkCollisionWithPaddles();
    }
    
    private void checkCollisionWithPaddles() {
		
	}

	private void checkCollisionWithTopOrBottom() {
		if(hasHitTopOrBottom()){
			y+= -yDirection;
		}
	}

	private void updateLocation() {
		x += xDirection;
		y += yDirection;
		for (LocationListener listener : locationListeners)
			listener.locationChanged(new LocationEvent(x, y));
	}

	private boolean hasHitTopOrBottom() {
        return y < 0 || y > Pong.screenSize.getHeight();
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, size, size);
    }
    
    public void addListener(LocationListener toAdd) {
        locationListeners.add(toAdd);
    }

    public void paint(Graphics g) {
    	g.setColor(ballColor);
        g.fillRect(x, y, size, size);
    }
}