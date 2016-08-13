import java.util.Random;

/**
 * Class to represent the Controller part of MVC
 *
 */
public class Controller {
	private int numWide, numHigh, numMines;
	
	private boolean firstMove;	//If true, it is the first move of the player
	
	private Cell[][] cells;
	private GUI gui;
	
	public Controller() {
		firstMove = true;
		
		numWide = Driver.getNumWide();
		numHigh = Driver.getNumHigh();
		numMines = Driver.getNumMines();
		
		//Create the GUI:
		gui = new GUI(this);
		
		//Create the Cells:
		createCells();
		
		//Place the mines:
		setMines();
		
		//Count the number of adjacent mines for each Cell:
		countNumAdjacentMines();
	}
	
	/**
	 * Initialises the Cell's.
	 */
	public void createCells() {
		//Create the 2D array:
		cells = new Cell[numHigh][numWide];
		
		//Initialise the Cell's within the array:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				cells[row][column] = new Cell();
			}
		}
	}
	
	/**
	 * Returns the specified Cell.
	 */
	public Cell getCell(int row, int column) {
		return cells[row][column];
	}
	
	/**
	 * Sets some of the Cell's to be mines.
	 */
	public void setMines() {
		int num_placed = 0;
		
		Random rand = new Random();
		int row, column;
		Cell this_cell;
		
		//Keep placing mines until enough have been placed:
		while (num_placed < numMines) {
			row = rand.nextInt(numHigh);
			column = rand.nextInt(numWide);
			
			this_cell = cells[row][column];
			
			//Check if this Cell is already a mine:
			if (this_cell.isMine() == false) {
				//It's not a mine, so set it as one
				this_cell.makeMine();
				num_placed++;
			}
		}
	}
	
	/**
	 * Returns whether the specified Cell is a mine.
	 */
	public boolean isMine(int row, int column) {
		return cells[row][column].isMine(); 
	}
	
	/**
	 * Counts the number of adjacent mines for each Cell.
	 */
	public void countNumAdjacentMines() {
		int count;
		
		//Iterate over all Cells:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				if (cells[row][column].isMine()) {
					//Do nothing
				} else {
					//Not a mine, so count number of adjacent mines:
					count = 0;
					
					//Iterate over surrounding Cells:
					for (int tmp_row = row - 1; tmp_row <= row + 1; tmp_row++) {
						for (int tmp_column = column - 1; tmp_column <= column + 1; tmp_column++) {
							if (tmp_row >= 0 && tmp_row < numHigh && tmp_column >= 0 && tmp_column < numWide) {
								if (tmp_row == row && tmp_column == column) {
									//Don't bother counting this cell
								} else if (cells[tmp_row][tmp_column].isMine()) {
									count++;
								}
							}
						}
					}
					
					//Set number of mines:
					cells[row][column].setNumAdjMines(count);
				}
			}
		}
	}
	
	/**
	 * Reveal the value of this cell. If it has no adjacent mines, then reveal the value of adjacent cells.
	 * @param row is the row we are processing
	 * @param column is the column we are processing
	 */
	public void revealAndTraverse(int row, int column) {
		int numMines = getCell(row, column).getNumAdjMines();
		getGUI().getGUIFrame().getGUITop().getGUIGrid().getButton(row, column).displayValue(numMines);
		getCell(row, column).markAsKnown();
		
		if (numMines == 0) {
			//No adjacent mines, so display value of all adjacent mines
			
			//Iterate over surrounding cells:
			for (int tmp_row = row - 1; tmp_row <= row + 1; tmp_row++) {
				for (int tmp_column = column - 1; tmp_column <= column + 1; tmp_column++) {
					if (tmp_row >= 0 && tmp_row < Driver.getNumHigh() && tmp_column >= 0 && tmp_column < Driver.getNumWide()) {
						if (tmp_row == row && tmp_column == column) {
							//Don't include this cell
						} else if (getCell(tmp_row, tmp_column).isValueKnown() == false) {
							//Call this method on the adjacent cell
							revealAndTraverse(tmp_row, tmp_column);
						}
					}
				}
			}
		}
	}
	
	/**
	 * Displays where all mines are, as well as the number of mines for each Cell.
	 */
	public void displayAllMines() {
		GUIGrid grid = gui.getGUIFrame().getGUITop().getGUIGrid();
		
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				if (cells[row][column].isMine()) {
					grid.getButton(row, column).displayValue(-1);
				} else {
					//Not a mine.
					grid.getButton(row, column).displayValue(cells[row][column].getNumAdjMines());
				}
			}
		}
	}
	
	/**
	 * This method is used if a mine is selected. It displays all other mines and ends the game.
	 */
	public void failGame() {
		//Iterate over the grid:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				if (cells[row][column].isMine()) {
					gui.getGUIFrame().getGUITop().getGUIGrid().getButton(row, column).displayMine();
					cells[row][column].markAsKnown();
				}
			}
		}
		
		//Stop the timer:
		gui.getGUIFrame().getGUIBottom().getGUITimeTaken().stopTimer();
		
		//Lock the buttons so they can no longer be selected:
		lockButtons();
		
		//Inform the user that they have lost:
		gui.failGameDialog();
	}
	
	/**
	 * This method is called if the user wins the game.
	 */
	public void winGame() {
		//Stop the timer:
		gui.getGUIFrame().getGUIBottom().getGUITimeTaken().stopTimer();
		
		//Display dialog to inform user that they won:
		gui.winGameDialog();
	}
	
	/**
	 * Checks if the user won the game
	 */
	public void checkGameWin() {
		//Iterate over the grid:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				if (cells[row][column].isMine() == true) {
					//Do nothing
				} else if (cells[row][column].isValueKnown()) {
					//Do nothing
				} else {
					//Not a mine and the value is not known - therefore, user hasn't won yet
					return;
				}
			}
		}
		
		//If we get to this point, then the user has won the game
		winGame();
	}
	
	/**
	 * Locks all of the buttons so they can no longer be clicked.
	 */
	public void lockButtons() {
		//Iterate over the Cells:
		for (int row = 0; row < numHigh; row++) {
			for (int column = 0; column < numWide; column++) {
				gui.getGUIFrame().getGUITop().getGUIGrid().getButton(row, column).setEnabled(false);
			}
		}
	}
	
	/**
	 * Returns the GUI object
	 * @return the GUI object
	 */
	public GUI getGUI() {
		return gui;
	}
	
	/**
	 * Returns the number of mines in the game.
	 * @return The number of mines
	 */
	public int getNumMines() {
		return numMines;
	}
	
	/**
	 * Returns whether it is the first move of the player.
	 * @return firstMove
	 */
	public boolean getFirstMove() {
		return firstMove;
	}
	
	/**
	 * Sets whether or not it is the player's first move.
	 * @param move is the new value of firstMove
	 */
	public void setFirstMove(boolean move) {
		firstMove = move;
	}
}
