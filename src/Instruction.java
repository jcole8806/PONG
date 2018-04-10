import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instruction extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public Instruction() {
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		JLabel instructions = new JLabel("Instructions: Use the up and down arrow keys on the keyboard"
				+ " to move your paddle. The objective of the game is to block the ball from passing off "
				+ "the screen from your side, and instead trying to get the ball to pass off the screen"
				+ "from the other side.");
		instructions.setFont(instructions.getFont().deriveFont(20.0f));
		instructions.setForeground(Color.white);
		
		add(instructions);
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
		
		JButton gameStart = new JButton("Start Game");
		gameStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Pong.pongFrame.setContentPane(new MainGame());
				Pong.pongFrame.getContentPane().requestFocus();
			}
		});
		add(gameStart);
	}
	
	/*
	public void paint(Graphics g){
		super.paint(g);
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		g.setColor(Color.white);
		g.drawString("Instruct!", Pong.screenSize.width/2, Pong.screenSize.height/2);
		g.setFont(this.getFont().deriveFont(20.0f));
	}
	*/

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}

}
