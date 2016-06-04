import java.awt.GridLayout;

import javax.swing.JPanel;


/**
 * Class for the GUI section that holds the GUIGrid.
 */
@SuppressWarnings("serial")
public class GUITop extends JPanel {
	private GUIButton[][] buttons;
	
	public GUITop(int num_wide, int num_high, Controller controller) {
		setLayout(new GridLayout(num_high, num_wide));
		
		buttons = new GUIButton[num_high][num_wide];
		
		//Add the GUIButtons:
		for (int row = 0; row < num_high; row++) {
			for (int column = 0; column < num_wide; column++) {
				buttons[row][column] = new GUIButton(row, column, controller);
				
				this.add(buttons[row][column]);
				buttons[row][column].click(0);
			}
		}
	}
	
	/**
	 * Returns the specified GUIButton.
	 */
	public GUIButton getButton(int row, int column) {
		return buttons[row][column];
	}
}
