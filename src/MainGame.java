//TODO Add powerups
//TODO Modify angle of deflection for ball to make game more fun
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
//test
public class MainGame extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private Timer timer = new Timer(10, this);
	private int ballDirection = -1, paddleDirection, ballXSpeed = 0, ballYVelocity = 0, paddleSpeed = 5, i = 0, player1Score = 0, player2Score = 0, paddle2Direction;
	private boolean paddleMoving = false, tangible = true, twoHumans, paddle2Moving = false;
	private Ball ball;
	private Paddle paddle, compPaddle;
	private HumanPlayer human;
	private Player comp;
	private Game game;
	private PowerUp power;
	
	public MainGame(boolean twoHumans) {
		if(!twoHumans) {
			game = new Game();
			comp = (ComputerPlayer) game.getPlayer2();
		} else {
			game = new Game(new HumanPlayer(), new HumanPlayer());
			comp = (HumanPlayer) game.getPlayer2();
		}
		ball = game.getBall();
		human = (HumanPlayer) game.getPlayer1();
		human.initPaddle(Paddle.LEFT);
		
		comp.initPaddle(Paddle.RIGHT);
		paddle = human.getPaddle();
		compPaddle = comp.getPaddle();
		this.twoHumans = twoHumans;
		power = new PowerUp();
		
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
		
		power.paint(g);
	}
	
	private boolean hitPaddle() {
		if (ball.x < paddle.xPos + paddle.width - ballXSpeed || ball.x > compPaddle.xPos + compPaddle.width + ballXSpeed)
			tangible = false;
		if(ball.y >= paddle.yPos - ball.size && ball.y <= paddle.yPos + paddle.size && tangible) {
			ballYVelocity = (ball.y - (paddle.yPos + paddle.size/2))/10;
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
				ballXSpeed = 5;
		}
		
		if(twoHumans && (e.getKeyCode() == 38 || e.getKeyCode() == 40)) {
			paddle2Moving = true;
			if(ballXSpeed == 0)
				ballXSpeed = 5;
			if(e.getKeyCode() == 38)
				paddle2Direction = -1;
			else if(e.getKeyCode() == 40)
				paddle2Direction = 1;
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
	
	private void playSound() {
		   try {
		    	  File soundFile = new File("audio/blip.wav");
		    	  AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
		    	  Clip clip = AudioSystem.getClip();
		    	  clip.open(audioIn);
		    	  clip.start();
		      } catch (Exception e) {}
	   }

	
	public void actionPerformed(ActionEvent e) {
		if(paddleMoving && ((paddleDirection == -1 && paddle.yPos > 10) ||(paddleDirection == 1 && paddle.yPos < Pong.screenSize.height - 158)))
			paddle.yPos = paddle.yPos + paddleSpeed*paddleDirection;
		if(paddle2Moving && ((paddle2Direction == -1 && compPaddle.yPos > 10) ||(paddle2Direction == 1 && compPaddle.yPos < Pong.screenSize.height - 158)) && twoHumans)
			compPaddle.yPos = compPaddle.yPos + paddleSpeed*paddle2Direction;
		
		if((ball.x - (paddle.xPos + 20) <= 0) && hitPaddle()){
			ballDirection *= -1;
			playSound();
		}else if(ball.x > compPaddle.xPos && ball.y >= compPaddle.yPos - ball.size && ball.y <= compPaddle.yPos + compPaddle.size){
			ballDirection *= -1;
			playSound();
		}
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
			paddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
			compPaddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
		} else if(ball.x >= Pong.screenSize.width) {
			ball.setLocation(Pong.screenSize.width*3/4, Pong.screenSize.height/2);
			ballXSpeed = 0;
			ballYVelocity = 0;
			player1Score++;
			paddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
			compPaddle.setY(Pong.screenSize.height/2 - compPaddle.size/2);
		}
		
		if(player1Score == 11 || player2Score == 11) {
			if(player1Score == 11)
				Pong.pongFrame.setContentPane(new Winner(1, twoHumans));
			else if(player2Score == 11)
				Pong.pongFrame.setContentPane(new Winner(2, twoHumans));
			Pong.pongFrame.remove(this);
			player1Score = 0;
			player2Score = 0;
		}
	}
	
	
}
