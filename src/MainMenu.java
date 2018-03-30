import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	public MainMenu() {
		setLayout(null);
		setBackground(Color.WHITE);
		setSize(Pong.screenSize);
		
		JLabel title = new JLabel("PONG");
		JButton start = new JButton("Start Game");
		start.addActionListener(this);
		start.setActionCommand(start.getText());
		
		title.setSize(400, 400);
		title.setLocation((int)Pong.screenSize.width/2 - title.getWidth()/2, 0);
		title.setFont(new Font("Arail", 1, 100));
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start Game")) {
			Pong.pongFrame.add(new MainGame());
			Pong.pongFrame.remove(0);
		}
			
	}

}
