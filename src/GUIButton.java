import java.awt.Color;
import java.awt.Font;
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
	
	public GUIButton(int row, int column, Controller controller) {
		//Save position on grid:
		this.row = row;
		this.column = column;
		
		this.controller = controller;
		
		//Formatting of the button:
		setSize(15, 15);
		setFont(new Font("Verdana", Font.BOLD, 16));
		
		this.addMouseListener(new Mouse());		//Add listener to deal with mouse interactions
	}
	
	/**
	 * Set's the button text once it has been clicked.
	 */
	public void click(int num_mines) {
		if (num_mines == 0) {
			setFont(new Font("Verdana", Font.BOLD, 16));
			setForeground(Color.BLACK);
			setText(" ");
		}
		else if (num_mines >= 1 && num_mines <= 8) {
			setFont(new Font("Verdana", Font.BOLD, 16));
			setForeground(Color.BLACK);
			setText((new Integer(num_mines)).toString());
		}
		else if (num_mines == -1) {
			//Define -1 to mean that there is a mine at this Cell
			controller.failGame();
		}
		
		//Make the button non-selectable:
		//TODO - make button non-selectable
		
	}
	
	public void displayMine() {
		setText("x");
		setForeground(Color.RED);
	}
	
	/**
	 * Class to deal with the interactions of the mouse with the buttons.
	 */
	private class Mouse implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {					//Left click
			if ((arg0.getButton() == MouseEvent.BUTTON1) && (controller.getCell(row, column).isFlagged() == false)) {
				if (controller.isMine(row, column)) {
					//Is a mine
					click(-1);
				}
				else {
					//Not a mine
					click(controller.getCell(row, column).getNumAdjMines());
				}
				
				setEnabled(false);
				
			}
			else if ((arg0.getButton() == MouseEvent.BUTTON3) && (isEnabled() == true)) {		//Right click
				//Toggle whether cell is "flagged":
				if (controller.getCell(row, column).isFlagged() == true) {
					controller.getCell(row, column).setFlagged(false);
					click(0);	//Reset text on button
				}
				else {
					//Not flagged
					controller.getCell(row, column).setFlagged(true);	//Mark as flagged
					
					//Change text on button:
					setText("!");
					setForeground(Color.BLUE);
				}
				
				//Right click
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	
}
