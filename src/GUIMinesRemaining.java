import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class for the GUI section that shows the user how many mines remain.
 */
@SuppressWarnings("serial")
public class GUIMinesRemaining extends JPanel {
	private JLabel mines;
	private int minesRemaining;		//The number of mines yet to be selected by the user
	
	public GUIMinesRemaining(int minesRemaining) {
		setPreferredSize(new Dimension(Driver.getGUIMinesRemainingWidth(), Driver.getGUIMinesRemainingHeight()));
		
		//Add label keeping track of number of mines remaining:
		mines = new JLabel();
		mines.setFont(new Font(null, Font.BOLD, 18));
		this.minesRemaining = minesRemaining;
		setMinesRemainingLabel();
		add(mines);
	}
	
	/**
	 * Update the number of mines the user is yet to identify.
	 */
	private void setMinesRemainingLabel() {
		mines.setText("Mines remaining: " + minesRemaining);
	}
	
	/**
	 * Decrements the number of mines
	 */
	public void mineSelect() {
		minesRemaining--;
		setMinesRemainingLabel();
	}
	
	/**
	 * Increments the number of mines
	 */
	public void mineDeselect() {
		minesRemaining++;
		setMinesRemainingLabel();
	}
}
