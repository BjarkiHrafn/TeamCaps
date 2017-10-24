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
		board = business.initializeBoard();
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
		char player = business.playerXorO(playerCounter);
		playerCounter ++;

		System.out.println("Player " + player + ": ");
		
		System.out.print("Input: ");
		int userInput = read.nextInt();
		read.close();
		System.out.println();
		
	}
	
	public static  void main(String[] args){  
		printBoard();
		userInteraction();
    Interface test = new Interface();
		test.printBoard();
	}
}