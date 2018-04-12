//TODO Make buttons look nice
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String[] optionTexts = {"Start Game", "Options", "Exit Game"};
	private JButton[] options = new JButton[optionTexts.length];
	
	public MainMenu() {
		setFocusable(true);
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
		g.drawString("PONG", Pong.screenSize.width/2 - 295/2, Pong.screenSize.height/4);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start Game"))
			Pong.pongFrame.setContentPane(new Instruction());
		else if(e.getActionCommand().equals("Options"))
			Pong.pongFrame.setContentPane(Pong.settings);
		else if(e.getActionCommand().equals("Exit Game"))
			System.exit(0);	
	}

}
