//TODO Add option to change control configuration
//TODO Add Option to customize background / paddle color
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
	private String[] buttonTexts = {"Power Ups: On", "Max Score: 11", "Up", "Down", "Go Back"};
	private JButton[] buttons = new JButton[buttonTexts.length];
	public static boolean powerUps = true;
	public static int maxScore = 11;
	
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
		
		buttons[0].setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2, 400, 40);
		buttons[1].setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2 + 50, 200, 40);
		buttons[2].setBounds(buttons[1].getX() + 200, Pong.screenSize.height/2 + 50, 100, 40);
		buttons[3].setBounds(buttons[2].getX() + 100, Pong.screenSize.height/2 + 50, 100, 40);
		
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
		else if(e.getActionCommand().equals("Power Ups: On")) {
			powerUps = !powerUps;
			if(powerUps)
				buttons[0].setText("Power Ups: On");
			else
				buttons[0].setText("Power Ups: Off");
		} else if(e.getActionCommand().equals("Up")) {
			if(maxScore < 99)
				maxScore ++;
			buttons[1].setText("Max Score: " + maxScore);
		} else if(e.getActionCommand().equals("Down")) {
			if(maxScore > 1)
				maxScore--;
			buttons[1].setText("Max Score: " + maxScore);
		}
			
		
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
