import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.BoxLayout;

/**
 * Class for the radio buttons which select the mode of difficulty for the game
 */
@SuppressWarnings("serial")
public class GUIDifficulty extends JPanel {
	public GUIDifficulty() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Create the radio buttons:
		JRadioButton easyButton = new JRadioButton("Easy");
		JRadioButton mediumButton = new JRadioButton("Medium");
		JRadioButton hardButton = new JRadioButton("Hard");
		mediumButton.setSelected(true);
		
		//Add them to a group:
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(easyButton);
		buttons.add(mediumButton);
		buttons.add(hardButton);
		
		//Add the buttons to the GUI:
		add(easyButton);
		add(mediumButton);
		add(hardButton);
		
		//Create action listeners for the buttons:
		//TODO - create action listener for each button. It should set the difficulty for the Controller, then call the "reset" method which I haven't created yet
	}
}
