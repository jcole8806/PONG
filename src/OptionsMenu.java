//TODO Add Option to customize background / paddle color
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class OptionsMenu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private String[] buttonTexts = {"Power Ups: On", "Max Score: 11", "Up", "Down", "Go Back", "Background Color:"}, colorTexts = {"Black", "Blue", "Green", "Red"};
	private JButton[] buttons = new JButton[buttonTexts.length];
	public static boolean powerUps = true;
	public static int maxScore = 11;
	private JComboBox<String> backgroundColor = new JComboBox<String>();
	public static Color bgColor = Color.BLACK;
	
	public OptionsMenu() {
		setLayout(null);
		setBackground(bgColor);
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
		buttons[5].setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2 + 50*2, 200, 40);
		
		JButton back = new JButton("Go Back");
		back.addActionListener(this);
		back.setActionCommand(back.getText());
		back.setBounds(Pong.screenSize.width/2 - 200, Pong.screenSize.height/2 + 50*3, 400, 40);
		add(back);
		
		for(String color : colorTexts)
			backgroundColor.addItem(color);
		
		backgroundColor.setBounds(Pong.screenSize.width/2, Pong.screenSize.height/2 + 50*2, 200, 40);
		backgroundColor.addActionListener(this);
		backgroundColor.setActionCommand("Background Color");
		add(backgroundColor);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(OptionsMenu.bgColor);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Comic Sans", 1, 100));
		g.drawString("Options", Pong.screenSize.width/2 - g.getFontMetrics().stringWidth("Options")/2, Pong.screenSize.height/4);
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
		} else if (e.getActionCommand().equals("Background Color")); {
			try {
				JComboBox<String> combo = (JComboBox<String>)e.getSource();
				
				if(combo.getSelectedItem().equals("Black"))
					bgColor = Color.BLACK;
				else if(combo.getSelectedItem().equals("Blue"))
					bgColor = Color.BLUE;
				else if(combo.getSelectedItem().equals("Green"))
					bgColor = Color.GREEN;
				else if(combo.getSelectedItem().equals("Red"))
					bgColor = Color.RED;
			} catch (Exception x) {}
		}	
	}


}
