//TODO Arrange buttons in the center of screen (done using setLayout(null) and setBounds(x, y, width, height))
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
	private String[] optionTexts = {"Start Game", "Options", "Instructions", "Exit Game"};
	private JButton[] options = new JButton[optionTexts.length];
	//private Game game = new Game();
	
	public MainMenu() {
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		
		for(int i = 0; i < options.length; i++) {
			options[i] = new JButton(optionTexts[i]);
			options[i].setActionCommand(options[i].getText());
			options[i].addActionListener(this);
			add(options[i]);
		}
		//JPanel buttonPanel = new JPanel();
		//buttonPanel.setBounds(0, 800, 800, 800);
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("PONG", Pong.screenSize.width/2, Pong.screenSize.height/10);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Start Game")) {
			//Pong.pongFrame.setContentPane(new MainGame());
		} else if(e.getActionCommand().equals("Options")) {
			Pong.pongFrame.setContentPane(new OptionsMenu());
		} else if(e.getActionCommand().equals("Instructions")) {
			Pong.pongFrame.setContentPane(new Instruction());
		} else if(e.getActionCommand().equals("Exit Game")) {
			System.exit(0);
		}
			
	}

}
