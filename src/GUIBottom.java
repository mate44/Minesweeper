import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	public GUIBottom(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		setPreferredSize(new Dimension(Driver.getGUIBottomWidth(), Driver.getGUIBottomHeight()));
		
		//Add radio buttons to select difficulty:
		GUIDifficulty radioButtons = new GUIDifficulty();
		add(radioButtons);
		
		//Add section to keep track of time taken:
		GUITimeTaken timeTaken = new GUITimeTaken();
		add(timeTaken);
		
		//Add section to keep track of number of remaining mines:
		GUIMinesRemaining minesRemaining = new GUIMinesRemaining(controller);
		add(minesRemaining);
	}
}
