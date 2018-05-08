import java.awt.Color;

import javax.swing.JPanel;

/*
 * Announcement should show up as a message on either side of the board when added to the game panel
 * It should be on the side of the player that hit it (determined by direction)
 * Announcement should last for a few seconds (or until the powerup dies, idk which)
 * Should be Rapidly changing color if possible (like powerup)
 * Should not obstruct the game too much, but big enough to be noticed and readable
 * Should be located in center of designated side
 */

//TODO Get this shit operational

public class Announcement extends JPanel{
	
	public Announcement(Color color) {
		setLayout(null);
		setBounds(100,100,100,100);
		setBackground(Color.RED);
		if(color == Color.RED) {
			
		}
	}

}
