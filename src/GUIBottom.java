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
		
		//TODO - add empty space between the components
		
		//Add label keeping track of amount of time game has been played:
		JLabel time = new JLabel("Time: ");
		add(time);
		
		//Add label keeping track of number of mines remaining:
		JLabel mines = new JLabel("Number of mines: ");
		add(mines);
		
		//TODO - add empty space between the components
		
		//TODO - set text size, colour and spacing
		//TODO - Make timer work
		//TODO - Make some way for the number of remaining mines to be set as a parameter
	}
}
