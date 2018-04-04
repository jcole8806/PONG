
public class HumanPlayer extends Player{
	
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

}
