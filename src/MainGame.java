import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainGame extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	public MainGame() {
		setBackground(Color.BLUE);
		setSize(Pong.screenSize);
		add(new JLabel("Main Game goes here"));
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}
}
