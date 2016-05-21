
public class Driver {
	
	//Information about the Minesweeper difficulty:
	private static enum Mode {EASY, MEDIUM, HARD};	//Minesweeper difficulty
	private static Mode curr_mode = Mode.MEDIUM;
	
	//Store the dimension of the grid:
	private static int num_wide;
	private static int num_high;
	private static int num_mines;
	
	public static void main(String[] args) {
		//Set parameters based on difficulty:
		if (curr_mode == Mode.EASY) {
			num_wide = 8;
			num_high = 8;
			num_mines = 10;
		}
		else if (curr_mode == Mode.MEDIUM) {
			num_wide = 16;
			num_high = 16;
			num_mines = 40;
		}
		else if (curr_mode == Mode.HARD) {
			num_wide = 30;
			num_high = 16;
			num_mines = 99;
		}
		
		//Create the controller:
		new Controller(num_wide, num_high, num_mines);
	}
}
