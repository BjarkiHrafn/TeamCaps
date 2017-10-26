package is.ru.hugb.ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Interface{
	
	private static Business business;
	private static char[][] board;
	private static int playerCounter;
	
	public Interface(){
		business = new Business();
		board = business.board;
		playerCounter = 0;
	}
	
	private static void printBoard()
	{
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void userInteraction(){
		
		Scanner read = new Scanner(System.in);
		char player = ' ';
		while(!business.isGameWon(board) && playerCounter < 9){
			
			printBoard();
			player = business.playerXorO(playerCounter);
			
			System.out.println("Player " + player + ": ");
			
			int userInput = 99;
			String userInputString = "";
			while(!business.checkIfInRange(userInput)) {
				System.out.print("Input: ");
				userInputString = read.nextLine();
				
				try {
					userInput = Integer.valueOf(userInputString);
				}
				catch(Exception e) {
					System.out.println("Input is not a number");
				}
				
				int[] XY = business.convertToXY(userInput);
				if(!business.checkIfInRange(userInput)) {
					System.out.println("Invalid input, try again");
				}
				else if(business.checkIfOccupied(board, userInput)) {
					System.out.println("position is occupied, try again");
					userInput = 99;
				}
			}
			
			System.out.println();
			business.updateBoard(player, userInput);
			playerCounter ++;
			
		}
		printBoard();
		if(business.isGameWon(board)) {
			System.out.println("Player: " + player + " wins!");
		}
		else if(playerCounter >= 9) {
			System.out.println("Draw!");
		}
		else {
			System.out.println("something went wront");
		}
	}
	
	public static  void main(String[] args){  
		
		Interface test = new Interface();
		//test.printBoard();
		test.userInteraction();
	}
}