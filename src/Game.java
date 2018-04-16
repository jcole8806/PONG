import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game implements ActionListener{
	private int gamesWon = 0;
	Player player1, player2;
	private Timer timer = new Timer(10,this);
	private Ball ball;
	
	private Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.ball = new Ball(this);
		
	}
	
	public Game(){
		this(new HumanPlayer(), new ComputerPlayer());
		ComputerPlayer compPlayer = (ComputerPlayer) this.player2;
		this.ball.addListener(compPlayer);
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
	
	public void start(){
		//starts the timer whenever this method is called instead f everytime a new game is made
		timer.start();
	}

	public void actionPerformed(ActionEvent arg0) {
		if(gameOver()){
			//replaces game screen with winner screen
		}
		
	}

	public Player getPlayer1() {
		return player1;
	}

//	public void setPlayer1(Player player1) {
//		this.player1 = player1;
//	}

	public Player getPlayer2() {
		return player2;
	}

//	public void setPlayer2(Player player2) {
//		this.player2 = player2;
//	}

	public Ball getBall() {
		return ball;
	}

//	public void setBall(Ball ball) {
//		this.ball = ball;
//	}
	
}
