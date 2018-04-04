// Add option to change control configuration

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OptionsMenu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	public static OptionsMenu settings;
	
	public OptionsMenu() {
		settings = this;
		setBackground(Color.GREEN);
		setSize(Pong.screenSize);
		add(new JLabel("Options Menu goes here"));
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}
	
	public int getPlayer1Up() {
		return 38;
	}
	
	public int getPlayer2Up() {
		return 87;
	}
	
	public int getPlayer1Down() {
		return 40;
	}
	
	public int getPlayer2Down() {
		return 83;
	}

}
