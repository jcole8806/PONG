import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Instruction extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public Instruction() {
		setBackground(Color.RED);
		setSize(Pong.screenSize);
		JLabel instructions = new JLabel("Instructions: Use the up and down arrow keys on the keyboard"
				+ " to move your paddle. The objective of the game is to block the ball from passing off "
				+ "the screen from your side, and instead trying to get the ball to pass off the screen"
				+ "from the other side.");
		
		add(instructions);
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}

}
