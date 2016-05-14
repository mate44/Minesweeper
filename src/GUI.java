import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Class for the entire GUI
 */
public class GUI {
	private GUITop top;
	private GUIBottom bottom;
	
	public GUI(int num_wide, int num_high, int num_mines, Controller controller) {
		//Create large frame of GUI:
		JFrame frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		//Add the top grid section to the GUI:
		top = new GUITop(num_wide, num_high, controller);
		frame.add(top, BorderLayout.NORTH);
		
		//Add the bottom text section to the GUI:
		bottom = new GUIBottom(num_mines);
		frame.add(bottom, BorderLayout.SOUTH);
		
		frame.setSize(750, 650);
		
		
		//TODO - make the dimensions of the grid work correctly - as in the size of the GUI
	}
	
	/**
	 * Returns the GUITop.
	 */
	public GUITop getGUITop() {
		return top;
	}
	
	/**
	 * Returns the GUIBottom.
	 */
	public GUIBottom getGUIBottom() {
		return bottom;
	}
}