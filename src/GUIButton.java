import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * Class for the GUI of an individual grid cell
 */
@SuppressWarnings("serial")
public class GUIButton extends JButton {
	private int row, column;
	private Controller controller;
	private int fontSize = 22;
	private static final int IS_MINE = -1;		//Constant to mark this GUIButton as being a mine
	
	public GUIButton(int row, int column, Controller controller) {
		//Save position on grid:
		this.row = row;
		this.column = column;
		
		this.controller = controller;
		
		//Set size of button:
		setPreferredSize(new Dimension(Driver.getGUIButtonLength(), Driver.getGUIButtonLength()));
		
		//Formatting of the button:
		setSize(Driver.getGUIButtonLength(), Driver.getGUIButtonLength());
		setFont(new Font("Verdana", Font.PLAIN, fontSize));
		
		//Set margin so text takes up entire space of button:
		setMargin(new Insets(0, 0, 0, 0));
		
		this.addMouseListener(new Mouse());		//Add listener to deal with mouse interactions
	}
	
	/**
	 * Set's the button text once it has been clicked.
	 */
	public void displayValue(int num_mines) {
		if (num_mines == 0) {
			resetText();
		}
		else if (num_mines >= 1 && num_mines <= 8) {
			setForeground(Color.BLACK);
			setText((new Integer(num_mines)).toString());
		}
		else if (num_mines == IS_MINE) {
			controller.failGame();
		}
		
		//Make the button non-selectable:
		//TODO - make button non-selectable - maybe I could use polymorphism and use a 2D array of JComponents, which are parent classes of both JButtons and JLabels. Make sure after it is locked that no buttons can be clicked.
		
	}
	
	/**
	 * Resets the text of this GUIButton to be blank.
	 */
	public void resetText() {
		setForeground(Color.BLACK);
		setText("");
	}
	
	/**
	 * Marks this GUIButton as being a mine.
	 */
	public void displayMine() {
		setText("x");
		setForeground(Color.RED);
	}
	
	/**
	 * Does the appropriate action in response to this GUIButton being left clicked.
	 */
	public void leftClick() {
		Cell cell = controller.getCell(row, column);
		if (cell.isValueKnown() == true) {
			//Do nothing
		}
		else if (cell.isFlagged() == true) {
			//Do nothing
		}
		else {
			//Find the value of this cell:
			if (cell.isMine() == true) {
				displayValue(IS_MINE);
				cell.markAsKnown();
			}
			else {
				//Not a mine
				
				//Reveal value. If there are no adjacent mines, then reveal the value of adjacent cells:
				controller.revealAndTraverse(row, column);
			}
			
			//setEnabled(false);		//TODO - Fix this - it makes everything grey.
		}
	}
	
	/**
	 * Does the appropriate action in response to this GUIButton being right clicked.
	 */
	public void rightClick() {
		Cell cell = controller.getCell(row, column);
		if (cell.isValueKnown() == true) {
			//Do nothing
		}
		else {
			if (cell.isFlagged() == true) {
				cell.setFlagged(false);
				resetText();
				controller.getGUI().getGUIFrame().getGUIBottom().getGUIMinesRemaining().mineDeselect();	//Update number of mines
			}
			else {
				//Not flagged
				cell.setFlagged(true);
				
				//Change text on button:
				setText("!");
				setForeground(Color.BLUE);
				controller.getGUI().getGUIFrame().getGUIBottom().getGUIMinesRemaining().mineSelect();	//Update number of mines
			}
		}
	}
	
	/**
	 * Class to deal with the interactions of the mouse with the buttons.
	 */
	private class Mouse implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			//Deliberately empty method
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			//Deliberately empty method
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			//Deliberately empty method
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			//Deliberately empty method
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			if (arg0.getButton() == MouseEvent.BUTTON1) {
				//Left click
				leftClick();
				
			}
			else if (arg0.getButton() == MouseEvent.BUTTON3) {
				//Right click
				rightClick();
			}
		}
	}
	
}
