//TODO Add collision detection/AI to second paddle
//TODO Add powerups
//TODO Add two player functionality

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MainGame extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	//private Rectangle ball = new Rectangle();
	private Timer timer = new Timer(10, this);
	private int ballDirection = -1, paddleDirection, ballXSpeed = 0, ballYVelocity = 0, paddleSpeed = 5, i = 0, player1Score = 0, player2Score = 0;
	private boolean paddleMoving = false, tangible = true;
	private Ball ball;
	private Paddle paddle, compPaddle;
	private HumanPlayer human;
	private ComputerPlayer comp;
	private Game game;
	
	public MainGame() {
		game = new Game();
		ball = game.getBall();
		human = (HumanPlayer) game.getPlayer1();
		human.initPaddle(Paddle.LEFT);
		comp = (ComputerPlayer) game.getPlayer2();
		comp.initPaddle(Paddle.RIGHT);
		paddle = human.getPaddle();
		compPaddle = comp.getPaddle();
		
		setFocusable(true);
		setSize(Pong.screenSize);
		requestFocus();
		addKeyListener(this);
		setBackground(Color.BLACK);
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
		
	}
	
	private boolean hitPaddle() {
		if (ball.x < paddle.xPos + paddle.width - ballXSpeed || ball.x > compPaddle.xPos + compPaddle.width + ballXSpeed)
			tangible = false;
		if(ball.y >= paddle.yPos - ball.size && ball.y <= paddle.yPos + paddle.size && tangible) {
			ballYVelocity = (ball.y - (paddle.yPos + paddle.size/2))/20;
			return true;
		}
		return false;
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83) {
			paddleMoving = true;
			if(e.getKeyCode() == 87)
				paddleDirection = -1;
			else if(e.getKeyCode() == 83)
				paddleDirection = 1;
		}	else if(e.getKeyCode() == 32 && ballXSpeed == 0) {
				tangible = true;
				ballXSpeed = 5;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == 87 || e.getKeyCode() == 83)
			paddleMoving = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(paddleMoving && ((paddleDirection == -1 && paddle.yPos > 10) ||(paddleDirection == 1 && paddle.yPos < Pong.screenSize.height - 75)))
			paddle.yPos = paddle.yPos + paddleSpeed*paddleDirection;
		if((ball.x - (paddle.xPos + 20) <= 0) && hitPaddle())
			ballDirection *= -1;
		else if(ball.x > compPaddle.xPos && ball.y >= compPaddle.yPos - ball.size && ball.y <= compPaddle.yPos + compPaddle.size)
				ballDirection *= -1;
		
		i++;
		if(i % 100 == 0 && ballXSpeed < 100 && ballXSpeed > 0)
			ballXSpeed++;

		ball.setLocation(ball.x + ballXSpeed*ballDirection, ball.y + ballYVelocity);
		
		if(ball.y <= 10 || ball.y >= Pong.screenSize.height - 75)
			ballYVelocity*= -1;
		
		if(ball.x <= 0) {
			ball.setLocation(Pong.screenSize.width/4, Pong.screenSize.height/2);
			ballXSpeed = 0;
			ballYVelocity = 0;
			player2Score++;
		} else if(ball.x >= Pong.screenSize.width) {
			ball.setLocation(Pong.screenSize.width*3/4, Pong.screenSize.height/2);
			ballXSpeed = 0;
			ballYVelocity = 0;
			player1Score++;
		}
		
		if(player1Score == 11 || player2Score == 11) {
			if(player1Score == 11)
				Pong.pongFrame.setContentPane(new Winner(1));
			else if(player2Score == 11)
				Pong.pongFrame.setContentPane(new Winner(2));
			Pong.pongFrame.remove(this);
			player1Score = 0;
			player2Score = 0;
		}
	}
	
}
