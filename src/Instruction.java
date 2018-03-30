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
		add(new JLabel("Instruction goes here"));
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		add(back);
	}

	public void actionPerformed(ActionEvent e) {
		Pong.pongFrame.setContentPane(new MainMenu());
	}

}
