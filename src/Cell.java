//Test comment

/**
 * Class to represent an individual cell which may or may not be a mine
 */
public class Cell {
	private boolean is_mine;		//Stores whether or not this Cell is a mine
	private boolean flagged;		//If true, it means the user has marked this Cell as being a mine
	private int num_adjacent_mines;	//Stores the number of adjacent mines
	
	
	public Cell() {
		is_mine = false;
		flagged = false;
		num_adjacent_mines = 0;
	}
	
	/**
	 * Returns whether this Cell is a mine.
	 */
	public boolean isMine() {
		return is_mine;
	}
	
	/**
	 * Returns the number of adjacent mines to this Cell.
	 */
	public int getNumAdjMines() {
		return num_adjacent_mines;
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
		is_mine = true;
	}
	
	/**
	 * Sets the number of adjacent mines to this Cell.
	 */
	public void setNumAdjMines(int num_mines) {
		num_adjacent_mines = num_mines;
	}
	
	/**
	 * Sets this Cell as being flagged/not flagged, depending on parameter.
	 */
	public void setFlagged(boolean flag) {
		flagged = flag;
	}
}
