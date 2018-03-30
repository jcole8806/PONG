import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenu extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton[] options = new JButton[3];
	private String[] optionTexts = {"Start Game", "Options", "Instructions"};
	
	public MainMenu() {
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		
		for(int i = 0; i < options.length; i++) {
			options[i] = new JButton(optionTexts[i]);
			options[i].setActionCommand(options[i].getText());
			options[i].addActionListener(this);
			add(options[i]);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawString("PONG", Pong.screenSize.width/2, Pong.screenSize.height/10);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start Game")) {
			Pong.pongFrame.setContentPane(new MainGame());
		} else if(e.getActionCommand().equals("Options")) {
			Pong.pongFrame.setContentPane(new OptionsMenu());
		} else if(e.getActionCommand().equals("Instructions")) {
			Pong.pongFrame.setContentPane(new Instruction());
		}
			
	}

}
