import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JPanel;


/**
 * Class for the GUI section that holds the GUIGrid.
 */
@SuppressWarnings("serial")
public class GUITop extends JPanel {
	GUIGrid grid;
	public GUITop(Controller controller) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(Driver.getGUITopWidth(), Driver.getGUITopHeight()));
		
		//Add top blank space:
		add(Box.createRigidArea(new Dimension(Driver.getGUITopWidth(), Driver.getGUIGridPaddingHeight())), BorderLayout.NORTH);
		
		//Add left blank space:
		add(Box.createRigidArea(new Dimension(Driver.getGUIGridPaddingWidth(), Driver.getGUIGridHeight())), BorderLayout.WEST);
		
		//Create GUIGrid:
		grid = new GUIGrid(controller);
		add(grid, BorderLayout.CENTER);
		
		//Add right blank space:
		add(Box.createRigidArea(new Dimension(Driver.getGUIGridPaddingWidth(), Driver.getGUIGridHeight())), BorderLayout.EAST);
		
		//Add bottom blank space:
		add(Box.createRigidArea(new Dimension(Driver.getGUITopWidth(), Driver.getGUIGridPaddingHeight())), BorderLayout.SOUTH);
	}
	
	public GUIGrid getGUIGrid() {
		return grid;
	}
}
