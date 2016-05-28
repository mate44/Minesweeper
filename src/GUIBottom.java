import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.Timer;


/**
 * Class for the bottom section of the GUI
 */
@SuppressWarnings("serial")
public class GUIBottom extends JPanel {
	JLabel time;
	int numSeconds;
	
	public GUIBottom(int num_mines) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		//Set the number of seconds so far to 0:
		numSeconds = 0;
		
		//Add radio buttons to select difficulty:
		GUIDifficulty radioButtons = new GUIDifficulty();
		add(radioButtons);
		
		//Add empty space:
		add(Box.createRigidArea(new Dimension(50, 0)));
		
		//Add label keeping track of amount of time game has been played:
		time = new JLabel();
		time.setFont(new Font(null, Font.BOLD, 18));
		setTimeLabel();
		add(time);
		
		//Add empty space:
		add(Box.createRigidArea(new Dimension(100, 0)));
		
		//Add label keeping track of number of mines remaining:
		JLabel mines = new JLabel("Number of mines: ");
		mines.setFont(new Font(null, Font.BOLD, 18));
		add(mines);
		
		Timer minesTimer = new Timer(1000, new NumMinesListener());
		minesTimer.start();
		
		
		//TODO - Update the number of mines based on how many flags have been placed.
	}
	
	/**
	 * Updates the label for the time taken playing the game
	 */
	private void setTimeLabel() {
		time.setText("Time: " + numSeconds);
	}
	
	/**
	 * ActionListener for updating the timer on the GUI
	 */
	private class NumMinesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			numSeconds++;	//Increment timer
			setTimeLabel();	//Update GUI timer
		}
		
	}
}
