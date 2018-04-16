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
		if(this.previousLocation != null){
			int yChanged = (int) (event.getY() - this.previousLocation.getY());
			if(yChanged > 0){
				this.paddle.yPos++;
			}else if(yChanged < 0){
				this.paddle.yPos--;
			}
		}
		//System.out.println("This reached");
		this.previousLocation = new Point(event.getX(),event.getY());
		
		
	}
	
	
	
}
