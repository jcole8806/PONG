import java.awt.*;

public class ComputerPlayer extends Player implements LocationListener{

	private Point previousLocation;

	public void locationChanged(LocationEvent event) {
		int dir = 1;
		if(this.previousLocation != null){
			if(event.getY() <= 10 || event.getY() >= Pong.screenSize.height - 75);
				dir*=1;

			int yChanged = (int) (event.getY() - this.previousLocation.getY());
			if(yChanged > 0 && this.paddle.yPos + this.paddle.size < Pong.screenSize.height - 75)
				this.paddle.yPos+=1*dir;
			else if(yChanged < 0 && this.paddle.yPos > 0)
				this.paddle.yPos-=1*dir;
			
			if(event.getY() > this.getPaddle().yPos){
				this.paddle.yPos+=2;
			}else if(event.getY() < this.getPaddle().yPos){
				this.paddle.yPos-=2;
			}
			
		}
		
		
		
		this.previousLocation = new Point(event.getX(),event.getY());
	}
	
}
