
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Pong{
	public static JFrame pongFrame;
	public static JPanel settings;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Timer t = new Timer();
	
	public Pong() {
		pongFrame = new JFrame("PONG");
		settings = new OptionsMenu();
		pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pongFrame.setVisible(true);
		pongFrame.setResizable(false);
		pongFrame.setContentPane(new MainMenu());
	}
	
	public static void main(String[] args) {
		new Pong();
		t.schedule(new TimerTask() {
			public void run() {
				pongFrame.repaint();
			}
		}, 0, 10);
	}

}
