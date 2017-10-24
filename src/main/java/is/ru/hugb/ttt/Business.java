package is.ru.hugb.ttt;

public class Business{

	public static char[][] initializeBoard(){
		char board[][] = new char[3][3];

		int cellCounter = 49;

		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				board[i][j] = (char)cellCounter;
				cellCounter++;
			}
		}
		return board;
	}

	public static int[] convertToXY(int input){
		int x;
		int y;
		input = input - 1;
	    y = input % 3;
		x = input / 3;

		int[] arr = {x, y};
		return arr;
	}

	public static boolean checkIfOccupied(char[][] board, int x, int y){
		if(board[x][y] == 'X' || board[x][y] == 'O'){
			return true;
		}
		return false;
	}

	public static boolean checkIfInRange(int input){
			if(input > 9 || input < 1){
					return false;
			}

			return true;
	}
}
