//TODO Add option to change control configuration
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class OptionsMenu extends JPanel implements ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	
	public OptionsMenu() {
		setLayout(null);
		setBackground(Color.BLACK);
		setSize(Pong.screenSize);
		
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
