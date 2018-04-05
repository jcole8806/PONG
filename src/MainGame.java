import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGame extends JPanel implements ActionListener, KeyListener{
	private static final long serialVersionUID = 1L;
	private Game game;
	
	public MainGame(Game game) {
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		add(new JLabel("Main Game goes here"));
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		updateGraphics(g);
	}
	
	private void updateGraphics(Graphics g) {
		
	}
	
	public Game getGame() {
		return game;
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}

	public void keyPressed(KeyEvent e) {
		//if(e.getKeyCode() == KeyEvent.){
			
		//}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
