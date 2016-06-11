import javax.swing.JPanel;


/**
 * Class for the GUI section that holds the GUIGrid.
 */
@SuppressWarnings("serial")
public class GUITop extends JPanel {
	GUIGrid grid;
	public GUITop(int num_wide, int num_high, Controller controller) {
		//Create GUIGrid:
		grid = new GUIGrid(num_wide, num_high, controller);
		add(grid);
	}
	
	public GUIGrid getGUIGrid() {
		return grid;
	}
}
