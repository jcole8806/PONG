import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

import javax.swing.*;

public class PongTest {
	
	private static JFrame frame;
	private static java.util.Timer t = new java.util.Timer();
	
	public PongTest() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame = new JFrame("PONG");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setContentPane(new GamePanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private class GamePanel extends JPanel implements KeyListener, ActionListener{
		//need to add second paddle, make variable for speed (both ball and paddle), etc.
		private static final long serialVersionUID = 1L;
		private Rectangle paddle = new Rectangle(), ball = new Rectangle();
		private Timer timer = new Timer(10, this);
		private int direction = -1;

		public GamePanel() {
			setFocusable(true);
			requestFocus();
			addKeyListener(this);
			setBackground(Color.BLACK);
			setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
			paddle.setBounds(100, 100, 20, 100);
			ball.setBounds(300, 300, 20, 20);
			timer.start();
		}
		
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.WHITE);
			g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
			g.fillRect(ball.x, ball.y, ball.width, ball.height);
		}

		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 38 && paddle.y > 10)
				paddle.setLocation(paddle.x, paddle.y - 5);
			else if(e.getKeyCode() == 40 && paddle.y < 1054) 
				paddle.setLocation(paddle.x, paddle.y + 5);
		}

		public void keyReleased(KeyEvent e) {
			
		}

		public void keyTyped(KeyEvent e) {
			
		}

		public void actionPerformed(ActionEvent e) {
			// need to check y, figure that out
			if(ball.getLocation().x - (paddle.x + 20) <= 0)
				direction *= -1;
			
			ball.setLocation(ball.x + 5*direction, ball.y);
		}
		
	}

	public static void main(String[] args) {
		new PongTest();

		t.schedule(new TimerTask(){
			public void run() {
				frame.repaint();
			}
		}, 0,10);
	}

}
