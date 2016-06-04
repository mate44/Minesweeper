import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUIMinesRemaining extends JPanel {
	private JLabel mines;
	
	public GUIMinesRemaining(Controller controller) {
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
