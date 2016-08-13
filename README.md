# Minesweeper
## An imitation of the Minesweeper game

### Difficulty levels:
1. Easy - 8x8 grid - 10 mines
2. Medium - 16x16 grid - 40 mines
3. Hard - 30x16 grid - 99 mines

### How to play:
1. Use left click to select a cell:
  * If a number appears, then that is the number of mines in the 8 surrounding cells.
  * If an 'x' appears, then it is a mine and you have failed the game.
  * If the cell is blank then there are no surrounding mines. In this case, all adjacent cells should be revealed.
2. Use right click to 'flag' a mine. This means it is marked with a '!'. This can be useful to keep track of particular cells which you believe are mines. Flags can be removed by right clicking on the cell.
3. The aim of the game is to select all cells which are not mines.
4. When all all non-mine cells have been clicked, you win the game.

### Explanation of GUI:
* Select difficulty from bottom left. This starts the game again with the new grid size and number of mines.
* The total time taken is shown at the bottom.
* In the bottom right there is a counter for how many flags remain.

### How to compile:
* Within the /src folder, compile and run the Driver.java file.

## Jar file:
* Within the /jar folder, there is an executable jar file containing the game.

### Wanted features:
* When you select a cell, it becomes grayed out. I'd rather it retains its colour so the text is easier to read.
* When you change difficulty/create a new game, I'd rather that the current GUI is modified, rather than removed and re-created with the new settings.
