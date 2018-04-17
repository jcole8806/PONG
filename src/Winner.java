import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Winner extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private int winnerNum;
	private String[] optionTexts = {"New Game", "Main Menu", "Exit Game"};
	private JButton[] options = new JButton[optionTexts.length];
	
	public Winner(int winnerNum){
		this.winnerNum = winnerNum;
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		
		for(int i = 0; i < options.length; i++) {
			options[i] = new JButton(optionTexts[i]);
			options[i].setActionCommand(options[i].getText());
			options[i].addActionListener(this);
			options[i].setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2 + 50*i, 400, 40);
			add(options[i]);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("Player " + winnerNum + " wins!", Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Player " + winnerNum + " wins!")/2, Pong.screenSize.height/4);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Game")) {
			Pong.pongFrame.setContentPane(new MainGame());
			Pong.pongFrame.getContentPane().requestFocus();
		} else if(e.getActionCommand().equals("Main Menu"))
			Pong.pongFrame.setContentPane(new MainMenu());
		else if(e.getActionCommand().equals("Exit Game"))
			System.exit(0);
	}
	
}
