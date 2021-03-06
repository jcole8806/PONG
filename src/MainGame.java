
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainGame extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private Timer timer = new Timer(10, this);
	private int ballDirection = -1, paddleDirection, ballXSpeed = 0, ballYVelocity = 0, paddleSpeed = 5, i = 0, player1Score = 0, player2Score = 0, paddle2Direction, powerPlayer;
	private boolean paddleMoving = false, tangible = true, twoHumans, paddle2Moving = false, powerUpActive = false;
	private Ball ball;
	private Paddle paddle, compPaddle;
	private Player human, comp;
	private Game game;
	private PowerUp power;
	private Rectangle range = new Rectangle(0, 0, 0, 0);
	public static boolean paused = false;
	private Color currentPower;
	private JButton exit = new JButton("Exit Game");
	
	public MainGame(boolean twoHumans) {
		if(!twoHumans) {
			game = new Game();
			comp = (ComputerPlayer) game.getPlayer2();
		} else {
			game = new Game(new Player(), new Player());
			comp = game.getPlayer2();
		}
		ball = game.getBall();
		human = game.getPlayer1();
		human.initPaddle(Paddle.LEFT);
		
		comp.initPaddle(Paddle.RIGHT);
		paddle = human.getPaddle();
		compPaddle = comp.getPaddle();
		this.twoHumans = twoHumans;
		power = new PowerUp();

		exit.setActionCommand(exit.getText());
		exit.addActionListener(this);
		exit.setVisible(false);
		add(exit);
		
		setLayout(null);
		setFocusable(true);
		setSize(Pong.screenSize);
		requestFocus();
		addKeyListener(this);
		setBackground(OptionsMenu.bgColor);
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		paddle.paint(g);
		compPaddle.paint(g);
		ball.paint(g);
		
		for(int i = 0; i <= 47; i++)
			g.fillRect(Pong.screenSize.width/2 - 5, 18 * i, 10, 12);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("" + player1Score, Pong.screenSize.width/4 - g.getFontMetrics().stringWidth("" + player1Score)/4, Pong.screenSize.height/10);
		g.drawString("" + player2Score, (Pong.screenSize.width*3)/4 - g.getFontMetrics().stringWidth("" + player2Score)/2, Pong.screenSize.height/10);
		
		if(paused) {
			g.drawString("Game Paused", Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Game Paused")/2, Pong.screenSize.height/2);
			exit.setBounds(Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Game Paused")/2, Pong.screenSize.height/2,  g.getFontMetrics().stringWidth("Game Paused"), 40);
			exit.setVisible(true);
		}
		power.paint(g);
		
		if(powerUpActive) {
			g.setColor(power.getColor());
			g.setFont(new Font("Comic Sans", 1, 40));
			if(powerPlayer == 1)
				g.drawString(powerString(), Pong.screenSize.width/4 - g.getFontMetrics().stringWidth(powerString())/2, 200);
			else
				g.drawString(powerString(), (Pong.screenSize.width*3)/4 - g.getFontMetrics().stringWidth(powerString())/2, 200);
		}
		
		
	}
	
	private String powerString() {
		if(currentPower == Color.RED)
			return "Ball Speed +";
		else if(currentPower == Color.YELLOW)
			return "Paddle Speed +";
		else if(currentPower == Color.BLUE)
			return "Ball Speed -";
		else if(currentPower == Color.GREEN)
			return "Paddle Size +";
		else if(currentPower == Color.ORANGE)
			return "Opponent Size -";
		return "";
	}
	
	private boolean hitPaddle() {
		if (ball.x < paddle.xPos + paddle.width - ballXSpeed || ball.x + ball.size > compPaddle.xPos)
			tangible = false;
		if(ball.y >= paddle.yPos - ball.size && ball.y <= paddle.yPos + paddle.size && tangible) {
			ballYVelocity = (ball.y + ball.size/2 - (paddle.yPos + paddle.size/2))/10;
			return true;
		}
		return false;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83) {
			paddleMoving = true;
			tangible = true;
			if(ballXSpeed == 0){
				//ballXSpeed = 5;
			}
			if(e.getKeyCode() == 87)
				paddleDirection = -1;
			else if(e.getKeyCode() == 83)
				paddleDirection = 1;
		}	else if(e.getKeyCode() == 32 && ballXSpeed == 0) {
				tangible = true;
				power.gameStart = true;
				ballXSpeed = 5;
		}
		
		if(twoHumans && (e.getKeyCode() == 38 || e.getKeyCode() == 40)) {
			paddle2Moving = true;
			if(ballXSpeed == 0) {
				//ballXSpeed = 5;
				tangible = true;
			}
			if(e.getKeyCode() == 38)
				paddle2Direction = -1;
			else if(e.getKeyCode() == 40)
				paddle2Direction = 1;
		}
		
		if(e.getKeyCode() == 80 && !paused) {
			timer.stop();
			paused = true;
		} else {
			exit.setVisible(false);
			timer.start();
			paused = false;
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83)
			paddleMoving = false;
		if(e.getKeyCode() == 38 || e.getKeyCode() == 40)
			paddle2Moving = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	private boolean powerUpHit() {
		range = new Rectangle(power.x - ballXSpeed, power.y - Math.abs(ballYVelocity), 20 + ballXSpeed * 2, 20 + Math.abs(ballYVelocity)*2);
		
		if(range.intersects(ball.getBounds())) {
			power.setLocation(-20, -20);
			return true;
		}
			
		return false;
	}
	
	private void gameOver() {
		if(player1Score == OptionsMenu.maxScore)
			Pong.pongFrame.setContentPane(new Winner(1, twoHumans));
		else if(player2Score == OptionsMenu.maxScore)
			Pong.pongFrame.setContentPane(new Winner(2, twoHumans));
		Pong.pongFrame.remove(this);
		player1Score = 0;
		player2Score = 0;
	}
	
	private void pointScored() {
		if(ball.x <= 0) {
			ball.setLocation(Pong.screenSize.width/4, Pong.screenSize.height/2);
			player2Score++;
		} else if(ball.x >= Pong.screenSize.width - 50) {
			ball.setLocation(Pong.screenSize.width*3/4, Pong.screenSize.height/2);
			player1Score++;
		}
		ballXSpeed = 0;
		ballYVelocity = 0;
		paddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
		compPaddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
		power.gameStart = false;
		clearEffects();
	}
	
	private void powerUp() {
		currentPower = power.getColor();
		if(ballDirection == 1)
			powerPlayer = 1;
		else
			powerPlayer = 2;
		
		if(power.getColor() == Color.RED) {
			ballXSpeed *= 2;
		} else if (power.getColor() == Color.YELLOW) {
			if(ballDirection == 1)
				paddleSpeed = 13;
		} else if (power.getColor() == Color.BLUE) {
			ballXSpeed *= .5;
		} else if (power.getColor() == Color.GREEN) {
			if(ballDirection == 1) {
				paddle.size = 200;
				paddle.setY(paddle.yPos - 50);
			} else {
				compPaddle.size = 200;
				compPaddle.setY(compPaddle.yPos - 50);
			}	
		} else if (power.getColor() == Color.ORANGE) {
			if(ballDirection == 1)
				compPaddle.size /= 2;
			else
				paddle.size /= 2;
		}
		powerUpActive = true;
	}
	
	private void clearEffects() {
		paddleSpeed = 5;
		paddle.size = 100;
		compPaddle.size = 100;
		powerUpActive = false;
		currentPower = null;
	}

	
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getActionCommand().equals("Exit Game"))
				System.exit(0);
		} catch (Exception ex) {}
		
		if(paddleMoving && ((paddleDirection == -1 && paddle.yPos > 10) ||(paddleDirection == 1 && paddle.yPos < Pong.screenSize.height - 158)))
			paddle.yPos = paddle.yPos + paddleSpeed*paddleDirection;
		
		if(paddle2Moving && ((paddle2Direction == -1 && compPaddle.yPos > 10) ||(paddle2Direction == 1 && compPaddle.yPos < Pong.screenSize.height - 158)) && twoHumans)
			compPaddle.yPos = compPaddle.yPos + paddleSpeed*paddle2Direction;
		
		if(((ball.x - (paddle.xPos + 20) <= 0) && hitPaddle()))
			ballDirection *= -1;
		else if ((ball.x > compPaddle.xPos && ball.y >= compPaddle.yPos - ball.size && ball.y <= compPaddle.yPos + compPaddle.size)) {
			ballYVelocity = (ball.y + ball.size/2 - (compPaddle.yPos + compPaddle.size/2))/10;
			ballDirection *= -1;
		}
		
		i++;
		
		if(i % 100 == 0 && ballXSpeed < 50 && ballXSpeed > 0)
			ballXSpeed++;

		ball.setLocation(ball.x + ballXSpeed*ballDirection, ball.y + ballYVelocity);
		
		if(ball.y <= 10 || ball.y >= Pong.screenSize.height - 75)
			ballYVelocity *= -1;
		
		if(ball.x <= 0 || ball.x >= Pong.screenSize.width - 50)
			pointScored();
		
		if(player1Score == OptionsMenu.maxScore || player2Score == OptionsMenu.maxScore)
			gameOver();
		
		if(powerUpHit())
			powerUp();
		
	}
		
}
