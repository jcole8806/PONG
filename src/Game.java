import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game extends JPanel implements ActionListener{
	private int gamesWon = 0;
	Player player1, player2;
	private Timer timer = new Timer(10,this);
	
	public Game(Player player1, Player player2) {
		setFocusable(true);
		requestFocus();
		this.player1 = player1;
		this.player2 = player2;
		setBackground(Color.BLACK);
		timer.start();
	}
	
	public void roundWon(){
		//checks to see who won the round and then adds a point to their score
		//if(){
			gamesWon++;
		//}
	}
	
	private boolean gameOver(){
		//if a player had 3 games won, then the game is over and that player wins
		if(gamesWon == 3){
			return true;
		}
		return false;
	}
	
	

	public void actionPerformed(ActionEvent arg0) {
		if(gameOver()){
			//replaces game screen with winner screen
		}
		
	}
	
}
