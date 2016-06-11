
/**
 * Class to run the whole program.
 */
public class Driver {
	//Information about the Minesweeper difficulty:
	private static enum Mode {EASY, MEDIUM, HARD};	//Minesweeper difficulty
	private static Mode currMode = Mode.MEDIUM;
	private static Controller controller;
	//Store the dimension of the grid:
	private static int num_wide;
	private static int num_high;
	private static int num_mines;
	
	//Some values to store dimensions of different GUI components:
	private static int GUIButtonLength = 38;			//The width and height of each GUIButton		TODO - set value
	private static int GUIGridWidth;			//The width of the GUI Grid		TODO - set value
	private static int GUIGridHeight;			//The height of the GUIGrid		TODO - set value
	private static int GUIGridPaddingWidth;		//The width padding for the GUIGrid (each side)		TODO - set value
	private static int GUIGridPaddingHeight;	//The height padding for the GUIGrid (each side)		TODO - set value
	private static int GUITopWidth;				//The width of the GUITop		TODO - set value
	private static int GUITopHeight;			//The height of the GUITop		TODO - set value
	private static int GUIDifficultyWidth;		//The width of the GUIDifficulty		TODO - set value
	private static int GUIDifficultyHeight;		//The height of the GUIDifficulty		TODO - set value
	private static int GUITimeTakenWidth;		//The width of the GUITimeTaken			TODO - set value
	private static int GUITimeTakenHeight;		//The height of the GUITimeTaken		TODO - set value
	private static int GUIMinesRemainingWidth;	//The width of the GUIMinesRemaining	TODO - set value
	private static int GUIMinesRemainingHeight;	//The height of the GUIMinesRemaining	TODO - set value
	private static int GUIBottomWidth;			//The width of the GUIBottom		TODO - set value
	private static int GUIBottomHeight;			//The height of the GUIBottom		TODO - set value
	private static int GUIWidth;				//The width of the GUI		TODO - set value
	private static int GUIHeight;				//The height of the GUI		TODO - set value
	
	public static void main(String[] args) {
		//Deal a game of Minesweeper:
		dealGame();
	}
	
	/**
	 * This method deals a game of Minesweeper
	 */
	public static void dealGame() {
		//Set parameters based on difficulty:
		if (currMode == Mode.EASY) {
			num_wide = 8;
			num_high = 8;
			num_mines = 10;
		}
		else if (currMode == Mode.MEDIUM) {
			num_wide = 16;
			num_high = 16;
			num_mines = 40;
		}
		else if (currMode == Mode.HARD) {
			num_wide = 30;
			num_high = 16;
			num_mines = 99;
		}
		
		//Create the controller:
		controller = new Controller(num_wide, num_high, num_mines);
	}
	
	/**
	 * This method ends the current game and re-deals
	 */
	public static void reset() {
		//Close the current window:
		controller.getGUI().closeWindow();
		
		//Deal a new game:
		dealGame();
	}
	
	/**
	 * Sets the mode of the game
	 * @param newMode is the new mode
	 */
	public static void setMode(String newMode) {
		if (newMode.equalsIgnoreCase("Easy")) {
			currMode = Mode.EASY;
		} else if (newMode.equalsIgnoreCase("Medium")) {
			currMode = Mode.MEDIUM;
		} else if (newMode.equalsIgnoreCase("Hard")) {
			currMode = Mode.HARD;
		} else {
			System.out.println("Invalid mode set");
		}
	}
	
	/**
	 * Returns the String representation of the current mode.
	 * @return the current mode
	 */
	public static String getModeString() {
		return currMode.toString();
	}
	
	/**
	 * Returns the GUIButtonLength
	 * @return the GUIButtonLength
	 */
	public static int getGUIButtonLength() {
		return GUIButtonLength;
	}
	
	/**
	 * Returns the GUIGridWidth
	 * @return the GUIGridWidth
	 */
	public static int getGUIGridWidth() {
		return GUIGridWidth;
	}
	
	/**
	 * Returns the GUIGridHeight
	 * @return the GUIGridHeight
	 */
	public static int getGUIGridHeight() {
		return GUIGridHeight;
	}
	/**
	 * Returns the GUIGridPaddingWidth
	 * @return the GUIGridPaddingWidth
	 */
	public static int getGUIGridPaddingWidth() {
		return GUIGridPaddingWidth;
	}
	
	/**
	 * Returns the GUIGridPaddingHeight
	 * @return the GUIGridPaddingHeight
	 */
	public static int getGUIGridPaddingHeight() {
		return GUIGridPaddingHeight;
	}
	
	/**
	 * Returns the GUITopWidth
	 * @return the GUITopWidth
	 */
	public static int getGUITopWidth() {
		return GUITopWidth;
	}
	
	/**
	 * Returns the GUITopHeight
	 * @return the GUITopHeight
	 */
	public static int getGUITopHeight() {
		return GUITopHeight;
	}
	
	/**
	 * Returns the GUIDifficultyWidth
	 * @return the GUIDifficultyWidth
	 */
	public static int getGUIDifficultyWidth() {
		return GUIDifficultyWidth;
	}
	
	/**
	 * Returns the GUIDifficultyHeight
	 * @return the GUIDifficultyHeight
	 */
	public static int getGUIDifficultyHeight() {
		return GUIDifficultyHeight;
	}
	
	/**
	 * Returns the GUITimeTakenWidth
	 * @return the GUITimeTakenWidth
	 */
	public static int getGUITimeTakenWidth() {
		return GUITimeTakenWidth;
	}
	
	/**
	 * Returns the GUITimeTakenHeight
	 * @return the GUITimeTakenHeight
	 */
	public static int getGUITimeTakenHeight() {
		return GUITimeTakenHeight;
	}
	
	/**
	 * Returns the GUIMinesRemainingWidth
	 * @return the GUIMinesRemainingWidth
	 */
	public static int getGUIMinesRemainingWidth() {
		return GUIMinesRemainingWidth;
	}
	
	/**
	 * Returns the GUIMinesRemainingHeight
	 * @return the GUIMinesRemainingHeight
	 */
	public static int getGUIMinesRemainingHeight() {
		return GUIMinesRemainingHeight;
	}
	
	/**
	 * Returns the GUIBottomWidth
	 * @return the GUIBottomWidth
	 */
	public static int getGUIBottomWidth() {
		return GUIBottomWidth;
	}
	
	/**
	 * Returns the GUIBottomHeight
	 * @return the GUIBottomHeight
	 */
	public static int getGUIBottomHeight() {
		return GUIBottomHeight;
	}
	
	/**
	 * Returns the GUIWidth
	 * @return the GUIWidth
	 */
	public static int getGUIWidth() {
		return GUIWidth;
	}
	
	/**
	 * Returns the GUIHeight
	 * @return the GUIHeight
	 */
	public static int getGUIHeight() {
		return GUIHeight;
	}
	
}
