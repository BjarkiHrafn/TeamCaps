package is.ru.hugb.ttt;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BusinessTest {
  @Test
  public void testInitializeBoard() {
    char[][] board = Business.initializeBoard();

    int cellCounter = 49;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        assertEquals((char) cellCounter, board[i][j]);
        cellCounter++;
      }
    }
  }

  @Test
  public void testConvertXtoY() {
    int[] array = Business.convertToXY(9);
    int[] array2 = Business.convertToXY(1);

    assertEquals(2, array[0]);
    assertEquals(2, array[1]);
    assertEquals(0, array2[0]);
    assertEquals(0, array2[1]);
  }

  @Test
  public void testCheckIfOccupied() {
    char[][] board = Business.initializeBoard();
    board[0][0] = 'X';
    board[2][2] = 'O';

    assertEquals(true, Business.checkIfOccupied(board, 1));
    assertEquals(true, Business.checkIfOccupied(board, 9));
    assertEquals(false, Business.checkIfOccupied(board, 3));
  }

  @Test
  public void testCheckIfInRange() {

    for (int i = 1; i < 10; i++) {
      assertEquals(true, Business.checkIfInRange(i));
    }

    assertEquals(false, Business.checkIfInRange(10));
    assertEquals(false, Business.checkIfInRange(-1));
  }

  @Test
  public void testIsGameWonCrosses() {
    char[][] board = Business.initializeBoard();
    board[0][0] = 'X';
    board[1][1] = 'X';
    board[2][2] = 'X';
    assertEquals(true, Business.isGameWon(board));

    board = Business.initializeBoard();
    board[0][2] = 'O';
    board[1][1] = 'O';
    board[2][0] = 'O';
    assertEquals(true, Business.isGameWon(board));
  }

  @Test
  public void testIsGameWonLinesHorizontal() {
    char[][] board = Business.initializeBoard();
    for (int i = 0; i < 3; i++) {
      board = Business.initializeBoard();
      board[0][i] = 'X';
      board[1][i] = 'X';
      board[2][i] = 'X';
      assertEquals(true, Business.isGameWon(board));
    }
  }

  @Test
  public void testIsGameWonLinesVertical() {
    char[][] board = Business.initializeBoard();
    for (int i = 0; i < 3; i++) {
      board = Business.initializeBoard();
      board[i][0] = 'O';
      board[i][1] = 'O';
      board[i][2] = 'O';
      assertEquals(true, Business.isGameWon(board));
    }
  }

  @Test
  public void testIsGameWonVerticalFail() {
    char[][] board = Business.initializeBoard();
    for (int i = 0; i < 3; i++) {
      board = Business.initializeBoard();
      board[i][0] = 'O';
      board[i][1] = 'O';
      board[i][2] = 'X';
      assertEquals(false, Business.isGameWon(board));
    }
  }

  @Test
  public void testBoardUpdate() {
    Business b = new Business();

    b.updateBoard('X', 9);

    assertEquals('X', b.board[2][2]);
  }

  @Test
  public void testBoardToString() {
	char[][] board = Business.initializeBoard();
	String boardString = Business.boardToString(board);

	assertEquals("123456789", boardString);
  }
}
