
public class Game{
	Player player1, player2;
	private Ball ball;
	
	public Game(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.ball = new Ball(this);
	}
	
	public Game(){
		this(new Player(), new ComputerPlayer());
		ComputerPlayer compPlayer = (ComputerPlayer) this.player2;
		this.ball.addListener(compPlayer);
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Ball getBall() {
		return ball;
	}
	
}
