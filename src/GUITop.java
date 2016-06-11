import javax.swing.JPanel;


/**
 * Class for the GUI section that holds the GUIGrid.
 */
@SuppressWarnings("serial")
public class GUITop extends JPanel {
	GUIGrid grid;
	public GUITop(Controller controller) {
		//Create GUIGrid:
		grid = new GUIGrid(controller);
		add(grid);
	}
	
	public GUIGrid getGUIGrid() {
		return grid;
	}
}
