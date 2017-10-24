package is.ru.hugb.ttt;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BusinessTest{
	@Test
	public void testInitializeBoard() {
    	char[][] board = Business.initializeBoard();

		int cellCounter = 49;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				assertEquals((char)cellCounter, board[i][j]);
				cellCounter++;
			}
		}
	}

		@Test
		public void testConvertXtoY(){
			int[] array = Business.convertToXY(9);
			int[] array2 = Business.convertToXY(1);

			assertEquals(2, array[0]);
			assertEquals(2, array[1]);
			assertEquals(0, array2[0]);
			assertEquals(0, array2[1]);
		}

		@Test
		public void testCheckIfOccupied(){
			char[][] board = Business.initializeBoard();
			board[0][0] = 'X';
			board[2][2] = 'O';

			assertEquals(true, Business.checkIfOccupied(board, 0, 0));
			assertEquals(true, Business.checkIfOccupied(board, 2, 2));
			assertEquals(false, Business.checkIfOccupied(board, 1, 2));
		}


}
