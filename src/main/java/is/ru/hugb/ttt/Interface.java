package is.ru.hugb.ttt;

import java.util.Hashtable;
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
		
		
		
	}
	
	public static  void main(String[] args){
		Scanner in = new Scanner(System.in);
        
		printBoard();
	}
}