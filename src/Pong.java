import javax.swing.JFrame;
import java.util.Timer;
import java.util.TimerTask;

public class Pong{
	static JFrame pongFrame;
	static Timer t = new Timer();
	
	public Pong() {
		pongFrame = new JFrame("PONG");
		pongFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pongFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		pongFrame.setVisible(true);
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
