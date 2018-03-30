import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

public class Pong{
	public static JFrame pongFrame;
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private static Timer t = new Timer();
	
	public Pong() {
		pongFrame = new JFrame("PONG");
		pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pongFrame.setVisible(true);
		pongFrame.setResizable(false);
		pongFrame.add(new MainMenu());
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
