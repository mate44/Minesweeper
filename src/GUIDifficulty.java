import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
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
		
		//Select the button for the current mode:
		String currMode = Driver.getModeString();
		if (currMode.equalsIgnoreCase("Easy")) {
			easyButton.setSelected(true);
		} else if (currMode.equalsIgnoreCase("Medium")) {
			mediumButton.setSelected(true);
		} else if (currMode.equalsIgnoreCase("Hard")) {
			hardButton.setSelected(true);
		}
		
		//Add RadioButtons to a group:
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(easyButton);
		buttons.add(mediumButton);
		buttons.add(hardButton);
		
		//Add the buttons to the GUI:
		add(easyButton);
		add(mediumButton);
		add(hardButton);
		
		//Create action listeners for the buttons:
		RadioButtonListener listener = new RadioButtonListener();
		easyButton.addActionListener(listener);
		mediumButton.addActionListener(listener);
		hardButton.addActionListener(listener);
	}
	
	/**
	 * ActionListener for the radio buttons
	 */
	private class RadioButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent event) {
			//Get the selected difficulty level:
			AbstractButton button = (AbstractButton) event.getSource();
			String difficulty = button.getText();
			
			//Set the difficulty of the game:
			Driver.setMode(difficulty);
			
			Driver.reset();
		}
	}
}
