import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Class for the entire GUI
 */
public class GUI {
	private GUITop top;
	private GUIBottom bottom;
	private JFrame frame;
	
	public GUI(Controller controller) {
		//Create large frame of GUI:
		frame = new JFrame("Minesweeper");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
		
		frame.setSize(new Dimension(Driver.getGUIWidth(), Driver.getGUIHeight()));
		
		//Add the top grid section to the GUI:
		top = new GUITop(controller);
		frame.add(top, BorderLayout.NORTH);
		
		//Add the bottom text section to the GUI:
		bottom = new GUIBottom(controller);
		frame.add(bottom, BorderLayout.SOUTH);
	}
	
	
	//TODO - remove this method:
	public void printIt() {
		System.out.println("Top:\t\t" + top.getSize());
		System.out.println("Bottom:\t\t" + bottom.getSize());
		System.out.println("Grid:\t\t" + top.getGUIGrid().getSize());
		System.out.println("Total:\t\t" + frame.getSize());
		System.out.println();
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
	
	/**
	 * Dialog message to inform user they have lost
	 */
	public void failGameDialog() {
		int response = JOptionPane.showConfirmDialog(null, "Play again?", "Play again", JOptionPane.YES_NO_CANCEL_OPTION);
		if (response == 0) {
			//User selected 'Yes'
			Driver.reset();
		} else if (response == 1) {
			//User selected 'No'
			System.exit(0);
		} else if (response == 2) {
			//User selected 'Cancel'
			//TODO - lock everything.
		}
	}
	
	/**
	 * Dialog message to inform user they have won the game
	 */
	public void winGameDialog() {
		int response = JOptionPane.showConfirmDialog(null, "Play again?", "Play again", JOptionPane.YES_NO_OPTION);
		if (response == 0) {
			//User selected 'Yes'
			Driver.reset();
		}
		else if (response == 1) {
			//User selected 'No'
			System.exit(0);
		}
	}
	
	/**
	 * Closes the JFrame
	 */
	public void closeWindow() {
		frame.setVisible(false);
		frame.dispose();
	}
}