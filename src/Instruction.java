import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Instruction extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public Instruction(final boolean twoPlayers) {
		setLayout(null);
		setBackground(OptionsMenu.bgColor);
		new Dimension(Pong.screenSize.width - 10, Pong.screenSize.height - 10);
		setLayout(new BorderLayout());
		JTextArea instructions = new JTextArea(	" Instructions: Use the W and S keys on the keyboard"
				+ " to move your paddle. \n The objective of the game is to block the ball from passing off "
				+ "the screen from your side, and instead trying to get the ball to pass off the screen "
				+ " from the other side which would either be the second player or the computer player's side." + " Press P to pause the game.");
		JLabel controls2;
		if(twoPlayers) {
			controls2 = new JLabel("Player 2 Controls: Up and Down Arrow Keys");
			controls2.setBounds(500, 500, 300, 300);
		}	
		instructions.setEditable(false);
		instructions.setFocusable(false);
		instructions.setWrapStyleWord(true);
		instructions.setLineWrap(true);
		instructions.setFont(instructions.getFont().deriveFont(25.0f));
		instructions.setForeground(Color.WHITE);
		instructions.setBackground(OptionsMenu.bgColor);
		
		
		add(instructions, BorderLayout.NORTH);
		JPanel buttons = new JPanel();
		buttons.setBackground(OptionsMenu.bgColor);
		
		JButton back = new JButton("Go Back");
		
		back.addActionListener(this);
		buttons.add(back);
		
		JButton gameStart = new JButton("Start Game");
		gameStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Pong.pongFrame.setContentPane(new MainGame(twoPlayers));
				Pong.pongFrame.getContentPane().requestFocus();
			}
		});
		buttons.add(gameStart);
		add(buttons, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}

}
