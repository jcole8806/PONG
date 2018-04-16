import java.awt.Point;

/* I already have some ideas for the AI:
 * 	- Computer just moves up and down at a set pace until ball comes into contact with player's paddle
 * 	- Then, the computer begins trying to match its paddle's center with the ball
 * 	- How fast the computer's paddle moves depends on difficulty (easy, intermediate, hard)
 */


public class ComputerPlayer extends Player implements LocationListener{

	private Point previousLocation;

	public void locationChanged(LocationEvent event) {
		// this updates the paddle pos based on the location of ball
		//if(event.getY() > )
		int dir = 1;
		if(this.previousLocation != null){
			if(event.getY() <= 10 || event.getY() >= Pong.screenSize.height - 75){
				dir*=1;
			}
			
			int yChanged = (int) (event.getY() - this.previousLocation.getY());
			if(yChanged > 0){
				this.paddle.yPos+=2*dir;
			}else if(yChanged < 0){
				this.paddle.yPos-=2*dir;
			}
		}else{
			
		}
		
		
		
		
		this.previousLocation = new Point(event.getX(),event.getY());
		
		
	}
	
	
	
}
