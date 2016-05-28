import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;


/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	public GUIBottom(int num_mines) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//Add radio buttons to select difficulty:
		GUIDifficulty radioButtons = new GUIDifficulty();
		add(radioButtons);
		
		//Add empty space:
		add(Box.createRigidArea(new Dimension(50, 0)));
		
		//Add label keeping track of amount of time game has been played:
		JLabel time = new JLabel("Time: ");
		time.setFont(new Font(null, Font.BOLD, 18));
		add(time);
		//TODO - Make timer work
		
		//Add empty space:
		add(Box.createRigidArea(new Dimension(100, 0)));
		
		//Add label keeping track of number of mines remaining:
		JLabel mines = new JLabel("Number of mines: ");
		mines.setFont(new Font(null, Font.BOLD, 18));
		add(mines);
		
		//TODO - Update the number of mines based on how many flags have been placed.
	}
}
