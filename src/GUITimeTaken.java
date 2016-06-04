import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GUITimeTaken extends JPanel {
	JLabel time;
	int numSeconds;
	
	public GUITimeTaken() {
		//Set the number of seconds so far to 0:
		numSeconds = 0;
		
		//Add label keeping track of amount of time game has been played:
		time = new JLabel();
		time.setFont(new Font(null, Font.BOLD, 18));
		add(time);
		setTimeLabel();
		
		//Add Timer to keep track of time:
		Timer minesTimer = new Timer(1000, new NumMinesListener());
		minesTimer.start();
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
