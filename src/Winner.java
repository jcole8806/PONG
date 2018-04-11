import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Winner extends JPanel {
	private static final long serialVersionUID = 1L;
	private int winnerNum;
	
	public Winner(int winnerNum){
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		
		JButton gameStart = new JButton("New Game");
		gameStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Pong.pongFrame.setContentPane(new MainGame());
				Pong.pongFrame.getContentPane().requestFocus();
			}
		});
		
		this.winnerNum = winnerNum;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("Player " + winnerNum + " wins!", Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Player " + winnerNum + " wins!")/2, Pong.screenSize.height/4);
	}
	
}
