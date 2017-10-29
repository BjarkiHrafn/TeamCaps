Design report
=============

Document describing the initial design.

## Class Diagram

![Caption for the picture.](/path/to/diagramjpg.jpg)

## FUNCTIONS IN INTERFACE AND BUSINESS CLASSES

### BUSINESS

* void initializeBoard() // creates the board
* void updateBoard()     // updates the board after a player makes a move
* Boolean inputCheck()	 // checks if the input has been taken
* Boolean checkRange()	 // checks if the input is out of range
* void convertToXY()	 // converts to x or y
* Boolean gameOver 	   	 // checks if a player has won or if the game is a draw

### INTERFACE

* displayBoard() 		// displays the board to the user
* playerInput() 		// updates the board after each turn
* displayGameOver()		// informes the user when he has won or made a draw
