Design report
=============

> Continuous deployment achieved!
> 
> The initial design plan was a double layered system. As we are not using database for storing information in this simple project the traditional
> triple layered design (UI->Business->Database) was dropped. We decided which functions we would need and how to store the game board
> and drew everything up on a table. After a lot of brainstorming the results were as displayed in the class diagram below.
> This of course changed a bit after the game was updated into a web app. That presented one new function in the business class which was
> required to convert the game board into a string to be able to send it to the server as well as the omission of the Interface class.

## Class Diagram

![Caption for the picture.](/images/diagramjpg.jpg)

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
