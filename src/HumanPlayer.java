import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HumanPlayer extends Player implements KeyListener{
	
	private int upID, downID;
	
	public HumanPlayer() {
		super();
		upID = OptionsMenu.settings.getPlayer1Up();
		downID = OptionsMenu.settings.getPlayer1Down();
	}
	
	public int getUpID() {
		return upID;
	}
	
	public int getDownID() {
		return downID;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
