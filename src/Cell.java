

/**
 * Class to represent an individual cell which may or may not be a mine
 */
public class Cell {
	private boolean isMine;			//Stores whether or not this Cell is a mine
	private boolean flagged;		//If true, it means the user has marked this Cell as being a mine
	private boolean valueKnown;		//If true, it means the user knows the value of this cell (may or may not be a mine)
	private int numAdjacentMines;	//Stores the number of adjacent mines
	
	public Cell() {
		isMine = false;
		flagged = false;
		valueKnown = false;
		numAdjacentMines = 0;
	}
	
	/**
	 * Returns whether this Cell is a mine.
	 */
	public boolean isMine() {
		return isMine;
	}
	
	/**
	 * Returns the number of adjacent mines to this Cell.
	 */
	public int getNumAdjMines() {
		return numAdjacentMines;
	}
	
	/**
	 * Returns whether this Cell's value is known to the user.
	 */
	public boolean isValueKnown() {
		return valueKnown;
	}
	
	/**
	 * Returns whether or not this cell is flagged.
	 */
	public boolean isFlagged() {
		return flagged;
	}
	
	/**
	 * Makes this Cell into a mine.
	 */
	public void makeMine() {
		isMine = true;
	}
	
	/**
	 * Sets the number of adjacent mines to this Cell.
	 */
	public void setNumAdjMines(int num_mines) {
		numAdjacentMines = num_mines;
	}
	
	/**
	 * Sets this Cell as being flagged/not flagged, depending on parameter.
	 */
	public void setFlagged(boolean flag) {
		flagged = flag;
	}
	
	/**
	 * Marks this Cell's value as being known by the user.
	 */
	public void markAsKnown() {
		valueKnown = true;
	}
}
