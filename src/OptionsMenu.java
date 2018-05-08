//TODO Add option to change control configuration
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsMenu extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	private int player1Up = 87, player1Down = 83, player2Up = 38, player2Down = 40;
	private String[] buttonTexts = {"Set Player 1 Up", "Set Player 1 Down", "Set Player 2 Up", "Set Player 2 Down", "Go Back"};
	private JButton[] buttons = new JButton[buttonTexts.length];
	
	public OptionsMenu() {
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		setBorder(BorderFactory.createLineBorder(Color.WHITE, 10));
		
		for(int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonTexts[i]);
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(buttons[i].getText());
			add(buttons[i]);
		}
		
		for(int i = 0; i < 4; i++)
			buttons[i].setBounds(Pong.screenSize.width/2 - 200 + 200*(i/2), Pong.screenSize.height/2 + 50*(i%2), 200, 40);
		
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		back.setActionCommand(back.getText());
		back.setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2 + 50*2, 400, 40);
		add(back);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("Options", Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Options")/2, Pong.screenSize.height/4);
	}
	
	public int getPlayer1Up() {
		return player1Up;
	}
	
	public int getPlayer1Down() {
		return player1Down;
	}
	
	public int getPlayer2Up() {
		return player2Up;
	}
	
	public int getPlayer2Down() {
		return player2Down;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Go Back"))
			Pong.pongFrame.setContentPane(new MainMenu());
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
