import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


/**
 * Class for the grid section of the GUI which shows the mine field.
 */
@SuppressWarnings("serial")
public class GUIGrid extends JPanel {
	private GUIButton[][] buttons;
	
	public GUIGrid(Controller controller) {
		int numHigh = Driver.getNumHigh();
		int numWide = Driver.getNumWide();
		
		setLayout(new GridLayout(numHigh, numWide));
		
		setPreferredSize(new Dimension(Driver.getGUIGridWidth(), Driver.getGUIGridHeight()));
		
		buttons = new GUIButton[numHigh][numWide];
		
		//Add the GUIButtons:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				buttons[row][column] = new GUIButton(row, column, controller);
				
				this.add(buttons[row][column]);
				buttons[row][column].resetText();
			}
		}
	}
	
	/**
	 * Returns the specified GUIButton.
	 */
	public GUIButton getGUIButton(int row, int column) {
		return buttons[row][column];
	}
}
