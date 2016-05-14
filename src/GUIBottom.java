import javax.swing.JPanel;
import javax.swing.JLabel;


/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	public GUIBottom(int num_mines) {
		JLabel time = new JLabel("Time: ");
		JLabel mines = new JLabel("Number of mines: ");
		add(time);
		add(mines);
		//TODO - set text size, colour and spacing
		//TODO - Make timer work
		//TODO - Make some way for the number of remaining mines to be set as a parameter
	}
}
