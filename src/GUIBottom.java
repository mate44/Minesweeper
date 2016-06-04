import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;


/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	JLabel mines;
	
	public GUIBottom(Controller controller) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//Add radio buttons to select difficulty:
		GUIDifficulty radioButtons = new GUIDifficulty();
		add(radioButtons);
		
		//Add empty space:
		//add(Box.createRigidArea(new Dimension(50, 0)));	//TODO - do I want this?
		
		//Add section to keep track of time taken:
		GUITimeTaken timeRemaining = new GUITimeTaken();
		add(timeRemaining);
		
		//Add empty space:
		//add(Box.createRigidArea(new Dimension(100, 0)));		//TODO - do I want this?
		
		//Add label keeping track of number of mines remaining:
		mines = new JLabel();
		setMinesRemainingLabel(controller.getNumMines());
		mines.setFont(new Font(null, Font.BOLD, 18));
		add(mines);
		
		//TODO - Update the number of mines based on how many flags have been placed.
	}
	
	
	/**
	 * Update the number of mines the user is yet to identify.
	 * @param numMines The new number of mines
	 */
	private void setMinesRemainingLabel(int numMines) {
		mines.setText("Mines remaining: " + numMines);
	}
}
