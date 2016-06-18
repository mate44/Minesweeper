import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	private GUIDifficulty radioButtons;
	private GUITimeTaken timeTaken;
	private GUIMinesRemaining minesRemaining;
	
	public GUIBottom(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(Driver.getGUIBottomWidth(), Driver.getGUIBottomHeight()));
		
		//Add radio buttons to select difficulty:
		radioButtons = new GUIDifficulty();
		add(radioButtons);
		
		//Add section to keep track of time taken:
		timeTaken = new GUITimeTaken(controller);
		add(timeTaken);
		
		//Add section to keep track of number of remaining mines:
		minesRemaining = new GUIMinesRemaining(controller.getNumMines());
		add(minesRemaining);
	}
	
	/**
	 * Returns the GUIDifficulty
	 * @return the GUIDifficulty
	 */
	public GUIDifficulty getGUIDifficulty() {
		return radioButtons;
	}
	
	/**
	 * Returns the GUITimeTaken
	 * @return the GUITimeTaken
	 */
	public GUITimeTaken getGUITimeTaken() {
		return timeTaken;
	}
	
	/**
	 * Returns the GUIMinesRemaining
	 * @return the GUIMinesRemaining
	 */
	public GUIMinesRemaining getGUIMinesRemaining() {
		return minesRemaining;
	}
}
