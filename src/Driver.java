
/**
 * Class to run the whole program.
 */
public class Driver {
	//Information about the Minesweeper difficulty:
	private static enum Mode {EASY, MEDIUM, HARD};	//Minesweeper difficulty
	private static Mode currMode = Mode.MEDIUM;
	private static Controller controller;
	
	//Store the dimension of the grid:
	private static int numWide;
	private static int numHigh;
	private static int numMines;
	
	//Store the width, height and number of mines for each difficulty level:
	private static int numWideEASY = 8;
	private static int numHighEASY = 8;
	private static int numMinesEASY = 10;
	private static int numWideMEDIUM = 16;
	private static int numHighMEDIUM = 16;
	private static int numMinesMEDIUM = 40;
	private static int numWideHARD = 30;
	private static int numHighHARD = 16;
	private static int numMinesHARD = 99;
	
	//Some values to store dimensions of different GUI components:
	private static int GUIButtonLength = 20;	//The width and height of each GUIButton		TODO - set to appropriate value
	private static int GUIGridWidth;			//The width of the GUI Grid
	private static int GUIGridHeight;			//The height of the GUIGrid
	private static int GUIGridPaddingWidth;		//The width padding for the GUIGrid (each side)
	private static int GUIGridPaddingHeight;	//The height padding for the GUIGrid (each side)
	private static int GUITopWidth;				//The width of the GUITop
	private static int GUITopHeight;			//The height of the GUITop
	private static int GUIDifficultyWidth;		//The width of the GUIDifficulty
	private static int GUIDifficultyHeight;		//The height of the GUIDifficulty
	private static int GUITimeTakenWidth;		//The width of the GUITimeTaken
	private static int GUITimeTakenHeight;		//The height of the GUITimeTaken
	private static int GUIMinesRemainingWidth;	//The width of the GUIMinesRemaining
	private static int GUIMinesRemainingHeight;	//The height of the GUIMinesRemaining
	private static int GUIBottomWidth;			//The width of the GUIBottom
	private static int GUIBottomHeight = 100;	//The height of the GUIBottom			TODO - set to appropriate value
	private static int GUIWidth;				//The width of the GUI
	private static int GUIHeight;				//The height of the GUI
	
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
			numWide = numWideEASY;
			numHigh = numHighEASY;
			numMines = numMinesEASY;
		}
		else if (currMode == Mode.MEDIUM) {
			numWide = numWideMEDIUM;
			numHigh = numHighMEDIUM;
			numMines = numMinesMEDIUM;
		}
		else if (currMode == Mode.HARD) {
			numWide = numWideHARD;
			numHigh = numHighHARD;
			numMines = numMinesHARD;
		}
		
		//Set the dimensions for the GUI:
		setGUIDimensions();
		
		//Create the controller:
		controller = new Controller();
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
	 * Based on the game difficulty, this method calculates the dimensions of the GUI variables.
	 */
	public static void setGUIDimensions() {
		//Set GUIGrid dimension:
		GUIGridWidth = numWide * GUIButtonLength;
		GUIGridHeight = numHigh * GUIButtonLength;
		
		//Set GUITop dimension:
		GUITopWidth = calculateMaxGUIGridWidth();
		GUITopHeight = calculateMaxGUIGridHeight();
		
		//Set dimension of padding around GUIGrid:
		GUIGridPaddingWidth = (GUITopWidth - GUIGridWidth) / 2;
		GUIGridPaddingHeight = (GUITopHeight - GUIGridHeight) / 2;
		
		//Set GUIBottom dimension:
		GUIBottomWidth = calculateMaxGUIGridWidth();
		
		//Set GUIDifficulty dimension:
		GUIDifficultyWidth = GUIBottomWidth / 3;
		GUIDifficultyHeight = GUIBottomHeight;
		
		//Set GUITimeTaken dimension:
		GUITimeTakenWidth = GUIBottomWidth / 3;
		GUITimeTakenHeight = GUIBottomHeight;
		
		//Set GUIMinesRemaining dimension:
		GUIMinesRemainingWidth = GUIBottomWidth / 3;
		GUIMinesRemainingHeight = GUIBottomHeight;
		
		//Set GUI dimension:
		GUIWidth = calculateMaxGUIGridWidth();
		GUIHeight = GUITopHeight + GUIBottomHeight;
	}
	
	/**
	 * Calculate the maximum height the GUIGrid can be. This is equal to the height of the HARD difficulty. 
	 * @return the max height
	 */
	public static int calculateMaxGUIGridHeight() {
		return GUIButtonLength * numHighHARD;
	}
	
	/**
	 * Calculate the maximum width the GUIGrid can be. This is equal to the width of the HARD difficulty.
	 * @return the max width
	 */
	public static int calculateMaxGUIGridWidth() {
		return GUIButtonLength * numWideHARD;
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
	
	/**
	 * Returns the numWide
	 * @return the numWide
	 */
	public static int getNumWide() {
		return numWide;
	}
	
	/**
	 * Returns the numHigh
	 * @return the numHigh
	 */
	public static int getNumHigh() {
		return numHigh;
	}
	
	/**
	 * Returns the numMines
	 * @return the numMines
	 */
	public static int getNumMines() {
		return numMines;
	}
	
}
