import javax.swing.JOptionPane;

/**
 * Class for the entire GUI.
 */
public class GUI {
	private GUIFrame frame;
	private Controller controller;
	
	public GUI(Controller controller) {
		this.controller = controller;
		
		//Create large frame of GUI:
		frame = new GUIFrame(controller, "Minesweeper");
	}
	
	/**
	 * Returns the GUIFrame
	 * @return the GUIFrame
	 */
	public GUIFrame getGUIFrame() {
		return frame;
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
			controller.lockButtons();
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
		} else if (response == 1) {
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