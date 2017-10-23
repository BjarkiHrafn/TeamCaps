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
}