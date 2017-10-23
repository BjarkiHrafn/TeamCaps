package is.ru.hugb.ttt;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;

public class Interface{
	
	private Business business;
	private char[][] board;
	
	public Interface(){
		business = new Business();
		board = business.initializeBoard();
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
	
	public static  void main(String[] args){
		Scanner in = new Scanner(System.in);
        
		printBoard();
	}
}