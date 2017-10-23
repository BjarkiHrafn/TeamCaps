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
}