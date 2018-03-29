import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public MainMenu() {
		setLayout(null);
		setBackground(Color.WHITE);
		JLabel title = new JLabel("PONG");
		title.setSize(400, 400);
		title.setLocation((int)Pong.screenSize.width/2 - title.getWidth()/2, 0);
		title.setFont(new Font("Arail", 1, 100));
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title);
	}

}
